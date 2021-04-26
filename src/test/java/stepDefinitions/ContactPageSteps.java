package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ContactPage;
import utils.ExcelReader;

public class ContactPageSteps {
	
	private ContactPage contactPage = new ContactPage(DriverFactory.getDriver());
	
	@Given("User is on contact us page")
    public void user_is_on_contact_us_page() throws Throwable {
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=contact");
		String expected = "Contact us - My Store";
		Assert.assertEquals(expected, contactPage.getPageTitle());
    }

    @When("User fills form from given {string} and row number {int}")
    public void user_fills_form_from_given_something_and_row_number(String sheetname, Integer row) throws Throwable {
    	ExcelReader reader = new ExcelReader();
    	List<Map<String, String>> excelData = reader.getData("C:\\Users\\shashank.basant\\eclipse-workspace\\CucumberPOMFramework\\ContactData.xlsx", sheetname);
    	String heading = excelData.get(row).get("Subject Heading");
    	String email = excelData.get(row).get("Email");
    	String orderRef = excelData.get(row).get("Order Reference");
    	String message = excelData.get(row).get("Message");
    	contactPage.fillContactUsForm(heading, email, orderRef, message);
    }

    @And("User clicks on send button")
    public void user_clicks_on_send_button() throws Throwable {
        contactPage.clickSendButton();
    }
    
    @Then("Successful message is displayed to user")
    public void successful_message_is_displayed_to_user() throws Throwable {
        String expected = "Your message has been successfully sent to our team.";
        Assert.assertEquals(expected, contactPage.getAlertText());
    }

}
