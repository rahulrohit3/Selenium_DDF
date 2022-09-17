package protrack.main.test.page;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import protrack.com.frame.core.BaseDriver;
import protrack.com.frame.core.BaseTest;
import protrack.com.frame.core.GenericWebTableFunctions;
import protrack.com.frame.core.SeleniumHelper;
import protrack.com.frame.util.JsonReaderfile;
import protrack.com.test.suite.ExecutionEnvironment;

public class Projectpage extends BaseTest {
	SeleniumHelper wrapper = new SeleniumHelper();
	JsonReaderfile json;
	BaseDriver base = new BaseDriver();
	ExecutionEnvironment exec=new ExecutionEnvironment();
	DashBoardPage Dashboard=new DashBoardPage();
	public WebElement element;
	CompanyPage Company=new CompanyPage();
	ContactPage contact=null;

	
	/**
	 **************************************************************************************************************
	 * @throws InterruptedException 
	 * @throws IOException 
	 * @Function Name: project page
	 * @Description: functions are used for project pages
	 * @Param: 
	 * @Return:
	 * @Date: 22th,July-2019
	 * @Author: Ravi Ranjan
	 **************************************************************************************************************
	 */


	public synchronized String Createproject() throws InterruptedException, IOException
	{
		wrapper.click("ModalBox_AddProject");
		isAddprojectPageDisplayed();
		String projectname=add_data_submit_ProjectName_of_project();
		add_select_submit_CompnayCategory_of_project();
		add_select_submit_ProjectManager_DropDown();
		add_select_submit_Compnany_of_project();
		add_select_submit_PrimaryContact_of_project();
		Thread.sleep(3000);
		add_select_submit_SecondaryContact_of_project();
		//	add_select_submit_OtherContact_DropDown();
		add_select_submit_IndustryCluster_of_project();
		// 	add_select_submit_NAICSCode_DropDown();
		//	add_submit_CommisionerName();
		//	add_submit_District();
		add_Select_submit_Projectdatetype();
		add_submit_Projectdate();
		add_submit_ProjectdateNotes();
		addProject_Date_Grid();
		//add_select_submit_Visibility();
		add_select_submit_Tags();
		add_select_submit_Projectdate_Notes();
		add_select_submit_phoneType();
		add_select_submit_phoneNumberExtension();
		addProject_Phone_Grid();
		add_select_submit_EmailType();
		add_submit_Email();
		add_submit_EmailNotes();
		addProject_Email_Grid();
		add_Select_submit_AddressType();
		add__submit_StreetAddress();
		add__submit_StreetAddress2();
		add_submit_City();
		add_Select_Country();
		add_Select_State();
		add_Submit_Zip();
		add_Submit_Alias();
		addProject_Address_Grid();
		add_Select_URL();
		add_Submit_URLValue();
		add_Submit_URLNote();
		addProject_URL_Grid();
		Thread.sleep(5000);
		add_Select_SocialProfile();
		add_Submit_SocialProfileValue();
		add_Submit_SocialProfileNote();
		addProject_SocialProfile_Grid();
		Thread.sleep(3000);
		add_Select_InstantMessenger();
		add_Submit_InstantMessengerValue();
		add_Submit_InstantMessengerNote();
		addProject_InstantMessenger_Grid();
		
		//add_Select_RFI();
		//add_Select_RFIResponse();
		//add_Submit_Extrastring();
		//add_Submit_Dummydate();
		//add_Submit_RFIResponseNotes();
		//addProject_RFI_Grid();
		add_Submit_RFIDate();
		add_Submit_RFISource();
		
		


		///Project data tab********************

		Open_Projectdata_Tab();
		add_submit_Projectdata_Description();
		add_select_submit_StagesType_projectData();
		add_Submit_Stages_Date_projectdata();
		add_Submit_Stages_Notes_projectdata();
		addProject_Stages_Grid();
		Thread.sleep(3000);
		add_select_submit_IncentivesType_projectData();
		add_Submit_Incentives_Date_projectdata();
		add_Submit_Incentives_Notes_projectdata();
		addProject_Incentives_Grid();
		add_select_submit_HistoryType_projectData();
		add_Submit_History_Date_projectdata();
		addProject_History_Grid();
		add_Select_Construction_start_date();
		add_Select_Construction_End_date();
		add_Submit_requirmnet_Description();
		add_Submit_SpaceRequirmnet_ExistingBuilding_value();
		add_Submit_SpaceRequirmnet_ExistingBuilding_Notes();
		



		/////Project Benefits tab*****************************

		open_ProjectBenifits_Tab();
		//Enter_ProjectBenifits_InvestmnetNotes();
		//Enter_ProjectBenifits_IncentivesNotes();
		//Enter_ProjectBenifits_InVestmentInhibitors();
		//Enter_ProjectBenifits_InvestmentRational();
		Enter_ProjectBenifits_Investment_realstate_value();
		Enter_ProjectBenifits_Investment_Inventory();
		Enter_ProjectBenifits_Investment_MachineandEquipment();
		Enter_ProjectBenifits_Investment_FurnitureFixture();
		Add_investmnet();
		//Enter_ProjectBenifits_Investment_Amount();
		//Enter_ProjectBenifits_Incentive_Amount();
		Enter_ProjectBenifits_EmploymnetFullTimeNumber();
		Enter_ProjectBenifits_EmploymnetFullTimesalary();
		Enter_ProjectBenifits_EmploymnetManagmnetNumber();
		Enter_ProjectBenifits_EmploymnetmangamentSalary();
		Enter_ProjectBenifits_EmploymnetPartTimeNumber();
		Enter_ProjectBenifits_EmploymnetPartTimeSalary();
		Enter_ProjectBenifits_EmploymnetContractNumber();
		Enter_ProjectBenifits_EmploymnetContractSalary();
		add_employmnet_details();
		Enter_ProjectBenifits_NumberConstructionJobs();
		Enter_ProjectBenifits_WorkerWages();
		Enter_ProjectBenifits_ConstructionJobs();
		Enter_ProjectBenifits_TotalJobs();


		///////*******************Project Resources***********

		wrapper.click("ProjectResources_Title");
		Select_ProjectResource_Type();
		Enter_ProjectResource_DocumentDescription();
		Enter_ProjectResource_Keyword();
		ResourceTabDataEnter_uploadFile();

		///////**********************************Interaction Notes*************

		wrapper.click("ProjectInteractionNotes_Tab_Title");
		Select_ProjectInteraction_NoteType();
		Enter_ProjectInteraction_Keyword();
		//	add_select__Attendee_DropDown();
		Enter_ProjectInteraction_sortDescription();
		ProjectInteraction_uploadDocfile();
		add_select_Company_DropDown();

		///**************************Task*******************
		wrapper.click("ProjectTask_Tab_Title");
		Enter_ProjectTask_TaskName();
		add_Select_TaskStart_date();
		add_Select_TaskDue_date();
		//	add_select_RecordStatus_DropDown();
		Enter_ProjectTask_phase();
		wrapper.waitForBrowserToLoadCompletely();
		add_Submit_Project_validate(projectname);
		validateProjectCreated(projectname);
		
		return projectname;

	}
	
	public synchronized String Createproject_SCIDA() throws InterruptedException, IOException
	{
		wrapper.click("ModalBox_AddProject");
		String projectname=add_data_submit_ProjectName_of_project();
		add_select_submit_CompnayCategory_of_project();
		add_select_submit_ProjectManager_DropDown();
		add_select_submit_Compnany_of_project_SCIDA();
		add_data_submit_principals_of_project_scida();
		add_select_submit_PrimaryContact_of_project_SCIDA("Alexander Caro");
		add_select_submit_SecondaryContact_of_project("Abe Mayeri");
		add_select_submit_OtherContact_DropDown();
		add_data_submit_leadsource_of_project_scida();
		add_select_submit_IndustryCluster_of_project();
		add_select_submit_NAICSCode_DropDown_SCIDA();
		add_submit_CommisionerName();
		add_submit_District();
		add_Select_submit_Projectdatetype();
		add_submit_Projectdate();
		add_submit_ProjectdateNotes();
		//add_select_submit_Visibility();
		//add_select_submit_Tags();
		add_select_submit_Projectdate_Notes();
		add_select_submit_phoneType();
		add_select_submit_phoneNumberExtension();
		add_select_submit_EmailType();
		add_submit_Email();
		add_submit_EmailNotes();
		add_Select_submit_AddressType();
		add__submit_StreetAddress();
		add__submit_StreetAddress2();
		add_submit_City();
		add_Select_Country();
		add_Select_State();
		add_Submit_Zip();
		add_Submit_Alias();
		add_Select_URL();
		add_Submit_URLValue();
		add_Submit_URLNote();
		add_Select_RFI();
		//add_Select_RFIResponse();
		//add_Submit_Extrastring();
		//add_Submit_Dummydate();
		add_Submit_RFIResponseNotes();
		add_Submit_RFIDate();
		add_Submit_RFISource();


		///Project data tab********************

		Open_Projectdata_Tab();
		add_submit_Projectdata_Description();
		add_submit_Projectdata_process_scida();
		add_select_submit_StagesType_projectData();
		add_submit_Projectbenifits_IssueAmountRequested_scida();
		add_submit_Projectbenifits_fbr_scida();
		add_submit_Projectbenifits_closedbond_scida();
		add_Submit_Stages_Date_projectdata();
		add_Submit_Stages_Notes_projectdata();
		add_Select_Construction_start_date();
		add_Select_Construction_End_date();
		add_Submit_requirmnet_Description();
		add_Submit_SpaceRequirmnet_ExistingBuilding_value();
		add_Submit_SpaceRequirmnet_ExistingBuilding_Notes_scida();



		/////Project Benefits tab*****************************

		open_ProjectBenifits_Tab();
	    Enter_ProjectBenifits_InvestmnetNotes();
		Enter_ProjectBenifits_IncentivesNotes();
		Enter_ProjectBenifits_InVestmentInhibitors();
		Enter_ProjectBenifits_InvestmentRational();
		Enter_ProjectBenifits_Investment_realstate_value();
		Enter_ProjectBenifits_Investment_Inventory();
		Enter_ProjectBenifits_Investment_MachineandEquipment();
		Enter_ProjectBenifits_Investment_FurnitureFixture();
		Add_investmnet();
		//Enter_ProjectBenifits_Investment_Amount();
		//Enter_ProjectBenifits_Incentive_Amount();
		Enter_ProjectBenifits_EmploymnetFullTimeNumber();
		Enter_ProjectBenifits_EmploymnetFullTimesalary();
		Enter_ProjectBenifits_EmploymnetManagmnetNumber();
		Enter_ProjectBenifits_EmploymnetmangamentSalary();
		Enter_ProjectBenifits_EmploymnetPartTimeNumber();
		Enter_ProjectBenifits_EmploymnetPartTimeSalary();
		Enter_ProjectBenifits_EmploymnetContractNumber();
		Enter_ProjectBenifits_EmploymnetContractSalary();
		add_employmnet_details();
		Enter_ProjectBenifits_NumberConstructionJobs();
		Enter_ProjectBenifits_WorkerWages();
		//Enter_ProjectBenifits_ConstructionJobs();
		//Enter_ProjectBenifits_TotalJobs();


		///////*******************Project Resources***********

		wrapper.click("ProjectResources_Title");
		Select_ProjectResource_Type();
		Enter_ProjectResource_DocumentDescription();
		Enter_ProjectResource_Keyword();
		ResourceTabDataEnter_uploadFile();

		///////**********************************Interaction Notes*************

		wrapper.click("ProjectInteractionNotes_Tab_Title");
		Select_ProjectInteraction_NoteType();
		Enter_ProjectInteraction_Keyword();
		//	add_select__Attendee_DropDown();
		Enter_ProjectInteraction_sortDescription();
		ProjectInteraction_uploadDocfile();
		add_select_Company_DropDown("201 W. Broadway PJ, LLC");

		///**************************Task*******************
		wrapper.click("ProjectTask_Tab_Title");
		Enter_ProjectTask_TaskName();
		add_Select_TaskStart_date();
		add_Select_TaskDue_date();
		//	add_select_RecordStatus_DropDown();
		Enter_ProjectTask_phase();
		add_Submit_Project_validate(projectname);
		validateProjectCreated(projectname);
		
		return projectname;

	}
	
	public synchronized String Createproject_dafc() throws InterruptedException, IOException
	{
		wrapper.click("ModalBox_AddProject");
		isAddprojectPageDisplayed();
		String projectname=add_data_submit_ProjectName_of_project();
		add_select_submit_CompnayCategory_of_project();
		//add_select_submit_ProjectManager_DropDown("Administrator ");
		add_select_submit_Compnany_of_project("357 Gift Shop.com");
		//add_data_submit_principals_of_project_scida();
		add_select_submit_PrimaryContact_of_project_SCIDA("Aadu Allpere");
		add_select_submit_SecondaryContact_of_project("Adam Harbin");
		Thread.sleep(5000);
		add_select_submit_OtherContact_DropDown();
		//add_data_submit_leadsource_of_project_scida();
		add_select_submit_IndustryCluster_of_project();
		wrapper.waitForBrowserToLoadCompletely();
		add_select_submit_NAICSCode_DropDown();
		wrapper.waitForBrowserToLoadCompletely();
		add_submit_CommisionerName();
		add_submit_District();
//		add_Select_submit_Projectdatetype();
//		add_submit_Projectdate();
//		add_submit_ProjectdateNotes();
		//add_select_submit_Visibility();
		add_select_submit_Tags();
		//add_select_submit_Projectdate_Notes();
		add_select_submit_phoneType();
		add_select_submit_phoneNumberExtension();
		add_select_submit_EmailType();
		add_submit_Email();
		add_submit_EmailNotes();
		add_Select_submit_AddressType();
		add__submit_StreetAddress();
		add__submit_StreetAddress2();
		add_submit_City();
		add_Select_Country();
		add_Select_State();
		add_Submit_Zip();
		add_Submit_Alias();
		add_Submit_taxmap();
		add_Submit_schooldistric();
		add_Submit_acreage();
		add_Select_URL();
		add_Submit_URLValue();
		add_Submit_URLNote();
		add_Select_RFI();
		//add_Select_RFIResponse();
		//add_Submit_Extrastring();
		//add_Submit_Dummydate();
		add_Submit_RFIResponseNotes();
		add_Submit_RFIDate();
		add_Submit_RFISource();


		///Project data tab********************

		Open_Projectdata_Tab();
		add_submit_Projectdata_Description();
		add_submit_Projectdata_process_scida();
		add_select_submit_StagesType_projectData();
		add_submit_Projectbenifits_IssueAmountRequested_scida();
		add_submit_Projectbenifits_fbr_scida();
		add_submit_Projectbenifits_closedbond_scida();
		add_Submit_Stages_Date_projectdata();
		add_Submit_Stages_Notes_projectdata();
		add_Select_Construction_start_date();
		add_Select_Construction_End_date();
		add_Submit_requirmnet_Description();
		add_Submit_SpaceRequirmnet_ExistingBuilding_value();
		add_Submit_SpaceRequirmnet_ExistingBuilding_Notes_scida();



		/////Project Benefits tab*****************************

		open_ProjectBenifits_Tab();
	    Enter_ProjectBenifits_InvestmnetNotes();
		Enter_ProjectBenifits_IncentivesNotes();
		Enter_ProjectBenifits_InVestmentInhibitors();
		Enter_ProjectBenifits_InvestmentRational();
		Enter_ProjectBenifits_Investment_realstate_value();
		Enter_ProjectBenifits_Investment_Inventory();
		Enter_ProjectBenifits_Investment_MachineandEquipment();
		Enter_ProjectBenifits_Investment_FurnitureFixture();
		Add_investmnet();
		//Enter_ProjectBenifits_Investment_Amount();
		//Enter_ProjectBenifits_Incentive_Amount();
		Enter_ProjectBenifits_EmploymnetFullTimeNumber();
		Enter_ProjectBenifits_EmploymnetFullTimesalary();
		Enter_ProjectBenifits_EmploymnetManagmnetNumber();
		Enter_ProjectBenifits_EmploymnetmangamentSalary();
		Enter_ProjectBenifits_EmploymnetPartTimeNumber();
		Enter_ProjectBenifits_EmploymnetPartTimeSalary();
		Enter_ProjectBenifits_EmploymnetContractNumber();
		Enter_ProjectBenifits_EmploymnetContractSalary();
		add_employmnet_details();
		Enter_ProjectBenifits_NumberConstructionJobs();
		Enter_ProjectBenifits_WorkerWages();
		//Enter_ProjectBenifits_ConstructionJobs();
		//Enter_ProjectBenifits_TotalJobs();


		///////*******************Project Resources***********

		wrapper.click("ProjectResources_Title");
		Select_ProjectResource_Type();
		Enter_ProjectResource_DocumentDescription();
		Enter_ProjectResource_Keyword();
		ResourceTabDataEnter_uploadFile();

		///////**********************************Interaction Notes*************

		wrapper.click("ProjectInteractionNotes_Tab_Title");
		Select_ProjectInteraction_NoteType();
		Enter_ProjectInteraction_Keyword();
		//	add_select__Attendee_DropDown();
		Enter_ProjectInteraction_sortDescription();
		ProjectInteraction_uploadDocfile();
		add_select_Company_DropDown("357 Gift Shop.com");

		///**************************Task*******************
		wrapper.click("ProjectTask_Tab_Title");
		Enter_ProjectTask_TaskName();
		add_Select_TaskStart_date();
		add_Select_TaskDue_date();
		//	add_select_RecordStatus_DropDown();
		Enter_ProjectTask_phase();
		add_Submit_Project_validate(projectname);
		validateProjectCreated(projectname);
		
		return projectname;

	}
	
	public synchronized String CreateprojectWithFewDetails() throws InterruptedException, IOException
	{
		wrapper.click("ModalBox_AddProject");
		isAddprojectPageDisplayed();
		String projectname=add_data_submit_ProjectName_of_project();
		add_select_submit_CompnayCategory_of_project();
		add_select_submit_ProjectManager_DropDown();
		add_select_submit_Compnany_of_project();

		add_Submit_Project_validate(projectname);
		validateProjectCreated(projectname);
		
		return projectname;

	}

	
	public synchronized void CreateTask() throws InterruptedException, IOException
	{
		wrapper.click("ModalBox_AddProject");
		isAddprojectPageDisplayed();
		add_data_submit_ProjectName_of_project();
		add_select_submit_CompnayCategory_of_project();
		add_select_submit_ProjectManager_DropDown();
		add_select_submit_Compnany_of_project();
		add_select_submit_PrimaryContact_of_project();
		add_select_submit_SecondaryContact_of_project();
		


		///Project data tab********************

		Open_Projectdata_Tab();
		add_submit_Projectdata_Description();
		add_select_submit_StagesType_projectData();
		add_Submit_Stages_Date_projectdata();
		add_Submit_Stages_Notes_projectdata();
		add_Select_Construction_start_date();
		



		/////Project Benefits tab*****************************

		open_ProjectBenifits_Tab();
		//Enter_ProjectBenifits_InvestmnetNotes();
		//Enter_ProjectBenifits_IncentivesNotes();
		//Enter_ProjectBenifits_InVestmentInhibitors();
		//Enter_ProjectBenifits_InvestmentRational();
		Enter_ProjectBenifits_Investment_realstate_value();
		Enter_ProjectBenifits_Investment_Inventory();
		Enter_ProjectBenifits_Investment_MachineandEquipment();
		Enter_ProjectBenifits_Investment_FurnitureFixture();
		Add_investmnet();
		

		///////*******************Project Resources***********

		wrapper.click("ProjectResources_Title");
		Select_ProjectResource_Type();
		Enter_ProjectResource_DocumentDescription();
		Enter_ProjectResource_Keyword();
		ResourceTabDataEnter_uploadFile();

		///////**********************************Interaction Notes*************

		wrapper.click("ProjectInteractionNotes_Tab_Title");
		Select_ProjectInteraction_NoteType();
		Enter_ProjectInteraction_Keyword();
		

		///**************************Task*******************
		wrapper.click("ProjectTask_Tab_Title");
		Enter_ProjectTask_TaskName();
		add_Select_TaskStart_date();
		add_Select_TaskDue_date();
		//	add_select_RecordStatus_DropDown();
		Enter_ProjectTask_phase();
		wrapper.waitForBrowserToLoadCompletely();
		add_Submit_edited_task();

	}
	
	
	public synchronized void CreateTask_scida() throws InterruptedException, IOException
	{
		wrapper.click("ModalBox_AddProject");
		add_data_submit_ProjectName_of_project();
	

		///Project data tab********************

		Open_Projectdata_Tab();
		add_submit_Projectdata_Description();
		
		///**************************Task*******************
		wrapper.click("ProjectTask_Tab_Title");
		Enter_ProjectTask_TaskName();
		Enter_ProjectTaskAssigne_scida();
		add_Select_TaskStart_date();
		add_Select_TaskDue_date();
		//	add_select_RecordStatus_DropDown();
		Enter_ProjectTask_phase();
		add_Submit_edited_task();

	}
	
	public synchronized void CreateTask_dafc() throws InterruptedException, IOException
	{
		wrapper.click("ModalBox_AddProject");
		isAddprojectPageDisplayed();
		add_data_submit_ProjectName_of_project();
		add_select_submit_CompnayCategory_of_project();
		//add_select_submit_ProjectManager_DropDown();
		add_select_submit_Compnany_of_project("357 Gift Shop.com");
		add_select_submit_PrimaryContact_of_project_SCIDA("Aadu Allpere");
		add_select_submit_SecondaryContact_of_project("Aadu Allpere");
		


		///Project data tab********************

		Open_Projectdata_Tab();
		add_submit_Projectdata_Description();
		add_select_submit_StagesType_projectData();
		add_Submit_Stages_Date_projectdata();
		add_Submit_Stages_Notes_projectdata();
		add_Select_Construction_start_date();
		



		/////Project Benefits tab*****************************

		open_ProjectBenifits_Tab();
		//Enter_ProjectBenifits_InvestmnetNotes();
		//Enter_ProjectBenifits_IncentivesNotes();
		//Enter_ProjectBenifits_InVestmentInhibitors();
		//Enter_ProjectBenifits_InvestmentRational();
		Enter_ProjectBenifits_Investment_realstate_value();
		Enter_ProjectBenifits_Investment_Inventory();
		Enter_ProjectBenifits_Investment_MachineandEquipment();
		Enter_ProjectBenifits_Investment_FurnitureFixture();
		Add_investmnet();
		

		///////*******************Project Resources***********

		wrapper.click("ProjectResources_Title");
		Select_ProjectResource_Type();
		Enter_ProjectResource_DocumentDescription();
		Enter_ProjectResource_Keyword();
		ResourceTabDataEnter_uploadFile();

		///////**********************************Interaction Notes*************

		wrapper.click("ProjectInteractionNotes_Tab_Title");
		Select_ProjectInteraction_NoteType();
		Enter_ProjectInteraction_Keyword();
		

		///**************************Task*******************
		wrapper.click("ProjectTask_Tab_Title");
		Enter_ProjectTask_TaskName();
		Enter_ProjectTaskAssigne();
		add_Select_TaskStart_date();
		add_Select_TaskDue_date();
		//	add_select_RecordStatus_DropDown();
		Enter_ProjectTask_phase();
		add_Submit_edited_task();

	}

	public synchronized void CreateTask_cancel_confirmation_save() throws InterruptedException, IOException
	{
		wrapper.click("ModalBox_AddProject");
		isAddprojectPageDisplayed();
		add_data_submit_ProjectName_of_project();
		wrapper.click("project_cancel_buton");
		Thread.sleep(2000);
		wrapper.click("project_saveandcontinue_popup_buton");
	}
	
	public synchronized void CreateTask_cancel_donotsave() throws InterruptedException, IOException
	{
		wrapper.click("ModalBox_AddProject");
		isAddprojectPageDisplayed();
		add_data_submit_ProjectName_of_project();
		wrapper.click("project_cancel_buton");
		Thread.sleep(2000);
		wrapper.click("project_donotsaveandcontinue_popup_buton");
	}
	
	public synchronized void CreateTask_cancel_withcancelation_confirmation() throws InterruptedException, IOException
	{
		wrapper.click("ModalBox_AddProject");
		isAddprojectPageDisplayed();
		add_data_submit_ProjectName_of_project();
		wrapper.click("project_cancel_buton");
		Thread.sleep(2000);
		wrapper.click("project_cancel_popup_buton");
	}
	
	public synchronized void Createproject_withnewlyCreated_contact_comp(String compnamenew, String contactnamenew) throws InterruptedException, IOException
	{
		wrapper.click("ModalBox_AddProject");
		isAddprojectPageDisplayed();
		String projectnamenew=add_data_submit_ProjectName_of_project();
		add_select_submit_CompnayCategory_of_project();
		add_select_submit_ProjectManager_DropDown();
		add_select_submit_Compnany(compnamenew);
		add_select_submit_PrimaryContact_newlycreated(contactnamenew);
		add_select_submit_SecondaryContact_of_project();
		//	add_select_submit_OtherContact_DropDown();
		add_select_submit_IndustryCluster_of_project();
		// 	add_select_submit_NAICSCode_DropDown();
		//	add_submit_CommisionerName();
		//	add_submit_District();
		add_Select_submit_Projectdatetype();
		add_submit_Projectdate();
		add_submit_ProjectdateNotes();
		//add_select_submit_Visibility();
		add_select_submit_Tags();
		add_select_submit_Projectdate_Notes();
		add_select_submit_phoneType();
		add_select_submit_phoneNumberExtension();
		add_select_submit_EmailType();
		add_submit_Email();
		add_submit_EmailNotes();
		add_Select_submit_AddressType();
		add__submit_StreetAddress();
		add__submit_StreetAddress2();
		add_submit_City();
		add_Select_Country();
		add_Select_State();
		add_Submit_Zip();
		add_Submit_Alias();
		add_Select_URL();
		add_Submit_URLValue();
		add_Submit_URLNote();
		add_Select_RFI();
		//add_Select_RFIResponse();
		//add_Submit_Extrastring();
		//add_Submit_Dummydate();
		add_Submit_RFIResponseNotes();
		add_Submit_RFIDate();
		add_Submit_RFISource();
		add_Submit_Project_validate(projectnamenew);
		
	}
	public synchronized void Create_edit_resource() throws InterruptedException, IOException
	{
		
		wrapper.click("ModalBox_AddProject");
		isAddprojectPageDisplayed();
		String projectname=add_data_submit_ProjectName_of_project();
		add_select_submit_CompnayCategory_of_project();
		add_select_submit_ProjectManager_DropDown();
		add_select_submit_Compnany_of_project();
		add_select_submit_PrimaryContact_of_project();
		add_select_submit_SecondaryContact_of_project();
		//	add_select_submit_OtherContact_DropDown();
		add_select_submit_IndustryCluster_of_project();
		// 	add_select_submit_NAICSCode_DropDown();
		//	add_submit_CommisionerName();
		//	add_submit_District();
		add_Select_submit_Projectdatetype();
		add_submit_Projectdate();
		add_submit_ProjectdateNotes();
		//add_select_submit_Visibility();
		add_select_submit_Tags();
		add_select_submit_Projectdate_Notes();
		add_select_submit_phoneType();
		add_select_submit_phoneNumberExtension();
		add_select_submit_EmailType();
		add_submit_Email();
		add_submit_EmailNotes();
		add_Select_submit_AddressType();
		add__submit_StreetAddress();
		add__submit_StreetAddress2();
		add_submit_City();
		add_Select_Country();
		add_Select_State();
		add_Submit_Zip();
		add_Submit_Alias();
		add_Select_URL();
		add_Submit_URLValue();
		add_Submit_URLNote();
		add_Select_RFI();
		//add_Select_RFIResponse();
		//add_Submit_Extrastring();
		//add_Submit_Dummydate();
		add_Submit_RFIResponseNotes();
		add_Submit_RFIDate();
		add_Submit_RFISource();		

		///////*******************Project Resources***********

		wrapper.click("ProjectResources_Title");
		Select_ProjectResource_Type();
		Enter_ProjectResource_DocumentDescription();
		Enter_ProjectResource_Keyword();
		ResourceTabDataEnter_uploadFile();
		add_Submit_Project_validate(projectname);
		validateProjectCreated(projectname);
		
		wrapper.click("Link_Project_Managment_page");
		wrapper.click("ProjectResources_Title");
		wrapper.click("Project_edit_button");
	
		///////*******************Project Resources edit***********
		wrapper.click("Project_resource_edit_Button");
		Enter_ProjectResource_DocumentDescription();
		Enter_ProjectResource_Keyword();
		ResourceTabDataEnter_uploadFile();
		add_Submit_edited_resources();
		

	}
	
