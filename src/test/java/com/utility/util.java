package com.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class util {
    private static WebDriver driver;


    public static WebDriver getDriver() {
        String key="c";
        if (driver == null) {
            switch (key) {
                case "c":
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);
                    break;
                case "f":
                case "firefox":
                case "fox":
                case "fire":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);
                    break;
            }
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    // Create Selenium Objects
    // create WebDriverWait object
    public static WebDriverWait createWait() {
        return new WebDriverWait(driver , 10);
    }

    // create Actions object
    public static Actions createActions() {
        return new Actions(driver);
    }

    // create select object
    public static Select createSelect(WebElement element) {
        return new Select(element);
    }

    // Assert methods
    // title verification
    public static void titleVerification(String expectedTitle) {
        Assert.assertEquals(driver.getTitle() , expectedTitle); }
    public static void titleVerificationContains(String expectedTitle) {
        Assert.assertTrue(driver.getTitle().contains(expectedTitle)); }

    // url verification
    public static void urlVerification(String url) {
        Assert.assertEquals(driver.getCurrentUrl() , url);
    }
    public void urlVerificationContains(String url) {
        Assert.assertTrue(driver.getCurrentUrl().contains(url)); }

    // text verification
    public static void textVerification(WebElement element , String text) {
        Assert.assertEquals(element.getText() , text);
    }
    public static void textVerificationContains(WebElement element , String text) {
        Assert.assertTrue(element.getText().contains(text)); }

    // is displayed verification
    public static void isDisplayed(WebElement element) {
        Assert.assertTrue(element.isDisplayed());
    }

    // is selected verification
    public static void isSelected(WebElement element) { Assert.assertTrue(element.isSelected()); }

    // is enabled verification
    public static void isEnabled(WebElement element) { Assert.assertTrue(element.isEnabled()); }
}
