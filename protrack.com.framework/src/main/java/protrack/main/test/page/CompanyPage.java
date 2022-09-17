package protrack.main.test.page;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import protrack.com.frame.core.BaseDriver;
import protrack.com.frame.core.BaseTest;
import protrack.com.frame.core.SeleniumHelper;
import protrack.com.frame.util.JsonReaderfile;
import protrack.com.test.suite.ExecutionEnvironment;

public class CompanyPage extends BaseTest{

	SeleniumHelper wrapper = new SeleniumHelper();
	JsonReaderfile json;
	BaseDriver base = new BaseDriver();
	ExecutionEnvironment exec=new ExecutionEnvironment();
	public WebElement element;
	String CompanyValue=null;

	public synchronized String createCompany() throws IOException, InterruptedException
	{
		isAddCompanyPageDisplayed();

		isGeneralInformationTabDisplayedandEnabled();
		String Companyname=AddCompanyGeneralInformationTabDetailsInsertion();

		isResourcesTabDisplayedAndEnabled();
		AddCompanyResourcesTabDetailsInsertion();

		isInteractionNotesTabDisplayedAndEnabled();
		AddCompanyInteractionNotesTabDetailsInsertion();

		return Companyname;

	}
	
	public synchronized String createCompany(String projectName) throws IOException, InterruptedException
	{
		isAddCompanyPageDisplayed();

		isGeneralInformationTabDisplayedandEnabled();
		String Companyname=AddCompanyGeneralInformationTabDetailsInsertion(projectName);

		isResourcesTabDisplayedAndEnabled();
		AddCompanyResourcesTabDetailsInsertion();

		isInteractionNotesTabDisplayedAndEnabled();
		AddCompanyInteractionNotesTabDetailsInsertion();

		return Companyname;

	}


	public synchronized String createCompanywithFewDetails(String projectName) throws IOException, InterruptedException
	{
		isAddCompanyPageDisplayed();

		isGeneralInformationTabDisplayedandEnabled();
		String Companyname=AddCompanyGeneralInformationTabDetailsInsertion(projectName);

		SubmitAndValidateCompanyCreated(Companyname);

		return Companyname;

	}
	
	public synchronized String createCompanywithFewDetails() throws IOException, InterruptedException
	{
		isAddCompanyPageDisplayed();

		isGeneralInformationTabDisplayedandEnabled();
		String Companyname=AddCompanyGeneralInformationTabDetailsInsertion();

		SubmitAndValidateCompanyCreated(Companyname);

		return Companyname;

	}
	
	public synchronized String createCompanywithFewDetails_dafc() throws IOException, InterruptedException
	{
		isAddCompanyPageDisplayed();

		isGeneralInformationTabDisplayedandEnabled();
		String Companyname=AddCompanyGeneralInformationTabDetailsInsertion_dafc();

		SubmitAndValidateCompanyCreated(Companyname);

		return Companyname;

	}


	public synchronized void SubmitAndValidateCompanyCreated(String ContactTitle) throws InterruptedException, IOException {

		wrapper.click("AddCompanySubmitButton");
		wrapper.zoomInZoomOut();
		validateCompanyCreated(ContactTitle);
	}



	public synchronized void isAddCompanyPageDisplayed() throws IOException, InterruptedException {
		json = new JsonReaderfile();
		Reporter.log("Validate Add Company page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		wrapper.click("ModalBox_AddCompany");
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateInnerText("InlineText_AddCompany", "ExpectedCompanypagetext");

		}
	}

