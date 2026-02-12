package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath = "//button[normalize-space()='Login']")
	WebElement btnLogin;
	
	public void setEmail(String email) {
	    txtEmail.clear();
	    txtEmail.sendKeys(email);
	}

	public void setPassword(String password) {
	    txtPassword.clear();
	    txtPassword.sendKeys(password);
	}

	
	public void clickOnLoginButton() {
		btnLogin.submit();
	}
}
