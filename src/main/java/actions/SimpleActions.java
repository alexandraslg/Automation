package actions;

import org.openqa.selenium.WebDriver;
import webelements.SimpleElements;

public class SimpleActions {
    private SimpleElements elements;

    public SimpleActions(WebDriver driver){
        this.elements = new SimpleElements(driver);
    }

    public String getLoginText(){
        return elements.loginText().getText();
    }
}
