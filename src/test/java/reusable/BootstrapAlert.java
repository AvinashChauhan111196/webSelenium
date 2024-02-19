package reusable;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class BootstrapAlert extends OpenBrowser{

	@Test
	public void reusable() throws IOException, InterruptedException  {
		loadProperty();
		openBrowser("webdriver.chrome.driver", "C:\\Users\\avinashkc\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe",p.getProperty("browserType"));
		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
		
		clickOnElement(By.xpath("//*[@id='autoclosable-btn-success']"));
		visibleElement(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[1]")));
		clickOnElement(By.xpath("//*[@id='normal-btn-success']"));
		visibleElement(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]")));
		Thread.sleep(5000);
		invisbleElement(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[1]")));
		clickOnElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/button"));
	}
}
