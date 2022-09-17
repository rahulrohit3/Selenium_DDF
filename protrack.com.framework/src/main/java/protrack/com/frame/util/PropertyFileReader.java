package protrack.com.frame.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {

	public synchronized String getPropertyData(String propertyname) {
		File file = new File(System.getProperty("user.dir") + "/TestConfig/dbconfig.properties");

		FileInputStream fileInStream = null;
		try {
			fileInStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		// load properties file
		try {
			prop.load(fileInStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop.getProperty(propertyname);
	}
	
}
