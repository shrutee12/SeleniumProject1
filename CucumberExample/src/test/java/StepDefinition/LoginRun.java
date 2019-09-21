package StepDefinition;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginRun {
	WebDriver driver;
	@Given("Chrome is opened and Login page is displayed")
	public void chrome_is_opened_and_Login_page_is_displayed() {
			System.setProperty("webdriver.chrome.driver", ".//driver/chromedriver.exe");
			driver= new ChromeDriver();
			driver.get("http://127.0.0.1:8080/htmldb");
			
	}

	@When("User enters username  and password")
	public void user_enters_username_and_password() {
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys("hr");
		driver.findElement(By.xpath("//*[@type='password']")).sendKeys("hr");
	}

	@When("Click on login button")
	public void click_on_login_button() {
			driver.findElement(By.xpath("//*[@type='BUTTON']")).click();
	}

	@Then("Home Page is displayed")
	public void home_Page_is_displayed() {
	    assertEquals("Login Failed", "Oracle",driver.getTitle());
	}
	
	
}
