package DDT;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DDTbyExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(
				"D:\\Selenium_2025\\DemoProject\\src\\test\\resources\\ReadingDataFromExcel.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String campaignName = wb.getSheet("CampaignData").getRow(1).getCell(2).getStringCellValue();
		System.out.println(campaignName);
		double TargetData = wb.getSheet("CampaignData").getRow(1).getCell(3).getNumericCellValue();
		System.out.println(TargetData);
	}

}
