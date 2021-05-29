package Assignment.Week6.day2.Pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Assignment.Week6.day2.Hooks.Hooks;

public class CreateIncident extends Hooks {
	
	
	
	public CreateIncident captureIncidentNumber() {
		WebElement iframe = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(iframe);
		IncNumber = driver.findElement(By.id("incident.number")).getAttribute("value");
		System.out.println("The Created Incident number is : " + IncNumber);
		return this;
		
		
	}
	
	public CreateIncident selectCaller(String callerName) throws InterruptedException {
		//WebElement iframe = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		//driver.switchTo().frame(iframe);
		driver.findElement(By.xpath("//span[text()='Caller']//following::span[2]")).click();
		//	Print the number of windows open
		Set<String> allwindowHandles = driver.getWindowHandles();
		System.out.println(allwindowHandles.size());
		//	Get the second window from the Set
		List<String> lstofWindows = new ArrayList<String>(allwindowHandles);
		//	Get the Second windows handle
		String SecondWindowHandle = lstofWindows.get(1);
		//	Move the control to Second window
		driver.switchTo().window(SecondWindowHandle);
		// Enter the Caller as Guest
		WebElement searchDropDown = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		Select srchDropdown = new Select(searchDropDown); 
		srchDropdown.selectByVisibleText("Name");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(callerName, Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@class='glide_ref_item_link'])[1]")).click();
		Thread.sleep(2000);
		// Move to First Window
		driver.switchTo().window(lstofWindows.get(0));
		return this;
	}
	
	public CreateIncident enterShortDescription(String ShortDesc) {
		// Switch back to Iframe
		WebElement iframe = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(iframe);
		// Enter Short Description
		driver.findElement(By.id("incident.short_description")).sendKeys(ShortDesc);
		return this;
	}
	
	public Incidents clickSubmit() throws InterruptedException {
		//WebElement iframe = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		//driver.switchTo().frame(iframe);
		// Click Submit button
		driver.findElement(By.xpath("(//button[@value='sysverb_insert'])[2]")).click();
		Thread.sleep(5000);
		return new Incidents();
	}
	
	public CreateIncident clickSubmitErrorValidation() throws InterruptedException {
		//WebElement iframe = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		//driver.switchTo().frame(iframe);
		// Click Submit button
		driver.findElement(By.xpath("(//button[@value='sysverb_insert'])[2]")).click();
		Thread.sleep(5000);
		return this;
	}
	public CreateIncident validateErrorMessage() {
		String errorMessage = driver.findElement(By.xpath("//div[@class='outputmsg_div']//following::span[1]")).getText();
		if (errorMessage.contains("Short description, Caller")) {
			System.out.println("Valid Error message should be displayed");
		} else {
			System.out.println("Valid Error message not displayed");
		}
		return this;
	}

	
}
