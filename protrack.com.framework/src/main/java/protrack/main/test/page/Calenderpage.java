package protrack.main.test.page;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Set;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import protrack.com.frame.core.BaseDriver;
import protrack.com.frame.core.SeleniumHelper;
import protrack.com.frame.util.JsonReaderfile;
import protrack.com.test.suite.ExecutionEnvironment;

public class Calenderpage {
	
	SeleniumHelper wrapper = new SeleniumHelper();
	JsonReaderfile json;
	BaseDriver base = new BaseDriver();
	ExecutionEnvironment exec=new ExecutionEnvironment();
	DashBoardPage Dashboard=new DashBoardPage();
	public WebElement element;
	public synchronized void Open_calender_page() throws InterruptedException 
	 {
			Reporter.log("Open Calender page");
			wrapper.click("ModalBox_ViewCalenderList");
	 }
	
	public synchronized void Add_calender_name() throws InterruptedException 
	 {
			Reporter.log("Open add calender name pop up");
			wrapper.click("Calender_addCalender_Button");
	 }
	String Calendervalue=generateRandomAlphaNumeric(10);
	public synchronized void Input_Calender_name() throws InterruptedException 
	{
	Reporter.log("Enter Calender name");
	Thread.sleep(2000);
	wrapper.setTextBoxValue_Direct("Calender_addCalender_Name_textBox", Calendervalue);
	Thread.sleep(2000);
	}
	
	public synchronized void Add_submit_calender_name() throws InterruptedException 
	 {
			Reporter.log("Submit Calender name");
			Thread.sleep(2000);
			wrapper.click("Calender_addCalender_Name_Button");
	 }
	public synchronized void Validate_CalenderName_created() throws InterruptedException 
	 {
		Reporter.log("Validate Calender Name has been created");
		 wrapper.waitForBrowserToLoadCompletely();
	 String Calendervaluexpath= ("'"+Calendervalue+"'"+"]");
		 String TitlevalueCalender= wrapper.getInnerTextDynamictabular_element("Calender_Name_listing", Calendervaluexpath, "calendarname" );
		//String TitlevalueCalender=wrapper.getTextValueUsingSpecificElement("Calender_Name_listing", Calendervalue).getText();
		 System.out.println("this is tester value"+ Calendervalue);
		 System.out.println("This is web value"+ TitlevalueCalender);
		Assert.assertEquals(Calendervalue, TitlevalueCalender);
		
	 }
	
	
	public synchronized void Delete_CalenderName_created() throws InterruptedException 
	 {
		
		Reporter.log("Validate Calender Name has been Deleted");
		wrapper.click("Calender_delete_cross_button");
		Thread.sleep(5000);
		wrapper.getDriver().switchTo().alert().accept();
		wrapper.waitForBrowserToLoadCompletely();
		}
		
	 
	
	public synchronized void Add_Click_calender_Date() throws InterruptedException 
	 {
			Reporter.log("Open event form");
			 wrapper.waitForBrowserToLoadCompletely();
			
			wrapper.doubleClick("Calender_event_CreateDatePicker");
			wrapper.mouseDoubleClick("Calender_event_CreateDatePicker");
	 }
	
	public synchronized void Input_event_Title() throws InterruptedException 
	{
	Reporter.log("Enter Event  Title");
	 wrapper.waitForBrowserToLoadCompletely();
	wrapper.setTextBoxValue_Direct("Calender_event_TitleBox", generateRandomStringOfFixLength(50));
	Thread.sleep(1000);
	}
	
	public synchronized void Input_event_Location() throws InterruptedException 
	{
	Reporter.log("Enter Event  Title");
	wrapper.setTextBoxValue_Direct("Calender_event_LocationBox", "Delhi");
	Thread.sleep(1000);
	}
	
	public synchronized void Input_event_startDate() throws InterruptedException 
	{
	Reporter.log("Enter Event  start date");
	wrapper.setTextBoxValue_Direct("Calender_event_StartDate", dateToDateTimeFormat_ddmmyyyy());
	Thread.sleep(1000);
	}
	
	public synchronized void Input_event_EndDate() throws InterruptedException 
	{
	Reporter.log("Enter Event  End date");
	wrapper.setTextBoxValue_Direct("Calender_event_EndDate", dateToDateTimeFormat_ddmmyyyy());
	Thread.sleep(1000);
	}
	
	public synchronized void Input_event_Notes() throws InterruptedException 
	{
	Reporter.log("Enter Event  End date");
	wrapper.setTextBoxValue_Direct("Calender_event_Notes", generateRandomStringOfFixLength(200));
	}
	
	public synchronized void Submit_event_Details() throws InterruptedException 
	{
	Reporter.log("Submit Event  details ");
	wrapper.click("Calender_event_Submit_button");
	}
	
	public synchronized void Move_event_Details_box() throws InterruptedException 
	{
	Reporter.log("Move Event  details Box ");
    wrapper.click("Calender_event_popupBox");
	Set<String> allWindowHandles = wrapper.getDriver().getWindowHandles();
	 
	for(String handle : allWindowHandles)
	{
	System.out.println("Switching to window - > " + handle);
	wrapper.getDriver().switchTo().window(handle); //Switch to the desired window first and then execute commands using driver
	}
	}
	///**************General methods********************************


	public static String generateRandomAlphaNumeric(int count) {
		String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}
	public static String generateRandomStringOfFixLength(int diCount)
	{
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < diCount; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		String RandomString = sb.toString();
		return RandomString;

	}

	public static String generateRandomNumberOfFixLength(int digCount) {
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(digCount);
		for (int i = 0; i < digCount; i++)
			sb.append((char) ('1' + rnd.nextInt(8)));
		return sb.toString();
	}

	public static String generateEmailAddress_alpha(int i)
	{
		String domain="@mailinator.com";
		String ClientDesigneeEmail = generateRandomAlphaNumeric(i);
		return ClientDesigneeEmail.concat(domain);
	}
	public static String dateToDateTimeFormat_ddmmyyyy() 
	{

		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	       Date dateobj = new Date();
		return df.format(dateobj);
	}
}
