package stepDefinition;

import static junit.framework.Assert.assertTrue;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
 
public class SearchTest_Steps {
	public static WebDriver driver;
	@Given("^I am on Springer Link Page$")
	public void openbrowser_HomePage() throws Throwable {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://link.springer.com/");
		}
 
	@Given("^I see the search box$")
	public void ifVisible_Search() throws Throwable {
		driver.findElement(By.id("query")).isDisplayed();
		driver.findElement(By.id("query")).clear();
		}
 
	@When("^I type keyword in the search box$")
	public void enter_keyword() throws Throwable {
		driver.findElement(By.id("query")).sendKeys("science");
		}

 
	@When("^I click on search button$")
	public void click_searchbutton() throws Throwable {
		driver.findElement(By.id("search")).click();
	}
 
	@Then("^I see the results for keyword$")
	public void checkresults() throws Throwable {
		isTextPresent("science");
	}
	
	@When("^I type invalid_term in the search box$")
	public void enter_invalidterm() throws Throwable {
		driver.findElement(By.id("query")).sendKeys("¢∑††∑†®†");
		}
	
	@Then("^I should see validation_message on the results section$")
	public void checkmessage() throws Throwable {
		isTextPresent("Sorry – we couldn’t find what you are looking for. Why not…");
	}
	
	@After
	public void cleanup(){
		driver.quit();
	}
 


protected boolean isTextPresent(String text){
    try{
        boolean b = driver.getPageSource().contains(text);
        return b;
    }
    catch(Exception e){
        return false;
    }
  }
}
