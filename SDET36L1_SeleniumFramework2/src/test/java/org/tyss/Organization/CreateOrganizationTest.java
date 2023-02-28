package org.tyss.Organization;

import org.testng.annotations.Test;
import org.tyss.genericUtility.BaseClass;
import org.tyss.genericUtility.IpathConstants;
import org.tyss.objectRepository.CreateOrganizationsPage;

public class CreateOrganizationTest extends BaseClass {
	@Test
	public void createOrganizationTest() {
		// TODO Auto-generated method stub

		//Fetch the data from excel sheet
		String expectedOrganizationName = excelutility.getDataFromExcel("Organizations", 2, 1)+randomNumber;
		javautility.printStatement(expectedOrganizationName);

		//login to the app
		CreateOrganizationsPage createOrganizationsPage= new CreateOrganizationsPage(driver);
		createOrganizationsPage.createOrganization(expectedOrganizationName);
		createOrganizationsPage.explicitwait(webdriverutility);
		String actualOrganizationName=createOrganizationsPage.validateOrganiztionName();

		String sheetname="Organizations";

		//validate the data
		if(actualOrganizationName.equals(expectedOrganizationName))
		{
			
			javautility.printStatement("Organization created successfully----> TC is Pass");
			javautility.printStatement("Actual organization name==>"+actualOrganizationName);
			excelutility.setDataIntoExcel(sheetname, 2, 4,"Pass");
			excelutility.provideDataToExcelPass(IpathConstants.VTIGEREXELFILEPATH);

		}
		else
		{
			
			javautility.printStatement("Organisation not created successfully----> TC is Fail");
			excelutility.setDataIntoExcel(sheetname, 2, 4,"Fail");
			excelutility.provideDataToExcelPass(IpathConstants.VTIGEREXELFILEPATH);

		}

	}
}
