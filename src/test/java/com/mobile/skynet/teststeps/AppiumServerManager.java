package com.mobile.skynet.teststeps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.service.local.AppiumDriverLocalService;

import java.io.IOException;


/**
 * Created by prajitmadan on 1/7/17.
 */
public class AppiumServerManager {
    static AppiumDriverLocalService service;


    public void startserver() {
        try {
            if (service == null) {
                service = AppiumDriverLocalService.buildDefaultService();
                service.start();
                // Provide wait time of 5 mins to start appium server properly.
                // If face any error(Could not start a new session...) then Increase
                // this time to 15 or 20 mins.
                Thread.sleep(5000);
                System.out.println("Appium server Is started now.");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void stopserver() {
        if (service != null) {
            service.stop();
        }
        System.out.println("Appium server Is stopped now.");
    }
}

