package org.facebook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class MultiBrowserWindowHandle {
    static WebDriver driver;

    /**
     * When you click SignUp button,it opens the signup form in the new tab call it as Browser popup.
     * Case1:Click all the Social media platforms at the same time and go to each window ,get the title and close except the parent browser.
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
        driver.findElement(By.xpath("(//div[@class='orangehrm-login-footer-sm']/a)[1]")).click();
        driver.findElement(By.xpath("(//div[@class='orangehrm-login-footer-sm']/a)[2]")).click();
        driver.findElement(By.xpath("(//div[@class='orangehrm-login-footer-sm']/a)[3]")).click();
        driver.findElement(By.xpath("(//div[@class='orangehrm-login-footer-sm']/a)[4]")).click();
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();
        while (it.hasNext()) {
            String windowID = it.next();
            System.out.println(windowID);
            driver.switchTo().window(windowID);
            String title = driver.getTitle();
            Thread.sleep(2000);
            if (!windowID.equals(parentWindowID)) {
                driver.close();
            }


        }
        driver.switchTo().window(parentWindowID);
        System.out.println(driver.getTitle());
    }


}
