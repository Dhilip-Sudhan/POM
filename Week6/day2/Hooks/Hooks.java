package Assignment.Week6.day2.Hooks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Hooks {
	
	public static ChromeDriver driver;
	public static String IncNumber;
	
	
	@BeforeMethod
	 public void init() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://dev103117.service-now.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		 
	 }
	 
	@AfterMethod
	public void teardown() {
		//driver.close();
		 
	 }
}








	
