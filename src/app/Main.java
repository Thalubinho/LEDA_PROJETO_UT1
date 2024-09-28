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
		Transformations.filtrationLinux();




	}
}
