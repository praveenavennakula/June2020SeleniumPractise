package testngsessions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExpectedExceptionConcept {
    WebDriver driver;
    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.amazon.com");

    }
    @Test(expectedExceptions = ArithmeticException.class)
    public void searchTest() {
        System.out.println("searchTest");
        int i = 9/0;
        System.out.println("bye");//pass but  bye will not be printed as we are not handling the exception.Used when we want to show pass for all tests but not recommended
    }
    @Test(expectedExceptions = {NullPointerException.class, ArithmeticException.class})
    public void searchTestMultiException() {
        System.out.println("searchTest");
        try {
            int i = 9 / 0;
        }catch (Exception e){

        }
        System.out.println("bye");//fails..as we handled the exception, bye will be printed.
    }

}
