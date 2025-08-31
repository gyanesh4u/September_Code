package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	private WebDriver driver;

	// PageFactory locators

	@FindBy(name = "username")
	private WebElement userName;

	@FindBy(name = "password")
	private WebElement password;

	@FindBy(css = "button[type$='submit']")
	private WebElement loginBtn;

	// Constructor

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Actions

	public void login(String username, String pwd) {
		userName.sendKeys(username);
		password.sendKeys(pwd);
		loginBtn.click();
	}

	public String loginTitle() {
		return driver.getTitle();
	}
}
