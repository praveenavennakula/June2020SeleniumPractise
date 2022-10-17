package org.facebook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

      // System.setProperty("webdriver.chrome.driver","C:\\Users\\prade\\Praveena\\chromedriver99Win32.exe");
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.facebook.com/");
        String title= driver.getTitle();

        System.out.println("page title is: "+title);
        driver.close();

    }
}
