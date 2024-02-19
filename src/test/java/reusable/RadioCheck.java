package reusable;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class RadioCheck extends OpenBrowser {
	
	@Test
	public void reusable() throws IOException, InterruptedException  {
		loadProperty();
		openBrowser("webdriver.chrome.driver", "C:\\Users\\avinashkc\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe",p.getProperty("browserType"));
		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
		singleRadioMethod(By.xpath("//*[@id='easycont']/div/div[2]/div[1]/div[2]/label[1]/input"));
//		clickOnElement((By.xpath("//*[@id='buttoncheck']")));

	}

}
