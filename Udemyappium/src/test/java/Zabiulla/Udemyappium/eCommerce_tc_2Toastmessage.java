package Zabiulla.Udemyappium;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class eCommerce_tc_2Toastmessage extends BaseTest {



	@Test
	public  void Fillform() throws InterruptedException {

//In this script we use to click on the Lets shop button without passing the name in the Text Fields
		
		
		//Pass the text in the text field
		//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Sofiya");

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

		//There will be same x path for the toast by default i.e android.widget.Toast for toast message
		String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		Assert.assertEquals(toastMessage, "Please enter your name")	;
	}

}
