package base;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import utils.ReportManager;

public class BaseTest {

	protected WebDriver driver;

	@BeforeSuite
	public void beforeSuite() {
		ReportManager.getExtent();
	}

	@BeforeMethod
	public void setUp(Method method) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		ReportManager.createTest(method.getName()).info("Starting test: " + method.getName());

	}

	@AfterMethod
	public void tearDown() {

		if (driver != null) {
			driver.quit();
		}
	}

	@AfterSuite
	public void afterSuite() {
		ReportManager.flush();
	}
}
