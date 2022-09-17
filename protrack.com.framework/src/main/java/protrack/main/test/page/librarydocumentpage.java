package protrack.main.test.page;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import protrack.com.frame.core.BaseDriver;
import protrack.com.frame.core.BaseTest;
import protrack.com.frame.core.SeleniumHelper;
import protrack.com.frame.util.JsonReaderfile;
import protrack.com.test.suite.ExecutionEnvironment;



public class librarydocumentpage  extends BaseTest {
	SeleniumHelper wrapper = new SeleniumHelper();
	JsonReaderfile json;
	BaseDriver base = new BaseDriver();
	ExecutionEnvironment exec=new ExecutionEnvironment();
	public WebElement element;
	
	/**
	 **************************************************************************************************************
	 * @throws InterruptedException 
	 * @Function Name: library_document page
	 * @Description: functions are used for library document pages
	 * @Param: 
	 * @Return:
	 * @Date: 15th,July-2019
	 * @Author: Ravi Ranjan
	 **************************************************************************************************************
	 */
	
	// Verify that login page is displayed

		public synchronized void isLibraryofducuments_dropdown_dispalyed() throws InterruptedException {
			json = new JsonReaderfile();
			Reporter.log("Validate Library of documents drop down displayed");
			wrapper.click("Municipal_documents");
			String ExpTitle = json.getTestCaseData("MunicipalDocumentExpectedURL");

			wrapper.waitForBrowserToLoadCompletely();
			Thread.sleep(1000);

			if(wrapper.getDriver().getCurrentUrl().equalsIgnoreCase(ExpTitle)) {

				wrapper.validateWindowTab_PartialTitle("MunicipalDocumentsExpectedTitle");
				
			}
			
			else 
			{
				Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

			}

		}
		public synchronized void validateText_librarypage() throws IOException{
			Reporter.log("Validate error message for incorrect login");
			wrapper.click("Municipal_documents");
			wrapper.waitForBrowserToLoadCompletely();
			wrapper.validateInnerText("Text_MunicaplDocuments","ExpectedText");

		}
		
		public synchronized void validateText_Marketingpage() throws IOException{
			Reporter.log("Validate error message for incorrect login");
	
			wrapper.validateInnerText("Text_MarketingMaterial","ExpectedText");

		}
		
		public synchronized void Validate_Marketing_Material_link () throws IOException{
			Reporter.log("Validate error message for incorrect login");
			wrapper.click("Link_marketing_material_documents");

		}
		
		public synchronized void Validate_WorkforceDocumnet_link () throws IOException{
			Reporter.log("Validate workforce documnet link clickable");
			wrapper.click("workforcedocumnet_link");

		}
		
		public synchronized void Validate_Marketing_Material_innerlinks () throws IOException{
			Reporter.log("Validate error message for incorrect login");
			wrapper.click("Link_marketing_material_documents");
			wrapper.click("Link_marketingmaterial_first_link");
			wrapper.validateInnerText("Link_marketingmaterial_first_link","ExpectedText");
			wrapper.validateInnerText("Link_Landing_page","ExpectedTextLanding");
			wrapper.click("Link_Material_inner_link");
			wrapper.click("Link_Material_broucher");
			wrapper.validateInnerText("Link_Material_inner_link","ExpectedTextMaterial");
			wrapper.validateInnerText("Link_Material_broucher","ExpectedTextBroucher");
			wrapper.click("Link_Materials_sites");
			wrapper.validateInnerText("Link_Materials_sites","ExpectedTextSites");
			wrapper.click("Link_Materials_indutrial");
			wrapper.validateInnerText("Link_Materials_indutrial","ExpectedTextIndustrial");
			wrapper.click("Link_Materials_MixedUse");
			wrapper.validateInnerText("Link_Materials_MixedUse","ExpectedTextMixedUse");
			wrapper.click("Link_Materials_Office");
			wrapper.validateInnerText("Link_Materials_Office","ExpectedTextOffice");
			wrapper.click("Link_Materials_Retails");
			wrapper.validateInnerText("Link_Materials_Retails","ExpectedTextRetail");
			wrapper.click("Link_Materials_Retails");
			wrapper.validateInnerText("Link_Materials_Retails","ExpectedTextRetail");
			wrapper.click("Link_Materials_Buildings");
			wrapper.validateInnerText("Link_Materials_Buildings","ExpectedTextBuildings");
			wrapper.click("Link_Materials_Manufacturing");
			wrapper.validateInnerText("Link_Materials_Manufacturing","ExpectedTextManufacturing");
			

		}
		
