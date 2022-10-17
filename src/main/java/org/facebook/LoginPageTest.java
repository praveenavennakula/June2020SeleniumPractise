package org.facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageTest {
    public static void main(String[] args) throws Exception {
        BrowserUtil brUtil=new BrowserUtil();
       WebDriver driver= brUtil.launchBrowser("chrome");
        brUtil.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        System.out.println(brUtil.getPageTitle());
        System.out.println(brUtil.getPageUrl());

        By email=By.id("input-email");
        By password=By.id("input-password");
        ElementUtil elementUtil=new ElementUtil(driver);
        elementUtil.doSendKeys(email,"test@gmail.com");
        elementUtil.doSendKeys(password,"test@123");



    }
}