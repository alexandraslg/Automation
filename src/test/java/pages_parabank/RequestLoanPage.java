package pages_parabank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RequestLoanPage {

    private WebDriver driver;
    private By requestLoanPageText = By.xpath("//h1[text()[contains(.,'Apply for a Loan')]]");
    private Wait<WebDriver> wait;

    public RequestLoanPage(WebDriver driver){
        this.driver = driver;
    }

    public String getRequestLoanPageText(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(requestLoanPageText));
        return driver.findElement(requestLoanPageText).getText();
    }
}
