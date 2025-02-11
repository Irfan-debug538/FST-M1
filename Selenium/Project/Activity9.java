package project;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity9 {

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
	public void testActivity9() throws InterruptedException {
		WebElement userNameInput = driver.findElement(By.id("user_name"));
		WebElement passwordInput = driver.findElement(By.id("username_password"));
		WebElement loginButton = driver.findElement(By.id("bigbutton"));
		userNameInput.sendKeys("admin");
		passwordInput.sendKeys("pa$$w0rd");
		loginButton.click();
		Thread.sleep(Duration.ofSeconds(5));
		WebElement actionsButtonHomePage = driver.findElement(By.id("tab-actions"));
		wait.until(ExpectedConditions.visibilityOf(actionsButtonHomePage));

		Actions action = new Actions(driver);
		WebElement salesMenuItem = driver.findElement(By.xpath("//a[text() = 'Sales']"));
		WebElement leads = driver.findElement(By.xpath("//a[text() = 'Leads']"));
		action.moveToElement(salesMenuItem).pause(Duration.ofSeconds(3)).click(leads).pause(Duration.ofSeconds(5)).build().perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".table-responsive")));
		Thread.sleep(Duration.ofSeconds(3));

		String rowsXpathText;
		List<WebElement> row;
		WebElement user;
		for(int i = 1; i <= 10; i++) {
			rowsXpathText = "//div[@class= 'list-view-rounded-corners']/table/tbody/tr["+i+"]";
			row = driver.findElements(By.xpath(rowsXpathText));

			for (WebElement name : row) {
				name = driver.findElement(By.xpath(rowsXpathText+"/td[@field = 'name']//a"));
				user = driver.findElement(By.xpath(rowsXpathText+"/td[@field = 'assigned_user_name']//a"));
				
				System.out.println("Name of lead "+i+": "+name.getText());
				System.out.println("Assigned user name of lead "+i+": "+user.getText());
				Reporter.log("Name of lead "+i+": "+name.getText());
				Reporter.log("Assigned user name of lead "+i+": "+user.getText());
			}
		}
	}
	@AfterClass
	public void teardown() {
		driver.quit();
	}
}