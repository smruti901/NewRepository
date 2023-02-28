package org.tyss.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyss.genericUtility.ThreadSafeClass;
import org.tyss.genericUtility.WebdriverUtility;

public class CreateDocumentPage {
	RemoteWebDriver driver;
	/**
	 * This constructor is used to initialize elements everytime
	 * @param driver
	 */
	public CreateDocumentPage(RemoteWebDriver driver) {
		
		PageFactory.initElements(ThreadSafeClass.getDriver(), this);
	}
	
	@FindBy(linkText = "Documents") private WebElement clickOnDocument;
	@FindBy(xpath = "//img[@title='Create Document...']") private WebElement createDocument;
	@FindBy(name = "notes_title") private WebElement titleName;	
	@FindBy(xpath = "//iframe") private WebElement frame;
	
	
	@FindBy(xpath = "//body[@class='cke_show_borders']") private WebElement enterDescription;
	@FindBy(id = "filename_I__") private WebElement giveFilePath;
	@FindBy(xpath = "//input[@accesskey='S']") private WebElement saveBtn;
	
	
	@FindBy(id = "dtlview_Title") private WebElement validatetitle;
	@FindBy(xpath = "//td[@class='dvtCellInfo']/p") private WebElement validatedescription;
	@FindBy(xpath = "//td[@class='dvtCellInfo']/a") private WebElement validatefile;
	
	
	//business library
	public void createDocument(String title,WebdriverUtility webdriverUtility ) {
		clickOnDocument.click();
		createDocument.click();
		titleName.sendKeys(title);
		webdriverUtility.switchFrame(frame);
		
		}
	
	public void enterDescriptionAndFilepath(String description,String filepath)
	{
		enterDescription.sendKeys(description);
		driver.switchTo().defaultContent();
		giveFilePath.sendKeys(filepath);
		saveBtn.click();
	}
	
	public String validateTitle()
	{
		return validatetitle.getText();
	}
	
	public String validateDescription()
	{
		return validatedescription.getText();
	}
	
	public String validateFile()
	{
		return validatefile.getText();
	}
	

}
