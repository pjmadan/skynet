package com.mobile.skynet.picocontainers;

import com.controlcenter.skynet.controller.manager.TestManager;
import com.skynet.common.utils.ConfigurationHelper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Created by prajitmadan on 1/7/17.
 */
public class AppiumDriverContainer {
    private static Boolean IS_INITIALIZED = false;
    private static Boolean IS_ANDROID_INITIALIZED = false;
    private static Boolean IS_IOS_INITIALIZED = false;
    private static AppiumDriver<AndroidElement> androidDriver;
    private static AppiumDriver<IOSElement> iosDriver;
    private static String platformName;

    public AppiumDriverContainer() {
        try {
            ConfigurationHelper configurationHelper = new ConfigurationHelper();
            this.platformName=configurationHelper.getpropertyvalue(("platformName"));

            if (!IS_INITIALIZED) {
                if (platformName.equalsIgnoreCase("android")) {
                    File classpathRoot = new File(System.getProperty("user.dir"));
                    File appDir = new File(classpathRoot, "../../../Library/Android/sdk/platform-tools");
                    File app = new File(appDir, "test.apk");
                    DesiredCapabilities androidCapabilities = new DesiredCapabilities();
                    androidCapabilities.setCapability("deviceName", "Android Emulator");
                    androidCapabilities.setCapability("automationName", "Appium");
                    androidCapabilities.setCapability("platformName", "Android");
                    androidCapabilities.setCapability("platformVersion", "7.1");
                    androidCapabilities.setCapability("app", app.getAbsolutePath());
                    androidCapabilities.setCapability("appPackage", "lecho.lib.hellocharts.samples");
                    androidCapabilities.setCapability("noReset", true);
                    androidCapabilities.setCapability("fullReset", false);


                    androidDriver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), androidCapabilities);
                    WebDriverWait wait = new WebDriverWait(androidDriver, 30);
                    wait.until(ExpectedConditions.elementToBeClickable(By
                            .xpath("//android.widget.TextView[@text='Line Chart']")));
                }

                if (platformName.equalsIgnoreCase("ios")) {
                    File classpathRoot = new File(System.getProperty("user.dir"));
                    File iosappDir = new File(classpathRoot, "../../../Library/Developer/Xcode/DerivedData/WebDriverAgent-brdadhpuduowllgivnnvuygpwhzy/Build/Products/Debug-iphonesimulator");
                    File iosapp = new File(iosappDir, "IntegrationApp.app");
                    DesiredCapabilities iosCapabilities = new DesiredCapabilities();
                    iosCapabilities.setCapability("appium version", "1.6");
                    iosCapabilities.setCapability("deviceName", "iPhone Simulator");
                    iosCapabilities.setCapability("platformVersion", "10.2");
                    iosCapabilities.setCapability("app", iosapp.getAbsolutePath());
                    iosCapabilities.setCapability("noReset", true);
                    iosCapabilities.setCapability("fullReset", false);
                    iosDriver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), iosCapabilities);
                    IS_IOS_INITIALIZED = true;
                    IS_INITIALIZED = true;

                    IS_ANDROID_INITIALIZED = true;
                    IS_INITIALIZED = true;
                }
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public AppiumDriver<? extends MobileElement> getDriver(String platform) {
        if (platform.equalsIgnoreCase("android")) {
            return this.androidDriver;

        }
        if (platform.equalsIgnoreCase("ios")) {
            return this.iosDriver;
        }

        return null;

    }


}
