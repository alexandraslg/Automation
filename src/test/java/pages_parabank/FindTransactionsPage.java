package pages_parabank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FindTransactionsPage {

    private WebDriver driver;
    private By findTransactionsPageText = By.xpath("//h1[text()[contains(.,'Find Transactions')]]");
    private Wait<WebDriver> wait;

    public FindTransactionsPage(WebDriver driver){
        this.driver = driver;
    }

    public String getFindTransactionsPageText(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findTransactionsPageText));
        return driver.findElement(findTransactionsPageText).getText();
    }
}
