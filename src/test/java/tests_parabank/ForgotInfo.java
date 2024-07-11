package tests_parabank;

import org.testng.annotations.Test;
import pages_parabank.ForgotInfoPage;
import pages_parabank.HomePage;
import utile.BaseTest;
import utile.ConfigLoader;

import static org.testng.Assert.assertEquals;

public class ForgotInfo extends BaseTest {

    private HomePage homePage;
    private ForgotInfoPage forgotInfoPage;

    @Test
    public void testForgotLoginInformation(){
        initTest("Forgot Login Information");

        homePage = new HomePage(driver);

        forgotInfoPage = homePage.clickOnForgotLoginInfoButton();

        ConfigLoader configLoader = new ConfigLoader("src/test/resources/properties/bankUser2.properties");
        String firstName = configLoader.getProperty("firstName");
        String lastName = configLoader.getProperty("lastName");
        String address = configLoader.getProperty("address");
        String city = configLoader.getProperty("city");
        String state = configLoader.getProperty("state");
        String zipCode = configLoader.getProperty("zipCode");
        String ssn = configLoader.getProperty("ssn");

        String username = configLoader.getProperty("username");
        String password = configLoader.getProperty("password");

        forgotInfoPage.setFirstNameInfo(firstName);
        forgotInfoPage.setLastNameInfo(lastName);
        forgotInfoPage.setAddressInfo(address);
        forgotInfoPage.setCityInfo(city);
        forgotInfoPage.setStateInfo(state);
        forgotInfoPage.setZipCodeInfo(zipCode);
        forgotInfoPage.setSsnInfo(ssn);
        forgotInfoPage.clickOnFindMyLoginInfoButton();

        String expectedOutput = "Username: " + username + "\nPassword: " + password;

        assertEquals(forgotInfoPage.getLoginInformation(), expectedOutput, "Login info was not obtained successfully.");

    }

}
