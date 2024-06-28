package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utile.ConfigLoader;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private By userEmail = By.xpath("//div//input[@id='userEmail']");
    private By userPassword = By.xpath("//div//input[@id='userPassword']");
    private By loginButton = By.xpath("//div//input[@id='submitButton']");
    private By registerTab = By.xpath("//body//a[contains(@href,'register')]");
    private By loginText = By.xpath("//h2[@class='loginPageID']");
    private By forbiddenAccessText = By.xpath("//div[@id='errorForbiddenAccess']");
    private Wait<WebDriver> wait;
    private ConfigLoader configLoader;
    private RegisterPage registerPage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUserEmail(String userEmailText) {
        driver.findElement(userEmail).sendKeys(userEmailText);
    }

    public void setUserPassword(String userPasswordText) {
        driver.findElement(userPassword).sendKeys((userPasswordText));
    }

    public DashboardPage clickLoginButton() {
        driver.findElement(loginButton).click();
        return new DashboardPage(driver);
    }

    public RegisterPage clickRegisterTab() {
        driver.findElement(registerTab).click();
        return new RegisterPage(driver);
    }

    public String getLoginText() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginText));
        return driver.findElement(loginText).getText();
    }

    public String getForbiddenAccessText() {
        return driver.findElement(forbiddenAccessText).getText();
    }

    public boolean forbiddenAccessElementIsDisplayed() {
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(forbiddenAccessText));
            return driver.findElement(forbiddenAccessText).isDisplayed();
            }
        catch (Exception e) {
            return false;
        }
    }
}
