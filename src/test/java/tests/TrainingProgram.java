package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.RegisterPage;
import pages.TrainingsPage;
import utile.BaseTest;
import utile.ConfigLoader;


public class TrainingProgram extends BaseTest {

    private LoginPage loginPage = null;
    private DashboardPage dashboardPage = null;
    private RegisterPage registerPage = null;
    private TrainingsPage trainingsPage = null;
    private ConfigLoader configLoader;

    @Test
    public void clickOnTrainingTab() {
        initTest("Training program");
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        trainingsPage = new TrainingsPage(driver);
        registerPage = new RegisterPage(driver);

        login();
        dashboardPage.clickOnTraining();

        Assert.assertEquals(trainingsPage.getTrainingTabTitle(), "Training program");

    }

    private void login() {
        configLoader = new ConfigLoader("src/test/resources/properties/dataUser1.properties");

        String email = configLoader.getProperty("email");
        String password = configLoader.getProperty("password");

        loginPage.setUserEmail(email);
        loginPage.setUserPassword(password);
        loginPage.clickLoginButton();

        if (loginPage.forbiddenAccessElementIsDisplayed()) {
            registerPage = loginPage.clickRegisterTab();
            registerPage.registerUser(true);

            loginPage.setUserEmail(email);
            loginPage.setUserPassword(password);
            loginPage.clickLoginButton();

        }
    }
}



