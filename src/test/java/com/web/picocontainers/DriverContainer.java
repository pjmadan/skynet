package com.web.picocontainers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


/**
 * Created by pmadan on 12/25/16.
 */
public class DriverContainer {

    private static Boolean IS_INITIALIZED = false;
    private static Boolean IS_CHROME_INITIALIZED = false;
    private static Boolean IS_FIREFOX_INITIALIZED = false;
    private static WebDriver chromedriver;
    private static WebDriver firefoxdriver;

    public DriverContainer() {

        if(!IS_INITIALIZED) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver");
            ChromeDriver driver = new ChromeDriver();
            IS_CHROME_INITIALIZED = true;
            this.chromedriver = driver;


/*
        FirefoxDriver foxDriver = new FirefoxDriver();
        IS_FIREFOX_INITIALIZED = true;
        this.firefoxdriver = foxDriver;
*/

            IS_INITIALIZED = true;
        }
    }


    public WebDriver getDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            return this.chromedriver;

        }
        if (browser.equalsIgnoreCase("firefox")) {
            return this.firefoxdriver;
        }

        return null;

    }

}
