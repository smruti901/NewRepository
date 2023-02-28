package org.tyss.Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.tyss.genericUtility.ExcelUtility;
import org.tyss.genericUtility.IpathConstants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartSenario  {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		driver.findElement(By.name("q")).sendKeys("winter heater",Keys.ENTER);
		driver.findElement(By.xpath("//div[@class=\"_1TmfNK\"][1]")).click();
		String actualProduct = driver.findElement(By.xpath("//a[contains(@title,'DARSHANAM ')]")).getAttribute("title");
		System.out.println(actualProduct);
		driver.findElement(By.xpath("//a[text()='DARSHANAM WORLD 220v 500w Portable Electric Heater Mini...']")).click();
		String pid = driver.getWindowHandle();
		Set<String> cid = driver.getWindowHandles();
		for(String id:cid) {
			if(!pid.equals(id)) {
				driver.switchTo().window(id);
			}
			
		}
		driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
		String expectedProduct = driver.findElement(By.xpath("//a[@class=\"_2Kn22P gBNbID\"]")).getText();
		System.out.println(expectedProduct);
		Assert.assertEquals(expectedProduct, actualProduct);
		
	}

}


