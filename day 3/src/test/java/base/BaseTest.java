package base;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import utils.ConfigReader;
import utils.ReportManager;

public class BaseTest {

	protected WebDriver driver;
	protected Properties prop;

	@BeforeSuite
	public void beforeSuite() {
		prop = ConfigReader.initProperties();
		ReportManager.getExtent();
	}

	@BeforeMethod
	public void setUp(Method method) {
		String browser = prop.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			throw new RuntimeException("Unsupported browser in config: " + browser);
		}

		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

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