	public synchronized void Create_edit_resource_scida() throws InterruptedException, IOException
	{
		
		wrapper.click("ModalBox_AddProject");
		isAddprojectPageDisplayed();
		String projectname=add_data_submit_ProjectName_of_project();
	
		add_select_submit_CompnayCategory_of_project();
		add_select_submit_ProjectManager_DropDown("Admin");
		add_select_submit_Compnany_of_project_SCIDA();
		add_select_submit_PrimaryContact_of_project_SCIDA("Alexander Caro");
		add_select_submit_SecondaryContact_of_project("Abe Mayeri");
		//	add_select_submit_OtherContact_DropDown();
		add_select_submit_IndustryCluster_of_project();
		add_select_submit_NAICSCode_DropDown();
		add_submit_CommisionerName();
		add_submit_District();
		add_Select_submit_Projectdatetype();
		add_submit_Projectdate();
		add_submit_ProjectdateNotes();
		//add_select_submit_Visibility();
		add_select_submit_Tags();
		add_select_submit_Projectdate_Notes();
		add_select_submit_phoneType();
		add_select_submit_phoneNumberExtension();
		add_select_submit_EmailType();
		add_submit_Email();
		add_submit_EmailNotes();
		add_Select_submit_AddressType();
		add__submit_StreetAddress();
		add__submit_StreetAddress2();
		add_submit_City();
		add_Select_Country();
		add_Select_State();
		add_Submit_Zip();
		add_Submit_Alias();
		add_Select_URL();
		add_Submit_URLValue();
		add_Submit_URLNote();
		add_Select_RFI();
		//add_Select_RFIResponse();
		//add_Submit_Extrastring();
		//add_Submit_Dummydate();
		add_Submit_RFIResponseNotes();
		add_Submit_RFIDate();
		add_Submit_RFISource();		

		///////*******************Project Resources***********

		wrapper.click("ProjectResources_Title");
		Select_ProjectResource_Type();
		Enter_ProjectResource_DocumentDescription();
		Enter_ProjectResource_Keyword();
		ResourceTabDataEnter_uploadFile();
		add_Submit_Project_validate(projectname);
		validateProjectCreated(projectname);
		
		wrapper.click("Link_Project_Managment_page");
		wrapper.click("ProjectResources_Title");
		wrapper.click("Project_edit_button");
	
		///////*******************Project Resources edit***********
		wrapper.click("Project_resource_edit_Button");
		Enter_ProjectResource_DocumentDescription();
		Enter_ProjectResource_Keyword();
		ResourceTabDataEnter_uploadFile();
		add_Submit_edited_resources();
		

	}
	
	
	public synchronized void Create_edit_resource_dafc() throws InterruptedException, IOException
	{
		
		wrapper.click("ModalBox_AddProject");
		isAddprojectPageDisplayed();
		String projectname=add_data_submit_ProjectName_of_project();
	

		///////*******************Project Resources***********

		wrapper.click("ProjectResources_Title");
		Select_ProjectResource_Type();
		Enter_ProjectResource_DocumentDescription();
		Enter_ProjectResource_Keyword();
		ResourceTabDataEnter_uploadFile();
		add_Submit_Project_validate(projectname);
		validateProjectCreated(projectname);
		
		wrapper.click("Link_Project_Managment_page");
		wrapper.click("ProjectResources_Title");
		wrapper.click("Project_edit_button");
	
		///////*******************Project Resources edit***********
		wrapper.click("Project_resource_edit_Button");
		Enter_ProjectResource_DocumentDescription();
		Enter_ProjectResource_Keyword();
		ResourceTabDataEnter_uploadFile();
		add_Submit_edited_resources();
		

	}
	
	
	public synchronized void EditProjectTask() throws InterruptedException, IOException
	{
		wrapper.click("Link_Project_Managment_page");
		wrapper.click("ProjectTask_Tab_Title");
		wrapper.click("Project_edit_button");
		Enter_ProjectTask_TaskName();
		add_Select_TaskStart_date();
		add_Select_TaskDue_date();
		//	add_select_RecordStatus_DropDown();
		Enter_ProjectTask_phase();
		add_Submit_edited_task();

	}
	
	public synchronized void Delete_AddedInteractionNotes() throws InterruptedException, IOException
	{
		wrapper.click("ModalBox_AddProject");
		isAddprojectPageDisplayed();
		String projectname=add_data_submit_ProjectName_of_project();
		add_select_submit_CompnayCategory_of_project();
		add_select_submit_ProjectManager_DropDown();
		add_select_submit_Compnany_of_project();
		add_select_submit_PrimaryContact_of_project();
		add_select_submit_SecondaryContact_of_project();
		//	add_select_submit_OtherContact_DropDown();
		add_select_submit_IndustryCluster_of_project();
		// 	add_select_submit_NAICSCode_DropDown();
		//	add_submit_CommisionerName();
		//	add_submit_District();
		add_Select_submit_Projectdatetype();
		add_submit_Projectdate();
		add_submit_ProjectdateNotes();
		//add_select_submit_Visibility();
		add_select_submit_Tags();
		add_select_submit_Projectdate_Notes();
		add_select_submit_phoneType();
		add_select_submit_phoneNumberExtension();
		add_select_submit_EmailType();
		add_submit_Email();
		add_submit_EmailNotes();
		add_Select_submit_AddressType();
		add__submit_StreetAddress();
		add__submit_StreetAddress2();
		add_submit_City();
		add_Select_Country();
		add_Select_State();
		add_Submit_Zip();
		add_Submit_Alias();
		add_Select_URL();
		add_Submit_URLValue();
		add_Submit_URLNote();
		add_Select_RFI();
		//add_Select_RFIResponse();
		//add_Submit_Extrastring();
		//add_Submit_Dummydate();
		add_Submit_RFIResponseNotes();
		add_Submit_RFIDate();
		add_Submit_RFISource();		

	///////**********************************Interaction Notes*************

			wrapper.click("ProjectInteractionNotes_Tab_Title");
			Select_ProjectInteraction_NoteType();
			Enter_ProjectInteraction_Keyword();
			//	add_select__Attendee_DropDown();
			Enter_ProjectInteraction_sortDescription();
			ProjectInteraction_uploadDocfile();
			add_select_Company_DropDown();
			wrapper.waitForBrowserToLoadCompletely();
		add_Submit_Project_validate(projectname);
		validateProjectCreated(projectname);
/////////******************************************
		wrapper.click("Link_Project_Managment_page");
		wrapper.click("ProjectInteractionNotes_Tab_Title");
		wrapper.click("Project_edit_button");
		wrapper.waitForBrowserToLoadCompletely();
		wrapper.click("Project_interactionNote_delete");
		Thread.sleep(5000);
	    wrapper.getDriver().switchTo().alert().accept();
		wrapper.waitForBrowserToLoadCompletely();

	}
	
	public synchronized void Delete_AddedInteractionNotes_scida() throws InterruptedException, IOException
	{
		wrapper.click("ModalBox_AddProject");
		isAddprojectPageDisplayed();
		String projectname=add_data_submit_ProjectName_of_project();
		add_select_submit_CompnayCategory_of_project();
		add_select_submit_ProjectManager_DropDown("Admin");
		add_select_submit_Compnany_of_project_SCIDA();
		add_select_submit_PrimaryContact_of_project_SCIDA("Alexander Caro");
		add_select_submit_SecondaryContact_of_project("Abe Mayeri");
		add_select_submit_OtherContact_DropDown();
		add_select_submit_IndustryCluster_of_project();
			add_select_submit_NAICSCode_DropDown_SCIDA();
		add_submit_CommisionerName();
		add_submit_District();
		add_Select_submit_Projectdatetype();
		add_submit_Projectdate();
		add_submit_ProjectdateNotes();
		//add_select_submit_Visibility();
		//add_select_submit_Tags();
		add_select_submit_Projectdate_Notes();
		add_select_submit_phoneType();
		add_select_submit_phoneNumberExtension();
		add_select_submit_EmailType();
		


		///////**********************************Interaction Notes*************

		wrapper.click("ProjectInteractionNotes_Tab_Title");
		Select_ProjectInteraction_NoteType();
		Enter_ProjectInteraction_Keyword();
		//	add_select__Attendee_DropDown();
		Enter_ProjectInteraction_sortDescription();
		ProjectInteraction_uploadDocfile();
		add_select_Company_DropDown("324 South Service Road Assoc. LLC");

		add_Submit_Project_validate(projectname);
/////////******************************************
		wrapper.click("Link_Project_Managment_page");
		wrapper.click("ProjectInteractionNotes_Tab_Title");
		wrapper.click("Project_edit_button");
		wrapper.waitForBrowserToLoadCompletely();
		wrapper.click("Project_interactionNote_delete");
		Thread.sleep(5000);
	    wrapper.getDriver().switchTo().alert().accept();
		wrapper.waitForBrowserToLoadCompletely();

	}
	
	public synchronized void Delete_AddedInteractionNotes_dafc() throws InterruptedException, IOException
	{
		wrapper.click("ModalBox_AddProject");
		isAddprojectPageDisplayed();
		String projectname=add_data_submit_ProjectName_of_project();
		add_select_submit_CompnayCategory_of_project();


		///////**********************************Interaction Notes*************

		wrapper.click("ProjectInteractionNotes_Tab_Title");
		Select_ProjectInteraction_NoteType();
		Enter_ProjectInteraction_Keyword();
		//	add_select__Attendee_DropDown();
		Enter_ProjectInteraction_sortDescription();
		ProjectInteraction_uploadDocfile();
		add_select_Company_DropDown("357 Gift Shop.com");

		add_Submit_Project_validate(projectname);
/////////******************************************
		wrapper.click("Link_Project_Managment_page");
		wrapper.click("ProjectInteractionNotes_Tab_Title");
		wrapper.click("Project_edit_button");
		wrapper.waitForBrowserToLoadCompletely();
		wrapper.click("Project_interactionNote_delete");
		Thread.sleep(5000);
	    wrapper.getDriver().switchTo().alert().accept();
		wrapper.waitForBrowserToLoadCompletely();

	}
	
	public synchronized void Delete_ProjectResources() throws InterruptedException, IOException
	{
		
		wrapper.click("ModalBox_AddProject");
		isAddprojectPageDisplayed();
		String projectname=add_data_submit_ProjectName_of_project();
		add_select_submit_CompnayCategory_of_project();
		add_select_submit_ProjectManager_DropDown();
		wrapper.waitForBrowserToLoadCompletely();
		add_select_submit_Compnany_of_project();
		add_select_submit_PrimaryContact_of_project();
		add_select_submit_SecondaryContact_of_project();
		//	add_select_submit_OtherContact_DropDown();
		add_select_submit_IndustryCluster_of_project();
		// 	add_select_submit_NAICSCode_DropDown();
		//	add_submit_CommisionerName();
		//	add_submit_District();
		add_Select_submit_Projectdatetype();
		add_submit_Projectdate();
		add_submit_ProjectdateNotes();
		//add_select_submit_Visibility();
		add_select_submit_Tags();
		add_select_submit_Projectdate_Notes();
		add_select_submit_phoneType();
		add_select_submit_phoneNumberExtension();
		add_select_submit_EmailType();
		add_submit_Email();
		add_submit_EmailNotes();
		add_Select_submit_AddressType();
		add__submit_StreetAddress();
		add__submit_StreetAddress2();
		add_submit_City();
		add_Select_Country();
		add_Select_State();
		add_Submit_Zip();
		add_Submit_Alias();
		add_Select_URL();
		add_Submit_URLValue();
		add_Submit_URLNote();
		add_Select_RFI();
		//add_Select_RFIResponse();
		//add_Submit_Extrastring();
		//add_Submit_Dummydate();
		add_Submit_RFIResponseNotes();
		add_Submit_RFIDate();
		add_Submit_RFISource();		

		///////*******************Project Resources***********

		wrapper.click("ProjectResources_Title");
		Select_ProjectResource_Type();
		Enter_ProjectResource_DocumentDescription();
		Enter_ProjectResource_Keyword();
		ResourceTabDataEnter_uploadFile();
		add_Submit_Project_validate(projectname);
		validateProjectCreated(projectname);
		wrapper.click("Link_Project_Managment_page");
		wrapper.click("ProjectResources_Title");
		wrapper.click("Project_edit_button");
		wrapper.waitForBrowserToLoadCompletely();
		wrapper.click("Project_Resources_delete_button_new");
		Thread.sleep(3000);
		wrapper.getDriver().switchTo().alert().accept();
		wrapper.waitForBrowserToLoadCompletely();

	}
	
	public synchronized void Delete_ProjectResources_scida() throws InterruptedException, IOException
	{
		
		wrapper.click("ModalBox_AddProject");
		isAddprojectPageDisplayed();
		String projectname=add_data_submit_ProjectName_of_project();
		add_select_submit_CompnayCategory_of_project();
		add_select_submit_Compnany_of_project_SCIDA();
		add_select_submit_PrimaryContact_of_project_SCIDA("Alexander Caro");
		add_select_submit_SecondaryContact_of_project("Abe Mayeri");
		//	add_select_submit_OtherContact_DropDown();
		add_select_submit_IndustryCluster_of_project();
		add_select_submit_NAICSCode_DropDown_SCIDA();
			add_submit_CommisionerName();
		add_submit_District();
		add_Select_submit_Projectdatetype();
		add_submit_Projectdate();
		add_submit_ProjectdateNotes();
		//add_select_submit_Visibility();
		add_select_submit_Tags();
		add_select_submit_Projectdate_Notes();
		add_select_submit_phoneType();
		add_select_submit_phoneNumberExtension();
		add_select_submit_EmailType();
		add_submit_Email();
		add_submit_EmailNotes();
		add_Select_submit_AddressType();
		add__submit_StreetAddress();
		add__submit_StreetAddress2();
		add_submit_City();
		add_Select_Country();
		add_Select_State();
		add_Submit_Zip();
		add_Submit_Alias();
		add_Select_URL();
		add_Submit_URLValue();
		add_Submit_URLNote();
		add_Select_RFI();
		//add_Select_RFIResponse();
		//add_Submit_Extrastring();
		//add_Submit_Dummydate();
		add_Submit_RFIResponseNotes();
		add_Submit_RFIDate();
		add_Submit_RFISource();		

		///////*******************Project Resources***********

		wrapper.click("ProjectResources_Title");
		Select_ProjectResource_Type();
		Enter_ProjectResource_DocumentDescription();
		Enter_ProjectResource_Keyword();
		ResourceTabDataEnter_uploadFile();
		add_Submit_Project_validate(projectname);
		validateProjectCreated(projectname);
		wrapper.click("Link_Project_Managment_page");
		wrapper.click("ProjectResources_Title");
		wrapper.click("Project_edit_button");
		wrapper.waitForBrowserToLoadCompletely();
		wrapper.click("Project_Resources_delete_button_new");
		Thread.sleep(3000);
		 wrapper.getDriver().switchTo().alert().accept();
		wrapper.waitForBrowserToLoadCompletely();

	}
	public synchronized void Delete_ProjectResources_dafc() throws InterruptedException, IOException
	{
		
		wrapper.click("ModalBox_AddProject");
		isAddprojectPageDisplayed();
		String projectname=add_data_submit_ProjectName_of_project();
			

		///////*******************Project Resources***********

		wrapper.click("ProjectResources_Title");
		Select_ProjectResource_Type();
		Enter_ProjectResource_DocumentDescription();
		Enter_ProjectResource_Keyword();
		ResourceTabDataEnter_uploadFile();
		add_Submit_Project_validate(projectname);
		validateProjectCreated(projectname);
		wrapper.click("Link_Project_Managment_page");
		wrapper.click("ProjectResources_Title");
		wrapper.click("Project_edit_button");
		wrapper.waitForBrowserToLoadCompletely();
		wrapper.click("Project_Resources_delete_button_new");
		Thread.sleep(3000);
		 wrapper.getDriver().switchTo().alert().accept();
		wrapper.waitForBrowserToLoadCompletely();

	}
	
	
	
	
	public synchronized void Editproject_Generalinfo() throws InterruptedException, IOException
	{
		wrapper.click("Link_Project_Managment_page");
		//isAddprojectPageDisplayed();
		wrapper.click("Project_edit_button");
		wrapper.zoomInZoomOut();
		Thread.sleep(3000);
		String projectname=add_data_submit_ProjectName_of_project();
		add_select_submit_CompnayCategory_of_project();
		add_select_submit_ProjectManager_DropDown();
		add_select_submit_Compnany_of_project();
		add_select_submit_PrimaryContact_of_project();
		add_select_submit_SecondaryContact_of_project();
		//	add_select_submit_OtherContact_DropDown();
		add_select_submit_IndustryCluster_of_project();
		// 	add_select_submit_NAICSCode_DropDown();
		//	add_submit_CommisionerName();
		//	add_submit_District();
		add_Select_submit_Projectdatetype();
		add_submit_Projectdate();
		add_submit_ProjectdateNotes();
		//add_select_edit_Visibility();
		add_select_submit_Tags();
		add_select_submit_Projectdate_Notes();
		add_select_submit_phoneType();
		add_select_submit_phoneNumberExtension();
		add_select_submit_EmailType();
		add_submit_Email();
		add_submit_EmailNotes();
		add_Select_submit_AddressType();
		add__submit_StreetAddress();
		add__submit_StreetAddress2();
		add_submit_City();
		add_Select_Country();
		add_Select_State();
		add_Submit_Zip();
		add_Submit_Alias();
		add_Select_URL();
		add_Submit_URLValue();
		add_Submit_URLNote();
		add_Select_RFI();
		//add_Select_RFIResponse();
		//add_Submit_Extrastring();
		//add_Submit_Dummydate();
		add_Submit_RFIResponseNotes();
		add_Submit_RFIDate();
		add_Submit_RFISource();
		add_Submit_Project_validate(projectname);
		Thread.sleep(1000);
		validateProjectCreated(projectname);
	}
	
	public synchronized void Editproject_Generalinfo_scida() throws InterruptedException, IOException
	{
		wrapper.click("Link_Project_Managment_page");
		//isAddprojectPageDisplayed();
		wrapper.click("Project_edit_button");
		wrapper.zoomInZoomOut();
		Thread.sleep(3000);
		String projectname=add_data_submit_ProjectName_of_project();
		add_select_submit_CompnayCategory_of_project();
		add_select_submit_ProjectManager_DropDown("Admin");
		add_select_submit_Compnany_of_project_SCIDA();
		add_select_submit_PrimaryContact_of_project_SCIDA("Alexander Caro");
		add_select_submit_SecondaryContact_of_project("Abe Mayeri");
		//	add_select_submit_OtherContact_DropDown();
		add_select_submit_IndustryCluster_of_project();
		// 	add_select_submit_NAICSCode_DropDown();
		//	add_submit_CommisionerName();
		//	add_submit_District();
		add_Select_submit_Projectdatetype();
		add_submit_Projectdate();
		add_submit_ProjectdateNotes();
		//add_select_edit_Visibility();
		add_select_submit_Tags();
		add_select_submit_Projectdate_Notes();
		add_select_submit_phoneType();
		add_select_submit_phoneNumberExtension();
		add_select_submit_EmailType();
		add_submit_Email();
		add_submit_EmailNotes();
		add_Select_submit_AddressType();
		add__submit_StreetAddress();
		add__submit_StreetAddress2();
		add_submit_City();
		add_Select_Country();
		add_Select_State();
		add_Submit_Zip();
		add_Submit_Alias();
		add_Select_URL();
		add_Submit_URLValue();
		add_Submit_URLNote();
		add_Select_RFI();
		//add_Select_RFIResponse();
		//add_Submit_Extrastring();
		//add_Submit_Dummydate();
		add_Submit_RFIResponseNotes();
		add_Submit_RFIDate();
		add_Submit_RFISource();
		add_Submit_Project_validate(projectname);
		validateProjectCreated(projectname);
	}
	
	public synchronized void Editproject_Generalinfo_dafc() throws InterruptedException, IOException
	{
		wrapper.click("Link_Project_Managment_page");
		//isAddprojectPageDisplayed();
		wrapper.click("Project_edit_button");
		wrapper.zoomInZoomOut();
		Thread.sleep(3000);
		String projectname=add_data_submit_ProjectName_of_project();
		add_select_submit_CompnayCategory_of_project();
		//add_select_submit_ProjectManager_DropDown("Administrator ");
		add_select_submit_Compnany_of_project("357 Gift Shop.com");
		//add_data_submit_principals_of_project_scida();
		add_select_submit_PrimaryContact_of_project_SCIDA("Aadu Allpere");
		add_select_submit_SecondaryContact_of_project("Adam Harbin");
		add_select_submit_OtherContact_DropDown();
		//add_data_submit_leadsource_of_project_scida();
		add_select_submit_IndustryCluster_of_project();
			add_select_submit_NAICSCode_DropDown();
		add_submit_CommisionerName();
		add_submit_District();
		//add_Select_submit_Projectdatetype();
		//add_submit_Projectdate();
		//add_submit_ProjectdateNotes();
		//add_select_submit_Visibility();
		add_select_submit_Tags();
		//add_select_submit_Projectdate_Notes();
		add_select_submit_phoneType();
		add_select_submit_phoneNumberExtension();
		add_select_submit_EmailType();
		add_submit_Email();
		add_submit_EmailNotes();
		add_Select_submit_AddressType();
		add__submit_StreetAddress();
		add__submit_StreetAddress2();
		add_submit_City();
		add_Select_Country();
		add_Select_State();
		add_Submit_Zip();
		add_Submit_Alias();
		add_Submit_taxmap();
		add_Submit_schooldistric();
		add_Submit_acreage();
		add_Select_URL();
		add_Submit_URLValue();
		add_Submit_URLNote();
		add_Select_RFI();
		//add_Select_RFIResponse();
		//add_Submit_Extrastring();
		//add_Submit_Dummydate();
		add_Submit_RFIResponseNotes();
		add_Submit_RFIDate();
		add_Submit_RFISource();
		add_Submit_Project_validate(projectname);
		validateProjectCreated(projectname);
	}
	
	public synchronized void Editproject_ProjectData() throws InterruptedException, IOException
	{
		wrapper.click("Link_Project_Managment_page");
		//isAddprojectPageDisplayed();
		wrapper.click("Project_edit_button");
		wrapper.zoomInZoomOut();
		Thread.sleep(3000);
		add_data_submit_ProjectName_of_project();
		Open_Projectdata_Tab();
		String Desc=edit_Projectdata_Description();
		add_select_submit_StagesType_projectData();
		add_Submit_Stages_Date_projectdata();
		add_Submit_Stages_Notes_projectdata();
		add_Select_Construction_start_date();
		add_Select_Construction_End_date();
		add_Submit_requirmnet_Description();
		add_Submit_SpaceRequirmnet_ExistingBuilding_value();
		add_Submit_SpaceRequirmnet_ExistingBuilding_Notes();
		add_Submit_edited_projectvalues(Desc);
		//validateProjectdataedited();
		
	}
	
	public synchronized void Editproject_ProjectData_scida() throws InterruptedException, IOException
	{
		wrapper.click("Link_Project_Managment_page");
		//isAddprojectPageDisplayed();
		wrapper.click("Project_edit_button");
		wrapper.zoomInZoomOut();
		Thread.sleep(3000);
		add_data_submit_ProjectName_of_project();
		Open_Projectdata_Tab();
		String Desc=edit_Projectdata_Description();
		add_select_submit_StagesType_projectData();
		add_Submit_Stages_Date_projectdata();
		add_Submit_Stages_Notes_projectdata();
		add_Select_Construction_start_date();
		add_Select_Construction_End_date();
		add_Submit_requirmnet_Description();
		add_Submit_SpaceRequirmnet_ExistingBuilding_value();
		add_Submit_SpaceRequirmnet_ExistingBuilding_Notes_scida();
		add_Submit_edited_projectvalues(Desc);
		//validateProjectdataedited();
		
	}
	
