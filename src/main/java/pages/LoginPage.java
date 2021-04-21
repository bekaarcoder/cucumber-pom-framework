package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	// Locators
	private By pageHeader = By.xpath("//h1[contains(text(), 'Authentication')]");
	private By emailField = By.id("email");
	private By passwordField = By.id("passwd");
	private By loginButton = By.id("SubmitLogin");
	private By forgotPwdLink = By.linkText("Forgot your password?");
	
	// Constructor of the page class
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// Page actions
	
	public boolean isLoginPage() {
		return driver.findElement(pageHeader).isDisplayed();
	}
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean isForgotPwdLinkExist() {
		return driver.findElement(forgotPwdLink).isDisplayed();
	}
	
	public void enterEmail(String email) {
		driver.findElement(emailField).sendKeys(email);
	}
	
	public void enterPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
	}
	
	public void clickLoginButton() {
		driver.findElement(loginButton).click();
	}
	
	public AccountPage doLogin(String email, String password) {
		driver.findElement(emailField).sendKeys(email);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(loginButton).click();
		return new AccountPage(driver);
	}

}
