package DDT;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DDTbyJsonFile {

	public static void main(String[] args) throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		FileReader file = new FileReader("D:\\Selenium_2025\\DemoProject\\TestData\\studentData.json");
		Object javaObj = parser.parse(file);

		JSONObject obj = (JSONObject) javaObj;
		String name = obj.get("name").toString();
		String id = obj.get("id").toString();
		Object id1 = obj.get("id");
		String branch = obj.get("Branch").toString();
		String Age = obj.get("Age").toString();
		String isStudent = obj.get("isStudent").toString();
		System.out.println(name);
		System.out.println(id);
		System.out.println(id1);
		System.out.println(branch);
		System.out.println(Age);
		System.out.println(isStudent);

	}

}
