package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utile.ConfigLoader;


public class RegisterPage {

    private WebDriver driver;
    private By signUpText = By.xpath(".//h2[text()='Sign Up']");
    private By firstNameField = By.xpath("//div//input[@id = 'firstName']");
    private By lastNameField = By.xpath("//div//input[@id = 'lastName']");
    private By phoneNumberField = By.xpath("//div//input[@id = 'phoneNumber']");
    private By emailField = By.xpath("//div//input[@id = 'email']");
    private By passwordField = By.xpath("//div//input[@id = 'password']");
    private By cityField = By.xpath("//div//input[@id = 'city']");
    private By customerCheckBox = By.xpath("//div//input[@id = 'customer']");
    private By trainerCheckBox = By.xpath("//div//input[@id = 'trainer']");
    private By signUpButton = By.xpath("//div//input[@id = 'submit']");
    private ConfigLoader configLoader;

    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }

    public void setFirstNameField(String firstName){
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void setLastNameField(String lastName){
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void setPhoneNumberField(String phoneNumber){
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    public void setEmailField(String email){
        driver.findElement(emailField).sendKeys(email);
    }

    public void setPasswordField(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void setCityField(String city){
        driver.findElement(cityField).sendKeys(city);
    }

    public void clickOnCustomerCheckBox(){
        driver.findElement(customerCheckBox).click();
    }

    public void clickOnTrainerCheckBox(){
        driver.findElement(trainerCheckBox).click();
    }

    public LoginPage clickSignUpButton(){
        driver.findElement(signUpButton).click();
        return new LoginPage(driver);
    }

    public String getSignUpText(){
        return driver.findElement(signUpText).getText();
    }

    public LoginPage registerUser(boolean isTrainer, String email, String password, String phoneNumber){

        configLoader = new ConfigLoader("src/test/resources/properties/dataUser2.properties");
        String firstName = configLoader.getProperty("firstName");
        String lastName = configLoader.getProperty("lastName");
        //String phoneNumber = configLoader.getProperty("phoneNumber");
        //String email = configLoader.getProperty("email");
        //String password = configLoader.getProperty("password");
        String city = configLoader.getProperty("city");

        setFirstNameField(firstName);
        setLastNameField(lastName);
        setPhoneNumberField(phoneNumber);
        setEmailField(email);
        setPasswordField(password);
        setCityField(city);
        if(isTrainer){
            clickOnTrainerCheckBox();
        } else{
            clickOnCustomerCheckBox();
        }
        return clickSignUpButton();
    }

}
