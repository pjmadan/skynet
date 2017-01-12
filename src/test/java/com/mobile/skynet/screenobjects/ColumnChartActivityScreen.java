package com.mobile.skynet.screenobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by prajitmadan on 1/7/17.
 */
public class ColumnChartActivityScreen {
    private RemoteWebDriver appiumDriver;

    @FindBy(id = ("lecho.lib.hellocharts.samples:id/chart"))
    private MobileElement chartActivty;


    @FindBy(xpath = ("//android.widget.TextView[@text='ColumnChartActivity']"))
    private MobileElement columnChartName;

    private int implicitWaitTime;

    public ColumnChartActivityScreen(AppiumDriver<? extends MobileElement> driver) {

        this.appiumDriver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, implicitWaitTime,
                TimeUnit.SECONDS), this);

    }


    public boolean istextpresent(String text) {

        if (text.equalsIgnoreCase("columnchartactivity")) {
            return chartActivty.isDisplayed();
        } else {
            return false;
        }
    }

    public boolean ischartpresent() {

        return columnChartName.isDisplayed();
    }

}
