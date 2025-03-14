package de.selenium.auslesen.config;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class EineExcelFileAuslesenApachePOI {

	public ArrayList<Object[]> getExcelData(String filepath) throws IOException {
		ArrayList<Object[]> output = new ArrayList<Object[]>();

		FileInputStream is = new FileInputStream(filepath);

		XSSFWorkbook workbook = new XSSFWorkbook(is);
		// Name des Sheets geben wir.
		XSSFSheet worksheet = workbook.getSheet("Testform3");
		// Hier können wir auf jeden einzelnen Row zugreiffen
		for (Row row : worksheet) {
			if (row.getRowNum() >= 1) {

				Object[] values = new Object[row.getPhysicalNumberOfCells()];

				Iterator<Cell> cellIerator = row.cellIterator();

				int coloumn = 0;
				while (cellIerator.hasNext()) {
					Cell cellValue = cellIerator.next();
					if (cellValue.getCellType() == CellType.STRING) {
						values[coloumn] = cellValue.getStringCellValue();
					} else {
						values[coloumn] = NumberToTextConverter.toText(cellValue.getNumericCellValue());
					}
					coloumn++;
				}
				output.add(values);
			}
		}

		return output;
	}
	public static void main(String[] args) throws IOException {
		EineExcelFileAuslesenApachePOI test = new EineExcelFileAuslesenApachePOI();
		ArrayList<Object[]> list = test.getExcelData("C:\\Users\\engoulou\\Selenium\\Daten\\datadriven\\TestCaseTestform3.xlsx");
		for (Object[] objects : list) {
			for(Object obj: objects ) {
				System.out.println(obj+",");	
			}
			System.out.print("\n");
		}

	}
	
}