		public synchronized void isLibraryofducuments_leftside_category_clickable() {
			json = new JsonReaderfile();
			Reporter.log("Validate Library of documents drop down displayed");
			wrapper.click("Municipal_documents");
			wrapper.click("Link_left_category_list");
			
			String ExpTitle = json.getTestCaseData("MunicipalDocumentExpectedURL");

			wrapper.waitForBrowserToLoadCompletely();

			if(wrapper.getDriver().getCurrentUrl().equalsIgnoreCase(ExpTitle)) {

				wrapper.validateWindowTab_PartialTitle("MunicipalDocumentsExpectedTitle");
			

			}
			else 
			{
				Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

			}
			
}
		
		
		public synchronized void submit_municipal_document_form() {
			
			Reporter.log("Submit valid filed form for municipal documnets");

			wrapper.setTextBoxValue_Direct("TxtField_TenantCode", "QA" );
			wrapper.setTextBoxValue_Direct("TxtField_Username", "QA" );
			wrapper.setTextBoxValue_Direct("TxtField_Password", "QA");
			wrapper.click("Btn_SignIn");
		}
		
		public synchronized void open_municilap_documnet_form() throws IOException{
			Reporter.log("Validate error message for incorrect login");
			wrapper.click("Municipal_documents");
	
			wrapper.validateInnerText("Text_MunicaplDocuments","ExpectedText");

		}
		
		public synchronized void open_municilap_ordinace_dropdown() throws IOException{
			Reporter.log("open ordinace drop down");
			//wrapper.mouseDoubleClick("Link_library_doument_ordinances");
			wrapper.click("Link_library_doument_ordinances");
			wrapper.click("Link_library_doument_BuildingCodes");
		

		}
		
		public synchronized void open_marketing_website_dropdown() throws IOException{
			Reporter.log("open website drop down");
			wrapper.waitForBrowserToLoadCompletely();
			wrapper.mouseDoubleClick("MarketingMaterial_website_link");
			wrapper.click("MarketingMaterial_website_landingPage_link");
		

		}
		
		public synchronized void Delete_marketing_Documnets() throws IOException{
			Reporter.log("open website drop down");
		
			wrapper.click("Delete_project_documnets");
		

		}
		public synchronized void open_WorkforceDocumnet_dropdown() throws IOException{
			Reporter.log("open WorkforceDocumnet drop down");
			wrapper.waitForBrowserToLoadCompletely();
			wrapper.mouseDoubleClick("Workforce_leftside_link");
			wrapper.click("Workforce_ResourceDetails_link");
		

		}
		
		public synchronized void update_MarketingMaterial_document() throws IOException{
			Reporter.log("Update marketing matarial documnet button click");
			wrapper.click("marketingmaterial_update_button");
		

		}
		
		public synchronized void delete_documnets(){
			wrapper.waitForElementVisibility("Delete_project_documnets");
			wrapper.click("Delete_project_documnets");
			wrapper.getDriver().switchTo().alert().accept();
			wrapper.waitForBrowserToLoadCompletely();
		}

		public synchronized void open_municilap_documnet_addform() throws IOException{
			Reporter.log("Click on add new buttonto open foem");
			wrapper.click("Button_library_doument_add");
			wrapper.waitForBrowserToLoadCompletely();

		}
		
		String documentnamemarket= generateRandomStringOfFixLength(15);
		public synchronized void Add_docemnet_name_market() throws IOException{
			Reporter.log("Add minicipal document name");
			wrapper.setTextBoxValue_Direct("Minicipal_documnet_name_textBox",documentnamemarket );

		}
		
		String documentname= generateRandomStringOfFixLength(15);
		public synchronized void Add_docemnet_name() throws IOException{
			Reporter.log("Add minicipal document name");
			wrapper.setTextBoxValue_Direct("Minicipal_documnet_name_textBox",documentname );

		}
		
