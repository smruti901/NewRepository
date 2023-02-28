package org.tyss.genericUtility;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.tyss.objectRepository.CommonPage;
import org.tyss.objectRepository.CreateCampaignsPage;
import org.tyss.objectRepository.CreateContactsPage;
import org.tyss.objectRepository.CreateDocumentPage;
import org.tyss.objectRepository.CreateProductsPage;

public class BaseClass extends InstanceClass{
	
	public static WebDriver listenerdriver;
	//@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void classSetup() throws MalformedURLException {

		
		//Creating objects for GenericUtility
		fileutility= new FileUtility();
		excelutility = new ExcelUtility();
		javautility= new JavaUtility();
		webdriverutility= new WebdriverUtility();

		//Initialize data from Property file
		fileutility.initializethePropertyFile(IpathConstants.VTIGERPROPERTYFILEPATH);



		//Get the control for particular sheet in excel
		excelutility.initializeExcelFile(IpathConstants.VTIGEREXELFILEPATH);

		//Fetch the data from Property file
		browser=fileutility.getDataFromProperty("browser");
		url=fileutility.getDataFromProperty("url");
		username=fileutility.getDataFromProperty("username");
		password=fileutility.getDataFromProperty("password");
		timeout=fileutility.getDataFromProperty("timeout");

		//covert string to long
		time=javautility.convertStringToLong(timeout);

		//run time polymorphism
		driver=webdriverutility.setupDriver(browser);
		ThreadSafeClass.setDriver(driver);
		//listenerdriver=driver;

		//pre-setting for browser
		webdriverutility.maximizebrowser();
		webdriverutility.implicitwait(time);


		//login to the app
		commonPage= new CommonPage(driver);
		createCampaignsPage = new CreateCampaignsPage(driver);
		createContactsPage= new CreateContactsPage(driver);
		createDocumentPage= new CreateDocumentPage(driver);
		createProductsPage= new CreateProductsPage(driver);


		//creating object for Actions class
		webdriverutility.initializeActions();

		//navigate the application
		webdriverutility.openApplication(url);

	}

	@BeforeMethod(alwaysRun = true)
	public void randomSetup()
	{
		//Generate the random number
		randomNumber= javautility.getRandomNumber();

		commonPage.Login(username, password);
	}

	@AfterMethod(alwaysRun = true)
	public void methodTearDown()
	{
		//Closing the workbook and driver
		commonPage.Logout(webdriverutility);
	}

	@AfterClass(alwaysRun = true)
	public void classTearDown()
	{

		excelutility.workbookclose();
		webdriverutility.closeBrowser();
	}
}
