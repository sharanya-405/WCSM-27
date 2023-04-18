package Vtiger.contacts.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import objectRepository.ContactsInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import vTiger_GenericUtilities.BaseClass;

public class CreateContactTest extends BaseClass{
 
	@Test
	public void createContact() throws Exception
	{
		String LASTNAME=eUtil.getDataFromExcel("Contact", 1, 2)+jUtil.getrandomNumber();
		//Step1:-Navigate to contact link
		HomePage hp=new HomePage(driver);
		hp.clickOnContactsLink();
		
		//Step2:-click on create contact lookup image
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreateContactLokUpImg();
		//Assert.fail();
		//Step3:-Provide necessary data to the mandatory fields
		CreateNewContactPage cncp=new CreateNewContactPage(driver);
		cncp.createNewContact(LASTNAME);
		
		//Step4:-Validate whether the contact is created or not
		ContactsInfoPage cip=new ContactsInfoPage(driver);
		String contactHeader=cip.getContactHeader();
		Assert.assertTrue(contactHeader.contains(LASTNAME));
	    System.out.println("contact crated successful");		
	}
}
