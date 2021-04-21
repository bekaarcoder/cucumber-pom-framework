package stepDefinitions;

import org.junit.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.LoginPage;

public class LoginSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private static String title;
	
	@Given("User is on login page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	    Assert.assertTrue(loginPage.isLoginPage());
	}

	@When("User gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		title = loginPage.getLoginPageTitle();
	    System.out.println("Title of the webpage: " + title);
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String expectedTitle) {
	    Assert.assertEquals(expectedTitle, title);
	}

	@Then("Forgot password link should be displayed")
	public void forgot_password_link_should_be_displayed() {
	    Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}

	@When("User enters username {string}")
	public void user_enters_username(String email) {
	    loginPage.enterEmail(email);
	}

	@When("User enters password {string}")
	public void user_enters_password(String password) {
	    loginPage.enterPassword(password);
	}

	@When("User clicks on login button")
	public void user_clicks_on_login_button() {
	    loginPage.clickLoginButton();
	}

}
