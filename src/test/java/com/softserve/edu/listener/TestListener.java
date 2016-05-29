package com.softserve.edu.listener;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.softserve.edu.atqc.loggers.LoggerUtils;
import com.softserve.edu.atqc.tools.CaptureScreenImage;

public class TestListener extends TestListenerAdapter {

	@Override
	public void onTestSuccess(ITestResult result) {
		LoggerUtils.get().infoLog("Test " + result.getName() + " FROM CLASS " + result.getTestClass().getName() + " PASSED");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		LoggerUtils.get().errorLog("Test " + result.getName() + " FROM CLASS " + result.getTestClass().getName() + " FAILED");
		String fileNamePath = CaptureScreenImage.get().captureAndSaveScreen();
		LoggerUtils.get().insertPathToScreenShot(fileNamePath);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		LoggerUtils.get().infoLog("Test " + result.getName() + " FROM CLASS " + result.getTestClass().getName() + " SKIPPED");
	}
	
	@Override
	public void onFinish(ITestContext context) {
		SendEmail.sendDefaultEmail();
	}
}
