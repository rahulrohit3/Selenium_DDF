package protrack.main.test.page;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import protrack.com.frame.core.BaseDriver;
import protrack.com.frame.core.BaseTest;
import protrack.com.frame.core.SeleniumHelper;
import protrack.com.frame.util.JsonReaderfile;
import protrack.com.test.suite.ExecutionEnvironment;

public class ContactPage extends BaseTest {

	SeleniumHelper wrapper = new SeleniumHelper();
	JsonReaderfile json;
	BaseDriver base = new BaseDriver();
	ExecutionEnvironment exec=new ExecutionEnvironment();
	DashBoardPage Dashboard=new DashBoardPage();
    CompanyPage Company=new CompanyPage();
	Projectpage project=new Projectpage();
	private WebElement element;





	/**
	 **************************************************************************************************************
	 * @throws IOException 
	 * @throws InterruptedException 
	 * @Function Name: login page
	 * @Description: This function is used for login
	 * @Param: 
	 * @Return:
	 * @Date: 22nd,July-2019
	 * @Author: Rahul Rohitashwar
	 **************************************************************************************************************
	 */



	public synchronized String CreateContact() throws InterruptedException, IOException 
	{
		navigateToAddContactPage();
		validateUserIsOnGeneralInformationTab();

		//Filling Data inside General Information tab
		String firstname=GeneralInformationDataEnter_FirstName();
		String lastName=GeneralInformationDataEnter_LastName();
		String ContactTitle=firstname + " " + lastName;

		GeneralInformationDataEnter_JobTitle();
		GeneralInformation_SearchandSelectValueFromCompanyDropDown();
		GeneralInformation_SearchandSelectValueFromProjectDropDown();
		GeneralInformation_pickDate();
		GeneralInformationDataEnter_Notes();
		GeneralInformationDataEnter_Tags();
		GeneralInformationDataEnter_ContactNotes();
		GeneralInformationDataEnter_Phone();
		GeneralInformationDataEnter_Email("67", "Work");
		GeneralInformationDataEnter_Address("73","63", "Home");
		GeneralInformationDataEnter_URL("102", "Home");
		GeneralInformationDataEnter_SocialProfile("108","Facebook");
		GeneralInformationDataEnter_Instantmessanger("117","Facebook Messenger");
		add_Select_submit_Contactdatetype();
		addContact_Date_Grid();
		


		//navigating to the Resource tab
		wrapper.click("AddContact_ResourcesTab");
		validateResourcesVisible_Enabled();

		//Filling Data inside Resource tab
		ResourceTabDataEnter_SelectBox();
		ResourceTabDataEnter_Description();
		ResourceTabDataEnter_Keyword();
		ResourceTabDataEnter_uploadFile();

		//navigating to the Interaction Notes tab
		wrapper.click("AddContact_InteractionNotesTab");
		validateInteractionNotesVisible_Enabled();

		//Filling Data inside Interaction Notes tab
		InteractionNotesTabDataEnter_Notetype();
		InteractionNotesDataEnter_Author();
		//InteractionNotesDataEnter_Description();
		//Contact.InteractionNotesTabDataEnter_Attendee();
		InteractionNotesDataEnter_ShortDescription();
		InteractionNotesDataEnter_UploadFile();
		InteractionNotesDataEnter_SelectValueFromCompanyDropDown();
		InteractionNotesDataEnter_SelectValueFromProjectDropDown();
		return ContactTitle;

	}


	public synchronized String createContactWithFewDetails() throws InterruptedException, IOException {

		navigateToAddContactPage();
		validateUserIsOnGeneralInformationTab();
		String firstname=GeneralInformationDataEnter_FirstName();
		String lastName=GeneralInformationDataEnter_LastName();
		String ContactTitle=firstname + " " + lastName;
		return ContactTitle;

	}

	public synchronized void SubmitAndValidateContactCreated(String ContactTitle) throws InterruptedException, IOException {

		wrapper.click("AddContactSubmitButton");
		wrapper.zoomInZoomOut();
		validateContactCreated(ContactTitle);
	}


	public synchronized void navigateToAddContactPage() throws InterruptedException, IOException
	{
		wrapper.click("ModalBox_AddContacts");
		isAddContactsPageDisplayed();
	}


	// Verify that login page is displayed

	public synchronized void isAddContactsPageDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Add Contact page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateInnerText("InlineText_AddContacts", "ExpectedContactpagetext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}


	}

	public synchronized void validateUserIsOnGeneralInformationTab() throws InterruptedException, IOException
	{
		//navigating to the General Information tab
		isGeneralInformationTabDisplayed();
		wrapper.click("AddContact_GeneralInformationTab");
		validateAddContact_GeneralInformationVisible_Enabled();	
	}


	public synchronized void isViewContactListPageDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate View Contact List page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateInnerText("InlineText_ViewContactListPage", "ExpectedContactpagetext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}


	}

	public synchronized void isGeneralInformationTabDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate View Contact List page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateInnerText("AddContact_GeneralInformationTab", "ExpectedGeneralInformationTabtext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}


	}

	public synchronized void isProjectInfoTabDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate View Contact List page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateInnerText("AddContact_ProjectInfoTab", "ExpectedProjectInfoTabtext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}


	}

	public synchronized void isResourcesTabDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate View Contact List page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateInnerText("AddContact_ResourcesTab", "ExpectedResourcesTabtext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}


	}

	public synchronized void isInteractionNotesTabDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate View Contact List page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateInnerText("AddContact_InteractionNotesTab", "ExpectedInteractionNotesTabtext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}


	}

	public synchronized void validateContactPageListVisible() throws InterruptedException {
		Reporter.log("Validate Contact list page is in focus on Project management page");
		wrapper.validateElementVisible("ColumnFocus_ContactList");
	}

	public synchronized void validateGeneralInformationVisible_Enabled() throws InterruptedException {
		Reporter.log("Validate Contact list page is in focus on Project management page");

		wrapper.validateElementVisibleandEnabled("ContactListTab_GeneralInformation");
	}

	//*********************Methods for General Information Tab Validation along with the Filed listed under that**************************// 

	public synchronized void generalInfoFiledVisibleAndEnabled() throws InterruptedException, IOException
	{

		isGeneralInformationTabDisplayed();
		wrapper.click("AddContact_GeneralInformationTab");
		validateAddContact_GeneralInformationVisible_Enabled();	

		//		isAddContactGeneralInfoTitleDisplayed();
		//		validateGeneralInformation_TitleVisible_Enabled();
		//	
		//		isAddContactGeneralInfoVisibilityDisplayed();
		//		validateGeneralInformation_VisibilityVisible_Enabled();	

		isAddContactGeneralInfoFirstnameDisplayed();
		validateGeneralInformation_FirstnameVisible_Enabled();

		isAddContactGeneralInfoLastnameDisplayed();
		validateGeneralInformation_LastnameVisible_Enabled();

		isAddContactGeneralInfoJobTitleDisplayed();
		validateGeneralInformation_JobTitleVisible_Enabled();

		isAddContactGeneralInfoCompanyDisplayed();
		//validateGeneralInformation_CompanyVisible_Enabled();

		//isAddContactGeneralInfoProjectDisplayed();
		validateGeneralInformation_ProjectVisible_Enabled();

		isAddContactGeneralInfoDateDisplayed();
		validateGeneralInformation_DateVisible_Enabled();

		isAddContactGeneralInfoTagsDisplayed();
		validateGeneralInformation_TagsVisible_Enabled();

		isAddContactGeneralInfoNotesDisplayed();
		validateGeneralInformation_NotesVisible_Enabled();

		isAddContactGeneralInfoPhoneDisplayed();
		validateGeneralInformation_PhoneVisible_Enabled();

		isAddContactGeneralInfoEmailDisplayed();
		validateGeneralInformation_EmailVisible_Enabled();

		isAddContactGeneralInfoAddressDisplayed();
		validateGeneralInformation_AddressVisible_Enabled();

		isAddContactGeneralInfoURLDisplayed();
		validateGeneralInformation_URLVisible_Enabled();

		isAddContactGeneralInfoSocialProfileDisplayed();
		validateGeneralInformation_SocialProfileVisible_Enabled();

		isAddContactGeneralInfoInstantMessengerDisplayed();
		validateGeneralInformation_InstantMessengerVisible_Enabled();
	}

	public synchronized void validateAddContact_GeneralInformationVisible_Enabled() throws InterruptedException {
		Reporter.log("Validate Contact list page is in focus on Project management page");

		wrapper.validateElementVisibleandEnabled("AddContact_GeneralInformationTab");
	}

