package utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataReader {
XSSFWorkbook wb;
	
	public ExcelDataReader() {
		File src = new File("./TestData/TestData.xlsx");
		
		FileInputStream fis;
		try {
			fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("Unable to load File " + e.getMessage());
		}
	}
	
	public String getStringData(int sheetIndex, int row, int column) {
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
	}
	
	public String getStringData(String SheetName, int row, int column) {
		return wb.getSheet(SheetName).getRow(row).getCell(column).getStringCellValue();
	}
	
	public double getNumericData(String SheetName, int row, int column) {
		return wb.getSheet(SheetName).getRow(row).getCell(column).getNumericCellValue();
	}
}