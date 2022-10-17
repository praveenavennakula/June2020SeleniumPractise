package org.facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegAlertTest {
    public static void main(String[] args) throws Exception {
        BrowserUtil brUtil = new BrowserUtil();
        WebDriver driver = brUtil.launchBrowser("chrome");
        brUtil.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
        brUtil.getPageTitle();
        brUtil.getPageUrl();

        By ctnuBtn=By.xpath("//*[@id=\"content\"]/form/div/div/input[2]");
        By alertmsg=By.className("alert");
        By firstNamewarng=By.xpath("//*[@id=\"account\"]/div[2]/div/div");
        By lastNamewarng=By.xpath("//*[@id=\"account\"]/div[3]/div/div");
        By emailwarng=By.xpath("//*[@id=\"account\"]/div[4]/div/div");
        By telephoneewarng=By.xpath("//*[@id=\"account\"]/div[5]/div/div");
        By passwordwarng=By.xpath("//*[@id=\"content\"]/form/fieldset[2]/div[1]/div/div");

        ElementUtil elementUtil = new ElementUtil(driver);
        elementUtil.doClick(ctnuBtn);
        String alertmshval= elementUtil.doGetText(alertmsg);
        String firstNamewarngval= elementUtil.doGetText(firstNamewarng);
        String lastNamewarngval= elementUtil.doGetText(lastNamewarng);
        String emailwarngval= elementUtil.doGetText(emailwarng);
        String telephoneewarngval= elementUtil.doGetText(telephoneewarng);
        String passwordwarngval= elementUtil.doGetText(passwordwarng);

        System.out.println(alertmshval);
        System.out.println(firstNamewarngval);
        System.out.println(lastNamewarngval);
        System.out.println(emailwarngval);
        System.out.println(telephoneewarngval);
        System.out.println(passwordwarngval);

    }
}
