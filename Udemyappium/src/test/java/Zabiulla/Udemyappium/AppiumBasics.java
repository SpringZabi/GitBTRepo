package Zabiulla.Udemyappium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumBasics extends BaseTest {
	
	@Test
	public void WifiSettingName() throws MalformedURLException, Throwable {
		//Actual Automation Code
		//Locators the Appium Supports Xpath,ID,Class name,Accessibility ID,androidUIAutomator
		//Setting up Wifi name
		
		//Click on prefernce 
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		//Syntax for Xpath--->//tagname(@Attributr="Value")
		//Click on preferences dependencies
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		//Click on the check box
		driver.findElement(By.id("android:id/checkbox")).click();
		//Thread.sleep(5000);
		//click on the Wifisetting
		 driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		
		//Get the Text from the screen
		String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		
		//verify the text name is correct or not
		Assert.assertEquals(alertTitle,"WiFi settings");
		
		//Send the text in the field
		driver.findElement(By.id("android:id/edit")).sendKeys("RahulWifi");
		//Click on Ok button
		//driver.findElement(By.id("android:id/button1")).click(); //by using id 
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click(); //by using classname
		
	}
}
