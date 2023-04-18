package Vtiger.contacts.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.ContactsInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrganizationInfoPage;
import objectRepository.OrganizationsPage;
import vTiger_GenericUtilities.BaseClass;
import vTiger_GenericUtilities.ExcelUtility;
import vTiger_GenericUtilities.JavaUtility;
import vTiger_GenericUtilities.Propertyutility;
import vTiger_GenericUtilities.WebdriverUtility;

public class CreateContactWithOrganizationTest extends BaseClass {	
			@Test(groups="SmokeSuite")
			public void ContactWithOrgTest() throws Exception
			{
				String LASTNAME = eUtil.getDataFromExcel("Contact", 4, 2);
				String ORGNAME = eUtil.getDataFromExcel("Contact", 4, 3)+jUtil.getrandomNumber();

				// Step 1: Navigate to Organizations link
				HomePage hp=new HomePage(driver);
				hp.clickOnOrganizationsLink();

				// Step 2: Click on Create Organization Look up Image
				OrganizationsPage op=new OrganizationsPage(driver);
				op.clickOnCreateOrganizationLookUpImg();				

				// Step 3: Create organization with mandatory Fields
				CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
				cnop.createNewOrganization(ORGNAME);

				// Step 4: Validate for Organization
				OrganizationInfoPage oip=new OrganizationInfoPage(driver);
				String OrgHeader=oip.getOrganizationHeader();
				Assert.assertTrue(OrgHeader.contains(ORGNAME));
				
				// Step 5: Navigate Contacts Link
				  hp.clickOnContactsLink();
				
				// Step 6: Click on create Contact Look Up Image
				  ContactsPage cp=new ContactsPage(driver);
				  cp.clickOnCreateContactLokUpImg();

				// Step 7: Create new contact
				 CreateNewContactPage cncp=new CreateNewContactPage(driver);
				 cncp.createNewContact(driver,LASTNAME,ORGNAME);

				// Step 8: Validate for Organization
				 ContactsInfoPage cip=new ContactsInfoPage(driver);
				 String ContactHeader= cip.getContactHeader();
				 Assert.assertTrue(ContactHeader.contains(LASTNAME));	
				 System.out.println("contact with organization created successfully");
			}
			
			@Test
			public void sampleTest()
			{
				System.out.println("sampleTest executed");
			}
		}


