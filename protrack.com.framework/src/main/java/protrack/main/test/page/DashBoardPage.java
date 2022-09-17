package protrack.main.test.page;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import protrack.com.frame.core.BaseDriver;
import protrack.com.frame.core.BaseTest;
import protrack.com.frame.core.SeleniumHelper;
import protrack.com.frame.util.JsonReaderfile;
import protrack.com.test.suite.ExecutionEnvironment;

public class DashBoardPage extends BaseTest {

	SeleniumHelper wrapper = new SeleniumHelper();
	JsonReaderfile json;
	BaseDriver base = new BaseDriver();
	ExecutionEnvironment exec=new ExecutionEnvironment();
	;

	/**
	 **************************************************************************************************************
	 * @throws IOException 
	 * @throws InterruptedException 
	 * @Function Name: login page
	 * @Description: This function is used for login
	 * @Param: 
	 * @Return:
	 * @Date: 15th,July-2019
	 * @Author: Rahul Rohitashwar
	 **************************************************************************************************************
	 */

	// Verify that login page is displayed

	public synchronized void isDashBoardPageDisplayed() throws IOException, InterruptedException {
		json = new JsonReaderfile();
		Reporter.log("Validate Dashboard page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");

		wrapper.waitForBrowserToLoadCompletely();

		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) 
		{
			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("InlineText_AddDashBoard", "ExpectedPageName");

		}
		else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isAddprojectPageDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Add project page is displayed");
		
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		
		wrapper.waitForBrowserToLoadCompletely();
		
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateInnerText("InlineText_AddProject", "ExpectedPageName");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}

	}

	public synchronized void isAddCompanyPageDisplayed() throws IOException, InterruptedException {
		json = new JsonReaderfile();
		Reporter.log("Validate Add Company page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("InlineText_AddCompany", "ExpectedPageName");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}

	}

	public synchronized void isAddContactsPageDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Add Contact page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("InlineText_AddContacts", "ExpectedPageName");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}


	}
	
	public synchronized void isAddSurveyPageDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Add Survey page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("InlineText_AddSurvey", "ExpectedPageName");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}

		wrapper.waitForBrowserToLoadCompletely();

	}
	
	public synchronized void isAddLibraryofDocumentsPageDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate add Library of Document page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("InlineText_AddLibraryofDocuments", "ExpectedPageName");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}


	}
	
	public synchronized void isViewProjectListPageDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate View Project List page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("InlineText_ViewProjectListPage", "ExpectedPageName");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}


	}

	public synchronized void isViewContactListPageDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate View Contact List page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("InlineText_ViewContactListPage", "ExpectedPageName");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}


	}
	
	public synchronized void isViewCompanyListPageDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate View Contact List page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("InlineText_ViewCompanyListPage", "ExpectedPageName");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}


	}

	public synchronized void isViewCalenderListPageDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate View Contact List page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("InlineText_ViewCalenderListPage", "ExpectedPageName");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}

		wrapper.waitForBrowserToLoadCompletely();


	}

	public synchronized void validateContactPageListVisible() throws InterruptedException {
		Reporter.log("Validate Contact list page is in focus on Project management page");
		wrapper.validateElementVisible("ColumnFocus_ContactList");
	}
	
	public synchronized void validateProjectPageListVisible() throws InterruptedException {
		Reporter.log("Validate Project list page is in focus on Project management page");
		wrapper.validateElementVisible("ColumnFocus_ProjectList");
				
	}

	public synchronized void validateCompanyPageListVisible() throws InterruptedException {
		Reporter.log("Validate Company list page is in focus on Project management page");
		wrapper.validateElementVisible("ColumnFocus_CompanyList");
	}
	
	public synchronized void validateCalenderPageListVisible() throws InterruptedException {
		Reporter.log("Validate Company list page is in focus on Project management page");
		wrapper.validateElementVisible("ColumnFocus_CompanyList");
	}
}


