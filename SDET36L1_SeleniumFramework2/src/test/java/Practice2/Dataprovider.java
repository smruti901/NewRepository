package Practice2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Practice.Baseclass2;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Dataprovider  {
	@Test(dataProvider="dataSupplier")
	public void demo(String username, String password)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://demo.actitime.com/login.do");
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.name("pwd")).sendKeys(password,Keys.ENTER);
		String text = driver.findElement(By.xpath("//div[text()='Tasks']")).getText();
		
		Assert.assertEquals(text, "Tasks");
		driver.findElement(By.xpath("//div[text()='Tasks']")).click();
		
		driver.findElement(By.xpath("//a[text()='Logout']")).click();

}
	@DataProvider
	public Object[][] dataSupplier() {
		Object[][] objarr = new Object [3][2];
		objarr[0][0]="admin1";
		objarr[0][1]="manager1";
		objarr[1][0]="admin2";
		objarr[1][1]="manager2";
		objarr[2][0]="admin";
		objarr[2][1]="manager";
		
		return objarr;
		
		
	}

}
