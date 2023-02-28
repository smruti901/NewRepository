package org.tyss.Practice;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Practice.Baseclass;

public class Flipkart extends Baseclass {
	
	@Test(groups={"system"})
	public void Flipkartdemo()
	{
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		driver.findElement(By.xpath("//input[@class=\"_3704LK\"]")).sendKeys("iphone x",Keys.ENTER);
		String s = driver.findElement(By.xpath("//div[@class=\"_1YokD2 _3Mn1Gg\"]/div[2]/div/div/div/a/div[2]/div[1]/div[1]")).getText();
		//System.out.println(s);
		List<WebElement> s1 = driver.findElements(By.xpath("//div[@class=\"_13oc-S\"]/div/div/a/div[2]/div[1]/div[1]"));
		List<WebElement> str1 = driver.findElements(By.xpath("//div[@class=\"_13oc-S\"]/div/div/a/div[2]/div/following-sibling::div/div[1]/div[1]/div[1]"));
		Iterator<WebElement> phoneName = s1.iterator();
		Iterator<WebElement> phonePrice = str1.iterator();
		while(phoneName.hasNext() && phonePrice.hasNext()) {
			System.out.println(phoneName.next().getText()+"===>"+phonePrice.next().getText());
		}
	
		//String str = driver.findElement(By.xpath("//div[@data-id=\"MOBEXRGVVTMF9FYV\"]/div/a/div[2]/div[2]/div[1]/div[1]")).getText();
		//System.out.println(str);
		//System.out.println(s+" "+str);
	}

}
