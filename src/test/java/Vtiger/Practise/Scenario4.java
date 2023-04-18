package Vtiger.Practise;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import login.Fetching_Details_From_Properties;

public class Scenario4 {
	public static void main(String[] args) throws Exception {
		   Fetching_Details_From_Properties fd=new Fetching_Details_From_Properties();
		  String USERNAME= fd.getDataFromProperty("username");
		  String PASSWORD=fd.getDataFromProperty("password");
		  String URL=fd.getDataFromProperty("url");
		  
		  //Step1:Launch the browser
		  WebDriver driver=new ChromeDriver();
		  Random r=new Random();
		  int add=r.nextInt(1000);
		  driver.get(URL);
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  driver.manage().window().maximize();
		  
		  //Step2:Login
		  driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME,Keys.TAB,PASSWORD,Keys.ENTER);
		  
		  //Step3:Create organization
		  driver.findElement(By.linkText("Organizations")).click();
		  driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		  driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("wipro"+add);
		  WebElement w=driver.findElement(By.xpath("//select[@name='industry']"));
		  Select s=new Select(w);
		  s.selectByValue("Energy");
		  WebElement w1= driver.findElement(By.xpath("//select[@name='accounttype']"));
		  Select s1=new Select(w1);
		  s1.selectByValue("Customer");
		  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		  
		//Step3:Validation
		  String dvHeader=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		  if(dvHeader.contains("wipro"))
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
