package hellocucumber;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.*;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class SeleniumUIStepDefinition {
	
	//private final WebDriver driver=new FirefoxDriver();
	WebDriver driver=null;
	
	@Given("I am on the Google search page")
	public void i_am_on_the_google_search_page() {
	    System.out.println("Inside - I am on the Google search page");
	    driver=new ChromeDriver();
	    String driverPath=System.getProperty("user.dir");
	    System.out.println("driverPath"+driverPath);
	    System.setProperty("webdriver.chrome.driver", driverPath+"\\src\\test\\resources\\driver\\chromedriver.exe");
	    
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	    
	    driver.navigate().to("https://www.google.com/");
	}

	@When("I search for {string}")
	public void i_search_for(String searchValue) {
		
		System.out.println("Inside - I search for searchValue");
		
		driver.findElement(By.name("q")).sendKeys(searchValue);
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	}

	@Then("the page title should start with {string}")
	public void the_page_title_should_start_with(String titleOfPage) {
		
		System.out.println("Inside - the page title should start with expectedString");
		
		String titlePage = driver.getTitle();
		System.out.println("titlePage: "+titleOfPage);
		assertEquals(titlePage, titleOfPage);		
	}
	
	@And("user click on {string} header text")
	public void user_click_on_header_text(String textToClick) {
		
	    System.out.println("textToClick: "+textToClick);
	    System.out.println("(//h3[text()='"+textToClick+"'])[1]");
        driver.findElement(By.xpath("(//h3[text()='"+textToClick+"'])[1]")).click();		
	}

	@And("user navigates to home page of {string}")
	public void user_navigates_to_home_page_of(String stringToVerify) {
	    
		String titlePage2 = driver.getTitle();
		System.out.println("titlePage: "+titlePage2);
		
		Assert.assertEquals(stringToVerify, titlePage2);
		
		driver.getPageSource().contains("Selenium");
		
		driver.getTitle().equals("Selenium");
		
		System.out.println("CurrentUrl: "+driver.getCurrentUrl());
		
		driver.close();
		driver.quit();
	}


}
