package app;

import java.io.BufferedWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVFormat.Builder;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import csv_io.CSVReader;
import csv_io.CSVWriter;

public class Transformations {
	
	public static void transformation1() {
		CSVReader gamesCSV = new CSVReader("games.csv");
		CSVWriter transformedGamesCSV = new CSVWriter("games_formated_release_data.csv");
		
		try(Reader reader = Files.newBufferedReader(Paths.get(gamesCSV.getPath()));
			CSVParser csvParser = CSVFormat.Builder.create()
                       			  .setHeader()				 // The first line is set as Header
                       			  .build()
                       			  .parse(reader);
					
			BufferedWriter writer = Files.newBufferedWriter(Paths.get(transformedGamesCSV.getPath()));
			CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.Builder.create()
                    					.setHeader(csvParser.getHeaderMap().keySet().toArray(new String[0]))
                    					.build())) {
			
			int line = 0;
			for(CSVRecord record: csvParser) { // Each record is one line 
				//for(int count = 0; count<999_999_999; count++) {}
				
				String id = record.get(0);     // Each column is a .get(index)
				String name = record.get(1);	 				
 				String date = record.get(2);  
 				
 				// Formating "Release Date"
 				date = date.replace(' ', '/').replace(",",""); 
 				String[] dateFormated = date.split("/");
 				date = convertArrayToString(formatDate(dateFormated));
 				
 				//Cloning "games.csv" and changing "Release Date"
 				int numColumns = record.size();
 				String[] row = new String[numColumns];
 				
 				for(int column = 0; column < numColumns; column++) {
 					if(column == 2) { // "Release Date" column
 						row[column] = date;
 					} else {
 						row[column] = record.get(column);
 					}
 				}
 				
 				// Creating "games_formated_release_data.csv"
 				csvPrinter.printRecord((Object[]) row);
 				System.out.println(Arrays.toString(row));
 				//System.out.println("line: "+ line + "| id: " + id + "| name: " + name + "| date: " + row[2]);
 				line++;
			}
			
		} catch (Exception e) {
			e.printStackTrace(System.out);
			System.err.println("Erro ao ler 'games.csv' e/ou ao criar 'games_formated_release_data.csv'");
		}
	}
	
	public static String[] formatDate(String[] date) { 
		changeDayWithMonth(date);
		convertNameMonthToNum(date);
		convertDayToTwoDigits(date);
		
		return date;
	}

	private static void changeDayWithMonth(String[] date) { // "MM/DD/AAAA" -> "DD/MM/AAAA"
		String aux;
		aux = date[0];
		date[0] = date[1];
		date[1] = aux;
	}
	
	public static String convertArrayToString(String[] date) { // ["DD", "MM", "AAAA"] to "DD/MM/AAAA"
		StringBuilder result = new StringBuilder();
		
		for(int i = 0; i < date.length; i++) {
			
			result.append(date[i]);
			if(i != date.length-1) {
				result.append("/");
			}
		}
		
		return result.toString();
	}
	
	public static void convertNameMonthToNum(String[] date) { //  ["DD", "MM(name)", "AAAA"] -> ["DD", "MM(number)", "AAAA"]
		Map<String, String> months = new HashMap<String,String>(); // Extract this
		months.put("Jan", "01");
		months.put("Feb", "02");
		months.put("Mar", "03");
		months.put("Apr", "04");
		months.put("May", "05");
		months.put("Jun", "06");
		months.put("Jul", "07");
		months.put("Aug", "08");
		months.put("Sep", "09");
		months.put("Oct", "10");
		months.put("Nov", "11");
		months.put("Dec", "12");
		
		date[1] = months.get(date[1]); 
	}
	
	public static void convertDayToTwoDigits(String[] date) { // ["D", "MM", "AAAA"] -> ["DD", "MM", "AAAA"]
		if(date[0].length() == 1) {
			date[0] = "0"+date[0];
		}
	}

}
