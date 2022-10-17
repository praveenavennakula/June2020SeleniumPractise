package org.facebook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SVGElements {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();
      //  driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[text()='✕']")).click();

    //    driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']")).sendKeys("Macbook");
       // driver.findElement(By.xpath("//button[@type='submit']")).click();//works fine
      //  driver.findElement(By.xpath("//*[local-name()='svg']//ancestor::button[@type='submit']")).click();//works fine no need to use SVG
        driver.findElement(By.xpath("//*[local-name()='svg' and contains(@class,'fL')]")).click();


    }

}
