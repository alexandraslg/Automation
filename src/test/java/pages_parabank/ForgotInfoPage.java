package pages_parabank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ForgotInfoPage {

    private WebDriver driver;
    private By firstNameField = By.xpath("//input[@id='firstName']");
    private By lastNameField = By.xpath("//input[@id='lastName']");
    private By addressField = By.xpath("//input[@id='address.street']");
    private By cityField = By.xpath("//input[@id='address.city']");
    private By stateField = By.xpath("//input[@id='address.state']");
    private By zipCodeField = By.xpath("//input[@id='address.zipCode']");
    private By ssnField = By.xpath("//input[@id='ssn']");
    private By findMyLoginInfoButton = By.xpath("//input[@value='Find My Login Info']");
    private By loginInformation = By.xpath("//*[@id='rightPanel']/p[2]");
    private Wait<WebDriver> wait;

    public ForgotInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setFirstNameInfo(String firstName){
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void setLastNameInfo(String lastName){
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void setAddressInfo(String address){
        driver.findElement(addressField).sendKeys(address);
    }

    public void setCityInfo(String city){
        driver.findElement(cityField).sendKeys(city);
    }

    public void setStateInfo(String state){
        driver.findElement(stateField).sendKeys(state);
    }

    public void setZipCodeInfo(String zipCode){
        driver.findElement(zipCodeField).sendKeys(zipCode);
    }

    public void setSsnInfo(String ssn){
        driver.findElement(ssnField).sendKeys(ssn);
    }

    public void clickOnFindMyLoginInfoButton(){
        driver.findElement(findMyLoginInfoButton).click();
    }

    public String getLoginInformation(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginInformation));
        return driver.findElement(loginInformation).getText();
    }
}
