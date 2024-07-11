package pages_parabank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UpdateProfilePage {

    private WebDriver driver;
    private By firstNameField = By.xpath("//input[@id='customer.firstName']");
    private By lastNameField = By.xpath("//input[@id='customer.lastName']");
    private By addressField = By.xpath("//input[@id='customer.address.street']");
    private By cityField = By.xpath("//input[@id='customer.address.city']");
    private By stateField = By.xpath("//input[@id='customer.address.state']");
    private By zipCodeField = By.xpath("//input[@id='customer.address.zipCode']");
    private By phoneField = By.xpath("//input[@id='customer.phoneNumber']");
    private By updateProfileButton = By.xpath("//input[@value='Update Profile']");
    private By profileUpdatedMessage = By.xpath("//h1[contains(text(),'Profile Updated')]");
    private By updateProfilePageText = By.xpath("//h1[text()[contains(.,'Update Profile')]]");

    private Wait<WebDriver> wait;

    public UpdateProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUpdateFirstName(String firstName){
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void setUpdateLastName(String lastName){
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void setUpdateAddress(String address){
        driver.findElement(addressField).sendKeys(address);
    }

    public void setUpdateCity(String city){
        driver.findElement(cityField).sendKeys(city);
    }

    public void setUpdateState(String state){
        driver.findElement(stateField).sendKeys(state);
    }

    public void setUpdateZipCode(String zipCode){
        driver.findElement(zipCodeField).sendKeys(zipCode);
    }

    public void setUpdatePhone(String phone){
        driver.findElement(phoneField).sendKeys(phone);
    }

    public void clickOnUpdateProfileButton(){
        driver.findElement(updateProfileButton).click();
    }

    public String getProfileUpdatedMessage(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(profileUpdatedMessage));
        return driver.findElement(profileUpdatedMessage).getText();
    }

    public String getFirstNameField(){
        return driver.findElement(firstNameField).getText();
    }

    public String getLastNameField(){
        return driver.findElement(lastNameField).getText();
    }

    public String getAddressField(){
        return driver.findElement(addressField).getText();
    }

    public String getCityField(){
        return driver.findElement(cityField).getText();
    }

    public String getStateField(){
        return driver.findElement(stateField).getText();
    }

    public String getZipCodeField(){
        return driver.findElement(zipCodeField).getText();
    }

    public String getPhoneField(){
        return driver.findElement(phoneField).getText();
    }

    public String getUpdateProfilePageText(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(updateProfilePageText));
        return driver.findElement(updateProfilePageText).getText();
    }



}
