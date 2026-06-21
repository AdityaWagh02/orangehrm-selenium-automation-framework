package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.DriverFactory;
import utils.ExtentManager;
import utils.ScreenshotUtil;

public class BaseTest {
    protected WebDriver driver;
    protected static ExtentReports extent;
    protected ExtentTest test;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        extent = ExtentManager.getExtentReports();
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = DriverFactory.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(org.testng.ITestResult result) {
        if (result.getStatus() == org.testng.ITestResult.FAILURE) {
            String path = ScreenshotUtil.takeScreenshot(driver, result.getName());
            if (path != null) {
                test.fail("Screenshot: " + path);
            }
        }
        DriverFactory.quitDriver();
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        if (extent != null) {
            extent.flush();
        }
    }
}