package org.facebook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.URL;

public class BrowserUtil {
   private  WebDriver driver;

    /**
     * this method is used to initialize the browser based on the browser name
     */

    public WebDriver launchBrowser(String browser) throws Exception {
        System.out.println("Browser name is :" + browser);
        switch (browser) {
            case "chrome":
                //System.setProperty("webdriver.chrome.driver", "/Users/naveenautomationlabs/Downloads/chromedriver");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "safari":
                //  WebDriverManager.safaridriver().setup();//setup is not required for safari
                driver = new SafariDriver();
                break;
            default:
                System.out.println("please pass the right browser");
                throw new Exception("WRONGBROWSEREXCEPTION");

        }
        return driver;
    }


    /**
     * This methos is used to launch the URL
     */

    public void launchURL(String url) throws Exception {
        if (url == null) {
            System.out.println("URL is null");
            throw new Exception("URL is null");
        }
        if (url.length() == 0) {
            System.out.println("URL is blank");
            throw new Exception("URL is blank");
        }
        if (url.indexOf("http") != 0 && url.indexOf("https") != 0) {
            System.out.println("Http(s) is missing in the URL");
            throw new Exception("Http(s) is missing in the URL");
        }
        driver.navigate().to(url);
    }

    /**
     * This overloaded method is used to launch the URL
     */
    public void launchURL(URL url) throws Exception {
        String newURL = String.valueOf(url);
        if (newURL == null) {
            System.out.println("URL is null");
            throw new Exception("URL is null");
        }
        if (newURL.length() == 0) {
            System.out.println("URL is blank");
            throw new Exception("URL is blank");
        }
        if (newURL.indexOf("http") != 0 && newURL.indexOf("https") != 0) {
            System.out.println("Http(s) is missing in the URL");
            throw new Exception("Http(s) is missing in the URL");
        }
        driver.navigate().to("https://www.google.com");
    }

    /**
     * This wrapper method is used to get the page  title
     *
     * @return
     */

    public String getPageTitle() {
        String title = driver.getTitle();
        System.out.println("Page Title is: " + title);
        if (title != null) {
            return title;
        } else {
            System.out.println("getting null title");
            return null;
        }
    }

    /**
     * This wrapper method is used to get the current page url
     *
     * @return
     */
    public String getPageUrl() {
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Page URL is: " + currentUrl);
        if (currentUrl != null) {
            return currentUrl;
        } else {
            System.out.println("getting null URL");
            return null;
        }
    }

    /**
     * this wrapper method is used to close the browser
     */

    public void closeBrowser() {
        if (driver != null) {
            driver.close();
            System.out.println("Browser is closed");
        }
    }


    /**
     * this wrapper method is used to close the browser
     */

    public void quitBrowser() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser is closed");
        }
    }

    /**
     * this method is used to navigate back
     */

    public void navBack(){
        driver.navigate().back();
    }
}
