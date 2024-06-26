package tests;

import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.RegisterPage;
import utile.BaseTest;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RegisterUser extends BaseTest {
    private LoginPage loginPage;
    private RegisterPage registerPage;
    private DashboardPage dashboardPage;

    @Test
    public void registerUser(){

        initTest("Register User");


        driver.get("http://apptest.go.ro:9999/login");
        loginPage = new LoginPage(driver);

        registerPage = loginPage.clickRegisterTab();

        assertTrue(registerPage.getSignUpText().equalsIgnoreCase("Sign Up"));

        String email = "alexandraaaaaaAA";
        String password = "alexandra178dsdsAAA93";

        registerPage.setFirstNameField("Alexandra");
        registerPage.setLastNameField("Silaghi");
        registerPage.setPhoneNumberField("079465448854334556656145");
        registerPage.setEmailField(email);
        registerPage.setPasswordField(password);
        registerPage.setCityField("Cluj-Napoca");
        registerPage.clickOnCustomerCheckBox();
        loginPage = registerPage.clickSignUpButton();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        assertTrue(loginPage.getLoginText().equalsIgnoreCase("Login"));

        loginPage.setUserEmail(email);
        loginPage.setUserPassword(password);
        dashboardPage = loginPage.clickLoginButton();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        assertEquals(dashboardPage.getUsernameDisplay(), email);

    }
}
