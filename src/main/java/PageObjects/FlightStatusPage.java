package PageObjects;

import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class FlightStatusPage {

    public FlightStatusPage(WebDriver webDriver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(webDriver, 15), this);
    }

    @FindBy(xpath = "//span[contains(text(), 'I understand')]/ancestor::span/ancestor::button")
    private WebElement consentCookies;

    @FindBy(xpath = "//div[@class='moodimagecontent']")
    private WebElement flightStatusSummary;

    @FindBy(xpath = "//span[contains(text(), 'Departure airport')]/ancestor::button")
    private WebElement departureButton;
    
    @FindBy(xpath = "//span[contains(text(), 'Destination airport')]/ancestor::button")
    private WebElement destinationButton;

    @FindBy(xpath = "//input[contains(@name, 'datepicker_input')]")
    private WebElement departureDate;

    @FindBy(xpath = "//input[contains(@id, 'station-select-')]")
    private WebElement airportInput;

    @FindBy(xpath = "//span[contains(text(), 'Show flight status')]/ancestor::button")
    private WebElement showFlightStatusButton;

    @FindBy(xpath = "//div[@class='calendar-date']")
    private WebElement calendar;

    @FindBy(xpath = "//div[contains(@class, 'o-search-flight-status__flight-list-cards')]")
    private WebElement flightResults;

    @FindBy(xpath = "//div[contains(@class, 'o-search-flight-status__card-flight-status')]")
    private WebElement flightsStatus;

    @FindBy(xpath = "//li[@class='o-search-flight-status__date-navigation__item']/button[contains(@class, 'active')]/div")
    private WebElement activeDate;

    public void clickConsentCookies() {
        consentCookies.isEnabled();
        consentCookies.click();
    }

    public boolean defaultHomePageIsDisplayed() {
        flightStatusSummary.isDisplayed();
        departureButton.isDisplayed();
        destinationButton.isDisplayed();
        departureDate.isDisplayed();
        return true;
    }

    public void selectDepartureAirport(String airport) {
        //TODO wait until element is clickable
        departureButton.isEnabled();
        departureButton.click();
        airportInput.sendKeys(airport);
        airportInput.sendKeys(Keys.ENTER);
    }

    public void selectDestinationAirport(String airport) {
        //TODO wait until element is clickable
        destinationButton.isEnabled();
        destinationButton.click();
        airportInput.sendKeys(airport);
        airportInput.sendKeys(Keys.ENTER);
    }

    public void selectDate(String date) {
        //TODO wait until element is clickable
        departureDate.isEnabled();
        departureDate.click();
        if(date.equals("today")){
            date = getDateToday();
        }
        WebElement validDate = calendar.findElement(By.xpath("//span[contains(text(), " + date + ")]/ancestor::div"));
        validDate.click();
    }

    public String getDateToday(){
        return String.valueOf(LocalDate.now().getDayOfMonth());
    }

    public void clickShowFlightStatusButton(){
        showFlightStatusButton.isEnabled();
        showFlightStatusButton.click();
    }

    public int flightResults(String date) {
        
        List<WebElement> listOfFlights = flightResults.findElements(By.xpath("//div[contains(@class, 'o-card-component__section--no-padding o-card-component__content')]"));

        if(date.equals("today")){
            date = getDateToday();
        }

        activeDate.isDisplayed();
        String dateValue = activeDate.getText().split(",")[1].split("/")[0];
        
        if(dateValue.equals(date)){
            return listOfFlights.size();
        }
        
        return 0;
    }

    public boolean flightStatusDisplayed() {
        flightsStatus.isDisplayed();
        return true;
    }

}

// a) Verify that flight routes from CGN to BER with different travel dates (e.g. today, tomorrow)
// are shown with the selected dates.
// b) Add any other tests, which you would like to automate