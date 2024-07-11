package tests_parabank;

import org.testng.annotations.Test;
import pages_parabank.HomePage;
import pages_parabank.RegistersPage;
import utile.BaseTest;
import utile.ConfigLoader;

import static org.testng.Assert.assertEquals;

public class RegisterBankUser extends BaseTest {

    private HomePage homePage;
    private RegistersPage registersPage;

    @Test
    public void testRegisterUser(){
        initTest("Register User");

        homePage = new HomePage(driver);
        registersPage = homePage.clickOnRegisterButton();

        ConfigLoader configLoader = new ConfigLoader("src/test/resources/properties/bankUser2.properties");
        String firstName = configLoader.getProperty("firstName");
        String lastName = configLoader.getProperty("lastName");
        String address = configLoader.getProperty("address");
        String city = configLoader.getProperty("city");
        String state = configLoader.getProperty("state");
        String zipCode = configLoader.getProperty("zipCode");
        String phone = configLoader.getProperty("phone");
        String ssn = configLoader.getProperty("ssn");
        String username = configLoader.getProperty("username");
        String password = configLoader.getProperty("password");

        registersPage.setFirstName(firstName);
        registersPage.setLastName(lastName);
        registersPage.setAddress(address);
        registersPage.setCity(city);
        registersPage.setState(state);
        registersPage.setZipCode(zipCode);
        registersPage.setPhone(phone);
        registersPage.setSsn(ssn);
        registersPage.setUsername(username);
        registersPage.setPassword(password);
        registersPage.setConfirmPassword(password);
        registersPage.clickOnRegisterSubmitButton();

        String expectedWelcomeUserText = "Welcome " + username;

        assertEquals(registersPage.getWelcomeUserText(), expectedWelcomeUserText, "Register was not successful.");

    }
}
