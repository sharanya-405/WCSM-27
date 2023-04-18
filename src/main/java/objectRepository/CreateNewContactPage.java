package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger_GenericUtilities.WebdriverUtility;

public class CreateNewContactPage extends WebdriverUtility{
  //Step1:-Decleration
	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img[@alt='Select']")
	private WebElement orgLookUpImg;
	
	@FindBy(name="search_text")
	private WebElement orgNameSearchEdt;
	
	@FindBy(name="search")
	private WebElement orgSearchBtn;
	
	//Step2:-Initialization
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//Step3:-Utilization
	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getOrgLookUpImg() {
		return orgLookUpImg;
	}

	public WebElement getOrgSearchEdt() {
		return orgNameSearchEdt;
	}

	public WebElement getOrgSearchBtn() {
		return orgSearchBtn;
	}
	
	//Step4:-Business Library
	/**
	 * This method will create new contact with mandatory data
	 * @param LASTNAME
	 */
	public void createNewContact(String LASTNAME)
	{
		lastNameEdt.sendKeys(LASTNAME);
		saveBtn.click();
	}
	
	public void createNewContact(WebDriver driver,String LASTNAME,String ORGNAME)
	{
		lastNameEdt.sendKeys(LASTNAME);
		orgLookUpImg.click();
		switchToWindow(driver,"Accounts");
		orgNameSearchEdt.sendKeys(ORGNAME);
		orgSearchBtn.click();
		driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click();    //or we can give xpath("//a[text()='"+ORGNAME+"'])
		switchToWindow(driver,"Contacts");
		saveBtn.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
