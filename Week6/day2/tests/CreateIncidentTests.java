package Assignment.Week6.day2.tests;

import org.testng.annotations.Test;

import Assignment.Week6.day2.Hooks.Hooks;
import Assignment.Week6.day2.Pages.Login;

public class CreateIncidentTests extends Hooks {
	
	@Test
	public void ValidateIncidents() throws InterruptedException {
		new Login()
			.typeUsername()
			.typePassword()
			.clickLogin()
			//.verifyWelcomeMessage()
			.enterFilterNavigator("Incident")
			.clickCreateNew()
			.captureIncidentNumber()
			.selectCaller("Guest")
			.enterShortDescription("Incident Number Dhilip")
			.clickSubmit()
			.validateCreatedIncidentNumber();
	}
	

}
