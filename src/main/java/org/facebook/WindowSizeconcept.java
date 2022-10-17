package org.facebook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowSizeconcept {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().setSize(new Dimension(500,400));
        Thread.sleep(1000);
       // driver.manage().window().minimize();
     //   driver.manage().window().fullscreen();
        Thread.sleep(3000);
    }
}
