package org.facebook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil {
    private WebDriver driver;
    public JavaScriptUtil(WebDriver driver){
        this.driver=driver;

    }

    public void flash(WebElement element){
        String bgColor= element.getCssValue("backgroundColor");
    }

}
