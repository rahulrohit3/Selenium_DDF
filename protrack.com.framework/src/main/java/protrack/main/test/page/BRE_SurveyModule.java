package protrack.main.test.page;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import protrack.com.frame.core.BaseDriver;
import protrack.com.frame.core.BaseTest;
import protrack.com.frame.core.SeleniumHelper;
import protrack.com.frame.util.JsonReaderfile;
import protrack.com.test.suite.ExecutionEnvironment;

public class BRE_SurveyModule extends BaseTest{

	SeleniumHelper wrapper = new SeleniumHelper();
	JsonReaderfile json;
	BaseDriver base = new BaseDriver();
	ExecutionEnvironment exec=new ExecutionEnvironment();
	public WebElement element;
	BRE_FormsPage Forms=new BRE_FormsPage();


	public synchronized void CreateSurveyEndToEnd() throws InterruptedException, IOException{

		Reporter.log("Validate that user is navigated  to surveyScreen");
		navigateToSurveyPage();

		Reporter.log("Validate that user is navigated  to Create Survey From Scretch surveyScreen");
		navigateToCreateSurveyPage();

		Reporter.log("Validate that user all details on General Tab present on the Create Survey Screen");
		String newSurveynameEntered=creSur_fillDetailsOnGeneralTab();

		Reporter.log("Validate that user app validates that user is on Questionaire tab on the Create Survey Screen");
		CreSurvey_validateUserIsOnQuestionTab(newSurveynameEntered);

		Reporter.log("Validate that user is able to fill all the details and able to create all qustion type and save the survey on question tab for  Create Survey Screen");
		creSur_FillDetailsAndCreationQuestionsOnQuestionTab();

		Reporter.log("Validate that user is able to fill all and able to navigate to send survey screen for  Create Survey Screen");
		SaveQuestion_FreezeSurvey_navigateToSendSurveyScreen();

	}
	
	//********************** Send Survey to recipient **************************************************

	public synchronized void sendSurvey(String Contactname) throws InterruptedException, IOException{
//	wrapper.waitForElementInvisibility("SendSurvey_SelectContact");
	wrapper.click("SendSurvey_SelectContact");
	wrapper.waitForBrowserToLoadCompletely();
	wrapper.click("SendSurvey_ClickContactDropDown");
	Thread.sleep(10000);
	wrapper.enterTexttoSearchinSeachBox_DropDown(Contactname, "SendSurvey_SearchContactandSelect");
	Thread.sleep(10000);

//	wrapper.dynamic_DropdownspanInputSearchListValidationValueSelection(Contactname, "SendSurvey_ClickContactDropDown","SendSurvey_SearchContactandSelect", "SendSurvey_SearchContactandSelectList");
	
	
	}

	//-------------------------------navigateToSurveyPage----------//

	public synchronized void navigateToSurveyPage() throws IOException
	{
		Reporter.log("Validate that user is able navigate on survey page");
		clickOnBRELink();
		clickOnSurveyDropDown();
		VerifyAppNavigatestoServeyScreen();
	}

	public synchronized void clickOnBRELink()
	{
		Reporter.log("Validate that user is able to click on the BRE link present on the dashboard page");
		wrapper.click("BRE_ClickBRE");

	}

	public synchronized void clickOnSurveyDropDown()
	{
		Reporter.log("Validate that user is able to click on the Survey link present inside BRE dropDown menu");
		wrapper.click("BRE_ClickSurevey");
	}

	public synchronized void VerifyAppNavigatestoServeyScreen() throws IOException
	{
		Reporter.log("Validate that user is on survey screen and view a list of surveys under my surveys");
		wrapper.validateInnerText( "BRE_MySurevey", "MySurveys");
	}


	//""""""""""""""""""""""""""""""navigateToCreateSurveyPage""""""""""""""//

	public synchronized void navigateToCreateSurveyPage()
	{
		Reporter.log("Validate that user is able navigate to create survey page from scratch");
		clickOncreatingFromScratch();
	}

