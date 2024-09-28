package algorithms;

import csv_io.RecordsCSV;
import org.apache.commons.csv.CSVRecord;

public class InsertionSort {
	
	public static void insertionSort(CSVRecord[] array){
		
	      for(int indexUnsorted = 1; indexUnsorted < array.length; indexUnsorted++){ //Considera o primeiro elemento como ordenado
	        int indexSorted = indexUnsorted - 1;
	        CSVRecord unsortedElement = array[indexUnsorted];
	        CSVRecord sortedElement = array[indexSorted];
	        while(indexSorted >= 0 && RecordsCSV.compareReleaseDate(array[indexSorted].get(2), unsortedElement.get(2))){
	            array[indexSorted+1] = array[indexSorted];
	            array[indexSorted] = unsortedElement;
	            indexSorted--;
	            System.out.println();
	        }
	        System.out.println();
	      }
	  }
}
