package org.tyss.Practice;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class createcustomer {
	@Test
	public void createCustomer() throws IOException {
		datautility du = new datautility();
		Random r = new Random();
		int num = r.nextInt(10000);
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(du.getDatafromProperties("url"));
		driver.findElement(By.name("q")).sendKeys(du.getDatafromExcel("Sheet1", 1, 1),Keys.ENTER);
		
	}

}
