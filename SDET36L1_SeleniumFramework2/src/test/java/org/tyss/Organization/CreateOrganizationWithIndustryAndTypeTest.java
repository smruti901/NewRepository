package org.tyss.Organization;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.tyss.genericUtility.ExcelUtility;
import org.tyss.genericUtility.FileUtility;
import org.tyss.genericUtility.IpathConstants;
import org.tyss.genericUtility.JavaUtility;
import org.tyss.genericUtility.WebdriverUtility;

public class CreateOrganizationWithIndustryAndTypeTest {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//Creating objects for GenericUtility
		FileUtility fileutility= new FileUtility();
		ExcelUtility excelutility = new ExcelUtility();
		JavaUtility javautility= new JavaUtility();
		WebdriverUtility webdriverutility= new WebdriverUtility();

		//Initialize data from Property file
		fileutility.initializethePropertyFile(IpathConstants.VTIGERPROPERTYFILEPATH);

		//Generate the random number
		int randomNumber= javautility.getRandomNumber();

		//Get the control for particular sheet in excel
		excelutility.initializeExcelFile(IpathConstants.VTIGEREXELFILEPATH);

		//Fetch the data from Property file
		String browser=fileutility.getDataFromProperty("browser");
		String url=fileutility.getDataFromProperty("url");
		String username=fileutility.getDataFromProperty("username");
		String password=fileutility.getDataFromProperty("password");
		String timeout=fileutility.getDataFromProperty("timeout");

		//Fetch the data from excel sheet
		String expectedOrganizationName = excelutility.getDataFromExcel("Organizations", 2, 1)+randomNumber;

		//run time polymorphism
		WebDriver driver=webdriverutility.setupDriver(browser);

		//pre-setting for browser
		webdriverutility.maximizebrowser();
		javautility.convertStringToLong(timeout);



		//creating object for Actions class
		webdriverutility.initializeActions();

		//navigate the application
		webdriverutility.openApplication(url);

		//login to the app
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@alt=\"Create Organization...\"]")).click();
		driver.findElement(By.name("accountname")).sendKeys(expectedOrganizationName);
		WebElement industryDropdown=driver.findElement(By.name("industry"));


		//Creating object for Actions and Select Class
		Select select=new Select(industryDropdown);
		select.selectByValue("Education");
		WebElement typeDropdown=driver.findElement(By.name("accounttype"));
		Select selecttype=new Select(typeDropdown);
		selecttype.selectByValue("Press");
		driver.findElement(By.name("assigntype")).click();
		driver.findElement(By.xpath("//input[@accesskey='S']")).click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[contains(text(),'Updated today')]")));
		String actualOrganizationName=driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
		String actualIndustry=driver.findElement(By.id("dtlview_Industry")).getText();
		String actualType=driver.findElement(By.id("dtlview_Type")).getText();

		//validate the data
		if(actualOrganizationName.equals(expectedOrganizationName) && actualIndustry.equals("Education") && actualType.equals("Press"))
		{
			javautility.printStatement("Organization,Industry and Type created successfully");
			javautility.printStatement("Actual organization name==>"+actualOrganizationName);
			excelutility.setDataIntoExcel("Organizations", 2, 4,"Pass");
			excelutility.provideDataToExcelPass(IpathConstants.VTIGEREXELFILEPATH);
			
		}
		else
		{
			javautility.printStatement("Organization,Industry and Type not created successfully");
			excelutility.setDataIntoExcel("Organizations", 2, 4,"Fail");
			excelutility.provideDataToExcelPass(IpathConstants.VTIGEREXELFILEPATH);
						
		}

		//Creation of object of Actions class , Close the workbook and  driver
		WebElement administratorIcon=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		webdriverutility.mouseOverElement(administratorIcon);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		excelutility.workbookclose();
		webdriverutility.closeBrowser();

	}
}
