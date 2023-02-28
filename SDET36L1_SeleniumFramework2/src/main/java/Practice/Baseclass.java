package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	public WebDriver driver;
	@Parameters("browser")
@BeforeClass(alwaysRun=true)
public void launchbrowser(String browser)
{
	if(browser.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
	}
	else if (browser.equals("edge")){
		WebDriverManager.edgedriver().setup();
		driver= new EdgeDriver();
	}
	else {
		System.out.println("Enter valid browser");
	}
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 driver.manage().window().maximize();
	

}
@BeforeMethod(alwaysRun=true)
public void loginapplication()
{

}
@AfterMethod(alwaysRun=true)
public void logoutapplication()
{
	
}
@AfterClass(alwaysRun=true)
public void closebrowser()
{
	driver.close();
}

}
