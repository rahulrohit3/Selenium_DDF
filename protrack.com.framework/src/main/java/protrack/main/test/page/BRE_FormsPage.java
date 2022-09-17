package protrack.main.test.page;

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

public class BRE_FormsPage extends BaseTest{

	SeleniumHelper wrapper = new SeleniumHelper();
	JsonReaderfile json;
	BaseDriver base = new BaseDriver();
	ExecutionEnvironment exec=new ExecutionEnvironment();
	public WebElement element;


	public synchronized void CreationToSendForm_BRE() throws IOException, InterruptedException
	{
		navigateToNewFormCreationPage();
		NewFormPageDataFill_General_QuestionNaireTabs();
		addingQuestionTypeOnPreviewPage();
		SaveQuestion_FreezeForm_navigateToSendFormScreen();
		SendFormTOrespectiveUsers();
	}

	//***************** navigateToNewFormCreationPage  ***************************************
	
	public synchronized void navigateToNewFormCreationPage() throws IOException, InterruptedException {	

		clickOnBRELink();
		clickOnFormDropDown();
		clickOnCreateFromScratchPresentOnFormPage();
		isCreateFormPageDisplayed();
	}

	public synchronized void clickOnBRELink()
	{
		Reporter.log("Validate that user is able to click on the BRE link present on the dashboard page");
		wrapper.click("BRE_ClickBRE");

	}

	public synchronized void clickOnFormDropDown()
	{
		Reporter.log("Validate that user is able to click on the Forms link present inside BRE dropDown menu");
		wrapper.click("BRE_ClickForms");
	}

	public synchronized void clickOnCreateFromScratchPresentOnFormPage()
	{
		Reporter.log("Validate that user is able to click on the 'create from scratch' link present inside Forms page");
		wrapper.click("Form_ClickFromScratch");
	}

	public synchronized void isCreateFormPageDisplayed() throws InterruptedException, IOException
	{
		json = new JsonReaderfile();
		Reporter.log("Validate Create New form page is displayed");
		String ExpTitle = json.getTestCaseData("LoginExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateInnerText("InlineText_CreateForm", "ExpectedCreateFormpagetext");

		}

	}

	//*************** NewFormPageDataFill_General_QuestionNaireTabs *******************************
	
	public synchronized void NewFormPageDataFill_General_QuestionNaireTabs() throws IOException, InterruptedException {	

		isNewForm_And_InstructionsGetDisplayed();
		forms_NewForms_InsertValue();
		forms_Instruction_InsertValue();
		clickOnSaveAndNextButtonePresentOnGeneralpage();
		Form_Questionnaire_panelsurveyNameValidation();
		clickOnAddSectionPresentOnQuestionnairepage();
		isName_And_InstructionsGetDisplayedONQuestionnaireTab();
		formsQuestionnaire_NewForms_InsertValue();
		formsQuestionnaire_Instruction_InsertValue();
		clickOnSaveButtonPresentOnQuestionnairepage();
		clickOnAddNewQuestionPresentOnQuestionnairepage();
	}

	public synchronized void isNewForm_And_InstructionsGetDisplayed() throws InterruptedException, IOException
	{
		json = new JsonReaderfile();
		Reporter.log("Validate Create New form page is displayed");
		String ExpTitle = json.getTestCaseData("LoginExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateInnerText("InlineTextForms_NewForms", "Expected_NewFormFiledtext");
			wrapper.validateInnerText("InlineTextForms_Instructions", "Expected_InstructionFiledtext");


		}

	}
	String newFormInsertedValue=wrapper.generateRandomString(10);

	public synchronized String forms_NewForms_InsertValue()
	{
		Reporter.log("Validate that user is able to enter value in New Forms textField");
		wrapper.setTextBoxValue_Direct("Forms_NewForms_textFiled", newFormInsertedValue);
		
		return newFormInsertedValue;
	}

	public synchronized void forms_Instruction_InsertValue()
	{
		Reporter.log("Validate that user is able to enter value in Instruction textField");
		wrapper.setTextBoxValue_Direct("Forms_Instructions_textFiled", wrapper.generateRandomString(100));

	}

	public synchronized void clickOnSaveAndNextButtonePresentOnGeneralpage()
	{
		Reporter.log("Validate that user is able to click on the clickOnSaveAndNextButtonePresentOnGeneralpage link present on General tab on Forms page");
		wrapper.click("Form_General_SaveNextClick");
	}
	
