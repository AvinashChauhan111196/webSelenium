package reusable;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Alert extends OpenBrowser{

	@Test
	public void reusable() throws IOException, InterruptedException  {
		loadProperty();
		openBrowser("webdriver.chrome.driver", "C:\\Users\\avinashkc\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe",p.getProperty("browserType"));
		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
		
		//Only accepts Okay button
		clickOnElement(By.xpath("//*[@id='easycont']/div/div[2]/div[1]/div[2]/button"));
		alertBox();
		
		//Accepts both okay and cancel button
		clickOnElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/button"));
		alertBox();
//		promptDismiss();
		
		//Enter you name, click & cancel
		
		clickOnElement(By.xpath("//*[@id='easycont']/div/div[2]/div[3]/div[2]/button"));
		promptEnterText();
		alertBox();
//		promptEnterText();
//		promptDismiss();
	}
	
}
