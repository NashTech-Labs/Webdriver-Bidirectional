package Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

    public static ExtentReports extent;
    public static ExtentTest test;
    public static ExtentHtmlReporter htmlReporter;

    public static ExtentReports setupExtentReport() {
        // Initialize ExtentHtmlReporter
        htmlReporter = new ExtentHtmlReporter("target/extent-reports/extent-report.html");
        htmlReporter.config().setDocumentTitle("Test Report");
        htmlReporter.config().setReportName("Automation Test Results");
        htmlReporter.config().setTheme(Theme.DARK);

        // Initialize ExtentReports and attach the reporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        return extent;
    }

    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}
