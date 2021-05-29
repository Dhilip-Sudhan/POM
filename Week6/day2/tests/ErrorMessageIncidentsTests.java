package Assignment.Week6.day2.tests;

import org.testng.annotations.Test;

import Assignment.Week6.day2.Hooks.Hooks;
import Assignment.Week6.day2.Pages.Login;

public class ErrorMessageIncidentsTests extends Hooks {
	
	@Test
	public void errormessagesIncidents() throws InterruptedException {
		new Login()
			.typeUsername()
			.typePassword()
			.clickLogin()
			.enterFilterNavigator("Incident")
			.clickCreateNew()
			.clickSubmitErrorValidation()
			.validateErrorMessage();
			
	}



}
