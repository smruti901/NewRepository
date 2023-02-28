package Pakages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewPom {
	WebDriver driver;
	/**
	 * This constructor is used to initialize elements everytime
	 * @param driver
	 */
	
	public NewPom(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	private String anyshow="1";
	private String s="Latest & Trending";
	@FindBy(xpath = "//a[text()='Movies Recommended For You']/../../../div[2]/div/div/div/div[1]/div/div/div/article/a") private WebElement filepath;
	//private String dynamicXpath = ("//a[text()='"+s+"']/../../../div[2]/div/div/div/div["+anyshow+"]/div/div/div/article/a");
//	private String dynamicXpath1=("//a[text()='"+s+"']/../../../div[2]/div/div/div/div");
//	private String dynamicXpath2=("//a[text()='"+s+"']/../../../div[2]/div/div/div/div/div/div/div/article/a");
//
//	/*
//	public void screenshot(List<WebElement> i,JavaUtility javaUtility) throws InterruptedException
//	{
//		i=web;
//		Iterator<WebElement> itr = i.iterator();
//		while(itr.hasNext())
//		{
//			Thread.sleep(2000);
//			TakesScreenshot ts= (TakesScreenshot)itr.next();
//			File src = ts.getScreenshotAs(OutputType.FILE);
//			File trg= new File("./screenshot/"+"_"+javaUtility.getCurrentDate("HH_mm_ss")+".png");
//			try {
//				FileUtils.copyFile(src, trg);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//		}
//
//
//	}
//*/
//	
	public void convertStringToWebelement()
	{
		filepath.findElement(By.xpath("//a[text()='"+s+"']/../../../div[2]/div/div/div/div["+anyshow+"]/div/div/div/article/a")).click();
	}
//	
//	public void dynamicXpathnew(String replacedata)
//	{
//		  convertStringToWebelement(dynamicXpath, replacedata).click();
//	}
//	
//	public List<WebElement> convertStringToListofWebelement1(String dynxpath1, String replacedata)
//	{
//		String xpath = String.format(dynxpath1, s);
//		return driver.findElements(By.xpath(xpath));
//	}
//	
//	List<WebElement> wb;
//	JavaUtility javaUtility;
//	public List<WebElement> dynamicXpathnew1(String s1)
//	{
//		return convertStringToListofWebelement1(dynamicXpath1, s);
//	}
//	public List<WebElement> dynamicXpathnew2(String s1)
//	{
//		 wb = convertStringToListofWebelement1(dynamicXpath2, s);
//		 return convertStringToListofWebelement1(dynamicXpath2, s);
//	}
//	
//	
//		public void screenshotwithforeach(Object currentclass,String s1) throws InterruptedException {
//
//
//				for(WebElement r:wb) {
//					Thread.sleep(2000);
//					TakesScreenshot ts= (TakesScreenshot)r;
//					File src = ts.getScreenshotAs(OutputType.FILE);
//					File trg= new File("./screenshot/"+currentclass.getClass().getSimpleName()+"_"+javaUtility.getCurrentDate("HH_mm_ss")+".png");
//					try {
//						FileUtils.copyFile(src, trg);
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//
//					String s= r.getText();
//					System.out.println(s);
//
//				}
		}
		