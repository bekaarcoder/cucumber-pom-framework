package pages;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {
	
	private WebDriver driver;
	
	// Locators
	private By accountSectionLinks = By.cssSelector(".addresses-lists span");
	private By pageHeader = By.xpath("//h1[contains(text(), 'My account')]");
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public int getAccountSectionLinksCount() {
		return driver.findElements(accountSectionLinks).size();
	}
	
	public List<String> getAccountSectionLinks() {
		List<String> linkValue = new ArrayList<String>();
		List<WebElement> links = driver.findElements(accountSectionLinks);
		
		for(WebElement e : links) {
			String val = e.getText().trim();
			linkValue.add(val);
		}
		
		return linkValue;
	}
	
	public boolean isAccountPage() {
		return driver.findElement(pageHeader).isDisplayed();
	}

}
