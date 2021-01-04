package stepdefinitions;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import io.cucumber.java.en.Then;

public class Login {
	
	WebDriver driver;
	    
	
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
	
	@Given("I launch Chrome browser")
	public void i_launch_chrome_browser() {
		 driver = new ChromeDriver();
			
		    driver.manage().window().maximize();
		    driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
		    driver.manage().timeouts().setScriptTimeout(60,TimeUnit.SECONDS);
		System.out.println("successfully driver is loaded with pre configuration");
	}

	@When("I open Growth Engineering webpage")
	public void openWebsite() {
		driver.get("https://www.growthengineering.co.uk");
	System.out.println("successfully entered webpage");
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	@Then("I check the Menu options")
	public void checkMenu() throws InterruptedException {

		Thread.sleep(3000);
		pullMenuLinks();

		//handleContactUs();
		
		Thread.sleep(3000);
			
	
	}

	@Then("I click contact-button")
	public void handleContact() throws InterruptedException {
		//Get in Touch menu
		//WebElement ele=	driver.findElement(By.xpath("//ul[contains(@id,'menu-1')]/li/a[@id='contact-button']"));
		WebElement ele=	driver.findElement(By.xpath("//*[@id=\"contact-button\"]"));
		System.out.println("contac Button URL "+ ele.getAttribute("href"));
		Actions actions = new Actions(driver);
		actions.moveToElement(ele).click().perform();
		Thread.sleep(1000);
		//check if all the element checks are working if not passed
		WebElement firstName=	driver.findElement(By.xpath("//*[@id=\"firstname-63c6168e-e30a-4c79-ab68-77cedae08dfe\"]"));
		firstName.sendKeys(Keys.TAB);
		
		System.out.println("Current value is :"+driver.findElement(By.xpath("//*[@id=\"hsForm_63c6168e-e30a-4c79-ab68-77cedae08dfe\"]/fieldset[1]/div[1]/ul/li/label")).getAttribute("class"));
		
		
		  if(firstName.getText().isBlank()) { 
			  Assert.assertEquals("As Expected , there is an Error check for First Name","hs-error-msg",driver.findElement(By.xpath("//*[@id=\"hsForm_63c6168e-e30a-4c79-ab68-77cedae08dfe\"]/fieldset[1]/div[1]/ul/li/label")).getAttribute("class"));
		}
		  driver.findElement(By.xpath(
		  "//*[@id=\"hsForm_63c6168e-e30a-4c79-ab68-77cedae08dfe\"]/fieldset[1]/div[1]/ul/li/label"
		  ).className("hs-error-msg")); WebElement lastName=
		  driver.findElement(By.xpath(
		  "//*[@id=\"lastname-63c6168e-e30a-4c79-ab68-77cedae08dfe\"]"));
		  
		  //System.out.println("Printing the class "+ele.getAttribute("class"));
		  if(ele.getText().isBlank()) {
		  Assert.assertEquals("Mandatory Check is enabled", ele.getAttribute("class"),
		  "hs-input"); printMessage(); }
		 
		 
	}

	private void printMessage() {
		// TODO Auto-generated method stub
		
	}

	private void pullMenuLinks() throws InterruptedException {
		List<WebElement> menuLinks = driver.findElements(By.xpath("//ul[contains(@id,'menu-1')]/li/a"));

		for(WebElement menuLink:menuLinks) {

			if(menuLink.isDisplayed()) {
				Actions actions = new Actions(driver);
				actions.moveToElement(menuLink).click().perform();
				Thread.sleep(1000);
				String hrefUrl=menuLink.getAttribute("href");				
				System.out.println("hrefUrl link:"+hrefUrl);
				verifyLinks(hrefUrl);
				System.out.println("Menu was checked properly and is working fine");
				
			}
		}
	}

	private void pullAllLinks() {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		  
	      // This line will print the number of links and the count of links.
	      System.out.println("No of links are "+ links.size());  
	    
	      //checking the links fetched.
	      for(int i=0;i<links.size();i++)
	      {
	          WebElement E1= links.get(i);
	          String url= E1.getAttribute("href");
	          verifyLinks(url);
	      }
	}
	public static void verifyLinks(String linkUrl)
    {
        try
        {
            URL url = new URL(linkUrl);
 
            //Now we will be creating url connection and getting the response code
            HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
            httpURLConnect.setConnectTimeout(5000);
            httpURLConnect.connect();
            if(httpURLConnect.getResponseCode()>=400)
            {
             System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage()+"is a broken link");
            }    
       
            //Fetching and Printing the response code obtained
            else{
                System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
            }
        }catch (Exception e) {
      }

        
    }	
	@Then("close the browser")
	public void close_the_browser() {
     System.out.println("browser closed");
	}

	

	

}
