package project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {

	public WebDriver driver;
	public String title;

	@BeforeClass
	public void setup() {
		driver = new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/crm");
		driver.manage().window().maximize();
	}

	@Test
	public void testActivity1() {
		title = driver.getTitle();
		System.out.println("Title of the page: " +title);
		Assert.assertEquals(title, "SuiteCRM");
		Reporter.log("Title of the page: " +title);
	}

	@AfterClass
	public void teardown() {
		if(title.equalsIgnoreCase("SuiteCRM")) {
			driver.quit();
		}
	}
}