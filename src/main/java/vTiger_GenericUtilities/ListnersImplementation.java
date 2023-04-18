package vTiger_GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation of ITestListner interface of testNG
 * @author Admin
 *
 */
public class ListnersImplementation implements ITestListener {

	ExtentReports report;
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"=== test script execution started ====");
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"=== test script PASSED ===");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"=== test script FAILED ===");
		System.out.println(result.getThrowable());
		
		WebdriverUtility wUtil=new WebdriverUtility();
		
		String screenShotName=methodName+"-"+new JavaUtility().getSystemDateInFormat();
		
		try {
			wUtil.takesScreenShot(BaseClass.sdriver,screenShotName);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"=== test script SKIPPED ===");
		System.out.println(result.getThrowable());   //if the script is skipped it will print exception
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("==== Execution started ====");
		
		//Extent report configuration Report-05 APR 2023-10-23-45.html
		ExtentSparkReporter htmlReporter=new ExtentSparkReporter(".\\ExtentReport\\Report-"+new JavaUtility().getSystemDateInFormat()+".html"); 
	    htmlReporter.config().setDocumentTitle("Vtiegr Execution Report");
	    htmlReporter.config().setTheme(Theme.DARK);
	    htmlReporter.config().setReportName("Automation Execution Report");
	    
	    report=new ExtentReports();
	    report.attachReporter(htmlReporter);
	    report.setSystemInfo("Base URL", "http://localhost:8888");
	    report.setSystemInfo("Base Browser","chrome");
	    report.setSystemInfo("Base platform","Windows");
	    report.setSystemInfo("Reporter-name","sharanya");
	    
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("==== Execution finished ====");
		report.flush();  //generate the report
	}
   
	
	
	
	
	
	
	
	
}
