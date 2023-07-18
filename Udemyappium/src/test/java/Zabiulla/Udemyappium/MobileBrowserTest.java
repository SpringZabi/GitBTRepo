package Zabiulla.Udemyappium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileBrowserTest extends BrowserBaseTest {
	
	@Test
	public void browserTest() throws Exception {
		
		//In that script we perform Browser Automation using Appium
		
		//This is the Dummy app to perform browser action using appium https://rahulshettyacademy.com/angularAppdemo/
		
//		//Pass the web URL
//		driver.get("https://www.google.com/");
//		System.out.println(driver.getTitle());
//		
//		//pass the text to the chrome
//		driver.findElement(By.name("q")).sendKeys("RahulShetty Academy");
//		Thread.sleep(2000);
//		//Click on the Enter button
//		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
	
		
	
		//To work on the broswer from an Mobile pass the url of the site
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
	
		//Click on the Hamburger icon on the right top
		driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();
		
		//Click on the product fron the list
		driver.findElement(By.cssSelector("a[routerlink*='products']")).click();
		
		//scroll the page of the product
		((JavascriptExecutor)driver).executeAsyncScript("window.scrollBy(0,1000)", "");
		
		//Fetch the text of the devops and store it
		String text = driver.findElement(By.cssSelector("a[href*='products/3']")).getText();
		Thread.sleep(2000);
		
				//Verify the Name of the Devops with Assertion
		Assert.assertEquals(text, "Devops");
		
		
	}
}
