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
import static org.testng.Assert.assertTrue;


public class TrainingProgram extends BaseTest {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private TrainingsPage trainingsPage;
    private ConfigLoader configLoader;
    private RegisterPage registerPage;

    @BeforeTest
    public void setup(){

    }

    @Test
    public void clickOnTrainingTab() {

        initTest("Training program");
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        trainingsPage = new TrainingsPage(driver);
        registerPage = new RegisterPage(driver);
        configLoader = new ConfigLoader("src/test/resources/properties/dataUser2.properties");
        login();

        dashboardPage.clickOnTraining();
        Assert.assertEquals(trainingsPage.getTrainingTabTitle(), "Training program");
        trainingsPage.clickOnGenerateProgramButton();
        String dayIndex = configLoader.getProperty("dayIndex");
        String trainingProgram = configLoader.getProperty("trainingProgram");
        trainingsPage.dragAndDropTrainingProgram(dayIndex, trainingProgram);

        assertTrue(trainingsPage.getTrainingProgramOnWeekDay(configLoader.getProperty("dayIndex"),"legs").equalsIgnoreCase("legs"));
    }

    private void login() {

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



