package com.krct.listeners;

import com.krct.BaseTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class TestListener extends BaseTest
        implements ITestListener {

    @Override
    public void onTestFailure(
            ITestResult result)
    {
        File screenshot =
                ((TakesScreenshot) driver)
                        .getScreenshotAs(
                                OutputType.FILE
                        );

        try {

            FileHandler.copy(
                    screenshot,
                    new File(
                            "screenshots/"
                                    + result.getName()
                                    + ".png"
                    )
            );

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}