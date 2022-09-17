package Protrack.test.project.page;

import java.io.IOException;

import org.testng.annotations.Test;

import protrack.com.frame.core.SeleniumHelper;
import protrack.com.test.suite.Config_Utility;
import protrack.com.test.suite.ExecutionEnvironment;
import protrack.main.test.page.Projectpage;

public class Auto_protrack_edit_projectdata extends Config_Utility{
	

	Projectpage Projectpage = new Projectpage();
	ExecutionEnvironment exec = new ExecutionEnvironment();
	SeleniumHelper wrapper=new SeleniumHelper();
	
	@Test(description="Check project is being edited",groups = {"All", "Regression"})
	public void Editproject_projectData_section() throws IOException, InterruptedException {

		Projectpage.Editproject_ProjectData();

	}

}