		String documentnamelib= generateRandomStringOfFixLength(15);
		public synchronized void Add_docemnet_name_library() throws IOException{
			Reporter.log("Add minicipal document name");
			wrapper.setTextBoxValue_Direct("Minicipal_documnet_name_textBox",documentnamelib );

		}
		
		String documentnamework= generateRandomStringOfFixLength(15);
		public synchronized void Add_docemnet_name_workforce() throws IOException{
			Reporter.log("Add minicipal document name");
			wrapper.setTextBoxValue_Direct("Minicipal_documnet_name_textBox",documentnamework );

		}
		
		String documentDescription= generateRandomStringOfFixLength(35);
		public synchronized void Add_Description_Details() throws IOException{
			Reporter.log("Add minicipal descriptions");
			wrapper.setTextBoxValue_Direct("Minicipal_description_textBox",documentDescription );

		}
		
		String documentDescriptionlib= generateRandomStringOfFixLength(35);
		public synchronized void Add_Description_Details_lib() throws IOException{
			Reporter.log("Add minicipal descriptions");
			wrapper.setTextBoxValue_Direct("Minicipal_description_textBox",documentDescriptionlib );

		}
		String documentDescriptionwork= generateRandomStringOfFixLength(35);
		public synchronized void Add_Description_Details_workforce() throws IOException{
			Reporter.log("Add minicipal descriptions");
			wrapper.setTextBoxValue_Direct("Minicipal_description_textBox",documentDescriptionwork );

		}
		public synchronized void Add_Keyword_Details() throws IOException{
			Reporter.log("Add keyword details");
			wrapper.setTextBoxValue_Direct("Minicipal_keyword_textBox",generateRandomStringOfFixLength(8) );

		}
		
		public synchronized void SelectContact_Value() throws IOException, InterruptedException{
			Reporter.log("Select contact  value");
			wrapper.selectByValue("Minicipal_contact_DropDown", "5032");

		}
		
		public synchronized void SelectProject_Value() throws IOException, InterruptedException{
			Reporter.log("Select Project  value");
			wrapper.selectByValue("Minicipal_project_DropDown", "5029");

		}
		
		public synchronized void Upload_municipal_documnet() throws IOException, InterruptedException{
		Reporter.log("Upload municipal documnet file");
		this.element=wrapper.getElement("Minicipal_File_upload");
		element.sendKeys(System.getProperty("user.dir") +File.separator+"qa.pdf");
		wrapper.waitForBrowserToLoadCompletely();

		
		}
		
		
		public synchronized void save_municipal_document() throws IOException{
			Reporter.log("save municipal details form");
			wrapper.click("Minicipal_Documnet_save_Button");
			wrapper.waitForBrowserToLoadCompletely();

		}
		
		public synchronized void select_all_on_load_page_list() throws IOException, InterruptedException{
			Reporter.log("select value all");
			wrapper.refresh();
			wrapper.selectByValue("Select_page_listing_number", "50");
		}
		
		
		public synchronized void verify_marketing_document_uploaded() throws IOException{
			Reporter.log("Validate documnet  has been uploaded");
			 wrapper.waitForBrowserToLoadCompletely();
			 String Documnetnamevaluexpathmarket= ("'"+documentnamemarket+"'"+")]");
			 String TitlevalueDocumnetmarket= wrapper.getInnerTextDynamic("MarketingMaterial_website_documentname", Documnetnamevaluexpathmarket);
			 System.out.println("this is tester value"+ documentnamemarket);
			 System.out.println("This is web value"+ TitlevalueDocumnetmarket);
			Assert.assertEquals(documentnamemarket, TitlevalueDocumnetmarket);
			 String Descriptionxpathmarket= ("'"+documentDescription+"'"+")]");
			 String Titlevaluedescriptionmarket= wrapper.getInnerTextDynamic("MarketingMaterial_website_descriptionDetails", Descriptionxpathmarket);
			 System.out.println("this is tester value"+ documentDescription);
			 System.out.println("This is web value"+ Titlevaluedescriptionmarket);
			Assert.assertEquals(documentDescription, Titlevaluedescriptionmarket);

		}
		
