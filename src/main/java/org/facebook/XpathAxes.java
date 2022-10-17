package org.facebook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class XpathAxes {
    static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://classic.freecrm.com/index.html");
        driver.findElement(By.name("username")).sendKeys("AutomationUser");
        driver.findElement(By.name("password")).sendKeys("AutomationUser");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        driver.switchTo().frame("mainpanel");
        //  driver.findElement(By.linkText("Contacts")).click();//NSE
        driver.findElement(By.linkText("CONTACTS")).click();
        //driver.findElement(By.xpath(""));

/*        //to print specifc user details
        List<WebElement> userDetails=driver.findElements(By.xpath("//a[@_name='latha sanam']/parent::td/following-sibling::td"));
        for (int i=0;i<userDetails.size()-1;i++){
            String text=userDetails.get(i).getText();
            if (text.length()!=0){
                System.out.println(text);
            }

        }*/
        // to print all the rows
        List<WebElement> userDetails = driver.findElements(By.xpath("//form[@id=\"vContactsForm\"]//tbody/tr"));
        for (int i = 3; i < userDetails.size() - 1; i++) {
            String text = userDetails.get(i).getText();
            if (text.length() != 0) {
                System.out.println(text);
            }

        }


    }
}
