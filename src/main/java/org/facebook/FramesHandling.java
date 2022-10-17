package org.facebook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FramesHandling {
    static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://www.londonfreelance.org/courses/frames/index.html");
        List<WebElement> noOfFrames=driver.findElements(By.tagName("frame"));
        System.out.println("Number of Frames in the WebPage: "+noOfFrames.size());
       // driver.switchTo().frame(2);
      //  driver.switchTo().frame(driver.findElement(By.name("main")));
        driver.switchTo().frame("main");
        String header=driver.findElement(By.xpath("/html/body/h2")).getText();
        System.out.println(header);
        driver.switchTo().defaultContent();


    }
}