	public synchronized void isAddContactGeneralInfoFirstnameDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Add Contact page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateInnerText("AddContactGeneralInfo_inlinetextFirstname", "ExpectedLInlineTextFirstname");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}


	}

	public synchronized void validateGeneralInformation_FirstnameVisible_Enabled() throws InterruptedException {
		Reporter.log("Validate Contact list page is in focus on Project management page");

		wrapper.validateElementVisibleandEnabled("AddContactGeneralInfo_Firstname");
	}

	public synchronized void isAddContactGeneralInfoLastnameDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Add Contact page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {


			wrapper.validateInnerText("AddContactGeneralInfo_inlinetextlastname", "ExpectedLInlineTextLastname");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}


	}

	public synchronized void validateGeneralInformation_LastnameVisible_Enabled() throws InterruptedException {
		Reporter.log("Validate Contact list page is in focus on Project management page");

		wrapper.validateElementVisibleandEnabled("AddContactGeneralInfo_Lastname");
	}

	public synchronized void isAddContactGeneralInfoJobTitleDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Add Contact page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateInnerText("AddContactGeneralInfo_inlinetextJobTitle", "ExpectedLInlineTextJobTitle");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}


	}

	public synchronized void validateGeneralInformation_JobTitleVisible_Enabled() throws InterruptedException {
		Reporter.log("Validate Contact list page is in focus on Project management page");

		wrapper.validateElementVisibleandEnabled("AddContactGeneralInfo_JobTitle");
	}

	public synchronized void isAddContactGeneralInfoCompanyDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Add Contact page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateInnerText("AddContactGeneralInfo_InlineTextCompany", "ExpectedLInlineTextCompany");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}


	}

	public synchronized void validateGeneralInformation_CompanyVisible_Enabled() throws InterruptedException {
		Reporter.log("Validate Contact list page is in focus on Project management page");

		wrapper.validateElementVisible("AddContactGeneralInfo_DropDownCompany");
	}

	public synchronized void isAddContactGeneralInfoProjectDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Add Contact page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateInnerText("AddContactGeneralInfo_InlineTextProject", "ExpectedLInlineTextProject");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}


	}

	public synchronized void validateGeneralInformation_ProjectVisible_Enabled() throws InterruptedException {
		Reporter.log("Validate Contact list page is in focus on Project management page");

		wrapper.validateElementVisibleandEnabled("AddContactGeneralInfo_DropDownProject");
	}

	public synchronized void isAddContactGeneralInfoDateDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Add Contact page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateInnerText("AddContactGeneralInfo_InlineTextDates", "ExpectedLInlineTextDates");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}


	}

	public synchronized void validateGeneralInformation_DateVisible_Enabled() throws InterruptedException {
		Reporter.log("Validate Contact list page is in focus on Project management page");

		wrapper.validateElementVisibleandEnabled("AddContactGeneralInfo_EditBoxDates");
	}

	public synchronized void isAddContactGeneralInfoTagsDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Add Contact page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateInnerText("AddContactGeneralInfo_InlineTextTags", "ExpectedLInlineTextTags");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}


	}

	public synchronized void validateGeneralInformation_TagsVisible_Enabled() throws InterruptedException {
		Reporter.log("Validate Contact list page is in focus on Project management page");

		wrapper.validateElementVisibleandEnabled("AddContactGeneralInfo_EditBoxTags");
	}

	public synchronized void isAddContactGeneralInfoNotesDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Add Contact page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateInnerText("AddContactGeneralInfo_InlineTextNotes", "ExpectedLInlineTextJobNotes");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}


	}

	public synchronized void validateGeneralInformation_NotesVisible_Enabled() throws InterruptedException {
		Reporter.log("Validate Contact list page is in focus on Project management page");

		wrapper.validateElementVisibleandEnabled("AddContactGeneralInfo_EditBoxNotes");
	}

	public synchronized void isAddContactGeneralInfoPhoneDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Add Contact page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateInnerText("AddContactGeneralInfo_InlineTextPhone", "ExpectedLInlineTextJobPhone");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}


	}

	public synchronized void validateGeneralInformation_PhoneVisible_Enabled() throws InterruptedException {
		Reporter.log("Validate Contact list page is in focus on Project management page");

		wrapper.validateElementVisibleandEnabled("AddContactGeneralInfo_EditBoxPhonetype");

		Reporter.log("Validate Contact list page is in focus on Project management page");
		wrapper.validateElementVisibleandEnabled("AddContactGeneralInfo_EditBoxPhoneValue");

		Reporter.log("Validate Contact list page is in focus on Project management page");
		wrapper.validateElementVisibleandEnabled("AddContactGeneralInfo_EditBoxPhoneExtension");


	}

	public synchronized void isAddContactGeneralInfoEmailDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Add Contact page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateInnerText("AddContactGeneralInfo_InlineTextEmail", "ExpectedLInlineTextJobEmail");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}


	}

	public synchronized void validateGeneralInformation_EmailVisible_Enabled() throws InterruptedException {
		Reporter.log("Validate Contact list page is in focus on Project management page");
		wrapper.validateElementVisibleandEnabled("AddContactGeneralInfo_EditBoxEmailtype");

		Reporter.log("Validate Contact list page is in focus on Project management page");
		wrapper.validateElementVisibleandEnabled("AddContactGeneralInfo_EditBoxEmailValue");

		Reporter.log("Validate Contact list page is in focus on Project management page");
		wrapper.validateElementVisibleandEnabled("AddContactGeneralInfo_EditBoxEmailName");

	}

	public synchronized void isAddContactGeneralInfoAddressDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Add Contact page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateInnerText("AddContactGeneralInfo_InlineTextAddress", "ExpectedLInlineTextJobAddress");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}


	}

	public synchronized void validateGeneralInformation_AddressVisible_Enabled() throws InterruptedException {

		Reporter.log("Validate Contact list page is in focus on Project management page");
		wrapper.validateElementVisibleandEnabled("AddContactGeneralInfo_EditBoxAddresstype");

		Reporter.log("Validate Contact list page is in focus on Project management page");
		wrapper.validateElementVisibleandEnabled("AddContactGeneralInfo_EditBoxAddressValueTown");

		Reporter.log("Validate Contact list page is in focus on Project management page");
		wrapper.validateElementVisibleandEnabled("AddContactGeneralInfo_EditBoxAddressValueAddress1");

		Reporter.log("Validate Contact list page is in focus on Project management page");
		wrapper.validateElementVisibleandEnabled("AddContactGeneralInfo_EditBoxAddressValueAddress2");

		Reporter.log("Validate Contact list page is in focus on Project management page");
		wrapper.validateElementVisibleandEnabled("AddContactGeneralInfo_EditBoxAddressValueStreet");

		Reporter.log("Validate Contact list page is in focus on Project management page");
		wrapper.validateElementVisibleandEnabled("AddContactGeneralInfo_EditBoxAddressValueAddressStatelist");

		Reporter.log("Validate Contact list page is in focus on Project management page");
		//	wrapper.validateElementVisibleandEnabled("AddContactGeneralInfo_EditBoxAddressValuezipcode");

		Reporter.log("Validate Contact list page is in focus on Project management page");
		//	wrapper.validateElementVisibleandEnabled("AddContactGeneralInfo_EditBoxAddressname");

	}

	public synchronized void isAddContactGeneralInfoURLDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Add Contact page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateInnerText("AddContactGeneralInfo_InlineTextURl", "ExpectedLInlineTextJobURl");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}


	}

	public synchronized void validateGeneralInformation_URLVisible_Enabled() throws InterruptedException {

		Reporter.log("Validate Contact list page is in focus on Project management page");
		wrapper.validateElementVisibleandEnabled("AddContactGeneralInfo_EditBoxURLType");

		Reporter.log("Validate Contact list page is in focus on Project management page");
		wrapper.validateElementVisibleandEnabled("AddContactGeneralInfo_EditBoxURLValue");

		Reporter.log("Validate Contact list page is in focus on Project management page");
		wrapper.validateElementVisibleandEnabled("AddContactGeneralInfo_EditBoxURL");
	}

	public synchronized void isAddContactGeneralInfoSocialProfileDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Add Contact page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateInnerText("AddContactGeneralInfo_InlineTextSocialProfile", "ExpectedLInlineTextJobSocialProfile");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}


	}

	public synchronized void validateGeneralInformation_SocialProfileVisible_Enabled() throws InterruptedException {

		Reporter.log("Validate Contact list page is in focus on Project management page");
		wrapper.validateElementVisibleandEnabled("AddContactGeneralInfo_EditBoxSocialProfileType");

		Reporter.log("Validate Contact list page is in focus on Project management page");
		wrapper.validateElementVisibleandEnabled("AddContactGeneralInfo_EditBoxSocialProfileValue");

		Reporter.log("Validate Contact list page is in focus on Project management page");
		wrapper.validateElementVisibleandEnabled("AddContactGeneralInfo_EditBoxSocialProfilename");
	}

	public synchronized void isAddContactGeneralInfoInstantMessengerDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Add Contact page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateInnerText("AddContactGeneralInfo_InlineTextInstantMessanger", "ExpectedLInlineTextJobInstantmessenger");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}


	}

	public synchronized void validateGeneralInformation_InstantMessengerVisible_Enabled() throws InterruptedException {

		Reporter.log("Validate Contact list page is in focus on Project management page");
		wrapper.validateElementVisibleandEnabled("AddContactGeneralInfo_EditBoxInstantMessangerType");

		Reporter.log("Validate Contact list page is in focus on Project management page");
		wrapper.validateElementVisibleandEnabled("AddContactGeneralInfo_EditBoxInstantMessangerValue");

		Reporter.log("Validate Contact list page is in focus on Project management page");
		wrapper.validateElementVisibleandEnabled("AddContactGeneralInfo_EditBoxInstantMessangerName");
	}

	//*********************Methods for Project info Tab Validation along with the Filed listed under that**************************// 

	public synchronized void validateProjectInfoVisible_Enabled() throws InterruptedException {
		Reporter.log("Validate Contact list page is in focus on Project management page");
		wrapper.validateElementVisibleandEnabled("AddContact_ProjectInfoTab");
	}

	//*********************Methods for Resource Tab Validation along with the Filed listed under that**************************// 

	public synchronized void ResourceInfoFiledVisibleAndEnabled() throws InterruptedException, IOException
	{
		isResourcesTabDisplayed();
		wrapper.click("AddContact_ResourcesTab");
		validateResourcesVisible_Enabled();	

		isAddContactResourceTab_DocDropDownDisplayed();

		isAddContactResourceTab_DescriptionDisplayed();
		validateResourceTab_Description_VisibleEnabled();

		isAddContactResourceTab_KeywordDisplayed();
		validateResourceTab_Keyword_VisibleEnabled();

		isAddContactResourceTab_UploadFileDisplayed();

	}	

	public synchronized void validateResourcesVisible_Enabled() throws InterruptedException {
		Reporter.log("Validate Contact list page is in focus on Project management page");
		wrapper.validateElementVisibleandEnabled("AddContact_ResourcesTab");
	}

	public synchronized void isAddContactResourceTab_DocDropDownDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Doc tpye Dropdown displayed under resource tab under Add Contact page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateElementEnabled("AddContactResourceTab_DoctypeDropdown");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}


	}

	public synchronized void isAddContactResourceTab_DescriptionDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Add Contact page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateInnerText("AddContactResourceTab_inlinetextDescription", "ExpectedLInlineTextDescription");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}


	}

	public synchronized void validateResourceTab_Description_VisibleEnabled() throws InterruptedException {

		Reporter.log("Validate Contact list page is in focus on Project management page");
		wrapper.validateElementVisibleandEnabled("AddContactResourceTab_Description");

	}

	public synchronized void isAddContactResourceTab_KeywordDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Add Contact page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateInnerText("AddContactResourceTab_inlinetextKeyword", "ExpectedLInlineTextKeyword");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}


	}

	public synchronized void validateResourceTab_Keyword_VisibleEnabled() throws InterruptedException {

		Reporter.log("Validate Contact list page is in focus on Project management page");
		wrapper.validateElementVisibleandEnabled("AddContactResourceTab_Keyword");

	}

	public synchronized void isAddContactResourceTab_UploadFileDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Add Contact page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateInnerText("AddContactResourceTab_inlinetextUploadFile", "ExpectedLInlineTextUploadFile");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}


	}

	public synchronized void validateResourceTab_UploadFile_Visible() throws InterruptedException {

		Reporter.log("Validate Contact list page is in focus on Project management page");
		wrapper.validateElementVisible("AddContactResourceTab_UploadFile");

	}


	//*********************Methods for Interaction Note info Tab Validation along with the Filed listed under that**************************// 

	public synchronized void InteractionNoteFiledVisibleAndEnabled() throws InterruptedException, IOException
	{
		isInteractionNotesTabDisplayed();
		wrapper.click("AddContact_InteractionNotesTab");
		validateInteractionNotesVisible_Enabled();

		//Note type
		isAddContactinterNotes_NoteTypeDisplayed();
		validateinterNotes_NoteType_VisibleEnabled();

		//Author
		isAddContactinterNotes_AuthorDisplayed();
		validateinterNotes_Author_VisibleEnabled();

		//Date
		isAddContactinterNotes_DateDisplayed();
		validateinterNotes_Date_VisibleEnabled();

		//Description
		isAddContactinterNotes_DescriptionDisplayed();
		validateinterNotes_Description_VisibleEnabled();

		//attendees
		isAddContactinterNotes_AttendeesDisplayed();
		validateinterNotes_Attendees_VisibleEnabled();

		//short Description
		isAddContactinterNotes_ShortDescDisplayed();
		validateinterNotes_ShortDesc_VisibleEnabled();

		//Files
		isAddContactinterNotes_FilesDisplayed();
		validateinterNotes_Files_VisibleEnabled();

		//Company
		isAddContactinterNotes_CompanyDisplayed();
		validateinterNotes_Company_VisibleEnabled();

		//Project
		isAddContactinterNotes_ProjectDisplayed();
		validateinterNotes_Project_VisibleEnabled();

	}

	public synchronized void validateInteractionNotesVisible_Enabled() throws InterruptedException {
		Reporter.log("Validate Contact list page is in focus on Project management page");
		wrapper.validateElementVisibleandEnabled("AddContact_InteractionNotesTab");
	}

	public synchronized void isAddContactinterNotes_NoteTypeDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Add Contact page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateInnerText("AddContactInteractionNotesTab_inlinenotetype", "ExpectedInteractionNotesTab_NoteType");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}


	}

	public synchronized void validateinterNotes_NoteType_VisibleEnabled() throws InterruptedException {

		Reporter.log("Validate Contact list page is in focus on Project management page");
		wrapper.validateElementVisible("AddContactInteractionNotesTab_notetype");

	}

	public synchronized void isAddContactinterNotes_AuthorDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Add Contact page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateInnerText("AddContactInteractionNotesTab_inlineAuthor", "ExpectedInteractionNotesTab_Author");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}


	}

	public synchronized void validateinterNotes_Author_VisibleEnabled() throws InterruptedException {

		Reporter.log("Validate Contact list page is in focus on Project management page");
		wrapper.validateElementVisible("AddContactInteractionNotesTab_Author");

	}

	public synchronized void isAddContactinterNotes_DateDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Add Contact page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateInnerText("AddContactInteractionNotesTab_inlineDate", "ExpectedInteractionNotesTab_Date");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}


	}


	public synchronized void validateinterNotes_Date_VisibleEnabled() throws InterruptedException {

		Reporter.log("Validate Contact list page is in focus on Project management page");
		wrapper.validateElementVisible("AddContactInteractionNotesTab_Date");

	}

	public synchronized void isAddContactinterNotes_DescriptionDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Add Contact page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateInnerText("AddContactInteractionNotesTab_inlineDescription", "ExpectedInteractionNotesTab_Description");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}


	}

	public synchronized void validateinterNotes_Description_VisibleEnabled() throws InterruptedException {

		Reporter.log("Validate Contact list page is in focus on Project management page");
		wrapper.validateElementVisible("AddContactInteractionNotesTab_Description");

	}

	public synchronized void isAddContactinterNotes_AttendeesDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Add Contact page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateInnerText("AddContactInteractionNotesTab_inlineAttendee", "ExpectedInteractionNotesTab_Attendee");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}


	}

	public synchronized void validateinterNotes_Attendees_VisibleEnabled() throws InterruptedException {

		Reporter.log("Validate Contact list page is in focus on Project management page");
		wrapper.validateElementVisible("AddContactInteractionNotesTab_Attendee");

	}

	public synchronized void isAddContactinterNotes_ShortDescDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Add Contact page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateInnerText("AddContactInteractionNotesTab_inlineshortdesc", "ExpectedInteractionNotesTab_ShortDesc");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}


	}

	public synchronized void validateinterNotes_ShortDesc_VisibleEnabled() throws InterruptedException {

		Reporter.log("Validate Contact list page is in focus on Project management page");
		wrapper.validateElementVisible("AddContactInteractionNotesTab_Shortdesc");

	}

	public synchronized void isAddContactinterNotes_FilesDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Add Contact page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateInnerText("AddContactInteractionNotesTab_inlinefiles", "ExpectedInteractionNotesTab_File");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}


	}

	public synchronized void validateinterNotes_Files_VisibleEnabled() throws InterruptedException {

		Reporter.log("Validate Contact list page is in focus on Project management page");
		wrapper.validateElementVisible("AddContactInteractionNotesTab_Files");

	}

	public synchronized void isAddContactinterNotes_CompanyDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Add Contact page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateInnerText("AddContactInteractionNotesTab_inlineCompany", "ExpectedInteractionNotesTab_Company");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}


	}

	public synchronized void validateinterNotes_Company_VisibleEnabled() throws InterruptedException {

		Reporter.log("Validate Contact list page is in focus on Project management page");
		wrapper.validateElementVisible("AddContactInteractionNotesTab_Company");

	}

	public synchronized void isAddContactinterNotes_ProjectDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Add Contact page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateInnerText("AddContactInteractionNotesTab_inlineProject", "ExpectedInteractionNotesTab_Project");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}


	}

	public synchronized void validateinterNotes_Project_VisibleEnabled() throws InterruptedException {

		Reporter.log("Validate Contact list page is in focus on Project management page");
		wrapper.validateElementVisible("AddContactInteractionNotesTab_Project");

	}


	//*********************Methods for Interaction Note info Tab Validation along with the Filed listed under that**************************// 

	public synchronized void Displayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate View Contact List page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateInnerText("ContactListTab_InteractionNotes", "ExpectedInteractionNotesTabtext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}


	}

	//*********************Methods for Filling data under the General information tab**************************// 

	public synchronized void GeneralInformationDataEnter_Salutation() {

		Reporter.log("inserting data in general information tab while creating new contact info");

		wrapper.setTextBoxValue(TCID,"AddContactGeneralInfo_Salutation","TextField_Salutation");		

	}


	public synchronized String GeneralInformationDataEnter_FirstName() {
		
		String Firstname=wrapper.generateRandomString(12);
		
		System.out.println("Value of Firstname is " +Firstname);

		Reporter.log("inserting data in general information tab while creating new contact info");

		wrapper.setTextBoxValue_Direct("AddContactGeneralInfo_Firstname", Firstname);
		return Firstname;

	}

	public synchronized  String GeneralInformationDataEnter_LastName() {

		Reporter.log("inserting data in general information tab while creating new contact info");
		String lastname=wrapper.generateRandomString(12);
		System.out.println("Value of Firstname is " +lastname);

		wrapper.setTextBoxValue_Direct("AddContactGeneralInfo_Lastname",lastname);
		return lastname;

	}

	public synchronized void GeneralInformationDataEnter_JobTitle() {

		Reporter.log("inserting data in general information tab while creating new contact info");
		//wrapper.setTextBoxValue_Direct("AddContactGeneralInfo_JobTitle","TextField_JobTitle");
		wrapper.setTextBoxValue(TCID,"AddContactGeneralInfo_JobTitle","TextField_JobTitle");

	}

	public synchronized void GeneralInformation_SelectValueFromCompanyDropDown() throws InterruptedException 
	{

		wrapper.Dropdownvalueselection( "DropDown_Company","AddContactGeneralInfo_DropDownClickCompany", "AddContactGeneralInfo_CompanyListValue" );
	}

	public synchronized void GeneralInformation_SelectValueFromProjectDropDown() throws InterruptedException 
	{
		wrapper.Dropdownvalueselection( "DropDown_Project","AddContactGeneralInfo_DropDownClickProject", "AddContactGeneralInfo_ProjectListValue" );
	}
	
	
	public synchronized void GeneralInformation_SelectValueFromProjectDropDownDynamic(String ProjectTitle) throws InterruptedException 
	{
		wrapper.Dropdownvalueselection( ProjectTitle,"AddContactGeneralInfo_DropDownClickProject", "AddContactGeneralInfo_ProjectListValue" );
	}
	
	public synchronized void GeneralInformation_SearchandSelectValueFromProjectDropDown() throws InterruptedException 
	{

	wrapper.DropdownspanInputSearchListValidationValueSelection(
			"DropDown_Project", 
				"AddContactGeneralInfo_DropDownClickProject",
				"AddContactGeneralInfo_ProjectDropdownSearch", 
				"AddContactGeneralInfo_ProjectListValue" );
//	String ExpectedValue=wrapper.getTextValueUsingSpecificElement("GeneralInformationCompanyDropDownValueSelected", CompanyValue).getText();	
//	wrapper.validateActualAndExpectedTextDirectly(CompanyValue, ExpectedValue);

	}
	public synchronized void GeneralInformation_SearchandSelectValueFromProjectDropDownDynamic(String projectValue) throws InterruptedException 
	{

	wrapper.dynamic_DropdownspanInputSearchListValidationValueSelection(
			projectValue, 
				"AddContactGeneralInfo_DropDownClickProject",
				"AddContactGeneralInfo_ProjectDropdownSearch", 
				"AddContactGeneralInfo_ProjectListValue" );
//	String ExpectedValue=wrapper.getTextValueUsingSpecificElement("GeneralInformationCompanyDropDownValueSelected", CompanyValue).getText();	
//	wrapper.validateActualAndExpectedTextDirectly(CompanyValue, ExpectedValue);

	}
	public synchronized void GeneralInformation_SearchandSelectValueFromCompanyDropDown() throws InterruptedException 
	{

	wrapper.DropdownspanInputSearchListValidationValueSelection(
				"DropDown_Company", 
				"AddContactGeneralInfo_DropDownClickCompany",
				"AddContactGeneralInfo_CompanyListsearchbox", 
				"AddContactGeneralInfo_CompanyListValue" );

	}

	public synchronized void GeneralInformation_SearchandSelectValueFromCompanyDropDownDynamic(String CompanyValue) throws InterruptedException 
	{

	wrapper.dynamic_DropdownspanInputSearchListValidationValueSelection(
				CompanyValue, 
				"AddContactGeneralInfo_DropDownClickCompany",
				"AddContactGeneralInfo_CompanyListsearchbox", 
				"AddContactGeneralInfo_CompanyListValue" );
//	String ExpectedValue=wrapper.getTextValueUsingSpecificElement("GeneralInformationCompanyDropDownValueSelected", CompanyValue).getText();	
//	wrapper.validateActualAndExpectedTextDirectly(CompanyValue, ExpectedValue);

	}
	public synchronized void add_Select_submit_Contactdatetype() throws InterruptedException 
	{
		Reporter.log("Add Contact Date type");
		wrapper.isSelectDropdown("Drop_down_contactType");
	}

	public synchronized void GeneralInformation_pickDate() 
	{

		wrapper.click("AddContactGeneralInfo_ClickDates");
		wrapper.datePickFromCalendar("AddContactGeneralInfo_fromDates", "1");

	}

	public synchronized void GeneralInformationDataEnter_Notes() {

		Reporter.log("inserting data in general information tab while creating new contact info");

		wrapper.setTextBoxValue_Direct("AddContactGeneralInfo_Notes", wrapper.generateRandomString(10));
	}
	
	public synchronized String addContact_Date_Grid() throws InterruptedException
	
	{
		wrapper.click("Contactgeneralinfo_dategrid_icon");
		return classResult;
		
		
			
		
		
	}

	public synchronized void GeneralInformationDataEnter_Tags() {

		Reporter.log("inserting data in general information tab while creating new contact info");

		wrapper.setTextBoxValue_Direct("AddContactGeneralInfo_tags",wrapper.generateRandomString(10));
		this.element=wrapper.getElement("AddContactGeneralInfo_tags");
		element.sendKeys(Keys.TAB);

	}

	public synchronized void GeneralInformationDataEnter_ContactNotes() {

		Reporter.log("inserting data in general information tab while creating new contact info");

		wrapper.setTextBoxValue_Direct("AddContactGeneralInfo_ContactNotes", wrapper.generateRandomString(10));
	}

	public synchronized void GeneralInformationDataEnter_Ethnicity() {

		Reporter.log("inserting data in general information tab while creating new contact info");

		wrapper.setTextBoxValue_Direct("AddContactGeneralInfo_Ethnicity", wrapper.generateRandomString(10));
	}

	public synchronized void GeneralInformationDataEnter_Phone() throws InterruptedException {
		String phoneTypeText=enterPhoneTypeDetails();
		String phonenumber=enterPhoneNumberDetails();
		String phoneExtension=enterPhoneExtensionrDetails();
		clickonPlusSignLocator();

		System.out.println(phoneTypeText + "  " + phonenumber + " " + phoneExtension );

		wrapper.validateDynamicText("AddContactGeneralInfo_EditBoxPhonetpyeText", "Main", phoneTypeText);
		wrapper.validateDynamicText("AddContactGeneralInfo_EditBoxPhoneValueText",phonenumber, phonenumber);
		wrapper.validateDynamicText("AddContactGeneralInfo_EditBoxPhoneExtensionText",phoneExtension, phoneExtension);

	}

	public synchronized String enterPhoneTypeDetails() throws InterruptedException {

		Reporter.log("inserting data in general information tab while creating new contact info");

		wrapper.waitForElementVisibility("AddContactGeneralInfo_EditBoxPhonetype");
		wrapper.selectByValue("AddContactGeneralInfo_EditBoxPhonetype", "62");

		String phoneTypeValue=wrapper.getTextValueUsingSpecificElement("AddContactGeneralInfo_EditBoxPhonetpyeText", "Main").getText();
		System.out.println("phoneTypeValue " + phoneTypeValue);
		return phoneTypeValue;

	}


	public synchronized String enterPhoneNumberDetails() throws InterruptedException {

		Reporter.log("inserting data  by enterPhoneNumberDetails in general information tab while creating new contact info");

		String Phonenumber=wrapper.generateRandomString(10);
		wrapper.setTextBoxValue_Direct("AddContactGeneralInfo_phonenumber", Phonenumber);
		return Phonenumber;


	}

	public synchronized String enterPhoneExtensionrDetails() throws InterruptedException {

		Reporter.log("inserting data by AddContactGeneralInfo_phoneExtension in general information tab while creating new contact info");
		String phoneExtension=wrapper.GenerateRandomNumber(10);
		wrapper.setTextBoxValue_Direct("AddContactGeneralInfo_phoneExtension", phoneExtension);
		return phoneExtension;

	}


	public synchronized void clickonPlusSignLocator() throws InterruptedException {

		Reporter.log("inserting data by clickonPlusSignLocator in general information tab while creating new contact info");
		wrapper.click("CreContact_phone_PlusiconClickLocator");


	}

	public synchronized void GeneralInformationDataEnter_Email(String selectByValue, String valueText) throws InterruptedException {

		Reporter.log("inserting data in general information tab while creating new contact info");

		String emailType=enterEmailTypeDetails(selectByValue, valueText);
		String emailValue=enterEmailValueDetails("er.rahu@gmail.com");
		String emailName=enterEmailNameDetails();
		clickonPlusSignLocator_Email();

		System.out.println(emailType + "  " + emailValue + " " + emailName );

		wrapper.validateDynamicText("AddContactGeneralInfo_EditBoxEmailtpyeText", valueText, emailType);
		wrapper.validateDynamicText("AddContactGeneralInfo_EditBoxEmailValueText",emailValue, emailValue);
		wrapper.validateDynamicText("AddContactGeneralInfo_EditBoxEmailNameText",emailName, emailName);

	}

	public synchronized String enterEmailTypeDetails(String selectByValue, String valueText) throws InterruptedException {

		Reporter.log("inserting data in general information tab while creating new contact info");

		wrapper.waitForElementVisibility("AddContactGeneralInfo_EditBoxEmailtype");
		wrapper.selectByValue("AddContactGeneralInfo_EditBoxEmailtype", selectByValue);

		String emailTypeValue=wrapper.getTextValueUsingSpecificElement("AddContactGeneralInfo_EditBoxEmailtpyeText", valueText).getText();
		System.out.println("emailTypeValue " + emailTypeValue);
		return emailTypeValue;

	}

	public synchronized String enterEmailValueDetails(String email) throws InterruptedException {

		wrapper.setTextBoxValue_Direct("AddContactGeneralInfo_EditBoxEmailValue",email );

		return email;

	}

	public synchronized String enterEmailNameDetails() throws InterruptedException {

		String emailName=wrapper.GenerateRandomNumber(10);
		wrapper.setTextBoxValue_Direct("AddContactGeneralInfo_EditBoxEmailName", emailName);
		return emailName;

	}

	public synchronized void clickonPlusSignLocator_Email() throws InterruptedException {

		wrapper.click("CreContact_Email_PlusiconClickLocator");

	}

	public synchronized void GeneralInformationDataEnter_Address(String selectaddressValue, String selectStreetValue, String valueText) throws InterruptedException 

	{

		Reporter.log("inserting data in general information tab while creating new contact info");

		String AddressTypeText=enterAddressTypeDetails(selectaddressValue, valueText);
		String address1=AddContactGeneralInfo_EditBoxAddressValueAddress1();
		String address2=AddContactGeneralInfo_EditBoxAddressValueAddress2();
		String town=AddContactGeneralInfo_EditBoxAddressValueTown();
		String Street=AddContactGeneralInfo_EditBoxAddressValueStreet(selectStreetValue);
		String zipCode=AddContactGeneralInfo_EditBoxAddressValuezipcode();
		String addressName=AddContactGeneralInfo_EditBoxAddressname();
		//String textMap=AddContactGeneralInfo_EditBoxTextMap();
		//String schoolDistict=AddContactGeneralInfo_EditBoxSchoolDistict();
		//String addressMessage=AddContactGeneralInfo_EditBoxAddressAcreage();
		clikcAddressPlusiconClickLocator();

		System.out.println(AddressTypeText + "  " + address1 + " " + address2  + " " + town + " " + Street + " " + zipCode 
				+ " " + addressName + " " );

	}

	public synchronized String enterAddressTypeDetails(String selectaddressValue, String valueText) throws InterruptedException {

		Reporter.log("inserting data in general information tab while creating new contact info");

		wrapper.waitForElementVisibility("AddContactGeneralInfo_EditBoxAddresstype");
		wrapper.selectByValue("AddContactGeneralInfo_EditBoxAddresstype", selectaddressValue);


		String AddressTypeValue=wrapper.getTextValueUsingSpecificElement("AddContactGeneralInfo_EditBoxAddresstpyeText", valueText).getText();
		System.out.println("AddressTypeValue " + AddressTypeValue);

		return valueText;

	}

	public synchronized String AddContactGeneralInfo_EditBoxAddressValueAddress1() throws InterruptedException {

		String address1=wrapper.GenerateRandomNumber(10);

		wrapper.setTextBoxValue_Direct("AddContactGeneralInfo_EditBoxAddressValueAddress1", address1);
		return address1;

	}

	public synchronized String AddContactGeneralInfo_EditBoxAddressValueAddress2() throws InterruptedException {

		String address2=wrapper.GenerateRandomNumber(10);

		wrapper.setTextBoxValue_Direct("AddContactGeneralInfo_EditBoxAddressValueAddress2", address2);
		return address2;

	}

	public synchronized String AddContactGeneralInfo_EditBoxAddressValueTown() throws InterruptedException {

		String townValue=wrapper.GenerateRandomNumber(10);

		wrapper.setTextBoxValue_Direct("AddContactGeneralInfo_EditBoxAddressValueTown", townValue);
		return townValue;

	}

	public synchronized String AddContactGeneralInfo_EditBoxAddressValueStreet(String selectByValue) throws InterruptedException {

		String emailName=wrapper.GenerateRandomNumber(10);

		wrapper.waitForElementVisibility("AddContactGeneralInfo_EditBoxAddressValueStreet");
		wrapper.selectByValue("AddContactGeneralInfo_EditBoxAddressValueStreet", selectByValue);

		return emailName;
	}

	//			Thread.sleep(4000);
	//			wrapper.waitForBrowserToLoadCompletely();
	//			wrapper.selectByValue("AddContactGeneralInfo_EditBoxAddressValueAddressStatelist", "82");

	public synchronized String AddContactGeneralInfo_EditBoxAddressValuezipcode() throws InterruptedException {

		String zipcode=wrapper.GenerateRandomNumber(10);

		wrapper.setTextBoxValue_Direct("AddContactGeneralInfo_EditBoxAddressValuezipcode", zipcode);
		return zipcode;

	}

	public synchronized String AddContactGeneralInfo_EditBoxAddressname() throws InterruptedException {

		String addressName=wrapper.generateRandomString(10);

		wrapper.setTextBoxValue_Direct("AddContactGeneralInfo_EditBoxAddressname", addressName);

		return addressName;
	}

	public synchronized String AddContactGeneralInfo_EditBoxTextMap() throws InterruptedException {

		String editBoxText=wrapper.GenerateRandomNumber(10);

		wrapper.setTextBoxValue_Direct("AddContactGeneralInfo_EditBoxTextMap", editBoxText);

		return editBoxText;

	}



	public synchronized String AddContactGeneralInfo_EditBoxSchoolDistict() throws InterruptedException {

		String schoolDistict=wrapper.GenerateRandomNumber(10);

		wrapper.setTextBoxValue_Direct("AddContactGeneralInfo_EditBoxSchoolDistict", schoolDistict);
		return schoolDistict;
	}

	public synchronized String AddContactGeneralInfo_EditBoxAddressAcreage() throws InterruptedException {

		String addressMessage=wrapper.GenerateRandomNumber(10);

		wrapper.setTextBoxValue_Direct("AddContactGeneralInfo_EditBoxAddressAcreage", addressMessage);

		return addressMessage;
	}

	public synchronized void clikcAddressPlusiconClickLocator() throws InterruptedException {

		wrapper.click("CreContact_Address_PlusiconClickLocator");

	}


	public synchronized void GeneralInformationDataEnter_URL(String selectaddressValue, String valueText) throws InterruptedException {

		Reporter.log("inserting data in general information tab while creating new contact info");
		String urlType=enterURLTypeDetails(selectaddressValue, valueText);
		String urlValue=AddContactGeneralInfo_enterURLValueDetails();
		String editBoxValue=AddContactGeneralInfo_enterEditBoxDetails();
		CreContact_URL_PlusiconClickLocator();
		
		System.out.println(urlType + " " + urlValue + " " + editBoxValue);
		
		wrapper.validateDynamicText("AddContactGeneralInfo_EditBoxURLValueText", valueText, urlType);
		wrapper.validateDynamicText("AddContactGeneralInfo_EditBoxURLValueText",urlValue, urlValue);
		wrapper.validateActualAndExpectedTextDirectly("AddContactGeneralInfo_EditBoxURLText", editBoxValue);
		//wrapper.validateDynamicText("AddContactGeneralInfo_EditBoxURLText",editBoxValue, editBoxValue);
		
	}
	
	public synchronized String enterURLTypeDetails(String selectaddressValue, String valueText) throws InterruptedException {

		Reporter.log("inserting data in general information tab while creating new contact info");

		wrapper.waitForElementVisibility("AddContactGeneralInfo_EditBoxURLType");
		wrapper.selectByValue("AddContactGeneralInfo_EditBoxURLType", selectaddressValue);


//		String AddressTypeValue=wrapper.getTextValueUsingSpecificElement("AddContactGeneralInfo_EditBoxURLtpyeText", valueText).getText();
//		System.out.println("AddressTypeValue " + AddressTypeValue);

		return valueText;

	}

	public synchronized String AddContactGeneralInfo_enterURLValueDetails() throws InterruptedException {

		String urlValue=wrapper.generateRandomString(10);

		wrapper.setTextBoxValue_Direct("AddContactGeneralInfo_EditBoxURLValue", urlValue);
		
		return urlValue;

	}

	public synchronized String AddContactGeneralInfo_enterEditBoxDetails() throws InterruptedException {

		String editBox=wrapper.generateRandomString(10);

		wrapper.setTextBoxValue_Direct("AddContactGeneralInfo_EditBoxURL",editBox);

		wrapper.click("CreContact_URL_PlusiconClickLocator");		
		
		return editBox;

	}
	
	public synchronized void CreContact_URL_PlusiconClickLocator() throws InterruptedException {
		
		wrapper.click("CreContact_URL_PlusiconClickLocator");		

	}

	public synchronized void GeneralInformationDataEnter_SocialProfile(String selectSocailValue, String valueText) throws InterruptedException {

		Reporter.log("inserting data in general information tab while creating new contact info");
		enterSocialTypeDetails(selectSocailValue, valueText);
		String socialProfileValue=EnterSocailProfileValue();
		String socialProfileName=EnterSocailProfileName();
		wrapper.click("CreContact_SocialPro_PlusiconClickLocator");
		
		System.out.println(valueText + " " + socialProfileValue + " " + socialProfileName);
		
		wrapper.validateDynamicText("AddContactGeneralInfo_SocialTypeEnteredText",valueText, valueText);
		wrapper.validateDynamicText("AddContactGeneralInfo_SocialValueEnteredText",socialProfileValue,socialProfileValue);
		wrapper.validateDynamicText("AddContactGeneralInfo_SocialNameEnteredText",socialProfileName, socialProfileName);
	
	}

	public synchronized String enterSocialTypeDetails(String selectSocailValue, String valueText) throws InterruptedException {

		Reporter.log("inserting data in general information tab while creating new contact info");

		wrapper.waitForElementVisibility("AddContactGeneralInfo_EditBoxSocialProfileType");
		wrapper.selectByValue("AddContactGeneralInfo_EditBoxSocialProfileType", selectSocailValue);


//		String AddressTypeValue=wrapper.getTextValueUsingSpecificElement("AddContactGeneralInfo_EditBoxURLtpyeText", valueText).getText();
//		System.out.println("AddressTypeValue " + AddressTypeValue);

		return valueText;

	}
	
	public synchronized String EnterSocailProfileValue()
	{
		String SocailProfileValue=wrapper.generateRandomString(10);
		
		wrapper.setTextBoxValue_Direct("AddContactGeneralInfo_EditBoxSocialProfileValue",SocailProfileValue );

		return SocailProfileValue;
		
	}
	
	public synchronized String EnterSocailProfileName()
	{
		String SocailProfileName=wrapper.GenerateRandomNumber(10);
		
		wrapper.setTextBoxValue_Direct("AddContactGeneralInfo_EditBoxSocialProfilename", SocailProfileName);

		return SocailProfileName;
		
	}
	
	public synchronized void GeneralInformationDataEnter_Instantmessanger(String selectSocailValue, String valueText) throws InterruptedException {

		Reporter.log("inserting data in general information tab while creating new contact info");

		String InstantMessangertype=enterInstantMessengerDetails(selectSocailValue, valueText);
		String InstantMessangerValue=enterInstantMessangerValue();
		String InstantMessangerName=enterInstantMessangerName();

		wrapper.click("CreContact_InstaMsg_PlusiconClickLocator");
				
		System.out.println(InstantMessangertype + " " + InstantMessangerValue + " " + InstantMessangerName);
		
		wrapper.validateDynamicText("AddContactInstantMessangerTypeEnteredText",InstantMessangertype, InstantMessangertype);
		wrapper.validateDynamicText("AddContactInstantMessangerValueEnteredText",InstantMessangerValue,InstantMessangerValue);
		wrapper.validateDynamicText("AddContactInstantMessangerNameEnteredText",InstantMessangerName, InstantMessangerName);

	}
	
	public synchronized String enterInstantMessengerDetails(String selectSocailValue, String valueText) throws InterruptedException {

		Reporter.log("inserting data in general information tab while creating new contact info");

		wrapper.waitForElementVisibility("AddContactGeneralInfo_EditBoxInstantMessangerType");
		wrapper.selectByValue("AddContactGeneralInfo_EditBoxInstantMessangerType", selectSocailValue);


//		String AddressTypeValue=wrapper.getTextValueUsingSpecificElement("AddContactGeneralInfo_EditBoxURLtpyeText", valueText).getText();
//		System.out.println("AddressTypeValue " + AddressTypeValue);

		return valueText;

	}
	
	public synchronized String enterInstantMessangerValue()
	{
		String InstantMessangerValue=wrapper.GenerateRandomNumber(10);
		
		wrapper.setTextBoxValue_Direct("AddContactGeneralInfo_EditBoxInstantMessangerValue", InstantMessangerValue);

		return InstantMessangerValue;
		
	}
	
	public synchronized String enterInstantMessangerName()
	{
		String InstantMessangerName=wrapper.GenerateRandomNumber(10);
		
		wrapper.setTextBoxValue_Direct("AddContactGeneralInfo_EditBoxInstantMessangerName", InstantMessangerName);

		return InstantMessangerName;
		
	}
	

	//*********************Methods for Filling data under the Resource tab**************************// 

	public synchronized void ResourceTabDataEnter_SelectBox() throws InterruptedException {

		Reporter.log("inserting data in general information tab while creating new contact info");

		wrapper.waitForElementVisibility("AddContactResourceTab_DoctypeDropdown");
		wrapper.selectByValue("AddContactResourceTab_DoctypeDropdown", "43");

	}

	public synchronized void ResourceTabDataEnter_Description() throws InterruptedException {

		Reporter.log("inserting data in general information tab while creating new contact info");

		wrapper.setTextBoxValue_Direct("AddContactResourceTab_Description", wrapper.generateRandomString(100));


	}

	public synchronized void ResourceTabDataEnter_Keyword() throws InterruptedException {

		Reporter.log("inserting data in general information tab while creating new contact info");

		wrapper.setTextBoxValue_Direct("AddContactResourceTab_Keyword", wrapper.generateRandomString(10));
		this.element=wrapper.getElement("AddContactResourceTab_Keyword");
		element.sendKeys(Keys.TAB);


	}

	public synchronized void ResourceTabDataEnter_uploadFile() throws InterruptedException 
	{
		wrapper.click("Project_resources_upload_doc");
		wrapper.click("Project_resources_upload_Localdoc_link_on_PopUp");  
		Thread.sleep(1000);
		this.element=wrapper.getElement("Contact_resource_uploadfilepath");
			element.sendKeys(System.getProperty("user.dir") +File.separator+"qa.pdf");
			Thread.sleep(1000);
			wrapper.click("Project_resources_select_Upload_attached_button");
			Thread.sleep(1000);
			wrapper.click("Project_resources_upload_doc");
			wrapper.click("Project_resources_upload_libracryDoc_link_on_PopUp"); 
			wrapper.click("Project_resources_select_doc_from_library");
			wrapper.click("Project_resources_select_Upload_attached_button");

	}

	//*********************Methods for Filling data under the InteractionNotes tab**************************// 

	public synchronized void InteractionNotesTabDataEnter_Notetype() throws InterruptedException {

		Reporter.log("inserting data in general information tab while creating new contact info");

		wrapper.waitForElementVisibility("AddContactInteractionNotesTab_notetype");
		wrapper.selectByValue("AddContactInteractionNotesTab_notetype", "Phone call");

	}

	public synchronized void InteractionNotesDataEnter_Author() throws InterruptedException {

		Reporter.log("inserting data in general information tab while creating new contact info");

		wrapper.setTextBoxValue_Direct("AddContactInteractionNotesTab_Author", wrapper.generateRandomString(10));



	}

	public synchronized void InteractionNotes_pickDate() 
	{

		wrapper.click("AddContactInteractionNotesTab_Date");
		wrapper.datePickFromCalendar("AddContactInteractionNotesTab_Date", "20");

	}

	public synchronized void InteractionNotesDataEnter_Description() throws InterruptedException {

		Reporter.log("inserting data in general information tab while creating new contact info");

		wrapper.setTextBoxValue_Direct("AddContactInteractionNotesTab_Description", wrapper.generateRandomString(10));


	}

	public synchronized void InteractionNotesTabDataEnter_Attendee() throws InterruptedException {

		Reporter.log("inserting data in general information tab while creating new contact info");

		wrapper.waitForElementVisibility("AddContactInteractionNotesTab_Attendee");
		wrapper.selectByValue("AddContactInteractionNotesTab_Attendee", "5020");
		wrapper.selectByValue("AddContactInteractionNotesTab_Attendee", "5029");


	}

	public synchronized void InteractionNotesDataEnter_ShortDescription() throws InterruptedException {

		Reporter.log("inserting data in general information tab while creating new contact info");

		wrapper.setTextBoxValue_Direct("AddContactInteractionNotesTab_Shortdesc", wrapper.generateRandomString(10));


	}

	public synchronized void InteractionNotesDataEnter_UploadFile() throws InterruptedException {

		this.element=wrapper.getElement("AddContactInteractionNotesTab_ClickFile");
		element.sendKeys(System.getProperty("user.dir") +File.separator+"qa.pdf");	

	}

	public synchronized void InteractionNotesDataEnter_SelectValueFromCompanyDropDown() throws InterruptedException 
	{
		wrapper.Dropdownvalueselection( "internotes_CompanyValue","AddContactInteractionNotesTab_ClickCompany", "AddContactInteractionNotesTab_CompanyList" );
	}

	public synchronized void InteractionNotesDataEnter_SelectValueFromProjectDropDown() throws InterruptedException 
	{
		wrapper.Dropdownvalueselection( "internotes_ProjectValue","AddContactInteractionNotesTab_Clickproject", "AddContactInteractionNotesTab_ProjectList" );
	}

	//Submit the form******************************************************888

	public synchronized  String validateContactCreated(String Name_ContactCreated) throws InterruptedException
	{

		Reporter.log("Validate Add Contact page is displayed");
		System.out.println("expected value is " + Name_ContactCreated);
		wrapper.validateActualAndExpectedTextDirectly( "ContactCreateTitle", Name_ContactCreated);

		return Name_ContactCreated;

	}

	public synchronized void validatecompanyDropdownAfterandBeforeValue() {
		wrapper.validateBeforeandAfterFieldValue("AddContact_CompanyValueValidationLoctor", "DropDown_Company");

	}



	//************ Auto_Protack_TC_Contact_ContactNotCreatedOnClickingcancel

	public synchronized void ContactNotCreatedOnClickingcancel() throws InterruptedException, IOException
	{

		String Name_ContactCreated=navigateContactEnterDetailsAndClickOnCancel();
		SearchContact(Name_ContactCreated);
		ValidateNoContactDisplayed();
	}

	public synchronized String navigateContactEnterDetailsAndClickOnCancel() throws InterruptedException, IOException
	{
		wrapper.click("ModalBox_AddContacts");
		isAddContactsPageDisplayed();
		isGeneralInformationTabDisplayed();
		wrapper.click("AddContact_GeneralInformationTab");

		validateAddContact_GeneralInformationVisible_Enabled();	
		String Firstname=GeneralInformationDataEnter_FirstName();
		String lastname=GeneralInformationDataEnter_LastName();
		String contactExpectedTitle=Firstname + " " + lastname;
		GeneralInformationDataEnter_JobTitle();
		wrapper.click("AddContactCancelButton");
		wrapper.waitForBrowserToLoadCompletely();
		wrapper.click("AddContactCancel_dontsaveandcontinueButton");
		wrapper.waitForBrowserToLoadCompletely();

		return contactExpectedTitle;
	}

	public synchronized void SearchContact(String Name_ContactCreated)
	{
		wrapper.setTextBoxValue_Direct("ContactsLisr_SearchBoxLocator", Name_ContactCreated );
		wrapper.hitEnter();
		wrapper.waitForBrowserToLoadCompletely();
	}

	public synchronized void ValidateNoContactDisplayed() throws InterruptedException

	{	String Actualtitle=wrapper.getElement("NoDataAvailableLocator").getText();
	System.out.println(Actualtitle);
	Thread.sleep(2000);
	Assert.assertEquals(Actualtitle, "No data available in table", "Data does not get saved after cancellation");
	}

	//************ Auto_Protack_TC_Contact_AbletoEditContactDetails

	public synchronized void verifyUserIsAletoEditContactDetails() throws InterruptedException, IOException
	{
		String contactTitle=CreateContact();
		SubmitAndValidateContactCreated(contactTitle);
		wrapper.waitForBrowserToLoadCompletely();
		wrapper.click("SavedContact_EditButton");
		Thread.sleep(3000);
		String EditedFirstName=ContatctEdit_GeneralInformationDataEnter_FirstName();
		String EditedLastName=ContactEdit_GeneralInformationDataEnter_LastName();
		Thread.sleep(2000);
		validateContactUpdated(EditedFirstName + " " + EditedLastName);


	}

	public synchronized String ContatctEdit_GeneralInformationDataEnter_FirstName() {

		Reporter.log("inserting data in general information tab while creating new contact info");
		String Firstname=wrapper.generateRandomString(5);
		System.out.println("Edited First name Value is " + Firstname);
		wrapper.setTextBoxValue_Direct("AddContactGeneralInfo_Firstname", Firstname);
		return Firstname;

	}

	public synchronized  String ContactEdit_GeneralInformationDataEnter_LastName() {

		Reporter.log("inserting data in general information tab while creating new contact info");
		String lastname=wrapper.generateRandomString(5);
		System.out.println("Edited last name Value is " + lastname);

		wrapper.setTextBoxValue_Direct("AddContactGeneralInfo_Lastname",lastname);
		return lastname;

	}


	public synchronized  void validateContactUpdated(String Name_ContactCreated) throws InterruptedException
	{
		wrapper.click("AddContactSubmitButton");
		wrapper.zoomInZoomOut();
		Reporter.log("Validate Add Contact page is displayed");
		System.out.println("expected value is " + Name_ContactCreated);
		wrapper.validateActualAndExpectedTextDirectly( "ContactCreateTitle", Name_ContactCreated);

	}

	//************ Auto_Protack_TC_Contact_AbletoEditContactDetails

	public synchronized void verifyUserIsAbleToViewEditContactDetails() throws InterruptedException, IOException
	{
		String contactTitle=CreateContact();
		SubmitAndValidateContactCreated(contactTitle);
		wrapper.waitForBrowserToLoadCompletely();
		wrapper.click("SavedContact_EditButton");
		wrapper.waitForBrowserToLoadCompletely();
		validateUserisOnEditPage("AddContactGeneralInfo_Firstname");
		validateUserisOnEditPage("AddContactGeneralInfo_Lastname");
		validateUserisOnEditPage("AddContactGeneralInfo_phonenumber");


	}

	public synchronized  void validateUserisOnEditPage(String locatorName) throws InterruptedException
	{
		this.element = wrapper.getElement(locatorName);
		element.isEnabled();
		Assert.assertTrue(true, "Elemente is not enabled");

	}

	//SearchingContact From the contactslist
	public synchronized void searchContactFromContactsList() throws InterruptedException, IOException
	{
		String contactTitle=CreateContact();
		SubmitAndValidateContactCreated(contactTitle);
		wrapper.waitForBrowserToLoadCompletely();
		SearchContact(contactTitle);
		Thread.sleep(10000);
		wrapper.waitForBrowserToLoadCompletely();
		ValidateContactDisplayed("ContactsSearchText_Locator", contactTitle);
	}



	public synchronized void ValidateContactDisplayed(String locatorName, String locatorValue) throws InterruptedException
	{	
		String Actualtitle=wrapper.getTextValueUsingSpecificElement(locatorName, locatorValue).getText();

		System.out.println(Actualtitle);
		Assert.assertEquals(Actualtitle, locatorValue, "Data does not get saved after cancellation");
	}

	// *********Auto_Protack_TC_Contact_VerifyFirstLastAndPhonePresent************

	public synchronized void VerifyFirstLastAndPhonePresent() throws InterruptedException, IOException
	{

		navigateToAddContactPage();
		validateUserIsOnGeneralInformationTab();

		isAddContactGeneralInfoFirstnameDisplayed();
		validateGeneralInformation_FirstnameVisible_Enabled();
		GeneralInformationDataEnter_FirstName();

		isAddContactGeneralInfoLastnameDisplayed();
		validateGeneralInformation_LastnameVisible_Enabled();
		GeneralInformationDataEnter_LastName();

		isAddContactGeneralInfoPhoneDisplayed();
		validateGeneralInformation_PhoneVisible_Enabled();
		GeneralInformationDataEnter_Phone();
	}

	// *********Auto_Protack_TC_Contact_VerifyFirstLastAndPhonePresent************

	public synchronized void Contact_abletoViewAccessEditContactPage() throws InterruptedException, IOException
	{
		String contactTitle=CreateContact();
		SubmitAndValidateContactCreated(contactTitle);
		wrapper.waitForBrowserToLoadCompletely();
		wrapper.click("SavedContact_EditButton");
		wrapper.waitForBrowserToLoadCompletely();
		//		generalInfoFiledVisibleAndEnabled();
		//		ResourceInfoFiledVisibleAndEnabled();
		//		InteractionNoteFiledVisibleAndEnabled();

	}

	// ******************************Auto_Protack_TC_Contact_AbleToAddmultiplePhoneNumber*************888

	public void Contact_AbleToAddmultiplePhoneNumber() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		navigateToAddContactPage();
		generalInfoFiledVisibleAndEnabled();
		GeneralInformationDataEntermultiplePhoneRecord("62", "Main");
		GeneralInformationDataEntermultiplePhoneRecord("58", "Work");
		GeneralInformationDataEntermultiplePhoneRecord("60", "Office");


	}

	public synchronized void GeneralInformationDataEntermultiplePhoneRecord(
			String selectByValue, 
			String valueText) 
					throws InterruptedException {

		String phoneTypeText=enterPhoneTypeDetails(selectByValue, valueText);
		String phonenumber=enterPhoneNumberDetails();
		String phoneExtension=enterPhoneExtensionrDetails();
		clickonPlusSignLocator();

		System.out.println(phoneTypeText + "  " + phonenumber + " " + phoneExtension );

		wrapper.validateDynamicText("AddContactGeneralInfo_EditBoxPhonetpyeText", valueText, phoneTypeText);
		wrapper.validateDynamicText("AddContactGeneralInfo_EditBoxPhoneValueText",phonenumber, phonenumber);
		wrapper.validateDynamicText("AddContactGeneralInfo_EditBoxPhoneExtensionText",phoneExtension, phoneExtension);

	}

	public synchronized String enterPhoneTypeDetails(String selectByValue, String valueText) throws InterruptedException {

		Reporter.log("inserting data in general information tab while creating new contact info");

		wrapper.waitForElementVisibility("AddContactGeneralInfo_EditBoxPhonetype");
		wrapper.selectByValue("AddContactGeneralInfo_EditBoxPhonetype", selectByValue);

		String phoneTypeValue=wrapper.getTextValueUsingSpecificElement("AddContactGeneralInfo_EditBoxPhonetpyeText", valueText).getText();
		System.out.println("phoneTypeValue " + phoneTypeValue);
		return phoneTypeValue;

	}

	// ******************************Auto_Protack_TC_Contact_AbleToAddPhoneNumberType_MAIN*************888


	public void Contact_AbleToAddPhoneNumberType_MAIN_trail() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		navigateToAddContactPage();
		generalInfoFiledVisibleAndEnabled();

		String firstname=GeneralInformationDataEnter_FirstName();
		String lastName=GeneralInformationDataEnter_LastName();
		String ContactTitle=firstname + " " + lastName;
		GeneralInformationDataEntermultiplePhoneRecord("62", "Main");


	}		


	public synchronized void Contact_AbleToAddPhoneNumberType(
			String selectByValue, 
			String valueText) 
					throws InterruptedException, IOException {

		navigateToAddContactPage();
		generalInfoFiledVisibleAndEnabled();

		String firstname=GeneralInformationDataEnter_FirstName();
		String lastName=GeneralInformationDataEnter_LastName();
		String ContactTitle=firstname + " " + lastName;

		String phoneTypeText=enterPhoneTypeDetails(selectByValue, valueText);
		String phonenumber=enterPhoneNumberDetails();
		String phoneExtension=enterPhoneExtensionrDetails();
		clickonPlusSignLocator();

		System.out.println(phoneTypeText + "  " + phonenumber + " " + phoneExtension );

		wrapper.validateDynamicText("AddContactGeneralInfo_EditBoxPhonetpyeText", valueText, phoneTypeText);
		wrapper.validateDynamicText("AddContactGeneralInfo_EditBoxPhoneValueText",phonenumber, phonenumber);
		wrapper.validateDynamicText("AddContactGeneralInfo_EditBoxPhoneExtensionText",phoneExtension, phoneExtension);

		SubmitAndValidateContactCreated(ContactTitle);
		wrapper.waitForBrowserToLoadCompletely();

		wrapper.validateActualAndExpectedTextDirectly("AddContactGeneralInfo_SavedPhonetpye", phoneTypeText);
		wrapper.validateActualAndExpectedTextDirectly("AddContactGeneralInfo_SavedPhoneValueText", phonenumber);
		wrapper.validateActualAndExpectedTextDirectly("AddContactGeneralInfo_SavedPhoneExtensionText", phoneExtension);


	}

	public synchronized void Contact_AbleToAddEmail(String selectByValue, String valueText) 
			throws InterruptedException, IOException {
		String contactTitle=createContactWithFewDetails();
		GeneralInformationEmailAfterAndBeforeData(contactTitle, selectByValue, valueText);

	}

	public synchronized void GeneralInformationEmailAfterAndBeforeData(String ContactTitle, String selectByValue, String valueText) throws InterruptedException, IOException {

		Reporter.log("inserting data in general information tab while creating new contact info");

		String emailType=enterEmailTypeDetails(selectByValue, valueText);
		String emailValue=enterEmailValueDetails("er.rahu@gmail.com");
		String emailName=enterEmailNameDetails();
		clickonPlusSignLocator_Email();

		System.out.println(emailType + "  " + emailValue + " " + emailName );

		wrapper.validateDynamicText("AddContactGeneralInfo_EditBoxEmailtpyeText", valueText, emailType);
		wrapper.validateDynamicText("AddContactGeneralInfo_EditBoxEmailValueText",emailValue, emailValue);
		wrapper.validateDynamicText("AddContactGeneralInfo_EditBoxEmailNameText",emailName, emailName);

		SubmitAndValidateContactCreated(ContactTitle);
		wrapper.waitForBrowserToLoadCompletely();

		wrapper.validateActualAndExpectedTextDirectly("AddContactGeneralInfo_SavedEmailtpye", emailType);
		wrapper.validateActualAndExpectedTextDirectly("AddContactGeneralInfo_SavedEmailValueText", emailValue);
		wrapper.validateActualAndExpectedTextDirectly("AddContactGeneralInfo_SavedEmailNameText", emailName);

	}

	public synchronized void validateEmailID(String selectByValue, String valueText) 
			throws InterruptedException, IOException {
		String generateEmailId=wrapper.generateRandomString(10);
		navigateToAddContactPage();
		validateUserIsOnGeneralInformationTab();
		GeneralInformationDataEnter_FirstName();
		GeneralInformationDataEnter_LastName();
		enterEmailTypeDetails(selectByValue, valueText);
		enterEmailValueDetails(generateEmailId);
		enterEmailNameDetails();
		clickonPlusSignLocator_Email();
		String errormessage=wrapper.getElement("AddContactGeneralInfo_EmailValueErrormessage1").getText();

		Assert.assertTrue(errormessage.contains("Please provide valid email addresses."), "errormessage is not getting displayed");


	}

	public synchronized void Contact_AbleToAddressType(
			String selectaddressValue, String selectStreetValue, 
			String valueText) 
					throws InterruptedException, IOException {

		navigateToAddContactPage();
		validateUserIsOnGeneralInformationTab();
		
		String firstname=GeneralInformationDataEnter_FirstName();
		String lastName=GeneralInformationDataEnter_LastName();
		String ContactTitle=firstname + " " + lastName;

		String AddressTypeText=enterAddressTypeDetails(selectaddressValue, valueText);
		String address1=AddContactGeneralInfo_EditBoxAddressValueAddress1();
		String address2=AddContactGeneralInfo_EditBoxAddressValueAddress2();
		String town=AddContactGeneralInfo_EditBoxAddressValueTown();
		String Street=AddContactGeneralInfo_EditBoxAddressValueStreet(selectStreetValue);
		String zipCode=AddContactGeneralInfo_EditBoxAddressValuezipcode();
		String addressName=AddContactGeneralInfo_EditBoxAddressname();
		clikcAddressPlusiconClickLocator();

		System.out.println(AddressTypeText + "  " + address1 + " " + address2  + " " + town + " " + Street + " " + zipCode 
				+ " " + addressName + " " );

		wrapper.validateDynamicText("AddContactGeneralInfo_EditBoxAddresstpyeText", valueText, AddressTypeText);

		SubmitAndValidateContactCreated(ContactTitle);
		wrapper.waitForBrowserToLoadCompletely();

		wrapper.validateActualAndExpectedTextDirectly("AddContactGeneralInfo_SavedAddresstypeText", AddressTypeText);


	}

