package pages_parabank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistersPage {

    private WebDriver driver;
    private By firstNameField = By.xpath("//input[@id='customer.firstName']");
    private By lastNameField = By.xpath("//input[@id='customer.lastName']");
    private By addressField = By.xpath("//input[@id='customer.address.street']");
    private By cityField = By.xpath("//input[@id='customer.address.city']");
    private By stateField = By.xpath("//input[@id='customer.address.state']");
    private By zipCodeField = By.xpath("//input[@id='customer.address.zipCode']");
    private By phoneField = By.xpath("//input[@id='customer.phoneNumber']");
    private By ssnField = By.xpath("//input[@id='customer.ssn']");
    private By usernameField = By.xpath("//input[@id='customer.username']");
    private By passwordField = By.xpath("//input[@id='customer.password']");
    private By confirmPasswordField = By.xpath("//input[@id='repeatedPassword']");
    private By registerSubmit = By.xpath("//input[@value='Register']");
    private By welcomeUserText = By.xpath("//h1");
    private Wait<WebDriver> wait;


    public RegistersPage(WebDriver driver){
        this.driver = driver;
    }

    public void setFirstName(String firstName){
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void setLastName(String lastName){
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void setAddress(String address){
        driver.findElement(addressField).sendKeys(address);
    }

    public void setCity(String city){
        driver.findElement(cityField).sendKeys(city);
    }

    public void setState(String state){
        driver.findElement(stateField).sendKeys(state);
    }

    public void setZipCode(String zipCode){
        driver.findElement(zipCodeField).sendKeys(zipCode);
    }

    public void setPhone(String phone){
        driver.findElement(phoneField).sendKeys(phone);
    }

    public void setSsn(String ssn){
        driver.findElement(ssnField).sendKeys(ssn);
    }

    public void setUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
    }

    public void setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void setConfirmPassword(String confirmPassword){
        driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
    }

    public void clickOnRegisterSubmitButton(){
        driver.findElement(registerSubmit).click();
    }

    public String getWelcomeUserText(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeUserText));
        return driver.findElement(welcomeUserText).getText();
    }
}
