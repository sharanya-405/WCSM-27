package Vtiger.organization.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
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
//@Listeners(vTiger_GenericUtilities.ListnersImplementation.class)
public class CreateOrganizationTest extends BaseClass{
    @Test(groups="SmokeSuite")
    public void CreateOrgTest() throws Exception
    {
    	String ORGNAME=eUtil.getDataFromExcel("Organizatio",1,2)+jUtil.getrandomNumber();
   
			//Step 1: Navigate to Organizations link
			HomePage hp=new HomePage(driver);
			hp.clickOnOrganizationsLink();
			
			//Step 2: Click on Create Organization Look up Image
			OrganizationsPage op=new OrganizationsPage(driver);
			op.clickOnCreateOrganizationLookUpImg();
			
			//Step 3: Create organization with mandatory Fields
			CreateNewOrganizationPage cop=new CreateNewOrganizationPage(driver);
			cop.createNewOrganization(ORGNAME);
			
			//Step 4: Validate for Organization
			OrganizationInfoPage oip=new OrganizationInfoPage(driver);
			String OrgHeader =oip.getOrganizationHeader();
			Assert.assertTrue(OrgHeader.contains(ORGNAME));	
			System.out.println("organization created successfully");
    }
    @Test
    public void another()
    {
    	System.out.println("another test executed");
    }
}























