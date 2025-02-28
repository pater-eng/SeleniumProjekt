package de.selenium.auslesen.config;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ErstellenEineCSVFile2 {
	 private static  Object[][] daten = {
	            { "Test Form 1 Test 1 Chrome", "chrome", "selenium102", "codingsolo", "Parametrisierter Test 1", "Dieter",
	                "Java Grundlagen Kurs mit Dieter", "2,4,6", "2,4", "Java Grundlagen Kurs", "Magazzini Alimentari Riuniti" },
	              { "Test Form 1 Test 2 Chrome", "chrome", "selenium102", "codingsolo", "Parametrisierter Test 2", "Miriam",
	                "Python Grundlagen Kurs mit Dieter", "2,4,6", "2,4", "Python Grundlagen Kurs", "Magazzini Alimentari Riuniti" },
	              { "Test Form 1 Test 2 FireFox", "fireFox", "selenium102", "codingsolo", "Parametrisierter Test 2", "Miriam",
	                "Python Grundlagen Kurs mit Dieter", "2,4,6", "2,4", "Python Grundlagen Kurs", "Magazzini Alimentari Riuniti" },
	              { "Test Form 1 Test 2 IE", "ie", "selenium102", "codingsolo", "Parametrisierter Test 2", "Miriam",
	                "Python Grundlagen Kurs mit Dieter", "2,4,6", "2,4", "Python Grundlagen Kurs", "Magazzini Alimentari Riuniti" }
	          };


    // Methode zum Schreiben der Testdaten in eine CSV-Datei
    private static void writeTestDataToCsv(String csvFilePath) throws IOException {
    	

    	String[] headers = {
    		    "testName", "browsername", "username", "password", "betreff", "name",
    		    "kursTitel", "firmenBox1", "firmenBox2", "assert1", "assert2"
    		};
       
    	List<Map<String, String>> dataList = new ArrayList<>();

    	for (Object[] row : daten) {
    	    Map<String, String> dataMap = new HashMap<>();
    	    for (int i = 0; i < headers.length; i++) {
    	        dataMap.put(headers[i], row[i].toString());
    	    }
    	    dataList.add(dataMap);
    	}
    	
    	try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(csvFilePath))) {
    	    // Schreibe die Kopfzeile
    	    writer.write(String.join(";", headers));
    	    writer.newLine();

    	    // Schreibe die Datenzeilen
    	    for (Map<String, String> dataMap : dataList) {
    	        List<String> row = new ArrayList<>();
    	        for (String header : headers) {
    	            row.add(dataMap.get(header));
    	        }
    	        writer.write(String.join(";", row));
    	        writer.newLine();
    	    }
    	} catch (IOException e) {
    	    e.printStackTrace();
    	}


       
    } 
    
    public static void main(String[] args) throws IOException{
    	writeTestDataToCsv("C:\\Users\\engoulou\\Selenium\\Daten\\erstellte_csvFile\\datei_2.csv");
    	
    	
    }
}
