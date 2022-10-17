package org.facebook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationPractise {


        static WebDriver driver;

        public static void main(String[] args) throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get("http://automationpractice.com/index.php");
            ElementUtil eleUtil=new ElementUtil(driver);
            By searchloc=By.id("search_query_top");
            By suggloc=By.xpath("//div[@class='ac_results']/ul/li");
            By textVal=By.tagName("h1");
            eleUtil.dosearch(searchloc,"dress",suggloc,"Casual Dresses > Printed Dress");
            String headName=eleUtil.doGetText(textVal);
            System.out.println(headName);
            if(headName.equals("Printed Dress")){
                System.out.println("PASS");
            }
        }
}
