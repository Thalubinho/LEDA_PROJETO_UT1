package algorithms;

import csv_io.RecordsCSV;
import org.apache.commons.csv.CSVRecord;

public class SelectionSort {
	public static void selectionSort(CSVRecord[] array) {
		int minorIndex;
		CSVRecord minor;

		for(int unsortedIndex = 0; unsortedIndex < array.length - 1; unsortedIndex++) {
			minor = array[unsortedIndex];
			minorIndex = unsortedIndex;
			for(int index = unsortedIndex; index < array.length; index++) {
				if (!RecordsCSV.compareReleaseDate(minor.get(2),array[index].get(2))) {
					minor = array[index];
					minorIndex = index;
				}				
			}			
			array[minorIndex] = array[unsortedIndex];
			array[unsortedIndex] = minor;		
		}
	}
}
