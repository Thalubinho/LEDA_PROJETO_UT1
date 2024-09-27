package app;

import csv_io.RecordsCSV;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
	public static void main(String[] args) {
		// Creating folders "transformations" and "ordinations"
		Path path_transformations = Paths.get("transformations");
		Path path_ordinations = Paths.get("sorts");
		try {
			Files.createDirectory(path_transformations);
			Files.createDirectory(path_ordinations);
		} catch (FileAlreadyExistsException e) {
			e.printStackTrace();
			System.err.println("The folder(s) 'transformations' and/or 'sorts' already exist");
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Error creating folders");
		}

		Transformations.transformation1();

//		// Initializing variable
//		double inicialMemory, finalMemory, inicialTime, finalTime;
//		double consumedMemory, durationTime;
//		Runtime runtime = Runtime.getRuntime();
//
//		// Cleaning Garbage Collector
//		System.gc();
//
//		// Measuring execution time and consumed memory
//		inicialTime = System.nanoTime();
//		inicialMemory = runtime.totalMemory() - runtime.freeMemory();
//
//		finalMemory = runtime.totalMemory() - runtime.freeMemory();
//		finalTime = System.nanoTime();
//		Transformations.transformation1();
//		durationTime = (finalTime - inicialTime) / 1_000_000;
//		consumedMemory = ((finalMemory - inicialMemory) / (1_024 * 1_024));
//
//		System.out.printf("Duration: %.4f ms%n" + "Consumed Memory: %.4f mb%n", durationTime, consumedMemory);

	}
}
