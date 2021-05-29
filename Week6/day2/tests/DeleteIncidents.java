package Assignment.Week6.day2.tests;

import org.testng.annotations.Test;

import Assignment.Week6.day2.Hooks.Hooks;
import Assignment.Week6.day2.Pages.Login;

public class DeleteIncidents extends Hooks {

	@Test
	public void deleteIncidents() throws InterruptedException {
		new Login()
			.typeUsername()
			.typePassword()
			.clickLogin()
			.enterFilterNavigator("Incident")
			.clickOpenIncident()
			.clickExactMatch()
			.clickDeleteIncidents()
			.validateDeleteIncidentDisplayed();

	}
}
