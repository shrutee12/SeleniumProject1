package StepDefinition;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateStep {
WebDriver driver;
	
	@Given("Chrome is Opened & Login Page is displayed")
	public void chrome_is_Opened_Login_Page_is_displayed() {
		System.setProperty("webdriver.chrome.driver", ".//Driver//chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.get("http://127.0.0.1:8080/htmldb/");
	}

	@When("User enters userName & Password")
	public void user_enters_userName_Password() {
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys("sys");
	    driver.findElement(By.xpath("//*[@type='password']")).sendKeys("India@123");
	}
	
	@When("User enters {string} & {string}")
	public void user_enters(String string, String string2) {
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys(string);
	    driver.findElement(By.xpath("//*[@type='password']")).sendKeys(string2);
	}

	@When("Click on Login button")
	public void click_on_Login_button() {
		driver.findElement(By.xpath("//*[@type='BUTTON']")).click();
	}

	@Then("Home Page Should Display")
	public void home_Page_Should_Display() {
		assertEquals("Login Failed","Oracle", driver.getTitle());
	}

	@When("User clicks on Admin")
	public void user_clicks_on_Admin() {
		driver.findElement(By.linkText("Administration")).click();
	}

	@When("Database user & Click on Create")
	public void database_user_Click_on_Create() {
		driver.findElement(By.xpath("//*[@title='Database Users']")).click();
		driver.findElement(By.cssSelector("input[value='Create >']")).click();
	}

	@When("User enters following details")
	public void user_enters_following_details(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		List<Map<String, String>> data = dataTable.asMaps();
		driver.findElement(By.id("P2611_USERNAME")).sendKeys(data.get(0).get("UserName"));
		driver.findElement(By.id("P2611_PASSWORD")).sendKeys(data.get(0).get("Password"));
		driver.findElement(By.id("P2611_CONFIRM_PASSWORD")).sendKeys(data.get(0).get("CPassword"));
	}

	@When("Click on Create")
	public void click_on_Create() {
		driver.findElement(By.xpath("//input[@value='Create']")).click();
	}

	@Then("User created Message should display")
	public void user_created_Message_should_display() {
	    
		String text = driver.findElement(By.xpath("//div[@class='htmldbSuccessMessage']")).getText();
		assertEquals("User Created.", text);
	}
	@After
	public void after() {
		driver.quit();
	}
	@AfterStep
	public void afterStep()
	{
		System.out.println("After Step");
	}
}
