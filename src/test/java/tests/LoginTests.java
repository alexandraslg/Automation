package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utile.BaseTest;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class LoginTests extends BaseTest {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;


    @Test
    public void testLoginWithIncorrectCredentials(){
        initTest("Login with incorrect credentials");

        loginPage = new LoginPage(driver);

        String expectedForbiddenAccessText = "Access forbidden!";

        loginPage.setUserEmail("alexandra@example.com");
        loginPage.setUserPassword("incorrectPassword");
        loginPage.clickLoginButton();

        // Implicit wait
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Explicit wait - more dynamic
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getForbiddenAccessWebElement()));

        assertEquals(loginPage.getForbiddenAccessText(), expectedForbiddenAccessText, "The forbidden access text is incorrect.");

    }

    @Test
    public void testSuccessfulLogin(){
        initTest("Successful Login");

        loginPage = new LoginPage(driver);

        loginPage.setUserEmail("alexandra@example.com");
        loginPage.setUserPassword("alexandra123");
        dashboardPage = loginPage.clickLoginButton();

        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardPage.getUsernameWebElement()));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        assertEquals(dashboardPage.getUsernameDisplay(),"alexandra@example.com", "Login was not successful.");
    }
}
