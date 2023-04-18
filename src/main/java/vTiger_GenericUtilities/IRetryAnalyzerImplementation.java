package vTiger_GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class is an implementation of IRetryAnalyzer interface of testNG
 * @author Sharanya
 *
 */
public class IRetryAnalyzerImplementation implements IRetryAnalyzer{

	int count=0;
	int retryCount=4;
	
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		while(count<retryCount)
		{
			count++;
			return true;
		}
		return false;
	}

}
