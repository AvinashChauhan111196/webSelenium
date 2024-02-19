package reusable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Pattern;

public class OpenBrowser {

	public static WebDriver driver = null;
	EdgeOptions edgeOp = new EdgeOptions();

	static WebDriverWait wait;
	public static Actions actions = null;
	public Properties p;
	String filepath = "./src/test/java/reusable/config.properties";
	static boolean select;

	public void openDifferentBrowsers() throws InterruptedException {
		openBrowser("webdriver.chrome.driver",
				"C:\\Users\\avinashkc\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe", "chrome");
//        driver.manage().window().maximize();
		driver.get("https://www.google.com");
		Thread.sleep(1000);
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//*[@id='yDmH0d']/c-wiz/div/div/c-wiz/div/div/div/div[2]/div[2]/button")).click();
	}

	public WebDriver openBrowser(String key, String value, String browserName) {

		if (browserName.equals("chrome")) {
			System.setProperty(key, value);
			driver = new ChromeDriver();
		}

		if (browserName.equals("edge")) {
			System.setProperty(key, value);
			edgeOp.addArguments("--start-maximized");
			driver = new EdgeDriver(edgeOp);
		}

		if (browserName.equals("firefox")) {
			System.setProperty(key, value);
			driver = new FirefoxDriver();
		}
		return driver;

		/*
		 * if(browserName.equals("safari")){ System.setProperty(key,value); driver = new
		 * SafariDriver(); }
		 */
	}

	/*
	 * Different resuable methods for expected conditions
	 */
	public static void invisbleElement(WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(1));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public static void visibleElement(WebElement element) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(1));
		wait.until(ExpectedConditions.visibilityOf(element));
//		element.click();
		
	}

	public static void textPresent(WebElement element, String message) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(1));
		wait.until(ExpectedConditions.textToBePresentInElement(element, message));
//		element.click();
		Thread.sleep(2000);
	}

	public static void elementClickBy(By element) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(1));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(element)));
//		driver.findElement(element).click();
		Thread.sleep(2000);
	}

	public static void elementClickWebelement(WebElement element) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(1));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		//element.click();
		Thread.sleep(2000);
	}

	public static void elementStateBy(By element, boolean select) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(1));
		wait.until(ExpectedConditions.elementSelectionStateToBe(driver.findElement(element), select));
//		driver.findElement(element).click();
		Thread.sleep(2000);
	}

	public static void elementStateWebElement(WebElement element, boolean select) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(1));
		wait.until(ExpectedConditions.elementSelectionStateToBe(element, select));
//		element.click();
		Thread.sleep(2000);
	}

	// same text to be present
	public static void elementTextToBe(By element, String msg) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(1));
		wait.until(ExpectedConditions.textToBe(element, msg));
		Thread.sleep(2000);
	}

	// some part of text to be present
	public static void elementText(By element, String msg) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(1));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(element, msg));
		Thread.sleep(2000);
	}

	// value attribute
	public static void elementValueBy(By element, String msg) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(1));
		wait.until(ExpectedConditions.textToBePresentInElementValue(element, msg));
//		driver.findElement(element).click();
		Thread.sleep(2000);
	}

	public static void elementValueWebElement(WebElement element, String msg) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(1));
		wait.until(ExpectedConditions.textToBePresentInElementValue(element, msg));
//		element.click();
		Thread.sleep(2000);
	}

	// true case
	public static void elementSelWebElement(WebElement element) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.elementToBeSelected(element));
		element.click();
		Thread.sleep(2000);
	}

	// true case
	public static void elementSelBy(By element) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.elementToBeSelected(driver.findElement(element)));
		driver.findElement(element).click();
		Thread.sleep(2000);
	}

	public static void getTextAssert(String locatorValue, String assertActual, String assertExpected) {
		assertActual = driver.findElement(By.xpath(locatorValue)).getText();
		Assert.assertEquals(assertActual, assertExpected);

	}

	public static void actionClick(WebElement element) {
		actions = new Actions(driver);
		actions.click(element).build().perform();
	}

	public static void enterText(WebElement element, String s) {
		actions = new Actions(driver);
		actions.sendKeys(element, s);
	}

	public void loadProperty() throws IOException {

		p = new Properties();
		InputStream str = new FileInputStream(filepath);
		p.load(str);
	}

	public static boolean isSelected(By key) {
		return driver.findElement(key).isSelected();
	}

	public static boolean isEnabled(By key) {
		return driver.findElement(key).isEnabled();
	}

	public static boolean isDisplayed(By key) {
		return driver.findElement(key).isDisplayed();
	}

	public static void clickOnElement(By key) {
		driver.findElement(key).click();
	}

	public static void clickRadioButton(By key) {
		driver.findElement(key).click();
	}

	public static void singleCheckboxMethod(By key) throws InterruptedException {
		select = isSelected(key);
		Assert.assertEquals(false, select);
		boolean enable = isEnabled(key);
		Assert.assertEquals(true, enable);
		boolean display = isDisplayed(key);
		Assert.assertEquals(true, display);
		clickOnElement(key);
		select = isSelected(key);
		Assert.assertEquals(true, select);
		visibleElement(driver.findElement(key));
		elementClickBy(key);
		elementClickWebelement(driver.findElement(key));
	}

	public static void singleRadioMethod(By key) throws InterruptedException {
		select = isSelected(key);
		Assert.assertEquals(false, select);
		boolean enable = isEnabled(key);
		Assert.assertEquals(true, enable);
		boolean display = isDisplayed(key);
		Assert.assertEquals(true, display);
		clickOnElement(key);
		elementClickBy(key);
		select = isSelected(key);
		Assert.assertEquals(true, select);
		visibleElement(driver.findElement(key));
		
		
	}

	public static void singleSelect(By element, String day) throws InterruptedException {
		
		Select s = new Select(driver.findElement(element));
		s.selectByValue(day);
		visibleElement(driver.findElement(element));
		

	}

	

	public static void dragDrop(WebElement fromElement, WebElement toElement) {
		
		Actions builder = new Actions(driver);
		builder.clickAndHold(fromElement).moveToElement(toElement).release().build().perform();
		
	}
	
	public static void alertBox() throws InterruptedException {

//		clickOnElement(key);
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
	}


	public static void promptEnterText() throws InterruptedException {

//		clickOnElement(key);
		Thread.sleep(2000);
		driver.switchTo().alert().sendKeys("avinash");
	}

	public static void promptDismiss() throws InterruptedException {

//		clickOnElement(key);
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();
	}
	
	public void closeBrowser() {
		driver.close();
		
	}
	
	public void tearDown() {
		driver.quit();
	}
	
	public static void dropdowncheck(By element, String country) throws InterruptedException {
        Select s = new Select(driver.findElement(element));
        s.selectByValue(country);
        visibleElement(driver.findElement(element));
        
       
    }

 

 

    public static void Multiselect(By element, String country1, String country2) {        
        Select Sel = new Select(driver.findElement(element));
        if (Sel.isMultiple()) {
            Sel.selectByVisibleText(country1);
            Sel.selectByVisibleText(country2);
        }


    }

    public static void window(By key) throws InterruptedException {
    	
    	clickOnElement(key);
    	Thread.sleep(2000);
    	String mainWindowHandle = driver.getWindowHandle();
		 driver.switchTo().window(mainWindowHandle);
		 System.out.println("Title of the page is " + driver.getTitle());
            }

    
    
}
