package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenCartTest extends BaseClass{




    @Test(priority = 0)
    public void searchTest() {
        boolean flag = driver.findElement(By.name("search")).isDisplayed();
        Assert.assertEquals(flag, true);

    }

    @Test(priority = 1)
    public void pageTitletest() {
        String title = driver.getTitle();
        Assert.assertEquals(title, "Account Login");
    }



}
