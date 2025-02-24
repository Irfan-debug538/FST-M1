package activities;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity1 {
AppiumDriver driver;

@BeforeClass
public void setup() throws MalformedURLException, URISyntaxException {
	// Desired Capabilities
	UiAutomator2Options options = new UiAutomator2Options();
	options.setPlatformName("android");
	options.setAutomationName("UiAutomator2");
	options.setAppPackage("com.android.calculator2");
	options.setAppActivity(".Calculator");

	// Server Address
	URL serverURL = new URI("http://localhost:4723").toURL();
	// Driver Initialization
	driver = new AndroidDriver(serverURL, options);
}
	@Test
	public void multiplyTest() {
	
		driver.findElement(AppiumBy.id("digit_6")).click();
		driver.findElement(AppiumBy.accessibilityId("×")).click();
		driver.findElement(AppiumBy.id("digit_9")).click();
		driver.findElement(AppiumBy.accessibilityId("equals")).click();
		
		String result = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.android.calculator2:id/result\"]")).getText();
		assertEquals(result, "54");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}