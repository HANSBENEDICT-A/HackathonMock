package com.krct.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.krct.BaseTest;
import com.krct.reports.ExtentManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class TestListener extends BaseTest
        implements ITestListener {

    ExtentReports extent = ExtentManager.getReport();

    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result)
    {
        test = extent.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(
            ITestResult result)
    {
        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result)
    {
        test.fail("Test Failed");

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {

            FileHandler.copy(screenshot, new File("screenshots/" + result.getName() + ".png"));

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ITestContext context)
    {
        extent.flush();
    }
}