package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

    private WebDriver driver;
    private By usernameDisplay = By.xpath("//a[@id='userNameDisplay']");

    public DashboardPage(WebDriver driver){
        this.driver = driver;
    }

    public String getUsernameDisplay(){
        return driver.findElement(usernameDisplay).getText();
    }


}
