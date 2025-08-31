package tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import base.BaseTest;
import pages.LoginPage;
import utils.ReportManager;

public class LoginTest extends BaseTest {

	@Test
	public void loginTest() {
		LoginPage lp = new LoginPage(driver);
		ReportManager.getTest().info("Attempting login.....");
		lp.login("Admin", "admin123");
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		ReportManager.getTest().info("Logged In successfully.....");
	}

	@Test
	public void loginTitleTest() {
		LoginPage lp = new LoginPage(driver);
		String title = lp.loginTitle();
		ReportManager.getTest().info("Getting Title.....");
		System.out.println(title);
		Assert.assertEquals(title, "OrangeHRM");
		ReportManager.getTest().info("Title Matched.....");
	}
}
