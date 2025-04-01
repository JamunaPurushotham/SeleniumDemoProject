package GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileUtility {

	public String readingDataFromUtilityFile(String key) throws IOException {

		FileInputStream fis = new FileInputStream(
				"D:\\Selenium_2025\\DemoProject\\src\\test\\resources\\CommonData.properties");
		Properties propUtil = new Properties();
		propUtil.load(fis);
		String data = propUtil.getProperty(key);
		return data;

	}

}
