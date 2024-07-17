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
    private RegisterPage registerPage;

    @BeforeTest
    public void setup(){

    }

    @Test
    public void testAddNewEventInCalendar() {

        initTest("Add event in calendar");
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        registerPage = new RegisterPage(driver);
        login();

        ConfigLoader configLoaderDate = new ConfigLoader("src/test/resources/properties/dataUserCalendar.properties");
        dashboardPage.clickSpecificDayOnCalendar(configLoaderDate.getProperty("date"));
        dashboardPage.setEventTitle(configLoaderDate.getProperty("event"));
        dashboardPage.clickOnCreateEventButton();

        Assert.assertTrue(dashboardPage.isEventCreated(configLoaderDate.getProperty("event")));
    }

    private void login() {
        ConfigLoader configLoader = new ConfigLoader("src/test/resources/properties/dataUser2.properties");
        String email = configLoader.getProperty("email");
        String password = configLoader.getProperty("password");

        loginUser(email, password);

        if (loginPage.forbiddenAccessElementIsDisplayed()) {
            registerPage = loginPage.clickRegisterTab();
            registerPage.registerUser(true,null,null,null);

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
