package org.facebook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MoveToElementBigBasketAssignment {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.bigbasket.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        By parent1Loc=By.xpath("//a[contains(@class,'meganav-shop')]");
        By parent2Loc=By.linkText("Bakery, Cakes & Dairy");
        By parent3Loc=By.linkText("Cookies, Rusk & Khari");
        By parent4Loc=By.linkText("Premium Cookies");
        By childLoc=By.linkText("Biscuits");
        //  handleLevel1MenuItems(parentLoc,childLoc);
        ElementUtil eleUtil=new ElementUtil(driver);
        eleUtil.handleLevel4MenuItems(parent1Loc,parent2Loc,parent3Loc,parent4Loc,childLoc);


    }
}
