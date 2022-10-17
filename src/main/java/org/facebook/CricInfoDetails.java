package org.facebook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class CricInfoDetails {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.espncricinfo.com/series/india-women-in-england-2022-1289245/england-development-squad-women-vs-india-women-warm-up-1332750/full-scorecard");
        driver.manage().window().maximize();
        Thread.sleep(3000);
       // ArrayList<String> scoreArray=new ArrayList<String>();
       /* List<WebElement> playerScoreCard=driver.findElements(By.xpath("//span[text()='Sabbhineni Meghana']/ancestor::td/following-sibling::td"));
        ArrayList<String> scoreArray=new ArrayList<String>();
        for(WebElement e:playerScoreCard){
            String text=e.getText();
           System.out.println(text);
           if(text.length()!=0) {
               scoreArray.add(text);
           }
        }*/
       // System.out.println(scoreArray);
        ArrayList<String> scoreArray=battingScoreDetails("Sabbhineni Meghana");
        System.out.println(scoreArray);
        ArrayList<String> bowlingScoreArray=bowlingScoreDetails("Grace Potts");
        System.out.println(bowlingScoreArray);
    }

    public static ArrayList<String> battingScoreDetails(String playername){
        List<WebElement> playerScoreCard=driver.findElements(By.xpath("//span[text()='"+playername+"']/ancestor::td/following-sibling::td"));
        ArrayList<String> scoreArray=new ArrayList<String>();
        for(WebElement e:playerScoreCard){
            String text=e.getText();
            System.out.println(text);
            if(text.length()!=0) {
                scoreArray.add(text);
            }
        }
        return scoreArray;
    }
    public static ArrayList<String> bowlingScoreDetails(String playername){
        List<WebElement> playerScoreCard=driver.findElements(By.xpath("//span[text()='"+playername+"']/ancestor::td/following-sibling::td"));
        ArrayList<String> scoreArray=new ArrayList<String>();
        for(WebElement e:playerScoreCard){
            String text=e.getText();
            System.out.println(text);
            if(text.length()!=0) {
                scoreArray.add(text);
            }
        }
        return scoreArray;
    }
}
