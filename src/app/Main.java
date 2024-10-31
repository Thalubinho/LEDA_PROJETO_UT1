package app;

import csv_io.RecordsCSV;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
	public static void main(String[] args) {
		// Creating folders "transformations" and "sorts"
		Path path_transformations = Paths.get("transformations");
		Path path_ordinations = Paths.get("sorts");
		try {
			Files.createDirectory(path_transformations);
			Files.createDirectory(path_ordinations);
		} catch (FileAlreadyExistsException e) {
			System.err.println("The folder(s) 'transformations' and/or 'sorts' already exist");
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Error creating folders");
		}

		Transformations.transformationReleaseDate();
		Transformations.transformationLinux();
		Transformations.transformationPortuguese();

		// Sorts
		Sorts.mergeSortByReleaseDateAverageCase("games_formated_release_date.csv");
		Sorts.mergeSortByReleaseDateBestCase("games_release_date_mergeSort_medioCaso.csv");
		Sorts.mergeSortByReleaseDateWorstCase("games_formated_release_date.csv");

		Sorts.heapSortByReleaseDateAverageCase("games_formated_release_date.csv");
		Sorts.heapSortByReleaseDateBestCase("games_release_date_heapSort_medioCaso.csv");
		Sorts.heapSortByReleaseDateWorstCase("games_formated_release_date.csv");

	}
}
