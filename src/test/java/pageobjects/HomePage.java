package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//li[@class='list-inline-item']//i[@class='fa-solid fa-caret-down']")
	WebElement linkMyAccount;
	
	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement linkRegister;
	
	@FindBy(xpath = "//a[normalize-space()='Login']")
	WebElement linkLogin;
	
	public void clickOnMyAccount() {
		linkMyAccount.click();
	}
	
	public void clickOnRegister() {
		linkRegister.click();
	}
	
	public void clickOnLogin() {
		linkLogin.click();
	}
}
