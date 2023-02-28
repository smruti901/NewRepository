package org.tyss.Products;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.tyss.genericUtility.ExcelUtility;
import org.tyss.genericUtility.FileUtility;
import org.tyss.genericUtility.IpathConstants;
import org.tyss.genericUtility.JavaUtility;
import org.tyss.genericUtility.WebdriverUtility;

public class CreateCampaignWithProductTest {

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
		String expectedCampaignName = excelutility.getDataFromExcel("Campaigns", 2, 1)+randomNumber;
		System.out.println(expectedCampaignName);
		String expectedProductName = excelutility.getDataFromExcel("Product", 2, 1)+randomNumber;
		System.out.println(expectedProductName);
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
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys(expectedProductName);
		driver.findElement(By.xpath("//input[@accesskey='S']")).click();

		//Creating object for WebDriverWait and Actions 
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[contains(text(),'Updated today')]")));
		WebElement more=driver.findElement(By.xpath("//a[text()='More']"));
		Actions act= new Actions(driver);
		act.moveToElement(more).perform();
		driver.findElement(By.xpath("//a[@name=\"Campaigns\"]")).click();
		driver.findElement(By.xpath("//img[@title=\"Create Campaign...\"]")).click();
		driver.findElement(By.name("campaignname")).sendKeys(expectedCampaignName);
		driver.findElement(By.xpath("//img[@language='javascript']/../../../tr[5]/td[4]/img[@title='Select']")).click();

		//Swithing the window
		String pid=driver.getWindowHandle();
		Set<String>cid=driver.getWindowHandles();
		Iterator<String> i = cid.iterator();
		while(i.hasNext())
		{
			String newWindow=i.next();
			driver.switchTo().window(newWindow);
		}


		driver.findElement(By.id("search_txt")).sendKeys(expectedCampaignName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(expectedProductName)).click();

		//Switching to Parent window
		driver.switchTo().window(pid);
		driver.findElement(By.xpath("//input[@accesskey='S']")).click();
		String actualCampaignName=driver.findElement(By.id("dtlview_Campaign Name")).getText();
		String actualProductName=driver.findElement(By.linkText(expectedProductName)).getText();

		//validate the data
		if(actualProductName.equals(expectedProductName) && actualCampaignName.equals(expectedCampaignName))
		{
			javautility.printStatement("Product and Campaign created successfully----> TC is Pass");
			javautility.printStatement("Actual Product name==>"+actualProductName);
			excelutility.setDataIntoExcel("Campaigns", 2, 4,"Pass");
			excelutility.setDataIntoExcel("Product", 2, 4,"Pass");
			excelutility.provideDataToExcelPass(IpathConstants.VTIGEREXELFILEPATH);
			
		}
		else
		{
			javautility.printStatement("Product and Campaign not created successfully----> TC is Pass");
			excelutility.setDataIntoExcel("Campaigns", 2, 4,"Fail");
			excelutility.setDataIntoExcel("Product", 2, 4,"Fail");
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
