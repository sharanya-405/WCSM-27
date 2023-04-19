package Vtiger.Practise;

import org.testng.annotations.Test;

public class ReadDataFromCmdLine {
  @Test
  public void sample()
  {
	 String BROWSER=System.getProperty("browser");
	 System.out.println(BROWSER);
	 
	  }
}