	public synchronized String Form_Questionnaire_panelsurveyNameValidation()
	{

		Reporter.log("Validate that user is able to enter value in Instruction textField");
		wrapper.validateInnerTextDirectly("Form_Questionnaire_panelsurveyName", newFormInsertedValue);
		
		return newFormInsertedValue;
	}

	public synchronized void clickOnAddSectionPresentOnQuestionnairepage()
	{
		Reporter.log("Validate that user is able to click on the clickOnAddSectionPresentOnQuestionnairepage link present on General tab on Forms page");
		wrapper.click("Form_Questionnaire_AddNextClick");
	}
	
	public synchronized void isName_And_InstructionsGetDisplayedONQuestionnaireTab() throws InterruptedException, IOException
	{
		json = new JsonReaderfile();
		Reporter.log("Validate Create New form page is displayed");
		String ExpTitle = json.getTestCaseData("LoginExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateInnerText("InlineTextForms_QueName", "Expected_NameFiledtext");
			wrapper.validateInnerText("InlineTextForms_QueInstructions", "Expected_QueInstructionFiledtext");


		}

	}
	
	public synchronized void formsQuestionnaire_NewForms_InsertValue()
	{
		Reporter.log("Validate that user is able to enter value in New Forms textField");
		wrapper.setTextBoxValue_Direct("FormsQuestionnaire_NametextFiled", wrapper.generateRandomString(10));
	}

	public synchronized void formsQuestionnaire_Instruction_InsertValue()
	{
		Reporter.log("Validate that user is able to enter value in Instruction textField");
		wrapper.setTextBoxValue_Direct("FormsQuestionnaire_InstructiontextFiled", wrapper.generateRandomString(100));

	}

	public synchronized void clickOnSaveButtonPresentOnQuestionnairepage()
	{
		Reporter.log("Validate that user is able to click on the clickOnAddSectionPresentOnQuestionnairepage link present on General tab on Forms page");
		wrapper.click("FormsQuestionnaire_SaveButton");
	}
	
	public synchronized void clickOnAddNewQuestionPresentOnQuestionnairepage() throws InterruptedException
	{
		Thread.sleep(2000);

		Reporter.log("Validate that user is able to click on the clickOnAddSectionPresentOnQuestionnairepage link present on General tab on Forms page");
		wrapper.click("FormsQuestionnaire_AddNewQuestion");
	}
	
	//********************* addingQuestionTypeOnPreviewPage ***********************************
	
	public synchronized void addingQuestionTypeOnPreviewPage() throws IOException, InterruptedException {	
		QuestionType_SingleTextBox();
		clickOnAddNewQuestionPresentOnQuestionnairepage();
		
		QuestionType_YesNo();
		clickOnAddNewQuestionPresentOnQuestionnairepage();
		
		QuestionType_TrueFalse();
		clickOnAddNewQuestionPresentOnQuestionnairepage();
		
		QuestionType_RatingScale();
		clickOnAddNewQuestionPresentOnQuestionnairepage();
		
		QuestionType_Datetime();
		clickOnAddNewQuestionPresentOnQuestionnairepage();
		
		QuestionType_MultipleChoiceSingleSelection();
		clickOnAddNewQuestionPresentOnQuestionnairepage();
		
		QuestionType_MultipleChoiceMultipleSelection();
		clickOnAddNewQuestionPresentOnQuestionnairepage();
		
		QuestionType_StaticMatrix();
		clickOnAddNewQuestionPresentOnQuestionnairepage();
		
		QuestionType_DynamicMatrix();
		clickOnAddNewQuestionPresentOnQuestionnairepage();
		
		QuestionType_FileUpload();
		clickOnAddNewQuestionPresentOnQuestionnairepage();
		
	}
	
	public synchronized void QuestionType_Textarea_DataFill()
	{
		Reporter.log("Validate that user is able to enter value in the question text area for selected question type");
		wrapper.setTextBoxValue_Direct("QuestionType_SinTextBox_textarea", wrapper.generateRandomString(10));
	}
	
