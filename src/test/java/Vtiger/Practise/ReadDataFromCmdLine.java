package Vtiger.Practise;

import org.testng.annotations.Test;

public class ReadDataFromCmdLine {
  @Test
  public void sample()
  {
	 String USERNAME=System.getProperty("username");
	 System.out.println(USERNAME);
	 
	 String PASSWORD=System.getProperty("password");
	 System.out.println(PASSWORD);
  }
}
