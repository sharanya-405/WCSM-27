package Vtiger.Practise;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import login.Fetching_Details_From_Properties;
public class Scenario1 {
public static void main(String[] args) throws Exception{
	
	//Reading the data from properties
	FileInputStream fisp=new FileInputStream(".\\src\\test\\resources\\commonDataFrom.Properties");
	Properties p=new Properties();
	p.load(fisp);
	String BROWSER=p.getProperty("browser");
	String URL=p.getProperty("url");
	String USERNAME=p.getProperty("username");
	String PASSWORD=p.getProperty("password");
	
	Random rd=new Random();
	int add=rd.nextInt(1000);
	//Reading data from excel
	FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	Workbook book=WorkbookFactory.create(fise);
	String orgname=book.getSheet("Organizatio").getRow(1).getCell(2).getStringCellValue()+add;
	
	WebDriver driver=null;
	//Step1:Launch the browser-RUNTIME POLYMORPHISM
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
	
	
	//Step2:Perform login
	driver.findElement(By.xpath("//input[@type='text']")).sendKeys(USERNAME,Keys.TAB,PASSWORD,Keys.ENTER);
	
	//Step3:Create Contact
	driver.findElement(By.xpath("//a[text()='Contacts']")).click();
	driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	WebElement w=driver.findElement(By.xpath("//select[@name='salutationtype']"));
			w.click();
    Select s=new Select(w);
	s.selectByValue("Mr.");
	driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Nishal"+add);
	driver.findElement(By.xpath("//input[@id='mobile']")).sendKeys("6500128877");
	driver.findElement(By.xpath("//input[@id='email']")).sendKeys("xyz@gmail.com");
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	
	//Step4:Validation
	String dvHeader=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(dvHeader.contains("Nishal"))
	{
	  System.out.println("-----passed------");
	}
	else
	{
		System.out.println("---Failed----");
	}
	
	//Step5:Logout
	driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	driver.findElement(By.linkText("Sign Out")).click();
	System.out.println("successfully logged out!!");
	driver.quit();
				}	
}

