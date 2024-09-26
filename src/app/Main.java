package app;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
	public static void main(String[] args) {
		// creating folders "transformations" and "ordinations"
		Path path_transformations = Paths.get("transformations");
		Path path_ordinations = Paths.get("ordinations");
		try {
			Files.createDirectory(path_transformations);
			Files.createDirectory(path_ordinations);
		} catch (FileAlreadyExistsException e) {
			e.printStackTrace();
			System.err.println("O(s) diretorio(s) 'transformations' e/ou 'ordinations' ja existe");
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Erro ao criar o(s) diretorio(s)");
		}
		
		Transformations.transformation1();
	}
}
