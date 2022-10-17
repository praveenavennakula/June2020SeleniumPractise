package testcases;

import org.facebook.BrowserUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass {
    WebDriver driver;
    @Parameters({"url","browser"})
    @BeforeTest
    public void setup(String url,String browser) throws Exception {
      /*  WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();*/
        BrowserUtil brutil=new BrowserUtil();
        driver=brutil.launchBrowser(browser);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(url);

    }
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