	public synchronized void select_QuestionType_Value_FromDropDown(String Value)
	{
		Reporter.log("Validate that user is able to enter value in the question text area for selected question type");
		try {
			wrapper.WaitForElementThenClick("QuestionType_DropDownValue_Selection");
			wrapper.selectByValue("QuestionType_DropDownValue_Selection", Value);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public synchronized void clickOnSaveButtonPresentbelowQuestionTypeDropDown()
	{
		Reporter.log("Validate that user is able to click on the clickOnAddSectionPresentOnQuestionnairepage link present on General tab on Forms page");
		wrapper.click("QuestionType_DropDown_below_Savebutton");
	}
	
	public synchronized void QuestionType_ismandatoryCheckBox_Click()
	{
		Reporter.log("Validate that user is able to click on the clickOnAddSectionPresentOnQuestionnairepage link present on General tab on Forms page");
//		wrapper.click("QuestionType_ismandatoryCheckBox_Click");
	}

	public synchronized void QuestionType_SingleTextBox() throws InterruptedException
	{
		QuestionType_Textarea_DataFill();
		select_QuestionType_Value_FromDropDown("3");
		clickOnSaveButtonPresentbelowQuestionTypeDropDown();
		QuestionType_ismandatoryCheckBox_Click();
		
	}
	
	public synchronized void QuestionType_YesNo() throws InterruptedException
	{
		QuestionType_Textarea_DataFill();
		select_QuestionType_Value_FromDropDown("6");
		clickOnSaveButtonPresentbelowQuestionTypeDropDown();
		QuestionType_ismandatoryCheckBox_Click();
		
	}
	
	public synchronized void QuestionType_TrueFalse() throws InterruptedException
	{
		QuestionType_Textarea_DataFill();
		select_QuestionType_Value_FromDropDown("5");
		clickOnSaveButtonPresentbelowQuestionTypeDropDown();
		QuestionType_ismandatoryCheckBox_Click();
	}
	
	public synchronized void QuestionType_RatingScale() throws InterruptedException
	{
		QuestionType_Textarea_DataFill();
		select_QuestionType_Value_FromDropDown("4");
		clickOnSaveButtonPresentbelowQuestionTypeDropDown();
		QuestionType_ismandatoryCheckBox_Click();
		
	}
	
	public synchronized void QuestionType_Datetime() throws InterruptedException
	{
		QuestionType_Textarea_DataFill();
		select_QuestionType_Value_FromDropDown("19");
		clickOnSaveButtonPresentbelowQuestionTypeDropDown();
		QuestionType_ismandatoryCheckBox_Click();
	}
	
	public synchronized void QuestionType_MultipleChoiceSingleSelection()
	{
	}
	
	public synchronized void QuestionType_MultipleChoiceMultipleSelection()
	{
	}
	
	public synchronized void QuestionType_StaticMatrix() throws InterruptedException
	{
		QuestionType_Textarea_DataFill();
		select_QuestionType_Value_FromDropDown("17");
		clickOnSaveButtonPresentbelowQuestionTypeDropDown();
		QuestionType_ismandatoryCheckBox_Click();
	}
	
	public synchronized void QuestionType_DynamicMatrix() throws InterruptedException
	{
		QuestionType_Textarea_DataFill();
		select_QuestionType_Value_FromDropDown("18");
		clickOnSaveButtonPresentbelowQuestionTypeDropDown();
		QuestionType_ismandatoryCheckBox_Click();
	}
	
	public synchronized void QuestionType_FileUpload() throws InterruptedException
	{
		QuestionType_Textarea_DataFill();
		select_QuestionType_Value_FromDropDown("20");
		clickOnSaveButtonPresentbelowQuestionTypeDropDown();
		QuestionType_ismandatoryCheckBox_Click();
	}
	
	public synchronized void SaveQuestion_FreezeForm_navigateToSendFormScreen()
	{
		Save_CreatednewForms();
		Freeze_CreatednewForms();
		PreviewPage_CreatednewForms_ClickNext();
	}
	public synchronized void Save_CreatednewForms()
	{
		wrapper.click("CreatenewForms_SaveButton_Click");
	}
	
	public synchronized void Freeze_CreatednewForms()
	{
		wrapper.click("CreatenewForms_FreezeForm_Click");
		wrapper.getDriver().switchTo().alert().accept();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public synchronized void PreviewPage_CreatednewForms_ClickNext()
	{
		wrapper.click("PreviewPage_CreatednewForms_ClickNext");
	}

	//****************** SendFormTOrespectiveusers ***********************************************
	public synchronized void SendFormTOrespectiveUsers() throws IOException, InterruptedException {	

		
	}

	public synchronized void SelectContact_SendFormPage()
	{
	}

}
