package protrack.com.test.suite;

import java.io.IOException;
import java.sql.Wrapper;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import protrack.com.frame.core.BaseDriver;
import protrack.com.frame.core.BaseTest;
import protrack.com.frame.core.SeleniumHelper;
import protrack.main.test.page.LoginPage;


public class Config_Utility extends BaseTest {

	LoginPage login = new LoginPage();
	BaseDriver base = new BaseDriver();
	ExecutionEnvironment exec = new ExecutionEnvironment();
	SeleniumHelper wrapper = new SeleniumHelper();

	
	@BeforeClass(dependsOnGroups = "beforeClass", alwaysRun = true)
	public synchronized void openBrowser() {
		base.GetDriver(exec.getEnvPropertyData("BrowserName"), exec.getEnvPropertyData("ApplicationUrl"));
	}

	@BeforeMethod(dependsOnGroups = "beforeMethod", alwaysRun = true)
	public synchronized void beforeMethod() throws IOException {
		login.login();
	}

	@AfterMethod(dependsOnGroups = "afterMethod", alwaysRun = true)
	public synchronized void logout() throws InterruptedException {
		if (wrapper.getElement("Btn_Signout").isDisplayed())
		{
			login.logOut();

		} else if(wrapper.getElement("Btn_Signout")==null)
		{
			wrapper.zoomInZoomOut();
			login.logOut();
		} else
		{
			wrapper.refresh();
			login.logOut();
		}
	}
	
	@AfterClass(dependsOnGroups = "afterClass", alwaysRun = true)
	public synchronized void endBrowser() {
		
		wrapper.getDriver().quit();
	}
}

