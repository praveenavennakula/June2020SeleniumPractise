package testngsessions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AmazonTest {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.amazon.com");

    }

    @Test(priority = 0)
    public void searchTest() {
        boolean flag = driver.findElement(By.id("twotabsearchtextbox")).isDisplayed();
        Assert.assertEquals(flag, true);

    }

    @Test(priority = 2)
    public void pageTitletest() {
        String title = driver.getTitle();
        Assert.assertEquals(title, "Amazon.com. Spend less. Smile more.");
    }

    @Test(priority = 1)
    public void logoTest() {
        boolean flag = driver.findElement(By.id("nav-logo-sprites")).isDisplayed();
        Assert.assertEquals(flag, true);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
