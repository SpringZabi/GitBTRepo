package Zabiulla.Udemyappium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.functions.ExpectedCondition;

public class eCommerce_tc_3AddproductstothecartandVerifytheName extends BaseTest {



	@Test
	public  void Fillform() throws InterruptedException {

		//In this script we use to scroll the page and add the product to the add to cart page.


		//Pass the text in the text field
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Sofiya");

		//Hide the keyboard
		driver.hideKeyboard();

		//Select the Radio Button
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();

		//Click on the Dropdown
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();

		//Scroll the dropdown list
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Belgium\"))"));

		driver.findElement(By.xpath("//android.widget.TextView[@text='Belgium']")).click();

		//Click on the Lets shop button 
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		//Scroll the page till we see the particular product
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"))"));

		//Get the size of the products that are displaying in the page (All the products are page)
		int productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();


		for (int i = 0; i <productCount; i++) {
			String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			if (productName.equalsIgnoreCase("Jordan 6 Rings")) {
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();	
			}	
		}
		
		//Toavoid StaleElementException
		Thread.sleep(3000);
		
		//Click on the Add to cart button
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		//Thread.sleep(3000);

		//Applying Explicitly wait until it loads the next page
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));


		//Capture the product name from the cart page
		String lastPageProduct = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		Assert.assertEquals(lastPageProduct, "Jordan 6 Rings");
	}
}
