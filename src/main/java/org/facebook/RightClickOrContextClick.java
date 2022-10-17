package org.facebook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class RightClickOrContextClick {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        WebElement rightClikEle= driver.findElement(By.xpath("//span[text()='right click me']"));
        Actions act=new Actions(driver);
        act.contextClick(rightClikEle).build().perform();
        List<WebElement> optionsList=driver.findElements(By.xpath("//ul[contains(@class,'context-menu-root')]/li/span"));
        for(WebElement e:optionsList){
            String text=e.getText();
            System.out.println(text);
            if(text.equals("Copy")){
                e.click();
                break;
            }
        }
    }
}
