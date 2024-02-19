package program;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Checkbox {

	WebDriver driver;
	WebDriverWait wait = null;
	
	@Test
	public void check() throws Exception {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\avinashkc\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.seleniumeasy.com/basic-checkbox-demo.html");
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(1));
//		singleBeforeCheck();
//		singleCheck();
//		singleAfterCheck();
		beforeCheck();		
//		multipleCheck();
		checkButton();
		afterCheck();		
		uncheckButton();
//		multipleUnCheck();
				
	}
	
	
	public void singleBeforeCheck() throws IOException {
		
		boolean check1 = driver.findElement(By.xpath("//*[@id='isAgeSelected']")).isSelected();
//		boolean enable = driver.findElement(By.xpath("//*[@id='isAgeSelected']")).isEnabled();
//		boolean visible = driver.findElement(By.xpath("//*[@id='isAgeSelected']")).isDisplayed();
		
		if(check1==true)
		{
			// Validate if text is not visible 
			wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//*[@id='txtAge']"))));
			
		}
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(scrFile, new File("../WorkShop/screenshot/screenshot2.png"));
		
	}
	
	public void singleAfterCheck() throws IOException {
		
		boolean check2 = driver.findElement(By.xpath("//*[@id='isAgeSelected']")).isSelected();
		Assert.assertEquals(true, check2);
		String msg = driver.findElement(By.xpath("//*[@id='txtAge']")).getText();
		Assert.assertEquals("Success - Check box is checked", msg);
		// Validates if text is visible
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='txtAge']"))));
		wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//*[@id='txtAge']")),"Success - Check box is checked"));
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(scrFile, new File("../WorkShop/screenshot/screenshot2.png"));
		
	}
	
	public void beforeCheck() throws IOException {
		
		boolean checked1 = driver.findElement(By.xpath("//*[@id=\'easycont\']/div/div[2]/div[2]/div[2]/div[1]/label/input")).isSelected();
		boolean checked2 = driver.findElement(By.xpath("//*[@id=\'easycont\']/div/div[2]/div[2]/div[2]/div[2]/label/input")).isSelected();
		boolean checked3 = driver.findElement(By.xpath("//*[@id=\'easycont\']/div/div[2]/div[2]/div[2]/div[3]/label/input")).isSelected();
		boolean checked4 = driver.findElement(By.xpath("//*[@id=\'easycont\']/div/div[2]/div[2]/div[2]/div[4]/label/input")).isSelected();
		if(checked1==false && checked2==false && checked3==false && checked4==false)
		{
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='check1' and @value='Check All']"))));
		}
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(scrFile, new File("../WorkShop/screenshot/screenshot2.png"));
	}
	
	public void afterCheck() throws IOException {
		
		boolean check5 = driver.findElement(By.xpath("//*[@id=\'easycont\']/div/div[2]/div[2]/div[2]/div[1]/label/input")).isSelected();
		Assert.assertEquals(true, check5);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='check1' and @value='Uncheck All']"))));
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(scrFile, new File("../WorkShop/screenshot/screenshot2.png"));
	}
	
	
	public void singleCheck() {
		
		driver.findElement(By.xpath("//*[@id=\'isAgeSelected\']")).click();
		
	}
	
	public void multipleCheck() {
		
		driver.findElement(By.xpath("//*[@id=\'easycont\']/div/div[2]/div[2]/div[2]/div[1]/label/input")).click();
		driver.findElement(By.xpath("//*[@id=\'easycont\']/div/div[2]/div[2]/div[2]/div[2]/label/input")).click();
		driver.findElement(By.xpath("//*[@id=\'easycont\']/div/div[2]/div[2]/div[2]/div[3]/label/input")).click();
		driver.findElement(By.xpath("//*[@id=\'easycont\']/div/div[2]/div[2]/div[2]/div[4]/label/input")).click();
		
	}
	
	public void multipleUnCheck() {
		
		driver.findElement(By.xpath("//*[@id=\'easycont\']/div/div[2]/div[2]/div[2]/div[1]/label/input")).click();
		driver.findElement(By.xpath("//*[@id=\'easycont\']/div/div[2]/div[2]/div[2]/div[2]/label/input")).click();
		driver.findElement(By.xpath("//*[@id=\'easycont\']/div/div[2]/div[2]/div[2]/div[3]/label/input")).click();
		driver.findElement(By.xpath("//*[@id=\'easycont\']/div/div[2]/div[2]/div[2]/div[4]/label/input")).click();
		
	}
	
	public void checkButton() throws IOException {
		
		driver.findElement(By.xpath("//*[@id=\'check1\']")).click();
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(scrFile, new File("../WorkShop/screenshot/screenshot2.png"));
		
	}
	
	public void uncheckButton() throws IOException {
		
		driver.findElement(By.xpath("//*[@id=\'check1\']")).click();
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(scrFile, new File("../WorkShop/screenshot/screenshot2.png"));
		
	}
	
	public void screenshot() throws IOException {
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(scrFile, new File("../WorkShop/screenshot/screenshot2.png"));
	}
}

