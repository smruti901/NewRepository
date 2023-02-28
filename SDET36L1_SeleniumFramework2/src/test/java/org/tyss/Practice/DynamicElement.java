package org.tyss.Practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Listeners;

import Pakages.NewPom;
import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(org.tyss.genericUtility.ListenerImplementation.class)
public class DynamicElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.edgedriver().setup();
		WebDriver driver= new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.hotstar.com/in");
		//driver.findElement(By.xpath("//div[text()='Movie']")).click();
		
		
//		String NewShow = "3";
//		String s2 = "Popular Shows";
		NewPom newPom= new NewPom(driver);
		newPom.convertStringToWebelement();
//		List<WebElement> wb = newPom.dynamicXpathnew1(s2);
//		Iterator<WebElement> itr = wb.iterator();
//		List<WebElement> wb1 = newPom.dynamicXpathnew2(s2);
//		Iterator<WebElement> itr1 = wb1.iterator();
//		while(itr.hasNext() && itr1.hasNext())
//			{
//	
//	
//				String s1=itr.next().getAttribute("data-index")+" "+itr1.next().getAttribute("to").split("/")[3].replaceAll("-", " ");
//				System.out.println(s1);
//						
//					
//			}
//		System.out.println("");
//		System.out.println("Totals number of Films is ==> "+wb.size());
//		newPom.dynamicXpathnew(NewShow);
////		try {
////			newPom.screenshotwithforeach(null, s2);
////		} catch (InterruptedException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		
//
//	 
		

	}

}
