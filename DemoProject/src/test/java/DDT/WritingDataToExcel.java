package DDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WritingDataToExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(
				"D:\\Selenium_2025\\DemoProject\\src\\test\\resources\\ReadingDataFromExcel.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.createSheet("WriteData").createRow(1).createCell(1).setCellValue("Selenium");
		FileOutputStream fos = new FileOutputStream(
				"D:\\Selenium_2025\\DemoProject\\src\\test\\resources\\ReadingDataFromExcel.xlsx");
		wb.write(fos);
		wb.close();
		System.out.println("Data written successfully");

	}

}
