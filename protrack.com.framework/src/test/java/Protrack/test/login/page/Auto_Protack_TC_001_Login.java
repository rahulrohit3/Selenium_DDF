package Protrack.test.login.page;

import java.io.IOException;

import org.testng.annotations.Test;
import protrack.com.test.suite.Config_Utility;
import protrack.com.test.suite.ExecutionEnvironment;
import protrack.main.test.page.LoginPage;

public class Auto_Protack_TC_001_Login extends Config_Utility {

	
	LoginPage login=new LoginPage();
	ExecutionEnvironment exec = new ExecutionEnvironment();
	
	@Test(description="User Log In - required fields - Valid password",groups = {"All", "Smoke"})
	public void loginSuccess() throws IOException {
	
		login.isLoginPageDisplayed();	
	}
	
	
}


