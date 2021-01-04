package stepdefinitions;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Application_form {
	
		WebDriver  driver;
		
		
		@Before
		public void setup() {
			System.setProperty("webdriver.chrome.driver","/home/dhanvika/handsonmaven/newproj/src/main/java/resources/chromedriver");
		    
		}
		
		@After
		public void teardown() {
			driver.manage().deleteAllCookies();
			driver.quit();
			driver = null;
			
			
			
		}
		
	@Given("I open chrome browser")
	public void i_open_chrome_browser() throws Exception {
					 driver = new ChromeDriver();
					 driver.get("https://www.growthengineering.co.uk");
					 Thread.sleep(3000);
			    driver.manage().window().maximize();
			    driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
			    driver.manage().timeouts().setScriptTimeout(60,TimeUnit.SECONDS);
			System.out.println("successfully driver is loaded with pre configuration");
		}
			

	@Then("I click the Get In Touch button")
	public void i_click_the_get_in_touch_button() throws Exception{
		driver.findElement(By.xpath("//*[@id=\"contact-button\"]")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
				System.out.println("I clicked button");
	}

	@And("It opens Login page")
	public void it_opens_login_page() throws Exception {
			Thread.sleep(3000);
		
		 System.out.println("opens the login page");
	}

	@When("I enter valid details")
	public void i_enter_valid_details() throws Exception {
		Thread.sleep(3000);
		
		driver.findElement(By.name("firstname")).sendKeys("vivek");
		driver.findElement(By.name("lastname")).sendKeys("s");
		driver.findElement(By.name("email")).sendKeys("vivek123@gmail.com");
		driver.findElement(By.name("phone")).sendKeys("12345");
		driver.findElement(By.name("company")).sendKeys("Infosys");
		driver.findElement(By.name("country_")).sendKeys("India");
		driver.findElement(By.xpath("//*[@id=\"role_description-63c6168e-e30a-4c79-ab68-77cedae08dfe\"]/option[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"what_is_the_purpose_of_your_enquiry_-63c6168e-e30a-4c79-ab68-77cedae08dfe\"]/option[2]")).click();
		driver.findElement(By.name("i_have_read_and_understand_growth_engineering_s_privacy_poolicy")).click();
		
		System.out.println("Entered valid details");
	}

	@When("I entered no details in page")
	public void i_entered_no_details_in_page() throws Exception {
		driver.findElement(By.name("firstname")).clear();
		driver.findElement(By.name("firstname")).click();
		Thread.sleep(10000);
		System.out.println("Please complete this required field.");
	
		 
	}

}
	
	
	
	