		public synchronized void verify_muncipal_document_uploaded() throws IOException{
			Reporter.log("Validate documnet  has been uploaded");
			 wrapper.waitForBrowserToLoadCompletely();
			 String Documnetnamevaluexpathmarket= ("'"+documentname+"'"+")]");
			 String TitlevalueDocumnetmarket= wrapper.getInnerTextDynamic("Muncipal_ordinance_documentname", Documnetnamevaluexpathmarket);
			 System.out.println("this is tester value"+ documentname);
			 System.out.println("This is web value"+ documentname);
			Assert.assertEquals(documentname, TitlevalueDocumnetmarket);
			 

		}
		

		
		
		public synchronized void verify_edited_library_document_uploaded() throws IOException{
			Reporter.log("Validate documnet  has been uploaded");
			 wrapper.waitForBrowserToLoadCompletely();
			 String Documnetnamevaluexpathlib= ("'"+documentnamelib+"'"+")]");
			 System.out.println(documentnamelib);
			 System.out.println(Documnetnamevaluexpathlib);
			 String TitlevalueDocumnetlib= wrapper.getInnerTextDynamic("MarketingMaterial_website_documentname", Documnetnamevaluexpathlib);
			 System.out.println("this is tester value"+ documentnamelib);
			 System.out.println("This is web value"+ TitlevalueDocumnetlib);
			Assert.assertEquals(documentnamelib, TitlevalueDocumnetlib);
			 String Descriptionxpathlib= ("'"+documentDescriptionlib+"'"+")]");
			 String Titlevaluedescriptionlib= wrapper.getInnerTextDynamic("MarketingMaterial_website_descriptionDetails", Descriptionxpathlib);
			 System.out.println("this is tester value"+ Descriptionxpathlib);
			 System.out.println("This is web value"+ Titlevaluedescriptionlib);
			Assert.assertEquals(documentDescriptionlib, Titlevaluedescriptionlib);

		}
		
		public synchronized void verify_work_document_uploaded() throws IOException{
			Reporter.log("Validate documnet  has been uploaded");
			 wrapper.waitForBrowserToLoadCompletely();
			 String Documnetnamevaluexpathmarket= ("'"+documentnamework+"'"+")]");
			
			 String TitlevalueDocumnetmarket= wrapper.getInnerTextDynamic("MarketingMaterial_website_documentname", Documnetnamevaluexpathmarket);
			 System.out.println("this is tester value"+ documentnamework);
			 System.out.println("This is web value"+ TitlevalueDocumnetmarket);
			Assert.assertEquals(documentnamework, TitlevalueDocumnetmarket);
			 String Descriptionxpathmarket= ("'"+documentDescriptionwork+"'"+")]");
			 String Titlevaluedescriptionmarket= wrapper.getInnerTextDynamic("MarketingMaterial_website_descriptionDetails", Descriptionxpathmarket);
			 System.out.println("this is tester value"+ documentDescriptionwork);
			 System.out.println("This is web value"+ Titlevaluedescriptionmarket);
			Assert.assertEquals(documentDescriptionwork, Titlevaluedescriptionmarket);

		}
		public synchronized void verify_Deleted_Documnet_not_availaible() throws IOException{
			Reporter.log("Validate documnet  has been uploaded");
			 wrapper.waitForBrowserToLoadCompletely();
			 String Documnetnamevaluexpathwork= ("'"+documentnamework+"'"+")]");
			 String TitlevalueDocumnetwork= wrapper.getInnerTextDynamic("MarketingMaterial_website_documentname", Documnetnamevaluexpathwork);
			 System.out.println("this is tester value"+ documentnamework);
			 System.out.println("This is web value"+ TitlevalueDocumnetwork);
			 Assert.assertNotEquals(documentnamework, TitlevalueDocumnetwork);
			 String Descriptionxpathwork= ("'"+documentDescriptionwork+"'"+")]");
			 String Titlevaluedescriptionwork= wrapper.getInnerTextDynamic("MarketingMaterial_website_descriptionDetails", Descriptionxpathwork);
			 System.out.println("this is tester value"+ documentDescriptionwork);
			 System.out.println("This is web value"+ Titlevaluedescriptionwork);
			 Assert.assertNotEquals(documentDescriptionwork, Titlevaluedescriptionwork);

		}
		
		public synchronized void Edit_marketingMaterial_document() throws IOException{
			Reporter.log("Edit marketing material documnet");
			wrapper.click("marketingmaterial_edit_documnet");
			wrapper.waitForBrowserToLoadCompletely();

		}
		
		
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
}

