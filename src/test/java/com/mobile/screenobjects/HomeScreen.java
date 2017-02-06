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
public class HomeScreen {

    private RemoteWebDriver appiumDriver;

    @FindBy(xpath = ("//android.widget.TextView[@text='Line Chart']"))
    private MobileElement lineChartName;


    @FindBy(xpath = ("//android.widget.TextView[@text='HelloCharts']"))
    private MobileElement hometext;


    @FindBy(xpath = ("//android.widget.TextView[@text='Column Chart']"))
    private MobileElement columnChartName;

    private int implicitWaitTime;

    public HomeScreen(AppiumDriver<? extends MobileElement> driver) {

        this.appiumDriver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, implicitWaitTime,
                TimeUnit.SECONDS), this);

    }


    public void clickchart(String chartName) {
        if (chartName.equalsIgnoreCase("line")) {
            lineChartName.click();


        }

        if (chartName.equalsIgnoreCase("column")) {
            columnChartName.click();


        }

    }

    public boolean istextpresent(String text) {

        if (text.equalsIgnoreCase(hometext.getText())) {
            return true;
        } else {
            return false;
        }
    }


}
