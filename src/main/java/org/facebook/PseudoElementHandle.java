package org.facebook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PseudoElementHandle {
    //PseudoElements:Not a html tag,not part of DOM but inside the DOM called Pseudo Elements.
    //Ex: * beside FirstName is a pseudo element which is declared with ::before
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        String fn="input-firstname";
      //  String script="return window.getComputedStyle(document.querySelector(\"label[for='"+fn+"']\"),'::before').getPropertyValue('content');\n";
       /* JavascriptExecutor jse=(JavascriptExecutor)driver;
        String man_field=jse.executeScript(script).toString();
        System.out.println(man_field);
        if(man_field.contains("*")){
            System.out.println("First Name is Mandatory ");
        }
        else{
            System.out.println("First Name is not Mandatory");
        }*/
/*        ElementUtil eleUtil=new ElementUtil(driver);
        checkElementIsMandatory(script);*/

        checkElementIsMandatory("input-firstname");
        checkElementIsMandatory("input-lastname");
        checkElementIsMandatory("input-email");
        checkElementIsMandatory("input-telephone");
        checkElementIsMandatory("input-password");
        checkElementIsMandatory("input-confirm");



    }
 /*   public static boolean checkElementIsMandatory(String jsScript)
    {
        JavascriptExecutor jse=(JavascriptExecutor)driver;
        String man_field=jse.executeScript(jsScript).toString();
        System.out.println(man_field);
        if(man_field.contains("*")){
            System.out.println("First Name is Mandatory ");
            return true;
        }
        else{
            System.out.println("First Name is not Mandatory");
            return false;
        }
    }*/
    public static boolean checkElementIsMandatory(String fieldName){
        String script="return window.getComputedStyle(document.querySelector(\"label[for='"+fieldName+"']\"),'::before').getPropertyValue('content');\n";
        JavascriptExecutor jse=(JavascriptExecutor)driver;
        String man_field=jse.executeScript(script).toString();
        System.out.println(man_field);
        if(man_field.contains("*")){
            System.out.println("Element is Mandatory ");
            return true;
        }
        else{
            System.out.println("Element is not Mandatory");
            return false;
        }

    }

}
