package Zabiulla.Udemyappium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class SwipeDemo extends BaseTest {
	@Test
	public void SwipeDemoTest() throws InterruptedException {
		//Click on the views
		driver.findElement(AppiumBy.accessibilityId("Views")).click();

		//Click on the Gallery
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		//driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Gallery\"]")).click();

		//click on the photos
		//driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Photos\"]")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();

		// location of the first image on the gallery
		WebElement firstImage = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));

		//Check that one photos is focusable or not
		Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"), "true");

		//Swipe the photos
		swipeAction(firstImage, "left");
//		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
//				"elementId", ((RemoteWebElement) firstImage).getId(),
//				"direction", "left",
//				"percent", 0.75
//				));

		//Check that one photos is swiped or not
		Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"), "false");



	}
}
