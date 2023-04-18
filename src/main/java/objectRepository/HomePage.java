package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger_GenericUtilities.WebdriverUtility;

//Step1:-This POM class is for Home web page
public class HomePage extends WebdriverUtility{
 //Step2:-Initialize and store all the web elements on the home page by using selenium annotations
	
	@FindBy(xpath="//input[@name='query_string']")
	private WebElement searchEdt;
	
	@FindBy(xpath="//input[@class='searchBtn']")
	private WebElement searchBtn;
	
	@FindBy(xpath="//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement AdministratorImg;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signOutLnk;
	
	@FindBy(xpath="//a[text()='My Preferences']")
	private WebElement myPreferencesLnk;
	
	@FindBy(xpath="//a[text()='Help']")
	private WebElement helpLnk;
	
	@FindBy(xpath="//a[text()='Feedback']")
	private WebElement feedBackLnk;
	
	@FindBy(linkText="Calendar")
	private WebElement calenderLnk;
	
	@FindBy(linkText="Leads")
	private WebElement leadsLnk;
	
	@FindBy(linkText="Organizations")
	private WebElement organizationsLnk;
	
	@FindBy(linkText="Contacts")
	private WebElement contactsLnk;
	
	@FindBy(linkText="Opportunities")
	private WebElement oppertunitiesLnk;
	
	@FindBy(linkText="Products")
	private WebElement productsLnk;
	
	@FindBy(linkText="Documents")
	private WebElement documentsLnk;
	
	@FindBy(linkText="Email")
	private WebElement emailLnk;
	
	@FindBy(linkText="Trouble Tickets")
	private WebElement troubleTicketsLnk;
	
	@FindBy(linkText="Dashboard")
	private WebElement dashboardLnk;
	
	@FindBy(xpath="//a[text()='More']")
	private WebElement moreLnk;
	
	@FindBy(xpath="//a[text()=' Tools']")
	private WebElement toolsLnk;
	
	@FindBy(xpath="//a[@name='SMSNotifier']")
	private WebElement smsNotifyLnk;
	
	@FindBy(xpath="//a[@name='Our Sites']")
	private WebElement ourSitesLnk;
	
	@FindBy(xpath="//a[@name='Integration']")
	private WebElement integrationLnk;
	
	@FindBy(xpath="//a[@name='Mail Manager']")
	private WebElement mailMangerLnk;
	
	@FindBy(xpath="//a[@name='PBX Manager']")
	private WebElement pbxManagerLnk;
	
	@FindBy(xpath="//a[@name='Comments']")
	private WebElement commentsLnk;
	
	@FindBy(xpath="//a[@name='Recycle Bin']")
	private WebElement recycleBinLnk;
	
	@FindBy(xpath="//a[@name='RSS']")
	private WebElement rssLnk;
	
	@FindBy(xpath="//a[text()=' Analytics']")
	private WebElement analyticsLnk;
	
	@FindBy(xpath="//a[@name='Reports']")
	private WebElement reportsLnk;
	
	@FindBy(xpath="//a[text()=' Marketing']")
	private WebElement marketingLnk;
	
	@FindBy(xpath="//a[@name='Campaigns']")
	private WebElement campaignsLnk;
	
	@FindBy(xpath="//a[text()=' Support']")
	private WebElement supportLnk;
	
	@FindBy(xpath="//a[text()='Service Contracts']")
	private WebElement serviceContractsLnk;
	
	@FindBy(xpath="//a[text()='Project Milestones']")
	private WebElement projectMilestonesLnk;
	
	@FindBy(xpath="//a[text()='Project Tasks']")
	private WebElement projectTasksLnk;
	
	@FindBy(xpath="//a[text()='Projects']")
	private WebElement projectsLnk;
	
	@FindBy(xpath="//a[text()='FAQ']")
	private WebElement faqLnk;
	
	@FindBy(xpath="//a[text()=' Inventory']")
	private WebElement inventoryLnk;
	
	@FindBy(xpath="//a[text()='Services']")
	private WebElement servicesLnk;
	
	@FindBy(xpath="//a[text()='Assets']")
	private WebElement assetsLnk;
	
	@FindBy(xpath="//a[text()='Purchase Order']")
	private WebElement purchaseOrderLnk;
	
	@FindBy(xpath="//a[text()='Price Books']")
	private WebElement priceBooksLnk;
	
	@FindBy(xpath="//a[text()='Vendors']")
	private WebElement vendorsLnk;
	
	@FindBy(xpath="//a[text()=' Sales']")
	private WebElement salesLnk;
	
	@FindBy(xpath="//a[text()='Invoice']")
	private WebElement invoiceLnk;
	
	@FindBy(xpath="//a[text()='Sales Order']")
	private WebElement salesOrderLnk;
	
	@FindBy(xpath="//a[@name='Quotes']")
	private WebElement quotesLnk;
	
	//Step3:-Initialize all these elements with constructor
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
    
	//Step4:-provide getters to access these elements
	public WebElement getAdministratorImg() {
		return AdministratorImg;
	}

	public WebElement getSignOutLnk() {
		return signOutLnk;
	}

	public WebElement getOrgnizationsLnk() {
		return organizationsLnk;
	}

	public WebElement getContactsLnk() {
		return contactsLnk;
	}

	public WebElement getOppertunitiesLnk() {
		return oppertunitiesLnk;
	}

	public WebElement getProductsLnk() {
		return productsLnk;
	}
	
	//Step5:-Business library
	/**
	 * This method will click on organizations link
	 */
	public void clickOnOrganizationsLink()
	{
	   organizationsLnk.click();	
	}
     
	/**
	 * This method will click on contacts link
	 */
	public void clickOnContactsLink()
	{
		contactsLnk.click();
	}
	
	/**
	 * This method will perform signOut operation on web page
	 * @param driver
	 */
	public void logOutApp(WebDriver driver)
	{
		mouseHoverAction(driver,AdministratorImg);
		signOutLnk.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
