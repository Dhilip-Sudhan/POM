package stepDefintion.servicenow;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class CreateChange extends MyBaseTest {
	String chNumber;
	
	/*
	@Given("Launch Chrome browser")
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@When("Load URL {string}")
	public void loadUrl(String url) {
		driver.get(url);
	}
	*/
	
	@Given("Type username as {string}")
	public void typeUserName(String username) {
		driver.switchTo().frame(0);
		driver.findElement(By.id("user_name")).sendKeys(username);
	}

	@And("Type password as {string}")
	public void typepassword(String password) {
		driver.findElement(By.id("user_password")).sendKeys(password);
	}
	
	@When("Click Login Button")
	public void clickLogin() throws InterruptedException {
		driver.findElement(By.id("sysverb_login")).click();
		Thread.sleep(5000);
	}

	@Then("Verify Login is successful")
	public void isSuccess() throws InterruptedException {
		Thread.sleep(2000);
		WebElement iframe = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(iframe);
		String welcomeMessage = driver.findElement(By.xpath("//div[text()='Get Started']")).getText();
		if(welcomeMessage.contains("Get Started")) {
			System.out.println("Successfully Logged In");
		}
		driver.switchTo().defaultContent();
	}
	
	@Given("Enter the Change in Filter Navigation and click Enter")
	public void enterChangeText() throws InterruptedException {
		driver.findElement(By.id("filter")).sendKeys("Change", Keys.ENTER);
		Thread.sleep(5000);
	}
	
	@When("Click Create New button")
	public void clickNewButtonChange() throws InterruptedException {
		driver.findElement(By.xpath("(//span[text()='Change']/following::div[text()='Create New'])[1]")).click();
		Thread.sleep(2000);
	}
	
	@And("Click Normal Change")
	public void clicknormalChange() throws InterruptedException {
		WebElement iframe = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='change-model-card-component'])[2]")).click();
		Thread.sleep(3000);
	}
	
	@Given("Capture the Created change number")
	public void captureCreatedChangenum() throws InterruptedException {
		chNumber = driver.findElement(By.id("change_request.number")).getAttribute("value");
		System.out.println("The Created Change number is : " + chNumber);
	}
	

	@And("Enter Short Description {string}")
	public void entershortDescChange(String ShortDesc) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("change_request.short_description")).clear();
		driver.findElement(By.id("change_request.short_description")).sendKeys(ShortDesc);
	}
	
	@When("Click Submit button")
	public void clickSubmitChange() throws InterruptedException {
		driver.findElement(By.xpath("//button[@id='sysverb_insert']")).click();
		Thread.sleep(3000);
	}
	
	@And("Click Open button")
	public void clickOpenChange() throws InterruptedException {
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Change']/following::div[text()='Open']")).click();
		Thread.sleep(3000);
	}
	
	@Given("Enter the Change number")
	public void enterChangeNumber() throws InterruptedException {
		Thread.sleep(2000);
		WebElement iframe = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(2000);
		// Enter the Change number  and validate whether it is created or not
		WebElement searchDropDown = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		Select srchDropdown = new Select(searchDropDown); 
		srchDropdown.selectByVisibleText("Number");
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(chNumber, Keys.ENTER);
		Thread.sleep(2000);
	}
	
	@Then("Validate the Create change Number")
	public void validateChangeNum() throws InterruptedException {
		String changeNumberCreated = driver.findElement(By.xpath("(//td[@class='vt'])[1]/a")).getText();
		System.out.println(changeNumberCreated);
		if (chNumber.equals(changeNumberCreated)) {
			System.out.println("New Change number should be created successfully");
		} else {
			System.out.println("New chNumber number not created");

		}
		
	}
	
	@Given("Enter the Short Description text in Search field {string}")
	public void entershortDescription(String ShortDesc) throws InterruptedException {
		Thread.sleep(2000);
		WebElement iframe = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(2000);
		// Enter the Change number  and validate whether it is created or not
		WebElement searchDropDown = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		Select srchDropdown = new Select(searchDropDown); 
		srchDropdown.selectByVisibleText("for text");
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(ShortDesc, Keys.ENTER);
		Thread.sleep(2000);
	}
	
	@When("Click First Match")
	public void clickFirstMatch() throws InterruptedException {
		driver.findElement(By.xpath("(//a[@class='linked formlink'])[1]")).click();
		Thread.sleep(2000);
	}
	
	@Given("Select the State {string}")
	public void selectState(String StateVal) throws InterruptedException {
		// Select the state as Asses
		WebElement stateDropDown = driver.findElement(By.xpath("//select[@id='change_request.state']"));
		Select steDropdown = new Select(stateDropDown); 
		steDropdown.selectByVisibleText(StateVal);
		Thread.sleep(1000);
	}
	
	@Given("Select Assignment Group {string}")
	public void selectAssignmentGroup(String AssignmentGroup) throws InterruptedException {
		driver.findElement(By.id("sys_display.change_request.assignment_group")).sendKeys(AssignmentGroup, Keys.ENTER);
		Thread.sleep(2000);
	}
	
	@And("Select Assign To {string}")
	public void selectAssignTo(String AssignedTo) throws InterruptedException {
		driver.findElement(By.id("sys_display.change_request.assigned_to")).sendKeys(AssignedTo, Keys.ENTER);
		Thread.sleep(2000);
	}
	
	@When("Click Update button")
	public void clickUpdate() throws InterruptedException {
		// Click Update button
		driver.findElement(By.id("sysverb_update")).click();
		Thread.sleep(3000);
	}
	
	@Then("Validate the Updated Changes Reflected")
	public void validateUpdatedchangesReflected() throws InterruptedException {
		String stateUpdated = driver.findElement(By.xpath("//td[text()='Assess']")).getText();
		String assignedTo = driver.findElement(By.xpath("(//a[text()='ITIL User'])[1]")).getText();
		System.out.println(stateUpdated);
		System.out.println(assignedTo);
		// Validate the State By is displayed as Assess
		if (stateUpdated.equals("Assess")) {
			System.out.println("The State should be displayed as : " + stateUpdated);
		} else {
			System.out.println("The Requested ByState is not reflecting as expected");
		}
		// Validate the Assigned To is displayed as ITIL User
		if (assignedTo.equals("ITIL User")) {
			System.out.println("The Assigned To should be displayed as : " + assignedTo);
		} else {
			System.out.println("The Assigned To is not displayed as Expected");
		}
	
	}
	
	@And("Click Schedule")
	public void clickSchedule() throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='Schedule']")).click();
		Thread.sleep(2000);
	}
	
	@Given("Select Date from Planned Start Date")
	public void selectPlannedFromDate() throws InterruptedException {
		// Select Date from Planned Start Date
		driver.findElement(By.xpath("(//span[@class='icon-calendar icon'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='GwtDateTimePicker_ok']")).click();
		Thread.sleep(2000);
		String plannedStartDateExpected = driver.findElement(By.xpath("(//span[@class='icon-calendar icon'])[1]")).getAttribute("value");
		System.out.println("The Start Date is : " + plannedStartDateExpected);
	}
	
	@And("Select Date from Planned To Date")
	public void selectPlannedToDate() throws InterruptedException {
		driver.findElement(By.xpath("(//span[@class='icon-calendar icon'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='GwtDateTimePicker_ok']")).click();
		Thread.sleep(2000);
		String plannedEndDateExpected = driver.findElement(By.xpath("(//span[@class='icon-calendar icon'])[2]")).getAttribute("value");
		System.out.println("The Start Date is : " + plannedEndDateExpected);
	}
	
	@Given("Check the check box CAB Required")
	public void checkCAB() throws InterruptedException {
		driver.findElement(By.xpath("//label[@id='label.ni.change_request.cab_required']")).click();
		Thread.sleep(2000);
	}
	
	@And("Enter CAB date and select the Date")
	public void selectCABDate() throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='CAB date']//following::span[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[text()='Go to Today']")).click();
		Thread.sleep(2000);
	}
	
	@And("Validate the Updated Changes Reflected after CAB {string}")
	public void vaidateCABChanges(String ShortDescValidation) throws InterruptedException {
		Thread.sleep(2000);
		WebElement iframe = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(2000);
		// Capture the value which has been updated
		String descUpdatedActual = driver.findElement(By.xpath("(//td[text()='Dhilip Change Auto'])[1]")).getText();
		System.out.println(descUpdatedActual);
		Thread.sleep(2000);
		// Validate the Description is updated
		if (ShortDescValidation.equals(descUpdatedActual)) {
			System.out.println("Description should be updated");
		} else {
			System.out.println("Description is not updated");
		}
	}
	
	@And("Click Delete Button")
	public void clickDelete() throws InterruptedException {
		// Click Delete button
		driver.findElement(By.xpath("(//button[text()='Delete'])[1]")).click();
		Thread.sleep(2000);
	}
	
	@When("Click Confirm Delete button")
	public void clickDeleteConfirm() throws InterruptedException {
		driver.findElement(By.id("ok_button")).click();
		Thread.sleep(2000);
	}
	
	@Then("Validate No Records Found")
	public void validateNoRecordsFound() throws InterruptedException {
		// validate the deleted Incident is displayed
		WebElement searchDropDown = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		Select srchDropdown = new Select(searchDropDown); 
		srchDropdown.selectByVisibleText("for text");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys("Dhilip Change Auto Updated", Keys.ENTER);
		Thread.sleep(2000);
		String noRecordMessage = driver.findElement(By.xpath("//td[text()='No records to display']")).getText();
		System.out.println(noRecordMessage);
		
		if (noRecordMessage.equals("No records to display")) {
			System.out.println("No Records to display message should be displayed");
		} else {
			System.out.println("No Records to display message is not displayed");
		}
	}			

}


