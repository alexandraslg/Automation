package tests_parabank;

import org.testng.annotations.Test;
import pages_parabank.HomePage;
import pages_parabank.OpenAccountPage;
import pages_parabank.OverviewPage;
import utile.BaseTest;
import utile.ConfigLoader;

import static org.testng.Assert.assertEquals;

public class OpenNewAccount extends BaseTest {

    private HomePage homePage;
    private OverviewPage overviewPage;
    private OpenAccountPage openAccountPage;

    @Test
    public void testOpenNewAccount(){
        initTest("Open New Account");

        homePage = new HomePage(driver);

        ConfigLoader configLoader = new ConfigLoader("src/test/resources/properties/bankUser2.properties");
        String username = configLoader.getProperty("username");
        String password = configLoader.getProperty("password");

        homePage.setUsernameField(username);
        homePage.setPasswordField(password);
        overviewPage = homePage.clickOnLoginButton();

        openAccountPage = overviewPage.clickOnOpenNewAccountButton();

        openAccountPage.selectFromAccountTypeDropdown(1);
        openAccountPage.selectFromFromAccount(0);
        openAccountPage.clickOnOpenNewAccountButton();

        String expectedAccountOpenedText = "Account Opened!";

        assertEquals(openAccountPage.getAccountOpenedText(), expectedAccountOpenedText, "Account was not opened successfully.");

    }
}
