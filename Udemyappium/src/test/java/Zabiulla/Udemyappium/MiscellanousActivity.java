  package Zabiulla.Udemyappium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class MiscellanousActivity extends BaseTest {

	@Test
	public void Miscellanous() throws MalformedURLException, Throwable {

		//adb shell dumpsys window | find "mCurrentFocus"  --->Android
		//adb shell dumpsys window | grep -E ‘mCurrentFocus’ --->MAC
		
		//App package and App activity is used to navigate directly to the particular page
		//First we need to enter adb shell in cmd then dumpsys window | grep -E 'mCurrentFocus' you need to open the pg which u need app activity and package name
//		Activity activity = new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");
//		driver.startActivity(activity);
	
		
		//We follow 1,2 steps normally to check the functionality
		//1.Click on prefernce 
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		//Syntax for Xpath--->//tagname(@Attributr="Value")

		//2.Click on preferences dependencies
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();

		//Click on the check box
		driver.findElement(By.id("android:id/checkbox")).click();
		//Thread.sleep(5000);

		//1.Rotate the device to the Landscape
		DeviceRotation landscape = new DeviceRotation(0, 0, 90);
		driver.rotate(landscape);

		//click on the Wifisetting
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();

		//Get the Text from the screen
		String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();

		//verify the text name is correct or not
		Assert.assertEquals(alertTitle,"WiFi settings");

		//Copypaste options
		//2.Copy the text in the clipboard and paste in the text field using clipboard
		driver.setClipboardText("RahulWifi");

		//driver.findElement(By.id("android:id/edit")).sendKeys("RahulWifi");

		//Send the text in the field
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		Thread.sleep(2000);

		//3.Click on enter button, click on back button, click on home button
		//driver.pressKey(new KeyEvent(AndroidKey.ENTER));
	     ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
	     Thread.sleep(2000);
		
		//Click on Ok button
		//driver.findElement(By.id("android:id/button1")).click(); //by using id 
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click(); //by using classname

		//Click on the back button
		driver.pressKey(new KeyEvent(AndroidKey.BACK));

		//Click on the Home Button
		driver.pressKey(new KeyEvent(AndroidKey.HOME));

	}
}
