package org.facebook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownHandling {
   static WebDriver driver;
    public static void main(String[] args){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");

        // drop down : select tag is mandatory
        // tag name : select --> option
        // Select class in Selenium
     //   WebElement country = driver.findElement(By.id("Form_getForm_Country"));
     //   country.sendKeys("India");//works only if the html tag is select
       // Select sel=new Select(country);
    //    sel.selectByIndex(5);
      //  sel.selectByVisibleText("India");
      //  sel.selectByValue("Brazil");
        By country= By.id("Form_getForm_Country");
/*        List<WebElement> countryOptions=sel.getOptions();
        System.out.println("total number of countries: "+(countryOptions.size()-1));//because country is not an option so removing it from count

        for(WebElement e: countryOptions){
            String text=e.getText();
            System.out.println(text);
        }*/

        //using same class reusable static methods
      //  doSelectByVisibleText(country,"India");
      //  doSelectByIndex(country,7);
     //   doSelectByValue(country,"canada");
     //   List<WebElement> countryOptions=getDropDownOptions(country);
      //  System.out.println("total number of countries: "+(getDropDownOptionsCount(country)-1));

        ElementUtil eleUtil=new ElementUtil(driver);
    //    eleUtil.doSelectByIndex(country,5);
      //  eleUtil.doSelectByValue(country,"India");
       // eleUtil.doSelectByVisibleText(country,"Canada");
        List<WebElement> countryOptions=eleUtil.getDropDownOptions(country);
        System.out.println(eleUtil.getDropDownOptionsCount(country));

    }

    public static void doSelectByVisibleText(By locator,String text){
        Select sel=new Select(getElement(locator));
        sel.selectByVisibleText(text);


    }
    public static void doSelectByIndex(By locator,int index){
        Select sel=new Select(getElement(locator));
        sel.selectByIndex(6);


    }
    public static void doSelectByValue(By locator,String value){
        Select sel=new Select(getElement(locator));
        sel.selectByValue(value);


    }

    public static WebElement getElement(By locator){
        return driver.findElement(locator);
    }

    public static List<WebElement> getDropDownOptions(By locator){
        Select sel=new Select(getElement(locator));
       return sel.getOptions();

    }

    public static int getDropDownOptionsCount(By locator){
        return getDropDownOptions(locator).size();
    }
}
