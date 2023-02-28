import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class demotesting {
	@Test(invocationCount = 10)
	public void Createuser()
	{
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver =new ChromeDriver();
		//driver.get("https://www.flipkart.com/");
		System.out.println("user created");
	}
	@Test
	public void Modifyuser()
	{
		System.out.println("user modified");
	}
@Test

	public void Deleteuser()
	{
	System.out.println("user deleted");
	}
@Test(dependsOnMethods = "SignUp")
public void SignIn() {
	System.out.println("signin");
}
@Test
public void SignUp() {
	System.out.println("Signup");
}
}
