package org.facebook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class BrowserWindowHandle {
    static WebDriver driver;

    /**
     * When you click SignUp button,it opens the signup form in the new tab call it as Browser popup.
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://classic.crmpro.com/index.html");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        driver.findElement(By.linkText("Sign Up")).click();
        Set<String> handles=driver.getWindowHandles();
        Iterator<String> it=handles.iterator();
        String parentWindowID= it.next();
        System.out.println(parentWindowID);
        String childWindowID= it.next();
        System.out.println(childWindowID);
        driver.switchTo().window(childWindowID);
        driver.findElement(By.name("first_name")).sendKeys("Testing");
        driver.close();//when we close the child window where driver is present, driver is lost
        driver.switchTo().window(parentWindowID);
        System.out.println(driver.getTitle());

    }
}
