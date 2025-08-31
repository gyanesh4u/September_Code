package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import base.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pages.LoginPage;

public class LoginTest extends BaseTest {
	@Epic("OrangeHRM")
	@Feature("Login")
	@Story("Valid login with admin user")
	@Severity(SeverityLevel.BLOCKER)
	@Test
	public void loginTest() {
		LoginPage lp = new LoginPage(driver);
		lp.login("Admin", "admin123");
		AssertJUnit.assertEquals(driver.getTitle(), "OrangeHRM");
	}
}
