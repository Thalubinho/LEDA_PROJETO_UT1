package app;

import algorithms.*;
import csv_io.RecordsCSV;
import org.apache.commons.csv.CSVRecord;

import java.util.Arrays;

public class Sorts {

    public static void mergeSortByReleaseDateAverageCase(String filenameCSV) {
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

		System.out.printf(" %.2f; %.2f;  ", durationTime, consumedMemory);

        recordsCSV.copyCSV("sorts","games_release_date_mergeSort_medioCaso.csv");
    }

	public static void mergeSortByReleaseDateBestCase(String filenameCSV) {
        // Initializing variables
        RecordsCSV recordsCSV = new RecordsCSV("sorts", filenameCSV); //games_release_date_mergeSort_medioCaso

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

		System.out.printf(" %.2f; %.2f;  ", durationTime, consumedMemory);

        recordsCSV.copyCSV("sorts","games_release_date_mergeSort_melhorCaso.csv");
    }

	public static void mergeSortByReleaseDateWorstCase(String filenameCSV) {
        // Initializing variables
        RecordsCSV recordsCSV = new RecordsCSV("transformations", filenameCSV); //games_release_date_mergeSort_melhorCaso
		double initialMemory, finalMemory, initialTime, finalTime;
		double consumedMemory, durationTime;
		Runtime runtime = Runtime.getRuntime();

		// Descending sort
		MergeSortRecordArrayDescending.sort(recordsCSV.getRecords(),0,recordsCSV.getRecords().length-1);

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

		System.out.printf(" %.2f; %.2f;  ", durationTime, consumedMemory);

        recordsCSV.copyCSV("sorts","games_release_date_mergeSort_piorCaso.csv");
    }


    public static void heapSortByReleaseDateAverageCase(String filenameCSV) {
        // Initializing variable
        RecordsCSV recordsCSV = new RecordsCSV("transformations", filenameCSV); //games_release_date.csv

		double initialMemory, finalMemory, initialTime, finalTime;
		double consumedMemory, durationTime;
		Runtime runtime = Runtime.getRuntime();

		// Cleaning Garbage Collector
		System.gc();

		// Measuring execution time and consumed memory
		initialTime = System.nanoTime();
		initialMemory = runtime.totalMemory() - runtime.freeMemory();

        HeapSort.heapSort(recordsCSV.getRecords());

		finalMemory = runtime.totalMemory() - runtime.freeMemory();
		finalTime = System.nanoTime();

        //Final
		durationTime = (finalTime - initialTime) / 1_000_000;
		consumedMemory = ((finalMemory - initialMemory) / (1_024 * 1_024));

		System.out.printf(" %.2f; %.2f;  ", durationTime, consumedMemory);

        recordsCSV.copyCSV("sorts","games_release_date_heapSort_medioCaso.csv");
    }

	public static void heapSortByReleaseDateBestCase(String filenameCSV) {
        // Initializing variables
        RecordsCSV recordsCSV = new RecordsCSV("sorts", filenameCSV); //games_release_date_heapSort_medioCaso

		double initialMemory, finalMemory, initialTime, finalTime;
		double consumedMemory, durationTime;
		Runtime runtime = Runtime.getRuntime();

		// Cleaning Garbage Collector
		System.gc();

		// Measuring execution time and consumed memory
		initialTime = System.nanoTime();
		initialMemory = runtime.totalMemory() - runtime.freeMemory();

        HeapSort.heapSort(recordsCSV.getRecords());

		finalMemory = runtime.totalMemory() - runtime.freeMemory();
		finalTime = System.nanoTime();

        //Final
		durationTime = (finalTime - initialTime) / 1_000_000;
		consumedMemory = ((finalMemory - initialMemory) / (1_024 * 1_024));

		System.out.printf(" %.2f; %.2f;  ", durationTime, consumedMemory);

        recordsCSV.copyCSV("sorts","games_release_date_heapSort_melhorCaso.csv");
    }