//Contact_AbleToAddURLType_Work 
	
	public void Contact_AbleToURLType(
			String selectURLValue,
			String valueText) 
					throws InterruptedException, IOException {
		
		navigateToAddContactPage();
		validateUserIsOnGeneralInformationTab();
		
		String firstname=GeneralInformationDataEnter_FirstName();
		String lastName=GeneralInformationDataEnter_LastName();
		String ContactTitle=firstname + " " + lastName;
		
		GeneralInformationURLAfterAndBeforeData(ContactTitle, selectURLValue, valueText);
	
		
		
	}

	public synchronized void GeneralInformationURLAfterAndBeforeData(String ContactTitle, String selectaddressValue, String valueText) throws InterruptedException, IOException {

		Reporter.log("inserting data in general information tab while creating new contact info");
		String urlType=enterURLTypeDetails(selectaddressValue, valueText);
		String urlValue=AddContactGeneralInfo_enterURLValueDetails();
		String editBoxValue=AddContactGeneralInfo_enterEditBoxDetails();
		CreContact_URL_PlusiconClickLocator();
		
		System.out.println(urlType + " " + urlValue + " " + editBoxValue);
		
		wrapper.validateDynamicText("AddContactGeneralInfo_EditBoxURLValueText", valueText, urlType);
		wrapper.validateDynamicText("AddContactGeneralInfo_EditBoxURLValueText",urlValue, urlValue);
		wrapper.validateActualAndExpectedTextDirectly("AddContactGeneralInfo_EditBoxURLText", editBoxValue);
		
		
		SubmitAndValidateContactCreated(ContactTitle);
		wrapper.waitForBrowserToLoadCompletely();

		wrapper.validateActualAndExpectedTextDirectly("AddContactGeneralInfo_SavedURLTypeText", urlType);
		wrapper.validateActualAndExpectedTextDirectly("AddContactGeneralInfo_SavedURLValueText", urlValue);
		wrapper.validateActualAndExpectedTextDirectly("AddContactGeneralInfo_SavedEditBoxText", editBoxValue);

	}
	
 //**********	Auto_Protack_TC_Contact_AbleToAddSocialType_Twitter *************
	
	public void Contact_AbleToAddSocialProfileType(
			String selectURLValue,
			String valueText) 
					throws InterruptedException, IOException {
		
		navigateToAddContactPage();
		validateUserIsOnGeneralInformationTab();
		
		String firstname=GeneralInformationDataEnter_FirstName();
		String lastName=GeneralInformationDataEnter_LastName();
		String ContactTitle=firstname + " " + lastName;
		
		GeneralInformationSocialProfielAfterAndBeforeDataMatch(ContactTitle, selectURLValue, valueText);
		wrapper.waitForBrowserToLoadCompletely();
	
	}
		
		public synchronized void GeneralInformationSocialProfielAfterAndBeforeDataMatch(String ContactTitle, String selectSocailValue, String valueText) throws InterruptedException, IOException {

			Reporter.log("inserting data in general information tab while creating new contact info");
			enterSocialTypeDetails(selectSocailValue, valueText);
			String socialProfileValue=EnterSocailProfileValue();
			String socialProfileName=EnterSocailProfileName();
			wrapper.click("CreContact_SocialPro_PlusiconClickLocator");
			
			System.out.println(valueText + " " + socialProfileValue + " " + socialProfileName);
			
			wrapper.validateDynamicText("AddContactGeneralInfo_SocialTypeEnteredText",valueText, valueText);
			wrapper.validateDynamicText("AddContactGeneralInfo_SocialValueEnteredText",socialProfileValue,socialProfileValue);
			wrapper.validateDynamicText("AddContactGeneralInfo_SocialNameEnteredText",socialProfileName, socialProfileName);
			
			SubmitAndValidateContactCreated(ContactTitle);
			wrapper.waitForBrowserToLoadCompletely();		
			
			wrapper.validateDynamicText("AddContactGeneralInfo_SocialTypeEnteredText",valueText, valueText);
			wrapper.validateActualAndExpectedTextDirectly("AddContactGeneralInfo_SocialValueSavedText",socialProfileValue);
			wrapper.validateActualAndExpectedTextDirectly("AddContactGeneralInfo_SocialNameSavedText", socialProfileName);
	

		}
		
		public synchronized String createContactWithAlreadyCreateCompany() throws InterruptedException, IOException {
			
			String CompanyTitle=Company.createCompanywithFewDetails();
			wrapper.click("ModalBox_Dashboard");
			navigateToAddContactPage();
			validateUserIsOnGeneralInformationTab();
			String firstname=GeneralInformationDataEnter_FirstName();
			String lastName=GeneralInformationDataEnter_LastName();
			String ContactTitle=firstname + " " + lastName;
			GeneralInformation_SearchandSelectValueFromCompanyDropDownDynamic(CompanyTitle);
			
			Thread.sleep(20000);
			return ContactTitle;

		}
		
	public synchronized String createContactAllDetailsAlreadyCreateCompany() throws InterruptedException, IOException {
			
			String CompanyTitle=Company.createCompanywithFewDetails();
			
			wrapper.click("ModalBox_Dashboard");
		
			navigateToAddContactPage();
			validateUserIsOnGeneralInformationTab();

			//Filling Data inside General Information tab
			String firstname=GeneralInformationDataEnter_FirstName();
			String lastName=GeneralInformationDataEnter_LastName();
			String ContactTitle=firstname + " " + lastName;

			GeneralInformationDataEnter_JobTitle();
			GeneralInformation_SearchandSelectValueFromCompanyDropDownDynamic(CompanyTitle);
			GeneralInformation_SelectValueFromProjectDropDown();
			GeneralInformation_pickDate();
			GeneralInformationDataEnter_Notes();
			GeneralInformationDataEnter_Tags();
			GeneralInformationDataEnter_ContactNotes();
			GeneralInformationDataEnter_Phone();
			GeneralInformationDataEnter_Email("67", "Work");
			GeneralInformationDataEnter_Address("73","63", "Home");
			GeneralInformationDataEnter_URL("102", "Home");
			GeneralInformationDataEnter_SocialProfile("108","Facebook");
			GeneralInformationDataEnter_Instantmessanger("117","Facebook Messenger");

			//navigating to the Resource tab
			wrapper.click("AddContact_ResourcesTab");
			validateResourcesVisible_Enabled();

			//Filling Data inside Resource tab
			ResourceTabDataEnter_SelectBox();
			ResourceTabDataEnter_Description();
			ResourceTabDataEnter_Keyword();
			ResourceTabDataEnter_uploadFile();

			//navigating to the Interaction Notes tab
			wrapper.click("AddContact_InteractionNotesTab");
			validateInteractionNotesVisible_Enabled();

			//Filling Data inside Interaction Notes tab
			InteractionNotesTabDataEnter_Notetype();
			InteractionNotesDataEnter_Author();
			//InteractionNotesDataEnter_Description();
			//Contact.InteractionNotesTabDataEnter_Attendee();
			InteractionNotesDataEnter_ShortDescription();
			InteractionNotesDataEnter_UploadFile();
			InteractionNotesDataEnter_SelectValueFromCompanyDropDown();
			InteractionNotesDataEnter_SelectValueFromProjectDropDown();


			return ContactTitle;

		}
	
	
	public synchronized String createContactAllDetailsAlreadyCreatedProject() throws InterruptedException, IOException {
		
		String projectitle=project.CreateprojectWithFewDetails();
		
		wrapper.click("ModalBox_Dashboard");
	
		navigateToAddContactPage();
		validateUserIsOnGeneralInformationTab();

		//Filling Data inside General Information tab
		String firstname=GeneralInformationDataEnter_FirstName();
		String lastName=GeneralInformationDataEnter_LastName();
		String ContactTitle=firstname + " " + lastName;

		GeneralInformationDataEnter_JobTitle();
		GeneralInformation_SearchandSelectValueFromCompanyDropDown();
		GeneralInformation_SearchandSelectValueFromProjectDropDownDynamic(projectitle);
		GeneralInformation_pickDate();
		GeneralInformationDataEnter_Notes();
		GeneralInformationDataEnter_Tags();
		GeneralInformationDataEnter_ContactNotes();
		GeneralInformationDataEnter_Phone();
		GeneralInformationDataEnter_Email("67", "Work");
		GeneralInformationDataEnter_Address("73","63", "Home");
		GeneralInformationDataEnter_URL("102", "Home");
		GeneralInformationDataEnter_SocialProfile("108","Facebook");
		GeneralInformationDataEnter_Instantmessanger("117","Facebook Messenger");

		//navigating to the Resource tab
		wrapper.click("AddContact_ResourcesTab");
		validateResourcesVisible_Enabled();

		//Filling Data inside Resource tab
		ResourceTabDataEnter_SelectBox();
		ResourceTabDataEnter_Description();
		ResourceTabDataEnter_Keyword();
		ResourceTabDataEnter_uploadFile();

		//navigating to the Interaction Notes tab
		wrapper.click("AddContact_InteractionNotesTab");
		validateInteractionNotesVisible_Enabled();

		//Filling Data inside Interaction Notes tab
		InteractionNotesTabDataEnter_Notetype();
		InteractionNotesDataEnter_Author();
		//InteractionNotesDataEnter_Description();
		//Contact.InteractionNotesTabDataEnter_Attendee();
		InteractionNotesDataEnter_ShortDescription();
		InteractionNotesDataEnter_UploadFile();
		InteractionNotesDataEnter_SelectValueFromCompanyDropDown();
		InteractionNotesDataEnter_SelectValueFromProjectDropDown();


		return ContactTitle;

	}
	
