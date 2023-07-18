package betterthat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.protobuf.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;

public class basic {
 public static void main(String[]args) throws Throwable {
	 WebDriverManager.chromedriver().setup();
	 WebDriver driver =new ChromeDriver();
	 Thread.sleep(10);
	 //driver.manage().timeouts().implicitlyWait(Duration.ofsec)
	 driver.get("https://www.youtube.com/");
	 driver.manage().window().maximize(); 
	 Thread.sleep(6000);
	 driver.close();
 }
}
