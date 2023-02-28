package org.tyss.Contact;

import org.testng.annotations.Test;
import org.tyss.genericUtility.BaseClass;
import org.tyss.genericUtility.JavaUtility;

public class CreateContactsTest extends BaseClass{
	@Test
	public void createContactTest() {
		//Fetch the data from excel sheet
		String expectedContactName = excelutility.getDataFromExcel("Contacts", 2, 1)+randomNumber;
		createContactsPage.createCampaigns(webdriverutility, expectedContactName);
		createContactsPage.saveButton();
		
		String actualLastName=createContactsPage.validate();

		//validate the data
		if(actualLastName.equals(expectedContactName))
		{
			JavaUtility java= new JavaUtility();
			java.printStatement("Contacts created successfully----> TC is Pass");
			excelutility.setDataIntoExcel("Contacts",2,4, "Pass");

		}
		else
		{
			JavaUtility java= new JavaUtility();
			java.printStatement("Contacts not created successfully----> TC is Fail");
			excelutility.setDataIntoExcel("Contacts",2,4, "Fail");
		}




	}
}
