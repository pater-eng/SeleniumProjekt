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

public class CsvReaderDaten {
	public static void main(String[] args) {
		getVerzeichnis();

	}
	
	public static List<Object[]> getVerzeichnis() {
	    // Pfad zum Verzeichnis, in dem die CSV-Dateien liegen
	    String folderPath = "C:/Users/engoulou/Selenium/Daten/";
	//    System.out.println("Directory: " + folderPath);

	    List<Object[]> csvData = new ArrayList<>();

	    try {
	        // Liste alle Dateien mit der Endung .csv im Verzeichnis auf
	        Files.list(Paths.get(folderPath))
	            .filter(path -> path.toString().endsWith(".csv"))
	            .forEach(path -> csvData.addAll(readCsvFile(path)));

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return csvData;
	}

	
	public static List<Object[]> readCsvFile(Path filePath) {
	    List<Object[]> collection = new ArrayList<>();
	    
	    System.out.println("Auslesen der Datei: " + filePath.getFileName());
	    
	    try (CSVReader reader = new CSVReader(new FileReader(filePath.toFile()))) {
	        // Überspringe die erste Zeile (z.B. den Header)
	        reader.readNext();
	        String[] nextLine;
	        while ((nextLine = reader.readNext()) != null) {
	            System.out.println(Arrays.toString(nextLine)); // Jede Zeile ausgeben
	            Object[] params = mapToForm1(nextLine);
	            if (params != null) {
	                collection.add(params);
	            }
	        }
	    } catch (IOException | CsvValidationException e) {
	        e.printStackTrace();
	    }
	    
	    return collection;
	}


	public static Object[] mapToForm1(String[] daten) {
	    // Überprüfen, ob mindestens 14 Werte vorhanden sind (wie in Ihrem Beispiel erwartet)
	    if (daten != null && daten.length >= 14) {
	        String testName   = daten[0];
	        String browsername= daten[1];
	        String username   = daten[2];
	        String password   = daten[3];
	        String betreff    = daten[4];
	        String name       = daten[5];
	        String kursTitel  = daten[6];
	        // Erstelle die int-Arrays
	        int[] firmenBox1 = convertToIntArray(new String[]{daten[7], daten[8], daten[9]});
	        int[] firmenBox2 = convertToIntArray(new String[]{daten[10], daten[11]});
	        String assert1    = daten[12];
	        String assert2    = daten[13];

	        // Erstelle ein Array mit genau 11 Elementen
	        return new Object[]{
	            testName, browsername, username, password, betreff, name, kursTitel,
	            firmenBox1, firmenBox2, assert1, assert2
	        };
	    }
	    return null;
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



