package Zabiulla.Udemyappium;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class eCommerce_tc_1 extends BaseTest {



	@Test
	public  void Fillform() throws InterruptedException {

		//In this Script we used to pass the name in the Text Field and click on the lets shop button
		
		
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

		//Sleep to view the list of product
		Thread.sleep(5000);
	}

}
