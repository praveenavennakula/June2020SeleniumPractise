package org.facebook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSPractise {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        WebElement loginbtn=driver.findElement(By.xpath("//input[@value='Login']"));
      //  WebElement emailID=driver.findElement(By.id("input-email"));
        String bgcolor=loginbtn.getCssValue("backgroundColor");
        System.out.println(bgcolor);
        String color="rgb(255,255,255)";
        JavascriptExecutor jse=(JavascriptExecutor)driver;
        for (int i = 0; i < 300; i++) {
           // jse.executeScript("arguments[0].style.backgroundColor='" + color + "'", loginbtn);
           /* jse.executeScript("arguments[0].style.backgroundColor = '" + color + "'", emailID);
            jse.executeScript("arguments[0].style.backgroundColor = '" + bgcolor + "'", emailID);*/
            jse.executeScript("arguments[0].style.backgroundColor = '" + color + "'", loginbtn);
            jse.executeScript("arguments[0].style.backgroundColor = '" + bgcolor + "'", loginbtn);
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
            }
        }

    }
}
