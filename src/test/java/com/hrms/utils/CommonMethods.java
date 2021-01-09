package com.hrms.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CommonMethods {
    protected static WebDriver driver;

    /**
     * this method open a browser, set up configuration and navigate to the url
     */
    @BeforeMethod(alwaysRun = true)
    public static void setUp() {

        ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        switch (ConfigsReader.getPropertyValue("browser").toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Invalid browser");
        }
        driver.get(ConfigsReader.getPropertyValue("url"));
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);

    }

    /**
     * this method will close any open browser
     */
    @AfterMethod(alwaysRun = true)
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    /**
     * This method will clear a textBox and send text to it
     * @param element
     * @param textToSend
     */
     public static void sendText(WebElement element, String textToSend) {
        element.clear();
        element.sendKeys(textToSend);

     }

    /**
     * This method will return an object of Explicit wait with time set to 20 sec
     * @return WebDriverWait
     */

     public static WebDriverWait getWait(){
         WebDriverWait wait=new WebDriverWait(driver, Constants.EXPLICIT_WAIT);
         return  wait;
     }

    /**
     * tis method will wait until given element becomes clickable
     * @param element
     */
     public  static void waitForClickability(WebElement element){
         getWait().until(ExpectedConditions.elementToBeClickable(element));

     }

    /**
     * this method will wait until teh element is clickable and then click on it
     * @param element
     */
    public  static void click(WebElement element){
        waitForClickability(element);
        element.click();

    }




}

