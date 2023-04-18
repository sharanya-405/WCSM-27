package Vtiger.Practise;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractise {
   @Test
   public void practise()
   {
	   System.out.println("Step1");
	   Assert.assertEquals("a","a");
	   System.out.println("Step1");
	   Assert.assertTrue(false);
	   System.out.println("Step1");
	   System.out.println("Step1");
   }
   @Test
   public void practise1()
   {
	   SoftAssert sa=new SoftAssert();
	   System.out.println("Step1:-practise");
	   sa.assertEquals("a","s");
	   System.out.println("Step2:-practise");
	   sa.assertTrue(true);
	   System.out.println("Step3:-practise");
	   sa.assertFalse(true);
	   System.out.println("Step4:-practise");
	   sa.assertAll();
	   
   }
}
