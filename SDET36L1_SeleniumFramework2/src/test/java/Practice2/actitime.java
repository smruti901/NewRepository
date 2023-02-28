package Practice2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Practice.Baseclass;
import Practice.Baseclass2;
@Listeners(Practice.Listnersclass.class)
public class actitime extends Baseclass2 {
	@Test
	public void demo()
	{
		driver.get("https://demo.actitime.com/login.do");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager",Keys.ENTER);
		String text = driver.findElement(By.xpath("//div[text()='Tasks']")).getText();
		
		Assert.assertEquals(text, "Tasks");
		driver.findElement(By.xpath("//div[text()='Tasks']")).click();
		
		driver.findElement(By.xpath("//a[text()='Logout']")).click();

}
}