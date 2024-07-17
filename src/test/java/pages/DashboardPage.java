package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DashboardPage {

    private WebDriver driver;
    private By usernameDisplay = By.xpath("//a[@id='userNameDisplay']");
    private By trainingTab = By.xpath("//a[contains(text(),'Training')]");
    private By calendarDaysTable = By.cssSelector(".fc-daygrid-day-number");
    private By eventTitle = By.xpath("//input[@id='eventTitle']");
    private By createEventButton = By.xpath("//button[@id='createEventButton']");
    private By eventsCreated = By.cssSelector(".fc-event");
    private Wait<WebDriver> wait;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public String getUsernameDisplay() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameDisplay));
        return driver.findElement(usernameDisplay).getText();
    }

    public TrainingsPage clickOnTraining() {
        driver.findElement(trainingTab).click();
        return new TrainingsPage(driver);
    }

    public List<WebElement> calendarDays(){
        return driver.findElements(calendarDaysTable);
    }

    public List<WebElement> eventsCreated(){
        return driver.findElements(eventsCreated);
    }

    public void clickSpecificDayOnCalendar(String date){
        for (WebElement element : calendarDays()){
            if (element.getAttribute("aria-label").equals(date)){
                element.click();
            }
        }
    }

    public boolean isEventCreated(String event){
        wait.until(ExpectedConditions.visibilityOfElementLocated(eventsCreated));
        for (WebElement element : eventsCreated()){
            if (element.getText().equals(event)){
                return true;
            }
        }
        return false;
    }

    public void setEventTitle(String event){
        wait.until(ExpectedConditions.visibilityOfElementLocated(eventTitle));
        driver.findElement(eventTitle).sendKeys(event);
    }

    public void clickOnCreateEventButton(){
        driver.findElement(createEventButton).click();
    }




}
