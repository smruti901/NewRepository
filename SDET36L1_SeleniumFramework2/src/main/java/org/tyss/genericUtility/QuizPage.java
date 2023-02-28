package org.tyss.genericUtility;

public class QuizPage {

	//private WebDriver driver;
//	
//	@FindBy(xpath="//li/a[.='Remove Quiz']")
//	private WebElement removeQuizButton;
//	private String expectedQuizName="Java Program";
//	private String dynamicXpath=("//td[contains(text(),'"+expectedQuizName+"')]/ancestor::tr//a[@class='pull-right btn sub1']");
////private String dynamicXpath=("//td[.='%s']/ancestor::tr//a[@class='pull-right btn sub1']");
//	
//	@FindBy(xpath = "//table/tbody/tr/td[2]")
//	private List<WebElement> topicList;
//	
//	public QuizPage(WebDriver driver)
//	{
//		this.driver = driver;
//		PageFactory.initElements( driver,this);
//	}
//	
//
//	public WebElement convertStringToWebElement(String elementdynamicXpath,String replaceData)
//	{
//		String xpath=String.format(elementdynamicXpath,replaceData);
//		return driver.findElement(By.xpath(xpath));
//	}
//	
//	
//	public void deleteAction(String replaceData)
//	{
//		convertStringToWebElement(dynamicXpath,replaceData).click();
//	}
//	
//	
//
//	public List<String> getAllQuizNames()
//	{
//		List<String> QuizName = new ArrayList();
//		for (WebElement userName : topicList)
//		{
//			QuizName.add(userName.getText());
//		}
//		return QuizName;
//	}

}