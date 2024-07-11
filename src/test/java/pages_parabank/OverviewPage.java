package pages_parabank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OverviewPage {

    private WebDriver driver;
    private By welcomeText = By.xpath("//p[@class='smallText']");
    private By homePageButton = By.xpath("//div/ul/li[@class='home']/a");
    private By openNewAccountButton = By.xpath("//a[contains(text(),'Open New Account')]");
    private By transferFundsButton = By.xpath("//a[contains(text(),'Transfer Funds')]");
    private By billPayButton = By.xpath("//a[contains(text(),'Bill Pay')]");
    private By updateInfoButton = By.xpath("//a[contains(text(),'Update Contact Info')]");
    private By logOutButton = By.xpath("//a[contains(text(),'Log Out')]");
    private By firstAccountNumber = By.xpath("//table/tbody/tr/td/a");
    private By firstAccountBalance = By.xpath("//table/tbody/tr[1]/td[2]");
    private By secondAccountBalance = By.xpath("//table/tbody/tr[2]/td[2]");
    private By accountsOverviewPageText = By.xpath("//h1[text()[contains(.,'Accounts Overview')]]");
    private Wait<WebDriver> wait;

    public OverviewPage(WebDriver driver){
        this.driver = driver;
    }

    public String getWelcomeText(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeText));
        return driver.findElement(welcomeText).getText();
    }

    public HomePage clickOnLogOutButton(){
        driver.findElement(logOutButton).click();
        return new HomePage(driver);
    }

    public OpenAccountPage clickOnOpenNewAccountButton(){
        driver.findElement(openNewAccountButton).click();
        return new OpenAccountPage(driver);
    }

    public TransferFundsPage clickOnTransferFundsButton(){
        driver.findElement(transferFundsButton).click();
        return new TransferFundsPage(driver);
    }

    public BillPayPage clickOnBillPayButton(){
        driver.findElement(billPayButton).click();
        return new BillPayPage(driver);
    }

    public UpdateProfilePage clickOnUpdateContactInfoButton(){
        driver.findElement(updateInfoButton).click();
        return new UpdateProfilePage(driver);
    }

    public ActivityPage clickOnFirstAccount(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstAccountNumber));
        driver.findElement(firstAccountNumber).click();
        return new ActivityPage(driver);
    }

    public String getFirstAccountBalance(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstAccountBalance));
        return driver.findElement(firstAccountBalance).getText();
    }

    public String getSecondAccountBalance(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(secondAccountBalance));
        return driver.findElement(secondAccountBalance).getText();
    }

    public HomePage clickOnHomeButton(){
        driver.findElement(homePageButton).click();
        return new HomePage(driver);
    }

    public String getAccountsOverviewPageText(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountsOverviewPageText));
        return driver.findElement(accountsOverviewPageText).getText();
    }

}
