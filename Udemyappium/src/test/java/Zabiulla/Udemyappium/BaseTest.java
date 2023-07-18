package Zabiulla.Udemyappium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	public AndroidDriver driver;
	public AppiumDriverLocalService service;

	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException {
		//AndroidDriver  , IODDriver
		//Appium code ---> Appium server---> mobile
		//Code to start the Server
		service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\shaik\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
		//service.start();

		UiAutomator2Options options = new UiAutomator2Options();
		//To work on the Emulator we need to pass the Devicename
		//options.setDeviceName("Pixel 6 API 30 A1");
		options.setDeviceName("Pixel 6 Pro API 32");

		//To work on the Real Device just we need to pass Devicename as Android Device
		//options.setDeviceName("Android Device");

		//Set chrome Driver path
		options.setChromedriverExecutable("C:\\resources\\chromedriver_win32\\chromedriver.exe");

		//options.setChromedriverExecutable("C:/Users/shaik/Downloads/chromedriver_win32 (1)/chromedriver.exe");

		//For Api demos application
		//options.setApp("C:\\Users\\shaik\\eclipse-workspace\\Udemyappium\\src\\test\\java\\resources\\ApiDemos-debug.apk");

		//For general store application
		options.setApp("C:\\Users\\shaik\\eclipse-workspace\\Udemyappium\\src\\test\\java\\resources\\General-Store.apk");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}



	public void longPressAction(WebElement ele) {
		//LongPress on the People name
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement) ele).getId(),"duration",2000));
	}


	public void scrollDownAction() {
		//No prior idea till where to scroll and use this just to scroll until end
		boolean canScrollMore ;
		do
		{
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
					"left", 100, "top", 100, "width", 200, "height", 200,
					"direction", "down",
					"percent", 3.0
					));
		} 
		while (canScrollMore);
	}


	public void swipeAction(WebElement ele, String direction) {
		//Swipe the photos
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement) ele).getId(),
				"direction", "left",
				"percent", 0.75
				));
	}


	//Method to convert string to double to remove the $ from the amount.
	public Double getFormattedAmount(String amount) {
		Double price=Double.parseDouble(amount.substring(1));
		return price;
	}




	@AfterClass
	public void tearDown() {
		//Closing the Application
		driver.quit();

		//Stop the Server
		service.stop();	
	}

}
