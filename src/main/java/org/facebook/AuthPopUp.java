package org.facebook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthPopUp {

        static WebDriver driver;

        public static void main(String[] args) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            String userName="admin";
            String passWord="admin";
            //below syntaxes doesn't work if we have @ in the credentials
           // driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
            driver.get("https://"+userName+":"+passWord+"@the-internet.herokuapp.com/basic_auth");
            String s=driver.findElement(By.tagName("p")).getText();
            System.out.println(s);

        }
}
