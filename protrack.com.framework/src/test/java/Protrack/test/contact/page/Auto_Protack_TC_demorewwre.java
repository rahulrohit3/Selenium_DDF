package Protrack.test.contact.page;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import protrack.com.frame.core.GlobalVariable;
import protrack.com.frame.core.SeleniumHelper;
import protrack.com.frame.util.JsonReaderfile;
import protrack.com.test.suite.Config_Utility;
import protrack.com.test.suite.ExecutionEnvironment;
import protrack.main.test.page.ContactPage;



public class Auto_Protack_TC_demorewwre extends Config_Utility {

	ExecutionEnvironment exec = new ExecutionEnvironment();
	SeleniumHelper wrapper=new SeleniumHelper();
	ContactPage Contact=new ContactPage();
	public JsonReaderfile json;
	public static int StepNumber;
	public WebElement element;
	GlobalVariable globalVariable=new GlobalVariable();



	@Test(description="Added new contact by filling data in all 4 fields",groups = {"All", "Smoke"})
	public void Contactvalidationpromotion() throws IOException, InterruptedException 

	{

	String CreateContact=Contact.CreateContact();
	Contact.SubmitAndValidateContactCreated(CreateContact);
	Contact.validatecompanyDropdownAfterandBeforeValue();	
	
	}

}





