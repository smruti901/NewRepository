package org.tyss.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyss.genericUtility.ThreadSafeClass;
import org.tyss.genericUtility.WebdriverUtility;

public class CommonPage {
	/**
	 * This constructor is used to initialize elements everytime
	 * @param driver
	 */
	public CommonPage(RemoteWebDriver driver) {
		
		PageFactory.initElements(ThreadSafeClass.getDriver(), this);
	}
	
	@FindBy(name =  "user_name") private WebElement vtigerUsername;
	@FindBy(name = "user_password") private WebElement vtigerPassword;
	@FindBy(id = "submitButton") private WebElement submitBtn;
	
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']") private WebElement administratorIcon;
	@FindBy(xpath = "//a[text()='Sign Out']") private WebElement logout;
	
	WebDriver driver;
	//business library
	/**
	 * This method is used to perform login action
	 * @param email
	 * @param password
	 * @return 
	 */
	public void Login(String username, String password) {
		vtigerUsername.sendKeys(username);
		vtigerPassword.sendKeys(password);
		submitBtn.click();
		
	}
		
	/**
	 * This method is used to perform logout action
	 */
	public void Logout(WebdriverUtility webdriverUtility)
	{
		webdriverUtility.mouseOverElement(administratorIcon);
		logout.click();
		
	}
	
	

}
