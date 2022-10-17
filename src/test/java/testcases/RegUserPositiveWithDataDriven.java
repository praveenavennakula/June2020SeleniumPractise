package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class RegUserPositiveWithDataDriven {
    WebDriver driver;
    @BeforeMethod
    public void setup() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

    }


    @DataProvider
    public Object[][] userRegData(){
        return new Object[][] {
                {"FNUSer1xyzwe","LNUser1xyzwe","Userabc1xyzwe@gmail.com","1234567890","User1@1"},
                {"FNUSer2xyzwe","LNUser2xyzwe","Userabc2xyzwe@gmail.com","2345678901","User2@1"},
                {"FNUSer3xyzwe","LNUser3xyzwe","Userabc3xyzwe@gmail.com","3456789012","User3@1"},
                {"FNUSer4xyzwe","LNUser4xyzwe","Userabc4xyzwe@gmail.com","4567890123","User4@1"},
                {"FNUSer5xyzwe","LNUser5xyzwe","Userabc5xyzwe@gmail.com","1567890234","User5@1"},
        };
    }

    @Test(dataProvider = "userRegData")
    public void doRegister(String firstName,String lastName,String email,String telephone,String password) {
        driver.findElement(By.id("input-firstname")).clear();
        driver.findElement(By.id("input-firstname")).sendKeys(firstName);
        driver.findElement(By.id("input-lastname")).clear();
        driver.findElement(By.id("input-lastname")).sendKeys(lastName);
        driver.findElement(By.id("input-email")).clear();
        driver.findElement(By.id("input-email")).sendKeys(email);
        driver.findElement(By.id("input-telephone")).clear();
        driver.findElement(By.id("input-telephone")).sendKeys(telephone);
        driver.findElement(By.id("input-password")).clear();
        driver.findElement(By.id("input-password")).sendKeys(password);
        driver.findElement(By.id("input-confirm")).clear();
        driver.findElement(By.id("input-confirm")).sendKeys(password);
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        String text=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1"))).getText();
        Assert.assertEquals(text,"Your Account Has Been Created!");


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

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
