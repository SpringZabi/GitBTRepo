package appiumtests;

//public class SampleTest {
	import io.appium.java_client.MobileElement;
	import io.appium.java_client.android.AndroidDriver;
	import junit.framework.TestCase;
	import org.junit.After;
	import org.junit.Before;
	import org.junit.Test;
	import java.net.MalformedURLException;
	import java.net.URL;
	import org.openqa.selenium.remote.DesiredCapabilities;

	public class SampleTest {

	  private AndroidDriver driver;

	 @Before
	  public void setUp() throws MalformedURLException {
	    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("appium:platformVersion", "11.0");
	    desiredCapabilities.setCapability("appium:deviceName", "Pixel 6 API 30 A1");
	    desiredCapabilities.setCapability("appium:udid", "emulator-5554");
	    desiredCapabilities.setCapability("appium:automationName", "UIAutomator2");
	    desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
	    desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
	    desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
	    desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

	    URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

	    driver = new AndroidDriver(remoteUrl, desiredCapabilities);
	  }

	 @Test
	  public void sampleTest() {
	    MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("Contacts");
	    el2.click();
	    MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("Create new contact");
	    el3.click();
	    MobileElement el4 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText[1]");
	    el4.sendKeys("hello");
	  }

	 @After
	  public void tearDown() {
	    driver.quit();
	  }
	}

//}
