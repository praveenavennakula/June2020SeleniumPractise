package org.facebook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MoveToElementSpiceJetAssignment {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.spicejet.com/");
        driver.manage().window().maximize();
        Thread.sleep(5000);
      //  driver.switchTo().alert().accept();
     //   Thread.sleep(5000);
       /* Actions act=new Actions(driver);
        act.moveToElement(driver.findElement(By.className("menulink"))).build().perform();
        Thread.sleep(3000);
        driver.findElement(By.linkText("COURSES")).click();
        Thread.sleep(3000);*/
        By parentLoc=By.xpath("//div[text()='Add-ons']");
        By childLoc=By.xpath("//div[text()='Friends and Family']");
        //  handleLevel1MenuItems(parentLoc,childLoc);
        ElementUtil eleUtil=new ElementUtil(driver);
        eleUtil.handleLevel1MenuItems(parentLoc,childLoc);


    }
}
