package Vtiger.Practise;

import java.time.Duration;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import login.Fetching_Details_From_Properties;

public class Scenario5 {
public static void main(String[] args) throws Exception {
	Fetching_Details_From_Properties fd=new Fetching_Details_From_Properties();
	String USERNAME=fd.getDataFromProperty("username");
	String PASSWORD=fd.getDataFromProperty("password");
	String URL=fd.getDataFromProperty("url");
	
	//Step1:Launch the Browser
	WebDriver driver=new ChromeDriver();
	driver.get(URL);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	//Step2:Perform Login
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	
	//Step3:Navigate to Contacts module
	driver.findElement(By.linkText("Contacts")).click();

	//Step4:Create Contact and add organization
	Random r=new Random();
	int add=r.nextInt(10000);
	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	driver.findElement(By.name("lastname")).sendKeys("sharan"+add);
	driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
	
	     //add organization
	String parentId=driver.getWindowHandle();
	Set<String> childIds=driver.getWindowHandles();
	Iterator<String> itr=childIds.iterator();
	while(itr.hasNext())
	{
		String ids=itr.next();
		String titles=driver.switchTo().window(ids).getTitle();
		if(parentId.contains(titles))
		{
			break;
		}
	}
	driver.findElement(By.xpath("//a[text()='wipro21']")).click();
	driver.switchTo().window(parentId);
	driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
	
	//Step5:Validation
	String dvHeader=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(dvHeader.contains("sharan"))
		System.out.println("-----passed----");
	else
		System.out.println("----failed----");
	
	//Step6:Logout from application
	driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	driver.findElement(By.linkText("Sign Out")).click();
	System.out.println("loggedout successfully!!");
	
	//close the browser
	driver.quit();
	
}
}
