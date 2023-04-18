package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage {
  //Step1:-Declaration
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement contactHeaderText;
	
	//Step2:-Initialization
	public ContactsInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//Step3:-Utilization
	public WebElement getContactHeaderText() {
		return contactHeaderText;
	}
	
	//Step4:-Business Library
	public String getContactHeader()
	{
		return contactHeaderText.getText();
	}
	
	
}
