package tests;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegisterPage;
import utile.BaseTest;
import static org.testng.Assert.assertTrue;

public class RegisterUser extends BaseTest {
    private LoginPage loginPage;
    private RegisterPage registerPage;

    @Test
    public void registerUser(boolean isTrainer){

        initTest("Register User");

        loginPage = new LoginPage(driver);
        registerPage = loginPage.clickRegisterTab();

        assertTrue(registerPage.getSignUpText().equalsIgnoreCase("Sign Up"));

        registerPage.registerUser(true);

        assertTrue(loginPage.getLoginText().equalsIgnoreCase("Login"));


    }
}
