package org.tyss.Products;


import org.testng.annotations.Test;
import org.tyss.genericUtility.BaseClass;
import org.tyss.genericUtility.IpathConstants;


public class CreateProductTest extends BaseClass {
	@Test
	public void createProductTest() {
		// TODO Auto-generated method stub

		
		//Fetch the data from excel sheet
		String expectedProductName = excelutility.getDataFromExcel("Product", 2, 1)+randomNumber;
				
		String actualProductName=createProductsPage.clickOnproduct(expectedProductName);

		//validate the data
		if(actualProductName.equals(expectedProductName))
		{
			javautility.printStatement("Product created successfully----> TC is Pass");
			javautility.printStatement("Actual product name==>"+actualProductName);
			excelutility.setDataIntoExcel("Product", 2, 4,"Pass");
			excelutility.provideDataToExcelPass(IpathConstants.VTIGEREXELFILEPATH);
		}
		else
		{
			javautility.printStatement("Product not created successfully----> TC is Fail");
			excelutility.setDataIntoExcel("Product", 2, 4,"Fail");
			excelutility.provideDataToExcelPass(IpathConstants.VTIGEREXELFILEPATH);
		}

		

	}
}
