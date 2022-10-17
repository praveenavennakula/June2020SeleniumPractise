package org.facebook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDOM {
    //1.element is present in the below path
    //browser--> Page-->Iframe(#document)-->#shadow-root
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://selectorshub.com/xpath-practice-page/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
      driver.switchTo().frame("pact");
      JavascriptExecutor jse=(JavascriptExecutor)driver;//we need to Cast the driver to execute JavaScript
        //executescript gives the DOM ele,so we need to convert it to WebElement to Act upon it in JAVA
        WebElement e=(WebElement)jse.executeScript("return document.querySelector(\"#snacktime\").shadowRoot.querySelector(\"#tea\")");
        e.sendKeys("YES");

        //driver.findElement(By.id("tea")).sendKeys("YES");
    }
}
