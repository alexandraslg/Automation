package tests_parabank;

import org.testng.annotations.Test;
import pages_parabank.HomePage;
import pages_parabank.OverviewPage;
import utile.BaseTest;
import utile.ConfigLoader;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginInvalidCredentials extends BaseTest {
    private HomePage homePage;

    @Test
    public void testLoginWithInvalidCredetials(){
        initTest("Login Invalid Credentials");

        homePage = new HomePage(driver);

        ConfigLoader configLoader = new ConfigLoader("src/test/resources/properties/bankUserInvalid.properties");
        String username = configLoader.getProperty("username");
        String password = configLoader.getProperty("password");

        homePage.setUsernameField(username);
        homePage.setPasswordField(password);
        homePage.clickOnLoginButton();

        String expectedErrorMessage = "The username and password could not be verified.";

        assertTrue(homePage.getErrorMessageText().equalsIgnoreCase(expectedErrorMessage));
    }
}
