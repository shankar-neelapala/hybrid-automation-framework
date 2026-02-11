package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.AccountRegistrationPage;
import pageobjects.HomePage;

public class RegistrationTC001 extends BaseClass{
	
	@Test
	public void newAccountRegistration() {
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		homePage.clickOnRegister();
		
		AccountRegistrationPage registration = new AccountRegistrationPage(driver);
		registration.setFirstname(getRandomString());
		registration.setLastname(getRandomString());
		registration.setEmail(getRandomString()+"@gmail.com");
		registration.setPassword(getRandomAplhaNumeric().toLowerCase());
		registration.selectPrivacyPolicy();
		registration.clickOnContinue();
		
		String expectedMessage = "Your Account Has Been Created!";
		Assert.assertEquals(expectedMessage.toLowerCase(), registration.getConfirmMessage().toLowerCase());
	}
}
