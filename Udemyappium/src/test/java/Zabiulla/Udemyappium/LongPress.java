package Zabiulla.Udemyappium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class LongPress extends BaseTest {
	@Test
	public void LongPressGuseter() throws InterruptedException {
		//Click on View
		driver.findElement(AppiumBy.accessibilityId("Views")).click();

		//Click on Expandable Lists
		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();

		//Click on Custom Adapter
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();

		//xpath of people name
		WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));

		//		//LongPress on the People name
		//		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
		//			    "elementId", ((RemoteWebElement) ele).getId(),"duration",2000));
		//Thread.sleep(2000);

		//the longpress code is in the basetest
		longPressAction(element);

		//Get the text of the menu after long press
		String menuText = driver.findElement(By.id("android:id/title")).getText();
		//System.out.println(menuText);

		//Verify that the name is correct or not
		Assert.assertEquals(menuText, "Sample menu");

		//Verify that the spelling is correct or not
		Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());
	}
}
