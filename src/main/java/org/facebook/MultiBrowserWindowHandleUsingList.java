package org.facebook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MultiBrowserWindowHandleUsingList {
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
        //   String parentWindowID = driver.getWindowHandle();
        driver.findElement(By.xpath("(//div[@class='orangehrm-login-footer-sm']/a)[1]")).click();

        Set<String> handles = driver.getWindowHandles();
        List<String> handlesList = new ArrayList<String>(handles);//top casting
        //  ArrayList<String> handlesList=new ArrayList<String>(handles);  //allowed
        String parentWindowID = handlesList.get(0);
        System.out.println(parentWindowID);
        String childWindowID = handlesList.get(1);
        System.out.println(childWindowID);
        driver.switchTo().window(childWindowID);
        Thread.sleep(2000);
        String title = driver.getTitle();
        System.out.println(title);
        driver.close();
        driver.switchTo().window(parentWindowID);
        System.out.println(driver.getTitle());

    }
}
