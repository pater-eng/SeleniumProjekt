package de.selenium.auslesen.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MehrereExcelFileAuslesen {

    // Innere Klasse zur Speicherung von Dateiname und Daten
    public static class ExcelFileData {
        private String fileName;
        private List<Object[]> data;
        
        // Konstruktor innere Klasse
        public ExcelFileData(String fileName, List<Object[]> data) {
            this.fileName = fileName;
            this.data = data;
        }

        public String getFileName() {
            return fileName;
        }

        public List<Object[]> getData() {
            return data;
        }
    }

    public List<ExcelFileData> getExcelDataFromDirectory(String directoryPath) throws IOException {
        List<ExcelFileData> output = new ArrayList<>();

        // Excel-Dateien im Verzeichnis finden
        try (Stream<Path> paths = Files.walk(Paths.get(directoryPath))) {
            paths.filter(Files::isRegularFile)
                 .filter(path -> path.toString().endsWith(".xlsx"))
                 .forEach(path -> {
                     try {
                         // Daten aus jeder Datei extrahieren
                         List<Object[]> data = getExcelDataFromFile(path.toString());
                         // Hinzufügen des Dateinamens und der Daten zur Liste
                         output.add(new ExcelFileData(path.getFileName().toString(), data));
                     } catch (IOException e) {
                         System.err.println("Fehler beim Verarbeiten der Datei: " + path);
                         e.printStackTrace();
                     }
                 });
        }

        return output;
    }
    
    private List<Object[]> getExcelDataFromFile(String filePath) throws IOException {
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
                        }
                    }
                    data.add(values.toArray());
                }
            }
        }

        return data;
    }

    
    public static void main(String[] args) {
    	MehrereExcelFileAuslesen poi = new MehrereExcelFileAuslesen();
        try {
            List<ExcelFileData> filesData = poi.getExcelDataFromDirectory("C:\\Users\\engoulou\\Selenium\\Daten\\datadriven");
            for (ExcelFileData fileData : filesData) {
                System.out.println("Datei: " + fileData.getFileName());
                for (Object[] row : fileData.getData()) {
                    System.out.println(Arrays.toString(row));
                }
                System.out.println(); // Leerzeile zwischen Dateien
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
