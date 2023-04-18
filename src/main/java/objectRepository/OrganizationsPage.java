package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
  //Step1:declaration
	@FindBy(xpath="//img[@title=\"Create Organization...\"]")
	private WebElement createOrgLookUpImg;
	
	//Step2:-initialization
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
    
	//Step3:-utilization
	public WebElement getCreateOrgLookUpImg() {
		return createOrgLookUpImg;
	}
	
	//Step4:-Business Library
	/**
	 * This method will perform click operation on create organization look up image
	 */
	public void clickOnCreateOrganizationLookUpImg()
	{
		createOrgLookUpImg.click();
	}
}