	public static String insertString( 
	        String originalString, 
	        char stringToBeInserted, 
	        int index) 
	    { 
	  
	        // Create a new string 
	        String newString = new String(); 
	  
	        for (int i = 0; i < originalString.length(); i++) { 
	  
	            // Insert the original string character 
	            // into the new string 
	            newString += originalString.charAt(i); 
	  
	            if (i == index) { 
	  
	                // Insert the string to be inserted 
	                // into the new string 
	                newString += stringToBeInserted; 
	            } 
	        } 
	  
	        // return the modified String 
	        return newString; 
	    } 
	
	
	
	
	public synchronized void Editproject_ProjectBenifits() throws InterruptedException, IOException
	{
		
		wrapper.click("ModalBox_AddProject");
		isAddprojectPageDisplayed();
		String projectname=add_data_submit_ProjectName_of_project();
		add_select_submit_CompnayCategory_of_project();
		add_select_submit_ProjectManager_DropDown();
		add_select_submit_Compnany_of_project();
		add_select_submit_PrimaryContact_of_project();
		add_select_submit_SecondaryContact_of_project();
		//	add_select_submit_OtherContact_DropDown();
		add_select_submit_IndustryCluster_of_project();
		// 	add_select_submit_NAICSCode_DropDown();
		//	add_submit_CommisionerName();
		//	add_submit_District();
		add_Select_submit_Projectdatetype();
		add_submit_Projectdate();
		add_submit_ProjectdateNotes();
		//add_select_submit_Visibility();
		add_select_submit_Tags();
		add_select_submit_Projectdate_Notes();
		add_select_submit_phoneType();
		add_select_submit_phoneNumberExtension();
		add_select_submit_EmailType();
		add_submit_Email();
		add_submit_EmailNotes();
		add_Select_submit_AddressType();
		add__submit_StreetAddress();
		add__submit_StreetAddress2();
		add_submit_City();
		add_Select_Country();
		add_Select_State();
		add_Submit_Zip();
		add_Submit_Alias();
		add_Select_URL();
		add_Submit_URLValue();
		add_Submit_URLNote();
		add_Select_RFI();
		//add_Select_RFIResponse();
		//add_Submit_Extrastring();
		//add_Submit_Dummydate();
		add_Submit_RFIResponseNotes();
		add_Submit_RFIDate();
		add_Submit_RFISource();




		/////Project Benefits tab*****************************

		open_ProjectBenifits_Tab();
		//Enter_ProjectBenifits_InvestmnetNotes();
		//Enter_ProjectBenifits_IncentivesNotes();
		//Enter_ProjectBenifits_InVestmentInhibitors();
		//Enter_ProjectBenifits_InvestmentRational();
		Enter_ProjectBenifits_Investment_realstate_value();
		Enter_ProjectBenifits_Investment_Inventory();
		Enter_ProjectBenifits_Investment_MachineandEquipment();
		Enter_ProjectBenifits_Investment_FurnitureFixture();
		Add_investmnet();
		Enter_ProjectBenifits_Investment_Amount();
		//Enter_ProjectBenifits_Incentive_Amount();
		Enter_ProjectBenifits_EmploymnetFullTimeNumber();
		Enter_ProjectBenifits_EmploymnetFullTimesalary();
		Enter_ProjectBenifits_EmploymnetManagmnetNumber();
		Enter_ProjectBenifits_EmploymnetmangamentSalary();
		Enter_ProjectBenifits_EmploymnetPartTimeNumber();
		Enter_ProjectBenifits_EmploymnetPartTimeSalary();
		Enter_ProjectBenifits_EmploymnetContractNumber();
		Enter_ProjectBenifits_EmploymnetContractSalary();
		add_employmnet_details();
		Enter_ProjectBenifits_NumberConstructionJobs();
		Enter_ProjectBenifits_WorkerWages();
		Enter_ProjectBenifits_ConstructionJobs();
		Enter_ProjectBenifits_TotalJobs();


	

		///**************************Task*******************
		wrapper.click("ProjectTask_Tab_Title");
		Enter_ProjectTask_TaskName();
		add_Select_TaskStart_date();
		add_Select_TaskDue_date();
		//	add_select_RecordStatus_DropDown();
		Enter_ProjectTask_phase();
		add_Submit_Project_validate(projectname);
		validateProjectCreated(projectname);
		
		////***************edit benifits
		wrapper.click("Link_Project_Managment_page");
		open_ProjectBenifits_Tab();
		wrapper.click("Project_edit_button");
		wrapper.click("Project_benifits_edit_value");
		wrapper.zoomInZoomOut();
		Thread.sleep(3000);
		wrapper.click("ProjectBenifits_Investmnet_Realstate_Field_TextBox");
		Enter_ProjectBenifits_Investment_realstate_value();
		wrapper.click("ProjectBenifits_Investmnet_Inventory_Field_TextBox");
		Enter_ProjectBenifits_Investment_Inventory();
		wrapper.click("ProjectBenifits_Investmnet_MachineandEquipment_Field_TextBox");
		Enter_ProjectBenifits_Investment_MachineandEquipment();
		Enter_ProjectBenifits_Investment_FurnitureFixture();
		Thread.sleep(1000);
		update_investmnet();
		wrapper.click("ProjectGeneralInfoPage_Submit_Button");
		add_Submit_edited_projectBenifits();
		//validateProjectdataedited();
		
	}
	
	public synchronized void Editproject_ProjectBenifits_scida() throws InterruptedException, IOException
	{
		
		wrapper.click("ModalBox_AddProject");
		isAddprojectPageDisplayed();
		String projectname=add_data_submit_ProjectName_of_project();
		add_select_submit_CompnayCategory_of_project();
		add_select_submit_ProjectManager_DropDown("Administrator Admin");
		add_select_submit_Compnany_of_project("357 Gift Shop.com");
		add_select_submit_PrimaryContact_of_project_SCIDA("Aadu Allpere");
		add_select_submit_SecondaryContact_of_project("Adam Harbin");
		//	add_select_submit_OtherContact_DropDown();
		add_select_submit_IndustryCluster_of_project();
		// 	add_select_submit_NAICSCode_DropDown();
		add_submit_CommisionerName();
		add_submit_District();




		/////Project Benefits tab*****************************

		open_ProjectBenifits_Tab();
		//Enter_ProjectBenifits_InvestmnetNotes();
		//Enter_ProjectBenifits_IncentivesNotes();
		//Enter_ProjectBenifits_InVestmentInhibitors();
		//Enter_ProjectBenifits_InvestmentRational();
		Enter_ProjectBenifits_Investment_realstate_value();
		Enter_ProjectBenifits_Investment_Inventory();
		Enter_ProjectBenifits_Investment_MachineandEquipment();
		Enter_ProjectBenifits_Investment_FurnitureFixture();
		Add_investmnet();
		//Enter_ProjectBenifits_Investment_Amount();
		//Enter_ProjectBenifits_Incentive_Amount();
		Enter_ProjectBenifits_EmploymnetFullTimeNumber();
		Enter_ProjectBenifits_EmploymnetFullTimesalary();
		Enter_ProjectBenifits_EmploymnetManagmnetNumber();
		Enter_ProjectBenifits_EmploymnetmangamentSalary();
		Enter_ProjectBenifits_EmploymnetPartTimeNumber();
		Enter_ProjectBenifits_EmploymnetPartTimeSalary();
		Enter_ProjectBenifits_EmploymnetContractNumber();
		Enter_ProjectBenifits_EmploymnetContractSalary();
		add_employmnet_details();
		Enter_ProjectBenifits_NumberConstructionJobs();
		Enter_ProjectBenifits_WorkerWages();
		//Enter_ProjectBenifits_ConstructionJobs();
		//Enter_ProjectBenifits_TotalJobs();


	

		///**************************Task*******************
		wrapper.click("ProjectTask_Tab_Title");
		Enter_ProjectTask_TaskName();
		add_Select_TaskStart_date();
		add_Select_TaskDue_date();
		//	add_select_RecordStatus_DropDown();
		Enter_ProjectTask_phase();
		add_Submit_Project_validate(projectname);
		validateProjectCreated(projectname);
		
		////***************edit benifits
		wrapper.click("Link_Project_Managment_page");
		open_ProjectBenifits_Tab();
		wrapper.click("Project_edit_button");
		wrapper.click("Project_benifits_edit_value");
		wrapper.zoomInZoomOut();
		Thread.sleep(3000);
		wrapper.click("ProjectBenifits_Investmnet_Realstate_Field_TextBox");
		Enter_ProjectBenifits_Investment_realstate_value();
		wrapper.click("ProjectBenifits_Investmnet_Inventory_Field_TextBox");
		Enter_ProjectBenifits_Investment_Inventory();
		wrapper.click("ProjectBenifits_Investmnet_MachineandEquipment_Field_TextBox");
		Enter_ProjectBenifits_Investment_MachineandEquipment();
		Enter_ProjectBenifits_Investment_FurnitureFixture();
		Thread.sleep(1000);
		update_investmnet();
		wrapper.click("ProjectGeneralInfoPage_Submit_Button");
		add_Submit_edited_projectBenifits();
		//validateProjectdataedited();
		
	}
	
	
	public synchronized void Addtotal_ProjectBenifits_investments() throws InterruptedException, IOException
	{
		wrapper.click("ModalBox_AddProject");
		isAddprojectPageDisplayed();
		String projectname=add_data_submit_ProjectName_of_project();
		add_select_submit_CompnayCategory_of_project();
		add_select_submit_ProjectManager_DropDown();
		add_select_submit_Compnany_of_project();
		add_select_submit_PrimaryContact_of_project();
		add_select_submit_SecondaryContact_of_project();
		//	add_select_submit_OtherContact_DropDown();
		add_select_submit_IndustryCluster_of_project();
		// 	add_select_submit_NAICSCode_DropDown();
		//	add_submit_CommisionerName();
		//	add_submit_District();
		add_Select_submit_Projectdatetype();
		add_submit_Projectdate();
		add_submit_ProjectdateNotes();
		//add_select_submit_Visibility();
		add_select_submit_Tags();
		add_select_submit_Projectdate_Notes();
		add_select_submit_phoneType();
		add_select_submit_phoneNumberExtension();
		add_select_submit_EmailType();
		add_submit_Email();
		add_submit_EmailNotes();
		add_Select_submit_AddressType();
		add__submit_StreetAddress();
		add__submit_StreetAddress2();
		add_submit_City();
		add_Select_Country();
		add_Select_State();
		add_Submit_Zip();
		add_Submit_Alias();
		add_Select_URL();
		add_Submit_URLValue();
		add_Submit_URLNote();
		add_Select_RFI();
		//add_Select_RFIResponse();
		//add_Submit_Extrastring();
		//add_Submit_Dummydate();
		add_Submit_RFIResponseNotes();
		add_Submit_RFIDate();
		add_Submit_RFISource();


		///Project data tab********************

		Open_Projectdata_Tab();
		add_submit_Projectdata_Description();
		add_select_submit_StagesType_projectData();
		add_Submit_Stages_Date_projectdata();
		add_Submit_Stages_Notes_projectdata();
		add_Select_Construction_start_date();
		add_Select_Construction_End_date();
		add_Submit_requirmnet_Description();
		add_Submit_SpaceRequirmnet_ExistingBuilding_value();
		add_Submit_SpaceRequirmnet_ExistingBuilding_Notes();



		/////Project Benefits tab*****************************

		open_ProjectBenifits_Tab();
		//Enter_ProjectBenifits_InvestmnetNotes();
		//Enter_ProjectBenifits_IncentivesNotes();
		//Enter_ProjectBenifits_InVestmentInhibitors();
		//Enter_ProjectBenifits_InvestmentRational();
		Enter_ProjectBenifits_Investment_realstate_value();
		Enter_ProjectBenifits_Investment_Inventory();
		Enter_ProjectBenifits_Investment_MachineandEquipment();
		Enter_ProjectBenifits_Investment_FurnitureFixture();
		Add_investmnet();
		Enter_ProjectBenifits_Investment_Amount();
		//Enter_ProjectBenifits_Incentive_Amount();
		Enter_ProjectBenifits_EmploymnetFullTimeNumber();
		Enter_ProjectBenifits_EmploymnetFullTimesalary();
		Enter_ProjectBenifits_EmploymnetManagmnetNumber();
		Enter_ProjectBenifits_EmploymnetmangamentSalary();
		Enter_ProjectBenifits_EmploymnetPartTimeNumber();
		Enter_ProjectBenifits_EmploymnetPartTimeSalary();
		Enter_ProjectBenifits_EmploymnetContractNumber();
		Enter_ProjectBenifits_EmploymnetContractSalary();
		add_employmnet_details();
		Enter_ProjectBenifits_NumberConstructionJobs();
		Enter_ProjectBenifits_WorkerWages();
		Enter_ProjectBenifits_ConstructionJobs();
		Enter_ProjectBenifits_TotalJobs();
		
		

		add_Submit_Project_validate(projectname);
		Thread.sleep(5000);
		wrapper.waitForBrowserToLoadCompletely();
		Thread.sleep(6000);
		validateProjectCreated(projectname);
		
		
		wrapper.click("Link_Project_Managment_page");
		open_ProjectBenifits_Tab();
		wrapper.click("Project_edit_button");
		wrapper.click("Project_benifits_edit_value");
		wrapper.zoomInZoomOut();
		Thread.sleep(3000);
		wrapper.click("ProjectBenifits_Investmnet_Realstate_Field_TextBox");
		Enter_ProjectBenifits_Investment_realstate_value();
		wrapper.click("ProjectBenifits_Investmnet_Realstate_Field_TextBox");
		wrapper.click("ProjectBenifits_Investmnet_Inventory_Field_TextBox");
		Enter_ProjectBenifits_Investment_Inventory();
		wrapper.click("ProjectBenifits_Investmnet_Inventory_Field_TextBox");
		wrapper.click("ProjectBenifits_Investmnet_MachineandEquipment_Field_TextBox");
		Enter_ProjectBenifits_Investment_MachineandEquipment();
		wrapper.click("ProjectBenifits_Investmnet_MachineandEquipment_Field_TextBox");
		Enter_ProjectBenifits_Investment_FurnitureFixture();
		Thread.sleep(1000);
		update_investmnet();
		wrapper.click("ProjectGeneralInfoPage_Submit_Button");
		add_total_investmnet_projectBenifits();
		//validateProjectdataedited();
		
	}
	
	public synchronized void Addtotal_ProjectBenifits_investments_scida() throws InterruptedException, IOException
	{
		wrapper.click("ModalBox_AddProject");
		isAddprojectPageDisplayed();
		String projectname=add_data_submit_ProjectName_of_project();
		add_select_submit_CompnayCategory_of_project();
		add_select_submit_ProjectManager_DropDown();
		add_select_submit_Compnany_of_project_SCIDA();
		add_data_submit_principals_of_project_scida();
		add_select_submit_PrimaryContact_of_project_SCIDA("Alexander Caro");
		add_select_submit_SecondaryContact_of_project("Abe Mayeri");
		add_select_submit_OtherContact_DropDown();
		add_data_submit_leadsource_of_project_scida();
		add_select_submit_IndustryCluster_of_project();
	   // add_select_submit_NAICSCode_DropDown();
		add_submit_CommisionerName();
		add_submit_District();
		add_Select_submit_Projectdatetype();
		add_submit_Projectdate();
		add_submit_ProjectdateNotes();
		//add_select_submit_Visibility();
		//add_select_submit_Tags();
		add_select_submit_Projectdate_Notes();
		add_select_submit_phoneType();
		add_select_submit_phoneNumberExtension();
		add_select_submit_EmailType();
		add_submit_Email();
		add_submit_EmailNotes();
		add_Select_submit_AddressType();
		add__submit_StreetAddress();
		add__submit_StreetAddress2();
		add_submit_City();
		add_Select_Country();
		add_Select_State();
		add_Submit_Zip();
		add_Submit_Alias();
		add_Select_URL();
		add_Submit_URLValue();
		add_Submit_URLNote();
		add_Select_RFI();
		//add_Select_RFIResponse();
		//add_Submit_Extrastring();
		//add_Submit_Dummydate();
		add_Submit_RFIResponseNotes();
		add_Submit_RFIDate();
		add_Submit_RFISource();


		///Project data tab********************

		Open_Projectdata_Tab();
		add_submit_Projectdata_Description();
		add_submit_Projectdata_process_scida();
		add_select_submit_StagesType_projectData();
		add_submit_Projectbenifits_IssueAmountRequested_scida();
		add_submit_Projectbenifits_fbr_scida();
		add_submit_Projectbenifits_closedbond_scida();
		add_Submit_Stages_Date_projectdata();
		add_Submit_Stages_Notes_projectdata();
		add_Select_Construction_start_date();
		add_Select_Construction_End_date();
		add_Submit_requirmnet_Description();
		add_Submit_SpaceRequirmnet_ExistingBuilding_value();
		add_Submit_SpaceRequirmnet_ExistingBuilding_Notes_scida();



		/////Project Benefits tab*****************************

		open_ProjectBenifits_Tab();
	    Enter_ProjectBenifits_InvestmnetNotes();
		Enter_ProjectBenifits_IncentivesNotes();
		Enter_ProjectBenifits_InVestmentInhibitors();
		Enter_ProjectBenifits_InvestmentRational();
		Enter_ProjectBenifits_Investment_realstate_value();
		Enter_ProjectBenifits_Investment_Inventory();
		Enter_ProjectBenifits_Investment_MachineandEquipment();
		Enter_ProjectBenifits_Investment_FurnitureFixture();
		Add_investmnet();
		//Enter_ProjectBenifits_Investment_Amount();
		//Enter_ProjectBenifits_Incentive_Amount();
		Enter_ProjectBenifits_EmploymnetFullTimeNumber();
		Enter_ProjectBenifits_EmploymnetFullTimesalary();
		Enter_ProjectBenifits_EmploymnetManagmnetNumber();
		Enter_ProjectBenifits_EmploymnetmangamentSalary();
		Enter_ProjectBenifits_EmploymnetPartTimeNumber();
		Enter_ProjectBenifits_EmploymnetPartTimeSalary();
		Enter_ProjectBenifits_EmploymnetContractNumber();
		Enter_ProjectBenifits_EmploymnetContractSalary();
		add_employmnet_details();
		Enter_ProjectBenifits_NumberConstructionJobs();
		Enter_ProjectBenifits_WorkerWages();
		//Enter_ProjectBenifits_ConstructionJobs();
		//Enter_ProjectBenifits_TotalJobs();


		///////*******************Project Resources***********

		wrapper.click("ProjectResources_Title");
		Select_ProjectResource_Type();
		Enter_ProjectResource_DocumentDescription();
		Enter_ProjectResource_Keyword();
		ResourceTabDataEnter_uploadFile();

		///////**********************************Interaction Notes*************

		wrapper.click("ProjectInteractionNotes_Tab_Title");
		Select_ProjectInteraction_NoteType();
		Enter_ProjectInteraction_Keyword();
		//	add_select__Attendee_DropDown();
		Enter_ProjectInteraction_sortDescription();
		ProjectInteraction_uploadDocfile();
		add_select_Company_DropDown("201 W. Broadway PJ, LLC");

		///**************************Task*******************
		wrapper.click("ProjectTask_Tab_Title");
		Enter_ProjectTask_TaskName();
		add_Select_TaskStart_date();
		add_Select_TaskDue_date();
		//	add_select_RecordStatus_DropDown();
		Enter_ProjectTask_phase();
		add_Submit_Project_validate(projectname);
		validateProjectCreated(projectname);
		
		
		wrapper.click("Link_Project_Managment_page");
		open_ProjectBenifits_Tab();
		wrapper.click("Project_edit_button");
		wrapper.click("Project_interactionnotes_edit_Button_scida");
		wrapper.zoomInZoomOut();
		Thread.sleep(3000);
		wrapper.click("ProjectBenifits_Investmnet_Realstate_Field_TextBox");
		Enter_ProjectBenifits_Investment_realstate_value();
		wrapper.click("ProjectBenifits_Investmnet_Realstate_Field_TextBox");
		wrapper.click("ProjectBenifits_Investmnet_Inventory_Field_TextBox");
		Enter_ProjectBenifits_Investment_Inventory();
		wrapper.click("ProjectBenifits_Investmnet_Inventory_Field_TextBox");
		wrapper.click("ProjectBenifits_Investmnet_MachineandEquipment_Field_TextBox");
		Enter_ProjectBenifits_Investment_MachineandEquipment();
		wrapper.click("ProjectBenifits_Investmnet_MachineandEquipment_Field_TextBox");
		Enter_ProjectBenifits_Investment_FurnitureFixture();
		Thread.sleep(1000);
		update_investmnet();
		wrapper.click("ProjectGeneralInfoPage_Submit_Button");
		add_total_investmnet_projectBenifits();
		//validateProjectdataedited();
		
	}
	
	public synchronized void Addtotal_ProjectBenifits_investments_dafc() throws InterruptedException, IOException
	{
		wrapper.click("ModalBox_AddProject");
		isAddprojectPageDisplayed();
		String projectname=add_data_submit_ProjectName_of_project();
		

		



		/////Project Benefits tab*****************************

		open_ProjectBenifits_Tab();
		//Enter_ProjectBenifits_InvestmnetNotes();
		//Enter_ProjectBenifits_IncentivesNotes();
		//Enter_ProjectBenifits_InVestmentInhibitors();
		//Enter_ProjectBenifits_InvestmentRational();
		Enter_ProjectBenifits_Investment_realstate_value();
		Enter_ProjectBenifits_Investment_Inventory();
		Enter_ProjectBenifits_Investment_MachineandEquipment();
		Enter_ProjectBenifits_Investment_FurnitureFixture();
		Add_investmnet();
		//Enter_ProjectBenifits_Investment_Amount();
		//Enter_ProjectBenifits_Incentive_Amount();
		Enter_ProjectBenifits_EmploymnetFullTimeNumber();
		Enter_ProjectBenifits_EmploymnetFullTimesalary();
		Enter_ProjectBenifits_EmploymnetManagmnetNumber();
		Enter_ProjectBenifits_EmploymnetmangamentSalary();
		Enter_ProjectBenifits_EmploymnetPartTimeNumber();
		Enter_ProjectBenifits_EmploymnetPartTimeSalary();
		Enter_ProjectBenifits_EmploymnetContractNumber();
		Enter_ProjectBenifits_EmploymnetContractSalary();
		add_employmnet_details();
		Enter_ProjectBenifits_NumberConstructionJobs();
		Enter_ProjectBenifits_WorkerWages();
		Enter_ProjectBenifits_ConstructionJobs();
		//Enter_ProjectBenifits_TotalJobs();

		add_Submit_Project_validate(projectname);
		validateProjectCreated(projectname);
		
		
		wrapper.click("Link_Project_Managment_page");
		open_ProjectBenifits_Tab();
		wrapper.click("Project_edit_button");
		wrapper.click("Project_benifits_edit_value");
		wrapper.zoomInZoomOut();
		Thread.sleep(3000);
		wrapper.click("ProjectBenifits_Investmnet_Realstate_Field_TextBox");
		Enter_ProjectBenifits_Investment_realstate_value();
		wrapper.click("ProjectBenifits_Investmnet_Realstate_Field_TextBox");
		wrapper.click("ProjectBenifits_Investmnet_Inventory_Field_TextBox");
		Enter_ProjectBenifits_Investment_Inventory();
		wrapper.click("ProjectBenifits_Investmnet_Inventory_Field_TextBox");
		wrapper.click("ProjectBenifits_Investmnet_MachineandEquipment_Field_TextBox");
		Enter_ProjectBenifits_Investment_MachineandEquipment();
		wrapper.click("ProjectBenifits_Investmnet_MachineandEquipment_Field_TextBox");
		Enter_ProjectBenifits_Investment_FurnitureFixture();
		Thread.sleep(1000);
		update_investmnet();
		wrapper.click("ProjectGeneralInfoPage_Submit_Button");
		add_total_investmnet_projectBenifits();
		//validateProjectdataedited();
		
	}
	
	public synchronized void Validate_ProjectBenifits_Employmnetdetails() throws InterruptedException, IOException
	{
		wrapper.click("Link_Project_Managment_page");
		open_ProjectBenifits_Tab();
		wrapper.click("Project_edit_button");
		wrapper.waitForBrowserToLoadCompletely();
		Enter_ProjectBenifits_NumberConstructionJobs();
		Enter_ProjectBenifits_WorkerWages();
		Enter_ProjectBenifits_ConstructionJobs();
		Enter_ProjectBenifits_TotalJobs();
		wrapper.click("ProjectGeneralInfoPage_Submit_Button");
		Employee_details_validations_projectBenifits();
		
		
	}
	
