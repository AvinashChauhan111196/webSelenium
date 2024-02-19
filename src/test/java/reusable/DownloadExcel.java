package reusable;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DownloadExcel extends OpenBrowser{

	WebDriver driver;
	Actions a = new Actions(driver);
	
	@Test
	public void reusable() throws IOException, InterruptedException  {
		loadProperty();
		openBrowser("webdriver.chrome.driver", "C:\\Users\\avinashkc\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe",p.getProperty("browserType"));
		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
		
		
		a.moveToElement(driver.findElement(By.id("ui-id-2"))).click().build().perform();
        a.moveToElement(driver.findElement(By.xpath("//*[@id=\"ui-id-4\"]/span"))).click().build().perform();
        a.click(driver.findElement(By.xpath("//ul/li/a[text()='Excel']"))).build().perform();
}
}
