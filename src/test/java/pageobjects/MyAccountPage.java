package pageobjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement txtConfirmAccount;
	
	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	WebElement msgHeading;
	
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement linkLogout;
	
	public boolean isMyAccountPageExists() {
		try {
			return msgHeading.isDisplayed();
		}
		catch(NoSuchElementException e) {
			return false;
		}
	}
	
	
	public void clickOnLogout() {
		linkLogout.click();
	}

	public String confirmAccount() {
		return txtConfirmAccount.getText();
	}
}
