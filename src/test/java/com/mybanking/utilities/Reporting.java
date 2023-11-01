package com.mybanking.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reporting implements ITestListener {
	
	public static ExtentReports extent;
	public static ExtentSparkReporter spark;
	public static ExtentTest test;
	
	
	
	public static void setExtent() {
		
		spark = new ExtentSparkReporter("ExtentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(spark);
	
		
	
	}
	
	public static void endReport() {
		extent.flush();
	}
	
	
	public void onStart(ITestContext context) {	
		setExtent();
		System.out.println("onStart method started");
	}

	public void onFinish(ITestContext context) {
		System.out.println("onFinish method started");
		endReport();
	}
	
		public void onTestStart(ITestResult result) {
			System.out.println("New Test Started" +result.getName());
		}
		
		public void onTestSuccess(ITestResult result) {
			System.out.println("onTestSuccess Method" +result.getName());
			test=extent.createTest(result.getName());
			test.log(Status.PASS, MarkupHelper.createLabel("Name of the Passed Test Case is " + result.getName() ,  ExtentColor.GREEN));
		
			}

		public void onTestFailure(ITestResult result) {
			System.out.println("onTestFailure Method" +result.getName());
			test=extent.createTest(result.getName());
			test.log(Status.FAIL, MarkupHelper.createLabel("Name of the Failed Test Case is " + result.getName() ,  ExtentColor.RED));
		
			test.addScreenCaptureFromPath("C:\\Users\\ASUS\\eclipse-workspace\\My_Banking\\Screenshot\\");
			
		}

		public void onTestSkipped(ITestResult result) {
			System.out.println("onTestSkipped Method" +result.getName());
			test=extent.createTest(result.getName());
			test.log(Status.SKIP, MarkupHelper.createLabel("Name of the Skiped Test Case is " + result.getName() ,  ExtentColor.BROWN));
		
			
			
		}

		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			System.out.println("onTestFailedButWithinSuccessPercentage" +result.getName());
		}

}
