package org.facebook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MoveToElementConcept {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://mrbool.com/search/?txtsearch=how-to-create-menu-with-submenu-using-css-html");
        driver.manage().window().maximize();
        Thread.sleep(3000);
       /* Actions act=new Actions(driver);
        act.moveToElement(driver.findElement(By.className("menulink"))).build().perform();
        Thread.sleep(3000);
        driver.findElement(By.linkText("COURSES")).click();
        Thread.sleep(3000);*/
        By parentLoc=By.className("menulink");
        By childLoc=By.linkText("COURSES");
      //  handleLevel1MenuItems(parentLoc,childLoc);
        ElementUtil eleUtil=new ElementUtil(driver);
        eleUtil.handleLevel1MenuItems(parentLoc,childLoc);


    }
/*    public static WebElement getElement(By locator){
        return driver.findElement(locator);

    }
    public static void handleLevel1MenuItems(By parentLocator,By childLocator) throws InterruptedException {
        Actions act=new Actions(driver);
        act.moveToElement(getElement(parentLocator)).build().perform();
        Thread.sleep(3000);
        getElement(childLocator).click();
        Thread.sleep(3000);
    }*/
}
