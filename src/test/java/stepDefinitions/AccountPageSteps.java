package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.AccountPage;
import pages.LoginPage;

public class AccountPageSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AccountPage accountPage;
	
	@Given("User is logged in to application")
	public void user_is_logged_in_to_application(DataTable dataTable) {
	    List<Map<String, String>> credList = dataTable.asMaps();
	    String email = credList.get(0).get("email");
	    String password = credList.get(0).get("password");
	    DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	    accountPage = loginPage.doLogin(email, password);
	}

	@Given("User is on Accounts page")
	public void user_is_on_accounts_page() {
	    Assert.assertTrue(accountPage.isAccountPage());
	}

	@Then("User gets account section links")
	public void user_gets_account_section_links(DataTable dataTable) {
	    List<String> expectedLinks = dataTable.asList();
	    List<String> actualLinks = accountPage.getAccountSectionLinks();
	    Assert.assertTrue(expectedLinks.containsAll(actualLinks));
	}

	@Then("{string} links are displayed in the account section")
	public void links_are_displayed_in_the_account_section(String linksCount) {
	    Assert.assertEquals(Integer.parseInt(linksCount), accountPage.getAccountSectionLinksCount());
	}

}
