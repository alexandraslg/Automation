package utile;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportManager {

    private static ExtentReports extentReports;

    public static ExtentReports getInstance(){

        if(extentReports == null){
            String reportName = "target/test-report.html";
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportName);
            extentReports = new ExtentReports();
            extentReports.attachReporter(sparkReporter);
            sparkReporter.config().setTheme(Theme.DARK);
            sparkReporter.config().setDocumentTitle("My report");
        }
        return extentReports;
    }

    public static ExtentTest createTest(String testName){
        return getInstance().createTest(testName);
    }
}
