package com.qa.result;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.testbase.TestBase;
import com.qa.util.TestUtil;

public class Listeners extends TestBase implements ITestListener  {

	ExtentReports extent=TestUtil.getReportObject();
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test=extent.createTest(result.getMethod().getMethodName()); 
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	test.log(Status.PASS, "Test Pass");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
	test.fail(result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	test.skip(result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}

}
