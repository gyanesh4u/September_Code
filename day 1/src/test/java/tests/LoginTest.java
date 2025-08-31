package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {

	@Test
	public void loginTest() {
		LoginPage lp = new LoginPage(driver);
		lp.login("Admin", "admin123");
		AssertJUnit.assertEquals(driver.getTitle(), "OrangeHRM");
	}
}
