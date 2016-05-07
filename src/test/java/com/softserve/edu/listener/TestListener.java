package com.softserve.edu.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.softserve.edu.atqs.tools.loggers.CaptureScreenImage;
import com.softserve.edu.atqs.tools.loggers.Log4jWrapper;

public class TestListener implements ITestListener {

	@Override
	public void onTestSuccess(ITestResult result) {
		Log4jWrapper.get().info("Test " + result.getName() + " FROM CLASS " + result.getTestClass().getName() + " PASSED");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Log4jWrapper.get().info("Test " + result.getName() + " FROM CLASS " + result.getTestClass().getName() + " FAILED");
		String fileNamePath = CaptureScreenImage.get().captureAndSaveScreen();
		Log4jWrapper.get().insertScreenShot(fileNamePath);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Log4jWrapper.get().info("Test " + result.getName() + " FROM CLASS " + result.getTestClass().getName() + " SKIPPED");
	}
	
	@Override
	public void onTestStart(ITestResult result) {
	}
	
	@Override
	public void onFinish(ITestContext context) {
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
	}
}
