package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    private static ExtentReports extent;

    public synchronized static ExtentReports getExtentReports() {
        if (extent == null) {
            String reportPath = "target/extent-reports/extent.html";
            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportPath);
            htmlReporter.config().setDocumentTitle("OrangeHRM Test Report");
            htmlReporter.config().setReportName("OrangeHRM Automation Results");
            htmlReporter.config().setTheme(Theme.STANDARD);

            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("Framework", "Selenium + TestNG + Java");
        }
        return extent;
    }
}