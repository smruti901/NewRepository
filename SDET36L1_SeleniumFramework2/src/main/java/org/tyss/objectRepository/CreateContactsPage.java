package org.tyss.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyss.genericUtility.ThreadSafeClass;
import org.tyss.genericUtility.WebdriverUtility;

public class CreateContactsPage {

	WebDriver driver;
	/**
	 * This constructor is used to initialize elements everytime
	 * @param driver
	 */
	public CreateContactsPage(RemoteWebDriver driver) {
		
		PageFactory.initElements(ThreadSafeClass.getDriver(), this);
	}


	@FindBy(xpath = "//a[text()='Contacts']") private WebElement contactTab;
	@FindBy(xpath = "//img[@title=\"Create Contact...\"]") private WebElement createContact;
	@FindBy(name = "lastname") private WebElement provideContactName;
	@FindBy(xpath = "//input[@onclick=\"this.form.action.value='Save'; displaydeleted(); return formValidate() \"]") private WebElement saveBtn;
	@FindBy(xpath = "//span[@id='dtlview_Last Name']") private WebElement validateText;

	//business library
	public void createCampaigns(WebdriverUtility webdriverUtility, String contactName)
	{
		
		contactTab.click();
		createContact.click();
		provideContactName.sendKeys(contactName);
		
		
	} 
	
	public void saveButton() {
		saveBtn.click();
	}
	
	public String validate()
	{
		return validateText.getText();
	}



}
