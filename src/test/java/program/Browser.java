package program;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Browser {

	WebDriver driver;
	
	public void setup(String browser) throws Exception{
		
		if(browser.equalsIgnoreCase("firefox")){
		
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\avinashkc\\Downloads\\geckodriver-v0.32.0-win-aarch64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		else if(browser.equalsIgnoreCase("chrome")){
			
			System.setProperty("webdriver.chrome.driver","C:\\Users\\avinashkc\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
			
			driver = new ChromeDriver();
		}
		
				else if(browser.equalsIgnoreCase("Edge")){
					
					System.setProperty("webdriver.edge.driver","C:\\Users\\avinashkc\\Downloads\\msedgedriver.exe");
					
					driver = new EdgeDriver();
				}
		else{
			
			throw new Exception("Browser is not correct");
		}
	}
	
	@Test
	public void open() throws Exception {
		
		setup("chrome");
		driver.get("https://www.google.com");
	}
	
	
	
}
