package Zabiulla.Udemyappium;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class Excercise extends BaseTest{
	@Test
	public void Excercise() {
		
		//Click on the App link
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		
		//Click on ALert Dialog
		driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
		
		//Click on the list dailog
		driver.findElement(AppiumBy.accessibilityId("List dialog")).click();
		
		//Check header text
		String text = driver.findElement(By.id("android:id/alertTitle")).getText();
		//String text = driver.findElement(AppiumBy.accessibilityId("android:id/alertTitle")).getText();
		
		//Assertion
		Assert.assertEquals(text, "Header title");
		
		//Check the text
		String text1 = driver.findElement(By.xpath("//android.widget.TextView[@text='Command one']")).getText();
		System.out.println(text1);
		//Verfiying the text
		Assert.assertEquals(text1, "Command one");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
