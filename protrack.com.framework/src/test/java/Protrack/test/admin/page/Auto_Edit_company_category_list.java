package Protrack.test.admin.page;

import java.io.IOException;

import org.testng.annotations.Test;

import protrack.com.frame.core.SeleniumHelper;
import protrack.com.test.suite.Config_Utility;
import protrack.com.test.suite.ExecutionEnvironment;
import protrack.main.test.page.AdminPageprotrack;
import protrack.main.test.page.LoginPage;
import protrack.main.test.page.Projectpage;
import protrack.main.test.page.librarydocumentpage;

public class Auto_Edit_company_category_list extends Config_Utility{

	
	librarydocumentpage librarydocumentpages = new librarydocumentpage();
	ExecutionEnvironment exec = new ExecutionEnvironment();
	SeleniumHelper wrapper=new SeleniumHelper();
	LoginPage login=new LoginPage();
	AdminPageprotrack protracadmin= new AdminPageprotrack();
	Projectpage Projectpage = new Projectpage();
	
	
	
	@Test(description="Edit Company category",groups = {"All", "Regression"})
	public void TC003_Edit_company_category_list() throws IOException, InterruptedException {
		protracadmin.Validate_admin_configure_moudule_Submenu();
		protracadmin.Validate_admin_dropDownManagment_Submenu();
		protracadmin.Select_Company_ModuleList();
		protracadmin.Select_Company_subModuleList();
		protracadmin.edit_company_category();

}
}
