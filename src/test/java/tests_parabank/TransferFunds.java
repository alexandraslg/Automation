package tests_parabank;

import org.testng.annotations.Test;
import pages_parabank.HomePage;
import pages_parabank.OverviewPage;
import pages_parabank.TransferFundsPage;
import utile.BaseTest;
import utile.ConfigLoader;

import static org.testng.Assert.assertEquals;

public class TransferFunds extends BaseTest {

    private HomePage homePage;
    private OverviewPage overviewPage;
    private TransferFundsPage transferFundsPage;

    @Test
    public void testTransferFunds(){
        initTest("Transfer Funds");

        homePage = new HomePage(driver);

        ConfigLoader configLoaderLogin = new ConfigLoader("src/test/resources/properties/bankUser2.properties");
        String username = configLoaderLogin.getProperty("username");
        String password = configLoaderLogin.getProperty("password");

        homePage.setUsernameField(username);
        homePage.setPasswordField(password);
        overviewPage = homePage.clickOnLoginButton();

        String firstAccountDefaultBalance = overviewPage.getFirstAccountBalance();
        String secondAccountDefaultBalance = overviewPage.getSecondAccountBalance();
        firstAccountDefaultBalance = firstAccountDefaultBalance.substring(1);
        secondAccountDefaultBalance = secondAccountDefaultBalance.substring(1);

        System.out.println(firstAccountDefaultBalance);
        System.out.println(secondAccountDefaultBalance);

        transferFundsPage = overviewPage.clickOnTransferFundsButton();

        ConfigLoader configLoaderFunds = new ConfigLoader("src/test/resources/properties/transferFunds.properties");
        String amount = configLoaderFunds.getProperty("amount");
        String fromAccount = configLoaderFunds.getProperty("fromAccount");
        String toAccount = configLoaderFunds.getProperty("toAccount");

        transferFundsPage.setAmountField(amount);
        transferFundsPage.selectFromFromAccountDropdown(Integer.parseInt(fromAccount));
        String fromAccountOption = transferFundsPage.getFromAccountOption();
        transferFundsPage.selectFromToAccountDropdown(Integer.parseInt(toAccount));
        String toAccountOption = transferFundsPage.getToAccountOption();
        transferFundsPage.clickOnTransferButton();

        //String expectedOutputMessage = "$" + String.format("%.2f",Double.parseDouble(amount)) + " has been transferred from account #" + fromAccountOption + " to account #" + toAccountOption;

        //assertEquals(transferFundsPage.getTransferCompleteMessage(), expectedOutputMessage, "Transfer funds was not successful.");

        transferFundsPage.clickOnAccountsOverviewTab();
        String firstAccountAfterBalance = overviewPage.getFirstAccountBalance();
        String secondAccountAfterBalance = overviewPage.getSecondAccountBalance();
        firstAccountAfterBalance = firstAccountAfterBalance.substring(1);
        secondAccountAfterBalance = secondAccountAfterBalance.substring(1);

        System.out.println(firstAccountAfterBalance);
        System.out.println(secondAccountAfterBalance);

       assertEquals(Double.parseDouble(firstAccountAfterBalance), Double.parseDouble(firstAccountDefaultBalance)-Double.parseDouble(amount), "Transfer funds was not successful");
       assertEquals(Double.parseDouble(secondAccountAfterBalance), Double.parseDouble(secondAccountDefaultBalance)+Double.parseDouble(amount), "Transfer funds was not successful");






    }
}
