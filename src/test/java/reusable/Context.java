package reusable;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Context extends OpenBrowser{

	@Test
	public void reusable() throws IOException, InterruptedException  {
		loadProperty();
		openBrowser("webdriver.chrome.driver", "C:\\Users\\avinashkc\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe",p.getProperty("browserType"));
		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
		
		Actions a = new Actions(driver);
		a.contextClick(driver.findElement(By.xpath("//*[@id='hot-spot']")));
		
	
}
}
