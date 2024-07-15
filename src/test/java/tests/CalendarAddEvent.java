package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.RegisterPage;
import pages.TrainingsPage;
import utile.BaseTest;
import utile.ConfigLoader;

import static org.testng.Assert.assertEquals;

public class CalendarAddEvent extends BaseTest {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private TrainingsPage trainingsPage;
    private ConfigLoader configLoader;
    private RegisterPage registerPage;

    @BeforeTest
    public void setup(){

    }

    @Test
    public void testAddNewEventInCalendar() {

        initTest("Add event in calendar");
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        trainingsPage = new TrainingsPage(driver);
        registerPage = new RegisterPage(driver);
        login();



    }

    private void login() {
        configLoader = new ConfigLoader("src/test/resources/properties/dataUser2.properties");
        String email = configLoader.getProperty("email");
        String password = configLoader.getProperty("password");

        loginUser(email, password);

        if (loginPage.forbiddenAccessElementIsDisplayed()) {
            registerPage = loginPage.clickRegisterTab();
            registerPage.registerUser(true);

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
