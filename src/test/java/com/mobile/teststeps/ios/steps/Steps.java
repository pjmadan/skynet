package com.mobile.teststeps.ios.steps;

import com.mobile.picocontainers.AppiumDriverContainer;
import com.mobile.screenobjects.HomeScreen;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.Assert;

/**
 * Created by prajitmadan on 1/10/17.
 */
public class Steps {
    private AppiumDriver<? extends MobileElement> driver;
    private AppiumDriverContainer appiumDriverContainer;

    public Steps(AppiumDriverContainer appiumContainer) {
        this.appiumDriverContainer = appiumContainer;
    }
    @Given("^an end user has installed the Deportes iOS application and has launched it and is on the home screen$")
    public void an_end_user_has_installed_the_Deportes_iOS_application_and_has_launched_it_and_is_on_the_home_screen() throws Throwable {
        driver = appiumDriverContainer.getDriver("ios");
        HomeScreen homeScreen = new HomeScreen(driver);
        Assert.assertTrue(homeScreen.istextpresent("HelloCharts"));
    }

    @When("^I click on the first content displayed on the app$")
    public void i_click_on_the_first_content_displayed_on_the_app() throws Throwable {

    }

    @Then("^I should see the content load correctly$")
    public void i_should_see_the_content_load_correctly() throws Throwable {

    }

}
