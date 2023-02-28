package org.tyss.Campaign;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.tyss.genericUtility.BaseClass;
import org.tyss.genericUtility.JavaUtility;
//@Listeners(org.tyss.genericUtility.ListenerImplementation.class)
public class CreateCampaignsTest extends BaseClass{
	@Test
	public void createCampaignsTest() {

		// TODO Auto-generated method stub
		
		//Fetch the data from excel sheet
		String expectedCampaignName = excelutility.getDataFromExcel("Campaigns", 2, 1)+randomNumber;
		String actualCampaignName=createCampaignsPage.createCampaigns(webdriverutility, expectedCampaignName);
		
		//validate the data
		if(actualCampaignName.equals(expectedCampaignName))
		{
			JavaUtility java= new JavaUtility();
			java.printStatement("Campaign created successfully----> TC is Pass");
			excelutility.setDataIntoExcel("Campaigns",2,4, "Pass");
		}
		else
		{
			JavaUtility java= new JavaUtility();
			java.printStatement("Campaign not created successfully----> TC is Fail");
			excelutility.setDataIntoExcel("Campaigns",2,4, "Fail");
		}
	}
}
