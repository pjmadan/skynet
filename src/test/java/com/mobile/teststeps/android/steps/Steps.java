package com.mobile.teststeps.android.steps;

import com.mobile.screenobjects.ColumnChartActivityScreen;
import com.mobile.screenobjects.LineChartActivityScreen;
import com.mobile.picocontainers.AppiumDriverContainer;
import com.mobile.screenobjects.HomeScreen;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.Assert;


/**
 * Created by prajitmadan on 1/7/17.
 */
public class Steps {

    private AppiumDriver<? extends MobileElement> driver;
    private AppiumDriverContainer appiumDriverContainer;

    public Steps(AppiumDriverContainer appiumContainer) {
        this.appiumDriverContainer = appiumContainer;
    }

    @Given("^an end user has installed the Hello Charts Android application and has launched it and is on the home screen$")
    public void an_end_user_has_installed_the_Hello_Charts_Android_application_and_has_launched_it_and_is_on_the_home_screen() throws Throwable {

        driver = appiumDriverContainer.getDriver("android");
        HomeScreen homeScreen = new HomeScreen(driver);
        Assert.assertTrue(homeScreen.istextpresent("HelloCharts"));
    }


    @When("^I click on Line Chart button$")
    public void i_click_on_Line_Chart_button() throws Throwable {
        HomeScreen homeScreen = new HomeScreen(driver);
        homeScreen.clickchart("line");
    }

    @Then("^I should see a the label for Linechartactivity$")
    public void i_should_see_a_the_label_for_Linechartactivity() throws Throwable {
        LineChartActivityScreen lineChartActivityScreen = new LineChartActivityScreen(driver);
        Assert.assertTrue(lineChartActivityScreen.istextpresent("linechartactivity"));
    }

    @Then("^I should see a Line Chart$")
    public void i_should_see_a_Line_Chart() throws Throwable {

        LineChartActivityScreen lineChartActivityScreen = new LineChartActivityScreen(driver);
        Assert.assertTrue(lineChartActivityScreen.ischartpresent());
    }

    @When("^I click on ColumnChartActivity button$")
    public void i_click_on_ColumnChartActivity_button() throws Throwable {

        HomeScreen homeScreen = new HomeScreen(driver);
        homeScreen.clickchart("column");
    }

    @Then("^I should see a the label for ColumnChartActivity$")
    public void i_should_see_a_the_label_for_ColumnChartActivity() throws Throwable {

        ColumnChartActivityScreen columnChartActivityScreen = new ColumnChartActivityScreen(driver);
        Assert.assertTrue(columnChartActivityScreen.istextpresent("columnchartactivity"));
    }

    @Then("^I should see a Column Chart$")
    public void i_should_see_a_Column_Chart() throws Throwable {

        ColumnChartActivityScreen columnChartActivityScreen = new ColumnChartActivityScreen(driver);
        Assert.assertTrue(columnChartActivityScreen.ischartpresent());
    }

}
