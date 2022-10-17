package org.facebook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessIncognitoConcept {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions co = new ChromeOptions();
        //  co.setHeadless(true);
        co.addArguments("--headless");
        //disadvantages of headless:
        // JS popup,Action mouse movements may not work as expected in headless mode//not an industrial practise
        co.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(co);
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.quit();
    }
}
