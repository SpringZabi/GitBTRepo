package Zabiulla.Udemyappium;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class ScrollDemo extends BaseTest {
	@Test
	public void ScrollDemoTest() throws InterruptedException {
		//Click on the views
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		//where to scroll is known prior first method
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))"));
		//Thread.sleep(2000);

		//No prior idea till where to scroll and use this just to scroll until end second method
		scrollDownAction();
	}
}
