package Assignment.Week6.day2.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import Assignment.Week6.day2.Hooks.Hooks;

public class HomePage extends Hooks {
	
	public HomePage verifyWelcomeMessage() throws InterruptedException {
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		String welcomeMessage = driver.findElement(By.xpath("//div[text()='Get Started']")).getText();
		if(welcomeMessage.contains("Get Started")) {
			System.out.println("Successfully Logged In");
		}
		return this;
	}
	
	public HomePage enterFilterNavigator(String FilterValue) {
		driver.switchTo().defaultContent();
		//driver.findElement(By.id("filter")).clear();
		driver.findElement(By.id("filter")).sendKeys(FilterValue, Keys.ENTER);
		return this;
	}
	
	
	public CreateIncident clickCreateNew() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//span[text()='Incident']/following::div[text()='Create New']")).click();
		Thread.sleep(4000);
		return new CreateIncident();
	}
	
	public Incidents clickOpenIncident() throws InterruptedException {
		driver.findElement(By.xpath("(//div[text()='Open'])[1]")).click();
		Thread.sleep(2000);
		return new Incidents();
	}
	
	
	
	
	
}

