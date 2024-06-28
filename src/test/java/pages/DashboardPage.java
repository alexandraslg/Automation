package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {

    private WebDriver driver;
    private By usernameDisplay = By.xpath("//a[@id='userNameDisplay']");
    private By trainingTab = By.xpath("//a[contains(text(),'Training')]");
    private Wait<WebDriver> wait;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
    }

    public String getUsernameDisplay(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameDisplay));
        return driver.findElement(usernameDisplay).getText();
    }


    public TrainingsPage clickOnTraining(){
        driver.findElement(trainingTab).click();
        return new TrainingsPage(driver);
    }

}
