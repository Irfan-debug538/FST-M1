package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {

	public WebDriver driver;
	public String url;

	@BeforeClass
	public void setup() {
		driver = new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/crm");
		driver.manage().window().maximize();
	}

	@Test
	public void testActivity2() {
		url = driver.findElement(By.xpath("//div[@class = 'companylogo']//img")).getDomAttribute("src");
		System.out.println("URL of the header image: " +url);
		Reporter.log("URL of the header image: " +url);
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}
}