	public static void heapSortByReleaseDateWorstCase(String filenameCSV) {
        // Initializing variables
        RecordsCSV recordsCSV = new RecordsCSV("transformations", filenameCSV); //games_release_date_heapSort_melhorCaso
		double initialMemory, finalMemory, initialTime, finalTime;
		double consumedMemory, durationTime;
		Runtime runtime = Runtime.getRuntime();

		// Descending sort
		MergeSortRecordArrayDescending.sort(recordsCSV.getRecords(),0,recordsCSV.getRecords().length-1);

		// Cleaning Garbage Collector
		System.gc();

		// Measuring execution time and consumed memory
		initialTime = System.nanoTime();
		initialMemory = runtime.totalMemory() - runtime.freeMemory();

        HeapSort.heapSort(recordsCSV.getRecords());

		finalMemory = runtime.totalMemory() - runtime.freeMemory();
		finalTime = System.nanoTime();

        //Final
		durationTime = (finalTime - initialTime) / 1_000_000;
		consumedMemory = ((finalMemory - initialMemory) / (1_024 * 1_024));

		System.out.printf(" %2f; %.2f;  ", durationTime, consumedMemory);

        recordsCSV.copyCSV("sorts","games_release_date_heapSort_piorCaso.csv");
    }


	public static void quickSortHoareByReleaseDateAverageCase(String filenameCSV) {
        // Initializing variable
        RecordsCSV recordsCSV = new RecordsCSV("transformations", filenameCSV); //games_release_date.csv

		double initialMemory, finalMemory, initialTime, finalTime;
		double consumedMemory, durationTime;
		Runtime runtime = Runtime.getRuntime();

		// Cleaning Garbage Collector
		System.gc();

		// Measuring execution time and consumed memory
		initialTime = System.nanoTime();
		initialMemory = runtime.totalMemory() - runtime.freeMemory();

        QuickSort.quickSort(recordsCSV.getRecords(), 0, recordsCSV.getRecords().length-1);

		finalMemory = runtime.totalMemory() - runtime.freeMemory();
		finalTime = System.nanoTime();

        //Final
		durationTime = (finalTime - initialTime) / 1_000_000;
		consumedMemory = ((finalMemory - initialMemory) / (1_024 * 1_024));

		System.out.printf(" %.2f; %.2f;  ", durationTime, consumedMemory);

        recordsCSV.copyCSV("sorts","games_release_date_quickSortHoare_medioCaso.csv");
    }

	public static void quickSortHoareByReleaseDateBestCase(String filenameCSV) {
        // Initializing variables
        RecordsCSV recordsCSV = new RecordsCSV("sorts", filenameCSV); //games_release_date_quickSortHoare_medioCaso

		double initialMemory, finalMemory, initialTime, finalTime;
		double consumedMemory, durationTime;
		Runtime runtime = Runtime.getRuntime();

		// Cleaning Garbage Collector
		System.gc();

		// Measuring execution time and consumed memory
		initialTime = System.nanoTime();
		initialMemory = runtime.totalMemory() - runtime.freeMemory();

        QuickSort.quickSort(recordsCSV.getRecords(), 0, recordsCSV.getRecords().length-1);

		finalMemory = runtime.totalMemory() - runtime.freeMemory();
		finalTime = System.nanoTime();

        //Final
		durationTime = (finalTime - initialTime) / 1_000_000;
		consumedMemory = ((finalMemory - initialMemory) / (1_024 * 1_024));

		System.out.printf(" %.2f; %.2f;  ", durationTime, consumedMemory);

        recordsCSV.copyCSV("sorts","games_release_date_quickSortHoare_melhorCaso.csv");
    }

	public static void quickSortHoareByReleaseDateWorstCase(String filenameCSV) {
        // Initializing variables
        RecordsCSV recordsCSV = new RecordsCSV("transformations", filenameCSV); //games_release_date_quickSortHoare_melhorCaso
		double initialMemory, finalMemory, initialTime, finalTime;
		double consumedMemory, durationTime;
		Runtime runtime = Runtime.getRuntime();

		// Descending sort
		MergeSortRecordArrayDescending.sort(recordsCSV.getRecords(),0,recordsCSV.getRecords().length-1);

		// Cleaning Garbage Collector
		System.gc();

		// Measuring execution time and consumed memory
		initialTime = System.nanoTime();
		initialMemory = runtime.totalMemory() - runtime.freeMemory();

        QuickSort.quickSort(recordsCSV.getRecords(), 0, recordsCSV.getRecords().length-1);

		finalMemory = runtime.totalMemory() - runtime.freeMemory();
		finalTime = System.nanoTime();

        //Final
		durationTime = (finalTime - initialTime) / 1_000_000;
		consumedMemory = ((finalMemory - initialMemory) / (1_024 * 1_024));

		System.out.printf(" %2f; %.2f;  ", durationTime, consumedMemory);

        recordsCSV.copyCSV("sorts","games_release_date_quickSortHoare_piorCaso.csv");
    }


