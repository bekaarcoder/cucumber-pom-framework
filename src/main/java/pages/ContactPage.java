package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactPage {
	
	private WebDriver driver;
	
	// Locators
	private By subjectHeadingSelectField = By.id("id_contact");
	private By emailField = By.id("email");
	private By orderRefField = By.id("id_order");
	private By messageField = By.id("message");
	private By sendButton = By.id("submitMessage");
	private By alertText = By.xpath("//p[contains(@class, 'alert')]");
	
	// Constructor
	public ContactPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// Action Methods
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void fillContactUsForm(String heading, String email, String orderRef, String message) {
		Select select = new Select(driver.findElement(subjectHeadingSelectField));
		select.selectByVisibleText(heading);
		
		driver.findElement(emailField).sendKeys(email);
		
		driver.findElement(orderRefField).sendKeys(orderRef);
		
		driver.findElement(messageField).sendKeys(message);
	}
	
	public void clickSendButton() {
		driver.findElement(sendButton).click();
	}
	
	public String getAlertText() {
		return driver.findElement(alertText).getText();
	}

}
