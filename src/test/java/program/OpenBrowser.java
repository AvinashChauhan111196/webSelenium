package program;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class OpenBrowser {

	
//	WebDriver d = new EdgeDriver();
	
	
	@Test
	public void open() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\avinashkc\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
//		System.setProperty("webdriver.edge.driver","C:\\Users\\avinashkc\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		driver.get("https://www.google.com");
		
	}
	
}	



