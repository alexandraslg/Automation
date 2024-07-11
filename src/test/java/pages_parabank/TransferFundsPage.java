package pages_parabank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TransferFundsPage {

    private WebDriver driver;
    private By amountField = By.xpath("//input[@id='amount']");
    private By fromAccountId = By.xpath("//select[@id='fromAccountId']");
    private By toAccountId = By.xpath("//select[@id='toAccountId']");
    private By transferButton = By.xpath("//input[@value='Transfer']");
    private By transferCompleteMessage = By.xpath("//*[text()[contains(.,'has been transferred')]]");
    private By accountsOverviewTab = By.xpath("//a[contains(text(),'Accounts Overview')]");
    private By transferFundsPageText = By.xpath("//h1[text()[contains(.,'Transfer Funds')]]");
    private Wait<WebDriver> wait;

    public TransferFundsPage(WebDriver driver){
        this.driver = driver;
    }

    public void setAmountField(String amount){
        driver.findElement(amountField).sendKeys(amount);
    }

    public void selectFromFromAccountDropdown(int index){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Select fromAccountDropdown = new Select(driver.findElement(fromAccountId));
        fromAccountDropdown.selectByIndex(index);
    }

    public String getFromAccountOption(){
        Select accountDropdown = new Select(driver.findElement(fromAccountId));
        return accountDropdown.getFirstSelectedOption().getText();
    }

    public void selectFromToAccountDropdown(int index){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Select toAccountDropdown = new Select(driver.findElement(toAccountId));
        toAccountDropdown.selectByIndex(index);
    }
    public String getToAccountOption(){
        Select accountDropdown = new Select(driver.findElement(toAccountId));
        return accountDropdown.getFirstSelectedOption().getText();
    }

    public void clickOnTransferButton(){
        driver.findElement(transferButton).click();
    }

    public OverviewPage clickOnAccountsOverviewTab(){
        driver.findElement(accountsOverviewTab).click();
        return new OverviewPage(driver);
    }

    public String getTransferCompleteMessage(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(transferCompleteMessage));
        return driver.findElement(transferCompleteMessage).getText();
    }

    public String getTransferFundsPageText(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(transferFundsPageText));
        return driver.findElement(transferFundsPageText).getText();
    }



}
