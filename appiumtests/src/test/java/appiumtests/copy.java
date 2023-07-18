package appiumtests;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class copy {
	static AndroidDriver<MobileElement> driver;
	
	 
	public static void main(String[]arg) throws Throwable{
		openCalculator();
	}

	public static void openCalculator() throws Exception {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Pixel 6 API 30 A1");
		cap.setCapability("udid", "emulator-5554");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "11.0");
		
		cap.setCapability("appPackage", "com.indiamart.m");
		cap.setCapability("appActivity", "com.oneplus.calculator2.calculator");
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(url,cap);
		System.out.println("Application Started");
	}

}
