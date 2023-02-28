package Practice2;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	@Test
	public void Contact() {
		// TODO Auto-generated method stub
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		List<WebElement> lastname = driver.findElements(By.xpath("//input[@name=\"selected_id\"]"));
		Iterator<WebElement> lastName = lastname.iterator();
		while(lastName.hasNext()) {
		    String s = lastName.next().getAttribute("id");
		    System.out.println(s);
		    if(s.equals("5")) {
		    	driver.findElement(By.xpath("//input[@name=\"selected_id\"]")).click();
		    }
		}

	}

}
