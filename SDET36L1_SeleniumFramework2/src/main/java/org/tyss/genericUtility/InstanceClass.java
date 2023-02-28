package org.tyss.genericUtility;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.tyss.objectRepository.CommonPage;
import org.tyss.objectRepository.CreateCampaignsPage;
import org.tyss.objectRepository.CreateContactsPage;
import org.tyss.objectRepository.CreateDocumentPage;
import org.tyss.objectRepository.CreateProductsPage;

public class InstanceClass {
	public WebdriverUtility webdriverutility;
	public FileUtility fileutility;
	public ExcelUtility excelutility;
	public JavaUtility javautility;
	public String browser;
	public String url;
	public String username;
	public String password;
	public String timeout;
	public int randomNumber;
	public long time;
	public CommonPage commonPage;
	public CreateCampaignsPage createCampaignsPage;
	public CreateContactsPage createContactsPage;
	public CreateDocumentPage createDocumentPage;
	public CreateProductsPage createProductsPage;
	public RemoteWebDriver driver;

}
