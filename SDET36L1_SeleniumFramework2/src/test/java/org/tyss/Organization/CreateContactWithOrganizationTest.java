package org.tyss.Organization;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.tyss.genericUtility.BaseClass;
import org.tyss.genericUtility.IpathConstants;
import org.tyss.objectRepository.CreateOrganizationsPage;

public class CreateContactWithOrganizationTest extends BaseClass {
	
	@Test
	public void createContactwithOrganizationTest(){
		// TODO Auto-generated method stub
		
		//Fetch the data from excel sheet
		String expectedOrganizationName = excelutility.getDataFromExcel("Organizations", 2, 1)+randomNumber;
		
		String expectedContactName = excelutility.getDataFromExcel("Contacts", 2, 1)+randomNumber;
				
		//login to the app
		CreateOrganizationsPage createOrganizationsPage= new CreateOrganizationsPage(driver);
		createOrganizationsPage.createOrganization(expectedOrganizationName);
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[contains(text(),'Updated today')]")));
		
		createContactsPage.createCampaigns(webdriverutility, expectedContactName);
		driver.findElement(By.xpath("//img[@language='javascript']/../../../tr[5]/td[2]/img[@title='Select']")).click();

		//Changing the driver focus to new window
		String pid=driver.getWindowHandle();
		Set<String>cid=driver.getWindowHandles();
		for(String i:cid)
		{
			if(!pid.equals(i))
			{
				driver.switchTo().window(i);
			}
		}
		driver.findElement(By.id("search_txt")).sendKeys(expectedOrganizationName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(expectedOrganizationName)).click();

		//Changing the driver focus to parent window
		driver.switchTo().window(pid);
		driver.findElement(By.xpath("//input[@accesskey='S']")).click();
		String actualLastName=driver.findElement(By.id("dtlview_Last Name")).getText();
		String actualOrganizationName=driver.findElement(By.linkText(expectedOrganizationName)).getText();

		//Validating the data
		if(actualLastName.equals(expectedContactName) && actualOrganizationName.equals(expectedOrganizationName) )
		{
			
			javautility.printStatement("LastName and Organisation created successfully");
			javautility.printStatement("Actual LastName name==>"+actualLastName);
			excelutility.setDataIntoExcel("Organizations", 2, 4,"Pass");
			excelutility.setDataIntoExcel("Contacts", 2, 4,"Pass");
			excelutility.provideDataToExcelPass(IpathConstants.VTIGEREXELFILEPATH);

		}
		else
		{
			
			javautility.printStatement("LastName and Organisation not created successfully");
			excelutility.setDataIntoExcel("Organizations", 2, 4,"Fail");
			excelutility.setDataIntoExcel("Contacts", 2, 4,"Fail");
			excelutility.provideDataToExcelPass(IpathConstants.VTIGEREXELFILEPATH);
			
		}

		
	}
}
