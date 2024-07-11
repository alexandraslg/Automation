package pages_parabank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BillPayPage {

    private WebDriver driver;
    private By payeeName = By.xpath("//input[@name='payee.name']");
    private By payeeAddress = By.xpath("//input[@name='payee.address.street']");
    private By payeeCity = By.xpath("//input[@name='payee.address.city']");
    private By payeeState = By.xpath("//input[@name='payee.address.state']");
    private By payeeZipCode = By.xpath("//input[@name='payee.address.zipCode']");
    private By payeePhone = By.xpath("//input[@name='payee.phoneNumber']");
    private By payeeAccount = By.xpath("//input[@name='payee.accountNumber']");
    private By payeeVerifyAccount = By.xpath("//input[@name='verifyAccount']");
    private By payeeAmount = By.xpath("//input[@name='amount']");
    private By payeeFromAccount = By.xpath("//select[@name='fromAccountId']");
    private By sendPaymentButton = By.xpath("//input[@type='button']");
    private By billPaymentComplete = By.xpath("//*[text()[contains(.,'successful')]]");
    private By billPaymentServicePageText = By.xpath("//h1[text()[contains(.,'Bill Payment Service')]]");
    private Wait<WebDriver> wait;

    public BillPayPage(WebDriver driver){
        this.driver = driver;
    }

    public void setPayeeName(String name){
        driver.findElement(payeeName).sendKeys(name);
    }

    public void setPayeeAddress(String address){
        driver.findElement(payeeAddress).sendKeys(address);
    }

    public void setPayeeCity(String city){
        driver.findElement(payeeCity).sendKeys(city);
    }

    public void setPayeeState(String state){
        driver.findElement(payeeState).sendKeys(state);
    }

    public void setPayeeZipCode(String zipCode){
        driver.findElement(payeeZipCode).sendKeys(zipCode);
    }

    public void setPayeePhone(String phone){
        driver.findElement(payeePhone).sendKeys(phone);
    }

    public void setPayeeAccount(String account){
        driver.findElement(payeeAccount).sendKeys(account);
    }

    public void setPayeeVerifyAccount(String verifyAccount){
        driver.findElement(payeeVerifyAccount).sendKeys(verifyAccount);
    }

    public void setPayeeAmount(String amount){
        driver.findElement(payeeAmount).sendKeys(amount);
    }

    public void selectFromPayeeFromAccount(int index){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(payeeFromAccount));
        Select fromAccountDropdown = new Select(driver.findElement(payeeFromAccount));
        fromAccountDropdown.selectByIndex(index);
    }

    public String getFromAccountOption(){
        Select accountDropdown = new Select(driver.findElement(payeeFromAccount));
        return accountDropdown.getFirstSelectedOption().getText();
    }


    public void clickOnSendPaymentButton(){
        driver.findElement(sendPaymentButton).click();
    }

    public String getBillPaymentCompleteText(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(billPaymentComplete));
        return driver.findElement(billPaymentComplete).getText();
    }

    public String getBillPaymentServicePageText(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(billPaymentServicePageText));
        return driver.findElement(billPaymentServicePageText).getText();
    }

}
