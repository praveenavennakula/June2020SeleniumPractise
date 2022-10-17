package org.facebook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class WebTableTraverse {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.espncricinfo.com/series/india-women-in-england-2022-1289245/england-development-squad-women-vs-india-women-warm-up-1332750/full-scorecard");
        driver.manage().window().maximize();
        Thread.sleep(10000);
        int rowCount = getRowCount();
        System.out.println(rowCount);
        int colCount = getColCount();
        System.out.println(colCount);

    }

    public static int getRowCount() {
        //  return driver.findElements(By.xpath("(//table[@class=\"ds-w-full ds-table ds-table-md ds-table-auto  ci-scorecard-table\"])[1]//tr")).size();//0 ele
        //  List< WebElement > playerScoreCard=driver.findElements(By.xpath("//table[contains(@class,'ci-scorecard-table')]"));//2
        List<WebElement> playerScoreCard = driver.findElements(By.xpath("(//table[contains(@class,'ci-scorecard-table')])[1]//tr"));//27--dev tools giving me 16
       /* [[ChromeDriver: chrome on WINDOWS (2fb9725ef2b52a288f652550a0ef60ef)] -> xpath: (//table[contains(@class,'ci-scorecard-table')])[1]//tr]:Sabbhineni Meghana
                41 30 2 3 136.66
                [[ChromeDriver: chrome on WINDOWS (2fb9725ef2b52a288f652550a0ef60ef)] -> xpath: (//table[contains(@class,'ci-scorecard-table')])[1]//tr]:c Beaumont b Gibson

                in dev tools they seem to be under a single row,that's why its giving 16
                but here its counting bowler,catcher details as a separate row,that's why its giving 27.
               1.why there is a difference?
               2.how can i identify in the dev tools

                */

        System.out.println(playerScoreCard.size());
        ArrayList<String> scoreArray = new ArrayList<String>();
        for (WebElement e : playerScoreCard) {
            String text = e.getText();
            System.out.println(e + ":" + text);
            if (text.length() != 0) {
                scoreArray.add(text);
            }
        }
        System.out.println(scoreArray);
        return playerScoreCard.size();
    }

    public static int getColCount() {
        List<WebElement> playerScoreCard = driver.findElements(By.xpath("(//table[contains(@class,'ci-scorecard-table')])[1]//th"));//8--dev tools giving me 8
        System.out.println(playerScoreCard.size());
        ArrayList<String> scoreArray = new ArrayList<String>();
        for (WebElement e : playerScoreCard) {
            String text = e.getText();
            System.out.println(e + ":" + text);
            if (text.length() != 0) {
                scoreArray.add(text);
            }
        }
        System.out.println(scoreArray);
        return playerScoreCard.size();

    }
}
