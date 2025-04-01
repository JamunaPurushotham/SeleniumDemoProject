package GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {

	public String readingDataFromExcel(String sheet, int rowNum, int cellNum)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(
				"D:\\Selenium_2025\\DemoProject\\src\\test\\resources\\ReadingDataFromExcel.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String excelData = wb.getSheet(sheet).getRow(rowNum).getCell(cellNum).getStringCellValue();
		return excelData;
	}

}
