package org.tyss.Documents;

import org.testng.annotations.Test;
import org.tyss.genericUtility.BaseClass;

public class CreateDocumentTest extends BaseClass {
	@Test
	public void createDocumentTest(){
		// TODO Auto-generated method stub

		String sheetName="Title";
		//Fetch the data from excel sheet
		String expectedTitleName = excelutility.getDataFromExcel(sheetName, 2, 1)+randomNumber;
		String filePath = excelutility.getDataFromExcel(sheetName, 2, 5);
		String expectedFilePath=System.getProperty("user.dir")+filePath;
		String[] splitFilePath= expectedFilePath.split("/");
		String expectedFileName=splitFilePath[splitFilePath.length-1];
			

		//login to the app
		
		createDocumentPage.createDocument(expectedTitleName, webdriverutility);
	
		//Enter the value into Notes from excel 
		String expectedDescription = excelutility.getDataFromExcel(sheetName, 2, 4);
		createDocumentPage.enterDescriptionAndFilepath(expectedDescription, expectedFilePath);
		
		
		String actualTitleName=createDocumentPage.validateTitle();
		String actualDescription= createDocumentPage.validateDescription();
		String actualFileName= createDocumentPage.validateFile();
		

		//validate the data
		if(actualTitleName.equals(expectedTitleName) && actualDescription.equals(expectedDescription) && expectedFileName.equals(actualFileName))
		{

			javautility.printStatement("Title created successfully----> TC is Pass");
			excelutility.setDataIntoExcel(sheetName,2,4, "Pass");
		}
		else
		{
			javautility.printStatement("Title not created successfully----> TC is Pass");
			excelutility.setDataIntoExcel(sheetName,2,4, "Fail");

		}

	}
}
