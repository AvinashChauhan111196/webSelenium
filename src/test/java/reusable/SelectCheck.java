package reusable;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SelectCheck extends OpenBrowser {

	@Test
	public void reusable() throws IOException, InterruptedException  {
		loadProperty();
		openBrowser("webdriver.chrome.driver", "C:\\Users\\avinashkc\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe",p.getProperty("browserType"));
		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
		singleSelect(By.xpath("//*[@id=\"select-demo\"]"),"Monday");
//		singleSelect(By.xpath("*[@id=\"select-demo\"]/option"),"Monday");
		
	}
	
}
