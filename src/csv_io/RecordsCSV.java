package csv_io;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class RecordsCSV{
    private CSVRecord[] records;

    public CSVRecord[] getRecords() {
        return records;
    }

    public RecordsCSV(String folder, String filenameCSV) { // games_formated_release_data.csv
        CSVReader fileCSV = new CSVReader(folder, filenameCSV);
        try(Reader reader = Files.newBufferedReader(Paths.get(fileCSV.getPath()));
            CSVParser csvParser = CSVFormat.Builder.create()
                                  .setHeader()				 // The first line is set as Header
                                  .build()
                                  .parse(reader)) {

            this.records = csvParser.getRecords().toArray(new CSVRecord[0]);

        } catch (IOException e) {
            e.printStackTrace();
            System.err.printf("Error when reading %s", filenameCSV);
        }
    }

    /**
     * @param date1
     * @param date2
     * @return true if date1 is greater than date2
     */
    public static boolean compareReleaseDate(String date1 , String date2) { // DD/MM/AAAA
        boolean result = false;
        String[] date1Array = date1.split("/");
        String[] dates2Array = date2.split("/");

        // Handle exceptions later

        // Compare year
        if(Integer.parseInt(date1Array[2]) > Integer.parseInt(dates2Array[2])) {
            result = true;
        } else if (Integer.parseInt(date1Array[2]) == Integer.parseInt(dates2Array[2])) {

            // Compare month
            if(Integer.parseInt(date1Array[1]) > Integer.parseInt(dates2Array[1])) {
                result = true;
            } else if (Integer.parseInt(date1Array[1]) == Integer.parseInt(dates2Array[1])) {

                // Compare Day
                if(Integer.parseInt(date1Array[0]) > Integer.parseInt(dates2Array[0])) {
                    result = true;
                }
            }
        }

        return result;
    }

    public void copyCSV(String folderNewCSV,String filenameNewCSV){
        CSVWriter newCSV = new CSVWriter(folderNewCSV,filenameNewCSV);

        try(BufferedWriter writer = Files.newBufferedWriter(Paths.get(newCSV.getPath()));
            CSVPrinter csvPrinter = new CSVPrinter(writer,
                                    CSVFormat.Builder.create()
                                    .setHeader(getHeadersFromEnum())
                                    .build())) {

            for (CSVRecord record : this.records) {
                csvPrinter.printRecord(record);
            }

            } catch (IOException e) {
            e.printStackTrace(System.err);
            System.err.println("Erro ao ler 'games.csv' e/ou ao criar 'games_formated_release_data.csv'");
        }
    }

    private static String[] getHeadersFromEnum() {
        HeaderGamesCSV[] headersEnum = HeaderGamesCSV.values();
        String[] headers = new String[headersEnum.length];

        for (int i = 0; i < headersEnum.length; i++) {
            headers[i] = headersEnum[i].name();
        }

        return headers;
    }

    public static void main(String[] args) {
        RecordsCSV gamesFormatedCSV = new RecordsCSV("transformations", "games_formated_release_data.csv");
        String path = "dates_tests";

        // Create a empty file
        try {
            Files.writeString(Paths.get(path), "");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Test dates comparisons
        for(int i = 0; i < gamesFormatedCSV.records.length-1; i++){
            String recordDate1 = gamesFormatedCSV.records[i].get(2);
            String recordDate2 = gamesFormatedCSV.records[i+1].get(2);
            try {
                Files.writeString(Paths.get(path), "%s > %s, %b%n".formatted(recordDate1, recordDate2, compareReleaseDate(recordDate1, recordDate2)), StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
