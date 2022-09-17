package protrack.com.frame.core;

import static org.testng.Assert.assertEquals;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import protrack.com.frame.util.JsonReaderfile;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class SeleniumHelper implements Runnable{

	public static int StepNumber;
	static public ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	public WebElement element;
	public List<WebElement> listElement;
	public WebElement elementnew;
	public JsonReaderfile json= new JsonReaderfile();

	BaseTest baseTest;

	// DateFormat defDateFormat = new SimpleDateFormat("MM/dd/yyyy");
	// DateFormat defTimeFormat = new SimpleDateFormat("HH:mm:ss a");
	// DateFormat defDateTimeFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss
	// a");

	public synchronized void settDriver(ThreadLocal<WebDriver> driver) {
		SeleniumHelper.driver = driver;
	}

	public synchronized WebDriver getDriver() {

		return driver.get();
	}


	public synchronized String getAttribute_ButtonName(String locatorName, String attribute) {
		element = getElement(locatorName);
		return element.getAttribute(attribute);
	}

	public synchronized String getTextBoxValue(String locatorName) {
		this.element = getElement(locatorName);
		return element.getAttribute("value");
	}

	public synchronized boolean isReadOnlyTextBox(String locatorName) {
		this.element = getElement(locatorName);
		if ((element.getAttribute("readonly") != null) || (element.getAttribute("disabled") != null)) {
			BaseTest.test.log(LogStatus.INFO, "<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">"
					+ "<b>Step No - " + StepNumber++ + "" + " The Element Found as Read Only</b>");
			return true;
		} else {
			return false;

		}
	}

	public synchronized void Check_EditBox_ReadOnly(String locatorname) {
		BaseTest.test.log(LogStatus.INFO, "",
				"<b style= " + '"' + "font-size: 15px;color:blue" + '"' + ">" + BaseTest.testStep + "</b>");
		boolean r_Only = isReadOnlyTextBox(locatorname);
		if (r_Only) {
			BaseTest.test.log(LogStatus.PASS, "<b>Step No - " + StepNumber++ + "</b>",
					"<b>  Element has been Found As Read Only </b> ");

		} else {
			BaseTest.test.log(LogStatus.FAIL, "<b>Step No - " + StepNumber++ + "</b>",
					"<b>  Element NOT Found As Read Only </b> ");
			Assert.fail();
		}

	}

	public synchronized boolean getAttributeStatus(String locatorName, String attributeName) {
		this.element = getElement(locatorName);
		if (element.getAttribute(attributeName) != null) {
			return true;
		} else {
			return false;
		}
	}

	public synchronized boolean validateItemCount(int actualNumber, int expNumber) {
		// TODO Auto-generated method stub

		if(actualNumber==expNumber){
			BaseTest.test.log(LogStatus.PASS, "<b style= "+'"'+"font-size: 15px;color:green"+'"'+">"+"<b>Step No - "+StepNumber+++"</b>"+"</b>","<b style= "+'"'+"font-size: 15px;color:green"+'"'+">Number or Count Validation"+"</b> "+"</b>"+" Number or Count Validation Passed.  actual ADA Error Count: [<b>"+actualNumber+"</b>]  AND  expected ADA Error Count: [<b>"+expNumber+"</b>]");
			return true;
		}else{
			BaseTest.test.log(LogStatus.FAIL, "<b style= "+'"'+"font-size: 15px;color:red"+'"'+">"+"<b>Step No - "+StepNumber+++"</b>"+"</b>","<b style= "+'"'+"font-size: 15px;color:red"+'"'+">Number or Count Validation</b> "+"</b>"+" Number or Count Validation Passed. "+".  actual ADA Error Count: [<b>"+actualNumber+"</b>]  AND  expected ADA Error Count: [<b>"+expNumber+"</b>]");
			this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());
			Assert.assertEquals(actualNumber, expNumber);
			return false;
		}
	}

	public synchronized void validateInnerText( String locatorName, String validationName) throws IOException {
		json = new JsonReaderfile();
		this.element = getElement(locatorName);
		System.out.println(BaseTest.folderPath);
		String actualValue = element.getText();
		System.out.println("actual value is:- " + actualValue);

		String expectedValue = testDataMethodPick(validationName);
		if (expectedValue == null) {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Text Validation Failed"
							+ ". Expected Value is Null Please Match Test Data Column Name from script's field Name");
			// Assert.assertTrue(false);
			this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());
			Assert.assertTrue(false,
					"Text Validation Failed. Expected Value is Null Please Match Test Data Column Name from script's field Name");

		}
		if (expectedValue.trim().equalsIgnoreCase(actualValue.trim())) {
			BaseTest.test.log(LogStatus.PASS,
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Text Validation Passed" + ".  actual text: [<b>" + actualValue
							+ "</b>]  AND  expected: [<b>" + expectedValue + "</b>]");
		} else {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Text Validation Failed " + ".  actual text: [<b>" + actualValue
							+ "</b>]  AND  expected: [<b>" + expectedValue + "</b>]");
			// Assert.assertEquals(expectedValue.trim(), actualValue.trim());
			this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());
			Assert.assertEquals(actualValue.trim(), expectedValue.trim(),  "Expected value: " + expectedValue.trim()
			+ " does not match with Actual value: " + actualValue.trim());
			Assert.fail();
		}

	}


	public synchronized String testDataMethodPick(String validationName)
	{
		String expectedValue = null;

		for(int i=0;i<15;i++)

		{
			try{
				System.out.println(Thread.currentThread().getStackTrace()[i].getMethodName());
				expectedValue = json.DataReader(Thread.currentThread().getStackTrace()[i].getMethodName(), validationName);
				break;
			}
			catch(Exception e)
			{

			}
		}
		return expectedValue;
	}


	// Overloading for access duplicateTestData fields

	public synchronized void validateDynamicText(String locatorName, String validationName) {

		this.element = getElement(locatorName);
		String actualValue = element.getText();
		String expectedValue = validationName;
		if (expectedValue == null) {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Text Validation Failed"
							+ ". Expected Value is Null Please Match Test Data Column Name from script's field Name");
			this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());
			Assert.assertTrue(false,
					"Text Validation Failed. Expected Value is Null Please Match Test Data Column Name from script's field Name");
		}
		if (expectedValue.trim().equalsIgnoreCase(actualValue.trim())) {
			BaseTest.test.log(LogStatus.PASS,
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Text Validation Passed" + ".  actual text: [<b>" + actualValue
							+ "</b>]  AND  expected: [<b>" + expectedValue + "</b>]");
		} else {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Text Validation Failed " + ".  actual text: [<b>" + actualValue
							+ "</b>]  AND  expected: [<b>" + expectedValue + "</b>]");
			// Assert.assertEquals(expectedValue.trim(), actualValue.trim());
			this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());
			Assert.assertEquals(actualValue.trim(), expectedValue.trim(),  "Expected value: " + expectedValue.trim()
			+ " does not match with Actual value: " + actualValue.trim());
		}

	}
	
	public synchronized void validateDynamicText(String locatorName, String locatorValue, String validationName) throws InterruptedException {

		this.element = getTextValueUsingSpecificElement(locatorName, locatorValue);
		String actualValue = element.getText();
		String expectedValue = validationName;
		if (expectedValue == null) {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Text Validation Failed"
							+ ". Expected Value is Null Please Match Test Data Column Name from script's field Name");
			this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());
			Assert.assertTrue(false,
					"Text Validation Failed. Expected Value is Null Please Match Test Data Column Name from script's field Name");
		}
		if (expectedValue.trim().equalsIgnoreCase(actualValue.trim())) {
			BaseTest.test.log(LogStatus.PASS,
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Text Validation Passed" + ".  actual text: [<b>" + actualValue
							+ "</b>]  AND  expected: [<b>" + expectedValue + "</b>]");
		} else {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Text Validation Failed " + ".  actual text: [<b>" + actualValue
							+ "</b>]  AND  expected: [<b>" + expectedValue + "</b>]");
			// Assert.assertEquals(expectedValue.trim(), actualValue.trim());
			this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());
			Assert.assertEquals(actualValue.trim(), expectedValue.trim(),  "Expected value: " + expectedValue.trim()
			+ " does not match with Actual value: " + actualValue.trim());
		}

	}

	public synchronized void isSelectDropdown(String locatorName) {

		if (select(locatorName) != null) {
			BaseTest.test.log(LogStatus.PASS,
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Element Type Validation Passed. Element Type is Dropdown" + "</b>]");
		}
	}

	public synchronized void validateElementVisible(String locatorName) throws InterruptedException {
		zoomIn();
		zoomout();
		if (isVisible(locatorName))

		{
			BaseTest.test.log(LogStatus.PASS,
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Element is Visible. Validation Passed"
							+ ".  actual value:<b>Visible</b>  AND  expected value: [<b>Visible</b>]");

		} else {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Element is not Visible. Validation Failed"
							+ ".  actual value:<b>Not Visible</b>  AND  expected value: [<b>Visible</b>]");
			// Assert.assertTrue(false);
			Assert.assertTrue(false, "The desired element is not Visible. Thereby, validation Failed");
		}
	}

	public synchronized void validateElementVisibleandEnabled(String locatorName) throws InterruptedException {
		zoomIn();
		zoomout();
		if (isVisible(locatorName) && isEnabled(locatorName))

		{
			BaseTest.test.log(LogStatus.PASS,
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Element is Visible. Validation Passed"
							+ ".  actual value:<b>Visible</b>  AND  expected value: [<b>Visible</b>]");
			Assert.assertTrue(true, "The desired element is  visible and  enabled. Thereby, validation Passed");

		} else {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Element is not Visible. Validation Failed"
							+ ".  actual value:<b>Not Visible</b>  AND  expected value: [<b>Visible</b>]");
			// Assert.assertTrue(false);
			Assert.assertTrue(false, "The desired element is neither visible nor enabled. Thereby, validation Failed");
		}
	}

	public synchronized void validateElementNotVisible(String locatorName) {

		this.element=getElementWithoutExceptions(locatorName);
		if (element==null) {
			BaseTest.test.log(LogStatus.PASS,
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Element is Visible. Validation Passed"
							+ ".  actual value:<b>Visible</b>  AND  expected value: [<b>Visible</b>]");
			this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());
		} else {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Element is not Visible. Validation Failed"
							+ ".  actual value:<b>Visible</b>  AND  expected value: [<b>Not Visible</b>]");
			// Assert.assertTrue(false);
			this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());
			Assert.assertTrue(false, "The desired element is Visible. Thereby, validation Failed");
		}
	}

	public synchronized void validateElementEnabled(String locatorName) {

		if (isEnabled(locatorName) ) {
			BaseTest.test.log(LogStatus.PASS,
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Element is Enabled. Validation Passed"
							+ ".  actual value:<b>ENABLED</b>  AND  expected value: [<b>ENABLED</b>]");
		} else {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Element is Disabled. Validation Failed"
							+ ".  actual value:<b>DISABLED</b>  AND  expected value: [<b>ENABLED</b>]");
			// Assert.assertTrue(false);
			Assert.assertTrue(false, "The desired element is not Enabled. Thereby, validation Failed");
		}

	}

	public synchronized void validateElementDisabled(String locatorName) {

		if (!isEnabled(locatorName)) {
			BaseTest.test.log(LogStatus.PASS,
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Element is Disabled. Validation Failed"
							+ ".  actual value:<b>DISABLED</b>  AND  expected value: [<b>ENABLED</b>]");
		} else {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + "  Element is Enabled. Validation Passed"
							+ ".  actual value:<b>ENABLED</b>  AND  expected value: [<b>ENABLED</b>]");
			// Assert.assertTrue(false);
			Assert.fail("The desired element is Enabled. Thereby, validation Failed");
		}

	}

	public synchronized boolean isEnabled(String locatorName) {
		try {
			this.element = getElement(locatorName);
		} catch (Exception e) {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + " Element Not Found in Page Source");
			Assert.fail("Element is not enabled");
		}

		return this.element.isEnabled();
	}

	public synchronized boolean isVisible(String locatorName) {
		try {
			this.element = getElement(locatorName);
		} catch (Exception e) {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + " Element Not Found in Page Source");
			Assert.fail("Element is not visible");
		}

		return this.element.isDisplayed();
	}

	public synchronized boolean isVisible_dynamic(String locatorName) {

		this.element = getElement(locatorName);


		return this.element.isDisplayed();
	}
	
	
	public synchronized void minimizewindow() {

		getDriver().manage().window().setPosition(new Point(-2000, 0));


		
	}
	
	public synchronized void resiizewindow() {

		getDriver().manage().window().setPosition(new Point(1100, 900));


		
	}
	
	public synchronized void maximizewindow() {

		getDriver().manage().window().maximize();


		
	}

	public synchronized void validateElementIsTextBox(String locatorName) {
		try {
			this.element = getElement(locatorName);
		} catch (Exception e) {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + " Element Not Found in Page Source");
			Assert.fail("Element Not Found in Page Source");
		}

		if (element.getTagName().equals("input") && element.getAttribute("type").equals("text")) {
			BaseTest.test.log(LogStatus.PASS,
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Element is Text Box. Validation Passed"
							+ ".  actual value:<b>TextBox</b>  AND  expected value: [<b>TextBox</b>]");
		} else {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Element is not Text Box. Validation Failed"
							+ ".  actual value:<b>Not Textbox</b>  AND  expected value: [<b>TextBox</b>]");
			Assert.assertTrue(false, "Element is not a Text Box. Thereby, validation failed.");
		}
	}

	public synchronized void validateInnerTextContains( String locatorName, String validationName) {
		json = new JsonReaderfile();
		this.element = getElement(locatorName);

		String actualValue = element.getText();
		String expectedValue = null;
		expectedValue=testDataMethodPick(validationName);

		if (expectedValue == null) {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Text Validation Failed"
							+ ". Expected Value is Null Please Match Test Data Column Name from script's field Name");
			// Assert.assertTrue(false);

			Assert.assertTrue(false,
					"Text Validation Failed. Expected Value is Null Please Match Test Data Column Name from script's field Name");
		}
		if (actualValue.trim().toLowerCase().contains(expectedValue.trim().toLowerCase())) {
			BaseTest.test.log(LogStatus.PASS,
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Text Validation Passed" + ".  actual text: [<b>" + actualValue
							+ "</b>]  AND  expected: [<b>" + expectedValue + "</b>]");
		} else {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Text Validation Failed" + ".  actual text: [<b>" + actualValue
							+ "</b>]  AND  expected: [<b>" + expectedValue + "</b>]");
			// Assert.assertEquals(expectedValue.trim(), actualValue.trim());
			this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());
			Assert.assertEquals(actualValue.trim(),expectedValue.trim(), "Expected value: " + expectedValue.trim()
			+ " does not match with Actual value: " + actualValue.trim());
		}

	}
	
	
	public synchronized void validateInnerTextContainsdirect( String locatorName, String validationName) {
		json = new JsonReaderfile();
		this.element = getElement(locatorName);

		String actualValue = element.getText();
		String expectedValue = null;
		expectedValue=validationName;

		if (expectedValue == null) {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Text Validation Failed"
							+ ". Expected Value is Null Please Match Test Data Column Name from script's field Name");
			// Assert.assertTrue(false);

			Assert.assertTrue(false,
					"Text Validation Failed. Expected Value is Null Please Match Test Data Column Name from script's field Name");
		}
		if (actualValue.trim().toLowerCase().contains(expectedValue.trim().toLowerCase())) {
			BaseTest.test.log(LogStatus.PASS,
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Text Validation Passed" + ".  actual text: [<b>" + actualValue
							+ "</b>]  AND  expected: [<b>" + expectedValue + "</b>]");
		} else {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Text Validation Failed" + ".  actual text: [<b>" + actualValue
							+ "</b>]  AND  expected: [<b>" + expectedValue + "</b>]");
			// Assert.assertEquals(expectedValue.trim(), actualValue.trim());
			this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());
			Assert.assertEquals(actualValue.trim(),expectedValue.trim(), "Expected value: " + expectedValue.trim()
			+ " does not match with Actual value: " + actualValue.trim());
		}

	}

	public synchronized void validateInnerTextContains_Duplicate(String locatorName, String validationName) {
		json = new JsonReaderfile();
		this.element = getElement(locatorName);

		String actualValue = element.getText();
		String expectedValue = null;
		expectedValue = json.getTestCaseData(validationName);


		if (expectedValue == null) {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Text Validation Failed"
							+ ". Expected Value is Null Please Match Test Data Column Name from script's field Name");
			// Assert.assertTrue(false);
			Assert.assertTrue(false,
					"Text Validation Failed. Expected Value is Null Please Match Test Data Column Name from script's field Name");
		}
		if (actualValue.trim().toLowerCase().contains(expectedValue.trim().toLowerCase())) {
			BaseTest.test.log(LogStatus.PASS,
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Text Validation Passed" + ".  actual text: [<b>" + actualValue
							+ "</b>]  AND  expected: [<b>" + expectedValue + "</b>]");
			this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());
		} else {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Text Validation Failed" + ".  actual text: [<b>" + actualValue
							+ "</b>]  AND  expected: [<b>" + expectedValue + "</b>]");
			// Assert.assertEquals(expectedValue.trim(), actualValue.trim());
			this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());
			Assert.assertEquals(actualValue.trim(),expectedValue.trim(),  "Expected value: " + expectedValue.trim()
			+ " does not match with Actual value: " + actualValue.trim());
		}

	}

	public synchronized void validateElementInnerTextContains(String locatorName, String validationName) {
		json = new JsonReaderfile();
		this.element = getElement(locatorName);

		String actualValue = element.getText();
		//String expectedValue = null;
		String expectedValue = json.DataReader(Thread.currentThread().getStackTrace()[3].getMethodName(), validationName);


		if (expectedValue == null) {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Text Validation Failed"
							+ ". Expected Value is Null Please Match Test Data Column Name from script's field Name");
			// Assert.assertTrue(false);
			Assert.assertTrue(false,
					"Text Validation Failed. Expected Value is Null Please Match Test Data Column Name from script's field Name");
		}
		if (actualValue.trim().toLowerCase().contains(expectedValue.trim().toLowerCase())) {
			BaseTest.test.log(LogStatus.PASS,
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Text Validation Passed" + ".  actual text: [<b>" + actualValue
							+ "</b>]  AND  expected: [<b>" + expectedValue + "</b>]");
		} else {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Text Validation Failed" + ".  actual text: [<b>" + actualValue
							+ "</b>]  AND  expected: [<b>" + expectedValue + "</b>]");
			// Assert.assertEquals(expectedValue.trim(), actualValue.trim());
			this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());
			Assert.assertEquals(actualValue.trim(),expectedValue.trim(),  "Expected value: " + expectedValue.trim()
			+ " does not match with Actual value: " + actualValue.trim());
		}

	}

	public synchronized void validateSelectedValueInSingleSelectionDropdown( String locatorName, String validationName) {
		json = new JsonReaderfile();
		String actualValue = getFirstSelectedOption(locatorName).getText().trim();
		String expectedValue = null;
		expectedValue=testDataMethodPick(validationName);

		if (expectedValue == null) {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Dropdown Validation Failed"
							+ ". Expected Value is Null Please Match Test Data Column Name from script's field Name");
			// Assert.assertTrue(false);
			Assert.assertTrue(false,
					"Text Validation Failed. Expected Value is Null Please Match Test Data Column Name from script's field Name");
		}
		if (actualValue.trim().equalsIgnoreCase(expectedValue.trim())) {
			BaseTest.test.log(LogStatus.PASS,
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Selected value is correct. Validation Passed"
							+ ".  actual text: [<b>" + actualValue + "</b>]  AND  expected: [<b>" + expectedValue
							+ "</b>]");
		} else {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Selected value is incorrect. Validation Failed"
							+ ".  actual text: [<b>" + actualValue + "</b>]  AND  expected: [<b>" + expectedValue
							+ "</b>]");
			// Assert.assertEquals(actualValue.trim(), expectedValue.trim());
			Assert.assertEquals(actualValue.trim(),expectedValue.trim(),  "Expected value: " + expectedValue.trim()
			+ " does not match with Actual value: " + actualValue.trim());

		}
	}

	public synchronized void validateSelectedValueInSingleSelectionDropdown_duplicate(String locatorName, String validationName) {
		json = new JsonReaderfile();
		String actualValue = getFirstSelectedOption(locatorName).getText().trim();
		String expectedValue = null;
		expectedValue = json.getTestCaseData(validationName);

		if (expectedValue == null) {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Dropdown Validation Failed"
							+ ". Expected Value is Null Please Match Test Data Column Name from script's field Name");
			// Assert.assertTrue(false);
			Assert.assertTrue(false,
					"Text Validation Failed. Expected Value is Null Please Match Test Data Column Name from script's field Name");
		}
		if (actualValue.trim().equalsIgnoreCase(expectedValue.trim())) {
			BaseTest.test.log(LogStatus.PASS,
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Selected value is correct. Validation Passed"
							+ ".  actual text: [<b>" + actualValue + "</b>]  AND  expected: [<b>" + expectedValue
							+ "</b>]");
		} else {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Selected value is incorrect. Validation Failed"
							+ ".  actual text: [<b>" + actualValue + "</b>]  AND  expected: [<b>" + expectedValue
							+ "</b>]");
			// Assert.assertEquals(actualValue.trim(), expectedValue.trim());
			Assert.assertEquals( actualValue.trim(),expectedValue.trim(), "Expected value: " + expectedValue.trim()
			+ " does not match with Actual value: " + actualValue.trim());

		}
	}

	public synchronized void validateSelectedValueInSingleSelectionDropdownDirectly(String locatorName, String expectedValue) {
		String actualValue = getFirstSelectedOption(locatorName).getText().trim();

		if (actualValue.trim().equalsIgnoreCase(expectedValue.trim())) {
			BaseTest.test.log(LogStatus.PASS,
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Selected value is correct. Validation Passed"
							+ ".  actual text: [<b>" + actualValue + "</b>]  AND  expected: [<b>" + expectedValue
							+ "</b>]");
		} else {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Selected value is incorrect. Validation Failed"
							+ ".  actual text: [<b>" + actualValue + "</b>]  AND  expected: [<b>" + expectedValue
							+ "</b>]");
			// Assert.assertEquals(actualValue.trim(), expectedValue.trim());
			Assert.assertEquals(actualValue.trim(), expectedValue.trim(),  "Expected value: " + expectedValue.trim()
			+ " does not match with Actual value: " + actualValue.trim());
		}
	}

	public synchronized void validateInnerTextContainsDirectly(String locatorName, String expectedValue) {

		this.element = getElement(locatorName);

		String actualValue = element.getText();

		if (actualValue.trim().toLowerCase().contains(expectedValue.trim().toLowerCase())) {
			BaseTest.test.log(LogStatus.PASS,
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Text Validation Passed" + ".  actual text: [<b>" + actualValue
							+ "</b>]  AND  expected: [<b>" + expectedValue + "</b>]");
		} else {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Text Validation Failed " + ".  actual text: [<b>" + actualValue
							+ "</b>]  AND  expected: [<b>" + expectedValue + "</b>]");

			// Assert.assertEquals(actualValue.trim(), expectedValue.trim());

			Assert.assertEquals(actualValue.trim(),expectedValue.trim(), "Expected value: " + expectedValue.trim()
			+ " does not match with Actual value: " + actualValue.trim());
		}

	}

	public synchronized void validateInnerTextDirectly(String locatorName, String expectedValue) {
		try {
			this.element = getElement(locatorName);
		} catch (Exception e) {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + " Element Not Found in Page Source");
			Assert.fail("Element Not Found in Page Source");
		}

		String actualValue = element.getText();
		System.out.println( " this is the actual value " + actualValue);
		if (expectedValue.trim().toLowerCase().contains(actualValue.trim().toLowerCase())) {
			BaseTest.test.log(LogStatus.PASS,
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Text Validation Passed" + ".  actual text: [<b>" + actualValue
							+ "</b>]  AND  expected: [<b>" + expectedValue + "</b>]");
		} else {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Text Validation Failed " + ".  actual text: [<b>" + actualValue
							+ "</b>]  AND  expected: [<b>" + expectedValue + "</b>]");
			// Assert.assertEquals(expectedValue.trim(), actualValue.trim());
			Assert.assertEquals(actualValue.trim(),expectedValue.trim(),  "Expected value: " + expectedValue.trim()
			+ " does not match with Actual value: " + actualValue.trim());
		}

	}
	
	
	
	
	

	public synchronized WebElement getElement(String locatorName) {
		json = new JsonReaderfile();
		try {
			String locatorType = json.getLocator(locatorName)[0];
			String locatorValue = json.getLocator(locatorName)[1];
			By locator = getLocatorBy(locatorName, locatorType, locatorValue);
			int count = 1;
			System.out.println(
					"Waiting upto " + 10000 + "ms for element with locator: \"" + locator + "\" to appear on page.");
			while (getDriver().findElements(locator).size() == 0 && count <= 5) {
				Thread.sleep(1000);
				System.out.println("Waiting " + 1 + "000 ms for count " + count);
				count++;
			}
			return (getDriver().findElement(locator));
		} catch (NoSuchElementException e) {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style=" + '"' + "color:red" + '"' + ">Step No - " + StepNumber++ + "</b>" + "</b>",
					"<b>" + locatorName + "</b> " + "</b> " + "  is not found on Page Source. Test Failed");
			e.printStackTrace();
			Assert.fail("Element is not found");
		} catch (NullPointerException e) {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style=" + '"' + "color:red" + '"' + ">Step No - " + StepNumber++ + "</b>" + "</b>",
					"NullPointerException for " + "<b>" + locatorName + "</b> " + "</b> "
							+ "  Please Match Script's locator Name with OR Locator Name. Test Failed");
			e.printStackTrace();
			Assert.fail("Please Match Script's locator Name with OR Locator Name");
		} catch (StaleElementReferenceException e) {
			BaseTest.test.log(LogStatus.FAIL, "<b>Step No - " + StepNumber++ + "</b>",
					"<b>" + locatorName + "</b> " + "  is not attached to the page document. Test Failed");
			System.out.println("Element is not attached to the page document " + e.getStackTrace());
			e.printStackTrace();
			Assert.fail("Element is not attached to the page document");
		} 

		catch (InvalidElementStateException e) {
			BaseTest.test.log(LogStatus.FAIL, "<b>Step No - " + StepNumber++ + "</b>",
					"<b>" + locatorName + "</b> " + "  is not attached to the current page/modal document. Test Failed");
			System.out.println("Element is not currently interactable" + e.getStackTrace());
			e.printStackTrace();
			Assert.fail("Element is not attached to the page document");
		} 


		catch (Exception e) {
			BaseTest.test.log(LogStatus.FAIL, "<b>Step No - " + StepNumber++ + "</b>",
					"<b>" + locatorName + "</b> " + "  is not clickable. Test Failed");
			System.out.println("Element " + element + " is not clickable " + e.getStackTrace());
			e.printStackTrace();
			Assert.fail("Element is not clickable");
		}
		return null;
	}

	public synchronized List<WebElement> getElement_dynamic(String locatorName) throws InterruptedException {
		json = new JsonReaderfile();

		String locatorType = json.getLocator(locatorName)[0];
		String locatorValue = json.getLocator(locatorName)[1];
		By locator = getLocatorBy(locatorName, locatorType, locatorValue);
		int count = 1;
		System.out.println(
				"Waiting upto " + 10000 + "ms for element with locator: \"" + locator + "\" to appear on page.");
		while (getDriver().findElements(locator).size() == 0 && count <= 1) {
			Thread.sleep(1000);
			System.out.println("Waiting " + 1 + "000 ms for count " + count);
			count++;
		}
		return (getDriver().findElements(locator));

	}
	

	public synchronized WebElement getElementWithoutExceptions(String locatorName) {
		json = new JsonReaderfile();
		try {
			String locatorType = json.getLocator(locatorName)[0];
			String locatorValue = json.getLocator(locatorName)[1];
			By locator = getLocatorBy(locatorName, locatorType, locatorValue);
			int count = 1;
			System.out.println(
					"Waiting upto " + 10000 + "ms for element with locator: \"" + locator + "\" to appear on page.");
			while (getDriver().findElements(locator).size() == 0 && count <= 5) {
				Thread.sleep(1000);
				System.out.println("Waiting " + 1 + "000 ms for count " + count);
				count++;
			}
			return (getDriver().findElement(locator));
		} catch (NoSuchElementException e) {
			System.out.println("NoSuchElementException");
		} catch (NullPointerException e) {
			System.out.println("NullPointerException");
		} catch (StaleElementReferenceException e) {
			System.out.println("StaleElementReferenceException");
		} catch (Exception e) {
			System.out.println("Exception");
		}
		return null;
	}


	public synchronized void click(String locatorName) {
		try {
			this.element = getElement(locatorName);
			element.click();

			BaseTest.test.log(LogStatus.INFO, "<b>Step No - " + StepNumber++ + "</b>",
					"<b>" + locatorName + "</b> " + "</b> " + " has been clicked successfully");
		} catch (ElementNotVisibleException e) {
			BaseTest.test.log(LogStatus.FAIL, "<b>Step No - " + StepNumber++ + "</b>",
					"<b>" + locatorName + "</b> " + " has not been clicked because " + "<b>" + locatorName + "</b> "
							+ "</b> " + " is not visible on Page. So Selenium is not able to perform click.");
			Assert.fail("Unable to click the element");
		} catch (StaleElementReferenceException e) {
			try {
				this.element = getElement(locatorName);
				element.click();

			} catch (StaleElementReferenceException ne) {
				BaseTest.test.log(LogStatus.FAIL, "<b>Step No - " + StepNumber++ + "</b>",
						"<b>" + locatorName + "</b> " + "</b> " + " has not been clicked because " + "<b>" + locatorName
						+ "</b> " + "</b> "
						+ " Web page's HTM has been refreshed, changed or updated since it was looked up");
				Assert.fail("Web page's HTM has been refreshed, changed or updated since it was looked up");

			}
		} catch (WebDriverException e) {
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].click()", element);

		}

	}
	
	public synchronized void click_dynamic_locator(String locatorName, String Locatorvalue) throws InterruptedException {
		

			element = getElementwithVariable(locatorName,Locatorvalue);
			element.click();
			System.out.println("Element path is : "+ element);

			

		}
    

	public synchronized void holdAndSelect(String locatorName, String Locatorname2) {
		this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());
		try {
			this.element = getElement(locatorName);
			this.elementnew= getElement(Locatorname2);
			element.click();
			new Actions(getDriver()).clickAndHold(element).moveToElement(elementnew).release().click(elementnew).build().perform();
			elementnew.sendKeys("Lead" + Keys.TAB);
			elementnew.sendKeys(Keys.TAB);
			// elementnew.sendKeys(Keys.ENTER);
			//lement.sendKeys(Keys.ENTER);

			BaseTest.test.log(LogStatus.INFO, "<b>Step No - " + StepNumber++ + "</b>",
					"<b>" + locatorName + "</b> " + "</b> " + " has been clicked successfully");
			this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (ElementNotVisibleException e) {
			BaseTest.test.log(LogStatus.FAIL, "<b>Step No - " + StepNumber++ + "</b>",
					"<b>" + locatorName + "</b> " + " has not been clicked because " + "<b>" + locatorName + "</b> "
							+ "</b> " + " is not visible on Page. So Selenium is not able to perform click.");
			Assert.fail("Unable to click the element");
			this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (StaleElementReferenceException e) {
			try {
				this.element = getElement(locatorName);
				element.click();

			} catch (StaleElementReferenceException ne) {
				BaseTest.test.log(LogStatus.FAIL, "<b>Step No - " + StepNumber++ + "</b>",
						"<b>" + locatorName + "</b> " + "</b> " + " has not been clicked because " + "<b>" + locatorName
						+ "</b> " + "</b> "
						+ " Web page's HTM has been refreshed, changed or updated since it was looked up");
				Assert.fail("Web page's HTM has been refreshed, changed or updated since it was looked up");
				this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());

			}
		} catch (WebDriverException e) {
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].click()", element);

		}

	}

	public synchronized void holdAndSelectNew(String locatorName, String Locatorname2, String Locator3) {
		this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());
		try {
			this.element = getElement(locatorName);
			this.elementnew= getElement(Locatorname2);
			element.click();
			new Actions(getDriver()).clickAndHold(element).click(elementnew).sendKeys("Lead").clickAndHold().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).release().build().perform();

			BaseTest.test.log(LogStatus.INFO, "<b>Step No - " + StepNumber++ + "</b>",
					"<b>" + locatorName + "</b> " + "</b> " + " has been clicked successfully");
			this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (ElementNotVisibleException e) {
			BaseTest.test.log(LogStatus.FAIL, "<b>Step No - " + StepNumber++ + "</b>",
					"<b>" + locatorName + "</b> " + " has not been clicked because " + "<b>" + locatorName + "</b> "
							+ "</b> " + " is not visible on Page. So Selenium is not able to perform click.");
			Assert.fail("Unable to click the element");
			this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (StaleElementReferenceException e) {
			try {
				this.element = getElement(locatorName);
				element.click();

			} catch (StaleElementReferenceException ne) {
				BaseTest.test.log(LogStatus.FAIL, "<b>Step No - " + StepNumber++ + "</b>",
						"<b>" + locatorName + "</b> " + "</b> " + " has not been clicked because " + "<b>" + locatorName
						+ "</b> " + "</b> "
						+ " Web page's HTM has been refreshed, changed or updated since it was looked up");
				Assert.fail("Web page's HTM has been refreshed, changed or updated since it was looked up");
				this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());

			}
		} catch (WebDriverException e) {
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].click()", element);

		}

	}

	public synchronized void jsClick(String locatorName) {
		this.element = getElement(locatorName);

		try {
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].click()", element);
			BaseTest.test.log(LogStatus.INFO, "<b>Step No - " + StepNumber++ + "</b>",
					"<b>" + locatorName + "</b> " + "</b> " + " has been clicked successfully");
		} catch (ElementNotVisibleException e) {
			BaseTest.test.log(LogStatus.FAIL, "<b>Step No - " + StepNumber++ + "</b>",
					"<b>" + locatorName + "</b> " + " has not been clicked because " + "<b>" + locatorName + "</b> "
							+ "</b> " + " is not visible on Page. So Selenium is not able to perform click.");
			Assert.fail("Unable to click the element");
		}
	}

	public synchronized void mouseClick(String locatorName) {

		try {
			this.element = getElement(locatorName);
			new Actions(getDriver()).click(element).build().perform();
			BaseTest.test.log(LogStatus.INFO, "<b>Step No - " + StepNumber++ + "</b>",
					"<b>" + locatorName + "</b> " + "</b> " + " has been clicked successfully");
		} catch (ElementNotVisibleException e) {
			BaseTest.test.log(LogStatus.FAIL, "<b>Step No - " + StepNumber++ + "</b>",
					"<b>" + locatorName + "</b> " + " has not been clicked because " + "<b>" + locatorName + "</b> "
							+ "</b> " + " is not visible on Page. So Selenium is not able to perform click.");
			Assert.fail("Element is not visible on page");
		} catch (StaleElementReferenceException e) {
			try {
				this.element = getElement(locatorName);
				element.click();

			} catch (StaleElementReferenceException ne) {
				BaseTest.test.log(LogStatus.FAIL, "<b>Step No - " + StepNumber++ + "</b>",
						"<b>" + locatorName + "</b> " + "</b> " + " has not been clicked because " + "<b>" + locatorName
						+ "</b> " + "</b> "
						+ " Web page's HTM has been refreshed, changed or updated since it was looked up");
				Assert.fail("Web page's HTM has been refreshed, changed or updated since it was looked up");
			}
		}

	}



	public synchronized void mouseDoubleClick(String locatorName) {
		try {
			this.element = getElement(locatorName);
			new Actions(getDriver()).doubleClick(element).build().perform();
			BaseTest.test.log(LogStatus.INFO, "<b>Step No - " + StepNumber++ + "</b>",
					"<b>" + locatorName + "</b> " + "</b> " + " has been clicked successfully");
		} catch (ElementNotVisibleException e) {
			BaseTest.test.log(LogStatus.FAIL, "<b>Step No - " + StepNumber++ + "</b>",
					"<b>" + locatorName + "</b> " + " has not been clicked because " + "<b>" + locatorName + "</b> "
							+ "</b> " + " is not visible on Page. So Selenium is not able to perform click.");
			Assert.fail("Element is not visible on page");
		} catch (StaleElementReferenceException e) {
			try {
				this.element = getElement(locatorName);
				element.click();

			} catch (StaleElementReferenceException ne) {
				BaseTest.test.log(LogStatus.FAIL, "<b>Step No - " + StepNumber++ + "</b>",
						"<b>" + locatorName + "</b> " + "</b> " + " has not been clicked because " + "<b>" + locatorName
						+ "</b> " + "</b> "
						+ " Web page's HTM has been refreshed, changed or updated since it was looked up");
				Assert.fail("Web page's HTM has been refreshed, changed or updated since it was looked up");
			}
		}
	}

	public synchronized void mouseContextClick(String locatorName) {
		try {
			this.element = getElement(locatorName);
			new Actions(getDriver()).contextClick(element).build().perform();
			BaseTest.test.log(LogStatus.INFO, "<b>Step No - " + StepNumber++ + "</b>",
					"<b>" + locatorName + "</b> " + "</b> " + " has been context clicked successfully");
		} catch (ElementNotVisibleException e) {
			BaseTest.test.log(LogStatus.FAIL, "<b>Step No - " + StepNumber++ + "</b>",
					"<b>" + locatorName + "</b> " + " has not been context clicked because " + "<b>" + locatorName + "</b> "
							+ "</b> " + " is not visible on Page. So Selenium is not able to perform context click.");
			Assert.fail("Element is not visible on page");
		} catch (StaleElementReferenceException ne) {
			BaseTest.test.log(LogStatus.FAIL, "<b>Step No - " + StepNumber++ + "</b>",
					"<b>" + locatorName + "</b> " + "</b> " + " has not been context clicked because " + "<b>" + locatorName
					+ "</b> " + "</b> "
					+ " Web page's HTM has been refreshed, changed or updated since it was looked up");
			Assert.fail("Web page's HTM has been refreshed, changed or updated since it was looked up");
		}
	}



	/**
	 **************************************************************************************************************
	 * @Function Name: setTextBoxValue
	 * @Description: This function will enter the value in textBox.
	 * @Param: TCID
	 * @param: locatorName
	 * @param: fieldName
	 * @Return:
	 * @Date:
	 * @Author:
	 **************************************************************************************************************
	 */
	public synchronized void setTextBoxValue( String TCID, String locatorName, String fieldName) {
		json = new JsonReaderfile();
		try {
			this.element = getElement(locatorName);

			element.clear();
			if (TCID.equalsIgnoreCase("Login")){
				element.sendKeys(json.DataReader(TCID, fieldName));
				BaseTest.test.log(LogStatus.INFO, "<b>Step No - " + StepNumber++ + "</b>",
						json.DataReader(TCID, fieldName) + " has been entered in text box : " + "<b>" + locatorName + "</b> " + "</b> "
								+ "   successfully.");
			}
			else{
				element.sendKeys(testDataMethodPick(fieldName));
				BaseTest.test.log(LogStatus.INFO, "<b>Step No - " + StepNumber++ + "</b>",(testDataMethodPick( fieldName))+ " has been entered in text box : " + "<b>" + locatorName + "</b> " + "</b> "
						+ "   successfully.");
			}
		} catch (ElementNotVisibleException e) {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style=" + '"' + "color:red" + '"' + ">Step No - " + StepNumber++ + "</b>",
					testDataMethodPick( fieldName) + " has been entered in text box : " + "<b>" + locatorName + "</b> " + "</b> "
							+ " because " + "<b>" + locatorName + "</b> " + "</b> "
							+ " is not visible on Page. So Selenium is not able to perform click.");
			Assert.fail("Element is not visible");
		} catch (StaleElementReferenceException e) {
			// getDriver().executeScript("arguments[0].setAttribute('value', '" +
			// longstring
			// +"')", inputField);
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].setAttribute('value', '" + (testDataMethodPick( fieldName)) + "')",
					element);
		}

	}

	public synchronized void setTextBoxValue(String locatorName, String fieldName) {
		String textToInput = "";
		json = new JsonReaderfile();
		try {
			this.element = getElement(locatorName);

			textToInput = json.getTestCaseData(fieldName);
			element.clear();
			element.sendKeys(textToInput);
			BaseTest.test.log(LogStatus.INFO, "<b>Step No - " + StepNumber++ + "</b>",
					textToInput + " has been entered in text box : " + "<b>" + locatorName + "</b> " + "</b> "
							+ "   successfully.");
		} catch (ElementNotVisibleException e) {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style=" + '"' + "color:red" + '"' + ">Step No - " + StepNumber++ + "</b>",
					textToInput + " has been entered in text box : " + "<b>" + locatorName + "</b> " + "</b> "
							+ " because " + "<b>" + locatorName + "</b> " + "</b> "
							+ " is not visible on Page. So Selenium is not able to perform click.");
			Assert.fail("Element is not visible");
		} catch (StaleElementReferenceException e) {
			// getDriver().executeScript("arguments[0].setAttribute('value', '" +
			// longstring
			// +"')", inputField);
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].setAttribute('value', '" + textToInput + "')",
					element);
		}

	}

	public synchronized By getLocatorBy(String locatorName, String locatorType, String locatorValue) {
		By locatorBy = null;
		try {
			switch (locatorType.trim().toLowerCase()) {
			case "xpath":
				locatorBy = By.xpath(locatorValue);
				break;
			case "css":
				locatorBy = By.cssSelector(locatorValue);
				break;
			case "id":
				locatorBy = By.id(locatorValue);
				break;
			case "name":
				locatorBy = By.name(locatorValue);
				break;
			case "linktext":
				locatorBy = By.linkText(locatorValue);
				break;
			case "class":
				locatorBy = By.className(locatorValue);
				break;
			case "tag":
				locatorBy = By.tagName(locatorValue);
				break;
			case "plinktext":
				locatorBy = By.partialLinkText(locatorValue);
				break;
			}
		} catch (Exception e) {

		}

		return locatorBy;
	}

	// ------------------------ Start Drop
	// Down-----------------------------------
	public synchronized Select select(String locatorName) {
		Select selectElement = null;
		this.element = getElement(locatorName);
		System.out.println("Checking for the value  " + element.getText());
		try {
			selectElement = new Select(element);
		} catch (UnexpectedTagNameException e) {
			Assert.fail("Element " + locatorName
					+ " was not with select tag name   Error Message UnexpectedTagNameException  -->"
					+ e.getStackTrace());
		}
		return selectElement;
	}

	public synchronized void compareValueFromDropDown(String locatorName, String compareText) {
        List<WebElement> options = select(locatorName).getAllSelectedOptions(); 
    for (WebElement option : options){
        if (option.getText().equals(compareText)){
        	Assert.assertEquals(option.getText(), equals(compareText), "Text entered is equal to to the comapred text");
        }
    }
}
	public synchronized void deselectAll(String locatorName) {
		select(locatorName).deselectAll();
		this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());
	}

	public synchronized void deselectByIndex(String locatorName, int index) {
		select(locatorName).deselectByIndex(index);
		this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());
	}

	public synchronized void deselectByValue(String locatorName, String value) {
		select(locatorName).deselectByValue(value);
		this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());
	}

	public synchronized void deselectByVisibleText(String locatorName, String text) {
		select(locatorName).deselectByVisibleText(text);
		this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());
	}

	public synchronized List<WebElement> getAllSelectedOptions(String locatorName) {
		this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());
		return (select(locatorName).getAllSelectedOptions());
	}

	public synchronized WebElement getFirstSelectedOption(String locatorName) {
		// select(locatorName).getOptions().get()
		return select(locatorName).getFirstSelectedOption();
	}

	public synchronized String getSelectedOptionValue(String locatorName) {

		element = getFirstSelectedOption(locatorName);
		String value = element.getText();
		return value;
	}

	// All options belonging to this select tag
	public synchronized List<WebElement> getOptions(String locatorName) {
		return select(locatorName).getOptions();
	}

	public synchronized int getListSize(String locatorName) {
		this.element = getElement(locatorName);
		Select se = new Select(element);
		List<WebElement> l_size = se.getOptions();

		int List_size = l_size.size();
		return List_size;
	}

	public synchronized boolean isMultiple(String locatorName) {
		return select(locatorName).isMultiple();
	}

	// index start from 0 to n-1
	public synchronized void selectByIndex(String locatorName, int index) {
		this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());
		select(locatorName).selectByIndex(index);
	}

	public synchronized void selectByValue(String locatorName, String value) throws InterruptedException {
		
		select(locatorName).selectByValue(value);		
	}
	
	public synchronized void selectByValueFromTestData(String locatorName, String TestDataValidationValue) throws InterruptedException {
		
		String textToSelect = "";
		textToSelect = testDataMethodPick( TestDataValidationValue);
		select(locatorName).selectByValue(textToSelect);		
	}

	

	public synchronized void selectByVisibleText(String locatorName, String fieldName) {
		String textToSelect = "";
		json = new JsonReaderfile();
		this.element = getElement(locatorName);
		textToSelect = testDataMethodPick( fieldName);
		select(locatorName).selectByVisibleText(textToSelect);
		BaseTest.test.log(LogStatus.INFO, "<b>Step No - " + StepNumber++ + "</b>",
				textToSelect + " has been selected in DropDown Box : " + "<b>" + locatorName + "</b> " + "</b> "
						+ "   successfully.");

	}


	public synchronized void selectByVisibleTextDirectly(String locatorName, String textToSelect) {
		this.element = getElement(locatorName);
		select(locatorName).selectByVisibleText(textToSelect);
		BaseTest.test.log(LogStatus.INFO, "<b>Step No - " + StepNumber++ + "</b>",
				textToSelect + " has been selected in DropDown Box : " + "<b>" + locatorName + "</b> " + "</b> "
						+ "   successfully.");
	}


	public synchronized String getOptionTextByIndex(String locatorName, int index) {
		this.element = getElement(locatorName);
		return select(locatorName).getOptions().get(index).getText();
	}

	public synchronized void getDisabledOptions(String locatorName, int index) {
		this.element = getElement(locatorName);
		List<WebElement> options = select(locatorName).getOptions();
		try {
			String isDisabled = options.get(index).getAttribute("disabled");
			if (isDisabled.equalsIgnoreCase("true")){
				BaseTest.test.log(LogStatus.PASS,
						"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>Step No - " + StepNumber++
						+ "</b>" + "</b>",
						"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>" + locatorName + "</b> "
								+ "</b> " + "</b>" + " Text Validation Passed" + ".  actual dropdown value: [<b>"
								+ options.get(index).getText() + "</b>]  is disabled");
				Assert.assertTrue(options.get(index).getAttribute("disabled").equalsIgnoreCase("true"), "Option " + options.get(index).getText() + " is validated succesfully as disabled");
			}
			else {
				BaseTest.test.log(LogStatus.FAIL,
						"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
						+ "</b>" + "</b>",
						"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>" + locatorName + "</b> "
								+ "</b> " + "</b>" + " Text Validation Failed" + ".  actual dropdown value: [<b>"
								+ options.get(index).getText() + "</b>]  is not disabled");
				// Assert.assertEquals(actualValue, expectedValue);
				Assert.fail("Option " + options.get(index).getText() + " is found to be enabled. Expected the option to be disabled");
			}
		}
		catch (Exception ex) {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Index not found");
			Assert.fail("Index/Option not found. Please enter correct index");
		}
	}


	public synchronized void selectByDynamicText(String locatorName, String value) {
		// String textToSelect="";
		this.element = getElement(locatorName);
		// textToSelect=XLReader.TestCaseDataMap.get(fieldName);
		select(locatorName).selectByVisibleText(value);
		BaseTest.test.log(LogStatus.INFO, "<b>Step No - " + StepNumber++ + "</b>",
				value + " has been selected in DropDown Box : " + "<b>" + locatorName + "</b> " + "</b> "
						+ "   successfully.");

	}

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

	public synchronized void validateOptionExist(String locatorName, String visibleText) {
		for (WebElement option : getOptions(locatorName)) {
			String actualValue = option.getText().trim();
			this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());
			if (actualValue.equals(visibleText)) {
				Assert.assertEquals(actualValue, visibleText);
				return;
			}
		}
		Assert.fail(visibleText + " is not exist on the given locator " + locatorName);
	}

	// ---------------------- End Drop Down-----------------------------------

	public synchronized void browseURL(String url) {
		getDriver().get(url);
		this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());
	}

	public synchronized void navigate(String url) {
		getDriver().navigate().to(url);
		//this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());
	}

	public synchronized void maximizeWindow() {
		getDriver().manage().window().maximize();
	}

	public synchronized void maximizeWindowwithGivenDimension(int width, int height) {
		getDriver().manage().window().setSize(new Dimension(width, height));
	}

	public ThreadLocal<WebDriver> openFirefoxBrowser() {
		return (SeleniumHelper.driver = new ThreadLocal<WebDriver>());
	}

	public ThreadLocal<WebDriver> openFirefoxBrowserWithProfile(String profileName) {
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myprofile = profile.getProfile(profileName);
		return (SeleniumHelper.driver = new ThreadLocal<WebDriver>());
	}

	public WebDriver openChromeBrowser() {
		return (getDriver());
	}

	public WebDriver openIEBrowser() {
		return (getDriver());
	}

	public static void extentValidation(ExtentTest extent, String status, String expected, String actual) {
		if (status.equalsIgnoreCase("failed")) {
			extent.log(LogStatus.FAIL, "<b style=" + '"' + "color:red" + '"' + ">Step No-1</b>",
					"<b>ACTUAL:</b>" + "<b style=" + '"' + "font-size:15px" + '"' + ">" + actual + "</b>"
							+ "  ,  <b>EXPECTED: </b>" + "<b style=" + '"' + "font-size:14px" + '"' + ">" + expected
							+ "</b>");
			Assert.fail("extentValidation");
		} else {
			extent.log(LogStatus.PASS, "<b color=" + '"' + "green" + '"' + ">Step No-1</b>",
					"Expected: " + expected + "  , Actual:" + actual);

		}
	}

	public synchronized void doubleClick(String locatorName) {
		this.element = getElement(locatorName);
		Actions action = new Actions(getDriver()).doubleClick(element);
		action.build().perform();
		this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());
	}

	// -------------------------- Start Click
	// button----------------------------------

	// ---------------------------------- Start
	// table-----------------------------------
	public synchronized void table(String locatorName) {
		WebElement htmltable = getElement(locatorName);
		List<WebElement> rows = htmltable.findElements(By.tagName("tr"));
		for (int rnum = 0; rnum < rows.size(); rnum++) {
			List<WebElement> columns = rows.get(rnum).findElements(By.tagName("td"));
			for (int cnum = 0; cnum < columns.size(); cnum++) {

			}
		}

	}
	// ---------------------------------- End
	// Table----------------------------------

	// ------------------------- Start Close browser -------------------
	public synchronized void closeCurrentWindow() {
		getDriver().close();
	}

	public synchronized void closeAllWindow() {
		getDriver().quit();
	}

	public synchronized void closeChromeInstance() {
		try {
			Runtime.getRuntime().exec("taskkill /im chromegetDriver().exe /f");
			Runtime.getRuntime().exec("taskkill /im chrome.exe /f");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// ---------------------------------- End Close browser -------------------

	public synchronized void refresh() {
		getDriver().navigate().refresh();
	}

	public synchronized void refreshByPhysicalKey() {
		Actions actions = new Actions(getDriver());
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.F5).perform();
	}

	public synchronized void forward() {
		getDriver().navigate().forward();
	}

	public synchronized void back() {
		getDriver().navigate().back();
	}

	// ------------------------------- Start Cookie---------------------------

	public synchronized void addCookie(String cookieName, String cookieValue) {
		Cookie name = new Cookie(cookieName, cookieValue);
		getDriver().manage().addCookie(name);
	}

	public synchronized void deleteCookieByName(String cookieName) {
		getDriver().manage().deleteCookieNamed(cookieName);
	}

	public synchronized void deleteAllCookies() {
		getDriver().manage().deleteAllCookies();
	}

	public synchronized Cookie getCookieByName(String cookieName) {
		return (getDriver().manage().getCookieNamed(cookieName));
	}

	public synchronized Set<Cookie> getAllCookies() {
		return (getDriver().manage().getCookies());
	}

	// ------------------------------- End Cookie ----------------------------
	// ------------------------------- Read Property File --------------------
	public synchronized String readPropertyFile(File file, String key) {
		Properties prop = new Properties();
		InputStream input = null;
		String result;
		try {
			input = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Get the property value and print it out
		result = prop.getProperty(key);
		try {
			input.close();
		} catch (Exception e) {
		}

		return result;

	}

	public synchronized List<WebElement> getAnchorTagsList() {
		return (getDriver().findElements(By.tagName("a")));
	}

	public synchronized void holdOn(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 **************************************************************************************************************
	 * @Function Name: waitForBrowserToLoadCompletely
	 * @Description: This function will take the locator name and wait until the
	 *               browser load completely.
	 * @Param:
	 * @Return:
	 * @Date:
	 * @Author:
	 **************************************************************************************************************
	 */
	public synchronized void waitForBrowserToLoadCompletely() {
		String state = null;
		String oldstate = null;
		try {
			System.out.print("Waiting for browser loading to complete");
			int i = 0;
			while (i < 5) {
				Thread.sleep(1000);
				state = ((JavascriptExecutor) getDriver()).executeScript("return document.readyState;").toString();
				System.out.print("." + Character.toUpperCase(state.charAt(0)) + ".");
				if (state.equals("interactive") || state.equals("loading"))
					break;
				/*
				 * If browser in 'complete' state since last X seconds. Return.
				 */

				if (i == 1 && state.equals("complete")) {
					System.out.println();
					return;
				}
				i++;
			}
			i = 0;
			oldstate = null;
			Thread.sleep(2000);

			/*
			 * Now wait for state to become complete
			 */
			while (true) {
				state = ((JavascriptExecutor) getDriver()).executeScript("return document.readyState;").toString();
				System.out.print("." + state.charAt(0) + ".");
				if (state.equals("complete"))
					break;

				if (state.equals(oldstate))
					i++;
				else
					i = 0;
				/*
				 * If browser state is same (loading/interactive) since last 60
				 * secs. Refresh the page.
				 */
				if (i == 15 && state.equals("loading")) {
					System.out.println("\nBrowser in " + state + " state since last 60 secs. So refreshing browser.");
					getDriver().navigate().refresh();
					System.out.print("Waiting for browser loading to complete");
					i = 0;
				} else if (i == 6 && state.equals("interactive")) {
					System.out.println(
							"\nBrowser in " + state + " state since last 30 secs. So starting with execution.");
					return;
				}

				Thread.sleep(1000);
				oldstate = state;

			}
			System.out.println();

		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}

	}

	/**
	 **************************************************************************************************************
	 * @Function Name: waitForElementVisibility
	 * @Description: This function will take the locator name and wait until
	 *               that locator presents on the page.
	 * @Param: String locatorName
	 * @Return: void
	 * @Date:
	 * @Author:
	 **************************************************************************************************************
	 */
	public synchronized void waitForElementInvisibility(String locatorName) {
		json = new JsonReaderfile();
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		String locatorValue = json.getLocator(locatorName)[1];
		String locatorType = json.getLocator(locatorName)[0];
		By locator = getLocatorBy(locatorName, locatorType, locatorValue);

		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	/**
	 **************************************************************************************************************
	 * @Function Name: waitForElementVisibility
	 * @Description: This function will take the locator name and wait until
	 *               that locator presents on the page.
	 * @Param: String locatorName
	 * @Return: void
	 * @Date:
	 * @Author:
	 **************************************************************************************************************
	 */
	public synchronized void waitForElementVisibility(String locatorName) {
		json = new JsonReaderfile();
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		String locatorValue = json.getLocator(locatorName)[1];
		String locatorType = json.getLocator(locatorName)[0];
		By locator = getLocatorBy(locatorName, locatorType, locatorValue);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	/**
	 **************************************************************************************************************
	 * @Function Name: waitForElementPresence
	 * @Description: This function will take the locator name and wait until
	 *               that locator presents on the page.
	 * @Param: String locatorName
	 * @Return: void
	 * @Date:
	 * @Author:
	 **************************************************************************************************************
	 */
	public synchronized void waitForElementPresence(String locatorName) {
		json = new JsonReaderfile();
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		String locatorValue = json.getLocator(locatorName)[1];
		String locatorType = json.getLocator(locatorName)[0];
		By locator = getLocatorBy(locatorName, locatorType, locatorValue);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	// ---------------------------------------------- Start
	// Scrolling---------------------------------------------------
	public synchronized void scrollingToBottomofAPageUsingJS() {
		((JavascriptExecutor) getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());
	}

	public synchronized void scrollingToBottomofAPageUsingAction() {
		Actions actions = new Actions(getDriver());
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());
	}

	public synchronized void scrollingToElementofAPage(String locatorName) {
		this.element = getElement(locatorName);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();", element);
		this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());
	}

	public synchronized void scrollingByCoordinatesofAPage(int xAxis, int yAxis) {
		((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(" + xAxis + "," + yAxis + ")");
		this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());
	}

	// ------------------------------- End
	// Scrolling-------------------------------------------------

	public synchronized void dragAndDrop(String sourcelocatorName, String destinationlocatorName) {
		(new Actions(getDriver())).dragAndDrop(getElement(sourcelocatorName), getElement(destinationlocatorName)).perform();
		this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());
	}

	public synchronized boolean checkIsAlertPresent() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 300);

		if (wait.until(ExpectedConditions.alertIsPresent()) == null) {
			Assert.fail("alert was not present");
			return false;
		} else {
			System.out.println("Alert is present");
			this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());
			return true;
		}

	}

	/**
	 **************************************************************************************************************
	 * @Function Name: getAlertText
	 * @Description: This function will get the text of alert.
	 * @Param: String date
	 * @Param :
	 * @Return: alertMsg
	 * @Date:
	 * @Author:
	 **************************************************************************************************************
	 */
	public synchronized String getAlertText() {

		String alertMsg = "";
		if (checkIsAlertPresent()) {
			Alert alert = getDriver().switchTo().alert();
			alertMsg = alert.getText();
			alertAccept();
			this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		return alertMsg;
	}

	public synchronized void validateTextOnAlert(String expectedText) {
		checkIsAlertPresent();
		Alert alert = getDriver().switchTo().alert();
		Assert.assertTrue(alert.getText().contains(expectedText));
		this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());
	}

	public synchronized void alertAccept() {
		if (checkIsAlertPresent()) {

			Alert alert = getDriver().switchTo().alert();
			this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());
			alert.accept();
		}
	}

	// ----------------Switching focus from one window to
	// another---------------------------------
	/**
	 **************************************************************************************************************
	 * @Function Name: switchFocusOnWindowTabByTitle
	 * @Description: this function switch focus from one window to another by
	 *               Title.
	 * @Param: windowTabTitle
	 * @Return:
	 * @Date:
	 * @Author: Shailendra
	 **************************************************************************************************************
	 */
	public synchronized void switchFocusOnWindowTabByTitle(String windowTabTitle) {
		Set<String> setHndlValues = getDriver().getWindowHandles();
		for (String handleValue : setHndlValues) {
			getDriver().switchTo().window(handleValue);
			this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());
			String title = getDriver().getTitle();
			if (title.equalsIgnoreCase(windowTabTitle)) {
				break;
			}
		}

	}

	// this function switch focus from one window to another by Partial Title.
	public synchronized void switchFocusOnWindowTabByPartialTitle(String windowTabPartialTitle) {
		Set<String> setHndlValues = getDriver().getWindowHandles();
		for (String handleValue : setHndlValues) {
			getDriver().switchTo().window(handleValue);
			this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());
			String title = getDriver().getTitle();
			if (title.trim().toLowerCase().contains(windowTabPartialTitle.trim().toLowerCase())) {
				break;
			}
		}

	}

	// this function switch focus from one window to another by Partial Url..
	public synchronized void switchFocusOnWindowTabByPartialURL(String partialURL) {
		Set<String> setHndlValues = getDriver().getWindowHandles();
		for (String handleValue : setHndlValues) {
			getDriver().switchTo().window(handleValue);
			this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());
			String url = getDriver().getCurrentUrl();
			if (url.trim().toLowerCase().contains(partialURL.trim().toLowerCase())) {
				break;
			}
		}
	}

	// this function switch focus from one window to another by Url.
	public synchronized void switchFocusOnWindowTabByURL(String URL) {
		Set<String> setHndlValues = getDriver().getWindowHandles();
		for (String handleValue : setHndlValues) {
			getDriver().switchTo().window(handleValue);
			this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());
			String url = getDriver().getCurrentUrl();
			if (url.trim().toLowerCase().equalsIgnoreCase(URL.trim().toLowerCase())) {
				break;
			}
		}
	}

	/**
	 **************************************************************************************************************
	 * @Function Name: validateTextBoxValue
	 * @Description: This function will validate the text box value
	 * @Param: locatorName
	 * @Param : validationName
	 * @Return: alertMsg
	 * @Date:
	 * @Author: Shailendra
	 **************************************************************************************************************
	 */
	public synchronized void validateTextBoxValue(String locatorName, String validationName) {
		json = new JsonReaderfile();
		this.element = getElement(locatorName);

		String actualValue = element.getAttribute("value");
		String expectedValue = json.getTestCaseData(validationName);
		if (expectedValue == null) {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Text Validation Failed"
							+ ". Expected Value is Null Please Match Test Data Column Name from script's field Name");
			// Assert.assertTrue(false);
			Assert.assertTrue(false,
					"Text Validation Failed. Expected Value is Null Please Match Test Data Column Name from script's field Name");
		}
		if (expectedValue.trim().equalsIgnoreCase(actualValue.trim())) {
			BaseTest.test.log(LogStatus.PASS,
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Text Validation Passed" + ".  actual textbox value: [<b>"
							+ actualValue + "</b>]  AND  expected text box value: [<b>" + expectedValue + "</b>]");
		} else {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Text Validation Failed " + ".  actual text text box value: [<b>"
							+ actualValue + "</b>]  AND  expected text box value: [<b>" + expectedValue + "</b>]");
			// Assert.assertEquals(actualValue, expectedValue);
			Assert.assertEquals(actualValue.trim(),expectedValue.trim(),  "Expected value: " + expectedValue.trim()
			+ " does not match with Actual value: " + actualValue.trim());
		}

	}

	public synchronized void validateTextBoxValue_Duplicate( String locatorName, String validationName) {
		json = new JsonReaderfile();
		this.element = getElement(locatorName);

		String actualValue = element.getAttribute("value");
		String expectedValue=testDataMethodPick(validationName);
		if (expectedValue == null) {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Text Validation Failed"
							+ ". Expected Value is Null Please Match Test Data Column Name from script's field Name");
			// Assert.assertTrue(false);
			Assert.assertTrue(false,
					"Text Validation Failed. Expected Value is Null Please Match Test Data Column Name from script's field Name");
		}
		if (expectedValue.trim().equalsIgnoreCase(actualValue.trim())) {
			BaseTest.test.log(LogStatus.PASS,
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Text Validation Passed" + ".  actual textbox value: [<b>"
							+ actualValue + "</b>]  AND  expected text box value: [<b>" + expectedValue + "</b>]");
		} else {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Text Validation Failed " + ".  actual text text box value: [<b>"
							+ actualValue + "</b>]  AND  expected text box value: [<b>" + expectedValue + "</b>]");
			// Assert.assertEquals(actualValue, expectedValue);
			Assert.assertEquals(actualValue.trim(),expectedValue.trim(), "Expected value: " + expectedValue.trim()
			+ " does not match with Actual value: " + actualValue.trim());
		}

	}

	public synchronized void validateTextBoxValueContains(String locatorName, String validationName) {
		json = new JsonReaderfile();
		this.element = getElement(locatorName);

		String actualValue = element.getAttribute("value");
//		String actualValue = element.getText();

		String expectedValue=testDataMethodPick(validationName);
		if (expectedValue == null) {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Text Validation Failed"
							+ ". Expected Value is Null Please Match Test Data Column Name from script's field Name");
			// Assert.assertTrue(false);
			Assert.assertTrue(false,
					"Text Validation Failed. Expected Value is Null Please Match Test Data Column Name from script's field Name");
		}
		if (actualValue.trim().toLowerCase().contains(expectedValue.trim().toLowerCase())) {
			BaseTest.test.log(LogStatus.PASS,
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Text Validation Passed" + ".  actual textbox value: [<b>"
							+ actualValue + "</b>]  AND  expected text box value: [<b>" + expectedValue + "</b>]");
		} else {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Text Validation Failed " + ".  actual text text box value: [<b>"
							+ actualValue + "</b>]  AND  expected text box value: [<b>" + expectedValue + "</b>]");
			Assert.fail("Text box doesn't contain expected value");

		}
	}

	public synchronized boolean validateActualAndExpectedTextDirectly(String locatorName, String Expected) {
		json = new JsonReaderfile();
		this.element = getElement(locatorName);
		String Actual = element.getText();
		System.out.println("actual Value is " +Actual);
		System.out.println("Expected Value is " +Expected);

		if (Expected.trim().equalsIgnoreCase(Actual.trim())) {
			this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());
			BaseTest.test.log(LogStatus.PASS,
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>" + "</b> " + "</b> " + "</b>"
							+ " Text Validation Passed" + ".  actual text: [<b>" + Actual + "</b>]  AND  expected: [<b>"
							+ Expected + "</b>]");
			Assert.assertTrue(Actual.equalsIgnoreCase(Expected));
			Assert.assertEquals(Actual, Expected, "expected value is matching with the actual value");

		} else {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>" + "</b> " + "</b> " + "</b>"
							+ " Text Validation Failed " + ".  actual text: [<b>" + Actual
							+ "</b>]  AND  expected: [<b>" + Expected + "</b>]");
			Assert.fail("Text Validation Failed");

		}
		Assert.assertEquals(Actual, Expected);
		return true;

	}
	
	public synchronized boolean validateActualAndExpectedTextDirectly_attribute(String locatorName, String Expected) {
		json = new JsonReaderfile();
		this.element = getElement(locatorName);
		String Actual = element.getAttribute("value");
		System.out.println("actual Value is " +Actual);
		System.out.println("Expected Value is " +Expected);

		if (Expected.trim().equalsIgnoreCase(Actual.trim())) {
			this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());
			BaseTest.test.log(LogStatus.PASS,
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>" + "</b> " + "</b> " + "</b>"
							+ " Text Validation Passed" + ".  actual text: [<b>" + Actual + "</b>]  AND  expected: [<b>"
							+ Expected + "</b>]");
			Assert.assertTrue(Actual.equalsIgnoreCase(Expected));
			Assert.assertEquals(Actual, Expected, "expected value is matching with the actual value");

		} else {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>" + "</b> " + "</b> " + "</b>"
							+ " Text Validation Failed " + ".  actual text: [<b>" + Actual
							+ "</b>]  AND  expected: [<b>" + Expected + "</b>]");
			Assert.fail("Text Validation Failed");

		}
		Assert.assertEquals(Actual, Expected);
		return true;

	}
	
	public synchronized boolean validateActualAndExpectedTextDirectly_attributeDisable(String locatorName, String Expected) {
		json = new JsonReaderfile();
		this.element = getElement(locatorName);
		String Actual = element.getAttribute("innerText");
		System.out.println("actual Value is " +Actual);
		System.out.println("Expected Value is " +Expected);

		if (Expected.trim().equalsIgnoreCase(Actual.trim())) {
			this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());
			BaseTest.test.log(LogStatus.PASS,
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>" + "</b> " + "</b> " + "</b>"
							+ " Text Validation Passed" + ".  actual text: [<b>" + Actual + "</b>]  AND  expected: [<b>"
							+ Expected + "</b>]");
			Assert.assertTrue(Actual.equalsIgnoreCase(Expected));
			Assert.assertEquals(Actual, Expected, "expected value is matching with the actual value");

		} else {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>" + "</b> " + "</b> " + "</b>"
							+ " Text Validation Failed " + ".  actual text: [<b>" + Actual
							+ "</b>]  AND  expected: [<b>" + Expected + "</b>]");
			Assert.fail("Text Validation Failed");

		}
		Assert.assertEquals(Actual, Expected);
		return true;

	}
	
	public synchronized boolean validateActualAndExpectedTextDirectly_attributevalue(String locatorName, String Expected, String type) {
		json = new JsonReaderfile();
		this.element = getElement(locatorName);
		String Actual = element.getAttribute(type);
		System.out.println("actual Value is " +Actual);
		System.out.println("Expected Value is " +Expected);

		if (Expected.trim().equalsIgnoreCase(Actual.trim())) {
			this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());
			BaseTest.test.log(LogStatus.PASS,
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>" + "</b> " + "</b> " + "</b>"
							+ " Text Validation Passed" + ".  actual text: [<b>" + Actual + "</b>]  AND  expected: [<b>"
							+ Expected + "</b>]");
			Assert.assertTrue(Actual.equalsIgnoreCase(Expected));
			Assert.assertEquals(Actual, Expected, "expected value is matching with the actual value");

		} else {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>" + "</b> " + "</b> " + "</b>"
							+ " Text Validation Failed " + ".  actual text: [<b>" + Actual
							+ "</b>]  AND  expected: [<b>" + Expected + "</b>]");
			Assert.fail("Text Validation Failed");

		}
		Assert.assertEquals(Actual, Expected);
		return true;

	}


	public synchronized void validateBeforeandAfterFieldValue(String locatorName, String validationName) {
		json = new JsonReaderfile();
		this.element = getElement(locatorName);

		String actualValue = element.getText();
		String expectedValue=testDataMethodPick(validationName);
		System.out.println(actualValue + "is the value retrived after saving");
		if (expectedValue == null) {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Text Validation Failed"
							+ ". Expected Value is Null Please Match Test Data Column Name from script's field Name");
			// Assert.assertTrue(false);
			Assert.assertTrue(false,
					"Text Validation Failed. Expected Value is Null Please Match Test Data Column Name from script's field Name");
		}
		if (expectedValue.trim().equals(actualValue.trim())) {
			this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());
			BaseTest.test.log(LogStatus.PASS,
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>" + "</b> " + "</b> " + "</b>"
							+ " Text Validation Passed" + ".  actual text: [<b>" + actualValue + "</b>]  AND  expected: [<b>"
							+ expectedValue + "</b>]");
			Assert.assertTrue(expectedValue.equalsIgnoreCase(actualValue));
			Assert.assertEquals(actualValue, expectedValue);
			Assert.assertTrue(true, "Actual and expected value is not same");
			
			
		} else {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Text Validation Failed " + ".  actual text text box value: [<b>"
							+ actualValue + "</b>]  AND  expected text box value: [<b>" + expectedValue + "</b>]");
			Assert.fail("Text box doesn't contain expected value");
			Assert.assertTrue(false, "Actual and expected value is same");


		}
	}

	public synchronized void alertDismiss() {
		checkIsAlertPresent();
		Alert alert = getDriver().switchTo().alert();
		alert.dismiss();
	}

	public synchronized void alertSendKeys(String value) {
		checkIsAlertPresent();
		Alert alert = getDriver().switchTo().alert();
		this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());
		alert.sendKeys(value);

	}

	public synchronized int getCurrentDate() {
		Calendar now = Calendar.getInstance();
		return (now.get(Calendar.DATE));
	}

	public synchronized int getCurrentMonth() {
		Calendar now = Calendar.getInstance();
		return (now.get(Calendar.MONTH) + 1);
	}

	public synchronized int getCurrentYear() {
		Calendar now = Calendar.getInstance();
		return (now.get(Calendar.YEAR));
	}

	// // ------------------------------- End Date ----------------------------
	//
	// // ------------------------------- Start Screen Short
	// // ----------------------------
	// public synchronized void getscreenshot() throws Exception {
	// File scrFile = ((TakesScreenshot)
	// driver).getScreenshotAs(OutputType.FILE);
	// // The below method will save the screen shot in d drive with name
	// // "screenshot.png"
	// FileUtils.copyFile(scrFile, new File("D:\\aaaaaaaaaaaaa.png"));
	// }

	public synchronized String getCurrentTime() {
		return LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm a"));
	}

	public synchronized String getPastTime(int hrs, int minute) {
		return LocalTime.now().minusHours(hrs).minusMinutes(minute).format(DateTimeFormatter.ofPattern("HH:mm a"));
	}

	public synchronized String getFutureTime(int hrs, int minute) {
		return LocalTime.now().plusHours(hrs).plusMinutes(minute).format(DateTimeFormatter.ofPattern("HH:mm a"));
	}

	public synchronized String getDuration(String st, String et) {
		LocalTime d1, d2;
		d1 = LocalTime.parse(st, DateTimeFormatter.ofPattern("HH:mm a"));
		d2 = LocalTime.parse(et, DateTimeFormatter.ofPattern("HH:mm a"));

		Duration duration = Duration.between(d1, d2);
		duration.getSeconds();
		LocalDateTime currentDate = LocalDateTime.of(2017, 1, 1, 0, 0, 0);
		currentDate = currentDate.plusSeconds(duration.getSeconds());
		return currentDate.format(DateTimeFormatter.ofPattern("HH:mm"));
	}

	public synchronized String getInnerText(String locatorName) {
		element = getElement(locatorName);
		if (element != null) {
			return element.getText();
		}
		return null;
	}

	public synchronized int getXcor(String locatorName) {
		return getElement(locatorName).getLocation().getX();
	}

	public synchronized int getYcor(String locatorName) {
		return getElement(locatorName).getLocation().getY();
	}

	// For taking ScreenShot
	public synchronized void takeScreenShot(String folderPath, String methodName) {
		System.out.println(methodName);
		try {
			Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(10)).takeScreenshot(getDriver());


			//File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File file = new File(folderPath + File.separator + "snapshots");
			if (file.exists() == false) {

				file.mkdir();
			}

			folderPath = folderPath + File.separator + "snapshots";
			methodName = getTimeStamp() + "_" + methodName;
			//FileUtils.copyFile(scrFile, new File(folderPath + "//" + methodName + ".png"));
			ImageIO.write(screenshot.getImage(),"PNG",new File(folderPath + File.separator +methodName+".png"));
			zoomIn();
			zoomout();
			System.out.println("***Placed screen shot ***");
			BaseTest.test.log(LogStatus.INFO,
					"Screencast: " + BaseTest.test.addScreenCapture("snapshots" + File.separator + methodName + ".png"));
		} catch (IOException e) {
			BaseTest.test.log(LogStatus.FAIL, e.getMessage());
			Assert.fail();
			e.printStackTrace();
		} catch (NoSuchWindowException e) {
			BaseTest.test.log(LogStatus.FAIL, e.getMessage());
			Assert.fail();
			e.printStackTrace();
		} catch (WebDriverException e) {
			BaseTest.test.log(LogStatus.FAIL, e.getMessage());
			Assert.fail();
			e.printStackTrace();
		} catch (Exception e) {
			BaseTest.test.log(LogStatus.FAIL, e.getMessage());
			Assert.fail();
			e.printStackTrace();
		}
	}

	/**
	 **************************************************************************************************************
	 * @Function Name: getScreenShot
	 * @Description: apture the screenshot and add it into the Extent report.
	 *               Capture screen shoot can be used to manually check
	 * @Param: methodName - Name of the captured file.
	 * @Return:
	 * @Date:
	 * @Author:
	 **************************************************************************************************************
	 */
	public synchronized void getScreenShot(String methodName) {
		File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String folderPath = BaseTest.folderPath;
		try {
			File file = new File(folderPath + File.separator + "snapshots");
			if (file.exists() == false) {
				file.mkdir();
			}
			folderPath = folderPath + File.separator + "snapshots";
			methodName = getTimeStamp() + "_" + methodName;
			FileUtils.copyFile(scrFile, new File(folderPath + File.separator + methodName + ".png"));
			System.out.println("***Placed screen shot ***");
			BaseTest.test.log(LogStatus.PASS, methodName,
					BaseTest.test.addScreenCapture("snapshots" + File.separator + methodName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public synchronized String GenerateRandomNumber(int charLength) {
		return String.valueOf(charLength < 1 ? 0
				: new Random().nextInt((9 * (int) Math.pow(10, charLength - 1)) - 1)
				+ (int) Math.pow(10, charLength - 1));
	}

	public synchronized String generateRandomString(int length) {
		StringBuilder str = new StringBuilder(RandomStringUtils.randomAlphabetic(length));
		int idx = str.length() - 8;

		while (idx > 0) {
			str.insert(idx, " ");
			idx = idx - 8;
		}
		return str.toString();
	}

	public synchronized static String getTimeStamp() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM_dd_yy-HH_mm_ss");
		return sdf.format(new Date());
	}

	// this method converts RGBA values to hex value. [color]

	/**
	 **************************************************************************************************************
	 * @Function Name: colorToHexValue
	 * @Description: this method converts RGBA values to hex value. [color]
	 * @Param:color
	 * @Return: hex
	 * @Date:
	 * @Author:
	 **************************************************************************************************************
	 */
	public synchronized String colorToHexValue(String color) {
		String hex = null;
		;
		if (!color.equals("Transparent")) {
			String s1 = color.substring(5);
			StringTokenizer st = new StringTokenizer(s1);
			int r = Integer.parseInt(st.nextToken(",").trim());
			int g = Integer.parseInt(st.nextToken(",").trim());
			int b = Integer.parseInt(st.nextToken(",").trim());
			Color c = new Color(r, g, b);
			hex = "#" + Integer.toHexString(c.getRGB()).substring(2);
		} else {
			System.out.println("Color is transparent.");
			hex = "transparent";
		}
		return hex;
	}

	// It generates random number between min and max
	public synchronized int generateRandom(int min, int max) {
		int randomNo = 0;
		if (max == min) {
			randomNo = min;
		} else if (max < min) {
			System.out.println("Invalid Range for Random Numbers, Max should be greater than min");
		} else {
			Random rn = new Random();
			randomNo = rn.nextInt(max) + min;
		}
		return randomNo;
	}

	public synchronized void hoverElement(WebElement element) {
		Actions actions = new Actions(getDriver());
		actions.moveToElement(element).build().perform();
		this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());
	}

	public synchronized void switchToFrameByLocator(String locatorName) {
		// TODO Auto-generated method stub

		getDriver().switchTo().frame(getElement(locatorName));
		this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());
	}

	public synchronized void switchToFrameByIndex(int indexNo) {
		// TODO Auto-generated method stub

		getDriver().switchTo().frame(indexNo);
		this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());

	}

	/**
	 **************************************************************************************************************
	 * @Function Name: generateDate
	 * @Description: Method will be used to Generate todays\Yesterdays/Tomorrow
	 *               dates in desired format.
	 * @Param: DATE_FORMAT
	 * @Param : whatDay
	 * @Return: Date
	 * @Date:
	 * @Author:
	 **************************************************************************************************************
	 */
	public static String generateDate(String DATE_FORMAT, String whatDay) {
		String Date = null;
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		Calendar c1 = Calendar.getInstance();
		if (whatDay.equalsIgnoreCase("todays")) {
			c1 = Calendar.getInstance(); // today
			Date = sdf.format(c1.getTime());
			System.out.println("Today is " + Date);
		} else if (whatDay.equalsIgnoreCase("yesterdays")) {
			c1.add(Calendar.DATE, -1);
			Date = sdf.format(c1.getTime());
			System.out.println("Today is " + Date);
		} else if (whatDay.equalsIgnoreCase("tomorrow")) {
			c1.add(Calendar.DATE, 1);
			Date = sdf.format(c1.getTime());
			System.out.println("Today is " + Date);
		}

		return Date;
	}

	/**
	 **************************************************************************************************************
	 * @Function Name: getPrevious_dateFormatDDMMYYYY
	 * @Description: This function Will return a previous date based on the
	 *               parameter in mm/dd/yyyy format
	 * @Param: Number of days
	 * @Param : N/A
	 * @Return: Returns a String
	 * @Date:
	 * @Author:
	 **************************************************************************************************************
	 */

	public static String getPrevious_dateFormatDDMMYYYY(int noOfDays) {

		// String date = null;
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

		Date date = new Date();
		String todate = dateFormat.format(date);

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -noOfDays);
		Date todate1 = cal.getTime();
		String fromdate = dateFormat.format(todate1);
		return fromdate;
	}

	/**
	 **************************************************************************************************************
	 * @Function Name: getFuture_dateFormatDDMMYYYY
	 * @Description: This function Will return a previous date based on the
	 *               parameter in mm/dd/yyyy format
	 * @Param: Number of days
	 * @Param : N/A
	 * @Return: Returns a String
	 * @Date:
	 * @Author:
	 **************************************************************************************************************
	 */

	public synchronized String getFuture_dateFormatDDMMYYYY(int noOfDays) {

		// String date = null;
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

		Date date = new Date();
		String todate = dateFormat.format(date);

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, +noOfDays);
		Date todate1 = cal.getTime();
		String fromdate = dateFormat.format(todate1);
		return fromdate;
	}

	/**
	 **************************************************************************************************************
	 * @Function Name: getCurrentDate_DDMMYYYY()
	 * @Description: This function Will return current date in mm/dd/yyyy format
	 * @Param: N/A
	 * @Param : N/A
	 * @Return: Returns a String
	 * @Date:
	 * @Author:
	 **************************************************************************************************************
	 */

	public synchronized String getCurrentDate_DDMMYYYY() {

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		dateFormat.setTimeZone(TimeZone.getTimeZone("America/New_York"));
		Date date = new Date();
		String todate = dateFormat.format(date);
		return todate;
	}

	/**
	 **************************************************************************************************************
	 * @Function Name: compareDate
	 * @Description: This function will use to compare the date.
	 * @Param: origianalDate
	 * @Param: compareDate
	 * @Return:
	 * @Date:
	 * @Author:
	 **************************************************************************************************************
	 */
	public synchronized void compareDate(String origianalDate, String compareDate) {

		Date first_Date = convertString_To_Date(origianalDate);
		Date Second_Date = convertString_To_Date(compareDate);
		if (first_Date.compareTo(Second_Date) == 0) {
			BaseTest.test.log(LogStatus.INFO, "<b>Step No - " + StepNumber++ + "</b>", origianalDate
					+ " has been compared with" + " : " + "<b>" + compareDate + "</b> " + "   successfully.");
			this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());

		} else {
			BaseTest.test.log(LogStatus.INFO, "<b>Step No - " + StepNumber++ + "</b>",
					origianalDate + " has been compared And Did not match With" + " : " + "<b>" + compareDate + "</b>");

		}
	}

	/**
	 **************************************************************************************************************
	 * @Function Name: convertString_To_Date
	 * @Description: This function will convert string to date format
	 * @Param: String date
	 * @Return: startDate
	 * @Date:
	 * @Author:
	 **************************************************************************************************************
	 */
	public synchronized Date convertString_To_Date(String strValue) {
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date startDate = null;
		try {
			startDate = df.parse(strValue);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return startDate;
	}

	/**
	 **************************************************************************************************************
	 * @Function Name: retrieveLocatorValue
	 * @Description: This function will return the locator value by providing
	 *               the locator name
	 * @Param: fieldName
	 * @Return: locatorValue
	 * @Date:
	 * @Author:
	 **************************************************************************************************************
	 */

	public synchronized String retrieveLocatorValue(String fieldName) {
		json = new JsonReaderfile();
		String locatorValue = "";
		locatorValue = json.getLocator(fieldName)[1];

		return locatorValue;

	}

	/**
	 **************************************************************************************************************
	 * @Function Name: datePickFromCalendar
	 * @Description: This function will pick a day from calendar from given day
	 *               parameter
	 * @Param: locatorName
	 * @Param : dayFromCalendar
	 * @Return: N/A
	 * @Date:
	 * @Author:
	 **************************************************************************************************************
	 */
	public synchronized void datePickFromCalendar(String locatorName, String dayFromCalendar) {
		try {
			this.element = getElement(locatorName);
			List<WebElement> columns = element.findElements(By.tagName("td"));
			for (WebElement cell : columns) 
			{
				System.out.println(cell.getText());
				if (cell.getText().equals(dayFromCalendar)) 
				{
					cell.click();
					this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());
					break;
				}
			}
		} catch (Exception e) {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + " Element Not Found in Page Source");
			Assert.fail();

		}
	}


	/**
	 **************************************************************************************************************
	 * @Function Name: clearEditBox
	 * @Description: This function will Any value from Edit box
	 * @Param: locatorName
	 * @Return: N/A
	 * @Date:
	 * @Author:
	 **************************************************************************************************************
	 */
	public synchronized void clearEditBox(String locatorName) {

		try {
			this.element = getElement(locatorName);
			element.clear();
			BaseTest.test.log(LogStatus.INFO, "<b>Step No - " + StepNumber++ + "</b>",
					"<b>" + locatorName + "</b> " + "</b> " + " has been cleared successfully");
		} catch (ElementNotVisibleException e) {
			BaseTest.test.log(LogStatus.FAIL, "<b>Step No - " + StepNumber++ + "</b>",
					"<b>" + locatorName + "</b> " + " has not been cleared because " + "<b>" + locatorName + "</b> "
							+ "</b> " + " is not visible on Page. So Selenium is not able to perform clear.");
			Assert.fail("Element is not visible");

		}
	}

	public synchronized void clearEditBoxByBackspace(String locatorName) {

		try {
			this.element = getElement(locatorName);
			element.click();
			hitBackspace();
			BaseTest.test.log(LogStatus.INFO, "<b>Step No - " + StepNumber++ + "</b>",
					"<b>" + locatorName + "</b> " + "</b> " + " has been cleared successfully");
		} catch (ElementNotVisibleException e) {
			BaseTest.test.log(LogStatus.FAIL, "<b>Step No - " + StepNumber++ + "</b>",
					"<b>" + locatorName + "</b> " + " has not been cleared because " + "<b>" + locatorName + "</b> "
							+ "</b> " + " is not visible on Page. So Selenium is not able to perform clear.");
			Assert.fail("Element is not visible");
		}
	}

	/**
	 **************************************************************************************************************
	 * @Function Name: CheckObjectExist
	 * @Description: This function will verify the object is displayed in the
	 *               app or not
	 * @Param: locatorName
	 * @Return: True or false
	 * @Date:
	 * @Author:
	 **************************************************************************************************************
	 */
	public synchronized boolean CheckObjectExist(String locatorName) {
		json = new JsonReaderfile();
		String locatorValue = json.getLocator(locatorName)[1];
		String locatorType = json.getLocator(locatorName)[0];
		By locator = getLocatorBy(locatorName, locatorType, locatorValue);
		Boolean isPresent = getDriver().findElements(locator).size() > 0;

		return isPresent;
	}

	/**
	 **************************************************************************************************************
	 * @Function Name: CheckObjectDisplay
	 * @Description: This function will verify the object is displayed in the
	 *               app or not
	 * @Param: locatorName
	 * @Return: True or false
	 * @Date:
	 * @Author:
	 **************************************************************************************************************
	 */
	public synchronized boolean CheckObjectDisplay(String locatorName) {
		boolean isDisplayed = false;
		json = new JsonReaderfile();
		String locatorValue = json.getLocator(locatorName)[1];
		String locatorType = json.getLocator(locatorName)[0];
		By locator = getLocatorBy(locatorName, locatorType, locatorValue);
		isDisplayed = getDriver().findElements(locator).size() > 0 | getDriver().findElement(locator).isDisplayed();
		this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());
		if (isDisplayed) {
			passTestMsg("Expected Element is Found in the page");
		} else {
			failTestMsg("Expected Element is Not Found in the page");
		}
		return isDisplayed;
	}

	/**
	 **************************************************************************************************************
	 * @Function Name: CheckObjectNotDisplay
	 * @Description: This function will verify the object is displayed in the
	 *               app or not
	 * @Param: locatorName
	 * @Param :
	 * @Return: True or false
	 * @Date:
	 * @Author:
	 **************************************************************************************************************
	 */
	public synchronized boolean CheckObjectNotDisplay(String locatorName) {
		boolean isDisplayed = false;
		json = new JsonReaderfile();
		String locatorValue = json.getLocator(locatorName)[1];
		String locatorType = json.getLocator(locatorName)[0];
		By locator = getLocatorBy(locatorName, locatorType, locatorValue);
		isDisplayed = getDriver().findElements(locator).size() > 0 ? getDriver().findElement(locator).isDisplayed() : false;
		this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());
		if (isDisplayed) {
			failTestMsg("Expected Element is found in the page");
			Assert.assertFalse(isDisplayed);
		} else {
			passTestMsg("Expected Element is not displayed  in the page");

		}
		return isDisplayed;
	}

	/**
	 **************************************************************************************************************
	 * @Function Name: validateTextBoxValueNotEquals
	 * @Description: This function will verify the textbox value is not the
	 *               expected one.
	 * @Param: TCID
	 * @Param: locatorName
	 * @Param: validationName
	 * @Return: N/A
	 * @Date:
	 * @Author:
	 **************************************************************************************************************
	 */
	public synchronized void validateTextBoxValueNotEquals( String locatorName, String validationName) {
		json = new JsonReaderfile();
		this.element = getElement(locatorName);

		String actualValue = element.getAttribute("value");
		String expectedValue=testDataMethodPick(validationName);
		if (expectedValue == null) {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Text Validation Failed"
							+ ". Expected Value is Null Please Match Test Data Column Name from script's field Name");
			// Assert.assertTrue(false);
			Assert.assertTrue(false,
					"Text Validation Failed. Expected Value is Null Please Match Test Data Column Name from script's field Name");
		}
		if (expectedValue.trim().equalsIgnoreCase(actualValue.trim())) {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Text Validation Failed. Actual And Expected Values are  matching"
							+ ".  actual textbox value: [<b>" + actualValue + "</b>]  AND  expected textbox value: [<b>"
							+ expectedValue + "</b>]");
		} else {
			BaseTest.test.log(LogStatus.PASS,
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Text Validation Passed. Actual And Expected Values are not matching "
							+ ".  actual textbox value: [<b>" + actualValue + "</b>]  AND  expected textbox value: [<b>"
							+ expectedValue + "</b>]");
			// Assert.assertNotEquals(actualValue, expectedValue);
			Assert.assertNotEquals(expectedValue.trim(), actualValue.trim(), "Expected value: " + expectedValue.trim()
			+ " does not match with Actual value: " + actualValue.trim());
		}

	}

	public synchronized void validateTextBoxValueNotEquals_Duplicate(String locatorName, String validationName) {
		json = new JsonReaderfile();
		this.element = getElement(locatorName);

		String actualValue = element.getAttribute("value");
		String expectedValue = json.getTestCaseData(validationName);
		if (expectedValue == null) {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Text Validation Failed"
							+ ". Expected Value is Null Please Match Test Data Column Name from script's field Name");
			// Assert.assertTrue(false);
			Assert.assertTrue(false,
					"Text Validation Failed. Expected Value is Null Please Match Test Data Column Name from script's field Name");
		}
		if (expectedValue.trim().equalsIgnoreCase(actualValue.trim())) {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Text Validation Failed. Actual And Expected Values are  matching"
							+ ".  actual textbox value: [<b>" + actualValue + "</b>]  AND  expected textbox value: [<b>"
							+ expectedValue + "</b>]");
			Assert.fail("Text Validation Failed");
		} else {
			BaseTest.test.log(LogStatus.PASS,
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Text Validation Passed. Actual And Expected Values are not matching "
							+ ".  actual textbox value: [<b>" + actualValue + "</b>]  AND  expected textbox value: [<b>"
							+ expectedValue + "</b>]");
			// Assert.assertNotEquals(actualValue, expectedValue);
			Assert.assertNotEquals(expectedValue.trim(), actualValue.trim(), "Expected value: " + expectedValue.trim()
			+ " does not match with Actual value: " + actualValue.trim());
		}

	}

	public synchronized void passTestMsg(String msg) {
		BaseTest.test.log(LogStatus.PASS, "<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">"
				+ "<b>Step No - " + StepNumber++ + "</b>" + "</b>", +'"' + ">" + "<b>" + msg + "</b>");

	}

	public synchronized void failTestMsg(String msg) {
		BaseTest.test.log(LogStatus.FAIL, "<b style=" + "color:red;" + ">" + "Step No - " + StepNumber++ + "</b>",
				"<b style=" + "color:red;" + ">" + msg + "</b>");
		// Assert.fail();
		Assert.fail(msg);
	}

	/**
	 **************************************************************************************************************
	 * @Function Name: HoverAndClick
	 * @Description: This function will Hover over and click on menu options
	 * @Param: Hoverlocator
	 * @Param: ClickLocator
	 * @Return: N/A
	 * @Date:
	 * @Author:
	 **************************************************************************************************************
	 */

	public synchronized void HoverAndClick(String Hoverlocator, String ClickLocator) throws Exception {

		WebElement menuElement = getElement(Hoverlocator);
		Actions builder = new Actions(getDriver());
		Thread.sleep(2000);
		builder.moveToElement(menuElement).build().perform();
		Thread.sleep(3000);
		BaseTest.test.log(LogStatus.INFO, "<b>Step No - " + StepNumber++ + "</b>",
				"<b>" + Hoverlocator + "</b> " + "</b> " + " has been clicked successfully");
		WebElement subElement = getElement(ClickLocator);
		builder.moveToElement(subElement).click().perform();
		Thread.sleep(2000);
		BaseTest.test.log(LogStatus.INFO, "<b>Step No - " + StepNumber++ + "</b>",
				"<b>" + ClickLocator + "</b> " + "</b> " + " has been clicked successfully");
	}

	public synchronized void hitEnter() {
		this.element.sendKeys(Keys.RETURN);
	}

	public synchronized void hitBackspace() {
		for (int i = 0; i <= 20; i++) {
			this.element.sendKeys(Keys.BACK_SPACE);
		}

	}

	/**
	 **************************************************************************************************************
	 * @Function Name: selectAutoCompleteItemByVisibleText
	 * @Description: Select an item by visible text on the auto complete
	 *               dropdown list
	 * @Param: locatorName
	 * @Param: fieldName
	 * @Return: N/A
	 * @Date:
	 * @Author:
	 **************************************************************************************************************
	 */
	public synchronized void selectAutoCompleteItemByVisibleText(String locatorName, String fieldName) {
		json = new JsonReaderfile();
		WebElement autoCompletedDropdown = getElement(locatorName);
		String visibleText = json.getTestCaseData(fieldName);
		List<WebElement> items = autoCompletedDropdown.findElements(By.cssSelector("li"));
		for (WebElement item : items) {
			String itemText = item.getText().trim();
			if (visibleText.equals(itemText)) {
				BaseTest.test.log(LogStatus.PASS,
						"<b style= " + '"' + "font-size: 12pt;color:green" + '"' + ">" + "<b>Step No - " + StepNumber++
						+ "</b>" + "</b>",
						"<b style= " + '"' + "font-size: 12pt;color:green" + '"' + ">" + "<b>" + locatorName + "</b> "
								+ "</b> " + "</b>" + " " + " selected with [<b>" + itemText + "</b>]");
				item.click();
				break;
			}
		}
	}

	public synchronized void selectAutoCompleteItemByVisibleText_Duplicate( String locatorName, String fieldName) {
		json = new JsonReaderfile();
		WebElement autoCompletedDropdown = getElement(locatorName);
		//String visibleText = ;
		List<WebElement> items = autoCompletedDropdown.findElements(By.cssSelector("li"));
		for (WebElement item : items) {
			String itemText = item.getText().trim();
			if (json.DataReader(Thread.currentThread().getStackTrace()[3].getMethodName(), fieldName).equals(itemText)) {
				BaseTest.test.log(LogStatus.PASS,
						"<b style= " + '"' + "font-size: 12pt;color:green" + '"' + ">" + "<b>Step No - " + StepNumber++
						+ "</b>" + "</b>",
						"<b style= " + '"' + "font-size: 12pt;color:green" + '"' + ">" + "<b>" + locatorName + "</b> "
								+ "</b> " + "</b>" + " " + " selected with [<b>" + itemText + "</b>]");
				item.click();
				break;
			}
		}
	}

	/**
	 **************************************************************************************************************
	 * @Function Name: switchToDefaultContent
	 * @Description: Switch To the Top (default) frame of the current page
	 * @Param: N/A
	 * @Return: N/A
	 * @Date:
	 * @Author:
	 ***/

	public synchronized void switchToDefaultContent() {
		getDriver().switchTo().defaultContent();
		this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());
	}

	public synchronized boolean getAlertStatus() {
		boolean foundAlert = false;
		WebDriverWait wait = new WebDriverWait(getDriver(),
				0 /* timeout in seconds */);
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());
			foundAlert = true;
		} catch (TimeoutException eTO) {
			foundAlert = false;
		}
		return foundAlert;
	}

	/**
	 **************************************************************************************************************
	 * @Function Name: getFirstDate_DDMMYYYY
	 * @Description: This function Will return First day of current month in
	 *               mm/01/yyyy format
	 * @Param:
	 * @Return: todate
	 * @Date:
	 * @Author:
	 **************************************************************************************************************
	 */

	public synchronized String getFirstDate_DDMMYYYY() {

		DateFormat dateFormat = new SimpleDateFormat("MM/01/yyyy");
		Date date = new Date();
		String todate = dateFormat.format(date);
		return todate;
	}

	/**
	 **************************************************************************************************************
	 * @Function Name: validateWindowTabTitle
	 * @Description: This function will verify that Actual & Expected Window
	 *               Title is Matching or not
	 * @Param: titleFieldName
	 * @Return:
	 * @Date:
	 * @Author:
	 **************************************************************************************************************
	 */
	public synchronized void validateWindowTab_PartialTitle(String titleFieldName) {
		// TODO Auto-generated method stub
		json = new JsonReaderfile();
		String expectedPartialTitle = json.getTestCaseData(titleFieldName);
		String actualTitle = getDriver().getTitle();
		System.out.println(actualTitle);
		if (actualTitle.trim().toUpperCase().contains(expectedPartialTitle.trim().toUpperCase())) {
			BaseTest.test.log(LogStatus.PASS,
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>" + titleFieldName + "</b> "
							+ "</b> " + "</b>" + " Window Tab Validation Passed. Title is matching"
							+ ".  actual title: [<b>" + actualTitle + "</b>]  AND  eexpected title: [<b>"
							+ expectedPartialTitle + "</b>]");
		} else {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>" + titleFieldName + "</b> "
							+ "</b> " + "</b>" + " Window Tab Validation Failed "
							+ ".  Title is not matching. actual title: [<b>" + actualTitle
							+ "</b>]  AND  expected title: [<b>" + expectedPartialTitle + "</b>]");
			// Assert.assertTrue(false);
			Assert.assertTrue(false, "Expected title: " + expectedPartialTitle.trim()
			+ " does not match with Actual title: " + actualTitle.trim());
		}
	}

	/**
	 **************************************************************************************************************
	 * @Function Name: validateWindowTab_PartialTitle_NoMatch
	 * @Description: This function will verify that Actual & Expected Window
	 *               Title is not Matching
	 * @Param: titleFieldName
	 * @Param :
	 * @Return:
	 * @Date:
	 * @Author:
	 **************************************************************************************************************
	 */
	public synchronized void validateWindowTab_PartialTitle_NoMatch(String titleFieldName) {
		// TODO Auto-generated method stub
		json = new JsonReaderfile();
		String expectedPartialTitle = json.getTestCaseData(titleFieldName);
		String actualTitle = getDriver().getTitle();
		if (actualTitle.trim().toUpperCase().contains(expectedPartialTitle.trim().toUpperCase()) == false) {
			BaseTest.test.log(LogStatus.PASS,
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>" + titleFieldName + "</b> "
							+ "</b> " + "</b>" + " Window Tab Validation Passed. Title is not matching"
							+ ".  actual title: [<b>" + actualTitle + "</b>]  AND  eexpected title: [<b>"
							+ expectedPartialTitle + "</b>]");
		} else {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>" + titleFieldName + "</b> "
							+ "</b> " + "</b>" + " Window Tab Validation Failed "
							+ ".  Title is matching. actual title: [<b>" + actualTitle
							+ "</b>]  AND  expected title: [<b>" + expectedPartialTitle + "</b>]");
			// Assert.assertTrue(false);
			Assert.assertTrue(false, "Expected title: " + expectedPartialTitle.trim()
			+ " does not match with Actual title: " + actualTitle.trim());
		}
	}

	/**
	 **************************************************************************************************************
	 * @Function Name: validateTextDirectly
	 * @Description: This function will verify that Actual & Expected Window
	 *               Title is Matching without test from excel
	 * @Param: actualText
	 * @Param :expectedText
	 * @Param :validationMessage
	 * @Return:
	 * @Date:
	 * @Author:
	 **************************************************************************************************************
	 */
	public synchronized void validateTextDirectly(String validationMsg, String actualText, String expectedText) {
		// TODO Auto-generated method stub
		if (actualText.equals(expectedText)) {
			BaseTest.test.log(LogStatus.PASS,
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>" + validationMsg + "</b> "
							+ "</b> " + "</b>" + " Passed. Title is not matching" + ".  actual: [<b>" + actualText
							+ "</b>]  AND  expected: [<b>" + expectedText + "</b>]");
		} else {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>" + validationMsg + "</b> "
							+ "</b> " + "</b>" + " Window Tab Validation Failed " + ".  Title is matching. actual: [<b>"
							+ actualText + "</b>]  AND  expected: [<b>" + expectedText + "</b>]");
			// Assert.assertEquals(actualText, expectedText);
			Assert.assertEquals(actualText.trim(),expectedText.trim(),  "Expected value: " + expectedText.trim()
			+ " does not match with Actual value: " + actualText.trim());
		}
	}

	/**
	 **************************************************************************************************************
	 * @Function Name: validateColor
	 * @Description: This function will verify the color of the element.
	 * @Param: locatorName
	 * @Param: expColorValidationName
	 * @Return:
	 * @Date:
	 * @Author:
	 **************************************************************************************************************
	 */
	public synchronized void validateColor(String locator, String expColorValidationName) {
		// TODO Auto-generated method stub
		json = new JsonReaderfile();
		String actualColor = getColor(locator);
		String expColor = json.getTestCaseData(expColorValidationName);

		if (actualColor.equals(expColor)) {
			BaseTest.test.log(LogStatus.PASS,
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>" + locator + "</b> " + "</b> "
							+ "</b>" + " " + ".Color is Matching. actual: [<b>" + actualColor
							+ "</b>]  AND  expected: [<b>" + expColor + "</b>]");
		} else {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>" + locator + "</b> " + "</b> "
							+ "</b>" + " Color is not Matching. actual[<b>" + actualColor + "</b>]  AND  expected: [<b>"
							+ expColor + "</b>]");
			// Assert.assertEquals(actualColor, actualColor);
			Assert.assertEquals(actualColor.trim(), expColor.trim(),
					"Expected value: " + expColor.trim() + " does not match with Actual color: " + actualColor.trim());
		}
	}

	/**
	 **************************************************************************************************************
	 * @Function Name: getColor
	 * @Description: This function will get the color of element.
	 * @Param: locatorName
	 * @Return: color
	 * @Date:
	 * @Author:
	 **************************************************************************************************************
	 */
	public synchronized String getColor(String locatorName) {
		// TODO Auto-generated method stub
		try {
			this.element = getElement(locatorName);
		} catch (Exception e) {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + " Element Not Found in Page Source");
			Assert.fail("Text Validation Failed");

		}
		String color = element.getCssValue("color");
		if (color == null) {
			color = "";
		}
		return color;

	}

	/**
	 **************************************************************************************************************
	 * @throws InterruptedException 
	 * @Function Name: setTextBoxValue_Direct
	 * @Description: This function will enter the value in textbox without using
	 *               Json.
	 * @Param: locatorName
	 * @Param :textToInput
	 * @Return:
	 * @Date:
	 * @Author:
	 **************************************************************************************************************
	 */
	public synchronized void setTextBoxValue_Direct(String locatorName, String textToInput)  {

		try {
			this.element = getElement(locatorName);
			element.clear();
			element.sendKeys(textToInput);
			BaseTest.test.log(LogStatus.INFO, "<b>Step No - " + StepNumber++ + "</b>",
					textToInput + " has been entered in text box : " + "<b>" + locatorName + "</b> " + "</b> "
							+ "   successfully.");
		} catch (ElementNotVisibleException e) {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style=" + '"' + "color:red" + '"' + ">Step No - " + StepNumber++ + "</b>",
					textToInput + " has been entered in text box : " + "<b>" + locatorName + "</b> " + "</b> "
							+ " because " + "<b>" + locatorName + "</b> " + "</b> "
							+ " is not visible on Page. So Selenium is not able to perform click.");
			Assert.fail("Element is not visible");
		} catch (StaleElementReferenceException ne) {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style=" + '"' + "color:red" + '"' + ">Step No - " + StepNumber++ + "</b>",
					"<b>" + locatorName + "</b> " + "</b> " + " has not been clicked because " + "<b>" + locatorName
					+ "</b> " + "</b> "
					+ " Web page's HTM has been refreshed, changed or updated since it was looked up");
			Assert.fail("Web page's HTM has been refreshed, changed or updated since it was looked up");
		} catch (InvalidElementStateException e) {
			// getDriver().executeScript("arguments[0].setAttribute('value', '" +
			// longstring
			// +"')", inputField);
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].setAttribute('value', '" + textToInput + "')",
					element);
		}

	}

	/**
	 **************************************************************************************************************
	 * @Function Name: validateValueAttribute_Direct
	 * @Description: This function will verify the attribute value.
	 * @Param: locatorName
	 * @Param :expectedValue
	 * @Return:
	 * @Date:
	 * @Author:
	 **************************************************************************************************************
	 */
	public synchronized void validateValueAttribute_Direct(String locatorName, String expectedValue) {
		// TODO Auto-generated method stub

		this.element = getElement(locatorName);

		String actualValue = element.getAttribute("value");

		if (expectedValue == null) {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Text Validation Failed"
							+ ". Expected Value is Null Please Match Test Data Column Name from script's field Name");
			// Assert.assertTrue(false);
			Assert.assertTrue(false,
					"Text Validation Failed. Expected Value is Null Please Match Test Data Column Name from script's field Name");
		}
		if (expectedValue.trim().equalsIgnoreCase(actualValue.trim())) {
			BaseTest.test.log(LogStatus.PASS,
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Text Validation Passed" + ".  actual text: [<b>" + actualValue
							+ "</b>]  AND  expected: [<b>" + expectedValue + "</b>]");
		} else {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Text Validation Failed " + ".  actual text: [<b>" + actualValue
							+ "</b>]  AND  expected: [<b>" + expectedValue + "</b>]");
			// Assert.assertEquals(actualValue.trim(), expectedValue.trim());
			Assert.assertEquals(actualValue.trim(),expectedValue.trim(),  "Expected value: " + expectedValue.trim()
			+ " does not match with Actual value: " + actualValue.trim());
		}
	}

	public synchronized String getAttribute(String locatorName, String attribute) {
		String value = "";
		element = getElement(locatorName);
		value = element.getAttribute(attribute);
		return value;
	}

	public synchronized List<WebElement> getElementsList(String locatorName) {
		json = new JsonReaderfile();
		String locatorValue = json.getLocator(locatorName)[1];
		String locatorType = json.getLocator(locatorName)[0];
		return getDriver().findElements(getLocatorBy(locatorName, locatorType, locatorValue));
	}

	public synchronized int getElementsCount(String locatorName) {
		return getElementsList(locatorName).size();
	}

	public synchronized boolean isChecked(String locatorName) {
		boolean status = false;
		element = getElement(locatorName);
		if (element.isSelected()) {
			this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());
			status = true;

		} else {
			status = false;
		}

		return status;
	}

	public synchronized void switchToNewTab() {
		ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
		this.takeScreenShot(BaseTest.folderPath, Thread.currentThread().getStackTrace()[2].getMethodName());
		if(tabs.size()>1) {
			getDriver().switchTo().window(tabs.get(1));
		}
		else { Assert.fail("There is no other window tab to switch"); }
	}

	public synchronized String getBodyText() {
		return getDriver().findElement(By.tagName("body")).getText();
	}

	public synchronized int getWindowTabCount() {
		return getDriver().getWindowHandles().size();
	}

	public synchronized void validateWindowTabCount(int expectedWindowCount) {
		int actualWindowCount = getWindowTabCount();
		if (expectedWindowCount == actualWindowCount) {
			BaseTest.test.log(LogStatus.PASS,
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "</b>"
							+ " window or tab count validation passed" + ".  actual count: [<b>" + actualWindowCount
							+ "</b>]  AND  expected: [<b>" + expectedWindowCount + "</b>]");
		} else {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>" + "</b>"
							+ " window or tab count validation passed" + ".  actual count: [<b>" + actualWindowCount
							+ "</b>]  AND  expected: [<b>" + expectedWindowCount + "</b>]");
			// Assert.assertEquals(expectedWindowCount, actualWindowCount);
			Assert.assertEquals(actualWindowCount,expectedWindowCount, "Expected value: " + expectedWindowCount
					+ " does not match with Actual value: " + actualWindowCount);
		}
	}

	/**
	 **************************************************************************************************************
	 * @Function Name: validateValueInDropDown
	 * @Description: This function will verify that the value is available in
	 *               DropDown List or not.
	 * @Param: locatorName
	 * @Param :property
	 * @Param :TCID
	 * @Return:
	 * @Date:
	 * @Author:
	 **************************************************************************************************************
	 */
	public synchronized void validateValueInDropDown(String locatorName, String property) {
		// TODO Auto-generated method stub
		json = new JsonReaderfile();
		List<WebElement> listOptions = getOptions(locatorName);
		String expectedValue=testDataMethodPick(property);
		String actualText = null;
		boolean status = false;
		for (int i = 0; i <= listOptions.size() - 1; i++) {
			actualText = listOptions.get(i).getText().trim();
			if (actualText.equalsIgnoreCase(expectedValue.trim())) {
				status = true;
				break;
			}
		}
		if (status == true) {
			BaseTest.test.log(LogStatus.PASS,
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Dropdown Value Validation Passed" + ".  actual text: [<b>"
							+ actualText + "</b>]  AND  expected: [<b>" + expectedValue + "</b>]");
		} else {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Text Validation Failed " + ".  actual text: [<b>" + actualText
							+ "</b>]  AND  expected: [<b>" + expectedValue + "</b>]");
			// Assert.assertEquals(expectedValue.trim(), actualText.trim());
			Assert.assertEquals(actualText.trim(), expectedValue.trim(),  "Expected value: " + expectedValue.trim()
			+ " does not match with Actual value: " + actualText.trim());
		}

	}

	/**
	 **************************************************************************************************************
	 * @Function Name: validateValueInDropDown
	 * @Description: This function will verify that the value is available in
	 *               DropDown List or not.
	 * @Param: locatorName
	 * @Param :property
	 * @Return:
	 * @Date:
	 * @Author:
	 **************************************************************************************************************
	 */
	public synchronized void validateValueInDropDown_Duplicate(String locatorName, String property) {
		// TODO Auto-generated method stub
		json = new JsonReaderfile();
		List<WebElement> listOptions = getOptions(locatorName);
		String expectedValue = json.getTestCaseData(property);
		String actualText = null;
		boolean status = false;
		for (int i = 0; i <= listOptions.size() - 1; i++) {
			actualText = listOptions.get(i).getText().trim();
			if (actualText.equalsIgnoreCase(expectedValue.trim())) {
				status = true;
				break;
			}
		}
		if (status == true) {
			BaseTest.test.log(LogStatus.PASS,
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Dropdown Value Validation Passed" + ".  actual text: [<b>"
							+ actualText + "</b>]  AND  expected: [<b>" + expectedValue + "</b>]");
		} else {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>" + locatorName + "</b> "
							+ "</b> " + "</b>" + " Text Validation Failed " + ".  actual text: [<b>" + actualText
							+ "</b>]  AND  expected: [<b>" + expectedValue + "</b>]");
			// Assert.assertEquals(expectedValue.trim(), actualText.trim());
			Assert.assertEquals(actualText.trim(), expectedValue.trim(),  "Expected value: " + expectedValue.trim()
			+ " does not match with Actual value: " + actualText.trim());
		}

	}

	public synchronized void validateActualAndExpectedText_NotEqual(String Actual, String Expected) {

		if (Expected.trim().equalsIgnoreCase(Actual.trim())) {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>" + "</b> " + "</b> " + "</b>"
							+ " Text Validation Failed " + ".  actual text: [<b>" + Actual
							+ "</b>]  AND  expected: [<b>" + Expected + "</b>]");
			// Assert.assertEquals(Actual, Expected);
			Assert.fail("Expected value: " + Expected.trim() + " matches with Actual value: " + Actual.trim());
		} else {
			BaseTest.test.log(LogStatus.PASS,
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:green" + '"' + ">" + "<b>" + "</b> " + "</b> " + "</b>"
							+ " Text Validation Passed" + ".  actual text: [<b>" + Actual
							+ "</b>] is not equal to expected text: [<b>" + Expected + "</b>]");
		}
	}

	public synchronized int intRandom(int digit) {

		Random rand = new Random();
		int randomNo = 0;
		String strRandom = "";

		for (int i = 0; i < digit; i++) {
			randomNo = rand.nextInt(100);
			strRandom = strRandom + randomNo;
		}
		if (strRandom.length() > digit) {
			strRandom = strRandom.substring(0, digit);
		}
		return Integer.parseInt(String.valueOf(strRandom));
	}

	public synchronized void checkDataPatternFromAttribute(String locatorName, String attribute, String pattern) {

		String attributeVal = getAttribute(locatorName, attribute);
		if (attributeVal.equalsIgnoreCase(pattern)) {
			passTestMsg("Data Pattern Found as " + pattern);
		} else {
			passTestMsg("Data Pattern Not Match " + pattern + " And " + attributeVal);
		}
	}

	public synchronized void mouseOver(String locatorName) {

		Actions action = new Actions(getDriver());
		element = getElement(locatorName);
		action.moveToElement(element).perform();
		
	}
	
	public synchronized void sendKeys(String locatorName) {

		element = getElement(locatorName);
		element.sendKeys(Keys.TAB);
		
	}
	
	public synchronized void mouseOver_click(String locatorName, String Locatorname1, String Locator2) {

		Actions builder = new Actions(getDriver());
		element=getElement(Locator2);
		elementnew = getElement(locatorName);
		builder.moveToElement(element).moveToElement(elementnew).build().perform();
		click(Locatorname1);
		
	}
	
	
	

	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub

	}

	public void stopDriver(){
		if(getDriver()!=null) {
			getDriver().close();
			getDriver().quit();
		}
	}

	public synchronized void zoomIn() throws InterruptedException
	{
		JavascriptExecutor executor = (JavascriptExecutor)getDriver();
		executor.executeScript("document.body.style.zoom = '30%'");
	}

	public synchronized void zoomout() throws InterruptedException
	{

		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		executor.executeScript("document.body.style.zoom = '100%'");
	}

	public synchronized void DropdownspanInputSearchListValidationValueSelection(String validationName, String BoxClickLocator, String SearchBoxLocator, String ListValueLocator) throws InterruptedException
	{

		String expectedValue = testDataMethodPick(validationName);
		String TextToSearch=expectedValue.substring(0,2);

		//method use to verify the element visibility and click on the respective
		WaitForElementThenClick(BoxClickLocator);

		//method use to search into the search box present in the select drop-down
		enterTexttoSearchinSeachBox_DropDown(TextToSearch, SearchBoxLocator);

		//method use to find the list of the element retrieved after the search operation 
		this.listElement = getElementsList(ListValueLocator);

		//Validate list Value does not come to zero or test case fail
		ListCountZeroValidation(listElement.size());

		//Validate the found list one by one and verify that the search text contains and after validation if match found then click on the desired value
		ListValuevalidate_ContainsSearchAndClick(expectedValue, ListValueLocator, TextToSearch, listElement.size());

	}

	public synchronized void dynamic_DropdownspanInputSearchListValidationValueSelection(String validationName, String BoxClickLocator, String SearchBoxLocator, String ListValueLocator) throws InterruptedException
	{

		String expectedValue = validationName;
		String TextToSearch=expectedValue.substring(0,5);

		//method use to verify the element visibility and click on the respective
		WaitForElementThenClick(BoxClickLocator);
         Thread.sleep(1000);
		//method use to search into the search box present in the select drop-down
		enterTexttoSearchinSeachBox_DropDown(TextToSearch, SearchBoxLocator);

		//method use to find the list of the element retrieved after the search operation 
		this.listElement = getElementsList(ListValueLocator);

		//Validate list Value does not come to zero or test case fail
		ListCountZeroValidation(listElement.size());

		//Validate the found list one by one and verify that the search text contains and after validation if match found then click on the desired value
		ListValuevalidate_ContainsSearchAndClick(expectedValue, ListValueLocator, TextToSearch, listElement.size());

	}
	
	public synchronized void dynamic_DropdownspanInputSearchListValidationValueSelection_survey(String validationName, String BoxClickLocator, String SearchBoxLocator, String ListValueLocator) throws InterruptedException
	{

		String expectedValue = validationName;
		String TextToSearch=expectedValue.substring(0,5);

		//method use to verify the element visibility and click on the respective
		WaitForElementThenClick(BoxClickLocator);

		//method use to search into the search box present in the select drop-down
		enterTexttoSearchinSeachBox_DropDown(TextToSearch, SearchBoxLocator);

		//method use to find the list of the element retrieved after the search operation 
		this.listElement = getElementsList(ListValueLocator);

		//Validate list Value does not come to zero or test case fail
		ListCountZeroValidation(listElement.size());
             Thread.sleep(2000);
		//Validate the found list one by one and verify that the search text contains and after validation if match found then click on the desired value
		ListValuevalidate_ContainsSearchAndClick_survey(expectedValue, ListValueLocator, TextToSearch, listElement.size());

	}
	
	
	public synchronized void dynamic_DropdownspanInputSearchListValidationValueSelection_negative(String validationName, String BoxClickLocator, String SearchBoxLocator, String ListValueLocator) throws InterruptedException
	{

		String expectedValue = validationName;
		String TextToSearch=expectedValue.substring(0,2);

		//method use to verify the element visibility and click on the respective
		WaitForElementThenClick(BoxClickLocator);

		//method use to search into the search box present in the select drop-down
		enterTexttoSearchinSeachBox_DropDown(TextToSearch, SearchBoxLocator);

		//method use to find the list of the element retrieved after the search operation 
		this.listElement = getElementsList(ListValueLocator);

		//Validate list Value does not come to zero or test case fail
		//ListCountZeroValidation(listElement.size());

		//Validate the found list one by one and verify that the search text contains and after validation if match found then click on the desired value
		ListValuevalidate_ContainsSearchAndClick_negative(expectedValue, ListValueLocator, TextToSearch, listElement.size());

	}

	public synchronized void WaitForElementThenClick(String locatorName) throws InterruptedException
	{
		waitForElementVisibility(locatorName);
		click(locatorName);
		Thread.sleep(2000);
	}

	public synchronized void enterTexttoSearchinSeachBox_DropDown(String TextToSearch, String Locator) throws InterruptedException
	{
		waitForElementVisibility(Locator);
		this.element=getElement(Locator);
		System.out.println("SearchText " + TextToSearch);
		element.sendKeys(TextToSearch);	
		Thread.sleep(3000);

	}

	public synchronized void ListCountZeroValidation(int Size)
	{
		if(Size==0)
		{
			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>" + "</b> " + "</b> " + "</b>"
							+ " Text Validation Failed " + ".  actual text: [<b>" + " Please add value in the list to select any value:- "
							+ "</b>]  As the found count is : [<b>" + listElement.size() + "</b>]");

			Assert.assertTrue(false, "Please add value in the list to select any value");

		}
	}

	public synchronized void ListValuevalidate_ContainsSearchAndClick(String expectedValue, String ListValueLocator, String TextToSearch, int Size) throws InterruptedException
	{
		for (int i = 1; i <=Size; i++) 
		{			
			this.element=getTextValueUsingSpecificElement(ListValueLocator, i);
			String actualValue=element.getText();
			System.out.println("actualValue :-" + actualValue);

			foundListContains_SearchText(actualValue, TextToSearch);

			if (actualValue.equals(expectedValue)) {
				Thread.sleep(2000);
				element.click();
				BaseTest.test.log(LogStatus.PASS,
						"<b style= " + '"' + "font-size: 12pt;color:green" + '"' + ">" + "<b>Step No - " + StepNumber++
						+ "</b>" + "</b>",
						"<b style= " + '"' + "font-size: 12pt;color:green" + '"' + ">" + "<b>" + " Application is displaying all the list " + "</b> "
								+ "</b> " + "</b>" + " " + " selected with [<b>" + actualValue + "</b>]");       

				Assert.assertTrue(true, "Expected value: " + expectedValue.trim() + " does  contains in the list found: " + actualValue.trim());
				break;
			}
		}
	}
	
	public synchronized void ListValuevalidate_ContainsSearchAndClick_survey(String expectedValue, String ListValueLocator, String TextToSearch, int Size) throws InterruptedException
	{
				
			this.element=getTextValueUsingSpecificElement(ListValueLocator, 1);
		String actualValue=element.getText();			
		System.out.println("actualValue :-" + actualValue);
		element.click();

		}
		
	
	public synchronized void ListValuevalidate_ContainsSearchAndClick_negative(String expectedValue, String ListValueLocator, String TextToSearch, int Size) throws InterruptedException
	{
		for (int i = 1; i <=Size; i++) 
		{			
			this.element=getTextValueUsingSpecificElement(ListValueLocator, i);
			String actualValue=element.getText();
			System.out.println("actualValue :-" + actualValue);

			foundListContains_SearchText(actualValue, TextToSearch);

			if (actualValue.equals(expectedValue)) {
				Thread.sleep(2000);
				element.click();
				BaseTest.test.log(LogStatus.PASS,
						"<b style= " + '"' + "font-size: 12pt;color:green" + '"' + ">" + "<b>Step No - " + StepNumber++
						+ "</b>" + "</b>",
						"<b style= " + '"' + "font-size: 12pt;color:green" + '"' + ">" + "<b>" + " Application is displaying all the list " + "</b> "
								+ "</b> " + "</b>" + " " + " selected with [<b>" + actualValue + "</b>]");       

                Assert.assertFalse(true, "Expected value: " + expectedValue.trim() + " does  contains in the list found: " + actualValue.trim());
				break;
			}
		}
	}

	public synchronized WebElement getTextValueUsingSpecificElement(String locatorName, int i) throws InterruptedException 
	{
		json = new JsonReaderfile();
		String locatorType = json.getLocator(locatorName)[0];
		String locatorValue = json.getLocator(locatorName)[1];
		String LocatorValueupdated=locatorValue + "[" + i + "]";
		By locator = getLocatorBy(locatorName, locatorType, LocatorValueupdated);
		int count = 1;
		System.out.println(
				"Waiting upto " + 10000 + "ms for element with locator: \"" + locator + "\" to appear on page.");
		while (getDriver().findElements(locator).size() == 0 && count <= 5) {
			Thread.sleep(1000);
			System.out.println("Waiting " + 1 + "000 ms for count " + count);
			count++;
		}
		return (getDriver().findElement(locator));
	}
	
	public synchronized WebElement getTextValueUsingSpecificElement(String locatorName, String Value) throws InterruptedException 
	{
		json = new JsonReaderfile();
		String locatorType = json.getLocator(locatorName)[0];
		String locatorValue = json.getLocator(locatorName)[1];
		String LocatorValueupdated=locatorValue + "'" + Value +  "')]";
		By locator = getLocatorBy(locatorName, locatorType, LocatorValueupdated);
		int count = 1;
		System.out.println(
				"Waiting upto " + 10000 + "ms for element with locator: \"" + locator + "\" to appear on page.");
		while (getDriver().findElements(locator).size() == 0 && count <= 5) {
			Thread.sleep(1000);
			System.out.println("Waiting " + 1 + "000 ms for count " + count);
			count++;
		}
		return (getDriver().findElement(locator));
	}
	

	public synchronized void foundListContains_SearchText(String ListDisplayed, String SearchValue)
	{
		String ListValue=ListDisplayed.toLowerCase().toString();
		String Searchedtext=SearchValue.toLowerCase().toString();

		if (ListValue.contains(Searchedtext))		{
			BaseTest.test.log(LogStatus.PASS,
					"<b style= " + '"' + "font-size: 12pt;color:green" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 12pt;color:green" + '"' + ">" + "<b>" + " Application is displaying all the list " + "</b> "
							+ "</b> " + "</b>" + " " + " selected with [<b>" + ListDisplayed + "</b>]");       

			Assert.assertTrue(true, "Expected value: " + SearchValue.trim() + " does  contains in the list found: " + ListDisplayed.trim());


		}else{

			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>" + "</b> " + "</b> " + "</b>"
							+ " Text Validation Failed " + ".  actual text: [<b>" + " Application is displaying item from the list following item:- "
							+ "</b>]  AND  expected: [<b>" + ListDisplayed + "</b>]");
			Assert.fail("Expected value: " + SearchValue.trim() + " does not contains in the list found: " + ListDisplayed.trim());

		}

	}

	public synchronized void dropDownSelectedvalueClick(String actualValue, String expectedValue) throws InterruptedException
	{
		if (actualValue.equals(expectedValue)) {
			Thread.sleep(3000);
			element.click();
			BaseTest.test.log(LogStatus.PASS,
					"<b style= " + '"' + "font-size: 12pt;color:green" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 12pt;color:green" + '"' + ">" + "<b>" + " Application is displaying all the list " + "</b> "
							+ "</b> " + "</b>" + " " + " selected with [<b>" + actualValue + "</b>]");       

			Assert.assertTrue(true, "Expected value: " + expectedValue.trim() + " does  contains in the list found: " + actualValue.trim());


		}else{

			BaseTest.test.log(LogStatus.FAIL,
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>Step No - " + StepNumber++
					+ "</b>" + "</b>",
					"<b style= " + '"' + "font-size: 15px;color:red" + '"' + ">" + "<b>" + "</b> " + "</b> " + "</b>"
							+ " Text Validation Failed " + ".  actual text: [<b>" + " Application is displaying item from the list following item:- "
							+ "</b>]  AND  expected: [<b>" + actualValue + "</b>]");
			Assert.fail("Expected value: " + expectedValue.trim() + " does not contains in the list found: " + actualValue.trim());

		}

	}

	//For dropdown mapped under spam
	public void Dropdownvalueselection(String validationName, String BoxClickLocator, String ListValueLocator) throws InterruptedException
	{
		WaitForElementThenClick(BoxClickLocator);

		this.listElement = getElementsList(ListValueLocator);
		Thread.sleep(3000);

		for (int i = 1; i <= listElement.size(); i++) 
		{			
			this.element=getTextValueUsingSpecificElement(ListValueLocator, i);
			String actualValue = element.getText();
			System.out.println("actualValue :-" + actualValue);

			String expectedValue=testDataMethodPick(validationName);

			if (actualValue.equals(expectedValue)) {
				Thread.sleep(3000);
				element.click();
				BaseTest.test.log(LogStatus.PASS,
						"<b style= " + '"' + "font-size: 12pt;color:green" + '"' + ">" + "<b>Step No - " + StepNumber++
						+ "</b>" + "</b>",
						"<b style= " + '"' + "font-size: 12pt;color:green" + '"' + ">" + "<b>" + ListValueLocator + "</b> "
								+ "</b> " + "</b>" + " " + " selected with [<b>" + actualValue + "</b>]");            
				break;
			}
		}

	}
	
	public void DropdownvalueselectionDynamic(String validationName, String BoxClickLocator, String ListValueLocator) throws InterruptedException
	{
		WaitForElementThenClick(BoxClickLocator);

		this.listElement = getElementsList(ListValueLocator);
		Thread.sleep(3000);

		for (int i = 1; i <= listElement.size(); i++) 
		{			
			this.element=getTextValueUsingSpecificElement(ListValueLocator, i);
			String actualValue = element.getText();
			System.out.println("actualValue :-" + actualValue);

			String expectedValue=validationName;

			if (actualValue.equals(expectedValue)) {
				Thread.sleep(3000);
				element.click();
				BaseTest.test.log(LogStatus.PASS,
						"<b style= " + '"' + "font-size: 12pt;color:green" + '"' + ">" + "<b>Step No - " + StepNumber++
						+ "</b>" + "</b>",
						"<b style= " + '"' + "font-size: 12pt;color:green" + '"' + ">" + "<b>" + ListValueLocator + "</b> "
								+ "</b> " + "</b>" + " " + " selected with [<b>" + actualValue + "</b>]");            
				break;
			}
		}

	}

	
	//For dropdown mapped under spam
		public void Dropdownvalueselection_negative(String validationName, String BoxClickLocator, String ListValueLocator) throws InterruptedException
		{
			WaitForElementThenClick(BoxClickLocator);

			this.listElement = getElementsList(ListValueLocator);
			Thread.sleep(3000);

			for (int i = 1; i <= listElement.size(); i++) 
			{			
				this.element=getTextValueUsingSpecificElement(ListValueLocator, i);
				String actualValue = element.getText();
				System.out.println("actualValue :-" + actualValue);

				String expectedValue=testDataMethodPick(validationName);

				if (actualValue!=(expectedValue)) {
					Thread.sleep(3000);
					element.click();
					BaseTest.test.log(LogStatus.PASS,
							"<b style= " + '"' + "font-size: 12pt;color:green" + '"' + ">" + "<b>Step No - " + StepNumber++
							+ "</b>" + "</b>",
							"<b style= " + '"' + "font-size: 12pt;color:green" + '"' + ">" + "<b>" + ListValueLocator + "</b> "
									+ "</b> " + "</b>" + " " + " selected with [<b>" + actualValue + "</b>]");            
					break;
				}
			}

		}
	public void DynamicDropdownvalueselection(String validationName, String BoxClickLocator, String ListValueLocator) throws InterruptedException
	{
		WaitForElementThenClick(BoxClickLocator);

		this.listElement = getElementsList(ListValueLocator);
		Thread.sleep(3000);

		for (int i = 1; i <= listElement.size(); i++) 
		{			
			this.element=getTextValueUsingSpecificElement(ListValueLocator, i);
			String actualValue = element.getText();
			System.out.println("actualValue :-" + actualValue);


			if (actualValue.equals(validationName)) {
				Thread.sleep(3000);
				element.click();
				BaseTest.test.log(LogStatus.PASS,
						"<b style= " + '"' + "font-size: 12pt;color:green" + '"' + ">" + "<b>Step No - " + StepNumber++
						+ "</b>" + "</b>",
						"<b style= " + '"' + "font-size: 12pt;color:green" + '"' + ">" + "<b>" + ListValueLocator + "</b> "
								+ "</b> " + "</b>" + " " + " selected with [<b>" + actualValue + "</b>]");            
				break;
			}
		}

	}

	//For dropdown mapped under spam
	public void Dynamic_Dropdownvalueselection(String validationName, String BoxClickLocator, String ListValueLocator) throws InterruptedException
	{
		WaitForElementThenClick(BoxClickLocator);

		this.listElement = getElementsList(ListValueLocator);
		Thread.sleep(3000);

		for (int i = 1; i <= listElement.size(); i++) 
		{			
			this.element=getTextValueUsingSpecificElement(ListValueLocator, i);
			String actualValue = element.getText();
			System.out.println("actualValue :-" + actualValue);

			String expectedValue=validationName;

			if (actualValue.equals(expectedValue)) {
				Thread.sleep(3000);
				element.click();
				BaseTest.test.log(LogStatus.PASS,
						"<b style= " + '"' + "font-size: 12pt;color:green" + '"' + ">" + "<b>Step No - " + StepNumber++
						+ "</b>" + "</b>",
						"<b style= " + '"' + "font-size: 12pt;color:green" + '"' + ">" + "<b>" + ListValueLocator + "</b> "
								+ "</b> " + "</b>" + " " + " selected with [<b>" + actualValue + "</b>]");            
				break;
			}
		}

	}

	public synchronized String getInnerTextByName(String locatorName) {

		element = getElement(locatorName);
		if (element != null) {
			System.out.println("tester value" + element.getText());
			return element.getText();	
		}
		return null;
	}


	public synchronized String getInnerTextDynamic(String locatorName, String CalenderName) {

		element = getElementwithVariable(locatorName,CalenderName);
		System.out.println("wo test "+ element);

		//System.out.println("great test india"+element.getAttribute(valuename));
		if (element != null) {
			//return element.getAttribute(valuename);
			System.out.println(element.getText());
			return element.getText();

		}
		return null;
	}

	public synchronized String getInnerTextDynamictabular(String locatorName, String CalenderName) {

		element = getElementwithVariable(locatorName,CalenderName);
		String myValue = element.getText();

		System.out.println("wo test "+ element);
		System.out.println(element.getText());

		//System.out.println("great test india"+element.getAttribute(CalenderName));
		if (element != null) {
			return myValue;


		}

		return null;
	}
	
	public synchronized String getInnerTextDynamictabular_element(String locatorName, String CalenderName, String value) {

		element = getElementwithVariable(locatorName,CalenderName);
		//String myValue = element.getText();

		System.out.println("wo test "+ element);
		System.out.println(element.getText());

		//System.out.println("great test india"+element.getAttribute(CalenderName));
		if (element != null) {
			return element.getAttribute(value);


		}

		return null;
	}

	public synchronized WebElement getElementwithVariable(String locatorName, String calendername) {

		json = new JsonReaderfile();
		try {
			String locatorType = json.getLocator(locatorName)[0];
			String locatorValue = json.getLocator(locatorName)[1];
			String LocatornewValue= locatorValue+calendername;
			By locator = getLocatorBy(locatorName, locatorType, LocatornewValue);
			int count = 3;
			System.out.println(
					"Waiting upto " + 10000 + "ms for element with locator: \"" + locator + "\" to appear on page.");
			while (getDriver().findElements(locator).size() == 0 && count <= 5) {
				Thread.sleep(1000);
				System.out.println("Waiting " + 1 + "000 ms for count " + count);
				count++;
			}
			return (getDriver().findElement(locator));
		} catch (NoSuchElementException e) {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style=" + '"' + "color:red" + '"' + ">Step No - " + StepNumber++ + "</b>" + "</b>",
					"<b>" + locatorName + "</b> " + "</b> " + "  is not found on Page Source. Test Failed");
			e.printStackTrace();
			Assert.fail("Element is not found");
		} catch (NullPointerException e) {
			BaseTest.test.log(LogStatus.FAIL,
					"<b style=" + '"' + "color:red" + '"' + ">Step No - " + StepNumber++ + "</b>" + "</b>",
					"NullPointerException for " + "<b>" + locatorName + "</b> " + "</b> "
							+ "  Please Match Script's locator Name with OR Locator Name. Test Failed");
			e.printStackTrace();

			Assert.fail("Please Match Script's locator Name with OR Locator Name");
		} catch (StaleElementReferenceException e) {
			BaseTest.test.log(LogStatus.FAIL, "<b>Step No - " + StepNumber++ + "</b>",
					"<b>" + locatorName + "</b> " + "  is not attached to the page document. Test Failed");
			System.out.println("Element is not attached to the page document " + e.getStackTrace());
			e.printStackTrace();
			Assert.fail("Element is not attached to the page document");
		} 
		catch (InvalidElementStateException e) {
			BaseTest.test.log(LogStatus.FAIL, "<b>Step No - " + StepNumber++ + "</b>",
					"<b>" + locatorName + "</b> " + "  is not attached to the current page/modal document. Test Failed");
			System.out.println("Element is not currently interactable" + e.getStackTrace());
			e.printStackTrace();
			Assert.fail("Element is not attached to the page document");
		} 
		catch (Exception e) {

			BaseTest.test.log(LogStatus.FAIL, "<b>Step No - " + StepNumber++ + "</b>",

					"<b>" + locatorName + "</b> " + "  is not clickable. Test Failed");
			System.out.println("Element " + element + " is not clickable " + e.getStackTrace());
			e.printStackTrace();
			Assert.fail("Element is not clickable");
		}
		return null;
	}

	public void Dropdownvalueselection_WithOption(String validationName, String listboxName, String locatorName) throws InterruptedException

	{
		List<WebElement> listElement = getDriver().findElements(By.xpath("//ul[@id='" +listboxName + "' and @aria-hidden='false']//option"));

		Thread.sleep(1000);

		System.out.println("//ul[@id='" +listboxName + "' and @aria-hidden='false']//option");
		Thread.sleep(3000);

		System.out.println(listElement.size());
		for (int i = 1; i <= listElement.size(); i++) 

		{			
			this.element=getTextValueUsingSpecificElement(locatorName, i);

			String actualValue = element.getText();

			System.out.println("ravi tester"+ actualValue);

			String expectedValue = testDataMethodPick(validationName);

			System.out.println("dggddgsahdg"+expectedValue);

			System.out.println("List value returned value is: "+ actualValue);

			if (actualValue.equals(expectedValue)) {


				Thread.sleep(1000);


				element.click();


				BaseTest.test.log(LogStatus.PASS,


						"<b style= " + '"' + "font-size: 12pt;color:green" + '"' + ">" + "<b>Step No - " + StepNumber++


						+ "</b>" + "</b>",


						"<b style= " + '"' + "font-size: 12pt;color:green" + '"' + ">" + "<b>" + listboxName + "</b> "


	 								+ "</b> " + "</b>" + " " + " selected with [<b>" + actualValue + "</b>]");            

				break;

			}

		}
	}

	public synchronized void zoomInZoomOut() throws InterruptedException
	{
		zoomIn();
		Thread.sleep(2000);
		zoomout();
		Thread.sleep(2000);
	}


}




