package pages_parabank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActivityPage {

    private WebDriver driver;
    private By transactionsHistory = By.xpath("//table/tbody/tr/td/a[text()[contains(.,'Bill Payment')]]");
    private Wait<WebDriver> wait;

    public ActivityPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isTransactionHistoryDisplayed(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(transactionsHistory));
        return driver.findElement(transactionsHistory).isDisplayed();
    }

}
