package Vtiger.Practise;

import org.testng.Assert;
import org.testng.annotations.Test;

public class IRetryAnalyzerPractise {
 @Test(retryAnalyzer=vTiger_GenericUtilities.IRetryAnalyzerImplementation.class)
 public void sample()
 {
	 Assert.fail();
	 System.out.println("hai");
 }
}
