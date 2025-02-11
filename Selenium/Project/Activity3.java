package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {
	public WebDriver driver;
	public String copyrightText;

	@BeforeClass
	public void setup() {
		driver = new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/crm");
		driver.manage().window().maximize();
	}

	@Test
	public void testActivity3() {
		copyrightText = driver.findElement(By.id("admin_options")).getText();
		System.out.println("First copyright text: " +copyrightText);
		Reporter.log("First copyright text: " +copyrightText);
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}
}