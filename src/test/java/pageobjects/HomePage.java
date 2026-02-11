package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//li[@class='list-inline-item']//i[@class='fa-solid fa-caret-down']")
	WebElement myAccountLink;
	
	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement registerLink;
	
	public void clickOnMyAccount() {
		myAccountLink.click();
	}
	
	public void clickOnRegister() {
		registerLink.click();
	}
}
