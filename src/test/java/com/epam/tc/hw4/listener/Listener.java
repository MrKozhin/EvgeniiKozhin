package com.epam.tc.hw4.listener;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        Object driver = result.getTestContext().getAttribute("driver");

        if (driver != null) {
            AttachmentUtility.makeSreenshotAttachment("Fail screenshot",
                ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        }
    }
}
