package pages_parabank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.RegisterPage;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;
    private By usernameField = By.xpath("//input[@type='text']");
    private By passwordField = By.xpath("//input[@type='password']");
    private By loginButton = By.xpath("//input[@type='submit']");
    private By registerButton = By.xpath("//a[contains(text(),'Register')]");
    private By forgotLoginInfoButton = By.xpath("//a[contains(text(),'Forgot login info?')]");
    private By errorMessage = By.xpath("//p[@class='error']");
    private By openNewAccountTab = By.xpath("//a[contains(text(),'Open New Account')]");
    private By accountsOverviewTab = By.xpath("//a[contains(text(),'Accounts Overview')]");
    private By transferFundsTab = By.xpath("//a[contains(text(),'Transfer Funds')]");
    private By billPayTab = By.xpath("//a[contains(text(),'Bill Pay')]");
    private By findTransactionsTab = By.xpath("//a[contains(text(),'Find Transactions')]");
    private By updateContactInfoTab = By.xpath("//a[contains(text(),'Update Contact Info')]");
    private By requestLoanTab = By.xpath("//a[contains(text(),'Request Loan')]");
    private By logOutTab = By.xpath("//a[contains(text(),'Log Out')]");
    private Wait<WebDriver> wait;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void setUsernameField(String username){
        driver.findElement(usernameField).sendKeys(username);
    }

    public void setPasswordField(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public OverviewPage clickOnLoginButton(){
        driver.findElement(loginButton).click();
        return new OverviewPage(driver);
    }

    public RegistersPage clickOnRegisterButton(){
        driver.findElement(registerButton).click();
        return new RegistersPage(driver);
    }

    public ForgotInfoPage clickOnForgotLoginInfoButton(){
        driver.findElement(forgotLoginInfoButton).click();
        return new ForgotInfoPage(driver);
    }

    public String getErrorMessageText(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return driver.findElement(errorMessage).getText();
    }

    public boolean isLoginButtonDisplayed(){
        return driver.findElement(loginButton).isDisplayed();
    }

    public OpenAccountPage clickOnOpenNewAccountTab(){
        driver.findElement(openNewAccountTab).click();
        return new OpenAccountPage(driver);
    }

    public OverviewPage clickOnAccountsOverviewTab(){
        driver.findElement(accountsOverviewTab).click();
        return new OverviewPage(driver);
    }

    public TransferFundsPage clickOnTransferFundsTab(){
        driver.findElement(transferFundsTab).click();
        return new TransferFundsPage(driver);
    }

    public BillPayPage clickOnBillPayTab(){
        driver.findElement(billPayTab).click();
        return new BillPayPage(driver);
    }

    public FindTransactionsPage clickOnFindTransactionsTab(){
        driver.findElement(findTransactionsTab).click();
        return new FindTransactionsPage(driver);
    }

    public UpdateProfilePage clickOnUpdateContactInfoTab(){
        driver.findElement(updateContactInfoTab).click();
        return new UpdateProfilePage(driver);
    }

    public RequestLoanPage clickOnRequestLoanTab(){
        driver.findElement(requestLoanTab).click();
        return new RequestLoanPage(driver);
    }
}
