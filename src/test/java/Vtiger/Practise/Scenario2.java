package Vtiger.Practise;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import login.Fetching_Details_From_Properties;

public class Scenario2 {
public static void main(String[] args) throws Exception {
	//reading the data from properties file
  FileInputStream fisp=new FileInputStream(".\\src\\test\\resources\\commonDataFrom.Properties");
  Properties pobj=new Properties();
  pobj.load(fisp);
  String BROWSER=pobj.getProperty("browser");
  String URL=pobj.getProperty("url");
  String USERNAME=pobj.getProperty("username");
  String PASSWORD=pobj.getProperty("password");
  
  Random r=new Random();
  int add=r.nextInt(1000);
  //read the data from excel sheet
  FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
  Workbook book=WorkbookFactory.create(fise);
  String orgname=book.getSheet("Organizatio").getRow(1).getCell(2).getStringCellValue()+add;
  
  WebDriver driver=null;
  //Step1:Launching the browser
   if(BROWSER.equalsIgnoreCase("chrome"))
   {
	   driver=new ChromeDriver();
   }
   else if(BROWSER.equalsIgnoreCase("firefox"))
		   {
	          driver=new FirefoxDriver();
		   }
   else 
   {
	   System.out.println("invalid browser name");
   }
	   driver.get(URL);
		   
  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  driver.manage().window().maximize();
  
  //Step2:Login to app
  driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME,Keys.TAB,PASSWORD,Keys.ENTER);
  
  //Step3:Create organization
  driver.findElement(By.linkText("Organizations")).click();
  driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
  driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);
  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
  
  //Step3:Validation
  String dvHeader=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
  if(dvHeader.contains(orgname))
   System.out.println("----passed----");
  else
	  System.out.println("---failed---");
  
  //Step4:Logout
  driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
  driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
  System.out.println("Logged out successfully!!");
  driver.quit();
}
}
