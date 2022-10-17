package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchProductWithDataDriven {
    WebDriver driver;
    @BeforeTest
    public void setup() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

    }


    @DataProvider
    public Object[][] productData(){
        return new Object[][] {
                {"Macbook"},
                {"iMac"},
                {"samsung"},

        };
    }

    @Test(dataProvider = "productData")
    public void doSearch(String productName) {
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys(productName);
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
        int prdtCount=driver.findElements(By.className("product-thumb")).size();
        Assert.assertTrue(prdtCount> 0);

    }

    public boolean doLogin(String userName,String password){
        driver.findElement(By.id("input-email")).clear();
        driver.findElement(By.id("input-email")).sendKeys(userName);
        driver.findElement(By.id("input-password")).clear();
        driver.findElement(By.id("input-password")).sendKeys(password);
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        boolean flag=driver.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible")).isDisplayed();
        return flag;

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
