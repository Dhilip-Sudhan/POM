package Assignment.Week6.day2.tests;

import org.testng.annotations.Test;

import Assignment.Week6.day2.Hooks.Hooks;
import Assignment.Week6.day2.Pages.Login;

public class AssignedIncidentsTests extends Hooks {
	
	@Test
	public void assignedIncidents() throws InterruptedException {
		new Login()
			.typeUsername()
			.typePassword()
			.clickLogin()
			.enterFilterNavigator("Incident")
			.clickOpenIncident()
			.clickExactMatch()
			.enterAssignmentGroup()
			//.enterWorkNotesIncident("Assignment Group updated")
			.clickUpdateIncident()
			.validateAssignedIncidents();
		
	}

}
