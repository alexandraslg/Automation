package tests_parabank;

import org.testng.annotations.Test;
import pages_parabank.*;
import utile.BaseTest;
import utile.ConfigLoader;

import static org.testng.Assert.assertEquals;

public class MainMenuNavigation extends BaseTest {

    private HomePage homePage;
    private OpenAccountPage openAccountPage;
    private OverviewPage overviewPage;
    private TransferFundsPage transferFundsPage;
    private BillPayPage billPayPage;
    private FindTransactionsPage findTransactionsPage;
    private UpdateProfilePage updateProfilePage;
    private RequestLoanPage requestLoanPage;

    @Test
    public void testMainMenuNavigation(){
        initTest("Main Menu Navigation");

        homePage = new HomePage(driver);

        ConfigLoader configLoader = new ConfigLoader("src/test/resources/properties/bankUser2.properties");
        String username = configLoader.getProperty("username");
        String password = configLoader.getProperty("password");

        homePage.setUsernameField(username);
        homePage.setPasswordField(password);
        overviewPage = homePage.clickOnLoginButton();

        homePage = overviewPage.clickOnHomeButton();
        openAccountPage = homePage.clickOnOpenNewAccountTab();
        assertEquals(openAccountPage.getOpenAccountPageText(),"Open New Account","Open New Account tab was not opened successfully.");

        overviewPage = homePage.clickOnAccountsOverviewTab();
        assertEquals(overviewPage.getAccountsOverviewPageText(),"Accounts Overview","Accounts Overview tab was not opened successfully.");

        transferFundsPage = homePage.clickOnTransferFundsTab();
        assertEquals(transferFundsPage.getTransferFundsPageText(),"Transfer Funds","Transfer Funds tab was not opened successfully.");

        billPayPage = homePage.clickOnBillPayTab();
        assertEquals(billPayPage.getBillPaymentServicePageText(),"Bill Payment Service","Bill Payment tab was not opened successfully.");

        findTransactionsPage = homePage.clickOnFindTransactionsTab();
        assertEquals(findTransactionsPage.getFindTransactionsPageText(),"Find Transactions", "Find Transactions tab was not opened successfully.");

        updateProfilePage = homePage.clickOnUpdateContactInfoTab();
        assertEquals(updateProfilePage.getUpdateProfilePageText(),"Update Profile","Update Profile tab was not opened successfully.");

        requestLoanPage = homePage.clickOnRequestLoanTab();
        assertEquals(requestLoanPage.getRequestLoanPageText(),"Apply for a Loan", "Request Loan tab was not opened successfully.");
    }
}
