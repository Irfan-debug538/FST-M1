package appiumProject;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity6 {
	AndroidDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {
		// Desired Capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("Android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.android.chrome");
		options.setAppActivity("com.google.android.apps.chrome.Main");
		options.noReset();

		// Server URL
		URL serverURL = new URI("http://localhost:4723").toURL();

		// Driver initialization
		driver = new AndroidDriver(serverURL, options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// Open Selenium page
		driver.get("https://v1.training-support.net/selenium");
	}

	@Test
	public void PopUpLogin() throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.className("android.webkit.WebView")));
		
    	// Locate heading on page and print it
    	String pageTitle = driver.findElement(AppiumBy.className("android.webkit.WebView")).getText();
    	System.out.println("Web Page Heading: " + pageTitle);

    	driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Get Started!\"]")).click();
    	
    	wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"JavaScript Alerts\"]")));
    	
    	// UiScrollable object string
     	String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
     	
     	// Scroll to End
     	driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".scrollToEnd(2)"));
     	
     	wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Tables\"]")));
     	
     	//Scroll to End
     	driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".scrollToEnd(2)"));
     	    	
     	Thread.sleep(1000);
     	
     	// Locate element
     	driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"Popups  Tooltips and Modals\"]")).click();
    	
    	Thread.sleep(1000);
    	
    	String popUp = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Popups\"]")).getText();
    	System.out.println("You are on " + popUp);
    	
    	//click on sign on
    	driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Sign In\"]")).click();
    	
    	//popUp Window opens
    	wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View[@resource-id=\"signInModal\"]")));
    	
    	String NewPopUp = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Sign In\"]")).getText();
    	System.out.println("You are on new pop up window, " + NewPopUp);
    	
    	//enter valid credentials
    	driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]")).sendKeys("admin");
    	driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"password\"]")).sendKeys("password");
    	
    	wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text=\"Log in\"]")));
    	driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Log in\"]")).click();
    	
    	Thread.sleep(1000);
    	
    	wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Popups\"]")));
    	wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("action-confirmation")));
    	
    	String ConfirmationMsg = driver.findElement(AppiumBy.id("action-confirmation")).getText();
    	
    	System.out.println("Credential valid? " + ConfirmationMsg);
    	
    	Assert.assertEquals(ConfirmationMsg, "Welcome Back, admin");
    	
    	Thread.sleep(1000);
    	
    	
    	driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Sign In\"]")).click();
    	
    	//Pop Up window opens
    	wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View[@resource-id=\"signInModal\"]")));
    	
    	String NewPopUp1 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Sign In\"]")).getText();
    	System.out.println("You are on new pop up window, " + NewPopUp1);
    	
    	
    	//enter in-valid credentials
    	driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]")).sendKeys("admin1");
    	driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"password\"]")).sendKeys("password");
    	
    	wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text=\"Log in\"]")));
    	driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Log in\"]")).click();
    	
    	Thread.sleep(1000);
    	
    	wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Popups\"]")));
    	wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("action-confirmation")));
    	    	
    	String ConfirmationMsg1 = driver.findElement(AppiumBy.id("action-confirmation")).getText();
    	
    	System.out.println("Credential valid? " + ConfirmationMsg1);
    	
    	System.out.println("Credentials invalid?  " + ConfirmationMsg1);
    	
    	Assert.assertEquals(ConfirmationMsg1, "Invalid Credentials");
    	
    	
    	
	}


	@AfterClass
	public void tearDown() {
		// Close the browser
		driver.quit();
	}
}