package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pages.LoginPage;
import utils.ConfigReader;
import utils.ReportManager;

public class LoginTest extends BaseTest {
	@Epic("OrangeHRM")
    @Feature("Login")
    @Story("Valid login with Admin user")
    @Severity(SeverityLevel.BLOCKER)

	@Test
	public void loginTest() {
		LoginPage lp = new LoginPage(driver);
		String user = ConfigReader.getProperty("username");
        String pass = ConfigReader.getProperty("password");

		ReportManager.getTest().info("Attempting login.....");
		lp.login(user, pass);
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		ReportManager.getTest().info("Logged In successfully.....");
	}
	@Epic("OrangeHRM")
    @Feature("Title")
    @Story("Title Test")
    @Severity(SeverityLevel.BLOCKER)


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
