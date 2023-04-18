package objectRepositoryPractise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.LoginPage;

public class LoginPagePratise {
public static void main(String[] args) {
	WebDriverManager.firefoxdriver().setup();
	WebDriver driver=new FirefoxDriver();
	driver.get("http://localhost:8888/");
	
	LoginPage lpage=new LoginPage(driver);
	lpage.loginToApp("admin","admin");  //optimized way with the help of business library present in LoginPage pom class
	
}
}
