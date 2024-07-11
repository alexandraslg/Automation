package pages_parabank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OpenAccountPage {

    private WebDriver driver;
    private By accountType = By.xpath("//select[@id='type']");
    private By fromAccount = By.xpath("//select[@id='fromAccountId']");
    private By openNewAccountButton = By.xpath("//input[@type='button']");
    private By accountOpenedText = By.xpath("//h1[contains(text(),'Account Opened')]");
    private By openAccountPageText = By.xpath("//h1[text()[contains(.,'Open New Account')]]");
    private Wait<WebDriver> wait;

    public OpenAccountPage(WebDriver driver){
        this.driver = driver;
    }

    public void selectFromAccountTypeDropdown(int index){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountType));
        Select accountTypeDropdown = new Select(driver.findElement(accountType));
        accountTypeDropdown.selectByIndex(index);
    }

    public void selectFromFromAccount(int index){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(fromAccount));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Select fromAccountDropdown = new Select(driver.findElement(fromAccount));
        fromAccountDropdown.selectByIndex(index);
    }

    public void clickOnOpenNewAccountButton(){
        driver.findElement(openNewAccountButton).click();
    }

    public String getAccountOpenedText(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountOpenedText));
        return driver.findElement(accountOpenedText).getText();
    }

    public String getOpenAccountPageText(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(openAccountPageText));
        return driver.findElement(openAccountPageText).getText();
    }




}
