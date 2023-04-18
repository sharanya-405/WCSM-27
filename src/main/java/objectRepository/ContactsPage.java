package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	//Step1:-Decleration
  @FindBy(xpath="//img[@alt='Create Contact...']")
  private WebElement createContactLookUpImg;
  
  //Step2:-Initialization
  public ContactsPage(WebDriver driver)
  {
	  PageFactory.initElements(driver,this);
  }

  //Step3:-Utilization
  public WebElement getCreateContactLookUpImg() 
  {
	return createContactLookUpImg;
  }
  
  //Step4:-Business Library
  /**
   * This method will click on create new contact look up image
   */
  public void clickOnCreateContactLokUpImg()
  {
	  createContactLookUpImg.click();
  }
  
  
  
}
