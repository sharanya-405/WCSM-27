package Vtiger.organization.tests;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
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

public class CreateOrganizationWithMultipleDataTest extends BaseClass {
	
	@Test(dataProvider="OrgWithIndustry",groups="SmokeSuite")
	public void createOrgWithIndustryTest(String ORG,String INDUSTRY) throws IOException
	{
	  
      String ORGNAME=ORG+jUtil.getrandomNumber();
  
       //Step1:-Navigate to the Organizations link
       HomePage hp=new HomePage(driver);
       hp.clickOnOrganizationsLink();
       
       //Step2:-Click on create new Organization
       OrganizationsPage op=new OrganizationsPage(driver);
       op.clickOnCreateOrganizationLookUpImg();
       
       //Step3:-Create organization with mandatory fields
       CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
       cnop.createNewOrganization(ORGNAME,INDUSTRY);
       
       //Step4:-Validate whether the organization created or not
       OrganizationInfoPage oip=new OrganizationInfoPage(driver);
       String orgHeader=oip.getOrganizationHeader();
       Assert.assertTrue(orgHeader.contains(ORGNAME));
       System.out.println("organization with industry created successfully");
	}

@DataProvider(name="OrgWithIndustry")
public Object[][] getData() throws EncryptedDocumentException, IOException
{
	Object[][] data=eUtil.readDataFromExcelToDataProvider("DataProviderOrg");
	return data;
}
}



















