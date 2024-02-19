package reusable;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DragDrop extends OpenBrowser{
	
	@Test
	public void reusable() throws IOException, InterruptedException  {
		loadProperty();
		openBrowser("webdriver.chrome.driver", "C:\\Users\\avinashkc\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe",p.getProperty("browserType"));
		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
		
		dragDrop(driver.findElement(By.xpath("//*[@id='todrag']")),driver.findElement(By.xpath("//*[@id='mydropzone']")));
}
}
