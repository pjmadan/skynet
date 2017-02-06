package com.mobile.screenobjects;

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
public class LineChartActivityScreen {
    private RemoteWebDriver appiumDriver;

    @FindBy(id = ("lecho.lib.hellocharts.samples:id/chart"))
    private MobileElement chartActivty;


    @FindBy(xpath = ("//android.widget.TextView[@text='LineChartActivity']"))
    private MobileElement lineChartName;

    private int implicitWaitTime;

    public LineChartActivityScreen(AppiumDriver<? extends MobileElement> driver) {

        this.appiumDriver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, implicitWaitTime,
                TimeUnit.SECONDS), this);

    }


    public boolean istextpresent(String text) {

        if (text.equalsIgnoreCase(lineChartName.getText())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean ischartpresent() {

        return lineChartName.isDisplayed();
    }

}