	public synchronized void clickOncreatingFromScratch()
	{
		Reporter.log("Validate that user is able to click on the CreateFromScratch Button presrent on the mySurvey page");
		wrapper.click("Form_ClickFromScratch");

	}

	//----------------------------Naviagte back to surveypage after clicking cancel 

	public synchronized void VerifyAppNavigatestoServeyScreenAfterClickingCancel() throws IOException
	{
		navigateToSurveyPage();
		navigateToCreateSurveyPage();
		CreSurvey_clickCancelPresentonGeneraltab();
		VerifyAppNavigatestoServeyScreen();

	}

	public synchronized void CreSurvey_clickCancelPresentonGeneraltab()
	{
		Reporter.log("Validate that user is able to click on the CreateFromScratch Button presrent on the mySurvey page");
		wrapper.click("CreSur_Gen_Cancel");

	}

	//""""""""""""""""""""""""""""""""""creSur_fillDetailsOnGeneralTab""""""""""""""""""//

	public synchronized String creSur_fillDetailsOnGeneralTab() throws InterruptedException, IOException
	{
		Reporter.log("Validate that user is able navigate to create survey page from scratch");
		CreSur_Gen_newSurveyAndInstructionTextDisplayed();
		String SurveynameEntered=creSur_newSur_InsertValue();
		creSur_Instruction_InsertValue();
		clickOnSaveAndNextButtonePresentOnGeneralpage();
		System.out.println(SurveynameEntered + " is the Value entered");
		
		return SurveynameEntered;
	}

	public synchronized void CreSur_Gen_newSurveyAndInstructionTextDisplayed() throws InterruptedException, IOException
	{
		json = new JsonReaderfile();
		Reporter.log("Validate Create New form page is displayed");
		String ExpTitle = json.getTestCaseData("LoginExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateInnerText("CreSur_Gen_NewSeveyinline", "Expected_NewSurveyFiledtext");
			wrapper.validateInnerText("CreSur_Gen_Instruction", "Expected_InstructionFiledtext");


		}

	}

	public synchronized String creSur_newSur_InsertValue()
	{
		String newFormInsertedValue=wrapper.generateRandomString(10);
		Reporter.log("Validate that user is able to enter value in New Forms textField");
		wrapper.setTextBoxValue_Direct("CreSur_Gen_NewSevey_TextFill", newFormInsertedValue);

		return newFormInsertedValue;
	}

	public synchronized void creSur_Instruction_InsertValue()
	{
		Reporter.log("Validate that user is able to enter value in Instruction textField");
		wrapper.setTextBoxValue_Direct("CreSur_Gen_Instruction_TextFill", wrapper.generateRandomString(100));

	}

	public synchronized void clickOnSaveAndNextButtonePresentOnGeneralpage()
	{
		Reporter.log("Validate that user is able to click on the clickOnSaveAndNextButtonePresentOnGeneralpage link present on General tab on Forms page");
		wrapper.click("CreSur_Gen_SaveNextClick");
	}

	//"""""""""""""""""""""""""""""""CreSurvey_validateUserIsOnQuestionTab"""""""""""""//


	public synchronized void CreSurvey_validateUserIsOnQuestionTab(String ExpectedValue)
	{

		Reporter.log("Validate that user is able to enter value in Instruction textField");
		wrapper.validateInnerTextDirectly("CreSur_Questionnaire_panelsurveyName", ExpectedValue);
	}
	
	//"""""""""""""""""""""""""""""""Verify that user navigates to the question tab """""""""""""//

	public synchronized void validateUserNavigatetoQuestionPageafterFillingAllDetails() throws InterruptedException, IOException{

		Reporter.log("Validate that user is navigated  to surveyScreen");
		navigateToSurveyPage();

		Reporter.log("Validate that user is navigated  to Create Survey From Scretch surveyScreen");
		navigateToCreateSurveyPage();

		Reporter.log("Validate that user all details on General Tab present on the Create Survey Screen");
		String newSurveynameEntered=creSur_fillDetailsOnGeneralTab();

		Reporter.log("Validate that user app validates that user is on Questionaire tab on the Create Survey Screen");
		CreSurvey_validateUserIsOnQuestionTab(newSurveynameEntered);

	}
	
