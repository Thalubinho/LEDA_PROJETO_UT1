import java.io.File;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.csv.*;

public class CSVReader {
	private static final String RELATIVE_PATH_CSV = "./games.csv"; // File class to avoid OS conflicts 
	
	public static void main(String[] args) {
		try(Reader reader = Files.newBufferedReader(Paths.get(RELATIVE_PATH_CSV));
			CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)) {
			
			int lines = 0;
			for(CSVRecord csvRecord: csvParser) { // Each record is one line
				lines++;
				String id = csvRecord.get(0);
				String name = csvRecord.get(1);
 				String date = csvRecord.get(2);                // Release Date is a index 2 column  
 				date = date.replace(' ', '/').replace(",",""); // Formating date
 				String[] dateFormated = date.split(date);
				System.out.println("line: "+ lines + " " + id + " " + name + " :" + date);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static String[] formatDate(String[] date) { // "MM/DD/AAAA" to "DD/MM/AAAA"
		String result, aux;
		aux = date[0];
		date[0] = date[1];
		date[1] = aux;
		
		return date;
	}
	
}
