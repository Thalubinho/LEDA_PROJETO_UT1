import java.io.File;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import org.apache.commons.csv.*;

public class CSVReader {
	private static final String RELATIVE_PATH_CSV = "games.csv"; // File class to avoid OS conflicts 
	
	public static void main(String[] args) {
		try(Reader reader = Files.newBufferedReader(Paths.get(RELATIVE_PATH_CSV));
			CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)) {
			
			int lines = 0;
			for(CSVRecord csvRecord: csvParser) { // Each record is one line
				
				lines++;
				String id = csvRecord.get(0);     // Each column is a .get(index)
				String name = csvRecord.get(1);	 				
 				String date = csvRecord.get(2);  
 				
 				// Formating "Release Date"
 				date = date.replace(' ', '/').replace(",",""); 
 				String[] dateFormated = date.split("/");
 				date = dateArrayToString(formatDate(dateFormated));
 				
				System.out.println("line: "+ lines + " id: " + id + " name: " + name + " date: " + date);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
	
	public static String[] formatDate(String[] date) { // "MM/DD/AAAA" to "DD/MM/AAAA"
		String aux;
		aux = date[0];
		date[0] = date[1];
		date[1] = aux;
		
		return date;
	}
	
	public static String dateArrayToString(String[] date) {
		StringBuilder result = new StringBuilder();
		
		for(int i = 0; i < date.length; i++) {
			
			result.append(date[i]);
			if(i != date.length-1) {
				result.append("/");
			}
		}
		
		return result.toString();
	}
	
}
