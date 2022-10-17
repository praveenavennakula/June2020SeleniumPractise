package org.facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegPageTest {
    public static void main(String[] args) throws Exception {
        BrowserUtil brUtil = new BrowserUtil();
        WebDriver driver = brUtil.launchBrowser("chrome");
        brUtil.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
        brUtil.getPageTitle();
        brUtil.getPageUrl();
/*
        using ID locator
        By firstName=By.id("input-firstname");
        By lastName=By.id("input-lastname");
        By email=By.id("input-email");
        By telePhone=By.id("input-telephone");
        By password=By.id("input-password");
        By passwordConfirm=By.id("input-confirm");

*/
        //using id,name locators
        By firstName = By.name("firstname");
        By lastName = By.name("lastname");
        By email = By.name("email");
        By telePhone = By.id("input-telephone");
        By password = By.id("input-password");
        By passwordConfirm = By.id("input-confirm");

        ElementUtil elementUtil = new ElementUtil(driver);
        elementUtil.doSendKeys(firstName, "TestUser");
        elementUtil.doSendKeys(lastName, "Automation");
        elementUtil.doSendKeys(email, "test@gmail.com");
        elementUtil.doSendKeys(telePhone, "123456");
        elementUtil.doSendKeys(password, "test@123");
        elementUtil.doSendKeys(passwordConfirm, "test@123");

        driver.quit();

    }
}
