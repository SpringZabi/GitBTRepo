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

public class BrowserBaseTest {
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
//This Base test for to launch the browser using the mobile
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException {
		//AndroidDriver  , IODDriver
		//Appium code ---> Appium server---> mobile
		//Code to start the Server
		service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\shaik\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
		//service.start();

		UiAutomator2Options options = new UiAutomator2Options();
		//options.setDeviceName("Pixel 6 API 30 A1");
		options.setDeviceName("Pixel 6 Pro API 32");
		
		//Set chrome Driver path
		options.setChromedriverExecutable("C:\\resources\\chromedriver_win32\\chromedriver.exe");
		options.setCapability("browserName","Chrome");
		
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
