package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
  //Step1:-Decleration
	@FindBy(xpath="//span[@class=\"dvHeaderText\"]")
	private WebElement orgHeaderText;
	
	//Step2:-Initialization
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//Step3:-Utilization
	public WebElement getOrgHeaderText() {
		return orgHeaderText;
	}
	
	//Step4:-Business Library
	public String getOrganizationHeader()
	{
		return orgHeaderText.getText();
	}	
}
