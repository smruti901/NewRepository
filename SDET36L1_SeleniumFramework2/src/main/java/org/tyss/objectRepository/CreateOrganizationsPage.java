package org.tyss.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyss.genericUtility.ThreadSafeClass;
import org.tyss.genericUtility.WebdriverUtility;

public class CreateOrganizationsPage {
	
	/**
	 * This constructor is used to initialize elements everytime
	 * @param driver
	 */
	public CreateOrganizationsPage(RemoteWebDriver driver) {
		
		PageFactory.initElements(ThreadSafeClass.getDriver(), this);
	}
	
	@FindBy(xpath = "//a[text()='Organizations']") private WebElement organizationTab;
	@FindBy(xpath = "//img[@alt=\"Create Organization...\"]") private WebElement createOrganization;
	@FindBy(name = "accountname") private WebElement provideOrganizationName;
	@FindBy(xpath = "//input[@accesskey='S']") private WebElement saveBtn;
	
	@FindBy(xpath = "//td[@class=\"moduleName\"]") private WebElement locator;
	
	
	@FindBy(xpath = "//span[@id='dtlview_Organization Name']") private WebElement validateText;
	
	
	//business library
	
	public void createOrganization(String organiztaion) {
		organizationTab.click();
		createOrganization.click();
		provideOrganizationName.sendKeys(organiztaion);
		saveBtn.click();
	}
	
	public void explicitwait(WebdriverUtility webdriverUtility) {
		webdriverUtility.explicitwait(locator, 10);
	}
	
	public String validateOrganiztionName() {
		return validateText.getText();
	}
	
	
	

}
