package TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


import Utilities.ExtentReportUtility;

public class Listeners implements ITestListener{

		ExtentTest test;

		ExtentReports extent = ExtentReportUtility.createExtentReports();
		ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

		public void onTestStart(ITestResult result) {//calls when test methods starts
		ITestListener.super.onTestStart(result);
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
		}

		public void onTestSuccess(ITestResult result) {//called when test method passess
		ITestListener.super.onTestSuccess(result);
		extentTest.get().log(Status.PASS, "Test Passed");
		}

		public void onTestFailure(ITestResult result) {//called when test method fails
		ITestListener.super.onTestFailure(result);
		extentTest.get().log(Status.FAIL, "Test Failed");
		extentTest.get().fail(result.getThrowable());
		WebDriver driver = null;
		String testMethodName = result.getMethod().getMethodName();
		try {
		driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
		.get(result.getInstance());
		} catch (IllegalArgumentException e) {

		e.printStackTrace();
		} catch (IllegalAccessException e) {

		e.printStackTrace();
		} catch (NoSuchFieldException e) {

		e.printStackTrace();
		} catch (SecurityException e) {

		e.printStackTrace();
		}

		try {
		driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
		.get(result.getInstance());
		} catch (Exception e) {
		}
		}

		public void onTestSkipped(ITestResult result) {//called when test method is skipped
		ITestListener.super.onTestSkipped(result);
		extentTest.get().log(Status.SKIP, "Test Skipped");
		String testMethodName = result.getMethod().getMethodName();
		}

		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {//called when test method fails within success percentage
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
		}

		public void onTestFailedWithTimeOut(ITestResult result) {
		ITestListener.super.onTestFailedWithTimeout(result);
		}

		public void onStart(ITestContext context) {//called before test method starts
		ITestListener.super.onStart(context);
		}

		public void onFinish(ITestContext context) {//called after test method finishes
		ITestListener.super.onFinish(context);
		extent.flush();//if flush is not called report wont be generated
		}
		



	
		
}