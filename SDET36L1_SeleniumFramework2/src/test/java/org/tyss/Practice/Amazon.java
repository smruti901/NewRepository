package org.tyss.Practice;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Practice.Baseclass;

public class Amazon extends Baseclass {
	@Test(groups= {"smoke","system"})
	public void Amazondemo()
	{
		driver.get("https://www.amazon.in/");
	driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("iphone x",Keys.ENTER);
	List<WebElement> s1 = driver.findElements(By.xpath("//div[@class=\"a-section a-spacing-none puis-padding-right-small s-title-instructions-style\"]/h2/a/span"));
	List<WebElement> str1 = driver.findElements(By.xpath("//div[@class=\"a-section a-spacing-none puis-padding-right-small s-title-instructions-style\"]/following-sibling::div[1]/following-sibling::div/div[1]/div/div[1]/div[1]/a/span[1]"));
	Iterator<WebElement> phoneName = s1.iterator();
	Iterator<WebElement> phonePrice = str1.iterator();
	while(phoneName.hasNext() && phonePrice.hasNext())
	{
		System.out.println(phoneName.next().getText()+"===>"+phonePrice.next().getText());
	}

}
}
