package org.facebook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MoveToElementNALAssignment {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://naveenautomationlabs.com/opencart/index.php");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        By parentLoc=By.linkText("Laptops & Notebooks");
        By childLoc=By.linkText("Show All Laptops & Notebooks");
        //  handleLevel1MenuItems(parentLoc,childLoc);
        ElementUtil eleUtil=new ElementUtil(driver);
        eleUtil.handleLevel1MenuItems(parentLoc,childLoc);


    }
}
