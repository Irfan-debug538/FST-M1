package project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity6 {

	public WebDriver driver;
	public WebDriverWait wait;

	@BeforeClass
	public void setup() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("http://alchemy.hguy.co/crm");
		driver.manage().window().maximize();
	}

	@Test
	public void testActivity6() throws InterruptedException {
		WebElement userNameInput = driver.findElement(By.id("user_name"));
		WebElement passwordInput = driver.findElement(By.id("username_password"));
		WebElement loginButton = driver.findElement(By.id("bigbutton"));
		userNameInput.sendKeys("admin");
		passwordInput.sendKeys("pa$$w0rd");
		loginButton.click();
		Thread.sleep(Duration.ofSeconds(5));
		WebElement actionsButtonHomePage = driver.findElement(By.id("tab-actions"));
		wait.until(ExpectedConditions.visibilityOf(actionsButtonHomePage));

		WebElement activitiesMenu = driver.findElement(By.xpath("//a[text() = 'Activities']"));

		wait.until(ExpectedConditions.elementToBeClickable(activitiesMenu));

		Assert.assertTrue(activitiesMenu.isDisplayed());

		if(activitiesMenu.isDisplayed() && activitiesMenu.isEnabled()) {
			System.out.println("Activities menu exists and is clickable");
			Reporter.log("Activities menu exists and is clickable");
		}
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}
}