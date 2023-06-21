package Managers;

import PageObjects.FlightStatusPage;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    private final WebDriver webDriver;
    private FlightStatusPage flightStatusPage;

    public PageObjectManager(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public FlightStatusPage getFlightStatusPage() {
        return (flightStatusPage == null) ? flightStatusPage = new FlightStatusPage(webDriver) : flightStatusPage;
    }
}
