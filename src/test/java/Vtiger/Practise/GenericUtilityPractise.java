package Vtiger.Practise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger_GenericUtilities.ExcelUtility;
import vTiger_GenericUtilities.JavaUtility;
import vTiger_GenericUtilities.Propertyutility;
import vTiger_GenericUtilities.WebdriverUtility;

public class GenericUtilityPractise {
  public static void main(String[] args) throws Exception  {
	Propertyutility PUTIL=new Propertyutility();
	String BROWSER=PUTIL.getDataFromPoperties("browser");
	String URL=PUTIL.getDataFromPoperties("url");
	String USERNAME=PUTIL.getDataFromPoperties("username");
	String PASSWORD=PUTIL.getDataFromPoperties("password");
	System.out.println(BROWSER+"\n"+URL+"\n"+USERNAME+"\n"+PASSWORD);
	
	ExcelUtility EUTIL=new ExcelUtility();
	String data=EUTIL.getDataFromExcel("Contact",1,1);
	System.out.println(data);
	
	EUTIL.writeIntoExcel("Contact", 2, 5, "nishuuuu");
	System.out.println("data added");
	
	JavaUtility JUTIL=new JavaUtility();
	System.out.println(JUTIL.getrandomNumber());
	System.out.println(JUTIL.getSystemDate());
	
	System.out.println(JUTIL.getSystemDateInFormat());
	
	WebDriverManager.firefoxdriver().setup();
	WebDriver driver=new FirefoxDriver();
	
	WebdriverUtility WUTIL=new WebdriverUtility();
	WUTIL.maximizeWindow(driver);
	Thread.sleep(2000);
	WUTIL.minimizeWindow(driver);
	
}
}