	//"""""""""""""""""""""""""""""""creSur_FillDetailsAndCreationQuestionsOnQuestionTab""""""""""""""""""//

	public void creSur_FillDetailsAndCreationQuestionsOnQuestionTab() throws InterruptedException, IOException {

		Reporter.log("Validate that user is able to fill details for Add Section filed present on Question page");

		creSur_clickOnAddSectionButtonPresentOnQuestion();
		CreSur_Question_NameAndInstructionTextDisplayed();
		creSur_Question_name_InsertValue();
		creSur_QuestionInstruction_InsertValue();
		creSur_Ques_clickOnSAVEButton();
		creSur_Ques_clickOnAddNewQuestionButton();
		addingQuestionTypeOnQuestionPage();
		Save_CreatednewSurvey();

	}
	public synchronized void creSur_clickOnAddSectionButtonPresentOnQuestion()
	{
		Reporter.log("Validate that user is able to click on the clickOnSaveAndNextButtonePresentOnGeneralpage link present on General tab on Forms page");
		wrapper.click("CreSur_ques_AddSectionClick");
	}

	public synchronized void CreSur_Question_NameAndInstructionTextDisplayed() throws InterruptedException, IOException
	{
		json = new JsonReaderfile();
		Reporter.log("Validate Create New form page is displayed");
		String ExpTitle = json.getTestCaseData("LoginExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateInnerText("CreSur_ques_Nameinline", "Expected_NameFiledtext");
			wrapper.validateInnerText("CreSur_ques_Instruction", "Expected_SectionInstructionFiledtext");


		}

	}

	public synchronized String creSur_Question_name_InsertValue()
	{
		String newFormInsertedValue=wrapper.generateRandomString(10);
		Reporter.log("Validate that user is able to enter value in New Forms textField");
		wrapper.setTextBoxValue_Direct("CreSur_ques_Name_TextFill", newFormInsertedValue);

		return newFormInsertedValue;
	}

	public synchronized void creSur_QuestionInstruction_InsertValue()
	{
		Reporter.log("Validate that user is able to enter value in Instruction textField");
		wrapper.setTextBoxValue_Direct("CreSur_ques_Instruction_TextFill", wrapper.generateRandomString(100));

	}

	public synchronized void creSur_Ques_clickOnSAVEButton()
	{
		Reporter.log("Validate that user is able to click on the clickOnSaveAndNextButtonePresentOnGeneralpage link present on General tab on Forms page");
		wrapper.click("CreSur_ques_SaveClick");
	}


	public synchronized void creSur_Ques_clickOnAddNewQuestionButton() throws InterruptedException
	{
		Thread.sleep(2000);

		Reporter.log("Validate that user is able to click on the clickOnAddSectionPresentOnQuestionnairepage link present on General tab on Forms page");
		wrapper.click("CreSur_ques_Click_AddNewQuestion");

	}

	public synchronized void addingQuestionTypeOnQuestionPage() throws IOException, InterruptedException {	
		Forms.QuestionType_SingleTextBox();
		Forms.clickOnAddNewQuestionPresentOnQuestionnairepage();

		Forms.QuestionType_YesNo();
		Forms.clickOnAddNewQuestionPresentOnQuestionnairepage();

		Forms.QuestionType_TrueFalse();
		Forms.clickOnAddNewQuestionPresentOnQuestionnairepage();

		Forms.QuestionType_RatingScale();
		Forms.clickOnAddNewQuestionPresentOnQuestionnairepage();

		Forms.QuestionType_Datetime();
		Forms.clickOnAddNewQuestionPresentOnQuestionnairepage();

		Forms.QuestionType_MultipleChoiceSingleSelection();
		Forms.clickOnAddNewQuestionPresentOnQuestionnairepage();

		Forms.QuestionType_MultipleChoiceMultipleSelection();
		Forms.clickOnAddNewQuestionPresentOnQuestionnairepage();

		Forms.QuestionType_StaticMatrix();
		Forms.clickOnAddNewQuestionPresentOnQuestionnairepage();

		Forms.QuestionType_DynamicMatrix();
		Forms.clickOnAddNewQuestionPresentOnQuestionnairepage();

		Forms.QuestionType_FileUpload();
		Forms.clickOnAddNewQuestionPresentOnQuestionnairepage();

	}

