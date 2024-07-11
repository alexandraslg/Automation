package tests_parabank;

import org.testng.annotations.Test;
import pages_parabank.HomePage;
import pages_parabank.OverviewPage;
import utile.BaseTest;
import utile.ConfigLoader;

import static org.testng.Assert.assertEquals;

public class LoginValidCredentials extends BaseTest {
    private HomePage homePage;
    private OverviewPage overviewPage;

    @Test
    public void testLoginWithValidCredetials(){
        initTest("Login Valid Credentials");

        homePage = new HomePage(driver);

        ConfigLoader configLoader = new ConfigLoader("src/test/resources/properties/bankUser2.properties");
        String username = configLoader.getProperty("username");
        String password = configLoader.getProperty("password");

        homePage.setUsernameField(username);
        homePage.setPasswordField(password);
        overviewPage = homePage.clickOnLoginButton();

        String firstName = configLoader.getProperty("firstName");
        String lastName = configLoader.getProperty("lastName");
        String expectedWelcomeText = "Welcome " + firstName + " " + lastName;
        assertEquals(overviewPage.getWelcomeText(),expectedWelcomeText, "Login was not successful.");
    }
}
