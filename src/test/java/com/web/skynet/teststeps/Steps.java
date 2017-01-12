package com.web.skynet.teststeps;

import com.web.skynet.pageobjects.HomePage;
import com.web.skynet.picocontainers.DriverContainer;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

/**
 * Created by pmadan on 12/21/16.
 */
public class Steps

{
    private DriverContainer driverContainer;
    private WebDriver driver;

    public Steps(DriverContainer container) {
        this.driverContainer = container;
    }

    /* @Given("^an end user has navigated to a website using a supported browser$")
     public void an_end_user_has_navigated_to_a_website_using_a_supported_browser(DataTable stepinfo) throws Throwable {
         for (Map<String, String> data : stepinfo.asMaps(String.class, String.class)) {

             System.out.println(data.get("website"));
             System.out.println(data.get("browser"));

         }
     }*/
    @Given("^an end user has navigated to a website using a supported browser$")
    public void an_end_user_has_navigated_to_a_website_using_a_supported_browser() throws Throwable {

        driver = driverContainer.getDriver("chrome");
        driver.get("http://www.priceline.com");
    }

    @When("^I enter destination as \"([^\"]*)\"$")
    public void i_enter_destination_as(String arg1) throws Throwable {
        HomePage homePage = new HomePage(driver);
        homePage.setDestination(arg1);
    }

    @When("^I enter CheckInDate as \"([^\"]*)\"$")
    public void i_enter_CheckInDate_as(String arg1) throws Throwable {

    }

    @When("^I enter CheckOutDate as \"([^\"]*)\"$")
    public void i_enter_CheckOutDate_as(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I select Rooms as \"([^\"]*)\"$")
    public void i_select_Rooms_as(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I click on Search$")
    public void i_click_on_Search() throws Throwable {

    }

    @Then("^I should see a list of hotels that match my criteria$")
    public void i_should_see_a_list_of_hotels_that_match_my_criteria() throws Throwable {

    }

    @Then("^I should not see a list of hotels that match my criteria$")
    public void i_should_not_see_a_list_of_hotels_that_match_my_criteria(String seenotsee) throws Throwable {
        if (seenotsee.isEmpty()) {

        } else {


        }

    }

    @Then("^I should see an error saying \"([^\"]*)\"$")
    public void i_should_see_an_error_saying(String arg1) throws Throwable {

    }


}