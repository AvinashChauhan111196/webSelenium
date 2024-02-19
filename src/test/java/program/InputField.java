package program;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InputField {

	WebDriver driver;
	
	@Test
	public void check() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\avinashkc\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.seleniumeasy.com/basic-first-form-demo.html");
		singleField();
		multipleField();
		
	}
	
	
	public void singleField() {
		
		driver.findElement(By.xpath("//*[@id='user-message' and @class='form-control']")).sendKeys("a");
		driver.findElement(By.xpath("//*[@id='get-input']/button")).click();
		String msg = driver.findElement(By.xpath("//*[@id=\"user-message\"]/label")).getText();
		Assert.assertEquals("Your Message:", msg);
	}
	
	public void multipleField() {
		
		driver.findElement(By.xpath("//*[@id=\'sum1\']")).sendKeys("5");
		driver.findElement(By.xpath("//*[@id=\'sum2\']")).sendKeys("5");
		driver.findElement(By.xpath("//*[@id=\'gettotal\']/button")).click();
		String msg2 = driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div/label")).getText();
		Assert.assertEquals("Total a + b =", msg2);
		
	}
	
}
