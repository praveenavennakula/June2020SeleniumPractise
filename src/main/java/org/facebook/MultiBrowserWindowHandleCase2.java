package org.facebook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class MultiBrowserWindowHandleCase2 {
    static WebDriver driver;

    /**
     * When you click SignUp button,it opens the signup form in the new tab call it as Browser popup.
     * Case2:Click one social media platform at a time,get the title and close the browser and switch to the parent browser.Do the same process for all the social media platforms
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        String parentWindowID = driver.getWindowHandle();
        By ln=By.xpath("(//div[@class='orangehrm-login-footer-sm']/a)[1]");
        By fb=By.xpath("(//div[@class='orangehrm-login-footer-sm']/a)[2]");
        By twtr=By.xpath("(//div[@class='orangehrm-login-footer-sm']/a)[3]");
        By yt=By.xpath("(//div[@class='orangehrm-login-footer-sm']/a)[4]");
        getSocialMediaTitle(ln,parentWindowID);
        getSocialMediaTitle(fb,parentWindowID);
        getSocialMediaTitle(twtr,parentWindowID);
        getSocialMediaTitle(yt,parentWindowID);

    }

    public static void getSocialMediaTitle(By locator,String parentID) throws InterruptedException {
        driver.findElement(locator).click();
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();
        while (it.hasNext()) {
            String windowID = it.next();
            System.out.println(windowID);
            driver.switchTo().window(windowID);
            String title = driver.getTitle();
            System.out.println(title);
            Thread.sleep(2000);
            if (!windowID.equals(parentID)) {
                driver.close();
            }


        }
        driver.switchTo().window(parentID);
        System.out.println(driver.getTitle());



    }
}
