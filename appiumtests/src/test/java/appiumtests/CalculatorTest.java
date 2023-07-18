package appiumtests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


    
public class CalculatorTest {
	 static AndroidDriver<RemoteWebElement> driver;
	public static URL url;
	 
	public static void main(String[]arg) throws Throwable{
		openCalculator();
	}

	public static void openCalculator() throws Exception {
		final String URL_STRING = "http://127.0.0.1:4723/wd/hub";
		url = new URL(URL_STRING);
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "OnePlus 8 Pro");
		cap.setCapability("udid", "c1d169b8");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "13.0");
		
		cap.setCapability("appPackage", "com.oneplus.calculator");
		cap.setCapability("appActivity", "com.oneplus.calculator2.calculator");
		//URL url = new URL("http://localhost:4723/wd/hub");
		driver = new AndroidDriver<RemoteWebElement>(url,cap);
		System.out.println("Application Started");
	}
	 
}
