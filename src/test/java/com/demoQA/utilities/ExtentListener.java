package com.demoQA.utilities;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;

import com.demoQA.pages.Base;

public class ExtentListener implements ITestListener {
    private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> testThread = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        testThread.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        testThread.get().log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        testThread.get().log(Status.FAIL, "Test failed: " + result.getThrowable());
        String screenshotPath = ScreenshotUtil.captureScreenshot(Base.getDriver(), result.getMethod().getMethodName());
        try {
            testThread.get().addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        testThread.get().log(Status.SKIP, "Test skipped: " + result.getThrowable());
    }

    public static ExtentTest getCurrentTest() {
        return testThread.get();
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}

