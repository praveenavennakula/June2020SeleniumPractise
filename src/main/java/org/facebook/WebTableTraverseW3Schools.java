package org.facebook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableTraverseW3Schools {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/html/html_tables.asp");
        int rowCount = getRowCount();
        System.out.println(rowCount);
        int colCount = getColCount();
        System.out.println(colCount);
      //  getSpecificColumnData(3,rowCount);
        //getSpecificRowData(2,colCount);
        tableData(colCount,rowCount);
    }

    public static int getRowCount() {

        return driver.findElements(By.xpath("//table[@id='customers']//tr")).size();

    }

    public static int getColCount() {
        return driver.findElements(By.xpath("//table[@id='customers']//th")).size();
    }

    public static void getSpecificColumnData(int colNumber,int rowCount){
        //*[@id="customers"]/tbody/tr[2]/td[1]
        String beforeXpath="//*[@id=\"customers\"]/tbody/tr[";
        String afterXpath="]/td["+colNumber+"]";
        for(int i=2;i<=rowCount;i++){
            String actualXpath=beforeXpath+i+afterXpath;
          //  System.out.println(actualXpath);
            String text=driver.findElement(By.xpath(actualXpath)).getText();
            System.out.println(text);
        }

    }
    public static void getSpecificRowData(int rowNumber,int colCount){
        //*[@id="customers"]/tbody/tr[2]/td[1]
        String beforeXpath="//*[@id=\"customers\"]/tbody/tr["+rowNumber+"]/td[";
        String afterXpath="]";
        for(int i=1;i<=colCount;i++){
            String actualXpath=beforeXpath+i+afterXpath;
             // System.out.println(actualXpath);
            String text=driver.findElement(By.xpath(actualXpath)).getText();
            System.out.println(text);
        }

    }

    public static void tableData(int colCount,int rowCount){

       for (int j=2;j<=rowCount;j++){
           for(int i=1;i<=colCount;i++){
           //*[@id="customers"]/tbody/tr[2]/td[1]
           String actualXpath="//*[@id=\"customers\"]/tbody/tr["+j+"]/td["+i+"]";
         //  System.out.println(actualXpath);
           String text=driver.findElement(By.xpath(actualXpath)).getText();
           System.out.println(text);
       }
   }
    }
}
