package Assignment.Week6.day2.Pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Assignment.Week6.day2.Hooks.Hooks;

public class UpdateIncidents extends Hooks {
	
	
	
	public UpdateIncidents changeUrgencyIncident(String UrgenStatus) throws InterruptedException {
		
		WebElement urgencyDropDown = driver.findElement(By.xpath("//select[@id='incident.urgency']"));
		Select urgDropdown = new Select(urgencyDropDown); 
		urgDropdown.selectByVisibleText(UrgenStatus);
		Thread.sleep(2000);
		return this;
	}
	
	public UpdateIncidents changeStateIncident(String StateStatus) throws InterruptedException {
		
		WebElement stateDropDown = driver.findElement(By.xpath("//select[@id='incident.state']"));
		Select steDropdown = new Select(stateDropDown); 
		steDropdown.selectByVisibleText(StateStatus);
		Thread.sleep(2000);
		return this;
	}
	
	public UpdateIncidents enterWorkNotesIncident(String WorkNotes) {
		driver.findElement(By.xpath("//textarea[@id='activity-stream-work_notes-textarea']")).clear();
		driver.findElement(By.xpath("//textarea[@id='activity-stream-work_notes-textarea']")).sendKeys(WorkNotes);
		return this;
	}
	
	
	public Incidents clickUpdateIncident() throws InterruptedException {
		
		driver.findElement(By.id("sysverb_update")).click();
		Thread.sleep(3000);
		return new Incidents();
	}
	
	
	public UpdateIncidents enterAssignmentGroup() throws InterruptedException {
		
		driver.findElement(By.xpath("//span[text()='Assignment group']//following::span[2]")).click();
		Thread.sleep(3000);
		// Print the number of windows open
		Set<String> allwindowHandles = driver.getWindowHandles();
		System.out.println(allwindowHandles.size());
		//	Get the second window from the Set
		List<String> lstofWindows = new ArrayList<String>(allwindowHandles);
		//	Get the Second windows handle
		String SecondWindowHandle = lstofWindows.get(1);
		//	Move the control to Second window
		driver.switchTo().window(SecondWindowHandle);
		// Enter Software from the text box and click Enter
		WebElement searchDropDown = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		Select srchDropdown = new Select(searchDropDown); 
		srchDropdown.selectByVisibleText("for text");
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys("Software", Keys.ENTER);
		Thread.sleep(2000);
		// Select one of the value from  the second window
		driver.findElement(By.xpath("(//a[@class='glide_ref_item_link'])[1]")).click();
		Thread.sleep(2000);
		// Move to First Window
		driver.switchTo().window(lstofWindows.get(0));
		// Switch back to Iframe
		WebElement iframe = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(iframe);
		return this;
	}
	
	public UpdateIncidents clickResolutionInformation() throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='Resolution Information']")).click();
		Thread.sleep(1000);
		return this;
	}
	
	public UpdateIncidents enterResolutionCode() throws InterruptedException {
		// Select Resolution code
		WebElement resCodeDropDown = driver.findElement(By.xpath("//select[@id='incident.close_code']"));
		Select resDropdown = new Select(resCodeDropDown); 
		resDropdown.selectByVisibleText("Solved (Work Around)");
		Thread.sleep(1000);
		return this;
	}
	
	public UpdateIncidents enterResolutionNotes() {
		// Enter Resolution Notes
		driver.findElement(By.id("incident.close_notes")).sendKeys("Resolution notes");
		return this;
	}
	
	public Incidents clickResolveIncidents() throws InterruptedException {
		// Click Resolve button
		driver.findElement(By.xpath("(//button[text()='Resolve'])[1]")).click();
		Thread.sleep(3000);
		return new Incidents();
	}
	
	public Incidents clickDeleteIncidents() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='Delete']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("ok_button")).click();
		Thread.sleep(5000);
		return new Incidents();
	}
	
	
}

