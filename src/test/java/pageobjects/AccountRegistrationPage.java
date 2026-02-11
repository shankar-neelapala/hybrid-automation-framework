package pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtUsername;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkPrivacyPolicy;
	
	@FindBy(xpath="//button[normalize-space()='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement txtConfirmMessage;
	
	public void setFirstname(String username) {
		txtUsername.sendKeys(username);
	}
	
	public void setLastname(String lastname) {
		txtLastname.sendKeys(lastname);
	}
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void selectPrivacyPolicy() {
		//chkPrivacyPolicy.click();
		
		/*Actions act = new Actions(driver);
		act.moveToElement(chkPrivacyPolicy).click();*/
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()",chkPrivacyPolicy);
		
	}
	
	public void clickOnContinue() {
		//btnContinue.click();
		
		/*Actions act = new Actions(driver);
		act.moveToElement(btnContinue).click();*/
		
		btnContinue.submit();
	}
	
	public String getConfirmMessage() {
		return txtConfirmMessage.getText();
	}
}
