package protrack.com.frame.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.seleniumhq.jetty9.server.Authentication.Wrapped;
import org.testng.Assert;

import com.jayway.jsonpath.JsonPath;
import com.relevantcodes.extentreports.LogStatus;

import protrack.com.frame.core.BaseTest;

public class JsonReaderfile {

	//public File jsonFile;
	//public String value = null;

	public synchronized String DataReader(String TCID, String property) {
		String value = null;
		File jsonFile;
		// jsonFile = new File(System.getProperty("user.dir")
		// +"\\..\\protrack.com.framework\\TestData\\TestData.json");
		jsonFile = new File(System.getProperty("user.dir") + File.separator + ".." + File.separator
				+ "protrack.com.framework" + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator+"TestData.json");
		try {
			value = JsonPath.read(jsonFile, "$." + "TestData." + TCID + "." + property);
			
			System.out.println("Test data value is: "+ value);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return value;
	}
	
	public synchronized String[] getLocator(String property) {
		File jsonFile;
		// jsonFile = new File(System.getProperty("user.dir") +
		// "\\..\\protrack.com.framework\\ObjectRepository.json");
		jsonFile = new File(System.getProperty("user.dir") + File.separator + ".." + File.separator
				+ "protrack.com.framework" + File.separator + "ObjectRepository.json");
		String locatorType = null;
		String LocatorValue = null;
		String result = "";
		JSONArray Locator;

		try {

			BufferedReader br = new BufferedReader(new FileReader(jsonFile));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null) {
				sb.append(line);
				line = br.readLine();
			}
			result = sb.toString();
			JSONParser parser = new JSONParser();
			JSONObject json = (JSONObject) parser.parse(result);

			Locator = (JSONArray) json.get(property);
			locatorType = Locator.get(0).toString();
			LocatorValue = Locator.get(1).toString();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (ParseException e) {

			e.printStackTrace();
		}
		return new String[] { locatorType, LocatorValue };
		// return name;
	}

	public synchronized String getTestCaseData(String property) {
		String value = null;
		File jsonFile;
		jsonFile = new File(System.getProperty("user.dir")
			+ File.separator + "src" + File.separator + "test" +File.separator+ "resources" + File.separator + "ConfigPageURL.json");

		try {
			value = JsonPath.read(jsonFile, "$" + System.getProperty("environment") + "_Pages." + property);
			
		} catch (IOException e) {

			e.printStackTrace();
		}

		return value;
	}
	
	public synchronized String getTestCaseFieldData(String property) {
		String value = null;
		File jsonFile;
		jsonFile = new File(System.getProperty("user.dir") + File.separator + ".." + File.separator
				+ "protrack.com.framework" + File.separator + "src" + File.separator + "test" +File.separator+ "resources" + File.separator + "TestData.json");
		try {
			
			value = JsonPath.read(jsonFile, "$." + "TestData." + property);
			
		} catch (IOException e) {

			e.printStackTrace();
		}

		return value;
	}
	
}
