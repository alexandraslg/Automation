package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TrainingsPage {

    private WebDriver driver;
    private By trainingTabTitle = By.xpath("//h2[contains(text(),'Training program')]");
    private By generateProgramButton = By.xpath("//div[@class='generate-program']");
    private By trainingProgramList = By.cssSelector(".cdk-drag.example-box");
    private By dayProgram(String dayIndex){
        return By.xpath("//div[@id='cdk-drop-list-" + dayIndex + "']");
    }
    private Wait<WebDriver> wait;
    private Actions builder;

    public TrainingsPage(WebDriver driver) {
        this.driver = driver;
        builder = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public String getTrainingTabTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(trainingTabTitle));
        return driver.findElement(trainingTabTitle).getText();
    }

    public void clickOnGenerateProgramButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(generateProgramButton));
        driver.findElement(generateProgramButton).click();
    }

    public WebElement dayOfWeek(String dayIndex){
        return driver.findElement(dayProgram(dayIndex));
    }
    public List<WebElement> trainingPrograms(){
        return driver.findElements(trainingProgramList);
    }

    public void dragAndDropTrainingProgram(String dayIndex, String trainingProgram){
        wait.until(ExpectedConditions.visibilityOfElementLocated(trainingProgramList));
        Action dragAndDrop = builder.clickAndHold(getTrainingProgram(trainingProgram))
                .moveToElement(dayOfWeek(dayIndex))
                .release(dayOfWeek(dayIndex))
                .build();
        dragAndDrop.perform();
    }

    private WebElement getTrainingProgram(String trainingProgram){
        for (WebElement element : trainingPrograms()){
            if (element.getText().equalsIgnoreCase(trainingProgram))
                return element;
        }
        return null;
    }


}
