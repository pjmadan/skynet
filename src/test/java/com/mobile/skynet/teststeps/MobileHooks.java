package com.mobile.skynet.teststeps;

import com.mobile.skynet.picocontainers.AppiumDriverContainer;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * Created by prajitmadan on 1/9/17.
 */
public class MobileHooks {
    private AppiumDriver<? extends MobileElement> driver;

    @Before("@android")
    public void runbefore() {

        AppiumDriverContainer driverContainer = new AppiumDriverContainer();
        driver = driverContainer.getDriver("android");
        if (driver.isAppInstalled("lecho.lib.hellocharts.samples")) {
            System.out.println("THE APP IS INSTALLED. UNINSTALLING...");
            driver.removeApp("lecho.lib.hellocharts.samples");
            driver.installApp("/Users/prajitmadan/Library/Android/sdk/platform-tools/test.apk");
            driver.launchApp();
        } else {
            driver.installApp("/Users/prajitmadan/Library/Android/sdk/platform-tools/test.apk");
            driver.launchApp();
        }

    }

    @After("@android")
    public void runafter() {
        driver.closeApp();
        driver.removeApp("lecho.lib.hellocharts.samples");
    }

    @Before("@ios")
    public void runbeforeios() {

        AppiumDriverContainer driverContainer = new AppiumDriverContainer();
        driver = driverContainer.getDriver("ios");
        if (driver.isAppInstalled("simulator.app")) {
            System.out.println("THE APP IS INSTALLED. UNINSTALLING...");
            driver.removeApp("IntegrationApp.app");
            driver.installApp("/Users/prajitmadan/Library/Developer/Xcode/DerivedData/WebDriverAgent-brdadhpuduowllgivnnvuygpwhzy/Build/Products/Debug-iphonesimulator/IntegrationApp.app");
            driver.launchApp();

            // this will give us element information for xcui
            System.out.println(driver.getPageSource());
        } else {
            driver.installApp("/Users/prajitmadan/Library/Developer/Xcode/DerivedData/WebDriverAgent-brdadhpuduowllgivnnvuygpwhzy/Build/Products/Debug-iphonesimulator/IntegrationApp.app");
            driver.launchApp();
        }
    }

    @After("@ios")
    public void runafterios() {
        driver.closeApp();
        driver.removeApp("IntegrationApp.app");

    }
}