	public static void insertionSortByReleaseDateAverageCase(String filenameCSV) {
			// Initializing variable
			RecordsCSV recordsCSV = new RecordsCSV("transformations", filenameCSV); //games_release_date.csv

			double initialMemory, finalMemory, initialTime, finalTime;
			double consumedMemory, durationTime;
			Runtime runtime = Runtime.getRuntime();

			// Cleaning Garbage Collector
			System.gc();

			// Measuring execution time and consumed memory
			initialTime = System.nanoTime();
			initialMemory = runtime.totalMemory() - runtime.freeMemory();

			InsertionSort.insertionSort(recordsCSV.getRecords());

			finalMemory = runtime.totalMemory() - runtime.freeMemory();
			finalTime = System.nanoTime();

			//Final
			durationTime = (finalTime - initialTime) / 1_000_000;
			consumedMemory = ((finalMemory - initialMemory) / (1_024 * 1_024));

			System.out.printf(" %.2f; %.2f;  ", durationTime, consumedMemory);

			recordsCSV.copyCSV("sorts","games_release_date_insertioSort_medioCaso.csv");
		}

	public static void insertionSortByReleaseDateBestCase(String filenameCSV) {
			// Initializing variables
			RecordsCSV recordsCSV = new RecordsCSV("sorts", filenameCSV); //games_release_date_insertioSort_medioCaso

			double initialMemory, finalMemory, initialTime, finalTime;
			double consumedMemory, durationTime;
			Runtime runtime = Runtime.getRuntime();

			// Cleaning Garbage Collector
			System.gc();

			// Measuring execution time and consumed memory
			initialTime = System.nanoTime();
			initialMemory = runtime.totalMemory() - runtime.freeMemory();

			InsertionSort.insertionSort(recordsCSV.getRecords());

			finalMemory = runtime.totalMemory() - runtime.freeMemory();
			finalTime = System.nanoTime();

			//Final
			durationTime = (finalTime - initialTime) / 1_000_000;
			consumedMemory = ((finalMemory - initialMemory) / (1_024 * 1_024));

			System.out.printf(" %.2f; %.2f;  ", durationTime, consumedMemory);

			recordsCSV.copyCSV("sorts","games_release_date_insertioSort_melhorCaso.csv");
		}

	public static void insertionSortByReleaseDateWorstCase(String filenameCSV) {
			// Initializing variables
			RecordsCSV recordsCSV = new RecordsCSV("transformations", filenameCSV); //games_release_date_insertioSort_melhorCaso
			double initialMemory, finalMemory, initialTime, finalTime;
			double consumedMemory, durationTime;
			Runtime runtime = Runtime.getRuntime();

			// Descending sort
			MergeSortRecordArrayDescending.sort(recordsCSV.getRecords(),0,recordsCSV.getRecords().length-1);

			// Cleaning Garbage Collector
			System.gc();

			// Measuring execution time and consumed memory
			initialTime = System.nanoTime();
			initialMemory = runtime.totalMemory() - runtime.freeMemory();

			InsertionSort.insertionSort(recordsCSV.getRecords());

			finalMemory = runtime.totalMemory() - runtime.freeMemory();
			finalTime = System.nanoTime();

			//Final
			durationTime = (finalTime - initialTime) / 1_000_000;
			consumedMemory = ((finalMemory - initialMemory) / (1_024 * 1_024));

			System.out.printf(" %2f; %.2f;  ", durationTime, consumedMemory);

			recordsCSV.copyCSV("sorts","games_release_date_insertioSort_piorCaso.csv");
		}


	public static void selectionSortByReleaseDateAverageCase(String filenameCSV) {
			// Initializing variable
			RecordsCSV recordsCSV = new RecordsCSV("transformations", filenameCSV); //games_release_date.csv

			double initialMemory, finalMemory, initialTime, finalTime;
			double consumedMemory, durationTime;
			Runtime runtime = Runtime.getRuntime();

			// Cleaning Garbage Collector
			System.gc();

			// Measuring execution time and consumed memory
			initialTime = System.nanoTime();
			initialMemory = runtime.totalMemory() - runtime.freeMemory();

			SelectionSort.selectionSort(recordsCSV.getRecords()););