public synchronized String createContactFewDetailsAlreadyCreatedProject() throws InterruptedException, IOException {
		
		String projectitle=project.CreateprojectWithFewDetails();
		
		wrapper.click("ModalBox_Dashboard");
	
		navigateToAddContactPage();
		validateUserIsOnGeneralInformationTab();

		//Filling Data inside General Information tab
		String firstname=GeneralInformationDataEnter_FirstName();
		String lastName=GeneralInformationDataEnter_LastName();
		String ContactTitle=firstname + " " + lastName;

		GeneralInformationDataEnter_JobTitle();
		GeneralInformation_SearchandSelectValueFromCompanyDropDown();
		GeneralInformation_SearchandSelectValueFromProjectDropDownDynamic(projectitle);
		GeneralInformation_pickDate();


		return ContactTitle;

	}

public synchronized String createContactAllDetailsAlreadyCreatedCompanyAndProject() throws InterruptedException, IOException {
	
	String CompanyTitle=Company.createCompanywithFewDetails();
	
	wrapper.click("ModalBox_Dashboard");
	
	String projectitle=project.CreateprojectWithFewDetails();
	
	wrapper.click("ModalBox_Dashboard");

	navigateToAddContactPage();
	validateUserIsOnGeneralInformationTab();

	//Filling Data inside General Information tab
	String firstname=GeneralInformationDataEnter_FirstName();
	String lastName=GeneralInformationDataEnter_LastName();
	String ContactTitle=firstname + " " + lastName;

	GeneralInformationDataEnter_JobTitle();
	GeneralInformation_SearchandSelectValueFromCompanyDropDownDynamic(CompanyTitle);
	GeneralInformation_SearchandSelectValueFromProjectDropDownDynamic(projectitle);
	GeneralInformation_pickDate();
	GeneralInformationDataEnter_Notes();
	GeneralInformationDataEnter_Tags();
	GeneralInformationDataEnter_ContactNotes();
	GeneralInformationDataEnter_Phone();
	GeneralInformationDataEnter_Email("67", "Work");
	GeneralInformationDataEnter_Address("73","63", "Home");
	GeneralInformationDataEnter_URL("102", "Home");
	GeneralInformationDataEnter_SocialProfile("108","Facebook");
	GeneralInformationDataEnter_Instantmessanger("117","Facebook Messenger");

	//navigating to the Resource tab
	wrapper.click("AddContact_ResourcesTab");
	validateResourcesVisible_Enabled();

	//Filling Data inside Resource tab
	ResourceTabDataEnter_SelectBox();
	ResourceTabDataEnter_Description();
	ResourceTabDataEnter_Keyword();
	ResourceTabDataEnter_uploadFile();

	//navigating to the Interaction Notes tab
	wrapper.click("AddContact_InteractionNotesTab");
	validateInteractionNotesVisible_Enabled();

	//Filling Data inside Interaction Notes tab
	InteractionNotesTabDataEnter_Notetype();
	InteractionNotesDataEnter_Author();
	//InteractionNotesDataEnter_Description();
	//Contact.InteractionNotesTabDataEnter_Attendee();
	InteractionNotesDataEnter_ShortDescription();
	InteractionNotesDataEnter_UploadFile();
	InteractionNotesDataEnter_SelectValueFromCompanyDropDown();
	InteractionNotesDataEnter_SelectValueFromProjectDropDown();


	return ContactTitle;

}
		
