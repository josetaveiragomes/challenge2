package StepDefinitions;

import PageObjects.FlightStatusPage;
import Utilities.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class FlightStatusSteps {

    FlightStatusPage flightStatusPage;
    TestContext testContext;

    public FlightStatusSteps(TestContext context) {
        testContext = context;
        flightStatusPage = testContext.getPageObjectManager().getFlightStatusPage();
    }

    @Given("I am in the Flight Status Page")
    public void i_am_in_the_flight_status_page() {
        flightStatusPage.clickConsentCookies();
        Assert.assertTrue(flightStatusPage.defaultHomePageIsDisplayed());
    }

    @When("I add {string} as departure")
    public void i_add_as_departure(String departure) {
        flightStatusPage.selectDepartureAirport(departure);
        //TODO ASSERT THE DEPARTURE IS IN THE INPUT BOX
    }

    @When("I add {string} as destination")
    public void i_add_as_destination(String destination) {
        flightStatusPage.selectDestinationAirport(destination);
        //TODO ASSERT THE DESTINATION IS IN THE INPUT BOX
    }

    @When("I add {string} as date")
    public void i_add_as_date(String date) {
        flightStatusPage.selectDate(date);
        //TODO ASSERT THE DEPARTURE DATE IS IN THE INPUT BOX
    }

    @When("I press the Show flight status button")
    public void i_press_the_show_flight_status_button() {
        flightStatusPage.clickShowFlightStatusButton();
    }

    @Then("the flights should be for the date {string}")
    public void the_flights_should_be_for_the_date(String date) {
        Assert.assertTrue(flightStatusPage.flightResults(date) > 0);
    }

    @Then("the flights should have a status")
    public void the_flights_should_have_a_status() {
       Assert.assertTrue(flightStatusPage.flightStatusDisplayed());
    }
}
