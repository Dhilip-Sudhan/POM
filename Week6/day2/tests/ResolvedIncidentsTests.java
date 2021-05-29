package Assignment.Week6.day2.tests;

import org.testng.annotations.Test;

import Assignment.Week6.day2.Hooks.Hooks;
import Assignment.Week6.day2.Pages.Login;

public class ResolvedIncidentsTests extends Hooks {
	
	@Test
	public void resolvedIncidents() throws InterruptedException {
		new Login()
		.typeUsername()
		.typePassword()
		.clickLogin()
		.enterFilterNavigator("Incident")
		.clickOpenIncident()
		.clickExactMatch()
		.changeStateIncident("Resolved")
		//.enterWorkNotesIncident("My Resolved Updates")
		.clickResolutionInformation()
		.enterResolutionCode()
		.enterResolutionNotes()
		.clickResolveIncidents()
		.validateResolvedIncidents();
		
	}

}
