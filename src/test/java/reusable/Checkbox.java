package reusable;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Checkbox extends OpenBrowser{

//CommonMethods common = new CommonMethods();

    @Test(priority = 0)
    public void openDifferentBrowsers() throws InterruptedException {
        openBrowser("webdriver.chrome.driver", "C:\\Users\\avinashkc\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe", "chrome");
        driver.get("http://demo.seleniumeasy.com/basic-checkbox-demo.html");
        boolean checked = driver.findElement(By.xpath("//*[@id='isAgeSelected']")).isSelected();
        boolean enable = driver.findElement(By.xpath("//*[@id='isAgeSelected']")).isEnabled();
        boolean visible = driver.findElement(By.xpath("//*[@id='isAgeSelected']")).isDisplayed();
        Assert.assertEquals(false,checked);
        Assert.assertEquals(true,enable);
        Assert.assertEquals(true,visible);

        if (checked==false) {
            //Validates if the text is not visible
            invisbleElement(driver.findElement(By.xpath("//*[@id='txtAge']")));
        }

        //Here the code is trying to select the webelement
        driver.findElement(By.xpath("//*[@id='isAgeSelected']")).click();
        boolean checked1 = driver.findElement(By.xpath("//*[@id='isAgeSelected']")).isSelected();
        Assert.assertEquals(true,checked1);
        String message = driver.findElement(By.xpath("//*[@id='txtAge']")).getText();
        getTextAssert("//*[@id='txtAge']","","Success - Check box is checked");

        //Validates if the text is visible
        visibleElement(driver.findElement(By.xpath("//*[@id='txtAge']")));
        textPresent(driver.findElement(By.xpath("//*[@id='txtAge']")),"Success - Check box is checked");
    }
    
    /**
     * Below code is to check cases for multiple checkbox
     * @throws InterruptedException 
     */


    @Test(priority = 1)
    public void multiCheckBox() throws InterruptedException{
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0,500).perform();
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        actions.sendKeys("Text").build().perform();

        List<WebElement> list = driver.findElements(By.xpath("//input[@class='cb1-element']"));
        for (WebElement l : list){
            System.out.println("Count "+list.size());
            Assert.assertEquals(true,l.isDisplayed());
            Assert.assertEquals(true, l.isEnabled());
            Assert.assertEquals(false,l.isSelected());
            visibleElement(driver.findElement(By.xpath("//input[@class='cb1-element']")));
//            invisbleElement(driver.findElement(By.xpath("//input[@class='cb1-element']")));
        }
        visibleElement(driver.findElement(By.xpath("//*[@value='Check All']")));
        driver.findElement(By.xpath("//label[text()='Option 1']/input")).click();
        driver.findElement(By.xpath("//label[text()='Option 2']/input")).click();
        driver.findElement(By.xpath("//label[text()='Option 3']/input")).click();
        visibleElement(driver.findElement(By.xpath("//*[@value='Uncheck All']")));
        actionClick(driver.findElement(By.xpath("//*[@value='Uncheck All']")));
        actionClick(driver.findElement(By.xpath("//*[@value='Check All']")));
        /*actions.click(driver.findElement(By.xpath("//*[@value='Uncheck All']"))).build().perform();
        actions.click(driver.findElement(By.xpath("//*[@value='Check All']"))).build().perform();*/
    }
}
