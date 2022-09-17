package protrack.main.test.page;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import protrack.com.frame.core.BaseDriver;
import protrack.com.frame.core.BaseTest;
import protrack.com.frame.core.SeleniumHelper;
import protrack.com.frame.util.JsonReaderfile;
import protrack.com.test.suite.ExecutionEnvironment;

public class AdminPageprotrack extends BaseTest {
	
	SeleniumHelper wrapper = new SeleniumHelper();
	JsonReaderfile json;
	public int listElement;
	BaseDriver base = new BaseDriver();
	ExecutionEnvironment exec=new ExecutionEnvironment();
	public WebElement element;
	
	
	/**
	 **************************************************************************************************************
	 * @Function Name: Admin_document page
	 * @Description: functions are used for Admin document pages
	 * @Param: 
	 * @Return:
	 * @Date: 13th,Sep-2019
	 * @Author: Ravi Ranjan
	 **************************************************************************************************************
	 */
	
	// Verify that login page is displayed

		public synchronized void isAdminofducuments_dropdown_dispalyed() {
			json = new JsonReaderfile();
			Reporter.log("Validate Admin of documents drop down displayed");
			wrapper.click("Municipal_documents");
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
		public synchronized void Validate_admin_configure_moudule_Submenu () throws IOException, InterruptedException{
			Reporter.log("Validate admin submenu with configure module");
			
			wrapper.click("Admin_main_page_link");
			Thread.sleep(1000);
			wrapper.click("Admin_Configure_module");
			Thread.sleep(1000);


		}
		
		public synchronized void Validate_admin_dropDownManagment_Submenu () throws IOException, InterruptedException{
			Reporter.log("Validate admin submenu with Drop Down Managmnet");
			Thread.sleep(1000);
			wrapper.click("Admin_dropDown_managmnet_link");
			wrapper.waitForBrowserToLoadCompletely();

		}
		
		public synchronized void Validate_admin_fieldManagment_Submenu () throws IOException, InterruptedException{
			Reporter.log("Validate admin submenu with field Managmnet");
			wrapper.click("Admin_main_page_link");
			Thread.sleep(1000);
			wrapper.click("Admin_Configure_module");
			Thread.sleep(1000);
			wrapper.click("Admin_fieldManagmnet_link");
			wrapper.waitForBrowserToLoadCompletely();

		}
		
		public synchronized void Validate_admin_DataManagment_Submenu () throws IOException{
			Reporter.log("Validate admin submenu with field Managmnet");
			wrapper.click("Admin_DataManagment_page_link");
			wrapper.waitForBrowserToLoadCompletely();

		}
		
		public synchronized void Select_ModuleList() throws InterruptedException 
		{
			Reporter.log(" select sub menu list of category type");
			wrapper.selectByValue("Admin_select_modulelist", "1");
		}
		
		public synchronized void Select_commonSubList() throws InterruptedException 
		{
			Reporter.log(" select sub menu list of category type");
			wrapper.selectByValue("Admin_select_modulelist", "11");
		}
		
		public synchronized void Select_FieldList() throws InterruptedException 
		{
			Reporter.log(" select sub menu list of field type");
			Thread.sleep(2000);
			wrapper.selectByValue("Admin_field_menu_list_select", "1");
		}
		
		public synchronized void Select_DataDropDown_List() throws InterruptedException 
		{
			Reporter.log(" select sub menu list of field type");
			wrapper.selectByValue("Admin_Datamangmnet_landing_page", "1");
		}
		
		
		public synchronized void Select_submenuFieldList() throws InterruptedException 
		{
			Reporter.log(" select module sub menu list of field type");
			wrapper.selectByValue("Admin_field_submenu_list_select", "1");
		}
		
		public synchronized void Select_submenuFieldList_company() throws InterruptedException 
		{
			Reporter.log(" select module sub menu list of field type");
			wrapper.selectByValue("Admin_field_submenu_list_select", "3");
		}
		
		public synchronized void Select_submenuFieldList_contact() throws InterruptedException 
		{
			Reporter.log(" select module sub menu list of field type");
			wrapper.selectByValue("Admin_field_submenu_list_select", "2");
			wrapper.waitForBrowserToLoadCompletely();
		}
		
		public synchronized void Select_secondsubmenuFieldList() throws InterruptedException 
		{
			Reporter.log(" select second sub menu list of field type");
			wrapper.selectByValue("Admin_field_sub_submenu_select", "tab-52");
		}
		
		public synchronized void Select_secondsubmenuFieldList_ineractionNotes() throws InterruptedException 
		{
			Reporter.log(" select second sub menu list of field type");
			wrapper.selectByValue("Admin_field_sub_submenu_select", "tab-65");
		}
		
		public synchronized void Select_secondsubmenuFieldList_company() throws InterruptedException 
		{
			Reporter.log(" select second sub menu list of field type");
			wrapper.selectByValue("Admin_field_sub_submenu_select_company_gneralinfo", "tab-62");
		}
		
		public synchronized void Select_modulesubmenuList_project() throws InterruptedException 
		{
			Reporter.log(" select second sub menu list of field type");
			wrapper.selectByValue("Admin_filedMangmnet_sublavel_dropDown_select", "0");
		}
		
		
		public synchronized void Select_modulesubmenuList_projectname_edit_unvisible() throws InterruptedException 
		{
			Reporter.log(" select second sub menu list of field type");
			wrapper.click("Admin_field_isTabvisible");
			wrapper.click("Admin_field_isTabvisible");
			wrapper.click("Admin_field_projectName_edit_button");
		}
		
		public synchronized void Select_InteractioNotes_description_edit_unvisible() throws InterruptedException 
		{
			Reporter.log(" select second sub menu list of field type");
			wrapper.click("Admin_Interaction_notes_description_edit");
		}
		public synchronized void Select_modulesubmenuList_projectname_update_unvisible() throws InterruptedException 
		{
			Reporter.log(" select second sub menu list of field type");
			wrapper.click("Admin_field_projectname_update_button");
			wrapper.waitForBrowserToLoadCompletely();
			wrapper.click("Admin_filed_mangmnet_save_button");
		}
		
		public synchronized void isprojectName_unvisible_onThemainpage() throws InterruptedException, IOException {
			json = new JsonReaderfile();
			Reporter.log("Validate View General info  page is displayed");
			wrapper.click("Dashboard_header_link");
			wrapper.waitForBrowserToLoadCompletely();
			wrapper.click("ModalBox_AddProject");
			wrapper.waitForBrowserToLoadCompletely();
			ArrayList<Integer> arrprojectname = new ArrayList<Integer>(0); 
	
			System.out.println("tester array value"+arrprojectname);
			if (wrapper.getElement_dynamic("Projectgeneralinfopage_field_Title_Projectname").isEmpty())
			{
             	
				//Assert.assertTrue(true, "application is returning the blank list for theproject filed");
				assertEquals(wrapper.getElement_dynamic("Projectgeneralinfopage_field_Title_Projectname"), arrprojectname);
	
			}
			else {
				//Assert.assertTrue(false, "application is returning some list for the project filed containing value");
				//System.out.println(wrapper.getElement_dynamic("Projectgeneralinfopage_field_Title_Projectname").size());
				assertEquals(wrapper.getElement_dynamic("Projectgeneralinfopage_field_Title_Projectname"), arrprojectname);
			}
			
			
		}
		
		public synchronized void isContactTitle_unvisible_onThemainpage() throws InterruptedException, IOException {
			json = new JsonReaderfile();
			Reporter.log("Validate View General info  page is displayed");
			wrapper.click("Dashboard_header_link");
			wrapper.waitForBrowserToLoadCompletely();
			wrapper.click("ModalBox_AddProject");
			wrapper.waitForBrowserToLoadCompletely();
			ArrayList<Integer> arrprojectname = new ArrayList<Integer>(0); 
			System.out.println("tester array value"+arrprojectname);
			if (wrapper.getElement_dynamic("Admin_field_contactpage_title_field").isEmpty())
			{
             	
				
				assertEquals(wrapper.getElement_dynamic("Admin_field_contactpage_title_field"), arrprojectname);
	
		}
			else {
				assertEquals(wrapper.getElement_dynamic("Admin_field_contactpage_title_field"), arrprojectname);
			}
			
			
		}
		
		public synchronized void isprojectName_visible_onThemainpage() throws InterruptedException, IOException {
			json = new JsonReaderfile();
			Reporter.log("Validate View General info  page is displayed");
			wrapper.click("Dashboard_header_link");
			wrapper.waitForBrowserToLoadCompletely();
			wrapper.click("ModalBox_AddProject");
			wrapper.waitForBrowserToLoadCompletely();
			ArrayList<Integer> arrprojectname = new ArrayList<Integer>(0); 
			System.out.println("tester array value"+arrprojectname);
			if (wrapper.getElement_dynamic("Projectgeneralinfopage_field_Title_Projectname").isEmpty()==false)
			{
             	
				
				assertNotEquals(wrapper.getElement_dynamic("Projectgeneralinfopage_field_Title_Projectname"), arrprojectname);
	
		}
			else
			{
				assertNotEquals(wrapper.getElement_dynamic("Projectgeneralinfopage_field_Title_Projectname"), arrprojectname);
		}
		}
		
		public synchronized void iscontactTitle_visible_onThemainpage() throws InterruptedException, IOException {
			json = new JsonReaderfile();
			Reporter.log("Validate View General info  page is displayed");
			wrapper.click("Dashboard_header_link");
			wrapper.waitForBrowserToLoadCompletely();
			wrapper.click("ModalBox_AddContacts");
			wrapper.waitForBrowserToLoadCompletely();
			ArrayList<Integer> arrprojectname = new ArrayList<Integer>(0); 
			System.out.println("tester array value"+arrprojectname);
			if (wrapper.getElement_dynamic("Admin_field_contactpage_title_field").isEmpty()==false)
			{
             	
				
				assertNotEquals(wrapper.getElement_dynamic("Admin_field_contactpage_title_field"), arrprojectname);
	
		}
			else
			{
				assertEquals(wrapper.getElement_dynamic("Admin_field_contactpage_title_field"), arrprojectname);
		}
		}
		
			
		
		public synchronized void Select_modulesubmenuList_projectname_edit_checkbox() throws InterruptedException 
		{
			Reporter.log(" select second sub menu list of field type");
			wrapper.click("Admin_field_projectname_edit_checkbox");
			wrapper.waitForBrowserToLoadCompletely();
		}
		
        String Titlename= wrapper.generateRandomString(10);
		public synchronized void Project_filedname_edit() throws InterruptedException 
		{
			Reporter.log(" select second sub menu list of field type");
			wrapper.click("Admin_field_edit_title_box");
			wrapper.setTextBoxValue_Direct("Admin_field_edit_title_box", "GreatTester");
			wrapper.waitForBrowserToLoadCompletely();
		}
		
		public synchronized void Project_filedname_edit_rollbackoriginal() throws InterruptedException 
		{
			Reporter.log(" select second sub menu list of field type");
			wrapper.click("Admin_field_edit_title_box");
			wrapper.setTextBoxValue_Direct("Admin_field_edit_title_box", "Project Name");
			wrapper.waitForBrowserToLoadCompletely();
		}
		
		public synchronized void Contact_filedname_edit_rollbackoriginal() throws InterruptedException 
		{
			Reporter.log(" select second sub menu list of field type");
			wrapper.click("Admin_field_edit_title_box");
			wrapper.setTextBoxValue_Direct("Admin_field_edit_title_box", "Title");
			wrapper.waitForBrowserToLoadCompletely();
		}
		
		public synchronized void Company_filedname_edit_rollbackoriginal() throws InterruptedException 
		{
			Reporter.log(" select second sub menu list of field type");
			wrapper.click("Admin_field_edit_title_box");
			wrapper.setTextBoxValue_Direct("Admin_field_edit_title_box", "Company Name");
			wrapper.waitForBrowserToLoadCompletely();
		}
		
		public synchronized void Uncheck_visible_box() throws InterruptedException 
		{
			Reporter.log(" UnCheck visibility check box. ");
			wrapper.waitForBrowserToLoadCompletely();
			wrapper.click("Admin_field_submenu_visible_checkBox");
			wrapper.waitForBrowserToLoadCompletely();
			wrapper.click("Admin_filed_mangmnet_save_button");
		}
		
		public synchronized void check_visible_box() throws InterruptedException 
		{
			Reporter.log(" UnCheck visibility check box. ");
			wrapper.waitForBrowserToLoadCompletely();
			wrapper.click("Admin_field_submenu_visible_checkBox");
			wrapper.waitForBrowserToLoadCompletely();
			wrapper.click("Admin_filed_mangmnet_save_button");
		}
		
		public synchronized void isGeneralInformationTabDisplayed() throws InterruptedException, IOException {
			json = new JsonReaderfile();
			Reporter.log("Validate View General info  page is displayed");
			wrapper.click("Dashboard_header_link");
			wrapper.waitForBrowserToLoadCompletely();
			wrapper.click("ModalBox_AddProject");
			wrapper.waitForBrowserToLoadCompletely();
			String ExpTitle = json.getTestCaseData("ExpectedTitle");
			wrapper.waitForBrowserToLoadCompletely();
			if(wrapper.getElement_dynamic("Projectgeneralinfopage_text_Header_general_info")==null)
             {

			assertEquals(wrapper.getElement_dynamic("Projectgeneralinfopage_text_Header_general_info"), null);

			} 
		}
		
		public synchronized void iseditedfiledupdated() throws InterruptedException, IOException {
			json = new JsonReaderfile();
			Reporter.log("Validate View General info  page is displayed");
			wrapper.click("Dashboard_header_link");
			wrapper.waitForBrowserToLoadCompletely();
			wrapper.click("ModalBox_AddProject");
			wrapper.waitForBrowserToLoadCompletely();
		}
		
		
		public synchronized void iseditedfiledupdated_contact() throws InterruptedException, IOException {
			json = new JsonReaderfile();
			Reporter.log("Validate View General info  page is displayed");
			wrapper.click("Dashboard_header_link");
			wrapper.waitForBrowserToLoadCompletely();
			wrapper.click("ModalBox_AddContacts");
			wrapper.waitForBrowserToLoadCompletely();
		}
		
		public synchronized void iseditedfiledupdated_Company() throws InterruptedException, IOException {
			json = new JsonReaderfile();
			Reporter.log("Validate View General info  page is displayed");
			wrapper.click("Dashboard_header_link");
			wrapper.waitForBrowserToLoadCompletely();
			wrapper.click("ModalBox_AddCompany");
			wrapper.waitForBrowserToLoadCompletely();
		}
		
		public synchronized void verify_title_field_rollBack_asoldName() throws IOException{
			Reporter.log("Validate field title   has been edited");
			String originalpprojectnametitle= "GreatTester";
			 wrapper.waitForBrowserToLoadCompletely();
			 String Documnetnamevaluexpathmarket= ("'"+originalpprojectnametitle+"'"+")]");
			 String TitlevalueDocumnetmarket= wrapper.getInnerTextDynamic("Admin_edited_filed_name", Documnetnamevaluexpathmarket);
			 System.out.println("this is tester value"+ originalpprojectnametitle);
			 System.out.println("This is web value"+ TitlevalueDocumnetmarket);
			Assert.assertEquals(originalpprojectnametitle, TitlevalueDocumnetmarket);

		}
		
		public synchronized void verify_title_field_Contact_rollBack_asoldName() throws IOException{
			Reporter.log("Validate field title   has been edited");
			String originalpprojectnametitle= "Title";
			 wrapper.waitForBrowserToLoadCompletely();
			 String Documnetnamevaluexpathmarket= ("'"+originalpprojectnametitle+"'"+")]");
			 String TitlevalueDocumnetmarket= wrapper.getInnerTextDynamic("Admin_edited_filed_name", Documnetnamevaluexpathmarket);
			 System.out.println("this is tester value"+ originalpprojectnametitle);
			 System.out.println("This is web value"+ TitlevalueDocumnetmarket);
			Assert.assertEquals(originalpprojectnametitle, TitlevalueDocumnetmarket);

		}
		
		public synchronized void verify_project_field_rollBack_asoldName() throws IOException{
			Reporter.log("Validate field title   has been edited");
			String originalpprojectnametitle= "Project Name";
			 wrapper.waitForBrowserToLoadCompletely();
			 String Documnetnamevaluexpathmarket= ("'"+originalpprojectnametitle+"'"+")]");
			 String TitlevalueDocumnetmarket= wrapper.getInnerTextDynamic("Admin_edited_filed_name", Documnetnamevaluexpathmarket);
			 System.out.println("this is tester value"+ originalpprojectnametitle);
			 System.out.println("This is web value"+ TitlevalueDocumnetmarket);
			Assert.assertEquals(originalpprojectnametitle, TitlevalueDocumnetmarket);

		}
		
		public synchronized void verify_category_field_rollBack_asoldName() throws IOException{
			 Reporter.log("Validate field title has been edited");
			 String originalpprojectnametitle= "Company Name";
			 wrapper.waitForBrowserToLoadCompletely();
			 String Documnetnamevaluexpathmarket= ("'"+originalpprojectnametitle+"'"+")]");
			 String TitlevalueDocumnetmarket= wrapper.getInnerTextDynamic("Admin_edited_filed_name", Documnetnamevaluexpathmarket);
			 System.out.println("this is tester value"+ "Company Name");
			 System.out.println("This is web value"+ TitlevalueDocumnetmarket);
			 Assert.assertEquals("Company Name", TitlevalueDocumnetmarket);

		}
		
		
		
		public synchronized void verify_title_field_edited() throws IOException{
			Reporter.log("Validate field title   has been edited");

			 wrapper.waitForBrowserToLoadCompletely();
			 String Documnetnamevaluexpathmarket= ("'"+"GreatTester"+"'"+")]");
			 String TitlevalueDocumnetmarket= wrapper.getInnerTextDynamic("Admin_edited_filed_name", Documnetnamevaluexpathmarket);
			 System.out.println("this is tester value"+ "GreatTester");
			 System.out.println("This is web value"+ TitlevalueDocumnetmarket);
			Assert.assertEquals("GreatTester", TitlevalueDocumnetmarket);

		}
		
		public synchronized void isGeneralInformationTabDisplayed_company() throws InterruptedException, IOException {
			json = new JsonReaderfile();
			Reporter.log("Validate View General info  page is displayed");
			wrapper.click("Dashboard_header_link");
			wrapper.waitForBrowserToLoadCompletely();
			wrapper.click("ModalBox_AddCompany");
			wrapper.waitForBrowserToLoadCompletely();
			String ExpTitle = json.getTestCaseData("ExpectedTitle");
			wrapper.waitForBrowserToLoadCompletely();
			

			ArrayList<Integer> arr = new ArrayList<Integer>(0); 
			System.out.println("tester array value"+arr);
			if (wrapper.getElement_dynamic("AddCompany_GeneralInformationTab").isEmpty())
			{
             	
				
				assertEquals(wrapper.getElement_dynamic("AddCompany_GeneralInformationTab"), arr);
	
		}
		}
		
		public synchronized void isGeneralInformationTabDisplayed_contact() throws InterruptedException, IOException {
			json = new JsonReaderfile();
			Reporter.log("Validate View General info  page is displayed");
			wrapper.click("Dashboard_header_link");
			wrapper.waitForBrowserToLoadCompletely();
			wrapper.click("ModalBox_AddContacts");
			wrapper.waitForBrowserToLoadCompletely();
			wrapper.waitForBrowserToLoadCompletely();
			
			ArrayList<Integer> arr = new ArrayList<Integer>(0); 
			System.out.println("tester array value"+arr);
			if (wrapper.getElement_dynamic("Add_Contact_page_tab").isEmpty())
			{
             	
				
				assertEquals(wrapper.getElement_dynamic("Add_Contact_page_tab"), arr);
	
		}

		
		}
		public synchronized void isGeneralInformationTabDisplayed_company_visible() throws InterruptedException, IOException {
			json = new JsonReaderfile();
			Reporter.log("Validate View General info  page is displayed");
			wrapper.click("Dashboard_header_link");
			wrapper.waitForBrowserToLoadCompletely();
			wrapper.click("ModalBox_AddCompany");
			wrapper.waitForBrowserToLoadCompletely();
			String ExpTitle = json.getTestCaseData("ExpectedTitle");
			wrapper.waitForBrowserToLoadCompletely();
			
			ArrayList<Integer> arr = new ArrayList<Integer>(0); 
			System.out.println("tester array value"+arr);
			if (wrapper.getElement_dynamic("AddCompany_GeneralInformationTab").isEmpty()==false)
			{
             	
				
				assertNotEquals(wrapper.getElement_dynamic("AddCompany_GeneralInformationTab"), arr);
	
		}
		}
		
		public synchronized void isGeneralInformationTabDisplayed_contact_visible() throws InterruptedException, IOException {
			json = new JsonReaderfile();
			Reporter.log("Validate View General info  page is displayed");
			wrapper.click("Dashboard_header_link");
			wrapper.waitForBrowserToLoadCompletely();
			wrapper.click("ModalBox_AddContacts");
			wrapper.waitForBrowserToLoadCompletely();
			String ExpTitle = json.getTestCaseData("ExpectedTitle");
			wrapper.waitForBrowserToLoadCompletely();
			ArrayList<Integer> arr = new ArrayList<Integer>(0); 
			System.out.println("tester array value"+arr);
			if (wrapper.getElement_dynamic("Add_Contact_page_tab").isEmpty()==false)
			{
             	
				
				assertNotEquals(wrapper.getElement_dynamic("Add_Contact_page_tab"), arr);
	
		}
		}
		
		public synchronized void isGeneralInformationTabDisplayed_visible() throws InterruptedException, IOException {
			json = new JsonReaderfile();
			Reporter.log("Validate View General info  page is displayed");
			wrapper.click("Dashboard_header_link");
			wrapper.waitForBrowserToLoadCompletely();
			wrapper.click("ModalBox_AddProject");
			wrapper.waitForBrowserToLoadCompletely();
			String ExpTitle = json.getTestCaseData("ExpectedTitle");
			wrapper.waitForBrowserToLoadCompletely();
			if(wrapper.getElement_dynamic("Projectgeneralinfopage_text_Header_general_info")!=null)
             {

			assertNotEquals(wrapper.getElement_dynamic("Projectgeneralinfopage_text_Header_general_info"), null);

			} 
		}
		public synchronized void Select_Company_ModuleList() throws InterruptedException 
		{
			Reporter.log(" select sub menu list of category type");
			wrapper.selectByValue("Admin_select_modulelist", "10");
		}
		public synchronized void Select_subModuleList() throws InterruptedException 
		{
			Reporter.log(" open edit category page");
			wrapper.selectByValue("Admin_select_submudulelist", "MT_Categories");
		}
		
		public synchronized void Select_CommonList_value() throws InterruptedException 
		{
			Reporter.log("open edit category page");
			wrapper.selectByValue("Admin_select_submudulelist", "MT_ContactFields");
		}
		
		public synchronized void Select_CommonList_value_type() throws InterruptedException 
		{
			Reporter.log(" open edit category page");
			Thread.sleep(5000);
			wrapper.selectByValue("Admin_select_CommonListType", "Address");
	}
		
		
		public synchronized void Select_Company_subModuleList() throws InterruptedException 
		{
			Reporter.log(" open edit category page");
			wrapper.selectByValue("Admin_select_submudulelist", "MT_ClientType");
		}
		
		public synchronized void Select_Company_IndustryCluster() throws InterruptedException 
		{
			Reporter.log(" open edit category page");
			wrapper.selectByValue("Admin_select_submudulelist", "ServiceType");
		}
		
		public synchronized void Select_project_Source_drop_down() throws InterruptedException 
		{
			Reporter.log(" open edit category page");
			wrapper.selectByValue("Admin_select_submudulelist", "ProjectSource");
		}
		
		public synchronized void Select_Common_drop_down() throws InterruptedException 
		{
			Reporter.log(" open edit category page");
			wrapper.selectByValue("Admin_select_CommonListType", "Address");
		}
		
		String Categoryvalue= wrapper.generateRandomString(10);
		public synchronized void edit_category() throws InterruptedException 
		{
			Reporter.log(" edit category drop down name");
			wrapper.click("Admin_edit_category_name");
			wrapper.click("Admin_edit_category_title");
			wrapper.setTextBoxValue_Direct("Admin_edit_category_title", "GreatTest" );
			Thread.sleep(2000);
			wrapper.click("Admin_update_category_name");
			
			
		}
		
		String companycategoryvalue= wrapper.generateRandomString(10);
		public synchronized void edit_company_category() throws InterruptedException 
		{
			Reporter.log(" edit category drop down name");
			wrapper.click("Admin_edit_category_name");
			wrapper.click("Admin_edit_category_title");
			wrapper.setTextBoxValue_Direct("Admin_edit_category_title", "RajanComp" );
			Thread.sleep(2000);
			wrapper.click("Admin_update_category_name");
			
			
		}
		
		public synchronized void edit_company_category_visivility() throws InterruptedException 
		{
			Thread.sleep(1000);
			Reporter.log(" edit category drop down name");
			wrapper.click("Admin_edit_category_name");
			wrapper.click("Admin_Drop_down_checkbox_enable_company");
			wrapper.click("Admin_update_category_name");
			Thread.sleep(1000);
			
		}
		
		public synchronized void edit_common_address_visivility() throws InterruptedException 
		{
			Reporter.log(" edit category drop down name");
			wrapper.click("Admin_edit_common_address_button");
			wrapper.click("Admin_Drop_down_checkbox_enable_company");
			wrapper.click("Admin_update_category_name");
			Thread.sleep(1000);
			
			
		}
		
		public synchronized void validate_edited_companycategory_visible() throws InterruptedException 
		{
			wrapper.waitForBrowserToLoadCompletely();
		wrapper.dynamic_DropdownspanInputSearchListValidationValueSelection("RajanComp", "AddCompanyGeneralInfo_CompanyTypeClick" ,"AddCompanyGeneralInfo_CompanyTypeSearchBox", "AddCompanyGeneralInfo_CompanyListValue");
		}
		
		

		public synchronized void validate_edited_industrycluster_unvisible() throws InterruptedException 
		{
			wrapper.dynamic_DropdownspanInputSearchListValidationValueSelection_negative("Not Available", "AddCompanyGeneralInfo_IndustryCluster" ,"AddCoGeneralInfo_IndClusterSearchBox", "AddCoGeneralInfo_IndClusterListValue");
		}
		
		public synchronized void validate_edited_project_industrycluster_unvisible() throws InterruptedException 
		{
			wrapper.dynamic_DropdownspanInputSearchListValidationValueSelection_negative("Not Available", "ProjectGeneralinfo_IndustryCluster_ClickLocator" ,"ProjectGeneralinfo_IndustryCluster_SearchBoxlocator", "ProjectGeneralinfo_IndustryCluster_valueLocator");
		}
		public synchronized void validate_edited_project_source_unvisible() throws InterruptedException 
		{
			wrapper.dynamic_DropdownspanInputSearchListValidationValueSelection_negative("Cold Call", "ProjectGeneralInfoPage_DropDown_RFI_projectSource" ,"ProjectGeneralInfoPage_DropDown_RFI_projectSource_searchBox", "ProjectGeneralinfo_DropDown_RFI_ProjectSource_valueLocator");
		}
		
		public synchronized void validate_common_address_unvisible() throws InterruptedException 
		{
			wrapper.Dropdownvalueselection_negative("Other", "DropDown_address_type" , "AddCompanyGeneralInfo_EditBoxAddresstype");
		}
		
		public synchronized void validate_common_address_contact_unvisible() throws InterruptedException 
		{
			wrapper.Dropdownvalueselection_negative("Other", "AddContactGeneralInfo_EditBoxAddresstype" , "AddCompanyGeneralInfo_EditBoxAddresstype");
		}
		
		public synchronized void validate_common_address_contact_visible() throws InterruptedException 
		{
			wrapper.Dropdownvalueselection("Other", "AddContactGeneralInfo_EditBoxAddresstype" , "AddCompanyGeneralInfo_EditBoxAddresstype");
		}
	
		
		public synchronized void validate_address_unvisible() throws InterruptedException 
		
		{
			
			wrapper.Dropdownvalueselection_negative("Other", "AddCompanyGeneralInfo_EditBoxAddresstype" , "AddCompanyGeneralInfo_EditBoxAddresstype");
		}
		
		public synchronized void validate_address_visible() throws InterruptedException 
		{
			wrapper.Dropdownvalueselection("Other", "AddCompanyGeneralInfo_EditBoxAddresstype" , "AddCompanyGeneralInfo_EditBoxAddresstype");
		}
		
		public synchronized void validate_common_address_visible() throws InterruptedException 
		{
			wrapper.Dropdownvalueselection("Other", "ProjectGeneralInfoPage_DropDown_RFI_projectSource" , "ProjectGeneralinfo_DropDown_RFI_ProjectSource_valueLocator");
		}
		public synchronized void validate_edited_project_source_visible() throws InterruptedException 
		{
			wrapper.dynamic_DropdownspanInputSearchListValidationValueSelection("Cold Call", "ProjectGeneralInfoPage_DropDown_RFI_projectSource" ,"ProjectGeneralInfoPage_DropDown_RFI_projectSource_searchBox", "ProjectGeneralinfo_DropDown_RFI_ProjectSource_valueLocator");
		}
		public synchronized void validate_edited_compnayType_unvisible() throws InterruptedException 
		{
			
			Thread.sleep(1000);
			wrapper.dynamic_DropdownspanInputSearchListValidationValueSelection_negative(companycategoryvalue, "AddCompanyGeneralInfo_CompanyTypeClicknew" ,"AddCompanyGeneralInfo_CompanyTypeSearchBox", "AddCompanyGeneralInfo_CompanyListValue");
		}
		
		public synchronized void validate_industrycluster_visible() throws InterruptedException 
		{
			wrapper.dynamic_DropdownspanInputSearchListValidationValueSelection("N/A", "AddCompanyGeneralInfo_IndustryCluster" ,"AddCoGeneralInfo_IndClusterSearchBox", "AddCoGeneralInfo_IndClusterListValue");
		}
		
		
		public synchronized void validate_edited_project_industrycluster_visible() throws InterruptedException 
		{
			wrapper.dynamic_DropdownspanInputSearchListValidationValueSelection("Not Available", "ProjectGeneralinfo_IndustryCluster_ClickLocator" ,"ProjectGeneralinfo_IndustryCluster_SearchBoxlocator", "ProjectGeneralinfo_IndustryCluster_valueLocator");
		}
		
		public synchronized void validate_companytype_visible() throws InterruptedException 
		{
			wrapper.dynamic_DropdownspanInputSearchListValidationValueSelection("RajanComp", "AddCompanyGeneralInfo_CompanyTypeClick" ,"AddCompanyGeneralInfo_CompanyTypeSearchBox", "AddCompanyGeneralInfo_CompanyListValue");
		}
		
		public synchronized void add_select_submit_CompnayCategory_of_project() throws IOException, InterruptedException{

			Reporter.log("Select Category of company");
			wrapper.waitForElementVisibility("ProjectGeneralinfo_Icon_Category");
			wrapper.click("ProjectGeneralinfo_Icon_Category");
			wrapper.Dynamic_Dropdownvalueselection("GreatTest" , "CategoryId_listbox","ProjectGeneralinfo_DropDown_value_Company_Category" );

		}


		public synchronized void validateText_AdMindroppage() throws IOException{
			Reporter.log("Validate error message for incorrect login");
	
			wrapper.validateInnerText("Text_AdMindropadmin","ExpectedText");

		}
		
		public synchronized void Validate_AdMindrop_admin_link () throws IOException{
			Reporter.log("Validate error message for incorrect login");
			wrapper.click("Link_AdMindrop_admin_documents");

		}
		
		public synchronized void Validate_WorkforceDocumnet_link () throws IOException{
			Reporter.log("Validate workforce documnet link clickable");
			wrapper.click("workforcedocumnet_link");

		}
		
		public synchronized void Validate_AdMindrop_admin_innerlinks () throws IOException{
			Reporter.log("Validate error message for incorrect login");
			wrapper.click("Link_AdMindrop_admin_documents");
			wrapper.click("Link_AdMindropadmin_first_link");
			wrapper.validateInnerText("Link_AdMindropadmin_first_link","ExpectedText");
			wrapper.validateInnerText("Link_Landing_page","ExpectedTextLanding");
			wrapper.click("Link_admin_inner_link");
			wrapper.click("Link_admin_broucher");
			wrapper.validateInnerText("Link_admin_inner_link","ExpectedTextadmin");
			wrapper.validateInnerText("Link_admin_broucher","ExpectedTextBroucher");
			wrapper.click("Link_admins_sites");
			wrapper.validateInnerText("Link_admins_sites","ExpectedTextSites");
			wrapper.click("Link_admins_indutrial");
			wrapper.validateInnerText("Link_admins_indutrial","ExpectedTextIndustrial");
			wrapper.click("Link_admins_MixedUse");
			wrapper.validateInnerText("Link_admins_MixedUse","ExpectedTextMixedUse");
			wrapper.click("Link_admins_Office");
			wrapper.validateInnerText("Link_admins_Office","ExpectedTextOffice");
			wrapper.click("Link_admins_Retails");
			wrapper.validateInnerText("Link_admins_Retails","ExpectedTextRetail");
			wrapper.click("Link_admins_Retails");
			wrapper.validateInnerText("Link_admins_Retails","ExpectedTextRetail");
			wrapper.click("Link_admins_Buildings");
			wrapper.validateInnerText("Link_admins_Buildings","ExpectedTextBuildings");
			wrapper.click("Link_admins_Manufacturing");
			wrapper.validateInnerText("Link_admins_Manufacturing","ExpectedTextManufacturing");
			

		}

}
