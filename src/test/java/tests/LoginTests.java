package tests;

import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.RegisterPage;
import utile.BaseTest;


import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class LoginTests extends BaseTest {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    @Test
    public void testLoginWithIncorrectCredentials(){
        initTest("Login with incorrect credentials");

        driver.get("http://apptest.go.ro:9999/login");
        loginPage = new LoginPage(driver);

        String expectedForbiddenAccessText = "Access forbidden!";


        //modificare
        loginPage.setUserEmail("alexandra@example.com");
        loginPage.setUserPassword("incorrectPassword");
        loginPage.clickLoginButton();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        assertEquals(loginPage.getForbiddenAccessText(), expectedForbiddenAccessText, "The forbidden access text is incorrect.");

    }

    @Test
    public void testSuccessfulLogin(){
        initTest("Successful Login");

        driver.get("http://apptest.go.ro:9999/login");
        loginPage = new LoginPage(driver);

        loginPage.setUserEmail("alexandra@example.com");
        loginPage.setUserPassword("alexandra123");
        dashboardPage = loginPage.clickLoginButton();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        assertEquals(dashboardPage.getUsernameDisplay(),"alexandra@example.com", "Login was not successful.");
    }
}
