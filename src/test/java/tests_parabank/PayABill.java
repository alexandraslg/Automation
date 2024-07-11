package tests_parabank;

import org.testng.annotations.Test;
import pages_parabank.BillPayPage;
import pages_parabank.HomePage;
import pages_parabank.OverviewPage;
import utile.BaseTest;
import utile.ConfigLoader;

import static org.testng.Assert.assertEquals;

public class PayABill extends BaseTest {

    private HomePage homePage;
    private OverviewPage overviewPage;
    private BillPayPage billPayPage;

    @Test
    public void testBillPay(){
        initTest("Bill Pay");

        homePage = new HomePage(driver);

        ConfigLoader configLoader = new ConfigLoader("src/test/resources/properties/bankUser2.properties");
        String username = configLoader.getProperty("username");
        String password = configLoader.getProperty("password");

        homePage.setUsernameField(username);
        homePage.setPasswordField(password);
        overviewPage = homePage.clickOnLoginButton();

        billPayPage = overviewPage.clickOnBillPayButton();

        ConfigLoader configLoader2 = new ConfigLoader("src/test/resources/properties/payeeInformation1.properties");
        String payeeName = configLoader2.getProperty("payeeName");
        String address = configLoader2.getProperty("address");
        String city = configLoader2.getProperty("city");
        String state = configLoader2.getProperty("state");
        String zipCode = configLoader2.getProperty("zipCode");
        String phone = configLoader2.getProperty("phone");
        String account = configLoader2.getProperty("account");
        String amount = configLoader2.getProperty("amount");
        String fromAccount = configLoader2.getProperty("fromAccount");

        billPayPage.setPayeeName(payeeName);
        billPayPage.setPayeeAddress(address);
        billPayPage.setPayeeCity(city);
        billPayPage.setPayeeState(state);
        billPayPage.setPayeeZipCode(zipCode);
        billPayPage.setPayeePhone(phone);
        billPayPage.setPayeeAccount(account);
        billPayPage.setPayeeVerifyAccount(account);
        billPayPage.setPayeeAmount(amount);
        billPayPage.selectFromPayeeFromAccount(Integer.parseInt(fromAccount));
        String accountValue = billPayPage.getFromAccountOption();
        billPayPage.clickOnSendPaymentButton();

        String expectedPaymentText = "Bill Payment to " + payeeName + " in the amount of $" + String.format("%.2f",Double.parseDouble(amount)) + " from account " + accountValue + " was successful.";

        assertEquals(billPayPage.getBillPaymentCompleteText(), expectedPaymentText, "Payment was not successful.");

    }

}
