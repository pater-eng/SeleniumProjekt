package de.selenium.auslesen.config;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import de.selenium.exception.FehlerTyp;
import de.selenium.exception.MeineException;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Stream;

public class MehrereExcelFileAuslesenMitApachePOI {

    public List<Object[]> getExcelDataFromDirectory(String directoryPath) throws IOException, MeineException {
        List<Object[]> output = new ArrayList<>();

        // Überprüfen, ob der Ordner existiert
        File ordner = new File(directoryPath);
        if (!ordner.exists() || !ordner.isDirectory()) {
            throw new MeineException(FehlerTyp.FILE_EXISTIERT_NICHT, "Der Ordner " + directoryPath + " existiert nicht oder ist kein Verzeichnis.");
        }
        
        // Excel-Dateien im Verzeichnis finden
        try (Stream<Path> paths = Files.walk(Paths.get(directoryPath))) {
            paths.filter(Files::isRegularFile)
                 .filter(path -> path.toString().endsWith(".xlsx"))
                 .forEach(path -> {
                     try {
                    	// System.out.println("File: "+path.getFileName());
                         // Daten aus jeder Datei extrahieren und zur Liste hinzufügen
                         output.addAll(getExcelDataFromFile(path.toString()));
                     } catch (IOException | MeineException e) {
                         System.err.println("Fehler beim Verarbeiten der Datei: " + path);
                         e.printStackTrace();
                     }
                 });
        }

        return output;
    }

    private List<Object[]> getExcelDataFromFile(String filePath) throws IOException, MeineException {
        List<Object[]> data = new ArrayList<>();

        try (FileInputStream is = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(is)) {

            // Annahme: Daten befinden sich im ersten Sheet
            Sheet sheet = workbook.getSheetAt(0);
            DataFormatter formatter = new DataFormatter();	

            for (Row row : sheet) {
                if (row.getRowNum() >= 1) { // Überspringe die Kopfzeile
                    List<Object> values = new ArrayList<>();
                    for (Cell cell : row) {
                        switch (cell.getCellType()) {
                            case STRING:
                            	String cellValue = formatter.formatCellValue(cell);
                                values.add(cellValue);
                                break;
                            case NUMERIC:
                                if (DateUtil.isCellDateFormatted(cell)) {
                                	String cellValue2 = formatter.formatCellValue(cell);
                                	values.add(cellValue2);
                                } else {
                                	String cellValue3 = formatter.formatCellValue(cell);
                                    values.add(cellValue3);
                                }
                                break;
                            case BOOLEAN:
                            	String cellValue4 = formatter.formatCellValue(cell);
                                values.add(cellValue4);
                                break;
                            case FORMULA:
                            	String cellValue5 = formatter.formatCellValue(cell);
                                values.add(cellValue5);
                                break;
                            default:
                                values.add(null);
                                throw new MeineException(FehlerTyp.VALUE_EXISTIERT_NICHT, "Er wurdet keinen Value hinzugefügt!");
                                
                        }
                    }
                    data.add(values.toArray());
                }
            }
        }

        return data;
    }

    public static void main(String[] args) throws MeineException {
        MehrereExcelFileAuslesenMitApachePOI poi = new MehrereExcelFileAuslesenMitApachePOI();
        try {
            List<Object[]> data = poi.getExcelDataFromDirectory("C:\\Users\\engoulou\\Selenium\\Daten\\datadriven");
            for (Object[] row : data) {
                System.out.println(Arrays.toString(row));
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
