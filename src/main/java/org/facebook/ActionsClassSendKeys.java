package org.facebook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClassSendKeys {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
        driver.manage().window().maximize();
        Thread.sleep(3000);
      //  driver.findElement(By.id("input-firstname")).sendKeys("Testing");//just enters the keys
        Actions act=new Actions(driver);
        act.sendKeys("Testing");//first clicks the element and enters the keys
    }
}