	public synchronized void Validate_ProjectBenifits_Employmentinformation() throws InterruptedException, IOException
	{

		wrapper.click("ModalBox_AddProject");
		isAddprojectPageDisplayed();
		String projectname=add_data_submit_ProjectName_of_project();
		add_select_submit_CompnayCategory_of_project();
		//add_select_submit_ProjectManager_DropDown("Administrator ");
		add_select_submit_Compnany_of_project("357 Gift Shop.com");
		//add_data_submit_principals_of_project_scida();
		wrapper.waitForBrowserToLoadCompletely();
		add_select_submit_PrimaryContact_of_project_SCIDA("Aadu Allpere");
		Thread.sleep(5000);
		add_select_submit_SecondaryContact_of_project("Adam Harbin");
		add_select_submit_OtherContact_DropDown();
		//add_data_submit_leadsource_of_project_scida();
		add_select_submit_IndustryCluster_of_project();
		add_select_submit_NAICSCode_DropDown();
//		add_submit_CommisionerName();
//		add_submit_District();
		//add_Select_submit_Projectdatetype();
		//add_submit_Projectdate();
		//add_submit_ProjectdateNotes();
		//add_select_submit_Visibility();
		add_select_submit_Tags();
		//add_select_submit_Projectdate_Notes();
//		add_select_submit_phoneType();
//		add_select_submit_phoneNumberExtension();
//		add_select_submit_EmailType();
//		add_submit_Email();
//		add_submit_EmailNotes();
//		add_Select_submit_AddressType();
//		add__submit_StreetAddress();
//		add__submit_StreetAddress2();
//		add_submit_City();
//		add_Select_Country();
//		add_Select_State();
//		add_Submit_Zip();
//		add_Submit_Alias();
//		add_Submit_taxmap();
//		add_Submit_schooldistric();
//		add_Submit_acreage();
//		add_Select_URL();
//		add_Submit_URLValue();
//		add_Submit_URLNote();
//		add_Select_RFI();
		//add_Select_RFIResponse();
		//add_Submit_Extrastring();
		//add_Submit_Dummydate();
		add_Submit_RFIResponseNotes();
		add_Submit_RFIDate();
		add_Submit_RFISource();


		///Project data tab********************

//		Open_Projectdata_Tab();
//		add_submit_Projectdata_Description();
//		add_submit_Projectdata_process_scida();
//		add_select_submit_StagesType_projectData();
//		add_submit_Projectbenifits_IssueAmountRequested_scida();
//		add_submit_Projectbenifits_fbr_scida();
//		add_submit_Projectbenifits_closedbond_scida();
//		add_Submit_Stages_Date_projectdata();
//		add_Submit_Stages_Notes_projectdata();
//		add_Select_Construction_start_date();
//		add_Select_Construction_End_date();
//		add_Submit_requirmnet_Description();
//		add_Submit_SpaceRequirmnet_ExistingBuilding_value();
//		add_Submit_SpaceRequirmnet_ExistingBuilding_Notes_scida();



		/////Project Benefits tab*****************************

		open_ProjectBenifits_Tab();
		//Enter_ProjectBenifits_InvestmnetNotes();
				//Enter_ProjectBenifits_IncentivesNotes();
				//Enter_ProjectBenifits_InVestmentInhibitors();
				//Enter_ProjectBenifits_InvestmentRational();
				Enter_ProjectBenifits_Investment_realstate_value();
				Enter_ProjectBenifits_Investment_Inventory();
				Enter_ProjectBenifits_Investment_MachineandEquipment();
				Enter_ProjectBenifits_Investment_FurnitureFixture();
				Add_investmnet();
				//Enter_ProjectBenifits_Investment_Amount();
				//Enter_ProjectBenifits_Incentive_Amount();
				Enter_ProjectBenifits_EmploymnetFullTimeNumber();
				Enter_ProjectBenifits_EmploymnetFullTimesalary();
				Enter_ProjectBenifits_EmploymnetManagmnetNumber();
				Enter_ProjectBenifits_EmploymnetmangamentSalary();
				Enter_ProjectBenifits_EmploymnetPartTimeNumber();
				Enter_ProjectBenifits_EmploymnetPartTimeSalary();
				Enter_ProjectBenifits_EmploymnetContractNumber();
				Enter_ProjectBenifits_EmploymnetContractSalary();
				add_employmnet_details();
				Enter_ProjectBenifits_NumberConstructionJobs();
				Enter_ProjectBenifits_WorkerWages();
				Enter_ProjectBenifits_ConstructionJobs();
				Enter_ProjectBenifits_TotalJobs();


		///////*******************Project Resources***********

//		wrapper.click("ProjectResources_Title");
//		Select_ProjectResource_Type();
//		Enter_ProjectResource_DocumentDescription();
//		Enter_ProjectResource_Keyword();
//		ResourceTabDataEnter_uploadFile();

		///////**********************************Interaction Notes*************

//		wrapper.click("ProjectInteractionNotes_Tab_Title");
//		Select_ProjectInteraction_NoteType();
//		Enter_ProjectInteraction_Keyword();
//		//	add_select__Attendee_DropDown();
//		Enter_ProjectInteraction_sortDescription();
//		ProjectInteraction_uploadDocfile();
//		add_select_Company_DropDown("357 Gift Shop.com");

		///**************************Task*******************
//		wrapper.click("ProjectTask_Tab_Title");
//		Enter_ProjectTask_TaskName();
//		add_Select_TaskStart_date();
//		add_Select_TaskDue_date();
//		//	add_select_RecordStatus_DropDown();
//		Enter_ProjectTask_phase();
		add_Submit_Project_validate(projectname);
		validateProjectCreated(projectname);
		
		wrapper.click("Link_Project_Managment_page");
		open_ProjectBenifits_Tab();
		wrapper.click("Project_edit_button");
		wrapper.waitForBrowserToLoadCompletely();
		wrapper.click("project_projectBenifits_employmnetinformation_edit_button");
		Enter_ProjectBenifits_EmploymnetFullTimeNumber();
		Enter_ProjectBenifits_EmploymnetFullTimesalary();
		Enter_ProjectBenifits_EmploymnetManagmnetNumber();
		Enter_ProjectBenifits_EmploymnetmangamentSalary();
		Enter_ProjectBenifits_EmploymnetPartTimeNumber();
		Enter_ProjectBenifits_EmploymnetPartTimeSalary();
		Enter_ProjectBenifits_EmploymnetContractNumber();
		Enter_ProjectBenifits_EmploymnetContractSalary();
		Thread.sleep(2000);
		wrapper.click("project_projectBenifits_employmnetinformation_update_button");
		wrapper.waitForBrowserToLoadCompletely();
		wrapper.click("ProjectGeneralInfoPage_Submit_Button");
		wrapper.waitForBrowserToLoadCompletely();
		Employement_value_validations_projectBenifits();
		
		
	}
	public synchronized void Validate_ProjectBenifits_Employmentinformation_scida() throws InterruptedException, IOException
	{

		wrapper.click("ModalBox_AddProject");
		isAddprojectPageDisplayed();
		String projectname=add_data_submit_ProjectName_of_project();
		add_select_submit_CompnayCategory_of_project();
		


	/////Project Benefits tab*****************************

			open_ProjectBenifits_Tab();
		    Enter_ProjectBenifits_InvestmnetNotes();
			Enter_ProjectBenifits_IncentivesNotes();
			Enter_ProjectBenifits_InVestmentInhibitors();
			Enter_ProjectBenifits_InvestmentRational();
			Enter_ProjectBenifits_Investment_realstate_value();
			Enter_ProjectBenifits_Investment_Inventory();
			Enter_ProjectBenifits_Investment_MachineandEquipment();
			Enter_ProjectBenifits_Investment_FurnitureFixture();
			Add_investmnet();
			//Enter_ProjectBenifits_Investment_Amount();
			//Enter_ProjectBenifits_Incentive_Amount();
			Enter_ProjectBenifits_EmploymnetFullTimeNumber();
			Enter_ProjectBenifits_EmploymnetFullTimesalary();
			Enter_ProjectBenifits_EmploymnetManagmnetNumber();
			Enter_ProjectBenifits_EmploymnetmangamentSalary();
			Enter_ProjectBenifits_EmploymnetPartTimeNumber();
			Enter_ProjectBenifits_EmploymnetPartTimeSalary();
			Enter_ProjectBenifits_EmploymnetContractNumber();
			Enter_ProjectBenifits_EmploymnetContractSalary();
			add_employmnet_details();
			Enter_ProjectBenifits_NumberConstructionJobs();
			Enter_ProjectBenifits_WorkerWages();
			//Enter_ProjectBenifits_ConstructionJobs();
			//Enter_ProjectBenifits_TotalJobs();
		

		add_Submit_Project_validate(projectname);
		validateProjectCreated(projectname);
		
		wrapper.click("Link_Project_Managment_page");
		open_ProjectBenifits_Tab();
		wrapper.click("Project_edit_button");
		wrapper.waitForBrowserToLoadCompletely();
		wrapper.click("project_projectBenifits_employmnetinformation_edit_button");
		Enter_ProjectBenifits_EmploymnetFullTimeNumber();
		Enter_ProjectBenifits_EmploymnetFullTimesalary();
		Enter_ProjectBenifits_EmploymnetManagmnetNumber();
		Enter_ProjectBenifits_EmploymnetmangamentSalary();
		Enter_ProjectBenifits_EmploymnetPartTimeNumber();
		Enter_ProjectBenifits_EmploymnetPartTimeSalary();
		Enter_ProjectBenifits_EmploymnetContractNumber();
		Enter_ProjectBenifits_EmploymnetContractSalary();
		Thread.sleep(2000);
		wrapper.click("project_projectBenifits_employmnetinformation_update_button");
		wrapper.waitForBrowserToLoadCompletely();
		wrapper.click("ProjectGeneralInfoPage_Submit_Button");
		wrapper.waitForBrowserToLoadCompletely();
		Employement_value_validations_projectBenifits();
		
		
	}
	
	
	public synchronized void Validate_ProjectBenifits_InteractionNotes() throws InterruptedException, IOException
	{
		
		wrapper.click("ModalBox_AddProject");
		isAddprojectPageDisplayed();
		String projectname=add_data_submit_ProjectName_of_project();
		add_select_submit_CompnayCategory_of_project();
		add_select_submit_ProjectManager_DropDown();
		add_select_submit_Compnany_of_project();
		add_select_submit_PrimaryContact_of_project();
		add_select_submit_SecondaryContact_of_project();
		//	add_select_submit_OtherContact_DropDown();
		add_select_submit_IndustryCluster_of_project();
		// 	add_select_submit_NAICSCode_DropDown();
		//	add_submit_CommisionerName();
		//	add_submit_District();
		add_Select_submit_Projectdatetype();
		add_submit_Projectdate();
		add_submit_ProjectdateNotes();
		//add_select_submit_Visibility();
		add_select_submit_Tags();
		add_select_submit_Projectdate_Notes();
		add_select_submit_phoneType();
		add_select_submit_phoneNumberExtension();
		add_select_submit_EmailType();
		add_submit_Email();
		add_submit_EmailNotes();
		add_Select_submit_AddressType();
		add__submit_StreetAddress();
		add__submit_StreetAddress2();
		add_submit_City();
		add_Select_Country();
		add_Select_State();
		add_Submit_Zip();
		add_Submit_Alias();
		add_Select_URL();
		add_Submit_URLValue();
		add_Submit_URLNote();
		add_Select_RFI();
		//add_Select_RFIResponse();
		//add_Submit_Extrastring();
		//add_Submit_Dummydate();
		add_Submit_RFIResponseNotes();
		add_Submit_RFIDate();
		add_Submit_RFISource();		

	///////**********************************Interaction Notes*************

			wrapper.click("ProjectInteractionNotes_Tab_Title");
			Select_ProjectInteraction_NoteType();
			Enter_ProjectInteraction_Keyword();
			//	add_select__Attendee_DropDown();
			Enter_ProjectInteraction_sortDescription();
			ProjectInteraction_uploadDocfile();
			add_select_Company_DropDown();
		add_Submit_Project_validate(projectname);
		validateProjectCreated(projectname);
/////////******************************************
		wrapper.click("Link_Project_Managment_page");
		wrapper.click("ProjectInteractionNotes_Tab_Title");
		wrapper.click("Project_edit_button");
		Thread.sleep(2000);
		wrapper.click("Project_interactionnotes_edit_Button");
		wrapper.waitForBrowserToLoadCompletely();
		Enter_ProjectInteraction_Keyword();
		Enter_ProjectInteraction_sortDescription();
		ProjectInteraction_uploadDocfile();
		wrapper.click("ProjectGeneralInfoPage_Submit_Button");
		wrapper.waitForBrowserToLoadCompletely();
		InteractionNotes_details_description();
		//InteractionNotes_details_validations();
		
	}
	
	public synchronized void Validate_ProjectBenifits_InteractionNotes_scida() throws InterruptedException, IOException
	{
		
		wrapper.click("ModalBox_AddProject");
		isAddprojectPageDisplayed();
		String projectname=add_data_submit_ProjectName_of_project();
		add_select_submit_CompnayCategory_of_project();
		add_select_submit_ProjectManager_DropDown();
		add_select_submit_Compnany_of_project_SCIDA();
		add_select_submit_PrimaryContact_of_project_SCIDA("Alexander Caro");
		add_select_submit_SecondaryContact_of_project("Abe Mayeri");
		//	add_select_submit_OtherContact_DropDown();
		add_select_submit_IndustryCluster_of_project();
		// 	add_select_submit_NAICSCode_DropDown();
		//	add_submit_CommisionerName();
		//	add_submit_District();
		add_Select_submit_Projectdatetype();
		add_submit_Projectdate();
		add_submit_ProjectdateNotes();
		//add_select_submit_Visibility();
		add_select_submit_Tags();
		add_select_submit_Projectdate_Notes();
		add_select_submit_phoneType();
		add_select_submit_phoneNumberExtension();
		add_select_submit_EmailType();
		add_submit_Email();
		add_submit_EmailNotes();
		add_Select_submit_AddressType();
		add__submit_StreetAddress();
		add__submit_StreetAddress2();
		add_submit_City();
		add_Select_Country();
		add_Select_State();
		add_Submit_Zip();
		add_Submit_Alias();
		add_Select_URL();
		add_Submit_URLValue();
		add_Submit_URLNote();
		add_Select_RFI();
		//add_Select_RFIResponse();
		//add_Submit_Extrastring();
		//add_Submit_Dummydate();
		add_Submit_RFIResponseNotes();
		add_Submit_RFIDate();
		add_Submit_RFISource();		

	///////**********************************Interaction Notes*************

			wrapper.click("ProjectInteractionNotes_Tab_Title");
			Select_ProjectInteraction_NoteType();
			Enter_ProjectInteraction_Keyword();
			//	add_select__Attendee_DropDown();
			Enter_ProjectInteraction_sortDescription();
			ProjectInteraction_uploadDocfile();
			add_select_Company_DropDown("324 South Service Road Assoc. LLC");
		add_Submit_Project_validate(projectname);
		validateProjectCreated(projectname);
/////////******************************************
		wrapper.click("Link_Project_Managment_page");
		wrapper.click("ProjectInteractionNotes_Tab_Title");
		wrapper.click("Project_edit_button");
		Thread.sleep(2000);
		wrapper.click("Project_interactionnotes_edit_Button_scida");
		wrapper.waitForBrowserToLoadCompletely();
		Enter_ProjectInteraction_Keyword();
		Enter_ProjectInteraction_sortDescription();
		ProjectInteraction_uploadDocfile();
		wrapper.click("ProjectGeneralInfoPage_Submit_Button");
		wrapper.waitForBrowserToLoadCompletely();
		InteractionNotes_details_description();
		//InteractionNotes_details_validations();
		
	}

	public synchronized void Validate_ProjectBenifits_InteractionNotes_dafc() throws InterruptedException, IOException
	{
		
		wrapper.click("ModalBox_AddProject");
		isAddprojectPageDisplayed();
		String projectname=add_data_submit_ProjectName_of_project();	

	///////**********************************Interaction Notes*************

			wrapper.click("ProjectInteractionNotes_Tab_Title");
			Select_ProjectInteraction_NoteType();
			Enter_ProjectInteraction_Keyword();
			//	add_select__Attendee_DropDown();
			Enter_ProjectInteraction_sortDescription();
			ProjectInteraction_uploadDocfile();
			add_select_Company_DropDown("357 Gift Shop.com");
		add_Submit_Project_validate(projectname);
		validateProjectCreated(projectname);
/////////******************************************
		wrapper.click("Link_Project_Managment_page");
		wrapper.click("ProjectInteractionNotes_Tab_Title");
		wrapper.click("Project_edit_button");
		Thread.sleep(2000);
		wrapper.click("Project_interactionnotes_edit_Button_dafc");
		wrapper.waitForBrowserToLoadCompletely();
		Enter_ProjectInteraction_Keyword();
		Enter_ProjectInteraction_sortDescription();
		ProjectInteraction_uploadDocfile();
		wrapper.click("ProjectGeneralInfoPage_Submit_Button");
		wrapper.waitForBrowserToLoadCompletely();
		InteractionNotes_details_description();
		//InteractionNotes_details_validations();
		
	}

	
	public synchronized void Validate_Project_reset_Button() throws InterruptedException, IOException
	{
		
		wrapper.click("Link_Project_Managment_page");
		wrapper.click("ProjectInteractionNotes_Tab_Title");
		wrapper.click("Project_edit_button");
		wrapper.waitForBrowserToLoadCompletely();
		Enter_ProjectInteraction_Keyword();
		Enter_ProjectInteraction_sortDescription();
		Thread.sleep(1000);
		wrapper.click("project_reset_buton");
		wrapper.waitForBrowserToLoadCompletely();
		
		
	}
	
	String marketvalue=generateRandomNumberOfFixLength(4);
	public synchronized void Enter_ProjectBenifits_taxinfo_fairmarketvalue() throws InterruptedException 
	{
		
		
		  WebElement element = wrapper.getElement("Project_benifits_taxinformation_input_marketvalue");
		    element.clear();
		    String val = marketvalue; 
		    for (int i = 0; i < val.length(); i++){
		        char c = val.charAt(i);
		        String s = new StringBuilder().append(c).toString();
		        element.sendKeys(s);
		    }   
		Reporter.log("Enter value to market place");
		Thread.sleep(100);
		


	}
	
	String taxpaid=generateRandomNumberOfFixLength(5);
	public synchronized void Enter_ProjectBenifits_taxinfo_taxpaid() throws InterruptedException 
	{
		
		

		  WebElement element = wrapper.getElement("Project_benifits_taxinformation_input_taxpaid");
		    element.clear();
		    String val = taxpaid; 
		    for (int i = 0; i < val.length(); i++){
		        char c = val.charAt(i);
		        String s = new StringBuilder().append(c).toString();
		        element.sendKeys(s);
		    }   
		Reporter.log("Enter value to 10 years atax paid value");
		Thread.sleep(100);
		


	}
	
	String comulativeincetives=generateRandomNumberOfFixLength(5);
	public synchronized void Enter_ProjectBenifits_taxinfo_incetives() throws InterruptedException 
	{
		
		 WebElement element = wrapper.getElement("Project_benifits_taxinformation_input_incentives");
		    element.clear();
		    String val = comulativeincetives; 
		    for (int i = 0; i < val.length(); i++){
		        char c = val.charAt(i);
		        String s = new StringBuilder().append(c).toString();
		        element.sendKeys(s);
		    }   
		Reporter.log("Enter value to 10 years atax paid value");
		Thread.sleep(100);


	}
	

	public synchronized void Validate_projectBenifits_Taxinfomation() throws InterruptedException, IOException
	{
		wrapper.click("Link_Project_Managment_page");
		open_ProjectBenifits_Tab();
		wrapper.click("Project_edit_button");
		wrapper.waitForBrowserToLoadCompletely();
		Enter_ProjectBenifits_taxinfo_fairmarketvalue();
		Enter_ProjectBenifits_taxinfo_taxpaid();
		Enter_ProjectBenifits_taxinfo_incetives();
		wrapper.click("ProjectGeneralInfoPage_Submit_Button");
		Taxation_details_validations_projectBenifits();
		
		
	}
	
	
	public synchronized void Editproject_ProjectData_with_resizing_of_window() throws InterruptedException, IOException
	{
		wrapper.click("Link_Project_Managment_page");
		//isAddprojectPageDisplayed();
		wrapper.click("Project_edit_button");
		wrapper.zoomInZoomOut();
		Thread.sleep(3000);
		add_data_submit_ProjectName_of_project();
		Open_Projectdata_Tab();
		String Desc=edit_Projectdata_Description();
		wrapper.resiizewindow();
		add_select_submit_StagesType_projectData();
		add_Submit_requirmnet_Description();
		wrapper.maximizewindow();
		add_Submit_SpaceRequirmnet_ExistingBuilding_value();
		add_Submit_edited_projectvalues(Desc);
		//validateProjectdataedited();
		
	}
	public synchronized void isAddprojectPageDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Add project page is displayed");

		String ExpTitle = json.getTestCaseData("AddProjectExpectedTitle");