			finalMemory = runtime.totalMemory() - runtime.freeMemory();
			finalTime = System.nanoTime();

			//Final
			durationTime = (finalTime - initialTime) / 1_000_000;
			consumedMemory = ((finalMemory - initialMemory) / (1_024 * 1_024));

			System.out.printf(" %.2f; %.2f;  ", durationTime, consumedMemory);

			recordsCSV.copyCSV("sorts","games_release_date_selectionSort_medioCaso.csv");
		}

	public static void selectionSortByReleaseDateBestCase(String filenameCSV) {
			// Initializing variables
			RecordsCSV recordsCSV = new RecordsCSV("sorts", filenameCSV); //games_release_date_selectionSort_medioCaso

			double initialMemory, finalMemory, initialTime, finalTime;
			double consumedMemory, durationTime;
			Runtime runtime = Runtime.getRuntime();

			// Cleaning Garbage Collector
			System.gc();

			// Measuring execution time and consumed memory
			initialTime = System.nanoTime();
			initialMemory = runtime.totalMemory() - runtime.freeMemory();

			SelectionSort.selectionSort(recordsCSV.getRecords()););

			finalMemory = runtime.totalMemory() - runtime.freeMemory();
			finalTime = System.nanoTime();

			//Final
			durationTime = (finalTime - initialTime) / 1_000_000;
			consumedMemory = ((finalMemory - initialMemory) / (1_024 * 1_024));

			System.out.printf(" %.2f; %.2f;  ", durationTime, consumedMemory);

			recordsCSV.copyCSV("sorts","games_release_date_selectionSort_melhorCaso.csv");
		}

	public static void selectionSortByReleaseDateWorstCase(String filenameCSV) {
			// Initializing variables
			RecordsCSV recordsCSV = new RecordsCSV("transformations", filenameCSV); //games_release_date_selectionSort_melhorCaso
			double initialMemory, finalMemory, initialTime, finalTime;
			double consumedMemory, durationTime;
			Runtime runtime = Runtime.getRuntime();

			// Descending sort
			MergeSortRecordArrayDescending.sort(recordsCSV.getRecords(),0,recordsCSV.getRecords().length-1);

			// Cleaning Garbage Collector
			System.gc();

			// Measuring execution time and consumed memory
			initialTime = System.nanoTime();
			initialMemory = runtime.totalMemory() - runtime.freeMemory();

			SelectionSort.selectionSort(recordsCSV.getRecords()););

			finalMemory = runtime.totalMemory() - runtime.freeMemory();
			finalTime = System.nanoTime();

			//Final
			durationTime = (finalTime - initialTime) / 1_000_000;
			consumedMemory = ((finalMemory - initialMemory) / (1_024 * 1_024));

			System.out.printf(" %2f; %.2f;  ", durationTime, consumedMemory);

			recordsCSV.copyCSV("sorts","games_release_date_selectionSort_piorCaso.csv");
		}

    public static void main(String[] args) {
		System.out.print("Merge Sort; Release Date;");
        mergeSortByReleaseDateAverageCase("games_formated_release_data.csv");
        mergeSortByReleaseDateBestCase("games_release_date_mergeSort_medioCaso.csv");
		mergeSortByReleaseDateWorstCase("games_formated_release_data.csv");

		System.out.print("Heap Sort; Release Date;");
		heapSortByReleaseDateAverageCase("games_formated_release_data.csv");
		heapSortByReleaseDateBestCase("games_release_date_heapSort_medioCaso.csv");
		heapSortByReleaseDateWorstCase("games_formated_release_data.csv");

		System.out.print("Insetion Sort; Release Date;");
		insertionSortByReleaseDateAverageCase("games_formated_release_data.csv");
		insertionSortByReleaseDateBestCase("games_release_date_insertionSort_medioCaso.csv");
		insertionSortByReleaseDateWorstCase("games_formated_release_data.csv");

		System.out.print("Selection Sort; Release Date;");
		insertionSortByReleaseDateAverageCase("games_formated_release_data.csv");
		insertionSortByReleaseDateBestCase("games_release_date_selectionSort_medioCaso.csv");
		insertionSortByReleaseDateWorstCase("games_formated_release_data.csv");

    }

}
