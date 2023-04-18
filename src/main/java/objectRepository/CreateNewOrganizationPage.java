package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger_GenericUtilities.WebdriverUtility;

public class CreateNewOrganizationPage extends WebdriverUtility{
  //Step1:-decleration
	@FindBy(name="accountname")
	private WebElement orgNameEdt;
	
	@FindBy(name="industry")
	private WebElement industryDropDown;
		
	@FindBy(name="accounttype")
	private WebElement typeDropDown;
	
	@FindBy(xpath="//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveBtn;

	//Step2:-initialization
	public  CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
    //Step3:-Utilization
	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}
	
	public WebElement getTypeDropDown() {
		return typeDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Step4:-Business library
	/**
	 * This method will create organization with mandatory information
	 * @param ORGNAME
	 */
	public void createNewOrganization(String ORGNAME)
	{
		orgNameEdt.sendKeys(ORGNAME);
		saveBtn.click();
	}
	
	public void createNewOrganization(String ORGNAME,String INDUSTRY)
	{
		orgNameEdt.sendKeys(ORGNAME);
		handleDropdown(industryDropDown,INDUSTRY);
		saveBtn.click();		
	}
	
	public void createNewOrganization(String ORGNAME,String INDUSTRY,String TYPE)
	{
		orgNameEdt.sendKeys(ORGNAME);
		handleDropdown(industryDropDown,INDUSTRY);
		handleDropdown(typeDropDown,TYPE);
		saveBtn.click();
	}
}















