package basics;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class CalculatorTest {

	public static void main(String[] args) throws Exception {
//		DesiredCapabilities dc=new DesiredCapabilities();
//		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
//		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Andriod");
//		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, 13.0); //Version is Number here
//		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "OnePlus 8 pro");
//		//dc.setCapability(MobileCapabilityType.APP, "C:\\apk\\indiamart-13-0-7.apk");
//		
//		dc.setCapability("appPackage", "com.oneplus.calculator");
//		dc.setCapability("appActivity", "com.oneplus.calculator2.calculator");
//		URL url = new URL("http://127.0.0.1:4723/wd/hub");
//		AndroidDriver<WebElement> driver=new AndroidDriver<WebElement>(url,dc);
//		Thread.sleep(5000);

		
		//Set the Desired Capabilities
				DesiredCapabilities caps = new DesiredCapabilities();
				caps.setCapability("deviceName", "OnePlus 8 Pro");
				caps.setCapability("udid", "c1d169b8"); //Give Device ID of your mobile phone
				caps.setCapability("platformName", "Android");
				caps.setCapability("platformVersion", "13.0");
				caps.setCapability("appPackage", "com.android.vending");
				caps.setCapability("appActivity", "com.google.android.finsky.permission.DSE");
				caps.setCapability("noReset", "true");
				
				//Instantiate Appium Driver
				try {
						AppiumDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);
					
				} catch (MalformedURLException e) {
					System.out.println(e.getMessage());
				}
	}
}
