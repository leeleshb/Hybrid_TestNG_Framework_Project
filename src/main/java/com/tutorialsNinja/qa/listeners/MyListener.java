package com.tutorialsNinja.qa.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.tutorialsNinja.qa.utils.ExtentReporter;
import com.tutorialsNinja.qa.utils.Utilities;

public class MyListener implements ITestListener {

	ExtentReports extentReport;
	ExtentTest extentTest;

	@Override
	public void onStart(ITestContext context) {

			extentReport = ExtentReporter.generateExtentReport();
	}

	@Override
	public void onTestStart(ITestResult result) {

		String testName = result.getName();
		extentTest = extentReport.createTest(testName);
		extentTest.log(Status.INFO, testName + " started executing");
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		String testName = result.getName();
		extentTest.log(Status.INFO, testName + " got successfully executed");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		String testName = result.getName();

		WebDriver driver = null;

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}

		String destinationScreenshotPath = Utilities.captureScreenshot(driver, testName);

		extentTest.addScreenCaptureFromPath(destinationScreenshotPath);
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.FAIL, testName + " got failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		String testName = result.getName();
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, testName + " got skipped");
		
	}

	@Override
	public void onFinish(ITestContext context) {

		extentReport.flush();

		String pathOfExtentReport = System.getProperty("user.dir") + "\\test-output\\Extent Report\\eReport.html";
		File reportFile = new File(pathOfExtentReport);
		try {
			Desktop.getDesktop().browse(reportFile.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