	public synchronized void Save_CreatednewSurvey()
	{
		wrapper.click("CreatenewForms_SaveButton_Click");
	}

	//-----------------------------SaveQuestion_FreezeSurvey_navigateToSendSurveyScreen----------------//



	public synchronized void SaveQuestion_FreezeSurvey_navigateToSendSurveyScreen()
	{

		Freeze_CreatednewSurvey();
		PreviewPage_CreatednewForms_ClickNextSurvey();
	}


	public synchronized void Freeze_CreatednewSurvey()
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

	public synchronized void PreviewPage_CreatednewForms_ClickNextSurvey()
	{
		wrapper.click("PreviewPage_CreatednewForms_ClickNext");
	}


	//**************************** Method Test case Specific***************************************

	//****************************navigateTopreviewScreen***************************************
	public void creSur_navigateTopreviewScreen() throws InterruptedException, IOException {

		Reporter.log("Validate that user is navigated  to surveyScreen");
		navigateToSurveyPage();

		Reporter.log("Validate that user is navigated  to Create Survey From Scretch surveyScreen");
		navigateToCreateSurveyPage();
	
		Reporter.log("Validate that user all details on General Tab present on the Create Survey Screen");
		String newSurveynameEntered=creSur_fillDetailsOnGeneralTab();

		Reporter.log("Validate that user app validates that user is on Questionaire tab on the Create Survey Screen");
		CreSurvey_validateUserIsOnQuestionTab(newSurveynameEntered);

		Reporter.log("Validate that user is able to fill all the details and able to create all qustion type and save the survey on question tab for  Create Survey Screen");
		creSur_FillDetailsAndCreationQuestionsOnQuestionTab();

	}

	//****************************navigateTopreviewScreen***************************************
	public void CreSur_OpenCreateQuestionFormOnQuestionTab() throws InterruptedException, IOException {

		Reporter.log("Validate that user is able to fill details for Add Section filed present on Question page");

		creSur_clickOnAddSectionButtonPresentOnQuestion();
		CreSur_Question_NameAndInstructionTextDisplayed();
		creSur_Question_name_InsertValue();
		creSur_QuestionInstruction_InsertValue();
		creSur_Ques_clickOnSAVEButton();
		creSur_Ques_clickOnAddNewQuestionButton();

	}

	//**************************** EditTheSavedQuestion_YesNo***************************************

	public synchronized void TC_Survey005O_editTheSavedQuestion_YesNo() throws Exception
	{
		Reporter.log("Validate that user is navigated  to surveyScreen");
		navigateToSurveyPage();

		Reporter.log("Validate that user is navigated  to Create Survey From Scretch surveyScreen");
		navigateToCreateSurveyPage();

		Reporter.log("Validate that user all details on General Tab present on the Create Survey Screen");
		String newSurveynameEntered=creSur_fillDetailsOnGeneralTab();

		Reporter.log("Validate that user app validates that user is on Questionaire tab on the Create Survey Screen");
		CreSurvey_validateUserIsOnQuestionTab(newSurveynameEntered);

		Reporter.log("Validate that user able to fill details and open creat question form page oon question tab for the Create Survey Screen");
		CreSur_OpenCreateQuestionFormOnQuestionTab();

		Reporter.log("Validate that user is able to fill the details and create yes no type question on question tab for the Create Survey Screen");
		Forms.QuestionType_YesNo();

		Reporter.log("Validate that user is able to edit  the details and for yes no type question on question tab for the Create Survey Screen");
		Edit_QuestionType_YesNo();
	}


