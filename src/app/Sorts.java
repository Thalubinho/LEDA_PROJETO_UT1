package app;

import algorithms.MergeSortRecordArray;
import csv_io.RecordsCSV;
import org.apache.commons.csv.CSVRecord;

import java.util.Arrays;

public class Sorts {

    public static void mergeSortByReleaseDate(String filenameCSV) {
        // Initializing variable
        RecordsCSV recordsCSV = new RecordsCSV("transformations", filenameCSV);

		double initialMemory, finalMemory, initialTime, finalTime;
		double consumedMemory, durationTime;
		Runtime runtime = Runtime.getRuntime();

		// Cleaning Garbage Collector
		System.gc();

		// Measuring execution time and consumed memory
		initialTime = System.nanoTime();
		initialMemory = runtime.totalMemory() - runtime.freeMemory();

        MergeSortRecordArray.sort(recordsCSV.getRecords(),0,recordsCSV.getRecords().length-1);

		finalMemory = runtime.totalMemory() - runtime.freeMemory();
		finalTime = System.nanoTime();

        //Final
		durationTime = (finalTime - initialTime) / 1_000_000;
		consumedMemory = ((finalMemory - initialMemory) / (1_024 * 1_024));

		System.out.printf("Duration: %.4f ms%n" + "Consumed Memory: %.4f mb%n", durationTime, consumedMemory);

        recordsCSV.copyCSV("sorts","games_release_date_mergeSort_medioCaso.csv");
    }

    public static void main(String[] args) {
        mergeSortByReleaseDate("games_formated_release_data.csv");
    }

}
