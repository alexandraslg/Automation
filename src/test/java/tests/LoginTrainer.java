package tests;

import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.RegisterPage;
import utile.BaseTest;
import utile.ConfigLoader;

import static org.testng.Assert.assertEquals;

public class LoginTrainer extends BaseTest {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private RegisterPage registerPage;

    @Test
    public void testLoginTrainer(){
        initTest("Login Trainer");

        loginPage = new LoginPage(driver);

        ConfigLoader configLoader = new ConfigLoader("src/test/resources/properties/dataUser2.properties");
        String email = configLoader.getProperty("email");
        String password = configLoader.getProperty("password");

        loginUser(email, password);

        if (loginPage.forbiddenAccessElementIsDisplayed()) {
            registerPage = loginPage.clickRegisterTab();
            //registerPage.registerUser(true);

            loginUser(email, password);
        }
        assertEquals(dashboardPage.getUsernameDisplay(),email, "Login was not successful.");
    }

    private void loginUser(String email, String password) {
        loginPage.setUserEmail(email);
        loginPage.setUserPassword(password);
        dashboardPage = loginPage.clickLoginButton();
    }
}
