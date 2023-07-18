package Zabiulla.Udemyappium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class DragDrop extends BaseTest {
	@Test
	public void DragDropTest() throws InterruptedException {
		//Click on the views
		driver.findElement(AppiumBy.accessibilityId("Views")).click();

		//Click on the Drag and drop option
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();

		//Location of the Web element
		WebElement source = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));


		//Drag and Drop
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement) source).getId(),
				"endX", 624,
				"endY", 624
				));

		Thread.sleep(3000);
		String result = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();

		Assert.assertEquals(result, "Dropped!");
	}
}
