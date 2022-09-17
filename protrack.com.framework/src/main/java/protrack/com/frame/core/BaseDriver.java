package protrack.com.frame.core;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.internal.ElementScrollBehavior;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
//import sandata.com.frame.util.XmlReader;
import java.util.Properties;
import org.openqa.selenium.Proxy;

import java.util.concurrent.TimeUnit;
//import org.testng.annotations.*;

public class BaseDriver extends SeleniumHelper {
	public Properties GlobalVariables;
	
	//Bellow given syntaxes will set browser proxy settings using DesiredCapabilities.
	//private static final String PROXY = "localhost:8889";
	  //Proxy proxy = new Proxy();
		//options.addArguments("--proxy-server=%s" % MABL_CLI_PROXY);
		//capabilities.setCapability(CapabilityType.PROXY, MABL_CLI_PROXY);
		//  capabilities.setCapability(CapabilityType.PROXY, proxy);
	
	public synchronized void GetDriver(String browserName,String ApplicationUrl) {

		try {
			//String browserName = XmlReader.xmlReader("QA", "Browser");
			String OS = System.getProperty("os.name").toLowerCase();
			System.out.println("Running tests on OS: "+OS);
			switch (browserName) {
			case "chrome": {				
				if (OS.indexOf("win") >= 0){					
					System.setProperty("webdriver.chrome.driver",
							System.getProperty("user.dir") + "\\..\\protrack.com.framework\\BrowserDrivers\\chromedriver.exe");
				}
				
				else if (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 ) {
					System.setProperty("webdriver.chrome.driver",
                            System.getProperty("user.dir") + "/../protrack.com.framework/BrowserDrivers/chromedriver");

				} else { //MacOs
					System.setProperty("webdriver.chrome.driver",
							System.getProperty("user.dir") + "/../protrack.com.framework/BrowserDrivers/macos/chromedriver");
				}

				ChromeOptions options = new ChromeOptions();
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
				capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);

				//ßcapabilities.setCapability(CapabilityType.HAS_NATIVE_EVENTS, true);
				//capabilities.setCapability(CapabilityType.ELEMENT_SCROLL_BEHAVIOR, 0);
				//options.addArguments("test-type");
				//options.addArguments("--headless");
				//options.addArguments("window-size=720x760");
				//options.addArguments("--start-maximized");
				
				if (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 ){
					options.addArguments("--no-sandbox");
			        options.addArguments("--disable-dev-shm-usage");
			        options.addArguments("--ignore-certificate-errors");
			        options.addArguments("--disable-gpu");
			        options.addArguments("--allow-insecure-localhost");
			        options.addArguments("--allow-running-insecure-content");
			        options.setExperimentalOption("useAutomationExtension", false);
                    }

				//driver = new ChromeDriver(options);
				driver.set(new ChromeDriver(options));
				//if (OS.indexOf("win") >= 0){
					getDriver().manage().window().maximize();
				//}
				
			}
				break;
			case "ie": {
				DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
						true);
				capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
				capabilities.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, true);
				capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, true);
				// capabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS,
				// true);
				capabilities.setCapability(InternetExplorerDriver.ELEMENT_SCROLL_BEHAVIOR, ElementScrollBehavior.TOP);
				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir") + "\\..\\protrack.com.framework\\BrowserDrivers\\IEDriverServer.exe");
				//driver = new InternetExplorerDriver(capabilities);
				driver.set(new InternetExplorerDriver(capabilities));
				getDriver().manage().window().maximize();
			}
				break;
			case "firefox": {
				if (OS.indexOf("win") >= 0){
					System.setProperty("webdriver.gecko.driver",
							System.getProperty("user.dir")+"\\..\\protrack.com.framework\\BrowserDrivers\\geckodriver.exe");
				}
				
				else if (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 ) {
					System.setProperty("webdriver.gecko.driver",
							System.getProperty("user.dir")+"/../protrack.com.framework/BrowserDrivers/geckodriver");
				} else { //MacOs
					System.setProperty("webdriver.chrome.driver",
							System.getProperty("user.dir") + "/../protrack.com.framework/BrowserDrivers/macos/geckodriver");
				}
				DesiredCapabilities capabilities = new DesiredCapabilities();
				//capabilities.setCapability("acceptInsecureCerts",true);
				//driver = new FirefoxDriver(capabilities);
				driver.set(new FirefoxDriver(capabilities));
				getDriver().manage().deleteAllCookies();
				getDriver().manage().window().maximize();
			}

			}

			getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		getDriver().get(ApplicationUrl);
		//driver.get(XmlReader.xmlReader("QA", "ApplicationUrl"));
		// return driver;
	}

	/**
	 **************************************************************************************************************
	 * @Function Name: login page
	 * @Description: This function is used for login
	 * @Param: 
	 * @Return:
	 * @Date: 8th,July-2019
	 * @Author: Rahul Rohitashwar
	 **************************************************************************************************************
	 */
	
	public synchronized void StopDriver() {

		try {
			if (getDriver() != null) {
				
				getDriver().close();
				getDriver().quit();
				//driver.remove();
				//driver.set(null);

			}
		} catch (Exception ignore) {
			System.out.println("Getting Exception while closing the driver: " + ignore);

		}

	}
}
