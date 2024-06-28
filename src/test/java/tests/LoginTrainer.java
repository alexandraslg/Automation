package tests;

import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utile.BaseTest;
import utile.ConfigLoader;

import static org.testng.Assert.assertEquals;

public class LoginTrainer extends BaseTest {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    @Test
    public void testLoginTrainer(){
        initTest("Login Trainer");

        loginPage = new LoginPage(driver);

        ConfigLoader configLoader = new ConfigLoader("src/test/resources/properties/dataUser1.properties");
        String email = configLoader.getProperty("email");
        String password = configLoader.getProperty("password");

        loginPage.setUserEmail(email);
        loginPage.setUserPassword(password);
        dashboardPage = loginPage.clickLoginButton();

        assertEquals(dashboardPage.getUsernameDisplay(),email, "Login was not successful.");
    }
}
