package org.facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigateTest {

    public static void main(String[] args) throws Exception {

         BrowserUtil brUtil=new BrowserUtil();
         WebDriver driver=brUtil.launchBrowser("chrome");
         brUtil.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
         brUtil.getPageTitle();
         brUtil.getPageUrl();
         By regLink=By.linkText("Register");
         By forgotPassword=By.linkText("Forgotten Password");
         By myAcct=By.linkText("My Account");
        ElementUtil eleUtil=new ElementUtil(driver);
        eleUtil.doClick(regLink);
        brUtil.getPageTitle();
        brUtil.getPageUrl();
        brUtil.navBack();
        brUtil.getPageTitle();
        brUtil.getPageUrl();
        eleUtil.doClick(forgotPassword);
        brUtil.getPageTitle();
        brUtil.getPageUrl();
        brUtil.navBack();
        brUtil.getPageTitle();
        brUtil.getPageUrl();
        eleUtil.doClick(myAcct);
        brUtil.getPageTitle();
        brUtil.getPageUrl();
        brUtil.navBack();
        brUtil.getPageTitle();
        brUtil.getPageUrl();

    }
}
