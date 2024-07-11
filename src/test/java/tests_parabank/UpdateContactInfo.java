package tests_parabank;

import org.testng.annotations.Test;
import pages_parabank.HomePage;
import pages_parabank.OverviewPage;
import pages_parabank.UpdateProfilePage;
import utile.BaseTest;
import utile.ConfigLoader;

import static org.testng.Assert.assertEquals;

public class UpdateContactInfo extends BaseTest {

    private HomePage homePage;
    private OverviewPage overviewPage;
    private UpdateProfilePage updateProfilePage;

    @Test
    public void testUpdateContactInfo(){
        initTest("Update Contact Info");

        homePage = new HomePage(driver);

        ConfigLoader configLoader = new ConfigLoader("src/test/resources/properties/bankUser3.properties");
        String username = configLoader.getProperty("username");
        String password = configLoader.getProperty("password");

        homePage.setUsernameField(username);
        homePage.setPasswordField(password);
        overviewPage = homePage.clickOnLoginButton();

        updateProfilePage = overviewPage.clickOnUpdateContactInfoButton();

        ConfigLoader configLoaderInfo = new ConfigLoader("src/test/resources/properties/bankUser3UpdateProfile.properties");
        String firstName = configLoaderInfo.getProperty("firstName");
        String lastName = configLoaderInfo.getProperty("lastName");
        String address = configLoaderInfo.getProperty("address");
        String city = configLoaderInfo.getProperty("city");
        String state = configLoaderInfo.getProperty("state");
        String zipCode = configLoaderInfo.getProperty("zipCode");
        String phone = configLoaderInfo.getProperty("phone");

        updateProfilePage.setUpdateFirstName(firstName);
        updateProfilePage.setUpdateLastName(lastName);
        updateProfilePage.setUpdateAddress(address);
        updateProfilePage.setUpdateCity(city);
        updateProfilePage.setUpdateState(state);
        updateProfilePage.setUpdateZipCode(zipCode);
        updateProfilePage.setUpdatePhone(phone);
        updateProfilePage.clickOnUpdateProfileButton();

        assertEquals(updateProfilePage.getProfileUpdatedMessage(), "Profile Updated","Profile was not updated successfully.");



    }
}
