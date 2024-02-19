package program;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenWithoutGet {

	
	@Test
	public void open() throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\avinashkc\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.google.com");
		System.out.println("Title of the page is " + driver.getTitle());
//		File f = new File("C:\\Users\\avinashkc\\eclipse-workspace\\demo.txt");
//		f.createNewFile();
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(scrFile, new File("../WorkShop/screenshot/screenshot2.png"));
		driver.switchTo().frame(0);
	    driver.findElement(By.xpath("//*[@id='yDmH0d']/c-wiz/div/div/c-wiz/div/div/div/div[2]/div[2]/button")).click();
	    File scrFile2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(scrFile2, new File("../WorkShop/screenshot/screenshot3.png"));
		Assert.assertEquals(driver.getTitle(), "Google");
		
	
	}
	
}
	
