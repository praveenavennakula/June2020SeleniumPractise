package org.facebook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertPopUp {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //1.Alert

/*      driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        Alert alert=driver.switchTo().alert();
        String jsalertText=alert.getText();
        System.out.println(jsalertText);
        alert.accept();
       // alert.dismiss();
        String alertResult=driver.findElement(By.id("result")).getText();
        System.out.println(alertResult);//same alert message for accept and dismiss*/

        //2.Confirmation Alert

/*        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Alert alert=driver.switchTo().alert();
        String jsConfirmAlertText=alert.getText();
        System.out.println(jsConfirmAlertText);
        Thread.sleep(1000);
      //  alert.sendKeys("abddfshe");//ElementNotInteractableException: element not interactable: User dialog does not have a text box input field.Thrown when an element is present in the DOM but interactions with that element will hit another element due to paint order
        //alert.accept();
        // alert.dismiss();
        String alertResult=driver.findElement(By.id("result")).getText();
        System.out.println(alertResult);*/

        //3.Prompt Alert
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Alert alert=driver.switchTo().alert();
        String jsPromptAlertText=alert.getText();
        System.out.println(jsPromptAlertText);
        Thread.sleep(1000);
        alert.sendKeys("test prompt");
       // alert.accept();//without any send keys
        alert.dismiss();
        //without any send keys if we accept the alert it show you entered:
        //with send keys if we accept the alert it show you entered:text
        //without any send keys if we dismiss the alert it show you entered:null
        //with send keys if we dismiss the alert it show you entered:null

        String alertResult=driver.findElement(By.id("result")).getText();

        System.out.println(alertResult);

                }
                }
