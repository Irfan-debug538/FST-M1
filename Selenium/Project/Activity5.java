package project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5 {
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
	public void testActivity5() throws InterruptedException {
		WebElement userNameInput = driver.findElement(By.id("user_name"));
		WebElement passwordInput = driver.findElement(By.id("username_password"));
		WebElement loginButton = driver.findElement(By.id("bigbutton"));
		userNameInput.sendKeys("admin");
		passwordInput.sendKeys("pa$$w0rd");
		loginButton.click();
		Thread.sleep(Duration.ofSeconds(5));
		WebElement actionsButtonHomePage = driver.findElement(By.id("tab-actions"));
		wait.until(ExpectedConditions.visibilityOf(actionsButtonHomePage));

		Color colorNavMenu = Color.fromString(driver.findElement(By.className("desktop-toolbar")).getCssValue("color"));

		System.out.println("Color as RGB: " +colorNavMenu.asRgb());
		System.out.println("Color as hex code: " +colorNavMenu.asHex());
		Reporter.log("Color as RGB: " +colorNavMenu.asRgb());
		Reporter.log("Color as hex code: " +colorNavMenu.asHex());
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}
}