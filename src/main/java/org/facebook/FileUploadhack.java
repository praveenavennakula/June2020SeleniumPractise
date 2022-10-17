package org.facebook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadhack {

    //with out clicking the choose file we can upload the file,but make sure input tag has type="file" attribute
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.name("upfile")).sendKeys("C:\\Users\\prade\\OneDrive\\Desktop\\format.jfif");
    }
}
