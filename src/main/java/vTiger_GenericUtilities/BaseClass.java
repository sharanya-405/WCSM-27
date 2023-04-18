package vTiger_GenericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.HomePage;
import objectRepository.LoginPage;

/**
 * This class consists of all the basic configuration annotations
 * @author Sharanya
 *
 */
public class BaseClass {
	//Step1:-Object creation of all the generic utilities
	public ChromeOptions options=new ChromeOptions();
	public WebDriver driver=null;
	public static WebDriver sdriver;
	public Propertyutility pUtil=new Propertyutility();
	public ExcelUtility eUtil=new ExcelUtility();
	public JavaUtility jUtil=new JavaUtility();
	public WebdriverUtility wUtil=new WebdriverUtility();
   @BeforeSuite(alwaysRun=true)
   public void bsConfig()
   {
	   System.out.println("-----database connection created successful------");
   }
   
  // @Parameters("browser")
  // @BeforeTest
   @BeforeClass(alwaysRun=true)
   public void bcConfig(/*String BROWSER*/) throws IOException
   {
	 String BROWSER=pUtil.getDataFromPoperties("browser"); //
	  String URL=pUtil.getDataFromPoperties("url");
	  //Step2:-Launching the browser
	  if(BROWSER.equalsIgnoreCase("chrome"))
	  {
		  WebDriverManager.chromedriver().setup();
		  options.addArguments("--remote-allow-origins=*");
		  driver=new ChromeDriver(options);
		  System.out.println("---"+BROWSER+" "+"launched successful---");
	  }
	  else if(BROWSER.equalsIgnoreCase("firefox"))
	  {
		  WebDriverManager.firefoxdriver().setup();
		  driver=new FirefoxDriver();
		  System.out.println("---"+BROWSER+" "+"launched successful---");
	  }
	  else
	  {
		  System.out.println("Invalid browser name");
	  }
	  sdriver=driver;
	  wUtil.waitForPageLoad(driver);
	   wUtil.maximizeWindow(driver);
	   driver.get(URL);
   }
   
   @BeforeMethod(alwaysRun=true)
   public void bmConfig() throws IOException
   {
	   //Step3:-Login to the application
	   String USERNAME=pUtil.getDataFromPoperties("username");
	   String PASSWORD=pUtil.getDataFromPoperties("password");
	   LoginPage lp=new LoginPage(driver);
	   lp.loginToApp(USERNAME, PASSWORD);
	   System.out.println("Login to application successful");
    }
   
   @AfterMethod(alwaysRun=true)
   public void amConfig()
   {
	   //Step4:-Logout from the application
	   HomePage hp=new HomePage(driver);
	   hp.logOutApp(driver);
	   System.out.println("Logout of application successful");
   }
   
   //@AfterTest
   @AfterClass(alwaysRun=true)
   public void acConfig()
   {
	   //Step5:-close the browser
	   driver.quit();
	   System.out.println("Browser closed successfully");
   }
   
   @AfterSuite(alwaysRun=true)
   public void asConfig()
   {
	   System.out.println("-----database connection closed successful------");
   }
}










