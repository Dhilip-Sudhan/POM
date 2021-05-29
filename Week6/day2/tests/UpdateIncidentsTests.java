package Assignment.Week6.day2.tests;

import org.testng.annotations.Test;

import Assignment.Week6.day2.Hooks.Hooks;
import Assignment.Week6.day2.Pages.Login;

public class UpdateIncidentsTests extends Hooks {
	
	@Test
	public void UpdateIncidents() throws InterruptedException {
		new Login()
			.typeUsername()
			.typePassword()
			.clickLogin()
			.enterFilterNavigator("Incident")
			.clickOpenIncident()
			.clickExactMatch()
			.changeUrgencyIncident("1 - High")
			.changeStateIncident("In Progress")
			.enterWorkNotesIncident("My Updates")
			.clickUpdateIncident()
			.validateUpdatedIncidents();
			
			
	}

}
