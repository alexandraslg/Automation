package utile;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;


public class BaseTest {

    public WebDriver driver;
    private ExtentTest extentTest;
    private ScreenshotUtils screenshotUtils;
    private static ExtentReports extentReports;
    private ConfigLoader configLoader;

    @BeforeClass
    public void setupClass(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        screenshotUtils = new ScreenshotUtils(driver);
        configLoader = new ConfigLoader("src/test/resources/properties/url.properties");
        String url = configLoader.getProperty("url");
        driver.get(url);
        extentReports = ReportManager.getInstance();
    }

    @AfterClass
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }

        // Flush the report
        if (extentReports != null) {
            extentReports.flush();
        }
    }

    /**
     * This method creates the test result
     * @param result
     */

    @AfterMethod
    public void afterMethod(ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE){
            captureAndSaveFailureScreenshot(result.getMethod().getMethodName());
        }
        if (result.getStatus() == ITestResult.FAILURE){
            extentTest.log(Status.FAIL, MarkupHelper.createLabel("Test case failed: " + result.getName(), ExtentColor.RED));
            extentTest.fail(result.getThrowable());
        }
        else if (result.getStatus() == ITestResult.SUCCESS){
            extentTest.log(Status.PASS, MarkupHelper.createLabel("Test case passed: " + result.getName(), ExtentColor.GREEN));
        }
        else {
            extentTest.log(Status.SKIP, MarkupHelper.createLabel("Test case skipped: " + result.getName(), ExtentColor.YELLOW));
        }

    }

    public void initTest(String testName){
        extentTest = ReportManager.createTest(testName);

    }

    private void captureAndSaveFailureScreenshot(String testName){
        //We create a new folder, if it doesn't exist
        File screenshotDirectory = new File("screenshots");
        if (!screenshotDirectory.exists()){
            screenshotDirectory.mkdir();
        }

        // Capture and save screenshot
        screenshotUtils.captureAndSaveScreenshots(testName);

    }
}
