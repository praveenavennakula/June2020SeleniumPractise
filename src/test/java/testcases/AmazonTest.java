package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonTest extends BaseClass{




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

}
