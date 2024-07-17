package step_definition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.DashboardPage;
import pages.LoginPage;
import pages.RegisterPage;
import utile.BaseTest;
import utile.ConfigLoader;

import static org.testng.Assert.assertEquals;

public class CalendarSteps extends BaseTest {

    @Before
    public void beforeScenario(){
        setupClass();
        initTest("Cucumber Calendar Test");
    }

    @After
    public void afterScenario(){
        tearDown();
    }

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private RegisterPage registerPage;

    private String email = "";
    private String password = "";

    @Given("User is logged in with email {string}, password {string}, and phone number {string}")
    public void user_is_logged_in_with_email_password_and_phone_number(String email, String password, String phoneNumber) {

        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        registerPage = new RegisterPage(driver);

        login(email, password, phoneNumber);

    }
    @When("User navigates to the specific day {string}")
    public void user_navigates_to_the_specific_day(String date) {

        dashboardPage.clickSpecificDayOnCalendar(date);
    }
    @When("User creates a new event {string}")
    public void user_creates_a_new_event(String eventText) {

        dashboardPage.setEventTitle(eventText);
        dashboardPage.clickOnCreateEventButton();
    }
    @Then("The event {string} is present in the calendar")
    public void the_event_is_present_in_the_calendar(String eventText) {

        Assert.assertTrue(dashboardPage.isEventCreated(eventText),"Event text is not the same.");

    }

    private void login(String email, String password, String phoneNumber) {

        loginUser(email, password);

        if (loginPage.forbiddenAccessElementIsDisplayed()) {
            registerPage = loginPage.clickRegisterTab();
            registerPage.registerUser(true, email, password, phoneNumber);

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
