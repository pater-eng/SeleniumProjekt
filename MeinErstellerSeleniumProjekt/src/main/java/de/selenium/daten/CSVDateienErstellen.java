package de.selenium.daten;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CSVDateienErstellen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			writeTestDataToCsv();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	private static void writeTestDataToCsv() throws IOException {
		// Verzeichnis, in dem die CSV-Datei gespeichert werden soll
		String folderPath = "C:/Users/engoulou/Selenium/Daten/";
		// Sicherstellen, dass das Verzeichnis existiert; ansonsten anlegen
		Path directory = Paths.get(folderPath);
		if (!Files.exists(directory)) {
			Files.createDirectories(directory);
		}

		// Dateiname festlegen
		Path csvFilePath = Paths.get(folderPath, "testdaten_2.csv");

		// Testdaten
		Object[][] daten = {
				{ "Test Form 1 Test 1 Chrome", "chrome", "selenium102", "codingsolo", "Parametrisierter Test 1", "Dodo",
					"Java Grundlagen Kurs mit Dieter", "2,5,6", "1,2", "Java Grundlagen Kurs", "Magazzini Alimentari Riuniti" },
				{ "Test Form 1 Test 2 Chrome", "chrome", "selenium102", "codingsolo", "Parametrisierter Test 2", "Mama",
						"Python Grundlagen Kurs mit Dieter", "1,4,6", "1,5", "Python Grundlagen Kurs", "Magazzini Alimentari Riuniti" },
				{ "Test Form 1 Test 2 FireFox", "fireFox", "selenium102", "codingsolo", "Parametrisierter Test 2", "Miyam",
							"Python Grundlagen Kurs mit Dieter", "2,4,6", "2,4", "Python Grundlagen Kurs", "Magazzini Alimentari Riuniti" },
				{ "Test Form 1 Test 2 IE", "ie", "selenium102", "codingsolo", "Parametrisierter Test 2", "Clea",
								"Python Grundlagen Kurs mit Dieter", "2,4,6", "1,3", "Python Grundlagen Kurs", "Magazzini Alimentari Riuniti" }
		};

		try (BufferedWriter writer = Files.newBufferedWriter(csvFilePath)) {
			// Schreibe optional einen Header
			writer.write("testName;browsername;username;password;betreff;name;kursTitel;firmenBox1;firmenBox2;assert1;assert2");
			writer.newLine();
			for (Object[] row : daten) {
				StringBuilder line = new StringBuilder();
				for (int i = 0; i < row.length; i++) {
					line.append(row[i].toString());
					if (i < row.length - 1) {
						line.append(";");
					}
				}
				writer.write(line.toString());
				writer.newLine();
			}
		}
		System.out.println("CSV-Datei wurde unter " + csvFilePath.toString() + " erstellt.");
	}

}
