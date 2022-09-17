package protrack.main.test.page;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Reporter;

import protrack.com.frame.core.BaseDriver;
import protrack.com.frame.core.BaseTest;
import protrack.com.frame.core.SeleniumHelper;
import protrack.com.frame.util.JsonReaderfile;
import protrack.com.test.suite.ExecutionEnvironment;

public class LoginPage extends BaseTest {

	SeleniumHelper wrapper = new SeleniumHelper();
	JsonReaderfile json;
	BaseDriver base = new BaseDriver();
	ExecutionEnvironment exec=new ExecutionEnvironment();


	/**
	 **************************************************************************************************************
	 * @Function Name: login page
	 * @Description: This function is used for login
	 * @Param: 
	 * @Return:
	 * @Date: 7th,July-2019
	 * @Author: Rahul Rohitashwar
	 **************************************************************************************************************
	 */

	// Verify that login page is displayed

	public synchronized boolean isLoginPageDisplayed() {
		json = new JsonReaderfile();
		//Reporter.log("Validate login page is displayed");
		wrapper.waitForBrowserToLoadCompletely();
		String ExpTitle = json.getTestCaseData("LoginExpectedURL");

		wrapper.waitForBrowserToLoadCompletely();

		if(wrapper.getDriver().getCurrentUrl().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("LoginExpectedTitle");
			return true;

		}

		return false;

	}

	public synchronized void login() {
		exec = new ExecutionEnvironment();
		Reporter.log("Login with correct credentials");
		//wrapper.setTextBoxValue_Direct("TxtField_TenantCode", exec.getEnvPropertyData("Tenant"));
		wrapper.setTextBoxValue_Direct("TxtField_Username", exec.getEnvPropertyData("Username"));
		wrapper.setTextBoxValue_Direct("TxtField_Password", exec.getEnvPropertyData("Password"));
		wrapper.click("Btn_SignIn");
		//wrapper.waitForElementInvisibility("ModalBox_Dashboard");
	}
	

	public synchronized void loginAfterLogout() {
		wrapper.getDriver().navigate().refresh();
		Reporter.log("Login with incorrect credentials");
		//wrapper.setTextBoxValue_Direct("TxtField_TenantCode", exec.getEnvPropertyData("Tenant"));
		wrapper.setTextBoxValue_Direct("TxtField_Username", exec.getEnvPropertyData("Username"));
		wrapper.setTextBoxValue_Direct("TxtField_Password", exec.getEnvPropertyData("Password"));
		wrapper.click("Btn_SignIn");
		//wrapper.waitForElementInvisibility("ModalBox_Dashboard");
	}

	public synchronized void logOut(){
		wrapper.waitForElementVisibility("Btn_Signout");
		wrapper.click("Btn_Signout");
		wrapper.getDriver().switchTo().alert().accept();
		wrapper.waitForBrowserToLoadCompletely();
	}

	public synchronized void logout(String ApplicationLogoutUrl) {
		Reporter.log("Logout of the application");
		wrapper.navigate(ApplicationLogoutUrl);		
	}

	public synchronized void login_IncorrectPassword() {
		Reporter.log("Login with incorrect password");

		//wrapper.setTextBoxValue_Direct("TxtField_TenantCode", exec.getEnvPropertyData("Tenant"));
		wrapper.setTextBoxValue_Direct("TxtField_Username", exec.getEnvPropertyData("Username"));
		wrapper.setTextBoxValue_Direct("TxtField_Password", "Password");
		wrapper.click("Btn_SignIn");
	}

	public synchronized void login_IncorrectUsernamePassword() {
		Reporter.log("Login with incorrect password");
		wrapper.waitForBrowserToLoadCompletely();
		//wrapper.setTextBoxValue_Direct("TxtField_TenantCode", "QA" );
		wrapper.setTextBoxValue_Direct("TxtField_Username", "QA" );
		wrapper.setTextBoxValue_Direct("TxtField_Password", "QA");
		wrapper.click("Btn_SignIn");
	}

	public synchronized void login_IncorrectLogin() {
		Reporter.log("Login with incorrect password");

		//wrapper.setTextBoxValue_Direct("TxtField_TenantCode", exec.getEnvPropertyData("Tenant"));
		wrapper.setTextBoxValue_Direct("TxtField_Username", exec.getEnvPropertyData("Username"));
		wrapper.setTextBoxValue_Direct("TxtField_Password", "Password");
		wrapper.click("Btn_SignIn");
	}

	public synchronized void validateMessage_IncorrectPassword() throws IOException{
		Reporter.log("Validate error message for incorrect login");
		wrapper.validateInnerText("AlertBox_PasswordError","ExpectedErrorMessage");
		loginAfterLogout();

	}

	public synchronized void validateMessage_IncorrectTenent() throws IOException{
		Reporter.log("Validate error message for incorrect login");
		wrapper.validateInnerText("AlertBox_TenentError","ExpectedErrorMessage");
		loginAfterLogout();

	}

	public synchronized void Login_with_maximize_mimimize_window() throws IOException, InterruptedException{
		
	
	wrapper.waitForBrowserToLoadCompletely();
	exec = new ExecutionEnvironment();
	Reporter.log("Login with correct credentials");
	//wrapper.setTextBoxValue_Direct("TxtField_TenantCode", exec.getEnvPropertyData("Tenant"));
	wrapper.setTextBoxValue_Direct("TxtField_Username", exec.getEnvPropertyData("Username"));
	wrapper.setTextBoxValue_Direct("TxtField_Password", exec.getEnvPropertyData("Password"));
	wrapper.minimizewindow();
	Thread.sleep(9000);
	wrapper.maximizewindow();
	wrapper.click("Btn_SignIn");
	}
}


