package Vtiger.Practise;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNgPractiseTest {
  @Test(priority=3,dependsOnMethods="mobileUser")
  public void car()
  {
	  System.out.println("BMW");
  }
  @Test(priority=1,invocationCount=2)
  public void mobile()
  {
	  System.out.println("samsung");
  }
  @Test()
  public void mobileUser()
  {
	  Assert.fail();
	  System.out.println("mobile user created");
  }
}
