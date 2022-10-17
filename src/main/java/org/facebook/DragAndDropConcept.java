package org.facebook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropConcept {
    //Selenium Supports element to element drag and drop option
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        WebElement sourceElement= driver.findElement(By.xpath("//p[text()='Drag me to my target']"));
        WebElement targetElement= driver.findElement(By.xpath("//p[text()='Drop here']"));
        Actions act=new Actions(driver);
     //   act.clickAndHold(sourceElement).moveToElement(targetElement).release().build().perform();
        act.dragAndDrop(sourceElement,targetElement).build().perform();




    }
}
