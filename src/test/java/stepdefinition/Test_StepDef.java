package stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import reusable.*;

public class Test_StepDef extends OpenBrowser {

	WebDriver driver;
	
	@Given("User is on {string} selenium easy page")
	public void user_is_on_selenium_easy_page(String url) {
		driver = openBrowser("webdriver.chrome.driver","C:\\Users\\avinashkc\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe", "chrome");
		driver.manage().window().maximize();
		driver.get(url);
	   
	}
	
	@When("User click radio button")
	public void user_click_radio_checkbox() throws InterruptedException {
	    
	    singleRadioMethod(By.xpath("//*[@id='easycont']/div/div[2]/div[1]/div[2]/label[1]/input"));
	}
	

	
	@Then("User is able to click check value button")
	public void user_is_able_to_click_check_value_button() {
	  
		clickOnElement(By.xpath("//*[@id='buttoncheck']"));
	}
	
	@When("User click checkbox")
	public void user_click_checkbox() {
		clickOnElement(By.xpath("//*[@id='isAgeSelected']"));
	}

	@Then("User is able to see success message")
	public void user_is_able_to_see_success_message() throws InterruptedException {
		textPresent(driver.findElement(By.xpath("//*[@id='txtAge']")),"Success - Check box is checked");
	}

	
}
