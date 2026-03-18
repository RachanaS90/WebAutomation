package PracticeWebAutomation.EventHub;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listener implements ITestListener {

	ExtentReports reports = Reportutility.extentReports();
	ExtentTest extenttest;

	ThreadLocal<ExtentTest> local = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
		extenttest = reports.createTest(result.getMethod().getMethodName());
		local.set(extenttest);
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("✅ Test Passed: " + result.getName());
		local.get().log(Status.PASS, "✅ Test Passed: " + result.getName());
	  }
	
	@Override
	public void onTestFailure(ITestResult result) {
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		reports.flush();
	}
	

}
