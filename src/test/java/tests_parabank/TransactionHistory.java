package tests_parabank;

import org.testng.annotations.Test;
import pages_parabank.ActivityPage;
import pages_parabank.HomePage;
import pages_parabank.OverviewPage;
import utile.BaseTest;
import utile.ConfigLoader;

import static org.testng.Assert.assertTrue;

public class TransactionHistory extends BaseTest {

    private HomePage homePage;
    private OverviewPage overviewPage;
    private ActivityPage activityPage;

    @Test
    public void isTransactionHistoryDisplayed(){
        initTest("Transaction History");

        homePage = new HomePage(driver);

        ConfigLoader configLoader = new ConfigLoader("src/test/resources/properties/bankUser2.properties");
        String username = configLoader.getProperty("username");
        String password = configLoader.getProperty("password");

        homePage.setUsernameField(username);
        homePage.setPasswordField(password);
        overviewPage = homePage.clickOnLoginButton();

        activityPage = overviewPage.clickOnFirstAccount();

        assertTrue(activityPage.isTransactionHistoryDisplayed(),"Transaction History is not displayed.");

    }
}
