package org.facebook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsScrolling {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://amazon.com");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        Actions act=new Actions(driver);
        act.sendKeys(Keys.PAGE_DOWN).build().perform();
    }
}
