package de.selenium.auslesen.config;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ErstellenEineCSVFile {
    // Methode zum Schreiben der Testdaten in eine CSV-Datei
    private static void writeTestDataToCsv(String csvFilePath) throws IOException {
        Object[][] daten = {
            { "Test Form 1 Test 1 Chrome", "chrome", "selenium102", "codingsolo", "Parametrisierter Test 1", "Dieter",
              "Java Grundlagen Kurs mit Dieter", "2,4,6", "2,4", "Java Grundlagen Kurs", "Magazzini Alimentari Riuniti" },
            { "Test Form 1 Test 2 Chrome", "chrome", "selenium102", "codingsolo", "Parametrisierter Test 2", "Miriam",
              "Python Grundlagen Kurs mit Dieter", "2,4,6", "2,4", "Python Grundlagen Kurs", "Magazzini Alimentari Riuniti" },
            { "Test Form 1 Test 2 FireFox", "fireFox", "selenium102", "codingsolo", "Parametrisierter Test 2", "Miriam",
              "Python Grundlagen Kurs mit Dieter", "2,4,6", "2,4", "Python Grundlagen Kurs", "Magazzini Alimentari Riuniti" },
            { "Test Form 1 Test 2 IE", "ie", "selenium102", "codingsolo", "Parametrisierter Test 2", "Miriam",
              "Python Grundlagen Kurs mit Dieter", "2,4,6", "2,4", "Python Grundlagen Kurs", "Magazzini Alimentari Riuniti" }
        };

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(csvFilePath))) {
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
    } 
    
    public static void main(String[] args) throws IOException{
    	writeTestDataToCsv("C:\\Users\\engoulou\\Selenium\\Daten\\erstellte_csvFile\\datei_1.csv");
    	
    	
    }
}