		wrapper.waitForBrowserToLoadCompletely();

		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateInnerText("InlineText_AddProject", "ExpectedPageName");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}

	}

	public synchronized void validate_fields_under_generalinfo_Enabled() throws InterruptedException {
		Reporter.log("Validate add project name filed is enabled on general info page");

		wrapper.validateElementVisibleandEnabled("TxtField_projectName");
		wrapper.validateElementVisibleandEnabled("Text_box_date");
		wrapper.validateElementVisibleandEnabled("Text_box_notes");
		wrapper.validateElementVisibleandEnabled("TextBox_phonenumber");
		wrapper.validateElementVisibleandEnabled("TextBox_extension");
		wrapper.validateElementVisibleandEnabled("ProjectGeneralInfoPage_checkbox_RFI_ResponseNote");
		//wrapper.validateElementVisibleandEnabled("ProjectGeneralInfoPage_TextBox_WebUrl");
		//wrapper.validateElementVisibleandEnabled("ProjectGeneralInfoPage_TextBox_UrlNote");
		wrapper.validateElementVisibleandEnabled("ProjectGeneralInfoPage_TextBox_Zip");
		wrapper.validateElementVisibleandEnabled("ProjectGeneralInfoPage_TextBox_Alias");
		wrapper.validateElementVisibleandEnabled("TextBox_email");

	}
	
	public synchronized void validate_fields_under_generalinfo_Enabled_dafc() throws InterruptedException {
		Reporter.log("Validate add project name filed is enabled on general info page");

		wrapper.validateElementVisibleandEnabled("TxtField_projectName");
		//wrapper.validateElementVisibleandEnabled("Text_box_date");
		//wrapper.validateElementVisibleandEnabled("Text_box_notes");
		wrapper.validateElementVisibleandEnabled("TextBox_phonenumber");
		wrapper.validateElementVisibleandEnabled("TextBox_extension");
		wrapper.validateElementVisibleandEnabled("ProjectGeneralInfoPage_checkbox_RFI_ResponseNote");
		//wrapper.validateElementVisibleandEnabled("ProjectGeneralInfoPage_TextBox_WebUrl");
		//wrapper.validateElementVisibleandEnabled("ProjectGeneralInfoPage_TextBox_UrlNote");
		wrapper.validateElementVisibleandEnabled("ProjectGeneralInfoPage_TextBox_Zip");
		wrapper.validateElementVisibleandEnabled("ProjectGeneralInfoPage_TextBox_Alias");
		wrapper.validateElementVisibleandEnabled("TextBox_email");

	}

	/*public synchronized void add_select_submit_Visibility() throws InterruptedException 
	{
		Reporter.log("Select Visibility");
		wrapper.click("Drop_down_visibility");
		wrapper.click("DropDown_value");
	}
	
	public synchronized void add_select_edit_Visibility() throws InterruptedException 
	{
		Reporter.log("Select Visibility");
		wrapper.click("Drop_down_visibility_edit");
		wrapper.click("DropDown_value");
	}*/

	public synchronized void add_select_submit_Tags() throws InterruptedException 
	{
		Reporter.log("Select Tag");
		wrapper.click("Tag_box");
		wrapper.click("Select_list");
	}

	public synchronized void add_select_submit_Projectdate_Notes() throws InterruptedException 
	{
		Reporter.log("Submit notes text");
		wrapper.setTextBoxValue_Direct("TextBox_notes", generateRandomAlphaNumeric(200));
	}

	public synchronized void add_select_submit_phoneType() throws InterruptedException 
	{
		Reporter.log("Select phone type");
		wrapper.click("Drwondown_select_phone");
		wrapper.selectByVisibleText("Drwondown_select_phone", "ExpectedTextPhone");
	}

	public synchronized void add_select_submit_phoneNumber() throws InterruptedException 
	{
		Reporter.log("enter phone Number");
		wrapper.setTextBoxValue_Direct("TextBox_phonenumber", generateRandomNumberOfFixLength(8));
	}

	public synchronized void add_select_submit_phoneNumberExtension() throws InterruptedException 
	{
		Reporter.log("Enter phone extension");
		wrapper.setTextBoxValue_Direct("TextBox_extension", generateRandomNumberOfFixLength(2));
	}

	public synchronized void add_select_submit_EmailType() throws InterruptedException 
	{
		Reporter.log("Select Eamail type");
		wrapper.selectByVisibleText("Drowdown_email", "ExpectedTextEmail");
	}

	public synchronized void add_submit_Email() throws InterruptedException 
	{
		Reporter.log("Enter Eamail type");
		wrapper.setTextBoxValue_Direct("TextBox_email", "abababcd@gmail.com");
	}

	public synchronized void add_submit_EmailNotes() throws InterruptedException 
	{
		Reporter.log("Enter Eamail Notes");
		wrapper.setTextBoxValue_Direct("TextBox_notes_email", generateRandomAlphaNumeric(6));
	}

	public synchronized void add_Select_submit_AddressType() throws InterruptedException 
	{
		Reporter.log("Select Address Type");
		wrapper.selectByVisibleText("DropDown_address_type", "ExpectedTextAdressType");
	}

	public synchronized void add__submit_StreetAddress() throws InterruptedException 
	{
		Reporter.log("Enter street Address");
		wrapper.setTextBoxValue_Direct("TextBox_streetAddress", generateRandomAlphaNumeric(12));
	}

	public synchronized void add__submit_StreetAddress2() throws InterruptedException 
	{
		Reporter.log("Enter street Address2");
		wrapper.setTextBoxValue_Direct("TextBox_streetAddress2", generateRandomAlphaNumeric(12));
	}

	public synchronized void add_submit_City() throws InterruptedException 
	{
		Reporter.log("Enter street City");
		wrapper.setTextBoxValue_Direct("TextBox_City", generateRandomAlphaNumeric(10));
	}

	public synchronized void add_Select_Country() throws InterruptedException 
	{
		Reporter.log("Enter street Country");
		wrapper.selectByVisibleText("ProjectGeneralInfoPage_DropDown_Country", "ExpectedTexCountry");
	}

	public synchronized void add_Select_State() throws InterruptedException 
	{
		Reporter.log("Enter street State");
		wrapper.selectByVisibleText("ProjectGeneralInfoPage_DropDown_state", "ExpectedTexstate");
	}

	public synchronized void add_Submit_Zip() throws InterruptedException 
	{
		Reporter.log("Enter street Zip");
		wrapper.setTextBoxValue_Direct("ProjectGeneralInfoPage_TextBox_Zip", generateRandomNumberOfFixLength(8));
	}
	
	public synchronized void add_Submit_taxmap() throws InterruptedException 
	{
		Reporter.log("Enter tax map value");
		wrapper.setTextBoxValue_Direct("Project_difc_taxmap_textbox", generateRandomNumberOfFixLength(8));
	}
	
	public synchronized void add_Submit_schooldistric() throws InterruptedException 
	{
		Reporter.log("Enter school disctric");
		wrapper.setTextBoxValue_Direct("Project_difc_schooldisctrict_textbox", generateRandomNumberOfFixLength(8));
	}
	
	public synchronized void add_Submit_acreage() throws InterruptedException 
	{
		Reporter.log("Enter acreage value");
		wrapper.setTextBoxValue_Direct("Project_difc_acreage_textbox", generateRandomNumberOfFixLength(8));
	}
	

	public synchronized void add_Submit_Alias() throws InterruptedException 
	{
		Reporter.log("Enter Alias");
		wrapper.setTextBoxValue_Direct("ProjectGeneralInfoPage_TextBox_Alias", generateRandomAlphaNumeric(10));
	}

	public synchronized void add_Select_URL() throws InterruptedException 
	{
		Reporter.log("Select URl type");
		wrapper.selectByVisibleText("ProjectGeneralInfoPage_DropDown_Url", "ExpectedTexsURL");

	}

	public synchronized void add_Submit_URLValue() throws InterruptedException 
	{
		Reporter.log("Enter URL value");
		wrapper.setTextBoxValue_Direct("ProjectGeneralInfoPage_TextBox_WebUrl", "www.google.com");

	}

	public synchronized void add_Submit_URLNote() throws InterruptedException 
	{
		Reporter.log("Enter URLNote");
		wrapper.setTextBoxValue_Direct("ProjectGeneralInfoPage_TextBox_UrlNote", generateRandomAlphaNumeric(10));

	}

	public synchronized void add_Select_RFI() throws InterruptedException 
	{
		Reporter.log("Select RFI check BOX");
		wrapper.click("ProjectGeneralInfoPage_checkbox_RFI_yes");

	}

	public synchronized void add_Select_RFIResponse() throws InterruptedException 
	{
		Reporter.log("Select add RFIResponse");
		wrapper.selectByVisibleText("ProjectGeneralInfoPage_checkbox_RFI_Response", "ExpectedTexsResponse");

	}

	public synchronized void add_Submit_Extrastring() throws InterruptedException 
	{
		Reporter.log("Select add Extrastring");
		wrapper.setTextBoxValue_Direct("ProjectGeneralInfoPage_TextBox_ExtraStringField3", generateRandomAlphaNumeric(10));

	}

	public synchronized void add_Submit_Dummydate() throws InterruptedException 
	{
		Reporter.log("Select add Dummydate");
		wrapper.click("ProjectGeneralInfoPage_DateFiled_DummyDate3");
		wrapper.click("ProjectGeneralInfoPage_DateFiled_DummyDate3_value");

	}

	public synchronized void add_Submit_RFIResponseNotes() throws InterruptedException 
	{
		Reporter.log("Select add RFI response Notes");
		wrapper.setTextBoxValue_Direct("ProjectGeneralInfoPage_checkbox_RFI_ResponseNote", generateRandomAlphaNumeric(30));

	}

	public synchronized void add_Submit_RFIDate() throws InterruptedException 
	{
		Reporter.log("Select add RFI Date");
		wrapper.click("ProjectGeneralInfoPage_checkbox_RFI_dateCalender");
		wrapper.click("ProjectGeneralInfoPage_checkbox_RFI_dateValue");

	}

	public synchronized void add_Submit_RFISource() throws InterruptedException 
	{
		Reporter.log("Select add RFI Source");
		wrapper.holdAndSelect("ProjectGeneralInfoPage_DropDown_RFI_projectSource", "ProjectGeneralInfoPage_Dropdown_RFI_projectSource_value" );

	}

	public synchronized void add_Submit_Project_validate(String projectname) throws InterruptedException 
	{
		Reporter.log("Validate project has been created");
		Thread.sleep(1000);
		wrapper.click("ProjectGeneralInfoPage_Submit_Button");
		Thread.sleep(2000);
		wrapper.waitForBrowserToLoadCompletely();
		String Titlevaluenew= wrapper.getInnerTextByName("ProjectGeneralInfoPage_Text_projectTitle_ProjectName" );

		Assert.assertEquals(projectname, Titlevaluenew);

	}
	
	public synchronized void add_Submit_edited_projectvalues(String Desc) throws InterruptedException, IOException 
	{
		Reporter.log("Validate project has been created");
		wrapper.click("ProjectGeneralInfoPage_Submit_Button");
		wrapper.waitForBrowserToLoadCompletely();
		String Titlevalue= wrapper.getInnerTextByName("Project_projectData_Description" );
		
		System.out.println(Desc);
		System.out.println(Titlevalue);
		Thread.sleep(1000);
		Assert.assertEquals(Titlevalue, Desc);

	}


	
	public synchronized void add_Submit_edited_task() throws IOException{
		Reporter.log("Validate field task has been edited");
		wrapper.click("ProjectGeneralInfoPage_Submit_Button");
		wrapper.waitForBrowserToLoadCompletely();
		wrapper.click("ModalBox_Dashboard");
		String originalpprojectnametitle= TaskName;
		 wrapper.waitForBrowserToLoadCompletely();
		 String Documnetnamevaluexpathmarket= ("'"+originalpprojectnametitle+"'"+")]");
		 String TitlevalueDocumnetmarket= wrapper.getInnerTextDynamic("Project_task_name_dashboard", Documnetnamevaluexpathmarket);
		 System.out.println("this is tester value"+ originalpprojectnametitle);
		 System.out.println("This is web value"+ TitlevalueDocumnetmarket);
		Assert.assertEquals(originalpprojectnametitle, TitlevalueDocumnetmarket);
		wrapper.waitForBrowserToLoadCompletely();

	}
	
	public synchronized void add_Submit_edited_resources() throws IOException, InterruptedException{
		Reporter.log("Validate resource has been edited");
		wrapper.click("ProjectGeneralInfoPage_Submit_Button");
		wrapper.waitForBrowserToLoadCompletely();
		wrapper.click("ProjectResources_Title");
		String Titlevalue= wrapper.getInnerTextByName("Project_resource_description" );
		//String Titlevalue1= wrapper.getInnerTextByName("Project_resource_keyword" );
		
		String finaldescription=(resourcedescription+", "+projectresourcekeyword);
		Thread.sleep(1000);
		
		Assert.assertEquals(Titlevalue, resourcedescription);
		//Assert.assertEquals(Titlevalue1, projectresourcekeyword);

	}
	
	public synchronized void add_Submit_edited_projectBenifits() throws IOException, InterruptedException{
		Reporter.log("Validate project benifit has been edited");
		wrapper.waitForBrowserToLoadCompletely();
		String Titlevalue= wrapper.getInnerTextByName("Project_Benifits_realEstate_value" );
		String Titlevalue1= wrapper.getInnerTextByName("Project_Benifits_inventory_value" );
		String Titlevalue2= wrapper.getInnerTextByName("Project_Benifits_MESum_value" );
		String Titlevalue3= wrapper.getInnerTextByName("Project_Benifits_FurnitureFixture_value" );
		
		System.out.println(Realstate);
		System.out.println(Titlevalue);
		System.out.println(inventory);
		System.out.println(Titlevalue1);
		System.out.println(machineequipment);
		System.out.println(Titlevalue2);
		System.out.println(FurnitureFixture);
		System.out.println(Titlevalue3);
		Thread.sleep(1000);
		String realstatevalue= insertString(Realstate,'.',2);
		String inventoryvalue= insertString(inventory,'.',1);
		String machineequipmentvalue= insertString(machineequipment,'.',1);
		String FurnitureFixturevalue= insertString(FurnitureFixture,'.',0);
		Assert.assertEquals(Titlevalue, "$ "+realstatevalue);
		Assert.assertEquals(Titlevalue1, "$ "+inventoryvalue);
		Assert.assertEquals(Titlevalue2, "$ "+ machineequipmentvalue);
		Assert.assertEquals(Titlevalue3, "$ "+ FurnitureFixturevalue);

	}
	
	public synchronized void add_total_investmnet_projectBenifits() throws IOException, InterruptedException{
		Reporter.log("Validate project benifit has been edited");
		wrapper.waitForBrowserToLoadCompletely();
		String Titlevalue= wrapper.getInnerTextByName("Project_Benifits_realEstate_value" );
		String Titlevalue1= wrapper.getInnerTextByName("Project_Benifits_inventory_value" );
		String Titlevalue2= wrapper.getInnerTextByName("Project_Benifits_MESum_value" );
		String Titlevalue3= wrapper.getInnerTextByName("Project_Benifits_FurnitureFixture_value" );
		String Titlevalue4= wrapper.getInnerTextByName("Project_Benifits_totalinvestmnetvalue" );
		
		System.out.println(Realstate);
		System.out.println(Titlevalue);
		System.out.println(inventory);
		System.out.println(Titlevalue1);
		System.out.println(machineequipment);
		System.out.println(Titlevalue2);
		System.out.println(FurnitureFixture);
		System.out.println(Titlevalue3);
		int val1=Integer.parseInt(Realstate);
		int val2=Integer.parseInt(inventory);
		int val3=Integer.parseInt(machineequipment);
		int val4=Integer.parseInt(FurnitureFixture);
		
		
		int totalvalue= val1+val2+val3+val4;
	   String valuetest= Integer.toString(totalvalue);
		System.out.println(totalvalue);
		System.out.println(valuetest);
		System.out.println(test);
		Thread.sleep(1000);
		String realstatevalue= insertString(Realstate,'.',2);
		String inventoryvalue= insertString(inventory,'.',1);
		String machineequipmentvalue= insertString(machineequipment,'.',1);
		String FurnitureFixturevalue= insertString(FurnitureFixture,'.',0);
		Assert.assertEquals(Titlevalue, "$ "+realstatevalue);
		Assert.assertEquals(Titlevalue1, "$ "+inventoryvalue);
		Assert.assertEquals(Titlevalue2, "$ "+ machineequipmentvalue);
		Assert.assertEquals(Titlevalue3, "$ "+ FurnitureFixturevalue);
		Assert.assertEquals(Titlevalue3, "$ "+ FurnitureFixturevalue);
		//String formatedtotalvaleue1= insertString(valuetest,',',0);
		String formatedtotalvaleue= insertString(valuetest,'.',2);
		System.out.println(formatedtotalvaleue);
		System.out.println(Titlevalue4);
		Assert.assertEquals(Titlevalue4, "$ "+ formatedtotalvaleue);
		

	}

	public synchronized void Employee_details_validations_projectBenifits() throws IOException, InterruptedException{
		Reporter.log("Validate project benifit has been edited");
		wrapper.waitForBrowserToLoadCompletely();
		Thread.sleep(1000);
		String Totalemp= wrapper.getTextBoxValue("Project_Benifits_total_employee" );
		String Totalwages= wrapper.getTextBoxValue("Project_Benifits_total_average_wages" );
		String Totalconstructionperiod= wrapper.getTextBoxValue("Project_Benifits_total_period_cunstruction" );
		Thread.sleep(1000);
		String Totaljobcreated= wrapper.getTextBoxValue("Project_Benifits_total_jobs_created" );
	
		String wagestotalvaleue= insertString(wages,'.',0);
	
		System.out.println(test);
		Thread.sleep(6000);
		Assert.assertEquals(totalemp, Totalemp);
		Assert.assertEquals(Totalwages, "$ "+wagestotalvaleue);
		Assert.assertEquals(Totalconstructionperiod, consjobs);
		Assert.assertEquals(Totaljobcreated,  totaljobs);
		

	}
	
	public synchronized void Employement_information_validations_projectBenifits() throws IOException, InterruptedException{
		Reporter.log("Validate project benifit has been edited");
		wrapper.waitForBrowserToLoadCompletely();
		Thread.sleep(5000);
		String numberoffulltimeemp= wrapper.getInnerTextByName("project_projectBenifits_employment_fulltimenumber" );
		String fulltimesalary= wrapper.getInnerTextByName("project_projectBenifits_employment_fulltimesalary" );
		String managmnetnumber= wrapper.getInnerTextByName("project_projectBenifits_employment_managmnetnumber" );		
		String managmnetsalary= wrapper.getInnerTextByName("project_projectBenifits_employment_managmnetsalary" );
		String parttimenumber= wrapper.getInnerTextByName("project_projectBenifits_employment_parttimenumber" );
		String parttimesalary= wrapper.getInnerTextByName("project_projectBenifits_employment_parttimesalary" );
		String contractnumber= wrapper.getInnerTextByName("project_projectBenifits_employment_contractnumber" );
		String contractsalary= wrapper.getInnerTextByName("project_projectBenifits_employment_contractsalary" );
		String totalspendonemploymnet= wrapper.getInnerTextByName("project_projectBenifits_employment_totalspend" );
		
		
		
		int salaryfulltime= Integer.parseInt(fulltimenumberemploye) * Integer.parseInt(fulltimeemployeesalary);
		String s=String.valueOf(salaryfulltime);
		String decval10= insertString(s,'.',0);
		System.out.println(s);
	
	int salarymanagmnet=Integer.parseInt(Managmnetallemployee) * Integer.parseInt(managmnetemployeesalary);
	
	String s3=String.valueOf(salarymanagmnet);
	int s4= s.length();

	int s5= s4-2;

	String decval11= insertString(s3,'.',0);
	System.out.println(s3);
	
	
	
	int salaryparttime=Integer.parseInt(parttimenumberemployee) * Integer.parseInt(parttimeemployeesalary);
	String s6=String.valueOf(salaryparttime);
	int s7= s.length();
	


	String decval12= insertString(s6,'.',0);
	System.out.println(s6);


	int salarycontract=Integer.parseInt(employeecontractnumber) * Integer.parseInt(employeecontractnumbersalary);
	String s9=String.valueOf(salarycontract);
	int s10= s.length();
	


	String decval13= insertString(s9,'.',0);
	System.out.println(s9);

	int totalsalarypaid=Integer.parseInt(s9)+Integer.parseInt(s6)+Integer.parseInt(s3)+Integer.parseInt(s);

	String decval14= String.valueOf(totalsalarypaid);
	String finalvaluetomatch=insertString(decval14,'.',3);
	String finalvaluetomatch1=insertString(finalvaluetomatch,',',0);
	
	String finalvaluetomatch2=("$ "+finalvaluetomatch1+"00");

	System.out.println("Total salary paid" + totalsalarypaid);
	System.out.println("this is value of tester"+ finalvaluetomatch2);
	System.out.println("this value got from system"+ totalspendonemploymnet);
		
     Assert.assertEquals( totalspendonemploymnet, finalvaluetomatch2);
		

	}
	
	public synchronized void Employement_value_validations_projectBenifits() throws IOException, InterruptedException{
		Reporter.log("Validate project benifit has been edited");
		wrapper.waitForBrowserToLoadCompletely();
		Thread.sleep(5000);
		String numberoffulltimeemp= wrapper.getInnerTextByName("project_projectBenifits_employment_fulltimenumber" );
		String fulltimesalary= wrapper.getInnerTextByName("project_projectBenifits_employment_fulltimesalary" );
		String managmnetnumber= wrapper.getInnerTextByName("project_projectBenifits_employment_managmnetnumber" );		
		String managmnetsalary= wrapper.getInnerTextByName("project_projectBenifits_employment_managmnetsalary" );
		String parttimenumber= wrapper.getInnerTextByName("project_projectBenifits_employment_parttimenumber" );
		String parttimesalary= wrapper.getInnerTextByName("project_projectBenifits_employment_parttimesalary" );
		String contractnumber= wrapper.getInnerTextByName("project_projectBenifits_employment_contractnumber" );
		String contractsalary= wrapper.getInnerTextByName("project_projectBenifits_employment_contractsalary" );
		String totalspendonemploymnet= wrapper.getInnerTextByName("project_projectBenifits_employment_totalspend" );
		
		
		
		int salaryfulltime= Integer.parseInt(fulltimenumberemploye) * Integer.parseInt(fulltimeemployeesalary);
		String s=String.valueOf(salaryfulltime);
		String decval10= insertString(s,'.',0);
		System.out.println(s);
	
	int salarymanagmnet=Integer.parseInt(Managmnetallemployee) * Integer.parseInt(managmnetemployeesalary);
	
	String s3=String.valueOf(salarymanagmnet);
	int s4= s.length();

	int s5= s4-2;

	String decval11= insertString(s3,'.',0);
	System.out.println(s3);
	
	
	
	int salaryparttime=Integer.parseInt(parttimenumberemployee) * Integer.parseInt(parttimeemployeesalary);
	String s6=String.valueOf(salaryparttime);
	int s7= s.length();
	


	String decval12= insertString(s6,'.',0);
	System.out.println(s6);


	int salarycontract=Integer.parseInt(employeecontractnumber) * Integer.parseInt(employeecontractnumbersalary);
	String s9=String.valueOf(salarycontract);
	int s10= s.length();
	


	String decval13= insertString(s9,'.',0);
	System.out.println(s9);

	int totalsalarypaid=Integer.parseInt(s9)+Integer.parseInt(s6)+Integer.parseInt(s3)+Integer.parseInt(s);

	String decval14= String.valueOf(totalsalarypaid);
	String finalvaluetomatch=insertString(decval14,'.',2);
	
	
	String finalvaluetomatch2=("$ "+finalvaluetomatch+"00");

	System.out.println("Total salary paid" + totalsalarypaid);
	System.out.println("this is value of tester"+ finalvaluetomatch2);
	System.out.println("this value got from system"+ totalspendonemploymnet);
		
     Assert.assertEquals( totalspendonemploymnet, finalvaluetomatch2);
		

	}
	
	
	public synchronized void InteractionNotes_details_description() throws IOException, InterruptedException{
		Reporter.log("Validate interaction note has been edited");
		wrapper.waitForBrowserToLoadCompletely();
		Thread.sleep(2000);
		String full1= wrapper.getInnerTextByName("Project_interactionNote_description_text" );
	
	    wrapper.validateInnerTextContainsdirect("Project_interactionNote_description_text", Projectinteractiondescription);
	    wrapper.validateInnerTextContainsdirect("Project_interactionNote_description_text", Projectinteractionshortdescription);
   System.out.println(full1);
 

		

	}
	
	public synchronized void InteractionNotes_details_validations() throws IOException, InterruptedException{
		Reporter.log("Validate interaction note has been edited");
		wrapper.waitForBrowserToLoadCompletely();
		String fulldesc= wrapper.getTextBoxValue("ProjectInteractionNotes_Description_Field_TextBox" );
		String shortdesc= wrapper.getTextBoxValue("ProjectInteractionNotes_File_TextBox" );
	
   System.out.println(fulldesc);
   System.out.println(shortdesc);
   
		Assert.assertEquals(Projectinteractiondescription, fulldesc);
		Assert.assertEquals(Projectinteractionshortdescription, shortdesc);

		

	}
	
	
	public synchronized void Taxation_details_validations_projectBenifits() throws IOException, InterruptedException{
		Reporter.log("Validate project benifit has been edited");
		wrapper.waitForBrowserToLoadCompletely();
		Thread.sleep(1000);
		String Totalmarketplace= wrapper.getTextBoxValue("Project_benifits_taxinformation_input_marketvalue" );
		String Totaltaxpaid= wrapper.getTextBoxValue("Project_benifits_taxinformation_input_taxpaid" );
		String Totalincentives= wrapper.getTextBoxValue("Project_benifits_taxinformation_input_incentives" );
	
		String marketplacetotalvaleue= insertString(marketvalue,'.',1);
		String taxpaidtotalvaleue= insertString(taxpaid,'.',2);
		String incentivestotalvaleue= insertString(comulativeincetives,'.',2);
	
		System.out.println(test);
		Thread.sleep(1000);
		Assert.assertEquals(Totalmarketplace, "$ "+marketplacetotalvaleue);
		Assert.assertEquals(Totaltaxpaid, "$ "+taxpaidtotalvaleue);
		Assert.assertEquals(Totalincentives, "$ "+incentivestotalvaleue);
		

	}


	public synchronized String add_data_submit_ProjectName_of_project() throws IOException, InterruptedException{
		String projectname=generateRandomAlphaNumeric(13);

		Reporter.log("Enter Project name");
		wrapper.setTextBoxValue_Direct("TxtField_projectName", projectname);
		Thread.sleep(1000);
		return projectname;


	}
	
	public synchronized String add_data_submit_principals_of_project_scida() throws IOException, InterruptedException{
		String princiapals=generateRandomAlphaNumeric(13);

		Reporter.log("Enter Project name");
		wrapper.setTextBoxValue_Direct("Project_scida_principals_textbox", princiapals);
		Thread.sleep(1000);
		return princiapals;


	}
	public synchronized String add_data_submit_leadsource_of_project_scida() throws IOException, InterruptedException{
		String leadsource=generateRandomAlphaNumeric(13);

		Reporter.log("Enter Project name");
		wrapper.setTextBoxValue_Direct("Project_scida_leadsource_textbox", leadsource);
		Thread.sleep(1000);
		return leadsource;


	}
	
	public synchronized void add_select_submit_CompnayCategory_of_project() throws IOException, InterruptedException{

		Reporter.log("Select Category of company");
		wrapper.DropdownspanInputSearchListValidationValueSelection(
				"DropDown_value_company_Category", 
				"CategoryId_listbox",
				"ProjectGeneral_category_comnay_search_input_box", 
				"ProjectGeneralinfo_DropDown_value_Company_Category");

	}


	public synchronized void add_select_submit_ProjectManager_DropDown() throws InterruptedException 
	{
		Reporter.log("Select Project Manager");
		wrapper.waitForElementVisibility("ProjectGeneralinfo_DrpDown_ProjectManager");
		wrapper.selectByVisibleText("ProjectGeneralinfo_DrpDown_ProjectManager", "DropDown_value_projectManager");
	}
	
	public synchronized void add_select_submit_ProjectManager_DropDown(String projectnameproject) throws InterruptedException 
	{
		Reporter.log("Select Project Manager");
		wrapper.waitForElementVisibility("ProjectGeneralinfo_DrpDown_ProjectManager");
		wrapper.selectByVisibleTextDirectly("ProjectGeneralinfo_DrpDown_ProjectManager", projectnameproject);
	}

	public synchronized void add_select_submit_Compnany_of_project() throws IOException, InterruptedException{

		Reporter.log("Enter company name");

		wrapper.dynamic_DropdownspanInputSearchListValidationValueSelection(
				"Nabisco, Inc.",
				"ProjectInfo_CompanyClickLocator", 
				"ProjectInfo_CompanySearchBoxLocator", 
				"ProjectInfo_CompanyListValueLocator");

	}
	
	public synchronized void add_select_submit_Compnany_of_project_SCIDA() throws IOException, InterruptedException{

		Reporter.log("Enter company name");

		wrapper.dynamic_DropdownspanInputSearchListValidationValueSelection(
				"201 W. Broadway PJ, LLC",
				"ProjectInfo_CompanyClickLocator", 
				"ProjectInfo_CompanySearchBoxLocator", 
				"ProjectInfo_CompanyListValueLocator");

	}
	
	public synchronized void add_select_submit_Compnany_of_project(String compnametenant) throws IOException, InterruptedException{

		Reporter.log("Enter company name");

		wrapper.dynamic_DropdownspanInputSearchListValidationValueSelection(
				compnametenant,
				"ProjectInfo_CompanyClickLocator", 
				"ProjectInfo_CompanySearchBoxLocator", 
				"ProjectInfo_CompanyListValueLocator");

	}
	
	public synchronized void add_select_submit_Compnany(String compnamenewlyadded) throws IOException, InterruptedException{

		Reporter.log("Enter company name");

		wrapper.dynamic_DropdownspanInputSearchListValidationValueSelection(
				compnamenewlyadded,
				"ProjectInfo_CompanyClickLocator", 
				"ProjectInfo_CompanySearchBoxLocator", 
				"ProjectInfo_CompanyListValueLocator");

	}

	public synchronized void add_select_submit_PrimaryContact_of_project() throws InterruptedException 
	{
		wrapper.dynamic_DropdownspanInputSearchListValidationValueSelection(
				"Alpha Beta",
				"ProjectGeneralinfo_PrimaryContact_ClickLocator", 
				"ProjectGeneralinfo_PrimaryContact_SearchBoxlocator", 
				"ProjectGeneralinfo_PrimaryContact_valueLocator");
	}
	
	public synchronized void add_select_submit_PrimaryContact_of_project_SCIDA(String primaryname) throws InterruptedException 
	{
		wrapper.dynamic_DropdownspanInputSearchListValidationValueSelection(
				primaryname,
				"ProjectGeneralinfo_PrimaryContact_ClickLocator", 
				"ProjectGeneralinfo_PrimaryContact_SearchBoxlocator", 
				"ProjectGeneralinfo_PrimaryContact_valueLocator");
	}
	public synchronized void add_select_submit_PrimaryContact_newlycreated(String newlycompcreated) throws InterruptedException 
	{
		wrapper.dynamic_DropdownspanInputSearchListValidationValueSelection(
				newlycompcreated,
				"ProjectGeneralinfo_PrimaryContact_ClickLocator", 
				"ProjectGeneralinfo_PrimaryContact_SearchBoxlocator", 
				"ProjectGeneralinfo_PrimaryContact_valueLocator");
	}

	public synchronized void add_select_submit_SecondaryContact_of_project() throws InterruptedException 
	{
		wrapper.dynamic_DropdownspanInputSearchListValidationValueSelection(
				"Devesh Seth",
				"ProjectGeneralinfo_SecondaryContact_ClickLocator", 
				"ProjectGeneralinfo_SecondaryContact_SearchBoxlocator", 
				"ProjectGeneralinfo_SecondaryContact_valueLocator");
	}
	
	public synchronized void add_select_submit_SecondaryContact_of_project_dafc() throws InterruptedException 
	{
		wrapper.dynamic_DropdownspanInputSearchListValidationValueSelection(
				"Adam Hess",
				"ProjectGeneralinfo_SecondaryContact_ClickLocator", 
				"ProjectGeneralinfo_SecondaryContact_SearchBoxlocator", 
				"ProjectGeneralinfo_SecondaryContact_valueLocator");
	}
	public synchronized void add_select_submit_SecondaryContact_of_project(String name) throws InterruptedException 
	{
		wrapper.dynamic_DropdownspanInputSearchListValidationValueSelection(
				name,
				"ProjectGeneralinfo_SecondaryContact_ClickLocator", 
				"ProjectGeneralinfo_SecondaryContact_SearchBoxlocator", 
				"ProjectGeneralinfo_SecondaryContact_valueLocator");
	}

	public synchronized void add_select_submit_OtherContact_DropDown() throws InterruptedException 
	{
		Reporter.log("Select Other contact");
		wrapper.WaitForElementThenClick("ProjectGeneralinfo_otherContact_ClickLocator");
		//wrapper.selectByValue("ProjectGeneralinfo_otherContact_ValueLocator", "6204");

		//		wrapper.DynamicDropdownvalueselection("Alpha Beta",
		//				"ProjectGeneralinfo_otherContact_ClickLocator", 
		//				"ProjectGeneralinfo_otherContact_ValueLocator");
	}

	public synchronized void add_select_submit_IndustryCluster_of_project() throws InterruptedException 
	{
		wrapper.dynamic_DropdownspanInputSearchListValidationValueSelection(
				"Apparel and Textiles",
				"ProjectGeneralinfo_IndustryCluster_ClickLocator", 
				"ProjectGeneralinfo_IndustryCluster_SearchBoxlocator", 
				"ProjectGeneralinfo_IndustryCluster_valueLocator");
	}

	public synchronized void add_select_submit_NAICSCode_DropDown() throws InterruptedException 
	{
		Reporter.log("Select NAISC Code contact");
		wrapper.WaitForElementThenClick("ProjectGeneralinfo_NAICSCode_ClickLocator");
		wrapper.click("project_NISC_Code_value");
		//wrapper.selectByValue("ProjectGeneralinfo_NAICSCode_ValueLocator", "19311");

	}
	
	public synchronized void add_select_submit_NAICSCode_DropDown_SCIDA() throws InterruptedException 
	{
		Reporter.log("Select NAISC Code contact");
		wrapper.WaitForElementThenClick("ProjectGeneralinfo_NAICSCode_ClickLocator_scida");
		wrapper.click("project_NISC_Code_value");
		//wrapper.selectByValue("ProjectGeneralinfo_NAICSCode_ValueLocator", "19311");

	}

	public synchronized void add_submit_CommisionerName() throws InterruptedException 
	{
		Reporter.log("Add Commisioner name");
		wrapper.setTextBoxValue_Direct("ProjectGeneralinfo_TextBox_commisioner", generateRandomAlphaNumeric(12));
	}

	public synchronized void add_submit_District() throws InterruptedException 
	{
		Reporter.log("Add District");
		wrapper.setTextBoxValue_Direct("ProjectGeneralinfo_TextBox_district", generateRandomAlphaNumeric(11));
	}

	public synchronized void add_Select_submit_Projectdatetype() throws InterruptedException 
	{
		Reporter.log("Add Project Date type");
		wrapper.isSelectDropdown("Drop_down_projectType");
	}

	public synchronized void add_submit_Projectdate() throws InterruptedException 
	{
		Reporter.log("Add Project Date");
		wrapper.setTextBoxValue_Direct("Text_box_date", wrapper.getCurrentDate_DDMMYYYY());
	}

	public synchronized void add_submit_ProjectdateNotes() throws InterruptedException 
	{
		Reporter.log("Add Project Date notes");
		wrapper.setTextBoxValue_Direct("Text_box_notes", generateRandomAlphaNumeric(30));
	}

	public synchronized void Open_Projectdata_Tab() throws InterruptedException 
	{
		Reporter.log("Open project data tab page");
		wrapper.click("ProjectData_Link_tab");
	}
	
	String projectdescription=(generateRandomAlphaNumeric(30)+ " "+generateRandomAlphaNumeric(30));

	public synchronized void add_submit_Projectdata_Description() throws InterruptedException 
	{
		Reporter.log("Add Project Data Description");
		wrapper.setTextBoxValue_Direct("ProjectData_ProjectDescription_TextBox", projectdescription );
	}
	
	public synchronized void add_submit_Projectdata_process_scida() throws InterruptedException 
	{
		Reporter.log("Add Project benifits process");
		wrapper.setTextBoxValue_Direct("Project_scida_process_textbox", projectdescription );
	}
	
	public synchronized void add_submit_Projectbenifits_IssueAmountRequested_scida() throws InterruptedException 
	{
		String valueissue= generateRandomNumberOfFixLength(4);
		Reporter.log("Add Project benifits amount requested");
		wrapper.setTextBoxValue_Direct("Project_scida_IssueAmountRequested_textbox", valueissue );
	}
	
	public synchronized void add_submit_Projectbenifits_fbr_scida() throws InterruptedException 
	{
		String fbr= generateRandomNumberOfFixLength(4);
		Reporter.log("Add Project benifits fbr");
		wrapper.setTextBoxValue_Direct("Project_scida_FBR_textbox", fbr );
	}
	
	public synchronized void add_submit_Projectbenifits_closedbond_scida() throws InterruptedException 
	{
		String closedbond= generateRandomNumberOfFixLength(4);
		Reporter.log("Add Project benifits close bond");
		wrapper.setTextBoxValue_Direct("Project_scida_ClosedBondIssues_textbox", closedbond );
	}

	
   
	public synchronized String edit_Projectdata_Description() throws InterruptedException, IOException 
	{
		String textvalue= generateRandomAlphaNumeric(30)+ " "+generateRandomAlphaNumeric(30);
		Reporter.log("Add Project Data Description");
		wrapper.setTextBoxValue_Direct("ProjectData_ProjectDescription_TextBox", textvalue );
		
		return textvalue;
		 
	}
	public synchronized void add_select_submit_StagesType_projectData() throws InterruptedException 
	{
		wrapper.waitForElementVisibility("ProjectData_Stages_Drop_down");
		wrapper.click("ProjectData_Stages_Drop_down");
		wrapper.Dropdownvalueselection_WithOption("DropDown_value_Stages","ddnProjectStagesType", "ProjectData_Stages_Drop_down_value");
	}

	public synchronized void add_Submit_Stages_Date_projectdata() throws InterruptedException 
	{
		Reporter.log("Select add Stages Date");
		wrapper.click("ProjectData_Stages_date");
		wrapper.click("ProjectGeneralInfoPage_DateFiled_DummyDate3_value");

	}

	public synchronized void add_Submit_Stages_Notes_projectdata() throws InterruptedException 
	{
		Reporter.log("Enter satges notes");
		wrapper.setTextBoxValue_Direct("ProjectData_Projectdata_projextStages_Notesfield", generateRandomAlphaNumeric(30)+ " "+generateRandomAlphaNumeric(30) );


	}

	public synchronized void add_Select_Construction_start_date() throws InterruptedException 
	{
		Reporter.log("Select Construction start date");
		wrapper.click("ProjectData_StartDate_Date");
		wrapper.click("ProjectGeneralInfoPage_DateFiled_DummyDate3_value");


	}

	public synchronized void add_Select_Construction_End_date() throws InterruptedException 
	{
		Reporter.log("Select construction end date");
		wrapper.click("ProjectData_EndDate_Date");
		wrapper.click("ProjectData_DateFiled_EndDate_value");


	}

	public synchronized void add_Submit_requirmnet_Description() throws InterruptedException 
	{
		Reporter.log("Enter Requirmnet description");
		wrapper.setTextBoxValue_Direct("ProjectData_Projectdata_RequirmnetDescription_TeXtBox", generateRandomAlphaNumeric(30)+ " "+generateRandomAlphaNumeric(30) );



	}

	public synchronized void add_Submit_SpaceRequirmnet_ExistingBuilding_value() throws InterruptedException 
	{
		Reporter.log("Enter value of existing building field");

		wrapper.setTextBoxValue_Direct("ProjectData_Projectdata_ExistingBuilding_Value_TextBox", generateRandomNumberOfFixLength(3) );



	}

	public synchronized void add_Submit_SpaceRequirmnet_ExistingBuilding_Notes() throws InterruptedException 
	{
		Reporter.log("Enter notes of existing building field");
		wrapper.setTextBoxValue_Direct("ProjectData_Projectdata_ExistingBuiiding_Notes_TextBox", generateRandomAlphaNumeric(30) );



	}
	
	public synchronized void add_Submit_SpaceRequirmnet_ExistingBuilding_Notes_scida() throws InterruptedException 
	{
		Reporter.log("Enter notes of existing building field");
		wrapper.setTextBoxValue_Direct("ProjectData_Projectdata_ExistingBuiiding_Notes_TextBox_SCIDA", generateRandomAlphaNumeric(30) );



	}

	public synchronized void open_ProjectBenifits_Tab() throws InterruptedException 
	{
		Reporter.log("Open Project page");
		wrapper.click("ProjectBenifits_Tab_Title_text");


	}

	public synchronized void Enter_ProjectBenifits_InvestmnetNotes() throws InterruptedException 
	{
		Reporter.log("Enter valuw to Investmnet notes");
		wrapper.setTextBoxValue_Direct("ProjectBenifits_InvestmnetNotes_Field_TextBox", generateRandomAlphaNumeric(100) );


	}

	public synchronized void Enter_ProjectBenifits_IncentivesNotes() throws InterruptedException 
	{
		Reporter.log("Enter value to Incentives Notes ");
		wrapper.setTextBoxValue_Direct("ProjectBenifits_IncentivesNotes_Field_TextBox", generateRandomAlphaNumeric(100) );


	}

	public synchronized void Enter_ProjectBenifits_InVestmentInhibitors() throws InterruptedException 
	{
		Reporter.log("Enter value to InVestmentInhibitors");
		wrapper.setTextBoxValue_Direct("ProjectBenifits_InvestmentInhibitors_Field_TextBox", generateRandomAlphaNumeric(100) );


	}

	public synchronized void Enter_ProjectBenifits_InvestmentRational() throws InterruptedException 
	{
		Reporter.log("Enter value to InvestmentRational");
		wrapper.setTextBoxValue_Direct("ProjectBenifits_InvestmentRational_Field_TextBox", generateRandomAlphaNumeric(100) );


	}

	String Realstate= generateRandomNumberOfFixLength(5);
	public synchronized void Enter_ProjectBenifits_Investment_realstate_value() throws InterruptedException 
	{
		Reporter.log("Enter value to Investment_realstate");
		 
		    WebElement element = wrapper.getElement("ProjectBenifits_Investmnet_Realstate_Field_TextBox");
		    element.clear();
		    String val = Realstate; 
		    for (int i = 0; i < val.length(); i++){
		        char c = val.charAt(i);
		        String s = new StringBuilder().append(c).toString();
		        element.sendKeys(s);
		    }   
		Reporter.log("Enter value to Investment_realstate");
//		wrapper.setTextBoxValue_Direct("ProjectBenifits_Investmnet_Realstate_Field_TextBox", Realstate );
		Thread.sleep(1000);


	}
    String inventory= generateRandomNumberOfFixLength(4);
	public synchronized void Enter_ProjectBenifits_Investment_Inventory() throws InterruptedException 
	{
		Reporter.log("Enter value to Investment Inventory");

	    WebElement element = wrapper.getElement("ProjectBenifits_Investmnet_Inventory_Field_TextBox");
	    element.clear();
	    String val = inventory; 
	    for (int i = 0; i < val.length(); i++){
	        char c = val.charAt(i);
	        String s = new StringBuilder().append(c).toString();
	        element.sendKeys(s);
	    }   
		//wrapper.setTextBoxValue_Direct("ProjectBenifits_Investmnet_Inventory_Field_TextBox", inventory );
		Thread.sleep(1000);


	}

	 String machineequipment= generateRandomNumberOfFixLength(4);
	public synchronized void Enter_ProjectBenifits_Investment_MachineandEquipment() throws InterruptedException 
	{
		Reporter.log("Enter value to Machine and equipmnet");
		 WebElement element = wrapper.getElement("ProjectBenifits_Investmnet_MachineandEquipment_Field_TextBox");
		    element.clear();
		    String val = machineequipment; 
		    for (int i = 0; i < val.length(); i++){
		        char c = val.charAt(i);
		        String s = new StringBuilder().append(c).toString();
		        element.sendKeys(s);
		    }   
		//wrapper.setTextBoxValue_Direct("ProjectBenifits_Investmnet_MachineandEquipment_Field_TextBox", machineequipment );
		Thread.sleep(1000);

	}
    
	String FurnitureFixture= generateRandomNumberOfFixLength(3);
	public synchronized void Enter_ProjectBenifits_Investment_FurnitureFixture() throws InterruptedException 
	{
		Reporter.log("Enter value to Furniture and fixture");
		 WebElement element = wrapper.getElement("ProjectBenifits_Investmnet_FurnitureFixtures_Field_TextBox");
		    element.clear();
		    String val = FurnitureFixture; 
		    for (int i = 0; i < val.length(); i++){
		        char c = val.charAt(i);
		        String s = new StringBuilder().append(c).toString();
		        element.sendKeys(s);
		    }   
		//wrapper.setTextBoxValue_Direct("ProjectBenifits_Investmnet_FurnitureFixtures_Field_TextBox", FurnitureFixture);
		Thread.sleep(1000);

	}

	public synchronized void Add_investmnet() throws InterruptedException 
	{
		Reporter.log("Add investmnet");
		wrapper.click("ProjectBenifits_Investmnet_AddButton");


	}
	
	public synchronized void update_investmnet() throws InterruptedException 
	{
		Reporter.log("update investmnet");
		wrapper.click("Project_Benifits_upadte_button");


	}
	public synchronized void Enter_ProjectBenifits_Investment_Amount() throws InterruptedException 
	{
		Reporter.log("Enter value to Investmnet amount");
		wrapper.setTextBoxValue_Direct("ProjectBenifits_Investmentamount_Field_TextBox", generateRandomNumberOfFixLength(3) );


	}

	public synchronized void Enter_ProjectBenifits_Incentive_Amount() throws InterruptedException 
	{
		Reporter.log("Enter value to Incentive amount");
		wrapper.setTextBoxValue_Direct("ProjectBenifits_Incentiveamount_Field_TextBox", generateRandomNumberOfFixLength(3) );


	}
	
	String fulltimenumberemploye=generateRandomNumberOfFixLength(1) ;

	public synchronized void Enter_ProjectBenifits_EmploymnetFullTimeNumber() throws InterruptedException 
	{
		Reporter.log("Enter value to Full Time number");
		wrapper.click("ProjectBenifits_EmploymentFullTimeNumber_TextBox");
		
		
		 WebElement element = wrapper.getElement("ProjectBenifits_EmploymentFullTimeNumber_Value");
		
		    element.clear();
		    String val = fulltimenumberemploye; 
		    for (int i = 0; i < val.length(); i++){
		        char c = val.charAt(i);
		        String s = new StringBuilder().append(c).toString();
		        element.sendKeys(s);
		    }   
		Thread.sleep(100);


	}
      
	String fulltimeemployeesalary=generateRandomNumberOfFixLength(2);
	public synchronized void Enter_ProjectBenifits_EmploymnetFullTimesalary() throws InterruptedException 
	{
		Reporter.log("Enter value to full time salary");
		wrapper.click("ProjectBenifits_EmploymentFullTimeSalary_TextBox");

		
		WebElement element = wrapper.getElement("ProjectBenifits_EmploymentFullTimeSalary_Value");
	    element.clear();
	    String val = fulltimeemployeesalary; 
	    for (int i = 0; i < val.length(); i++){
	        char c = val.charAt(i);
	        String s = new StringBuilder().append(c).toString();
	        element.sendKeys(s);
	    }   
	Thread.sleep(100);


	}
	
	String Managmnetallemployee= generateRandomNumberOfFixLength(1);

	public synchronized void Enter_ProjectBenifits_EmploymnetManagmnetNumber() throws InterruptedException 
	{
		Reporter.log("Enter value to Managmnet Numbers");
		wrapper.click("ProjectBenifits_EmploymentMangmentNumber_TextBox");

		WebElement element = wrapper.getElement("ProjectBenifits_EmploymentMangmentNumber_Value");
	    element.clear();
	    String val = Managmnetallemployee; 
	    for (int i = 0; i < val.length(); i++){
	        char c = val.charAt(i);
	        String s = new StringBuilder().append(c).toString();
	        element.sendKeys(s);
	    }   
	Thread.sleep(100);


	}
     
	String managmnetemployeesalary=generateRandomNumberOfFixLength(2);
	public synchronized void Enter_ProjectBenifits_EmploymnetmangamentSalary() throws InterruptedException 
	{
		Reporter.log("Enter value to Managmnet Salary");
		wrapper.click("ProjectBenifits_EmploymentMangmentSalary_TextBox");
		
		
		WebElement element = wrapper.getElement("ProjectBenifits_EmploymentMangmentSalary_Value");
	    element.clear();
	    String val = managmnetemployeesalary; 
	    for (int i = 0; i < val.length(); i++){
	        char c = val.charAt(i);
	        String s = new StringBuilder().append(c).toString();
	        element.sendKeys(s);
	    }   
	Thread.sleep(100);


	}

	String parttimenumberemployee= generateRandomNumberOfFixLength(1);
	public synchronized void Enter_ProjectBenifits_EmploymnetPartTimeNumber() throws InterruptedException 
	{
		Reporter.log("Enter value to Part Time Number");
		wrapper.click("ProjectBenifits_EmploymentPartTimeNumber_TextBox");
	
		WebElement element = wrapper.getElement("ProjectBenifits_EmploymentPartTimeNumber_Value");
	    element.clear();
	    String val = parttimenumberemployee; 
	    for (int i = 0; i < val.length(); i++){
	        char c = val.charAt(i);
	        String s = new StringBuilder().append(c).toString();
	        element.sendKeys(s);
	    }   
	Thread.sleep(100);


	}

	String parttimeemployeesalary= generateRandomNumberOfFixLength(2);
	public synchronized void Enter_ProjectBenifits_EmploymnetPartTimeSalary() throws InterruptedException 
	{
		Reporter.log("Enter value to Part Time Salary");
		wrapper.click("ProjectBenifits_EmploymentPartTimesalary_TextBox");
	
		WebElement element = wrapper.getElement("ProjectBenifits_EmploymentPartTimesalary_Value");
	    element.clear();
	    String val = parttimeemployeesalary; 
	    for (int i = 0; i < val.length(); i++){
	        char c = val.charAt(i);
	        String s = new StringBuilder().append(c).toString();
	        element.sendKeys(s);
	    }   
	Thread.sleep(100);


	}

	String employeecontractnumber=generateRandomNumberOfFixLength(1) ;
	public synchronized void Enter_ProjectBenifits_EmploymnetContractNumber() throws InterruptedException 
	{
		Reporter.log("Enter value to Contract Numbers");
		wrapper.click("ProjectBenifits_EmploymentContractNumber_TextBox");
		
		WebElement element = wrapper.getElement("ProjectBenifits_EmploymentContractNumber_Value");
	    element.clear();
	    String val = employeecontractnumber; 
	    for (int i = 0; i < val.length(); i++){
	        char c = val.charAt(i);
	        String s = new StringBuilder().append(c).toString();
	        element.sendKeys(s);
	    }   
	Thread.sleep(100);


	}

	    String employeecontractnumbersalary=generateRandomNumberOfFixLength(2);
	public synchronized void Enter_ProjectBenifits_EmploymnetContractSalary() throws InterruptedException 
	{
		Reporter.log("Enter value to Contract Numbers");
		wrapper.click("ProjectBenifits_EmploymentContractSalary_TextBox");
	
		
		WebElement element = wrapper.getElement("ProjectBenifits_EmploymentContractSalary_Value");
	    element.clear();
	    String val = employeecontractnumbersalary; 
	    for (int i = 0; i < val.length(); i++){
	        char c = val.charAt(i);
	        String s = new StringBuilder().append(c).toString();
	        element.sendKeys(s);
	    }   
	Thread.sleep(100);


	}

	public synchronized void add_employmnet_details() throws InterruptedException 
	{
		Reporter.log("Enter value to Contract Numbers");
		wrapper.click("ProjectBenifits_EmploymentAdd_Button");


	}

	String totalemp=generateRandomNumberOfFixLength(2);
	public synchronized void Enter_ProjectBenifits_NumberConstructionJobs() throws InterruptedException 
	{
		Reporter.log("Enter value to Number of Construction jobs");
		wrapper.setTextBoxValue_Direct("ProjectBenifits_NumberOfConstructionJobs_TextBox", totalemp );


	}
   String wages= generateRandomNumberOfFixLength(3);
	public synchronized void Enter_ProjectBenifits_WorkerWages() throws InterruptedException 
	{
		Reporter.log("Enter value to Worker wages");
		wrapper.setTextBoxValue_Direct("ProjectBenifits_Workerwages_TextBox", wages );


	}
  String consjobs= generateRandomNumberOfFixLength(3);
	public synchronized void Enter_ProjectBenifits_ConstructionJobs() throws InterruptedException 
	{
		Reporter.log("Enter value to Construction jobs");
		wrapper.setTextBoxValue_Direct("ProjectBenifits_ConstructionJobs_TextBox", consjobs );


	}
    String totaljobs=generateRandomNumberOfFixLength(3);
	public synchronized void Enter_ProjectBenifits_TotalJobs() throws InterruptedException 
	{
		Reporter.log("Enter value to Total Jobs Created");
		wrapper.setTextBoxValue_Direct("ProjectBenifits_TotalJobsCreated_TextBox", totaljobs );


	}

	///////******************************************


	public synchronized void Select_ProjectResource_Type() throws InterruptedException 
	{
		Reporter.log("Select value from resource type drop down");
		wrapper.click("ProjectResources_DropDown_Documnettype");
		wrapper.Dropdownvalueselection_WithOption("DropDown_value_Resource","ddnTabSection", "ProjectResources_DropDown_DocumnetValue");


	}

	String resourcedescription= generateRandomNumberOfFixLength(35);
	public synchronized void Enter_ProjectResource_DocumentDescription() throws InterruptedException 
	{
		Reporter.log("Enter value to Document description Text Box");
		wrapper.setTextBoxValue_Direct("ProjectResources_Description_Field_TextBox", resourcedescription );


	}
	
	String projectresourcekeyword=generateRandomNumberOfFixLength(20);

	public synchronized void Enter_ProjectResource_Keyword() throws InterruptedException 
	{
		Reporter.log("Enter value to Keyword Text Box");
		wrapper.setTextBoxValue_Direct("ProjectResources_Keword_Field_TextBox", projectresourcekeyword );
		wrapper.sendKeys("ProjectResources_Keword_Field_TextBox");
		


	}

	public synchronized void ResourceTabDataEnter_uploadFile() throws InterruptedException 
	{

	wrapper.click("Project_resources_upload_doc");
	wrapper.click("Project_resources_upload_Localdoc_link_on_PopUp");   
	this.element=wrapper.getElement("ProjectResources_UploadFile_Field_TextBox");
		element.sendKeys(System.getProperty("user.dir") +File.separator+"qa.pdf");
		Thread.sleep(1000);
		wrapper.click("Project_resources_select_Upload_attached_button");
		Thread.sleep(1000);
		wrapper.click("Project_resources_upload_doc");
		wrapper.click("Project_resources_upload_libracryDoc_link_on_PopUp"); 
		wrapper.click("Project_resources_select_doc_from_library");
		wrapper.click("Project_resources_select_Upload_attached_button");
		
	}

	/////********************Project interaction***************

	public synchronized void Select_ProjectInteraction_NoteType() throws InterruptedException 
	{
		Reporter.log("Select value from resource type drop down");
		wrapper.click("ProjectInteractionNotes_NoteType_DropDown_Field");
		wrapper.Dropdownvalueselection_WithOption("DropDown_value_NoteType","InteractionType", "ProjectInteractionNotes_NoteType_DropDown_value");


	}

	String Projectinteractiondescription= generateRandomNumberOfFixLength(20) ;
	public synchronized void Enter_ProjectInteraction_Keyword() throws InterruptedException 
	{
		Reporter.log("Enter value to Description Text Box");
		wrapper.setTextBoxValue_Direct("ProjectInteractionNotes_Description_Field_TextBox", Projectinteractiondescription );


	}

	public synchronized void add_select__Attendee_DropDown() throws InterruptedException 
	{
		Reporter.log("Select Other contact");
		//wrapper.waitForElementVisibility("ProjectInteractionNotes_Attendee_DropDown");
		wrapper.click("ProjectInteractionNotes_Attendee_DropDown");
		wrapper.Dropdownvalueselection( "DropDown_value_Attendees", "Attendies_listbox","ProjectInteractionNotes_Attendee_DropDownValue" );
	}
    String Projectinteractionshortdescription= generateRandomNumberOfFixLength(12);
	public synchronized void Enter_ProjectInteraction_sortDescription() throws InterruptedException 
	{
		Reporter.log("Enter value to short Description Text Box");
		wrapper.setTextBoxValue_Direct("ProjectInteractionNotes_File_TextBox", Projectinteractionshortdescription );


	}

	public synchronized void ProjectInteraction_uploadDocfile() throws InterruptedException 
	{
		this.element=wrapper.getElement("ProjectInteractionNotes_UploadFile_Field_TextBox");
		element.sendKeys(System.getProperty("user.dir") +File.separator+"qa.pdf");


	}

	public synchronized void add_select_Company_DropDown() throws InterruptedException 
	{
		Reporter.log("Select Other contact");
		//	wrapper.Dropdownvalueselection( "DropDown_value_company", "ddlNoteCompany_listbox","ProjectInteractionNotes_Company_DropDownValue" );
		wrapper.dynamic_DropdownspanInputSearchListValidationValueSelection(
				"Nabisco, Inc.",
				"ProjectGeneralinfo_inote_Company_ClickLocator", 
				"ProjectGeneralinfo_inote_Company_SearchBoxlocator", 
				"ProjectGeneralinfo_inote_Company_valueLocator");
	}
	
	public synchronized void add_select_Company_DropDown(String companyname) throws InterruptedException 
	{
		Reporter.log("Select Other contact");
		//	wrapper.Dropdownvalueselection( "DropDown_value_company", "ddlNoteCompany_listbox","ProjectInteractionNotes_Company_DropDownValue" );
		wrapper.dynamic_DropdownspanInputSearchListValidationValueSelection(
				companyname,
				"ProjectGeneralinfo_inote_Company_ClickLocator", 
				"ProjectGeneralinfo_inote_Company_SearchBoxlocator", 
				"ProjectGeneralinfo_inote_Company_valueLocator");
	}

	//////////////*********************Project task*******************************

	String TaskName= generateRandomStringOfFixLength(15);
	public synchronized void Enter_ProjectTask_TaskName() throws InterruptedException 
	{
		Reporter.log("Enter value to short Description Text Box");
		wrapper.setTextBoxValue_Direct("ProjectTask_TaskName_Field_TextBox", TaskName );


	}

	public synchronized void add_Select_TaskStart_date() throws InterruptedException 
	{
		Reporter.log("Select Task Start date");
		wrapper.click("ProjectTask_ConstructionStartDate_Field_Box");
		wrapper.click("ProjectGeneralInfoPage_checkbox_RFI_dateValue");


	}

	public synchronized void add_Select_TaskDue_date() throws InterruptedException 
	{
		Reporter.log("Select Task Start date");
		wrapper.click("ProjectTask_DueDate_Field_Box");
		wrapper.click("ProjectData_DateFiled_EndDate_value");


	}

	public synchronized void add_select_RecordStatus_DropDown() throws InterruptedException 
	{
		Reporter.log("Select Record Status");
		//		wrapper.Dropdownvalueselection( "DropDown_value_status", "ddnTaskStatus","ProjectTask_RecordStatus_DropDown" );
		wrapper.waitForElementVisibility("ProjectTask_RecordStatus_DropDown");
		wrapper.deselectByValue("ProjectTask_RecordStatus_DropDown", "7");
	}

	public synchronized void Enter_ProjectTask_phase() throws InterruptedException 
	{
		Reporter.log("Enter value to short Description Text Box");
		//wrapper.setTextBoxValue_Direct("ProjectTask_Phase_Field_TextBox", generateRandomNumberOfFixLength(1) );


	}
	
	
	public synchronized void Enter_ProjectTaskAssigne() throws InterruptedException 
	{
		Reporter.log("Select value by assigne");
	    wrapper.click("project_dafc_assigne_value_for_task");
		wrapper.selectByValue("project_dafc_assigne_value_for_task", "986b6e7d-4d0d-4d56-95b6-c7a1877fbb6c");

	}
	
	public synchronized void Enter_ProjectTaskAssigne_scida() throws InterruptedException 
	{
		Reporter.log("Select value by assigne");
	    wrapper.click("project_dafc_assigne_value_for_task");
		wrapper.selectByValue("project_dafc_assigne_value_for_task", "aa61be0c-e295-4d86-a7c3-36954cb2b6f1");

	}
	


	public synchronized void Validate_Task_created() throws InterruptedException 
	{
		GenericWebTableFunctions GenericWebTableFunctions =new GenericWebTableFunctions();
		Reporter.log("Validate project has been created");
		//wrapper.waitForBrowserToLoadCompletely();
		//wrapper.click("ProjectTask_Tab_Title");
		System.out.println();
		String locatorType = json.getLocator("ProjectTask_TaskName_value")[0];
		String locatorValue = json.getLocator("ProjectTask_TaskName_value")[1];
		By locator = wrapper.getLocatorBy("ProjectTask_TaskName_value", locatorType, locatorValue);

		String Tasknametitle= GenericWebTableFunctions.getCellData( locator, 1, 1);
		System.out.println("as shown on title"+ Tasknametitle);
		System.out.println("as passed value"+ TaskName);
		Assert.assertEquals(TaskName, Tasknametitle);

		//		 wrapper.click("ModalBox_Dashboard");
		//		 String TaskNameonDashboard= wrapper.getInnerText("DashboardTask_listing_TasknameCreated");	
		//		 String ProjectnameonDashboard=	 wrapper.getInnerText("DashboardTask_listing_projectnameCreated");
		//		 System.out.println("as passed valuetask second"+ TaskNameonDashboard);
		//		 System.out.println("as passed value project second"+ ProjectnameonDashboard);
		//		 Assert.assertEquals(TaskName, Tasknametitle);
		//		 Assert.assertEquals(TaskName, TaskNameonDashboard);
		//		 Assert.assertEquals(projectname, ProjectnameonDashboard);




	}

	public synchronized void verifiy_all_tabs_are_visible() throws IOException{

		Reporter.log("Validate all tabs are visible");
		wrapper.click("Link_Project_Managment_page");
		wrapper.validateInnerText("Link_text_general_information","ExpectedTestGeneralinformation");
		wrapper.validateInnerText("Link_text_project_data","ExpectedTextProjectData");
		wrapper.validateInnerText("Link_text_Resources","ExpectedTextResources");
		wrapper.validateInnerText("Link_text_Interaction_notes","ExpectedTextInteractionNotes");
		wrapper.validateInnerText("Link_text_Task","ExpectedTextTask");
		wrapper.validateInnerText("Link_text_Project_benifits","ExpectedTextProjectBenefits");



	}
	
	public synchronized void verifiy_all_tabs_are_visible_scida() throws IOException{

		Reporter.log("Validate all tabs are visible");
		wrapper.click("Link_Project_Managment_page");
		wrapper.validateInnerText("Link_text_general_information_scida","ExpectedTestGeneralinformation");
		wrapper.validateInnerText("Link_text_project_data_scida","ExpectedTextProjectData");
		wrapper.validateInnerText("Link_text_Resources_scida","ExpectedTextResources");
		wrapper.validateInnerText("Link_text_Interaction_notes_scida","ExpectedTextInteractionNotes");
		wrapper.validateInnerText("Link_text_Task_scida","ExpectedTextTask");
		wrapper.validateInnerText("Link_text_Project_benifits_scida","ExpectedTextProjectBenefits");



	}

	public synchronized void verifiy_all_fileds_are_visible() throws IOException{

		Reporter.log("Validate all tabs are visible");
		wrapper.click("Link_Project_Managment_page");
		wrapper.validateInnerText("Link_text_general_information_scida","ExpectedTestGeneralinformation");
		wrapper.validateInnerText("Link_text_project_data","ExpectedTextProjectData");
		wrapper.validateInnerText("Link_text_Resources","ExpectedTextResources");
		wrapper.validateInnerText("Link_text_Interaction_notes","ExpectedTextInteractionNotes");
		wrapper.validateInnerText("Link_text_Task","ExpectedTextTask");
		wrapper.validateInnerText("Link_text_Project_benifits","ExpectedTextProjectBenefits");



	}

	public synchronized void isGeneralInformationTabDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate View General info  page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("Projectgeneralinfopage_text_Header_general_info", "ExpectedGeneralInformationTabtext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isCompanyInformationsectionDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validatecompany info section is visible on page is displayed");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("Projectgeneralinfopage_text_Header_company_info", "ExpectedCompanyInformationTabtext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isProjectnamefiledDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate project name filed is visible on general info page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("Projectgeneralinfopage_field_Title_Projectname", "ExpectedProjectnamefiledtitletext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void iscategorydropdownfiledDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate project name filed is visible on general info page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("Projectgeneralinfopage_field_Title_Category", "ExpectedCategoryfiledtitletext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isProjectManagerdropdownfiledDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate project name filed is visible on general info page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("Projectgeneralinfopage_field_Title_ProjectManager", "ExpectedProjectManagerDropDowntitletext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isCompanydropdownfiledDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate company name filed is visible on general info page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			Thread.sleep(1000);
			wrapper.validateInnerText("Projectgeneralinfopage_field_Title_Company", "ExpectedCompanyDropDowntitletext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}
	
	
	public synchronized void isCompanydropdownfiledDisplayed_dafc() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate company name filed is visible on general info page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			Thread.sleep(1000);
			wrapper.validateInnerText("Projectgeneralinfopage_field_Title_Company_dafc", "ExpectedCompanyDropDowntitletext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}
	public synchronized void isCompanydropdownfiledDisplayed_scida() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate company name filed is visible on general info page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			Thread.sleep(1000);
			wrapper.validateInnerText("Projectgeneralinfopage_field_Title_Company_scida", "ExpectedCompanyDropDowntitletext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isPrimaryContactPersondropdownfiledDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Primary Contact field is visible on general info page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");

			wrapper.validateInnerText("Projectgeneralinfopage_field_Title_Primary_contact_person", "ExpectedPrimaryContactpersonDropDowntitletext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isSecondaryContactPersondropdownfiledDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Secondary Contact filed is visible on general info page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			Thread.sleep(50000);
			wrapper.validateInnerText("Projectgeneralinfopage_field_Title_Secondary_contact_person", "ExpectedSecondaryContactpersonDropDowntitletext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isOtherContactdropdownfiledDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Other Contact field is visible on general info page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("Projectgeneralinfopage_field_Title_Other_contact_person", "ExpectedSecondaryOtherpersonDropDowntitletext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isIndustryClusterdropdownfiledDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Industry Cluster filed is visible on general info page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("Projectgeneralinfopage_field_Title_Industry_cluster", "ExpectedSecondaryIndustryClusterDropDowntitletext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isNAICSCodedropdownfiledDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate NAICS Code filed is visible on general info page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("Projectgeneralinfopage_field_Title_NAICS_Code", "ExpectedSecondaryNAICSCODEDropDowntitletext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isCommissionerNamefiledDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate commisioner name filed is visible on general info page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("Projectgeneralinfopage_field_Title_CommissionerName", "ExpectedSecondaryCommissonerfieldtitletext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isDistricfieldDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate District filed is visible on general info page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("Projectgeneralinfopage_field_Title_Distric", "ExpectedSecondaryDistricfieldtitletext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isProjectDatesectionDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Project Date filed is visible on general info page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("Projectgeneralinfopage_section_Project_date", "ExpectedSecondaryProjectDateSectiontitletext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isVisibilityfieldDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Visibility filed is visible on general info page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("Projectgeneralinfopage_section_Project_Visibility", "ExpectedSecondaryProjectVisibilitytitletext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isTagsfieldDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Tag filed is visible on general info page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("Projectgeneralinfopage_section_Project_tags", "ExpectedSecondaryProjectTagstitletext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}
	public synchronized void isTagsfieldDisplayed_dafc() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Tag filed is visible on general info page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("Projectgeneralinfopage_section_Project_tags_dafc", "ExpectedSecondaryProjectTagstitletext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isProjectNotesfieldDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Notes filed is visible on general info page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("Projectgeneralinfopage_section_Project_notes", "ExpectedSecondaryProjectNotestitletext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isCommunicationInformationSectionDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Comunication section  is visible on general info page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("Projectgeneralinfopage_section_Communication_information", "ExpectedSecondaryCommunicationInformationtitletext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isphoneGridfieldDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Phone Grid filed is visible on general info page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("Projectgeneralinfopage_field_phone", "ExpectedSecondaryPhonetitletext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isEmailGridfieldDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Email Grid is visible on general info page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("Projectgeneralinfopage_Title_Email_section", "ExpectedSecondaryEmailtitletext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isAddressGridfieldDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Address filed is visible on general info page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("Projectgeneralinfopage_Title_Address_section", "ExpectedSecondaryAddresstitletext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isURLGridfieldDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate URL filed is visible on general info page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("Projectgeneralinfopage_Title_URL_section", "ExpectedSecondaryURLtitletext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isExtraString3fieldDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Extra String 3 filed is visible on general info page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("Projectgeneralinfopage_Title_Extrastrin3_Field", "ExpectedSecondaryExtraStringField3titletext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isDumyDate3fieldDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Dummy Date 3 filed is visible on general info page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("Projectgeneralinfopage_Title_DummyDate3_Field", "ExpectedSecondaryDummyDate3titletext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isResponseRFIGridDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Resopnse RFI filed is visible on general info page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("Projectgeneralinfopage_Title_ResponseRFI_Grid", "ExpectedSecondaryResponseRFItitletext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isRFIDateFieldDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate RFI Date filed is visible on general info page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("Projectgeneralinfopage_Title_RFIDate_field", "ExpectedSecondaryRFIDatetitletext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isRFIProjectSourceDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Project Source filed is visible on general info page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("Projectgeneralinfopage_Title_RFISource_field", "ExpectedSecondaryProjectSourcetitletext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isRFICreatedByDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate RFI filed is visible on general info page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("Projectgeneralinfopage_Title_RFICreatedBy_field", "ExpectedSecondaryProjecCreatedbytitletext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isParentCompanyByDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Parent Company filed is visible on general info page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("Projectgeneralinfopage_Title_ParentCompany_field", "ExpectedParentCompanytitletext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isFEINByDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate FEIN is visible on general info page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("Projectgeneralinfopage_Title_FEIN_field", "ExpectedFEINtitletext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}


	//**************project tab page******************************************

	public synchronized void isProjectTabDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Project Tab is visible on project data page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("ProjectData_Link_tab", "ExpectedProjectDataTabtext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isProjectinformationsectionTitleDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Project Information section is visible on project data page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("ProjectData_Projectinformation_section_Title", "ExpectedProjectInformationsectionTitletext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isProjectDescriptionFiledDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Description is visible on project data page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("ProjectData_ProjectDescription_field_Title", "ExpectedProjectDescriptionfieldTitletext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isProjectStagesSectionDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate stages is visible on project data page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			//wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateElementInnerTextContains("ProjectData_Projectstages_sectionTitle", "ExpectedProjectStagesSectionTitletext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isProjectDateofContactDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Date of contact is visible on project data page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateElementInnerTextContains("ProjectData_Projectdata_Dateofcontact_text", "ExpectedProjectSDateofContactSectionTitletext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isProjectDataStartDateDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate start date is visible on project data page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateElementInnerTextContains("ProjectData_Projectdata_ConstructionstartDate_StartDateField_title", "ExpectedProjectStartDateTitletext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isProjectDataEndDateDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate End date is visible on project data page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("ProjectData_Projectdata_EndDateField_title", "ExpectedProjectEndDateTitletext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isProjectDataRequirementDescriptionDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Requirmnet description is visible on project data page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("ProjectData_Projectdata_RequirmnetDescription_title", "ExpectedProjectRequirementDescriptionTitletext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isProjectDataSpaceRequirmentDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Space Requirment is visible on project data page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("ProjectData_Projectdata_SpaceRequirements_TitleText", "ExpectedProjectSpaceRequirementsTitletext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isProjectDataExistingBuildingDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Existing Building is visible on project data page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("ProjectData_Projectdata_ExistingBuilding_TitleText", "ExpectedProjectExistingBuildingTitletext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isProjectDataspaceRequirmentFirstRowTitleDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate space Requirment First Row is visible on project data page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("ProjectData_Projectdata_Spacerequirment_firstrow_name_Title", "ExpectedProjectSpaceRequirmentFirstRowTitletext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isProjectDataspaceRequirmentSecondRowTitleDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate space Requirment Second Row is visible on project data page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("ProjectData_Projectdata_Spacerequirment_SecondRow_Value_Title", "ExpectedProjectSpaceRequirmentSecondRowTitletext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isProjectDataspaceRequirmentThirdRowTitleDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate space Requirment Third Row is visible on project data page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("ProjectData_Projectdata_Spacerequirment_ThirdRow_Value_Title", "ExpectedProjectSpaceRequirmentThirdRowTitletext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isProjectDataspaceRequirmentFourthRowTitleDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate space Requirment Fourth Row is visible on project data page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("ProjectData_Projectdata_Spacerequirment_FourthRow_Value_Title", "ExpectedProjectSpaceRequirmentFourthRowTitletext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void validate_fields_under_ProjectData_Enabled() throws InterruptedException {
		Reporter.log("Validate  filed is enabled on Project data page");

		Reporter.log("Validate Description Text box is enabled");
		wrapper.validateElementVisibleandEnabled("ProjectData_ProjectDescription_TextBox");
		Reporter.log("Validate Date of contact date field is enabled");
		//wrapper.validateElementVisibleandEnabled("ProjectData_Projectdata_Dateofcontact_datefield");
		Reporter.log("Validate Stages Notes Text Box is enabled");
		//wrapper.validateElementVisibleandEnabled("ProjectData_Projectdata_projextStages_Notesfield");
		Reporter.log("Validate Requirmnet Description Text box is enabled");
		wrapper.validateElementVisibleandEnabled("ProjectData_Projectdata_RequirmnetDescription_TeXtBox");
		Reporter.log("Validate Construction Date Field is enabled");
		wrapper.validateElementVisibleandEnabled("ProjectData_Projectdata_ConstrutionStartDate_FieldBox");
		Reporter.log("Validate Existing Building Value  Text box is enabled");
		wrapper.validateElementVisibleandEnabled("ProjectData_Projectdata_ExistingBuilding_Value_TextBox");



	}
	//********************Project Benifits Page**********************************

	public synchronized void isProjectBenifitsTitleDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Project Benifits is visible on project Benifits page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("ProjectBenifits_Tab_Title_text", "ExpectedProjectBenifitsTabtext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isProjectBenifitsInvestmnetInformationTitleDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Investmnet information  is visible on project Benifits page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("ProjectBenifits_InvestmnetInformation_section_Title_text", "ExpectedProjectBenifitsInvestmnetInformationtext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isProjectBenifitsInvestmentNotesFieldDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Investmnet notes  is visible on project Benifits page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("ProjectBenifits_InvestmnetNotes_Field_Title_text", "ExpectedProjectBenifitsInvestmnettext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isProjectBenifitsIcentivesNotesFieldDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Incentive notes  is visible on project Benifits page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("ProjectBenifits_IncentivesNotes_Field_Title_text", "ExpectedProjectBenifitsIncentiveNotestext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isProjectBenifitsIcentivesInhibitorsFieldDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Investmnet inhibitors  is visible on project Benifits page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("ProjectBenifits_InvestmentInhibitors_Field_Title", "ExpectedProjectBenifitsIncentiveInhibitorstext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isProjectBenifitsIcentivesRationaleFieldDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Investmnet Rational is visible on project Benifits page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("ProjectBenifits_InvestmentRationale_Field_Titletext", "ExpectedProjectBenifitsIncentiveRationaletext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isProjectBenifitsInvestmnetAmountFieldDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Investmnet Amount is visible on project Benifits page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("ProjectBenifits_Investmentamount_Field_Title", "ExpectedProjectBenifitsInvestmnetAmounttext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isProjectBenifitsIncentiveAmountFieldDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Incentive Amount is visible on project Benifits page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("ProjectBenifits_Incentiveamount_Field_Title", "ExpectedProjectBenifitsIncentiveAmounttext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isProjectBenifitsInvestmentTypeFieldDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Investmnet Type is visible on project Benifits page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("ProjectBenifits_InvestmentType_Field_TextBox", "ExpectedProjectBenifitsInvestmentTypetext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isProjectBenifitsInvestmentSourceFieldDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Investmnet Source is visible on project Benifits page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateElementInnerTextContains("ProjectBenifits_InvestmentSource_Field_TextBox", "ExpectedProjectBenifitsInvestmentSourcetext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isProjectBenifitsAmountFieldDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Fee amount is visible on project Benifits page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateElementInnerTextContains("ProjectBenifits_PrjectFeeAmount_Field_Title", "ExpectedProjectBenifitsProjectFeeAmounttext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isProjectBenifitsFeeCollectedFieldDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Fee collected  is visible on project Benifits page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateElementInnerTextContains("ProjectBenifits_PrjectFeeCollected_Field_Title", "ExpectedProjectBenifitsProjectFeeCollectedtext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isProjectBenifitEmploymnetInfosectionFieldDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Fee collected  is visible on project Benifits page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateElementInnerTextContains("ProjectBenifits_EmploymnetSection_Field_Title", "ExpectedProjectBenifitsEmploymentInfoSectionTitletext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isProjectBenifitJobTypeTitleDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Fee collected  is visible on project Benifits page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateElementInnerTextContains("ProjectBenifits_JobType_Table_Title", "ExpectedProjectBenifitsJobTypeTableTitle");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isProjectBenifitNumberOfConstructionJobDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Fee collected  is visible on project Benifits page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateElementInnerTextContains("ProjectBenifits_NumberOfConstructionJobs_Title", "ExpectedProjectBenifitsNumberofConstructionJobTitle");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isProjectBenifitConstrutionWorkerWagesDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Fee collected  is visible on project Benifits page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateElementInnerTextContains("ProjectBenifits_Workerwages_Title", "ExpectedProjectBenifitsWorkerWagesbTitle");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isProjectBenifitConstrutionJobsTypeDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Fee collected  is visible on project Benifits page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateElementInnerTextContains("ProjectBenifits_PeriodJobs_TextBox", "ExpectedProjectBenifitsPeriodJobsTitle");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isProjectBenifitTotalConstrutionWagesTypeDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Fee collected  is visible on project Benifits page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateElementInnerTextContains("ProjectBenifits_TotalConstructionWages_Title", "ExpectedProjectBenifitsTotalConstructionWagesTitle");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isProjectBenifitTotalJobsCreatedDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Fee collected  is visible on project Benifits page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateElementInnerTextContains("ProjectBenifits_TotalJobsCreated_Title", "ExpectedProjectBenifitsTotalJobsCreatedTitle");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isProjectBenifitDummyField4Displayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Fee collected  is visible on project Benifits page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateElementInnerTextContains("ProjectBenifits_DummyFiled4_Title", "ExpectedProjectBenifitsDummyField4Title");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void validate_fields_under_ProjectBenifits_Enabled() throws InterruptedException {
		Reporter.log("Validate  filed is enabled on Project data page");

		Reporter.log("Validate Investment Text box is enabled");
		//wrapper.validateElementVisibleandEnabled("ProjectBenifits_InvestmnetNotes_Field_TextBox");
		Reporter.log("Validate Incentive Text box is enabled");
		//wrapper.validateElementVisibleandEnabled("ProjectBenifits_IncentivesNotes_Field_TextBox");
		Reporter.log("Validate Inhibitors Text box is enabled");
		//wrapper.validateElementVisibleandEnabled("ProjectBenifits_InvestmentInhibitors_Field_TextBox");
		Reporter.log("Validate Inhibitors Text box is enabled");
		//wrapper.validateElementVisibleandEnabled("ProjectBenifits_InvestmentRational_Field_TextBox");
		Reporter.log("Validate Investmnet Amount Text box is enabled");
		//wrapper.validateElementVisibleandEnabled("ProjectBenifits_Investmentamount_Field_TextBox");
		Reporter.log("Validate Incentive Amount Text box is enabled");
		//wrapper.validateElementVisibleandEnabled("ProjectBenifits_Incentiveamount_Field_TextBox");
		Reporter.log("Validate Number of construction Jobs Text box is enabled");
		wrapper.validateElementVisibleandEnabled("ProjectBenifits_NumberOfConstructionJobs_TextBox");
		Reporter.log("Validate Construction worker wages Text box is enabled");
		wrapper.validateElementVisibleandEnabled("ProjectBenifits_Workerwages_TextBox");
		Reporter.log("Validate Construction  Jobs Text box is enabled");
		wrapper.validateElementVisibleandEnabled("ProjectBenifits_ConstructionJobs_TextBox");



	}

	public synchronized void validate_fields_under_ProjectBenifits_Enabled_scida() throws InterruptedException {
		Reporter.log("Validate  filed is enabled on Project data page");

		Reporter.log("Validate Investment Text box is enabled");
		//wrapper.validateElementVisibleandEnabled("ProjectBenifits_InvestmnetNotes_Field_TextBox");
		Reporter.log("Validate Incentive Text box is enabled");
		//wrapper.validateElementVisibleandEnabled("ProjectBenifits_IncentivesNotes_Field_TextBox");
		Reporter.log("Validate Inhibitors Text box is enabled");
		//wrapper.validateElementVisibleandEnabled("ProjectBenifits_InvestmentInhibitors_Field_TextBox");
		Reporter.log("Validate Inhibitors Text box is enabled");
		//wrapper.validateElementVisibleandEnabled("ProjectBenifits_InvestmentRational_Field_TextBox");
		Reporter.log("Validate Investmnet Amount Text box is enabled");
		//wrapper.validateElementVisibleandEnabled("ProjectBenifits_Investmentamount_Field_TextBox");
		Reporter.log("Validate Incentive Amount Text box is enabled");
		//wrapper.validateElementVisibleandEnabled("ProjectBenifits_Incentiveamount_Field_TextBox");
		Reporter.log("Validate Number of construction Jobs Text box is enabled");
		wrapper.validateElementVisibleandEnabled("ProjectBenifits_NumberOfConstructionJobs_TextBox");
		Reporter.log("Validate Construction worker wages Text box is enabled");
		wrapper.validateElementVisibleandEnabled("ProjectBenifits_Workerwages_TextBox");



	}


	//////**********************************Resources Tab page****************************************


	public synchronized void isResourcestabDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Project Benifits is visible on project Benifits page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("ProjectResources_Title", "ExpectedResourcesTabtext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isResourcesDescriptionFieldDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Project Benifits is visible on project Benifits page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("ProjectResources_Description_Field_Title", "ExpectedResourcesDescriptionFieldTitletext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isResourcesKeywordFieldDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Project Benifits is visible on project Benifits page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("ProjectResources_Keword_Field_Title", "ExpectedResourcesKeywordFieldTitletext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isResourcesUploadFileFieldDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Project Benifits is visible on project Benifits page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("ProjectResources_UploadFile_Field_TextBox", "ExpectedResourcesUploadfileFieldTitletext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}
	
	public synchronized void isResourcesUploadFileFieldDisplayed_scida() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Project Benifits is visible on project Benifits page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("ProjectResources_UploadFile_Field_TextBox_scida", "ExpectedResourcesUploadfileFieldTitletext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}



	public synchronized void validate_fields_under_ResourceTab_Enabled() throws InterruptedException {
		Reporter.log("Validate  filed is enabled on Project data page");

		Reporter.log("Validate DocumnetType Drop Down is enabled");
		wrapper.validateElementVisibleandEnabled("ProjectResources_DropDown_Documnettype");
		Reporter.log("Validate Description Text Box is enabled");
		wrapper.validateElementVisibleandEnabled("ProjectResources_Description_Field_TextBox");
		Reporter.log("Validate Keyword Text Box is enabled");
		//wrapper.validateElementVisibleandEnabled("ProjectResources_Keword_Field_TextBox");




	}

	/////**************************Interaction Tab page**************************************

	public synchronized void isInteractiontabDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Interaction Tab is Visible on  page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("ProjectInteractionNotes_Tab_Title", "ExpectedInteractionTabtext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isInteractionNoteTypeDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Interaction Note Type is Visible on  page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("ProjectInteractionNotes_NoteType_DropDown_title", "ExpectedNoteTypetext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isInteractionAuthorDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Interaction Author is Visible on  page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("ProjectInteractionNotes_Author_Field_titleText", "ExpectedAuthortext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isInteractionDateDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Interaction Date is Visible on  page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("ProjectInteractionNotes_Date_Field_titleText", "ExpectedDatetext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}
	
	public synchronized void isInteractionDateDisplayed_scida() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Interaction Date is Visible on  page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("ProjectInteractionNotes_Date_Field_titleText_scida", "ExpectedDatetext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isInteractionDescriptionDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Description is Visible on  page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("ProjectInteractionNotes_Description_Field_titleText", "ExpectedDescriptiontext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}
	
	public synchronized void isInteractionDescriptionDisplayed_scida() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Description is Visible on  page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("ProjectInteractionNotes_Description_Field_titleText_scida", "ExpectedDescriptiontext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isInteractionDescriptionDisplayed_dafc() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Description is Visible on  page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("ProjectInteractionNotes_Description_Field_titleText_dafc", "ExpectedDescriptiontext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isInteractionAttendeeDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Attendee is Visible on  page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("ProjectInteractionNotes_Attendee_Field_Title", "ExpectedAtendeetext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isInteractionShortDescriptionDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Short Description is Visible on  page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("ProjectInteractionNotes_ShortDescription_Field_Title", "ExpectedShortDescriptiontext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isInteractionFileDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate File field is Visible on  page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("ProjectInteractionNotes_File_Field_Title", "ExpectedFiletext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}
	
	public synchronized void isInteractionFileDisplayed_scida() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate File field is Visible on  page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("ProjectInteractionNotes_File_Field_Title_scida", "ExpectedFiletext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}
	
	public synchronized void isInteractionFileDisplayed_dafc() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate File field is Visible on  page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("ProjectInteractionNotes_File_Field_Title_dafc", "ExpectedFiletext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isInteractionCompanyDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate File field is Visible on  page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("ProjectInteractionNotes_Company_Title", "ExpectedCompanytext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}
	
	public synchronized void isInteractionCompanyDisplayed_scida() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate company field is Visible on  page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("ProjectInteractionNotes_Company_Title_scida", "ExpectedCompanytext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}
	
	public synchronized void isInteractionCompanyDisplayed_dafc() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate company field is Visible on  page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("ProjectInteractionNotes_Company_Title_dafc", "ExpectedCompanytext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}



	public synchronized void validate_fields_under_InteractionTab_Enabled() throws InterruptedException {
		Reporter.log("Validate  filed is enabled on Project data page");

		Reporter.log("Validate Note Type Drop Down is enabled");
		wrapper.validateElementVisibleandEnabled("ProjectInteractionNotes_NoteType_DropDown_Field");
		Reporter.log("Validate Descriptions Text field is enabled");
		wrapper.validateElementVisibleandEnabled("ProjectInteractionNotes_Description_Field_TextBox");
		Reporter.log("Validate short Descriptions Text field is enabled");
		//wrapper.validateElementVisibleandEnabled("ProjectInteractionNotes_File_TextBox");
		Reporter.log("Validate File Upload Button  is enabled");
		//wrapper.validateElementVisibleandEnabled("ProjectInteractionNotes_fileUpload_Button");


	}


	////***************************************Task Tab Page******************************************

	public synchronized void isTaskabDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Task Tab is Visible on  page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("ProjectTask_Tab_Title", "ExpectedTaskTabtext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isTaskNameFieldbDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Task Tab is Visible on  page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText( "ProjectTask_TaskName_Field_Title", "ExpectedTaskNametext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isStartDateFieldbDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Task Tab is Visible on  page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText( "ProjectTask_ConstructionStartDate_Field_Title", "ExpectedStartDatetext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}
	
	public synchronized void isStartDateFieldbDisplayed_scida() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Task Tab is Visible on  page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText( "ProjectTask_ConstructionStartDate_Field_Title_scida", "ExpectedStartDatetext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isDueDateFieldbDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Task Tab is Visible on  page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("ProjectTask_DueDate_Field_Title", "ExpectedDueDatetext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isAssignedToFieldbDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Task Tab is Visible on  page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("ProjectTask_AssignedTo_Field_Title", "ExpectedAssignedTotext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isRecordStatusFieldbDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Task Tab is Visible on  page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("ProjectTask_RecordStatus_Field_Title", "ExpectedRecordStatustext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void isPhaseFieldbDisplayed() throws InterruptedException, IOException {
		json = new JsonReaderfile();
		Reporter.log("Validate Task Tab is Visible on  page");
		String ExpTitle = json.getTestCaseData("ExpectedTitle");
		wrapper.waitForBrowserToLoadCompletely();
		if(wrapper.getDriver().getTitle().equalsIgnoreCase(ExpTitle)) {

			wrapper.validateWindowTab_PartialTitle("ExpectedTitle");
			wrapper.validateInnerText("ProjectTask_Phase_Field_Title", "ExpectedPhasetext");

		} else 
		{
			Assert.assertTrue(false, "Expected title: " + ExpTitle + "does not match with the current title :" + wrapper.getDriver().getTitle());

		}
	}

	public synchronized void validate_fields_under_Task_Tab_Enabled() throws InterruptedException {
		Reporter.log("Validate  filed is enabled on Project data page");

		Reporter.log("Validate Task Name Text box is enabled");
		wrapper.validateElementVisibleandEnabled("ProjectTask_TaskName_Field_TextBox");
		Reporter.log("Validate start date field box is enabled");
		wrapper.validateElementVisibleandEnabled("ProjectTask_ConstructionStartDate_Field_Box");
		Reporter.log("Validate Due date field box is enabled");
		wrapper.validateElementVisibleandEnabled("ProjectTask_DueDate_Field_Box");
		Reporter.log("Validate Phase field box is enabled");
		//wrapper.validateElementVisibleandEnabled("ProjectTask_Phase_Field_TextBox");




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

	public synchronized void validateProjectCreated(String projectname) throws InterruptedException
	{
		Reporter.log("Validate Add Contact page is displayed");
		wrapper.zoomInZoomOut();
		System.out.println("expected value is " + projectname);
		wrapper.validateActualAndExpectedTextDirectly("ContactCreateTitle", projectname);

	}
	
//	public synchronized void validateProjectdataedited() throws InterruptedException
//	{
//		Reporter.log("Validate Add Contact page is displayed");
//		wrapper.zoomInZoomOut();
//		System.out.println("expected value is " + projectdatadescriptionedited);
//		wrapper.validateActualAndExpectedTextDirectly("Project_projectData_Description", projectdatadescriptionedited);
//
//	}
	
	public synchronized String createProjectFewDetailsAlreadyCreatedCompanyAndProject() throws InterruptedException, IOException {

		contact= new ContactPage();
		String CompanyTitle=Company.createCompanywithFewDetails();

		wrapper.click("ModalBox_Dashboard");

		String ContactTitle=contact.createContactWithFewDetails();
		contact.SubmitAndValidateContactCreated(ContactTitle);

		wrapper.click("ModalBox_Dashboard");

		wrapper.click("ModalBox_AddProject");
		isAddprojectPageDisplayed();
		String projectName=add_data_submit_ProjectName_of_project();
		add_select_submit_CompnayCategory_of_project();
		add_select_submit_ProjectManager_DropDown();
		add_select_submit_Compnany(CompanyTitle);
		add_select_submit_PrimaryContact_newlycreated(ContactTitle);
		add_select_submit_SecondaryContact_of_project();
		add_Select_submit_Projectdatetype();
		add_submit_Projectdate();
		add_submit_ProjectdateNotes();
		//add_select_submit_Visibility();
		add_select_submit_Tags();
		add_select_submit_Projectdate_Notes();
		add_select_submit_phoneType();
		add_select_submit_phoneNumberExtension();
		add_select_submit_EmailType();
		add_submit_Email();
		add_submit_EmailNotes();
		add_Select_submit_AddressType();
		add__submit_StreetAddress();
		add__submit_StreetAddress2();
		add_submit_City();
		add_Select_Country();
		add_Select_State();
		add_Submit_Zip();
		add_Submit_Alias();
		add_Select_URL();
		add_Submit_URLValue();
		add_Submit_URLNote();
		add_Select_RFI();
		//add_Select_RFIResponse();
		add_Submit_RFIResponseNotes();
		add_Submit_RFIDate();
		add_Submit_RFISource();
		add_Submit_Project_validate(projectName);
		return projectName;


		}
	
	
	public synchronized String createProjectFewDetailsAlreadyCreatedCompanyAndProject_dafc() throws InterruptedException, IOException {

		contact= new ContactPage();
		String CompanyTitle=Company.createCompanywithFewDetails_dafc();

		wrapper.click("ModalBox_Dashboard");

		String ContactTitle=contact.createContactWithFewDetails();
		contact.SubmitAndValidateContactCreated(ContactTitle);

		wrapper.click("ModalBox_Dashboard");

		wrapper.click("ModalBox_AddProject");
		isAddprojectPageDisplayed();
		String projectName=add_data_submit_ProjectName_of_project();
		add_select_submit_CompnayCategory_of_project();
		add_select_submit_ProjectManager_DropDown();
		add_select_submit_Compnany(CompanyTitle);
		add_select_submit_PrimaryContact_newlycreated(ContactTitle);
		add_select_submit_SecondaryContact_of_project_dafc();
		add_Select_submit_Projectdatetype();
		add_submit_Projectdate();
		add_submit_ProjectdateNotes();
		
		//add_select_submit_Visibility();
		add_select_submit_Tags();
		add_select_submit_Projectdate_Notes();
		add_select_submit_phoneType();
		add_select_submit_phoneNumberExtension();
		add_select_submit_EmailType();
		add_submit_Email();
		add_submit_EmailNotes();
		add_Select_submit_AddressType();
		add__submit_StreetAddress();
		add__submit_StreetAddress2();
		add_submit_City();
		add_Select_Country();
		add_Select_State();
		add_Submit_Zip();
		add_Submit_Alias();
		add_Select_URL();
		add_Submit_URLValue();
		add_Submit_URLNote();
		add_Select_RFI();
		//add_Select_RFIResponse();
		add_Submit_RFIResponseNotes();
		add_Submit_RFIDate();
		add_Submit_RFISource();
		add_Submit_Project_validate(projectName);
		return projectName;


		}
	
	public synchronized void sendSurvey(String Projectname) throws InterruptedException, IOException{
//		wrapper.waitForElementInvisibility("SendSurvey_SelectContact");
		wrapper.click("SendSurvey_selectProject_radio_button");
		wrapper.waitForBrowserToLoadCompletely();
		wrapper.click("SendSurvey_ClickContactDropDown");
		
		Thread.sleep(2000);
		//wrapper.click("SendSurvey_ClickListofDropDown");
		Thread.sleep(1000);
		//wrapper.enterTexttoSearchinSeachBox_DropDown(Projectname, "SendSurvey_SearchContactandSelect");
		Thread.sleep(1000);
		//wrapper.click("SendSurvey_sendButton");

		
		
		}
	
	public synchronized void sendSurvey_dafc(String Projectname) throws InterruptedException, IOException{
//		wrapper.waitForElementInvisibility("SendSurvey_SelectContact");
		wrapper.click("SendSurvey_selectProject_radio_button");
		wrapper.waitForBrowserToLoadCompletely();
		wrapper.click("SendSurvey_ClickContactDropDown");
		
		Thread.sleep(2000);
		//wrapper.click("SendSurvey_ClickListofDropDown");
		Thread.sleep(1000);
		//wrapper.enterTexttoSearchinSeachBox_DropDown(Projectname, "sendSurvey_input_text_search");
//		Thread.sleep(1000);
		
		wrapper.dynamic_DropdownspanInputSearchListValidationValueSelection_survey(
				Projectname,
				"SendSurvey_ClickContactDropDown", 
				"sendSurvey_input_text_search", 
				"Sendsurvey_input_select_value");

		wrapper.click("SendSurvey_sendButton");

		
		
		}
	
	
	
	public synchronized String Searchtexton_projectpage() throws InterruptedException
	
	{
		wrapper.click("Link_Project_Managment_page");
		wrapper.click("Project_search_box");	
		wrapper.enterTexttoSearchinSeachBox_DropDown("Test", "Project_search_box");
		wrapper.hitEnter();
		Thread.sleep(5000);
		wrapper.click("Project_search_selectDropdown");
		wrapper.clearEditBox("Project_search_box");
		wrapper.waitForBrowserToLoadCompletely();
		
		
		
	   return FurnitureFixture;
			
		
		
	}
	
	public synchronized String Searchtexton_projectpage_favorite() throws InterruptedException
	
	{
		wrapper.click("Link_Project_Managment_page");
		wrapper.click("Project_search_selectDropdown");
		wrapper.click("Project_search_favoritesCheckbox");
		
		
		
	   return FurnitureFixture;
			
		
		
	}
	
          public synchronized String Searchtexton_projectpage_click() throws InterruptedException
	
	{
		
		wrapper.click("Link_Project_Managment_page");
		wrapper.click("Project_search_box");	
		wrapper.enterTexttoSearchinSeachBox_DropDown("Test", "Project_search_box");
		wrapper.hitEnter();
		Thread.sleep(5000);
		String finalpath=  ("'Test_Ajit']");
		String matchvalue= "Test_Ajit";
		wrapper.click_dynamic_locator("Project_name_title", finalpath);
	    wrapper.waitForBrowserToLoadCompletely();
		wrapper.validateActualAndExpectedTextDirectly("ContactCreateTitle", matchvalue);
		
		
	   return FurnitureFixture;
			
		
		
	}
          public synchronized String Searchtexton_projectpage_basedonprimarycontactname() throws InterruptedException
      	
      	{
      		wrapper.click("Link_Project_Managment_page");
      		wrapper.click("Project_search_box");	
      		wrapper.enterTexttoSearchinSeachBox_DropDown("Alpha Beta", "Project_search_box");
      		wrapper.hitEnter();
      		Thread.sleep(5000);
    		String matchvalue= "Alpha Beta";
    		wrapper.click("Project_name_primarycontact_title");
    	    wrapper.waitForBrowserToLoadCompletely();
    		wrapper.validateActualAndExpectedTextDirectly("Project_name_primarycontact", matchvalue);
      		
      		
      	   return FurnitureFixture;
      			
      		
      		
      	}
          public synchronized String Searchtexton_projectpage_basedoncategory() throws InterruptedException
        	
        	{
        		wrapper.click("Link_Project_Managment_page");
        		wrapper.click("Project_search_box");	
        		wrapper.enterTexttoSearchinSeachBox_DropDown("Lead", "Project_search_box");
        		wrapper.hitEnter();
        		wrapper.waitForBrowserToLoadCompletely();
        		Thread.sleep(3000);
        		String matchvalue= "Lead";
        		wrapper.click("Project_name_primarycontact_title");
        		wrapper.waitForBrowserToLoadCompletely();
        		wrapper.validateActualAndExpectedTextDirectly("Project_name_category_title", matchvalue);
        		
        		
        		
        		
        	   return FurnitureFixture;
        			
        			
        	}
          public synchronized String Searchtexton_projectpage_basedonprojectmanager() throws InterruptedException
      	
      	{
      		wrapper.click("Link_Project_Managment_page");
      		wrapper.click("Project_search_box");	
      		wrapper.enterTexttoSearchinSeachBox_DropDown("Admin 4", "Project_search_box");
      		wrapper.hitEnter();
      		Thread.sleep(5000);
      		String matchvalue= "Admin 4";
      		wrapper.click("Project_name_primarycontact_title");
    		wrapper.validateActualAndExpectedTextDirectly("Project_name_projectmanager", matchvalue);
    	    wrapper.waitForBrowserToLoadCompletely();
      		
      		
      		
      	   return FurnitureFixture;
      			
      		
      		
      	}
          public synchronized String Searchtexton_projectpage_basedoncompany() throws InterruptedException
        	
        	{
        		wrapper.click("Link_Project_Managment_page");
        		wrapper.click("Project_search_box");	
        		wrapper.enterTexttoSearchinSeachBox_DropDown("Deployment_Company_Testing", "Project_search_box");
        		wrapper.hitEnter();
        		Thread.sleep(5000);
        		String matchvalue= "Deployment_Company_Testing";
        		wrapper.click("Project_name_primarycontact_title");
        		Thread.sleep(3000);
        		wrapper.validateActualAndExpectedTextDirectly("Project_name_company", matchvalue);
        	    wrapper.waitForBrowserToLoadCompletely();
        		
        		
        	   return FurnitureFixture;
        			
        		
        		
        	}
          public synchronized String Searchtexton_projectpage_basedonparentcompany() throws InterruptedException
      	
      	{
      		wrapper.click("Link_Project_Managment_page");
      		wrapper.click("Project_search_box");	
      		wrapper.enterTexttoSearchinSeachBox_DropDown("Ridhi company_28Jan,", "Project_search_box");
      		wrapper.hitEnter();
      		Thread.sleep(5000);
      		wrapper.clearEditBox("Project_search_box");
      		wrapper.enterTexttoSearchinSeachBox_DropDown("RIDHI PROJECT_27", "Project_search_box");
      		wrapper.hitEnter();
      		Thread.sleep(5000);
      		String matchvalue= "Ridhi company_28Jan,";
    		wrapper.click("Project_name_primarycontact_title");
    		Thread.sleep(3000);
    		wrapper.validateActualAndExpectedTextDirectly("Project_name_parentcompany", matchvalue);
    	    wrapper.waitForBrowserToLoadCompletely();
      		
      		
      		
      	   return FurnitureFixture;
      			
      		
      		
      	}
          public synchronized String Searchtexton_projectpage_basedonfein() throws InterruptedException
        	
        	{
        		wrapper.click("Link_Project_Managment_page");
        		wrapper.click("Project_search_box");	
        		wrapper.enterTexttoSearchinSeachBox_DropDown("Testing43", "Project_search_box");
        		wrapper.hitEnter();
        		Thread.sleep(5000);
        		String matchvalue= "Testing43";
        		wrapper.click("Project_name_primarycontact_title");
        		Thread.sleep(3000);
        		wrapper.validateActualAndExpectedTextDirectly_attribute("Project_name_fein", matchvalue);
        	    wrapper.waitForBrowserToLoadCompletely();
          		
        		
        		
        	   return FurnitureFixture;
        			
        		
        		
        	}
          public synchronized String Searchtexton_projectpage_basedonpromoter_corporate() throws InterruptedException
      	
      	{
      		wrapper.click("Link_Project_Managment_page");
      		wrapper.click("Project_search_box");	
      		wrapper.enterTexttoSearchinSeachBox_DropDown("Deployment_Company_Testing", "Project_search_box");
      		wrapper.hitEnter();
      		Thread.sleep(5000);
      		String matchvalue= "Deployment_Company_Testing";
    		wrapper.click("Project_name_primarycontact_title");
    		Thread.sleep(3000);
    		wrapper.validateActualAndExpectedTextDirectly("Project_name_promoter_corporate", matchvalue);
    	    wrapper.waitForBrowserToLoadCompletely();
      		
      		
      	   return FurnitureFixture;
      			
      		
      		
      	}
          public synchronized String Searchtexton_projectpage_basedonpromoter_individual() throws InterruptedException
        	
        	{
        		wrapper.click("Link_Project_Managment_page");
        		wrapper.click("Project_search_box");	
        		wrapper.enterTexttoSearchinSeachBox_DropDown("Test Test", "Project_search_box");
        		wrapper.hitEnter();
        		Thread.sleep(5000);
        		String matchvalue= "Test Test";
        		wrapper.click("Project_name_primarycontact_title");
        		Thread.sleep(3000);
        		wrapper.validateActualAndExpectedTextDirectly("Project_name_promoter_individual", matchvalue);
        	    wrapper.waitForBrowserToLoadCompletely();
        		
        		
        		
        	   return FurnitureFixture;
        			
        		
        		
        	}
          public synchronized String Searchtexton_projectpage_basedonsecondarycontactname(String type) throws InterruptedException
        	
        	{
        		wrapper.click("Link_Project_Managment_page");
        		wrapper.click("Project_search_box");	
        		wrapper.enterTexttoSearchinSeachBox_DropDown("Test Test", "Project_search_box");
        		wrapper.hitEnter();
        		Thread.sleep(5000);
        		String matchvalue= "Test Test";
        		wrapper.click("Project_name_primarycontact_title");
        		wrapper.waitForBrowserToLoadCompletely();
        		Thread.sleep(5000);
        		wrapper.validateActualAndExpectedTextDirectly_attributevalue("Project_name_secondarycontact", matchvalue, type);
        	    wrapper.waitForBrowserToLoadCompletely();
        		
        		
        		
        		
        	   return FurnitureFixture;
        			
        		
        		
        	}
          public synchronized String Searchtexton_projectpage_basedonothercontactname() throws InterruptedException
      	
      	{
      		wrapper.click("Link_Project_Managment_page");
      		wrapper.click("Project_search_box");	
      		wrapper.enterTexttoSearchinSeachBox_DropDown("RIDHI PROJECT_27", "Project_search_box");
      		wrapper.hitEnter();
      		Thread.sleep(5000);
      		String matchvalue= "Alpha Beta";
    		wrapper.click("Project_name_primarycontact_title");
    		Thread.sleep(3000);
    		wrapper.validateActualAndExpectedTextDirectly("Project_name_othercontact", matchvalue);
    	    wrapper.waitForBrowserToLoadCompletely();
      		
      		
      		
      	   return FurnitureFixture;
      			
      		
      		
      	}
          public synchronized String Searchtexton_projectpage_basedonindustrycluster() throws InterruptedException
        	
        	{
        		wrapper.click("Link_Project_Managment_page");
        		wrapper.click("Project_search_box");	
        		wrapper.enterTexttoSearchinSeachBox_DropDown("Advanced Materials", "Project_search_box");
        		wrapper.hitEnter();
        		Thread.sleep(5000);
        		String matchvalue= "Advanced Materials";
        		wrapper.click("Project_name_primarycontact_title");
        		Thread.sleep(3000);
        		wrapper.validateActualAndExpectedTextDirectly("Project_name_industrycluster", matchvalue);
        	    wrapper.waitForBrowserToLoadCompletely();
        		
        		
        		
        	   return FurnitureFixture;
        			
        		
        		
        	}
          public synchronized String Searchtexton_projectpage_basedon_naicscode() throws InterruptedException
      	
      	{
      		wrapper.click("Link_Project_Managment_page");
      		wrapper.click("Project_search_box");	
      		wrapper.enterTexttoSearchinSeachBox_DropDown("111110", "Project_search_box");
      		wrapper.hitEnter();
      		Thread.sleep(5000);
      		String matchvalue= "111110 - Soybean Farming";
    		wrapper.click("Project_name_primarycontact_title");
    		wrapper.waitForBrowserToLoadCompletely();
    		wrapper.validateActualAndExpectedTextDirectly("Project_name_naicscode", matchvalue);
    	    wrapper.waitForBrowserToLoadCompletely();
      		
      		
      		
      	   return FurnitureFixture;
      			
      		
      		
      	}
          public synchronized String Searchtexton_projectpage_basedon_commissionername() throws InterruptedException
        	
        	{
        		wrapper.click("Link_Project_Managment_page");
        		wrapper.click("Project_search_box");	
        		wrapper.enterTexttoSearchinSeachBox_DropDown("com", "Project_search_box");
        		wrapper.hitEnter();
        		Thread.sleep(5000);
        		wrapper.clearEditBox("Project_search_box");
          		wrapper.enterTexttoSearchinSeachBox_DropDown("RIDHI PROJECT_27", "Project_search_box");
          		wrapper.hitEnter();
          		Thread.sleep(5000);
          		String matchvalue= "com";
          		wrapper.waitForBrowserToLoadCompletely();
        		wrapper.click("Project_name_primarycontact_title");
        		Thread.sleep(3000);
        		wrapper.validateActualAndExpectedTextDirectly_attribute("Project_name_commissioner_name_title", matchvalue);
        	    wrapper.waitForBrowserToLoadCompletely();
        		      		
        		
        	   return FurnitureFixture;
        			
        		
        		
        	}
          public synchronized String Searchtexton_projectpage_basedon_district() throws InterruptedException
      	
      	{
      		wrapper.click("Link_Project_Managment_page");
      		wrapper.click("Project_search_box");	
      		wrapper.enterTexttoSearchinSeachBox_DropDown("dis", "Project_search_box");
      		wrapper.hitEnter();
      		Thread.sleep(5000);
      		wrapper.clearEditBox("Project_search_box");
      		wrapper.enterTexttoSearchinSeachBox_DropDown("RIDHI PROJECT_27", "Project_search_box");
      		wrapper.hitEnter();
      		Thread.sleep(5000);
      		String matchvalue= "dis";
    		wrapper.click("Project_name_primarycontact_title");		
    		Thread.sleep(3000);
    		wrapper.validateActualAndExpectedTextDirectly_attribute("Project_name_district_title", matchvalue);
    	    wrapper.waitForBrowserToLoadCompletely();
      		
      		
      		
      	   return FurnitureFixture;
      			
      		
      		
      	}
          public synchronized String Searchtexton_projectpage_basedon_date() throws InterruptedException
        	
        	{
        		wrapper.click("Link_Project_Managment_page");
        		wrapper.click("Project_search_box");	
        		wrapper.enterTexttoSearchinSeachBox_DropDown("01/15/2020", "Project_search_box");
        		wrapper.hitEnter();
        		String matchvalue= "01/15/2020";
        		Thread.sleep(5000);
        		wrapper.click("Project_name_primarycontact_title");
        		Thread.sleep(3000);
        		wrapper.validateActualAndExpectedTextDirectly("Project_name_date", matchvalue);
        	    wrapper.waitForBrowserToLoadCompletely();
        		
        		
        		
        	   return FurnitureFixture;
        			
        		
        		
        	}
          public synchronized String Searchtexton_projectpage_basedon_visibility(String type) throws InterruptedException
      	
      	{
      		wrapper.click("Link_Project_Managment_page");
      		wrapper.click("Project_search_box");	
      		wrapper.enterTexttoSearchinSeachBox_DropDown("PRIVATE", "Project_search_box");
      		wrapper.hitEnter();
      		Thread.sleep(5000);
      		wrapper.clearEditBox("Project_search_box");
      		wrapper.enterTexttoSearchinSeachBox_DropDown("RIDHI PROJECT_27", "Project_search_box");
      		wrapper.hitEnter();
      		Thread.sleep(5000);
      		String matchvalue= "PRIVATE";
    		wrapper.click("Project_name_primarycontact_title");
    		Thread.sleep(5000);
    		wrapper.validateActualAndExpectedTextDirectly_attributevalue("Project_name_visibility", matchvalue, type);
    	    wrapper.waitForBrowserToLoadCompletely();
      		
      		
      		
      	   return FurnitureFixture;
      			
      		
      		
      	}
          public synchronized String Searchtexton_projectpage_basedon_tags(String type) throws InterruptedException
        	
        	{
        		wrapper.click("Link_Project_Managment_page");
        		wrapper.click("Project_search_box");	
        		wrapper.enterTexttoSearchinSeachBox_DropDown("Regression", "Project_search_box");
        		wrapper.hitEnter();
        		Thread.sleep(5000);
        		wrapper.clearEditBox("Project_search_box");
          		wrapper.enterTexttoSearchinSeachBox_DropDown("RIDHI PROJECT_27", "Project_search_box");
          		wrapper.hitEnter();
          		Thread.sleep(5000);
        		String matchvalue= "Regression";
        		wrapper.click("Project_name_primarycontact_title");
        		Thread.sleep(3000);
        		wrapper.validateActualAndExpectedTextDirectly_attributevalue("Project_name_tags", matchvalue, type);
        	    wrapper.waitForBrowserToLoadCompletely();
        		
        		
        		
        	   return FurnitureFixture;
        			
        		
        		
        	}
          public synchronized String Searchtexton_projectpage_basedon_notes(String type) throws InterruptedException
      	
      	{
      		wrapper.click("Link_Project_Managment_page");
      		wrapper.waitForBrowserToLoadCompletely();
      		wrapper.click("Project_search_box");	
      		wrapper.enterTexttoSearchinSeachBox_DropDown("eclipse", "Project_search_box");
      		wrapper.hitEnter();
      		Thread.sleep(5000);
      		String matchvalue= "eclipse";
      		wrapper.waitForBrowserToLoadCompletely();
    		wrapper.click("Project_name_primarycontact_title");
    		wrapper.waitForBrowserToLoadCompletely();
    		wrapper.validateActualAndExpectedTextDirectly_attributevalue("Project_name_notes", matchvalue , type);
    	    wrapper.waitForBrowserToLoadCompletely();
      		
      		
      		
      	   return FurnitureFixture;
      			
      		
      		
      	}
          
          
          public synchronized String addProject_Date_Grid() throws InterruptedException
        	
        	{
        		wrapper.click("Projectgeneralinfo_dategrid_icon");
				return FurnitureFixture;
        		
        			
        		
        		
        	}
          public synchronized String addProject_Phone_Grid() throws InterruptedException
      	
      	{
      		wrapper.click("Projectgeneralinfo_phonegrid_icon");
				return FurnitureFixture;
      		
      			
      		
      		
      	}
          public synchronized String addProject_Email_Grid() throws InterruptedException
        	
        	{
        		wrapper.click("Projectgeneralinfo_emailgrid_icon");
  				return FurnitureFixture;
        		
        			
        		
        		
        	}  
          public synchronized String addProject_Address_Grid() throws InterruptedException
      	
      	{
      		wrapper.click("Projectgeneralinfo_addressgrid_icon");
				return FurnitureFixture;
      		
      			
      		
      		
      	} 
          public synchronized String addProject_URL_Grid() throws InterruptedException
        	
        	{
        		wrapper.click("Projectgeneralinfo_URLgrid_icon");
  				return FurnitureFixture;
        		
        			
        		
        		
        	} 
          public synchronized String addProject_SocialProfile_Grid() throws InterruptedException
      	
      	{
      		wrapper.click("Projectgeneralinfo_SocialProfilegrid_icon");
				return FurnitureFixture;
      		
      			
      		
      		
      	} 
          public synchronized String addProject_InstantMessenger_Grid() throws InterruptedException
        	
        	{
        		wrapper.click("Projectgeneralinfo_InstantMessengergrid_icon");
  				return FurnitureFixture;
        		
        			
        		
        		
        	} 
          public synchronized String addProject_RFI_Grid() throws InterruptedException
      	
      	{
      		wrapper.click("Projectgeneralinfo_RFIgrid_icon");
				return FurnitureFixture;
      		
      			
      		
      		
      	} 
          public synchronized String addProject_Stages_Grid() throws InterruptedException
        	
        	{
        		wrapper.click("Projectgeneralinfo_Stagesgrid_icon");
  				return FurnitureFixture;
        		
        			
        		
        		
        	} 
          public synchronized String addProject_Incentives_Grid() throws InterruptedException
      	
      	{
      		wrapper.click("Projectgeneralinfo_Incentivesgrid_icon");
				return FurnitureFixture;
      		
      			
      		
      		
      	} 
          public synchronized String addProject_History_Grid() throws InterruptedException
        	
        	{
        		wrapper.click("Projectgeneralinfo_Historygrid_icon");
  				return FurnitureFixture;
        		
        			
        		
        		
        	} 
          public synchronized void add_Select_SocialProfile() throws InterruptedException 
      	{
      		Reporter.log("Select SocialProfile type");
      		wrapper.selectByVisibleText("ProjectGeneralInfoPage_DropDown_SocialProfile", "ExpectedTexsSocialProfile");

      	}

      	public synchronized void add_Submit_SocialProfileValue() throws InterruptedException 
      	{
      		Reporter.log("Enter SocialProfile value");
      		wrapper.setTextBoxValue_Direct("ProjectGeneralInfoPage_TextBox_WebSocialProfile", "www.google.com");

      	}

      	public synchronized void add_Submit_SocialProfileNote() throws InterruptedException 
      	{
      		Reporter.log("Enter SocialProfileNote");
      		wrapper.setTextBoxValue_Direct("ProjectGeneralInfoPage_TextBox_SocialProfileNote", generateRandomAlphaNumeric(10));

      	}
      	 public synchronized void add_Select_InstantMessenger() throws InterruptedException 
       	{
       		Reporter.log("Select InstantMessenger type");
       		wrapper.selectByVisibleText("ProjectGeneralInfoPage_DropDown_InstantMessenger", "ExpectedTextinstantmessenger");

       	}

       	public synchronized void add_Submit_InstantMessengerValue() throws InterruptedException 
       	{
       		Reporter.log("Enter InstantMessenger value");
       		wrapper.setTextBoxValue_Direct("ProjectGeneralInfoPage_TextBox_WebInstantMessenger", "www.google.com");

       	}

       	public synchronized void add_Submit_InstantMessengerNote() throws InterruptedException 
       	{
       		Reporter.log("Enter InstantMessengerNote");
       		wrapper.setTextBoxValue_Direct("ProjectGeneralInfoPage_TextBox_InstantMessengerNote", generateRandomAlphaNumeric(10));

       	}
       	public synchronized void add_select_submit_IncentivesType_projectData() throws InterruptedException 
    	{
    		wrapper.waitForElementVisibility("ProjectData_Incentives_Drop_down");
    		wrapper.click("ProjectData_Incentives_Drop_down");
    		wrapper.Dropdownvalueselection_WithOption("DropDown_value_Incentives","ddnProjectIncentivesType", "ProjectData_Incentives_Drop_down_value");
    	}

    	public synchronized void add_Submit_Incentives_Date_projectdata() throws InterruptedException 
    	{
    		Reporter.log("Select add Incentives Date");
    		wrapper.click("ProjectData_Incentives_date");
    		wrapper.click("ProjectGeneralInfoPage_DateFiled_DummyDate3_value");

    	}

    	public synchronized void add_Submit_Incentives_Notes_projectdata() throws InterruptedException 
    	{
    		Reporter.log("Enter Incentives notes");
    		wrapper.setTextBoxValue_Direct("ProjectData_Projectdata_projextIncentives_Notesfield", generateRandomAlphaNumeric(30)+ " "+generateRandomAlphaNumeric(30) );


    	}
    	public synchronized void add_select_submit_HistoryType_projectData() throws InterruptedException 
    	{
    		wrapper.waitForElementVisibility("ProjectData_History_Drop_down");
    		wrapper.click("ProjectData_History_Drop_down");
    		wrapper.Dropdownvalueselection_WithOption("DropDown_value_History","ddnProjectHistoryType", "ProjectData_History_Drop_down_value");
    	}

    	public synchronized void add_Submit_History_Date_projectdata() throws InterruptedException 
    	{
    		Reporter.log("Select add History Date");
    		wrapper.click("ProjectData_History_date");
    		wrapper.click("ProjectGeneralInfoPage_DateFiled_DummyDate3_value");

    	}

    	
  	}
	





