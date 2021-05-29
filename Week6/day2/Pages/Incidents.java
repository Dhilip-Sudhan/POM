package Assignment.Week6.day2.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Assignment.Week6.day2.Hooks.Hooks;

public class Incidents extends Hooks {
	
	
	public Incidents validateCreatedIncidentNumber() throws InterruptedException {
		//WebElement iframe = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		//driver.switchTo().frame(iframe);
		WebElement searchDropDown = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		Select srchDropdown = new Select(searchDropDown); 
		srchDropdown.selectByVisibleText("Number");
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(IncNumber, Keys.ENTER);
		Thread.sleep(2000);
		String IncNumberCreated = driver.findElement(By.xpath("(//a[@class='linked formlink'])[1]")).getText();
		System.out.println(IncNumberCreated);
		if (IncNumber.equals(IncNumberCreated)) {
			System.out.println("New Incident should be created successfully");
		} else {
			System.out.println("New Incident not created");

		}
		return this;
	}
	
	public UpdateIncidents clickExactMatch() throws InterruptedException {
		WebElement iframe = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(iframe);
		WebElement searchDropDown = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		Select srchDropdown = new Select(searchDropDown); 
		srchDropdown.selectByVisibleText("for text");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys("Incident Number Dhilip", Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@class='linked formlink'])[1]")).click();
		Thread.sleep(2000);
		return new UpdateIncidents();
	}
	
	
	public Incidents validateUpdatedIncidents() throws InterruptedException {
		//WebElement iframe = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		//driver.switchTo().frame(iframe);
		WebElement searchDropDown = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		Select srchDropdown = new Select(searchDropDown); 
		srchDropdown.selectByVisibleText("for text");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys("Incident Number Dhilip", Keys.ENTER);
		Thread.sleep(2000);
		// Capture the value which has been updated
		String priorityValue = driver.findElement(By.xpath("//table[@id='incident_table']//tbody[1]//tr[1]//td[7]")).getText();
		String stateValue = driver.findElement(By.xpath("//table[@id='incident_table']//tbody[1]//tr[1]//td[8]")).getText();
		System.out.println(priorityValue);
		System.out.println(stateValue);
		// Validate the Priority is displayed as 3 - Moderate
		if (priorityValue.equals("3 - Moderate")) {
			System.out.println("The prioity Status should be displayed as : " + priorityValue);
		} else {
			System.out.println("The Priority Status is not reflecting as expected");
		}
		// Validate the State is displayed as In-Progress
		if (stateValue.equals("In Progress")) {
			System.out.println("The status should be displayed as : " + stateValue);
		} else {
			System.out.println("The status is not displayed as Expected");
		}
		return this;
	}
	
	
	public Incidents validateAssignedIncidents() throws InterruptedException {
		//WebElement iframe = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		//driver.switchTo().frame(iframe);
		WebElement searchDropDown = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		Select srchDropdown = new Select(searchDropDown); 
		srchDropdown.selectByVisibleText("for text");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys("Incident Number Dhilip", Keys.ENTER);
		Thread.sleep(2000);
		// Capture the value which has been updated
		String assignmentGroup = driver.findElement(By.xpath("//table[@id='incident_table']//tbody[1]//tr[1]//td[10]")).getText();
		System.out.println(assignmentGroup);
		// Validate the Assignment Group is displayed as Software
		if (assignmentGroup.equals("Software")) {
			System.out.println("The Assignment Group should be displayed as : " + assignmentGroup);
		} else {
			System.out.println("The Assignment Group is not reflecting as expected");
		}
		return this;
	}
	
	public Incidents validateResolvedIncidents() {
		String stateStatus = driver.findElement(By.xpath("//table[@id='incident_table']//tbody[1]//tr[1]//td[8]")).getText();
		System.out.println(stateStatus);
		// Validate the State as Resolved
		if (stateStatus.equals("Resolved")) {
			System.out.println("The Status should be displayed as : " + stateStatus);
		} else {
			System.out.println("The Status is not reflecting as expected");
		}
		return this;
	}
	
	public Incidents validateDeleteIncidentDisplayed() throws InterruptedException {
		// validate the deleted Incident is displayed
		WebElement searchDropDown = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		Select srchDropdown = new Select(searchDropDown); 
		srchDropdown.selectByVisibleText("for text");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys("Incident Number Dhilip", Keys.ENTER);
		Thread.sleep(2000);
		String noRecordMessage = driver.findElement(By.xpath("//td[text()='No records to display']")).getText();
		System.out.println(noRecordMessage);
		
		if (noRecordMessage.equals("No records to display")) {
			System.out.println("No Records to display message should be displayed");
		} else {
			System.out.println("No Records to display message is not displayed");
		}
		return this;	
	}
	
}
