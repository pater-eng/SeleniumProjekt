package de.selenium.auslesen.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AuslesenMehrereCSVFile {
	 // Methode zum Einlesen der CSV-Datei und Konvertierung in eine Liste von Object[] für den Parameterized-Test
    public static List<Object[]> readTestDataFromCsv(String csvFilePath) throws IOException {
    	// leer Lisste wird erstellt
        List<Object[]> testData = new ArrayList<>();
        //Mit einem try-with-resources-Block wird ein BufferedReader geöffnet, der die Datei am Pfad csvFilePath liest.
        // Durch die Verwendung von Files.newBufferedReader(Paths.get(csvFilePath)) wird sichergestellt, dass der richtige Zeichensatz und Pfad verwendet werden.
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            String line;
            boolean firstLine = true; // Erste Zeile wird überspringen
            while ((line = reader.readLine()) != null) {
                // Überspringe den Header
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                // Jede weitere Zeile wird mit line.split(";") in einzelne Tokens aufgeteilt, basierend auf dem Semikolon als Trennzeichen.
                String[] tokens = line.split(";");
                if (tokens.length == 11) {
                    // Konvertiere die Felder für firmenBox1 und firmenBox2 (Spalte 8 und 9)
                    int[] firmenBox1 = convertToIntArray(tokens[7].split(","));
                    int[] firmenBox2 = convertToIntArray(tokens[8].split(","));
                    Object[] row = new Object[] {
                        tokens[0],             // testName
                        tokens[1],             // browsername
                        tokens[2],             // username
                        tokens[3],             // password
                        tokens[4],             // betreff
                        tokens[5],             // name
                        tokens[6],             // kursTitel
                        firmenBox1,            // firmenBox1
                        firmenBox2,            // firmenBox2
                        tokens[9],             // assert1
                        tokens[10]            // assert2
                    };
                    testData.add(row);
                } else {
                    System.err.println("Ungültige Zeile (falsche Spaltenzahl): " + Arrays.toString(tokens));
                }
            }
        }
        return testData;
    }

    // Hilfsmethode zur Konvertierung eines String-Arrays in ein int-Array
    private static int[] convertToIntArray(String[] daten) {
        int[] intArray = new int[daten.length];
        for (int i = 0; i < daten.length; i++) {
            intArray[i] = Integer.parseInt(daten[i].trim());
        }
        return intArray;
    }
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String folderPath = "C:/Users/engoulou/Selenium/Daten/daten_csv";
        List<Object[]> allTestData = new ArrayList<>();

        // Alle CSV-Dateien im Verzeichnis einlesen
        Files.list(Paths.get(folderPath))
             .filter(path -> path.toString().endsWith(".csv"))
             .forEach(path -> {
                 try {
                	 System.out.println("CSVFile: "+path.getFileName());
                     List<Object[]> fileData = readTestDataFromCsv(path.toString());
                     allTestData.addAll(fileData);
                     for(Object[] obj: allTestData) {
                    	 System.out.println(Arrays.toString(obj));
                     }
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             });
	}

}
