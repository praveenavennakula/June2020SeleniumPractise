package org.facebook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IFramesHandling {
    static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");
        driver.findElement(By.xpath("//img[@title='vehicle-registration-forms-and-templates']")).click();
        driver.switchTo().frame("frame-one748593425");//if we don't switch NoSuchElementException: no such element: Unable to locate element:
        driver.findElement(By.id("RESULT_TextField-8")).sendKeys("testing automation");



    }
}
