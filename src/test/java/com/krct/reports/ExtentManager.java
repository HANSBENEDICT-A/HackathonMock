package com.krct.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    static ExtentReports extent;

    public static ExtentReports getReport()
    {
        if (extent == null)
        {
            ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/ExtentReport.html");

            reporter.config().setReportName("OrangeHRM Automation Report");

            reporter.config().setDocumentTitle("Test Execution Report");

            extent = new ExtentReports();

            extent.attachReporter(reporter);
        }

        return extent;
    }
}