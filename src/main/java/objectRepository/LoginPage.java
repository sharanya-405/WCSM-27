package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
  //Step1:-Create seperate POM class for every web page
	//Step2:-identify and store web elements by using selenium annotations
	@FindBy(name="user_name")
	private WebElement userNameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindAll({@FindBy(id="submitButton"),@FindBy(xpath="//input[@type='submit']")})
	private WebElement submitBtn;
	
	//Step3:-Initialise these web elements with a constructor
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//Step4:-provide getters to access these elements
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	//Step5:-Business library-Generic methods-Project specific
	/**
	 * This method will login to application
	 * @param USERNAME
	 * @param PASSWORD
	 */
	public void loginToApp(String USERNAME,String PASSWORD)
	{
		userNameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		submitBtn.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}























