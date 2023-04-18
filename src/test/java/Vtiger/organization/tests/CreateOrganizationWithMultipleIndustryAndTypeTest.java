package Vtiger.organization.tests;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import objectRepository.CreateNewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.OrganizationInfoPage;
import objectRepository.OrganizationsPage;
import vTiger_GenericUtilities.BaseClass;

public class CreateOrganizationWithMultipleIndustryAndTypeTest extends BaseClass{
	
	@Test(dataProvider="OrgWithIndustryAndType",groups="SmokeSuite")
	public void createOrgIndTypeTest(String ORG,String INDUSTRY,String TYPE)
	{
		String ORGNAME=ORG+jUtil.getrandomNumber();
		//Step1:-Navigate to Organizations link
		HomePage hp=new HomePage(driver);
		hp.clickOnOrganizationsLink();
		
		//Step2:-Click on create new Organization look up image
		OrganizationsPage op=new OrganizationsPage(driver);
		op.clickOnCreateOrganizationLookUpImg();
		
		//Step3:-Create organization with mandatory fields
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME,INDUSTRY,TYPE);
		
		//Step4:-Validate whether the organization is created or not
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String orgHeader=oip.getOrganizationHeader();
		Assert.assertTrue(orgHeader.contains(ORGNAME));
		System.out.println("organization with industry and type created successfully");
	}
  
	@DataProvider(name="OrgWithIndustryAndType")
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		Object[][] data=eUtil.readDataFromExcelToDataProvider("DataProviderOrgType");
		return data;
		
	}
}
