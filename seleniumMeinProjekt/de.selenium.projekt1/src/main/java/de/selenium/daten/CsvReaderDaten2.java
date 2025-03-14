package de.selenium.daten;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class CsvReaderDaten2 {
	public static void main(String[] args) {
		getVerzeichnis();

	}
	
	public static String getVerzeichnis() {
		// Pfad zum Verzeichnis, in dem die CSV-Dateien liegen
		String folderPath = "C:/Users/engoulou/Selenium/Daten/";
		System.out.println("Directory: "+folderPath);


		try {
			// Listen alle Dateien mit Endung.csv aus dem Verzeichnis
			Files.list(Paths.get(folderPath))
			.filter(path -> path.toString().endsWith(".csv")) 
			.forEach(CsvReaderDaten2::readCsvFile);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return folderPath;
	}
	

	
	public static List<Object[]> readCsvFile(Path filePath) {
		List<Object[]> collection = new ArrayList<>();
		
		System.out.println("Auslesen der Datei : " + filePath.getFileName());
		System.out.println(" Existenz prüfen : " + filePath.getNameCount());
		List<Form1ParameterizedSeleniumKursChrome> forme1Liste = new ArrayList<>();

		try (CSVReader reader = new CSVReader(new FileReader(filePath.toFile()))) {
			// Überspringe die erste Zeile (z.B. den Header)
			reader.readNext();
			reader.getParser().parseLine(";");
			String[] nextLine;
			while ((nextLine = reader.readNext()) != null) {
				System.out.println(Arrays.toString(nextLine)); // Jeder Zeile ausgeben
				// Iteriere über die Collection und füge Form1ParameterizedSeleniumKursChrome zu forme1Liste hinzu
				Form1ParameterizedSeleniumKursChrome forme1ParaListe = mapToForm1(nextLine);
				forme1Liste.add(forme1ParaListe);
			}
		} catch (IOException | CsvValidationException e) {
			e.printStackTrace();
		}

		// Ausgabe der geladenen Form1
		forme1Liste.forEach(System.out::println);
		for (Form1ParameterizedSeleniumKursChrome liste : forme1Liste) {
	        collection.add(new Object[]{liste}); // Füge jedes Form1-Objekt als Array in die Collection hinzu
	    }
		//collection.forEach(System.out::println);
		return collection;
	}

	

	public static Form1ParameterizedSeleniumKursChrome mapToForm1(String[] daten) {
		Form1ParameterizedSeleniumKursChrome formPojo = null ;
	    for (int index = 0; index < daten.length; index++) {
	        if (daten[index] != null) {
	            String[] values = daten[index].split(";"); // Annahme: Semikolon als Trennzeichen
	            if (values.length > 0) {
	                System.out.println("Erstes Element: " + values[0]);
	                System.out.println("Zweites Element: " + values[1]);

	                String[] listeDatenBox1 = {values[7], values[8], values[9]};
	                String[] listeDatenBox2 = {values[10], values[11]};
	                int[] firmenBox1 = convertToIntArray(listeDatenBox1);
	                int[] firmenBox2 = convertToIntArray(listeDatenBox2);
	                System.out.println("INDEX: " + index);
	                
	                formPojo = new Form1ParameterizedSeleniumKursChrome();
	                formPojo.setTestName(values[0]);
	                formPojo.setBrowsername(values[1]);
	                formPojo.setUsername(values[2]);
	                formPojo.setPassword(values[3]);
	                formPojo.setBetreff(values[4]);
	                formPojo.setName(values[5]);
	                formPojo.setKursTitel(values[6]);
	                formPojo.setFirmenBox1(firmenBox1);
	                formPojo.setFirmenBox2(firmenBox2);
	                formPojo.setAssert1(values[12]);
	                formPojo.setAssert2(values[13]);
	                
	                for(int i = 0; i < firmenBox1.length; i++) {
	                	 System.out.println("BOX1: "+firmenBox1[i]);
	                }
	               
	               /* return new Form1ParameterizedSeleniumKursChrome(
	                    values[0], values[1], values[2], values[3], values[4],
	                    values[5], values[6], firmenBox1, firmenBox2,
	                    values[12], values[13]
	                );*/
	            }
	        }
	    }
	    return formPojo;
	}

	public static int[] convertToIntArray(String[] daten) {
		int[] intArray = new int[daten.length];
		for (int i = 0; i < daten.length; i++) {
			intArray[i] = Integer.parseInt(daten[i]);
		}
		return intArray;
	}

	public  static String[] convertToStringArray(int[] daten) {
		String[] stringArray = new String[daten.length];
		for (int i = 0; i < daten.length; i++) {
			stringArray[i] = String.valueOf(daten[i]);
		}
		return stringArray;
	}


}



