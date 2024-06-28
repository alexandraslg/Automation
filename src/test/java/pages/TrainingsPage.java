package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TrainingsPage {

    private WebDriver driver;
    private By trainingTabTitle = By.xpath("//h2[contains(text(),'Training program')]");
    private Wait<WebDriver> wait;

    public TrainingsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTrainingTabTitle() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(trainingTabTitle));
        return driver.findElement(trainingTabTitle).getText();
    }
}
