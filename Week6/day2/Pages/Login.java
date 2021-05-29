package Assignment.Week6.day2.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


import Assignment.Week6.day2.Hooks.Hooks;


public class Login extends Hooks {
	
	//WebElement iframeLogin = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
	
	public Login typeUsername() {
		driver.switchTo().frame(0);
		//driver.findElement(By.id("user_name")).clear();
		driver.findElement(By.id("user_name")).sendKeys("admin");
		return this;
	}
	
	public Login typePassword() {
		//driver.switchTo().frame(0);
		//driver.findElement(By.id("user_password")).clear();
		driver.findElement(By.id("user_password")).sendKeys("India@123");
		return this;
	}
	
	public HomePage typePasswordAndEnter() {
		//driver.switchTo().frame(0);
		//driver.findElement(By.id("user_password")).clear();
		driver.findElement(By.id("user_password")).sendKeys("India@123", Keys.ENTER);
		return new HomePage();
	}

	public HomePage clickLogin() throws InterruptedException {
		//driver.switchTo().frame(0);
		driver.findElement(By.id("sysverb_login")).click();
		Thread.sleep(4000);
		return new HomePage();
	}
	
	public Login clickLoginforFailure() {
		driver.findElement(By.className("decorativeSubmit")).click();
		return this;
	}

}


