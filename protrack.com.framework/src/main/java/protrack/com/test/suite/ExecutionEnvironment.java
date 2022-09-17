package protrack.com.test.suite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ExecutionEnvironment {
	
	public synchronized String getEnvPropertyData(String propertyname) { {
		File fileEnv;
		String environment = System.getProperty("environment");
		if (environment.equalsIgnoreCase("DEV")){
			fileEnv = new File(System.getProperty("user.dir") + File.separator+ "/src/main/resources/configDEVenvironment.properties");
		}

		else if (environment.equalsIgnoreCase("QA")){
			fileEnv = new File(System.getProperty("user.dir") + File.separator+ "/src/main/resources/configQAenvironment.properties");
		}
		else if (environment.equalsIgnoreCase("UAT")){
			fileEnv = new File(System.getProperty("user.dir") + File.separator+ "/src/main/resources/configUATenvironment.properties");
		}
		else if(environment.equalsIgnoreCase("Admin")){
			fileEnv = new File(System.getProperty("user.dir") + File.separator+ "/src/main/resources/configadminenvironment.properties");

		}
		

		else if (environment.equalsIgnoreCase("DEV_DAFC")){
			fileEnv = new File(System.getProperty("user.dir") + File.separator+ "/src/main/resources/configDEVenvironment_DAFC.properties");
		}
		else if (environment.equalsIgnoreCase("QA_DAFC")){
			fileEnv = new File(System.getProperty("user.dir") + File.separator+ "/src/main/resources/configQAenvironment_DAFC.properties");
		}
		else if(environment.equalsIgnoreCase("UAT_DAFC")){
			fileEnv = new File(System.getProperty("user.dir") + File.separator+ "/src/main/resources/configUATenvironment_DAFC.properties");

		}


		else if (environment.equalsIgnoreCase("DEV_SCIDA")){
			fileEnv = new File(System.getProperty("user.dir") + File.separator+ "/src/main/resources/configDEVenvironment_SCIDA.properties");
		}
		else if (environment.equalsIgnoreCase("QA_SCIDA")){
			fileEnv = new File(System.getProperty("user.dir") + File.separator+ "/src/main/resources/configQAenvironment_SCIDA.properties");
		}
		else if(environment.equalsIgnoreCase("UAT_SCIDA")){
			fileEnv = new File(System.getProperty("user.dir") + File.separator+ "/src/main/resources/configUATenvironment_SCIDA.properties");

		}

		else {
			fileEnv = new File(System.getProperty("user.dir") + File.separator+ "/src/main/resources/configQAenvironment.properties");
		}
		
		FileInputStream fileInStream = null;
		try {
			fileInStream = new FileInputStream(fileEnv);
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
}
