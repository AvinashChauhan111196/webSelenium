package reusable;

import java.io.IOException;


import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class JQuerySelect extends OpenBrowser{

	@Test
	public void reusable() throws IOException, InterruptedException  {
		loadProperty();
		openBrowser("webdriver.chrome.driver", "C:\\Users\\avinashkc\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe",p.getProperty("browserType"));
		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
		
		dropdowncheck(By.xpath("//*[@id='country']"),"Australia");
		Multiselect(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div[2]/select"),"Indiana","Alaska");
	
}
}