public synchronized String createContactFewDetailsAlreadyCreatedCompanyAndProject() throws InterruptedException, IOException {
	
	String CompanyTitle=Company.createCompanywithFewDetails();
	
	wrapper.click("ModalBox_Dashboard");
	
	String projectitle=project.CreateprojectWithFewDetails();
	
	wrapper.click("ModalBox_Dashboard");

	navigateToAddContactPage();
	validateUserIsOnGeneralInformationTab();

	//Filling Data inside General Information tab
	String firstname=GeneralInformationDataEnter_FirstName();
	String lastName=GeneralInformationDataEnter_LastName();
	String ContactTitle=firstname + " " + lastName;

	GeneralInformationDataEnter_JobTitle();
	GeneralInformation_SearchandSelectValueFromCompanyDropDownDynamic(CompanyTitle);
	GeneralInformation_SearchandSelectValueFromProjectDropDownDynamic(projectitle);
	GeneralInformation_pickDate();
	

	return ContactTitle;
	
	}

//**********	Auto_Protack_TC_Contact_AbleToAddSocialType_Twitter *************

	public void Contact_AbleToAddInstantManagerType(
			String selectURLValue,
			String valueText) 
					throws InterruptedException, IOException {
		
		navigateToAddContactPage();
		validateUserIsOnGeneralInformationTab();
		
		String firstname=GeneralInformationDataEnter_FirstName();
		String lastName=GeneralInformationDataEnter_LastName();
		String ContactTitle=firstname + " " + lastName;
		
		InstantmessangerBeforeAndAfterDataValidation(ContactTitle, selectURLValue, valueText);
		wrapper.waitForBrowserToLoadCompletely();
	
	}
	
	public synchronized void InstantmessangerBeforeAndAfterDataValidation(String ContactTitle, String selectSocailValue, String valueText) throws InterruptedException, IOException {

		Reporter.log("inserting data in general information tab while creating new contact info");

		String InstantMessangertype=enterInstantMessengerDetails(selectSocailValue, valueText);
		String InstantMessangerValue=enterInstantMessangerValue();
		String InstantMessangerName=enterInstantMessangerName();

		wrapper.click("CreContact_InstaMsg_PlusiconClickLocator");
				
		System.out.println(InstantMessangertype + " " + InstantMessangerValue + " " + InstantMessangerName);
		
		wrapper.validateDynamicText("AddContactInstantMessangerTypeEnteredText",InstantMessangertype, InstantMessangertype);
		wrapper.validateDynamicText("AddContactInstantMessangerValueEnteredText",InstantMessangerValue,InstantMessangerValue);
		wrapper.validateDynamicText("AddContactInstantMessangerNameEnteredText",InstantMessangerName, InstantMessangerName);

		SubmitAndValidateContactCreated(ContactTitle);
		wrapper.waitForBrowserToLoadCompletely();		
		
		wrapper.validateActualAndExpectedTextDirectly("AddContactInMessangerTypeSavedText",valueText);
		wrapper.validateActualAndExpectedTextDirectly("AddContactInMessangerValueSavedText",InstantMessangerValue);
		wrapper.validateActualAndExpectedTextDirectly("AddContactInMessangerNameSavedText", InstantMessangerName);

	}


	
	   public synchronized String Searchtexton_contactpage_First_name(String type) throws InterruptedException
	      	
	      	{
	      	
		        wrapper.click("ModalBox_ViewContactList");
	      		wrapper.waitForBrowserToLoadCompletely();
	      		wrapper.click("Contact_search_box");	
	      		wrapper.enterTexttoSearchinSeachBox_DropDown("Ridhi", "Contact_search_box");
	      		wrapper.hitEnter();
	      		wrapper.click("Contact_search_selectDropdown");
	      		String matchvalue= "Ridhi";
	      		wrapper.clearEditBox("Contact_search_box");
	      		wrapper.enterTexttoSearchinSeachBox_DropDown("Ridhi Contact_30jan", "Contact_search_box");
	      		wrapper.hitEnter();
	    		Thread.sleep(5000);
	    		wrapper.click("Contact_name_title");
	    		Thread.sleep(3000);
	    		wrapper.validateActualAndExpectedTextDirectly_attributevalue("Contact_First_name", matchvalue, type);
	      		wrapper.waitForBrowserToLoadCompletely();
	      		
	      		
	      		
	      		
	      	   return testCaseName;
	      			
	      		
	      		
	      	}
	   public synchronized String Searchtexton_contactpage_Last_name(String type) throws InterruptedException
     	
     	{
     	
	        wrapper.click("ModalBox_ViewContactList");
     		wrapper.waitForBrowserToLoadCompletely();
     		wrapper.click("Contact_search_box");	
     		wrapper.enterTexttoSearchinSeachBox_DropDown("Contact_30jan", "Contact_search_box");
     		wrapper.hitEnter();
     		wrapper.click("Contact_search_selectDropdown");
     		String matchvalue= "Contact_30jan";
     		wrapper.clearEditBox("Contact_search_box");
     		wrapper.enterTexttoSearchinSeachBox_DropDown("Ridhi Contact_30jan", "Contact_search_box");
     		wrapper.hitEnter();
   		    Thread.sleep(5000);
   		    wrapper.click("Contact_name_title");
   		    Thread.sleep(3000);
   		    wrapper.validateActualAndExpectedTextDirectly_attributevalue("Contact_Last_name", matchvalue, type);
     		wrapper.waitForBrowserToLoadCompletely();
     		
     		
     		
     		
     	   return testCaseName;
     			
     		
     		
     	}
	   public synchronized String Searchtexton_contactpage_Email_Id(String type) throws InterruptedException
    	
    	{
    	
	        wrapper.click("ModalBox_ViewContactList");
    		wrapper.waitForBrowserToLoadCompletely();
    		wrapper.click("Contact_search_box");	
    		wrapper.enterTexttoSearchinSeachBox_DropDown("rmishra@svam.com", "Contact_search_box");
    		wrapper.hitEnter();
    		wrapper.click("Contact_search_selectDropdown");
    		String matchvalue= "rmishra@svam.com";
    		wrapper.clearEditBox("Contact_search_box");
    		wrapper.enterTexttoSearchinSeachBox_DropDown("Ridhi Contact_30jan", "Contact_search_box");
    		wrapper.hitEnter();
  		    Thread.sleep(5000);
  		    wrapper.click("Contact_name_title");
  		    Thread.sleep(3000);
  		    wrapper.validateActualAndExpectedTextDirectly_attributevalue("Contact_Email_Id", matchvalue, type);
    		wrapper.waitForBrowserToLoadCompletely();
    		
    		
    		
    		
    	   return testCaseName;
    			
    	}

	   public synchronized String Searchtexton_contactpage_favorite() throws InterruptedException
		
		{
		    wrapper.click("ModalBox_ViewContactList");
		    wrapper.waitForBrowserToLoadCompletely();
			wrapper.click("Contact_search_selectDropdown");
			wrapper.click("Contact_search_favoritesCheckbox");
			Thread.sleep(5000);
			wrapper.click("Contact_name_title");
			
			
			
		   return testCaseName;
				
			
			
		}
	   public synchronized String Searchtexton_contactpage_FirstName(String type) throws InterruptedException
		
		{
		    wrapper.click("ModalBox_ViewContactList");
		    wrapper.waitForBrowserToLoadCompletely();
			wrapper.click("Contact_search_selectDropdown");
			Thread.sleep(3000);
			//wrapper.click("Contact_search_FirstNameCheckbox");
			wrapper.click("Contact_search_LastNameCheckbox");
			wrapper.click("Contact_search_EmailCheckbox");
			wrapper.click("Contact_search_CompanyNameCheckbox");
			wrapper.click("Contact_search_ContactNumberCheckbox");
			wrapper.click("Contact_search_CreationDateCheckbox");
			wrapper.click("Contact_search_FullNameCheckbox");
			Thread.sleep(3000);
			wrapper.click("Contact_search_box");
			wrapper.enterTexttoSearchinSeachBox_DropDown("Alpha", "Contact_search_box");
    		wrapper.hitEnter();
    		wrapper.waitForBrowserToLoadCompletely();
    		String matchvalue= "Alpha";
    		wrapper.click("Contact_FirstName_Title");
    	    wrapper.waitForBrowserToLoadCompletely();
    		wrapper.validateActualAndExpectedTextDirectly_attributevalue("Contact_FirstName", matchvalue, type);
    	
	
			
			
		return testCaseName;
				
			
			
		}
	   public synchronized String Searchtexton_contactpage_LastName(String type) throws InterruptedException
		
		{
		    wrapper.click("ModalBox_ViewContactList");
		    wrapper.waitForBrowserToLoadCompletely();
			wrapper.click("Contact_search_selectDropdown");
			Thread.sleep(3000);
			wrapper.click("Contact_search_FirstNameCheckbox");
			//wrapper.click("Contact_search_LastNameCheckbox");
			wrapper.click("Contact_search_EmailCheckbox");
			wrapper.click("Contact_search_CompanyNameCheckbox");
			wrapper.click("Contact_search_ContactNumberCheckbox");
			wrapper.click("Contact_search_CreationDateCheckbox");
			wrapper.click("Contact_search_FullNameCheckbox");
			Thread.sleep(3000);
			wrapper.click("Contact_search_box");
			wrapper.enterTexttoSearchinSeachBox_DropDown("Beta", "Contact_search_box");
   		    wrapper.hitEnter();
   		    wrapper.waitForBrowserToLoadCompletely();
   		    String matchvalue= "Beta";
   		    wrapper.click("Contact_FirstName_Title");
   	        wrapper.waitForBrowserToLoadCompletely();
   		    wrapper.validateActualAndExpectedTextDirectly_attributevalue("Contact_LastName", matchvalue, type);
   	
	
			
			
		return testCaseName;
				
			
			
		}
	   public synchronized String Searchtexton_contactpage_Email(String type) throws InterruptedException
		
	 		{
	 		    wrapper.click("ModalBox_ViewContactList");
	 		    wrapper.waitForBrowserToLoadCompletely();
	 			wrapper.click("Contact_search_selectDropdown");
	 			Thread.sleep(3000);
	 			wrapper.click("Contact_search_FirstNameCheckbox");
	 			wrapper.click("Contact_search_LastNameCheckbox");
	 			//wrapper.click("Contact_search_EmailCheckbox");
	 			wrapper.click("Contact_search_CompanyNameCheckbox");
	 			wrapper.click("Contact_search_ContactNumberCheckbox");
	 			wrapper.click("Contact_search_CreationDateCheckbox");
	 			wrapper.click("Contact_search_FullNameCheckbox");
	 			Thread.sleep(3000);
	 			wrapper.click("Contact_search_box");
	 			wrapper.enterTexttoSearchinSeachBox_DropDown("protrackuser1@svam.com", "Contact_search_box");
	    		wrapper.hitEnter();
	    		wrapper.waitForBrowserToLoadCompletely();
	    		String matchvalue= "protrackuser1@svam.com";
	    		wrapper.click("Contact_FirstName_Title");
	    	    wrapper.waitForBrowserToLoadCompletely();
	    		wrapper.validateActualAndExpectedTextDirectly_attributevalue("Contact_Email", matchvalue, type);
	    	
	 	
	 			
	 			
	 		return testCaseName;
	 				
	 			
	 			
	 		}
	   public synchronized String Searchtexton_contactpage_CompanyName(String type) throws InterruptedException
		
		{
		    wrapper.click("ModalBox_ViewContactList");
		    wrapper.waitForBrowserToLoadCompletely();
			wrapper.click("Contact_search_selectDropdown");
			Thread.sleep(3000);
			wrapper.click("Contact_search_FirstNameCheckbox");
			wrapper.click("Contact_search_LastNameCheckbox");
			wrapper.click("Contact_search_EmailCheckbox");
			//wrapper.click("Contact_search_CompanyNameCheckbox");
			wrapper.click("Contact_search_ContactNumberCheckbox");
			wrapper.click("Contact_search_CreationDateCheckbox");
			wrapper.click("Contact_search_FullNameCheckbox");
			Thread.sleep(3000);
			wrapper.click("Contact_search_box");
			wrapper.enterTexttoSearchinSeachBox_DropDown("Deployment_Company_Testing", "Contact_search_box");
   		    wrapper.hitEnter();
   		    wrapper.waitForBrowserToLoadCompletely();
   		    String matchvalue= "Deployment_Company_Testing";
   		    wrapper.click("Contact_FirstName_Title");
   	        wrapper.waitForBrowserToLoadCompletely();
   		    wrapper.validateActualAndExpectedTextDirectly_attributevalue("Contact_CompanyName", matchvalue, type);
   	
	
			
			
		return testCaseName;
				
			
			
		}
	}






