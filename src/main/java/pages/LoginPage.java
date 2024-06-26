package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private By userEmail = By.xpath("//div//input[@id='userEmail']");
    private By userPassword = By.xpath("//div//input[@id='userPassword']");
    private By loginButton = By.xpath("//div//input[@id='submitButton']");
    private By registerTab = By.xpath("//body//a[contains(@href,'register')]");
    private By loginText = By.xpath("//h2[@class='loginPageID']");
    private By forbiddenAccessText = By.xpath("//div[@id='errorForbiddenAccess']");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void setUserEmail(String userEmailText){
        driver.findElement(userEmail).sendKeys(userEmailText);
    }

    public void setUserPassword(String userPasswordText){
        driver.findElement(userPassword).sendKeys((userPasswordText));
    }

    public DashboardPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new DashboardPage(driver);
    }

    public RegisterPage clickRegisterTab(){
        driver.findElement(registerTab).click();
        return new RegisterPage(driver);
    }

    public String getLoginText(){
        return driver.findElement(loginText).getText();
    }

    public String getForbiddenAccessText(){
        return driver.findElement(forbiddenAccessText).getText();
    }

    public By getForbiddenAccessWebElement(){
        return forbiddenAccessText;
    }

}