	public synchronized void isGeneralInformationTabDisplayedandEnabled() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate View Contact List page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("AddCompany_GeneralInformationTab", "ExpectedGeneralInformationTabtext");
			wrapper.click("AddCompany_GeneralInformationTab");
			wrapper.validateElementVisibleandEnabled("AddCompany_GeneralInformationTab");
		}
	}

	public synchronized void isProjectDataTabDisplayedAndEnabled() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate View Contact List page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateInnerText("AddCompany_ProjectDataTab", "ExpectedProjectInfoTabtext");
			wrapper.click("AddCompany_ProjectDataTab");
			wrapper.validateElementVisibleandEnabled("AddCompany_ProjectDataTab");

		}

	}

	public synchronized void isResourcesTabDisplayedAndEnabled() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate View Contact List page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateInnerText("AddCompany_ResourcesTab", "ExpectedResourcesTabtext");
			wrapper.click("AddCompany_ResourcesTab");
			wrapper.validateElementVisibleandEnabled("AddCompany_ResourcesTab");

		}

	}

	public synchronized void isInteractionNotesTabDisplayedAndEnabled() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate View Contact List page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateInnerText("AddCompany_InteractionNotesTab", "ExpectedInteractionNotesTabtext");
			wrapper.click("AddCompany_InteractionNotesTab");
			wrapper.validateElementVisibleandEnabled("AddCompany_InteractionNotesTab");

		}

	}

	public synchronized void isAddCompanyGeneralInfoSocialPRofileEnabledAndDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Add Contact page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");

		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			Reporter.log("Validate Contact list page is in focus on Project management page");
			wrapper.validateInnerText("AddCompanyGeneralInfo_InlineTextSocialProfile", "ExpectedLInlineTextJobSocialProfile");

			Reporter.log("Validate Contact list page is in focus on Project management page");
			wrapper.validateElementVisibleandEnabled("AddCompanyGeneralInfo_EditBoxSocialProfileType");

			Reporter.log("Validate Contact list page is in focus on Project management page");
			wrapper.validateElementVisibleandEnabled("AddCompanyGeneralInfo_EditBoxSocialProfileValue");

			Reporter.log("Validate Contact list page is in focus on Project management page");
			wrapper.validateElementVisibleandEnabled("AddCompanyGeneralInfo_EditBoxSocialProfilename");


		}

	}

	public synchronized void isAddCompanyGeneralInfoURLEnabledAndDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Add Contact page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");

		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			Reporter.log("Validate Contact list page is in focus on Project management page");
			wrapper.validateInnerText("AddCompanyGeneralInfo_InlineTextURl", "ExpectedLInlineTextJobURl");

			Reporter.log("Validate Contact list page is in focus on Project management page");
			wrapper.validateElementVisibleandEnabled("AddCompanyGeneralInfo_EditBoxURLType");

			Reporter.log("Validate Contact list page is in focus on Project management page");
			wrapper.validateElementVisibleandEnabled("AddCompanyGeneralInfo_EditBoxURLValue");

			Reporter.log("Validate Contact list page is in focus on Project management page");
			wrapper.validateElementVisibleandEnabled("AddCompanyGeneralInfo_EditBoxURL");


		}

	}

	public synchronized void isAddCompanyGeneralInfoAddressEnabledAndDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Add Contact page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");

		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			Reporter.log("Validate Contact list page is in focus on Project management page");
			wrapper.validateInnerText("AddCompanyGeneralInfo_InlineTextAddress", "ExpectedLInlineTextJobAddress");

			Reporter.log("Validate Contact list page is in focus on Project management page");
			wrapper.validateElementVisibleandEnabled("AddCompanyGeneralInfo_EditBoxAddresstype");

			Reporter.log("Validate Contact list page is in focus on Project management page");
			wrapper.validateElementVisibleandEnabled("AddCompanyGeneralInfo_EditBoxAddressValueTown");

			Reporter.log("Validate Contact list page is in focus on Project management page");
			wrapper.validateElementVisibleandEnabled("AddCompanyGeneralInfo_EditBoxAddressValueAddress1");

			Reporter.log("Validate Contact list page is in focus on Project management page");
			wrapper.validateElementVisibleandEnabled("AddCompanyGeneralInfo_EditBoxAddressValueAddress2");

			Reporter.log("Validate Contact list page is in focus on Project management page");
			wrapper.validateElementVisibleandEnabled("AddCompanyGeneralInfo_EditBoxAddressValueStreet");

			Reporter.log("Validate Contact list page is in focus on Project management page");
			wrapper.validateElementVisibleandEnabled("AddCompanyGeneralInfo_EditBoxAddressValueAddressStatelist");

			Reporter.log("Validate Contact list page is in focus on Project management page");
			wrapper.validateElementVisibleandEnabled("AddCompanyGeneralInfo_EditBoxAddressValuezipcode");

			Reporter.log("Validate Contact list page is in focus on Project management page");
			wrapper.validateElementVisibleandEnabled("AddCompanyGeneralInfo_EditBoxAddressname");

		
		}
	}

	public synchronized void isAddCompanyGeneralInfoPhoneEnabledAndDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Add Contact page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");

		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			Reporter.log("Validate Contact list page is in focus on Project management page");
			wrapper.validateInnerText("AddCompanyGeneralInfo_InlineTextPhone", "ExpectedLInlineTextJobPhone");

			Reporter.log("Validate Contact list page is in focus on Project management page");
			wrapper.validateElementVisibleandEnabled("AddCompanyGeneralInfo_EditBoxPhonetype");

			Reporter.log("Validate Contact list page is in focus on Project management page");
			wrapper.validateElementVisibleandEnabled("AddCompanyGeneralInfo_EditBoxPhoneValue");

			Reporter.log("Validate Contact list page is in focus on Project management page");
			wrapper.validateElementVisibleandEnabled("AddCompanyGeneralInfo_EditBoxPhoneExtension");


		}

	}

	public synchronized void isAddCompanyGeneralInfoEmailEnabledAndDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Add Contact page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");

		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			Reporter.log("Validate Contact list page is in focus on Project management page");
			wrapper.validateInnerText("AddCompanyGeneralInfo_InlineTextEmail", "ExpectedLInlineTextJobEmail");

			Reporter.log("Validate Contact list page is in focus on Project management page");
			wrapper.validateElementVisibleandEnabled("AddCompanyGeneralInfo_EditBoxEmailtype");

			Reporter.log("Validate Contact list page is in focus on Project management page");
			wrapper.validateElementVisibleandEnabled("AddCompanyGeneralInfo_EditBoxEmailValue");

			Reporter.log("Validate Contact list page is in focus on Project management page");
			wrapper.validateElementVisibleandEnabled("AddCompanyGeneralInfo_EditBoxEmailName");


		}

	}

	public synchronized void isAddCompanyGeneralInfoNoteEnabledAndDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Add Contact page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");

		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			Reporter.log("Validate Contact list page is in focus on Project management page");
			wrapper.validateInnerText("AddCompanyGeneralInfo_InlineTextNotes", "ExpectedLInlineTextJobNotes");

			Reporter.log("Validate Contact list page is in focus on Project management page");
			wrapper.validateElementVisibleandEnabled("AddCompanyGeneralInfo_EditBoxNotes");


		}

	}

	public synchronized void isAddCompanyGeneralInfoDateEnabledAndDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Add Contact page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");

		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			Reporter.log("Validate Contact list page is in focus on Project management page");
			wrapper.validateInnerText("AddCompanyGeneralInfo_InlineTextDates", "ExpectedLInlineTextDates");

			Reporter.log("Validate Contact list page is in focus on Project management page");
			wrapper.validateElementVisibleandEnabled("AddCompanyGeneralInfo_DateType");

			Reporter.log("Validate Contact list page is in focus on Project management page");
			wrapper.validateElementVisibleandEnabled("AddCompanyGeneralInfo_ClickDates");

			Reporter.log("Validate Contact list page is in focus on Project management page");
			wrapper.validateElementVisibleandEnabled("AddCompanyGeneralInfo_DatesNote");


		}

	}

	public synchronized void isAddCompanyGeneralInfoCompanyNameEnabledAndDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Add Contact page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");

		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			Reporter.log("Validate Contact list page is in focus on Project management page");
			wrapper.validateInnerText("AddCompanyGeneralInfo_Companyinlinetext", "ExpectedLInlineTextCompanyName");

			Reporter.log("Validate Contact list page is in focus on Project management page");
			wrapper.validateElementVisibleandEnabled("AddCompanyGeneralInfo_Company");

		}

	}

	public synchronized void isAddCompanyGeneralInfoCompanyTypeEnabledAndDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Add Contact page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");

		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			Reporter.log("Validate Contact list page is in focus on Project management page");
			wrapper.validateInnerText("AddCompanyGeneralInfo_CompanyTypeinlinetext", "ExpectedLInlineTextCompanyType");

			Reporter.log("Validate Contact list page is in focus on Project management page");
			wrapper.validateElementVisibleandEnabled("AddCompanyGeneralInfo_CompanyType");

		}

	}

	public synchronized void isAddCompanyGeneralInfoProjectNameEnabledAndDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Add Contact page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");

		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			Reporter.log("Validate Contact list page is in focus on Project management page");
			wrapper.validateInnerText("AddCompanyGeneralInfo_ProjectNameinlinetext", "ExpectedLInlineTextProjectName");

			Reporter.log("Validate Contact list page is in focus on Project management page");
			wrapper.validateElementVisibleandEnabled("AddCompanyGeneralInfo_ProjectName");

		}

	}

	public synchronized void isAddCompanyGeneralInfoIndustryClusterEnabledAndDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Add Contact page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");

		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			Reporter.log("Validate Contact list page is in focus on Project management page");
			wrapper.validateInnerText("AddCompanyGeneralInfo_IndustryClusterinlinetext", "ExpectedLInlineTextIndustryCluster");

			Thread.sleep(2000);
			Reporter.log("Validate Contact list page is in focus on Project management page");
			wrapper.validateElementVisibleandEnabled("AddCompanyGeneralInfo_IndustryCluster");

		}

	}

	public synchronized void isAddCompanyGeneralInfoNAICSCodeEnabledAndDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Add Contact page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");

		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			Reporter.log("Validate Contact list page is in focus on Project management page");
			wrapper.validateInnerText("AddCompanyGeneralInfo_NAICSCodeinlinetext", "ExpectedLInlineTextNAICSCode");

			Reporter.log("Validate Contact list page is in focus on Project management page");
			wrapper.validateElementVisible("AddCompanyGeneralInfo_NAICSCode");

		}

	}


	public synchronized void isAddCompanyGeneralInfoFernEnabledAndDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Add Contact page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");

		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			Reporter.log("Validate Contact list page is in focus on Project management page");
			wrapper.validateInnerText("AddCompanyGeneralInfo_Ferninlinetext", "ExpectedLInlineTextFern");

			Reporter.log("Validate Contact list page is in focus on Project management page");
			wrapper.validateElementVisibleandEnabled("AddCompanyGeneralInfo_Fern");

		}

	}

	//*********************Methods for Resource Tab Validation along with the Filed listed under that**************************// 


	public synchronized void isAddContactResourceTab_DocDropDownDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Doc tpye Dropdown displayed under resource tab under Add Contact page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateElementVisibleandEnabled("AddCompanyResourceTab_DoctypeDropdown");

		} 


	}

	public synchronized void isAddCompanyResourceTab_DescriptionEnabledandDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Add Contact page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("AddCompanyResourceTab_inlinetextDescription", "ExpectedLInlineTextDescription");

			wrapper.waitForElementVisibility("AddCompanyResourceTab_Description");

			Reporter.log("Validate Contact list page is in focus on Project management page");
			wrapper.validateElementVisibleandEnabled("AddCompanyResourceTab_Description");

		} 

	}


	public synchronized void isAddCompanyResourceTab_KeywordEnabledandDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Add Contact page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateInnerText("AddCompanyResourceTab_inlinetextKeyword", "ExpectedLInlineTextKeyword");

			Reporter.log("Validate Contact list page is in focus on Project management page");
			wrapper.validateElementVisibleandEnabled("AddCompanyResourceTab_Keyword");


		} 

	}

	public synchronized void isAddCompanyResourceTab_UploadFileEnabledandDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Add Contact page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateInnerText("AddCompanyResourceTab_inlinetextUploadFile", "ExpectedLInlineTextUploadFile");

			Reporter.log("Validate Contact list page is in focus on Project management page");
			wrapper.validateElementVisible("AddCompanyResourceTab_UploadFile");

		} 

	}

	//*********************Methods for ineraction note Tab Validation along with the Filed listed under that**************************// 

	public synchronized void isAddCompanyinterNotes_NoteTypeVisibleAndDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Add Contact page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateInnerText("AddCompanyInteractionNotesTab_inlinenotetype", "ExpectedInteractionNotesTab_NoteType");

			Reporter.log("Validate Contact list page is in focus on Project management page");
			wrapper.validateElementVisible("AddCompanyInteractionNotesTab_notetype");

		} 


	}

	public synchronized void isAddCompanyinterNotes_AuthorVisibleAndDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Add Contact page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateInnerText("AddCompanyInteractionNotesTab_inlineAuthor", "ExpectedInteractionNotesTab_Author");

			Reporter.log("Validate Contact list page is in focus on Project management page");
			wrapper.validateElementVisible("AddCompanyInteractionNotesTab_Author");

		} 


	}

	public synchronized void isAddCompanyinterNotes_DateVisibleAndDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Add Contact page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("AddCompanyInteractionNotesTab_inlineDate", "ExpectedInteractionNotesTab_Date");

			Reporter.log("Validate Contact list page is in focus on Project management page");
			wrapper.validateElementVisible("AddCompanyInteractionNotesTab_Date");
		}
	}

	public synchronized void isAddCompanyinterNotes_DescriptionVisibleAndDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Add Contact page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("AddCompanyInteractionNotesTab_inlineDescription", "ExpectedInteractionNotesTab_Description");


			Reporter.log("Validate Contact list page is in focus on Project management page");
			wrapper.validateElementVisible("AddCompanyInteractionNotesTab_Description");
		}
	}

	public synchronized void isAddCompanyinterNotes_AttendeesVisibleAndDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Add Contact page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("AddCompanyInteractionNotesTab_inlineAttendee", "ExpectedInteractionNotesTab_Attendee");

			Reporter.log("Validate Contact list page is in focus on Project management page");
			wrapper.validateElementVisible("AddCompanyInteractionNotesTab_Attendee");

		}
	}

	public synchronized void isAddCompanyinterNotes_ShortDescVisibleAndDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Add Contact page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("AddCompanyInteractionNotesTab_inlineshortdesc", "ExpectedInteractionNotesTab_ShortDesc");

			Reporter.log("Validate Contact list page is in focus on Project management page");
			wrapper.validateElementVisible("AddCompanyInteractionNotesTab_Shortdesc");
		}
	}

	public synchronized void isAddCompanyinterNotes_FilesVisibleAndDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Add Contact page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("AddCompanyInteractionNotesTab_inlinefiles", "ExpectedInteractionNotesTab_File");


			Reporter.log("Validate Contact list page is in focus on Project management page");
			wrapper.validateElementVisible("AddCompanyInteractionNotesTab_Files");
		}
	}

	public synchronized void isAddCompanyinterNotes_ProjectVisibleAndDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Add Contact page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("AddCompanyInteractionNotesTab_inlineProject", "ExpectedInteractionNotesTab_Project");

			Reporter.log("Validate Contact list page is in focus on Project management page");
			wrapper.validateElementVisible("AddCompanyInteractionNotesTab_Project");
		}
	}

	//*********************Methods for adding value in the generalInformationtab along with the Filed listed under that**************************// 


	public synchronized String AddCompanyGeneralInformationTabDetailsInsertion(String projectName) throws InterruptedException {

		String CompanyValue=AddCompanyGeneralInfo_CompanyValue();
		AddCompanyGeneralInfo_DropDownCompany();
		AddCompanyGeneralInfo_DropDownProject(projectName);
		AddCompanyGeneralInfo_DropDown_IndCluster();
		AddCompanyGeneralInfo_DropDown_NAICSCode();
		AddCompanyGeneralInfo_DropDown_Fern();
		AddCompanyGeneralInfo_DropDown_DateFiled();
		AddCompanyGeneralInfo_Notes();
		AddCompanyGeneralInfo_DropDown_PhoneDetails();
		AddCompanyGeneralInfo_DropDown_EmailDetails();
		AddCompanyGeneralInfo_DropDown_AddressDetails();
		AddCompanyGeneralInfo_DropDown_URLDetails();
		AddCompanyGeneralInfo_DropDown_ProfileDetails();
		
		return CompanyValue;

	}

	public synchronized String AddCompanyGeneralInformationTabDetailsInsertion() throws InterruptedException {

		String CompanyValue=AddCompanyGeneralInfo_CompanyValue();
		AddCompanyGeneralInfo_DropDownCompany();
		AddCompanyGeneralInfo_DropDownProject();
		AddCompanyGeneralInfo_DropDown_IndCluster();
		AddCompanyGeneralInfo_DropDown_NAICSCode();
		AddCompanyGeneralInfo_DropDown_Fern();
		Thread.sleep(3000);
		AddCompanyGeneralInfo_DropDown_DateFiled();
		addCompany_Date_Grid();
		AddCompanyGeneralInfo_Notes();
		AddCompanyGeneralInfo_DropDown_PhoneDetails();
		AddCompanyGeneralInfo_DropDown_EmailDetails();
		AddCompanyGeneralInfo_DropDown_AddressDetails();
		AddCompanyGeneralInfo_DropDown_URLDetails();
		AddCompanyGeneralInfo_DropDown_ProfileDetails();
		
		
		return CompanyValue;

	}
	
	public synchronized String AddCompanyGeneralInformationTabDetailsInsertion_dafc() throws InterruptedException {

		String CompanyValue=AddCompanyGeneralInfo_CompanyValue();
		AddCompanyGeneralInfo_DropDownCompany();
		AddCompanyGeneralInfo_DropDownProject();
		AddCompanyGeneralInfo_DropDown_IndCluster();
		AddCompanyGeneralInfo_DropDown_NAICSCode();
		AddCompanyGeneralInfo_DropDown_Fern();
		Thread.sleep(6000);
		AddCompanyGeneralInfo_DropDown_DateFiled_dafc();
		AddCompanyGeneralInfo_Notes();
		AddCompanyGeneralInfo_DropDown_PhoneDetails_dafc();
		AddCompanyGeneralInfo_DropDown_EmailDetails_dafc();
		AddCompanyGeneralInfo_DropDown_AddressDetails_dafc();
		AddCompanyGeneralInfo_DropDown_URLDetails_dafc();
		AddCompanyGeneralInfo_DropDown_ProfileDetails_dafc();
		
		return CompanyValue;

	}
	public synchronized String AddCompanyGeneralInfo_CompanyValue() throws InterruptedException {

		this.CompanyValue=wrapper.generateRandomString(20);

		Reporter.log("inserting data in general information tab  for filed AddCompanyGeneralInfo_Company while creating new company info");
		wrapper.setTextBoxValue_Direct("AddCompanyGeneralInfo_Company", CompanyValue);

		return CompanyValue;

	}

	public synchronized void AddCompanyGeneralInfo_DropDownCompany() throws InterruptedException {


		Reporter.log("inserting data in general information tab  for filed AddCompanyGeneralInfo_Company while creating new company info");
		wrapper.DropdownspanInputSearchListValidationValueSelection("Com_DropDown_Company", "AddCompanyGeneralInfo_CompanyTypeClick" ,"AddCompanyGeneralInfo_CompanyTypeSearchBox", "AddCompanyGeneralInfo_CompanyListValue");

	}

	public synchronized void AddCompanyGeneralInfo_DropDownProject(String validationName) throws InterruptedException {


		Reporter.log("inserting data in general information tab  for filed AddCompanyGeneralInfo_Project while creating new company info");
		wrapper.dynamic_DropdownspanInputSearchListValidationValueSelection(validationName, "AddCompanyGeneralInfo_ProjectName" ,"AddCompanyGeneralInfo_ProjectTypeSearchBox", "AddCompanyGeneralInfo_ProjectListValue");

	}

	public synchronized void AddCompanyGeneralInfo_DropDownProject() throws InterruptedException {

      
		Reporter.log("inserting data in general information tab  for filed AddCompanyGeneralInfo_Project while creating new company info");
		wrapper.DropdownspanInputSearchListValidationValueSelection("Com_DropDown_Project", "AddCompanyGeneralInfo_ProjectName" ,"AddCompanyGeneralInfo_ProjectTypeSearchBox", "AddCompanyGeneralInfo_ProjectListValue");

	}

	public synchronized void AddCompanyGeneralInfo_DropDown_IndCluster() throws InterruptedException {


		Reporter.log("inserting data in general information tab  for filed AddCompanyGeneralInfo_Project while creating new company info");
		wrapper.DropdownspanInputSearchListValidationValueSelection("DropDown_IndCluster", "AddCompanyGeneralInfo_IndustryCluster" ,"AddCoGeneralInfo_IndClusterSearchBox", "AddCoGeneralInfo_IndClusterListValue");

	}

	public synchronized void AddCompanyGeneralInfo_DropDown_NAICSCode() throws InterruptedException {


		Reporter.log("inserting data in general information tab  for filed AddCompanyGeneralInfo_NAICSCode while creating new company info");
		wrapper.Dropdownvalueselection("DropDown_NAICSCode","AddCompanyGeneralInfo_NAICSCode", "AddCompanyGeneralInfo_NAICSCodeListValue");


	}
	
	public synchronized void AddCompanyGeneralInfo_DropDown_Fern() throws InterruptedException {

		Reporter.log("inserting data in general information tab  for filed AddCompanyGeneralInfo_Fern while creating new company info");
		wrapper.setTextBoxValue_Direct("AddCompanyGeneralInfo_Fern", wrapper.generateRandomString(20));	

	}
	public synchronized void add_Select_submit_Companydatetype() throws InterruptedException 
	{
		Reporter.log("Add Company Date type");
		wrapper.isSelectDropdown("Drop_down_companyType");
	}

	
	public synchronized void AddCompanyGeneralInfo_DropDown_DateFiled() throws InterruptedException {

		Reporter.log("inserting data in general information tab  for filed AddCompanyGeneralInfo_DateType while creating new company info");
		wrapper.WaitForElementThenClick("AddCompanyGeneralInfo_DateType");
		wrapper.selectByValue("AddCompanyGeneralInfo_DateType", "358");
		wrapper.click("AddCompanyGeneralInfo_ClickDates");
		wrapper.datePickFromCalendar("AddContactGeneralInfo_fromDates", "1");
		wrapper.setTextBoxValue_Direct("AddCompanyGeneralInfo_DatesNote", wrapper.generateRandomString(10));

	
	}
	
	public synchronized void AddCompanyGeneralInfo_DropDown_DateFiled_dafc() throws InterruptedException {

		Reporter.log("inserting data in general information tab  for filed AddCompanyGeneralInfo_DateType while creating new company info");
		wrapper.WaitForElementThenClick("AddCompanyGeneralInfo_DateType");
		wrapper.selectByValue("AddCompanyGeneralInfo_DateType", "349");
		wrapper.click("AddCompanyGeneralInfo_ClickDates");
		wrapper.datePickFromCalendar("AddContactGeneralInfo_fromDates", "1");
		wrapper.setTextBoxValue_Direct("AddCompanyGeneralInfo_DatesNote", wrapper.generateRandomString(10));

	
	}
    
	public synchronized String addCompany_Date_Grid() throws InterruptedException
	
	{
		wrapper.click("Comapnygeneralinfo_dategrid_icon");
		return classResult;
		
			
		
		
	}
	public synchronized void AddCompanyGeneralInfo_Notes() throws InterruptedException {

	Reporter.log("inserting data in general information tab  for filed AddCompanyGeneralInfo_EditBoxNotes while creating new company info");
	wrapper.setTextBoxValue_Direct("AddCompanyGeneralInfo_EditBoxNotes", wrapper.generateRandomString(10));
	}
	
	
	public synchronized void AddCompanyGeneralInfo_DropDown_PhoneDetails() throws InterruptedException {
	
	Reporter.log("inserting data in general information tab  for filed AddCompanyGeneralInfo_EditBoxPhone while creating new company info");
	wrapper.waitForElementVisibility("AddCompanyGeneralInfo_EditBoxPhonetype");
	wrapper.selectByValue("AddCompanyGeneralInfo_EditBoxPhonetype", "62");
	wrapper.setTextBoxValue_Direct("AddCompanyGeneralInfo_EditBoxPhoneValue", wrapper.generateRandomString(10));
	wrapper.setTextBoxValue_Direct("AddCompanyGeneralInfo_EditBoxPhoneExtension", wrapper.GenerateRandomNumber(10));
	}
	public synchronized void AddCompanyGeneralInfo_DropDown_PhoneDetails_dafc() throws InterruptedException {
		
		Reporter.log("inserting data in general information tab  for filed AddCompanyGeneralInfo_EditBoxPhone while creating new company info");
		wrapper.waitForElementVisibility("AddCompanyGeneralInfo_EditBoxPhonetype");
		wrapper.selectByValue("AddCompanyGeneralInfo_EditBoxPhonetype", "38");
		wrapper.setTextBoxValue_Direct("AddCompanyGeneralInfo_EditBoxPhoneValue", wrapper.generateRandomString(10));
		wrapper.setTextBoxValue_Direct("AddCompanyGeneralInfo_EditBoxPhoneExtension", wrapper.GenerateRandomNumber(10));
		}
	

	public synchronized void AddCompanyGeneralInfo_DropDown_EmailDetails() throws InterruptedException {

	Reporter.log("inserting data in general information tab  for filed AddCompanyGeneralInfo_EditBoxPhone while creating new company info");
	wrapper.waitForElementVisibility("AddCompanyGeneralInfo_EditBoxEmailtype");
	wrapper.selectByValue("AddCompanyGeneralInfo_EditBoxEmailtype", "67");
	wrapper.setTextBoxValue_Direct("AddCompanyGeneralInfo_EditBoxEmailValue", wrapper.generateRandomString(10));
	wrapper.setTextBoxValue_Direct("AddCompanyGeneralInfo_EditBoxEmailName", wrapper.GenerateRandomNumber(10));
	}
	public synchronized void AddCompanyGeneralInfo_DropDown_EmailDetails_dafc() throws InterruptedException {

		Reporter.log("inserting data in general information tab  for filed AddCompanyGeneralInfo_EditBoxPhone while creating new company info");
		wrapper.waitForElementVisibility("AddCompanyGeneralInfo_EditBoxEmailtype");
		wrapper.selectByValue("AddCompanyGeneralInfo_EditBoxEmailtype", "10");
		wrapper.setTextBoxValue_Direct("AddCompanyGeneralInfo_EditBoxEmailValue", wrapper.generateRandomString(10));
		wrapper.setTextBoxValue_Direct("AddCompanyGeneralInfo_EditBoxEmailName", wrapper.GenerateRandomNumber(10));
		}
		
	public synchronized void AddCompanyGeneralInfo_DropDown_AddressDetails() throws InterruptedException {

	Reporter.log("inserting data in general information tab  for filed AddCompanyGeneralInfo_EditBoxAddress while creating new company info");
	wrapper.waitForElementVisibility("AddCompanyGeneralInfo_EditBoxAddresstype");
	wrapper.selectByValue("AddCompanyGeneralInfo_EditBoxAddresstype", "70");
	wrapper.setTextBoxValue_Direct("AddCompanyGeneralInfo_EditBoxAddressValueTown", wrapper.GenerateRandomNumber(10));
	wrapper.setTextBoxValue_Direct("AddCompanyGeneralInfo_EditBoxAddressValueAddress1", wrapper.GenerateRandomNumber(10));
	wrapper.setTextBoxValue_Direct("AddCompanyGeneralInfo_EditBoxAddressValueAddress2", wrapper.generateRandomString(10));
	wrapper.selectByValue("AddCompanyGeneralInfo_EditBoxAddressValueStreet", "2");
	//wrapper.selectByValue("AddCompanyGeneralInfo_EditBoxAddressValueAddressStatelist", "30");
	wrapper.setTextBoxValue_Direct("AddCompanyGeneralInfo_EditBoxAddressValuezipcode", wrapper.GenerateRandomNumber(10));
	wrapper.setTextBoxValue_Direct("AddCompanyGeneralInfo_EditBoxAddressname", wrapper.generateRandomString(10));
	//wrapper.setTextBoxValue_Direct("AddCompanyGeneralInfo_EditBoxTextMap", wrapper.GenerateRandomNumber(10));
	//wrapper.setTextBoxValue_Direct("AddCompanyGeneralInfo_EditBoxSchoolDistict", wrapper.GenerateRandomNumber(10));
	//wrapper.setTextBoxValue_Direct("AddCompanyGeneralInfo_EditBoxAddressAcreage", wrapper.GenerateRandomNumber(10));
	}
	public synchronized void AddCompanyGeneralInfo_DropDown_AddressDetails_dafc() throws InterruptedException {

		Reporter.log("inserting data in general information tab  for filed AddCompanyGeneralInfo_EditBoxAddress while creating new company info");
		wrapper.waitForElementVisibility("AddCompanyGeneralInfo_EditBoxAddresstype");
		wrapper.selectByValue("AddCompanyGeneralInfo_EditBoxAddresstype", "12");
		wrapper.setTextBoxValue_Direct("AddCompanyGeneralInfo_EditBoxAddressValueTown", wrapper.GenerateRandomNumber(10));
		wrapper.setTextBoxValue_Direct("AddCompanyGeneralInfo_EditBoxAddressValueAddress1", wrapper.GenerateRandomNumber(10));
		wrapper.setTextBoxValue_Direct("AddCompanyGeneralInfo_EditBoxAddressValueAddress2", wrapper.generateRandomString(10));
		wrapper.selectByValue("AddCompanyGeneralInfo_EditBoxAddressValueStreet", "2");
		//wrapper.selectByValue("AddCompanyGeneralInfo_EditBoxAddressValueAddressStatelist", "30");
		wrapper.setTextBoxValue_Direct("AddCompanyGeneralInfo_EditBoxAddressValuezipcode", wrapper.GenerateRandomNumber(10));
		wrapper.setTextBoxValue_Direct("AddCompanyGeneralInfo_EditBoxAddressname", wrapper.generateRandomString(10));
		wrapper.setTextBoxValue_Direct("AddCompanyGeneralInfo_EditBoxTextMap", wrapper.GenerateRandomNumber(10));
		wrapper.setTextBoxValue_Direct("AddCompanyGeneralInfo_EditBoxSchoolDistict", wrapper.GenerateRandomNumber(10));
		wrapper.setTextBoxValue_Direct("AddCompanyGeneralInfo_EditBoxAddressAcreage", wrapper.GenerateRandomNumber(10));
		}
	public synchronized void AddCompanyGeneralInfo_DropDown_URLDetails() throws InterruptedException {

	Reporter.log("inserting data in general information tab  for filed AddCompanyGeneralInfo_EditBoxURLType while creating new company info");
	wrapper.WaitForElementThenClick("AddCompanyGeneralInfo_EditBoxURLType");
	wrapper.selectByValue("AddCompanyGeneralInfo_EditBoxURLType", "103");
	wrapper.setTextBoxValue_Direct("AddCompanyGeneralInfo_EditBoxURLValue", wrapper.generateRandomString(10));
	wrapper.setTextBoxValue_Direct("AddCompanyGeneralInfo_EditBoxURL", wrapper.GenerateRandomNumber(10));
	}
	public synchronized void AddCompanyGeneralInfo_DropDown_URLDetails_dafc() throws InterruptedException {

		Reporter.log("inserting data in general information tab  for filed AddCompanyGeneralInfo_EditBoxURLType while creating new company info");
		wrapper.WaitForElementThenClick("AddCompanyGeneralInfo_EditBoxURLType");
		wrapper.selectByValue("AddCompanyGeneralInfo_EditBoxURLType", "4");
		wrapper.setTextBoxValue_Direct("AddCompanyGeneralInfo_EditBoxURLValue", wrapper.generateRandomString(10));
		wrapper.setTextBoxValue_Direct("AddCompanyGeneralInfo_EditBoxURL", wrapper.GenerateRandomNumber(10));
		}
	
	public synchronized void AddCompanyGeneralInfo_DropDown_ProfileDetails() throws InterruptedException {

	Reporter.log("inserting data in general information tab  for filed AddCompanyGeneralInfo_EditBoxSocialProfilename while creating new company info");
	wrapper.WaitForElementThenClick("AddCompanyGeneralInfo_EditBoxSocialProfileType");
	wrapper.selectByValue("AddCompanyGeneralInfo_EditBoxSocialProfileType", "108");
	wrapper.setTextBoxValue_Direct("AddCompanyGeneralInfo_EditBoxSocialProfileValue", wrapper.generateRandomString(10));
	wrapper.setTextBoxValue_Direct("AddCompanyGeneralInfo_EditBoxSocialProfilename", wrapper.GenerateRandomNumber(10));
	}
	public synchronized void AddCompanyGeneralInfo_DropDown_ProfileDetails_dafc() throws InterruptedException {

		Reporter.log("inserting data in general information tab  for filed AddCompanyGeneralInfo_EditBoxSocialProfilename while creating new company info");
		wrapper.WaitForElementThenClick("AddCompanyGeneralInfo_EditBoxSocialProfileType");
		wrapper.selectByValue("AddCompanyGeneralInfo_EditBoxSocialProfileType", "11");
		wrapper.setTextBoxValue_Direct("AddCompanyGeneralInfo_EditBoxSocialProfileValue", wrapper.generateRandomString(10));
		wrapper.setTextBoxValue_Direct("AddCompanyGeneralInfo_EditBoxSocialProfilename", wrapper.GenerateRandomNumber(10));
		}

	public synchronized void AddCompanyResourcesTabDetailsInsertion() throws InterruptedException
	{
		Reporter.log("inserting data in general information tab  for filed AddCompanyResourceTab_DoctypeDropdown while creating new company info");
		wrapper.waitForElementVisibility("AddCompanyResourceTab_DoctypeDropdown");
		wrapper.selectByValue("AddCompanyResourceTab_DoctypeDropdown", "49");

		Reporter.log("inserting data in general information tab  for filed AddCompanyResourceTab_Description while creating new company info");
		wrapper.setTextBoxValue_Direct("AddCompanyResourceTab_Description", wrapper.generateRandomString(100));

		Reporter.log("inserting data in general information tab  for filed AddCompanyResourceTab_Keyword while creating new company info");
		wrapper.setTextBoxValue_Direct("AddCompanyResourceTab_Keyword", wrapper.generateRandomString(10));
		this.element=wrapper.getElement("AddCompanyResourceTab_Keyword");
		element.sendKeys(Keys.TAB);

		Reporter.log("inserting data in general information tab  for filed AddCompanyResourceTab_UploadFileClick while creating new company info");
		  wrapper.click("Project_resources_upload_doc");
		  Thread.sleep(1000);
		  wrapper.click("Project_resources_upload_Localdoc_link_on_PopUp");   
		   this.element=wrapper.getElement("Comapany_resource_uploadfilepath");
			element.sendKeys(System.getProperty("user.dir") +File.separator+"qa.pdf");
			wrapper.click("Project_resources_select_Upload_attached_button");
			Thread.sleep(1000);
			wrapper.click("Project_resources_upload_doc");
			wrapper.click("Project_resources_upload_libracryDoc_link_on_PopUp"); 
			Thread.sleep(1000);
			wrapper.click("Project_resources_select_doc_from_library");
			wrapper.click("Project_resources_select_Upload_attached_button");


	}

	public synchronized void AddCompanyInteractionNotesTabDetailsInsertion() throws InterruptedException
	{
		Reporter.log("inserting data in general information tab  for filed AddCompanyInteractionNotesTab_notetype while creating new company info");
		wrapper.waitForElementVisibility("AddCompanyInteractionNotesTab_notetype");
		wrapper.selectByValue("AddCompanyInteractionNotesTab_notetype", "Phone call");


		Reporter.log("inserting data in general information tab  for filed AddCompanyInteractionNotesTab_Author while creating new company info");
		wrapper.setTextBoxValue_Direct("AddCompanyInteractionNotesTab_Author", wrapper.generateRandomString(10));


		Reporter.log("inserting data in general information tab  for filed AddCompanyInteractionNotesTab_Description while creating new company info");
		wrapper.setTextBoxValue_Direct("AddCompanyInteractionNotesTab_Description", wrapper.generateRandomString(10));

		Reporter.log("inserting data in general information tab  for filed AddCompanyInteractionNotesTab_Attendee while creating new company info");
		//	wrapper.Dropdownvalueselection("DropDown_Attendee", "AddCompanyInteractionNotesTab_Attendee", "AddCompanyInteractionNotesTab_AttendeeListValue");


		Reporter.log("inserting data in general information tab  for filed AddCompanyInteractionNotesTab_Shortdesc while creating new company info");
		wrapper.setTextBoxValue_Direct("AddCompanyInteractionNotesTab_Shortdesc", wrapper.generateRandomString(10));

		Reporter.log("inserting data in general information tab  for filed AddCompanyInteractionNotesTab_Files while creating new company info");
		this.element=wrapper.getElement("AddCompanyInteractionNotesTab_FilesClick");
		element.sendKeys(System.getProperty("user.dir") +File.separator+"qa.pdf");

		Reporter.log("inserting data in general information tab  for filed AddCompanyResourceTab_DoctypeDropdown while creating new company info");
		//	wrapper.DropdownspanInputSearchListValidationValueSelection( "internotes_ProjectValue","AddCompanyInteractionNotesTab_Project","AddCompanyInteractionNotesTab_ProjectSearchBox", "AddCompanyInteractionNotesTab_ProjectListValue" );

	}

	public synchronized void validateCompanyCreated(String ExpTitle) throws InterruptedException
	{
		Reporter.log("Validate Add Contact page is displayed");

		String Actualtitle=wrapper.getElement("ContactCreateTitle").getText();
		System.out.println("expected title value is " + Actualtitle);

		//		wrapper(ExpTitle, Actualtitle);
		wrapper.validateTextDirectly("Actual and expected value is displaying correcting and same", ExpTitle, Actualtitle);

	}
	
	public synchronized void Validate_Company_PhoneType(String selectByValue, String valueText) throws IOException, InterruptedException
	{
		isAddCompanyPageDisplayed();

		isGeneralInformationTabDisplayedandEnabled();
		String CompanyValue=AddCompanyGeneralInfo_CompanyValue();
		AddCompanyGeneralInfo_DropDownCompany();
		AddCompanyGeneralInfo_DropDownProject();
		AddCompanyGeneralInfo_DropDown_IndCluster();
		AddCompanyGeneralInfo_DropDown_NAICSCode();
		AddCompanyGeneralInfo_DropDown_Fern();
		AddCompanyGeneralInfo_DropDown_DateFiled();
		AddCompanyGeneralInfo_Notes();
		AddCompanyGeneralInfo_DropDown_PhoneDetails(CompanyValue, selectByValue, valueText);



	}
	
	public synchronized void AddCompanyGeneralInfo_DropDown_PhoneDetails(String CompanyValue, String selectByValue, String valueText ) throws InterruptedException, IOException {
		
		Reporter.log("inserting data in general information tab  for filed AddCompanyGeneralInfo_EditBoxPhone while creating new company info");
		String phoneTypeText=enterPhoneTypeDetails(selectByValue, valueText);
		String phonenumber=enterPhoneNumberDetails();
		String phoneExtension=enterPhoneExtensionrDetails();
		
		clickonPlusSignLocator();

		System.out.println(phoneTypeText + "  " + phonenumber + " " + phoneExtension );

//		wrapper.validateDynamicText("AddContactGeneralInfo_EditBoxPhonetpyeText", valueText, phoneTypeText);
//		wrapper.validateDynamicText("AddContactGeneralInfo_EditBoxPhoneValueText",phonenumber, phonenumber);
//		wrapper.validateDynamicText("AddContactGeneralInfo_EditBoxPhoneExtensionText",phoneExtension, phoneExtension);
//
//		SubmitAndValidateCompanyCreated(CompanyValue);
//		wrapper.waitForBrowserToLoadCompletely();
//
//		wrapper.validateActualAndExpectedTextDirectly("AddContactGeneralInfo_SavedPhonetpye", phoneTypeText);
//		wrapper.validateActualAndExpectedTextDirectly("AddContactGeneralInfo_SavedPhoneValueText", phonenumber);
//		wrapper.validateActualAndExpectedTextDirectly("AddContactGeneralInfo_SavedPhoneExtensionText", phoneExtension);


	}
	
	public synchronized String enterPhoneTypeDetails(String selectByValue, String valueText) throws InterruptedException {

		Reporter.log("inserting data in general information tab while creating new contact info");

		wrapper.waitForElementVisibility("AddCompanyGeneralInfo_EditBoxPhonetype");
		wrapper.selectByValue("AddCompanyGeneralInfo_EditBoxPhonetype", selectByValue);
	
//		String phoneTypeValue=wrapper.getTextValueUsingSpecificElement("AddContactGeneralInfo_EditBoxPhonetpyeText", valueText).getText();
//		System.out.println("phoneTypeValue " + phoneTypeValue);
		return valueText;
		

	}
	
	public synchronized String enterPhoneNumberDetails() throws InterruptedException {

		Reporter.log("inserting data  by enterPhoneNumberDetails in general information tab while creating new contact info");

		String Phonenumber=wrapper.generateRandomString(10);
		wrapper.setTextBoxValue_Direct("AddCompanyGeneralInfo_EditBoxPhoneValue", Phonenumber);
		return Phonenumber;


	}

	public synchronized String enterPhoneExtensionrDetails() throws InterruptedException {

		Reporter.log("inserting data by AddContactGeneralInfo_phoneExtension in general information tab while creating new contact info");
		String phoneExtension=wrapper.GenerateRandomNumber(10);
		wrapper.setTextBoxValue_Direct("AddCompanyGeneralInfo_EditBoxPhoneExtension", phoneExtension);
		return phoneExtension;

	}


	public synchronized void clickonPlusSignLocator() throws InterruptedException {

		Reporter.log("inserting data by clickonPlusSignLocator in general information tab while creating new contact info");
		wrapper.click("CreCompany_phone_PlusiconClickLocator");


	}
	
	public synchronized void Validate_Company_EmailType(String selectByValue, String valueText) throws IOException, InterruptedException
	{
		isAddCompanyPageDisplayed();

		isGeneralInformationTabDisplayedandEnabled();
		String CompanyValue=AddCompanyGeneralInfo_CompanyValue();
		AddCompanyGeneralInfo_DropDownCompany();
		AddCompanyGeneralInfo_DropDownProject();
		AddCompanyGeneralInfo_DropDown_IndCluster();
		AddCompanyGeneralInfo_DropDown_NAICSCode();
		AddCompanyGeneralInfo_DropDown_Fern();
		AddCompanyGeneralInfo_DropDown_DateFiled();
		AddCompanyGeneralInfo_Notes();
		AddCompanyGeneralInfo_DropDown_PhoneDetails();
		AddCompanyGeneralInfo_DropDown_EmailDetails(CompanyValue, selectByValue, valueText);
		

	}

	public synchronized void AddCompanyGeneralInfo_DropDown_EmailDetails(String CompanyValue, String selectByValue, String valueText ) throws InterruptedException, IOException {

	Reporter.log("inserting data in general information tab  for filed AddCompanyGeneralInfo_EditBoxPhone while creating new company info");
	enterEmailTypeDetails(selectByValue, valueText);
	enterEmailNumberDetails();
	enterEmailExtensionrDetails();
	clickonEmailPlusSignLocator();
	SubmitAndValidateCompanyCreated(CompanyValue);
	wrapper.waitForBrowserToLoadCompletely();
	
	}
	
	public synchronized String enterEmailTypeDetails(String selectByValue, String valueText) throws InterruptedException {

		Reporter.log("inserting data in general information tab while creating new contact info");

		wrapper.waitForElementVisibility("AddCompanyGeneralInfo_EditBoxEmailtype");
		wrapper.selectByValue("AddCompanyGeneralInfo_EditBoxEmailtype", selectByValue);
	
//		String phoneTypeValue=wrapper.getTextValueUsingSpecificElement("AddContactGeneralInfo_EditBoxPhonetpyeText", valueText).getText();
//		System.out.println("phoneTypeValue " + phoneTypeValue);
		return valueText;
		

	}
	
	public synchronized String enterEmailNumberDetails() throws InterruptedException {

		Reporter.log("inserting data  by enterPhoneNumberDetails in general information tab while creating new contact info");

		String EmailNumber="er.rahu@gmail.com";
		wrapper.setTextBoxValue_Direct("AddCompanyGeneralInfo_EditBoxEmailValue", EmailNumber);
		return EmailNumber;


	}

	public synchronized String enterEmailExtensionrDetails() throws InterruptedException {

		Reporter.log("inserting data by AddContactGeneralInfo_phoneExtension in general information tab while creating new contact info");
		String emailExtension=wrapper.GenerateRandomNumber(10);
		wrapper.setTextBoxValue_Direct("AddCompanyGeneralInfo_EditBoxEmailName", emailExtension);
		return emailExtension;

	}


	public synchronized void clickonEmailPlusSignLocator() throws InterruptedException {

		Reporter.log("inserting data by clickonPlusSignLocator in general information tab while creating new contact info");
		wrapper.click("CreCompany_Email_PlusiconClickLocator");


	}

	  public synchronized String Searchtexton_companypage_Company_Name(String type) throws InterruptedException
   	
   	{
   	
	    wrapper.click("ModalBox_ViewCompanyList");
   		wrapper.waitForBrowserToLoadCompletely();
   		wrapper.click("Company_search_box");	
   		wrapper.enterTexttoSearchinSeachBox_DropDown("Deployment_Company_Testing", "Company_search_box");
   		wrapper.hitEnter();
   		wrapper.click("Company_name_title");
   		wrapper.waitForBrowserToLoadCompletely();
   		String matchvalue= "Deployment_Company_Testing";
   		wrapper.validateActualAndExpectedTextDirectly_attributevalue("CompanyName", matchvalue, type);
   		wrapper.waitForBrowserToLoadCompletely();
   		
   		
   		
   		
   	   return testCaseName;
   			
   		
   		
   	}
	  public synchronized String Searchtexton_companypage_Company_Type() throws InterruptedException
	   	
	   	{
	   	
		    wrapper.click("ModalBox_ViewCompanyList");
	   		wrapper.waitForBrowserToLoadCompletely();
	   		wrapper.click("Company_search_box");	
	   		wrapper.enterTexttoSearchinSeachBox_DropDown("Former Client", "Company_search_box");
	   		wrapper.hitEnter();
	   		wrapper.click("Company_name_title");
	   		wrapper.waitForBrowserToLoadCompletely();
	   		String matchvalue= "Former Client";
	   		wrapper.validateActualAndExpectedTextDirectly("CompanyType", matchvalue);
	   		wrapper.waitForBrowserToLoadCompletely();
	   		
	   		
	   		
	   		
	   	   return testCaseName;
	   		
	   	}
	  public synchronized String Searchtexton_companypage_favorite() throws InterruptedException
		
			{
			    wrapper.click("ModalBox_ViewCompanyList");
			    Thread.sleep(5000);
				wrapper.click("Company_search_selectDropdown");
				wrapper.click("Company_search_favoritesCheckbox");
				Thread.sleep(5000);
				wrapper.click("Company_name_title");
				
				
				
			   return testCaseName;
			}
	  public synchronized String Searchtexton_companypage_CompanyName_checkbox(String type) throws InterruptedException
		
		{
		    wrapper.click("ModalBox_ViewCompanyList");
		    wrapper.waitForBrowserToLoadCompletely();
		    wrapper.click("Company_search_selectDropdown");
			Thread.sleep(3000);
			//wrapper.click("Company_search_CompanyNameCheckbox");
			wrapper.click("Company_search_CompanyTypeCheckbox");
			wrapper.click("Company_search_CreationDateCheckbox");
			Thread.sleep(3000);
			wrapper.click("Company_search_box");
			wrapper.enterTexttoSearchinSeachBox_DropDown("Deployment_Company_Testing", "Company_search_selectDropdown");
 		    wrapper.hitEnter();
 		    wrapper.waitForBrowserToLoadCompletely();
 		    String matchvalue= "Deployment_Company_Testing";
 		    wrapper.click("Company_name_title");
 	        wrapper.waitForBrowserToLoadCompletely();
 		    wrapper.validateActualAndExpectedTextDirectly_attributevalue("CompanyName", matchvalue, type);
 	
	
			
			
		return testCaseName;
				
			
			
		}
				
	  public synchronized String Searchtexton_companypage_CompanyType_checkbox(String type) throws InterruptedException
		
		{
		    wrapper.click("ModalBox_ViewCompanyList");
		    wrapper.waitForBrowserToLoadCompletely();
		    wrapper.click("Company_search_selectDropdown");
			Thread.sleep(3000);
			wrapper.click("Company_search_CompanyNameCheckbox");
			//wrapper.click("Company_search_CompanyTypeCheckbox");
			wrapper.click("Company_search_CreationDateCheckbox");
			Thread.sleep(3000);
			wrapper.click("Company_search_box");
			wrapper.enterTexttoSearchinSeachBox_DropDown("Former Client", "Company_search_selectDropdown");
		    wrapper.hitEnter();
		    wrapper.waitForBrowserToLoadCompletely();
		    String matchvalue= "Former Client";
		    wrapper.click("Company_name_title");
	        wrapper.waitForBrowserToLoadCompletely();
		    wrapper.validateActualAndExpectedTextDirectly_attributevalue("CompanyType", matchvalue, type);
	
	
			
			
		return testCaseName;
				
			
			
		}
					
			
}