	public synchronized void Edit_QuestionType_YesNo() throws Exception
	{
		hoverMouseonquestion();
		String questionname=QuestionType_Textarea_DataFill();
		Thread.sleep(1000);
		edit_QuestionType_Value_FromDropDown("6");
		edit_ClickOnSaveButtonPresentbelowQuestionTypeDropDown();	
		validateTC_Survey005Old_EditingQuestionsBeforeandaftertext(questionname);
	}

	public synchronized void hoverMouseonquestion() throws Exception
	{
		wrapper.HoverAndClick("CreSur_editques_YesNoHover", "CreSur_editques_yesNoClick");

	}

	public synchronized String QuestionType_Textarea_DataFill()
	{
		String questionName=wrapper.generateRandomString(10);

		Reporter.log("Validate that user is able to enter value in the question text area for selected question type");
		wrapper.setTextBoxValue_Direct("QuestionType_SinTextBox_textarea", questionName);

		return questionName;

		//	wrapper.setTextBoxValue( "QuestionType_SinTextBox_textarea", "EditedQuestion_name");
	}

	public synchronized void edit_QuestionType_Value_FromDropDown(String Value)
	{
		Reporter.log("Validate that user is able to enter value in the question text area for selected question type");
		try {
			wrapper.WaitForElementThenClick("EditQuestionType_DropDownValue_Selection");
			wrapper.selectByValue("EditQuestionType_DropDownValue_Selection", Value);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public synchronized void edit_ClickOnSaveButtonPresentbelowQuestionTypeDropDown()
	{
		Reporter.log("Validate that user is able to click on the clickOnAddSectionPresentOnQuestionnairepage link present on General tab on Forms page");
		wrapper.click("EditQuestionType_DropDown_below_Savebutton");
	}

	public synchronized void validateTC_Survey005Old_EditingQuestionsBeforeandaftertext(String ExpectedText)
	{
		Reporter.log("Validate that edited text is remains same after saveing the form");
		System.out.println(ExpectedText);

		wrapper.validateActualAndExpectedTextDirectly("CreSur_Question_EditQuestion_Name",ExpectedText );
	}

	//**************************** DeleteTheSavedQuestion_YesNo***************************************

	public synchronized void TC_Survey006O_DeleteTheSavedQuestion_YesNo() throws Exception
	{
		Reporter.log("Validate that user is navigated  to surveyScreen");
		navigateToSurveyPage();

		Reporter.log("Validate that user is navigated  to Create Survey From Scretch surveyScreen");
		navigateToCreateSurveyPage();

		Reporter.log("Validate that user all details on General Tab present on the Create Survey Screen");
		String newSurveynameEntered=creSur_fillDetailsOnGeneralTab();

		Reporter.log("Validate that user app validates that user is on Questionaire tab on the Create Survey Screen");
		CreSurvey_validateUserIsOnQuestionTab(newSurveynameEntered);

		Reporter.log("Validate that user able to fill details and open creat question form page oon question tab for the Create Survey Screen");
		CreSur_OpenCreateQuestionFormOnQuestionTab();

		Reporter.log("Validate that user is able to fill the details and create yes no type question on question tab for the Create Survey Screen");
		Forms.QuestionType_YesNo();

		Reporter.log("Validate that user is able to delelte the created  on question tab for the Create Survey Screen");
		hoverMouseonquestionAndDelete();

	}
	public synchronized void hoverMouseonquestionAndDelete() throws Exception
	{
		wrapper.HoverAndClick("CreSur_editques_YesNoHover", "CreSur_Deleteques_Click");
		wrapper.getDriver().switchTo().alert().accept();

	}



	//**************************** Auto_Protack_SurveyModule_TC_Survey006O_DeletingQuestion***************************************

	public void navigatebacktoQuestionPageFromPreviewScreen() 

	{
		wrapper.click("CreSur_QuestionNaire_Click");
		System.out.println("able to click");

	}
}




