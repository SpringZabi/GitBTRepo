package Zabiulla.Udemyappium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.functions.ExpectedCondition;

public class eCommerce_tc_5ScrollAddVerifyTheAmountAndSwitchToWebAndBackToNative extends BaseTest {



	@Test
	public  void Fillform() throws InterruptedException {

		//In this script we use to add the multiple products to the page and we use to verify the price and switch to web app and pass the text and back to the native


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
//		ArrayList<Integer> al = new ArrayList<Integer>();
//		System.out.println(al.size());
		//Scroll the page till we see the particular product and click on add to cart the product
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();

//		System.out.println(fp);
//		Thread.sleep(5000);
//		String fp = driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).getText();
//
//		System.out.println(fp);
//		Thread.sleep(5000);

		//System.out.println(al.getsize());
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		//Thread.sleep(5000);

		//System.out.println(al.size());
		//Click on the Add to cart button
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

		//To avoid StaleElementException
		Thread.sleep(2000);

		//Applying Explicitly wait until it loads the next page
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));

		//Here we should use findelements because it returns list of web elements
		List<WebElement> productPrice = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		int count = productPrice.size();
		double totalSum=0;

		//we use for loop for repeation of the process
		for (int i = 0; i < count; i++) {
			String amountString = productPrice.get(i).getText();
			//Double price=Double.parseDouble(amountString.substring(1));
			//The below method is in the BaseTest it is used to remove the$ symbol.
			Double price = getFormattedAmount(amountString);
			totalSum=totalSum+price;	
		}

		//Finding the Sum of toatlamount from the cart
		String displaySum = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		Double displayFormattedSum = getFormattedAmount(displaySum);

		//Applying Assertion to check the values are correct or not
		Assert.assertEquals(totalSum, displayFormattedSum);

		//LongPress on the Please read our Terms and Condition and check the title and close button is working or not
		//LongPress
		WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		longPressAction(ele);

		//Capture the title and verify it is correct or not
		String title = driver.findElement(By.id("com.androidsample.generalstore:id/alertTitle")).getText();
		System.out.println(title);
		Assert.assertEquals(title, "Terms Of Conditions");

		//Click on the close button
		driver.findElement(By.id("android:id/button1")).click();

		//Select the Check box
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();

		//Click on the Visit to website button to purchase button to proceed
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();

		Thread.sleep(6000);

		//Getting the contexts that are there in the applications
		Set<String> contexts = driver.getContextHandles();

		//Advanced for loop is used to print all the context in the app
		for (String contextName : contexts) {
			System.out.println(contextName);
		}

		//Switch to browser window in the app

		driver.context("WEBVIEW_com.androidsample.generalstore");

		//Locator for an Search text field
		driver.findElement(By.name("q")).sendKeys("RahulShetty Academy");
		Thread.sleep(3000);
		//Click on the Enter button
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		//Click on the back button on the emulator
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		//Switch the control to the Mobile 
		driver.context("NATIVE_APP");

	}
}
