package reusable;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Frame extends OpenBrowser{
	
	@Test
	public void reusable() throws IOException, InterruptedException  {
		loadProperty();
		openBrowser("webdriver.chrome.driver", "C:\\Users\\avinashkc\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe",p.getProperty("browserType"));
		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
		
		clickOnElement(By.xpath("//*[@id='content']/div/ul/li[2]/a"));
		driver.switchTo().frame("mce_0_ifr");
		driver.findElement(By.xpath("//*[@id='tinymce']/p")).sendKeys(" hello world ");
}
}
