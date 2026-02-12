package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.AccountRegistrationPage;
import pageobjects.HomePage;
import testbase.BaseClass;

public class AccountRegistrationTC001 extends BaseClass{
	
	@Test(groups = {"regression", "master"})
	public void newAccountRegistration() {
		logger.info("*****Starting RegistrationTC001*****");
		HomePage homePage = new HomePage(driver);
		logger.info("Clicking on my account");
		homePage.clickOnMyAccount();
		logger.info("Clicking on registration");
		homePage.clickOnRegister();
		
		AccountRegistrationPage registration = new AccountRegistrationPage(driver);
		logger.info("Sending data to the application");
		registration.setFirstname(getRandomString());
		registration.setLastname(getRandomString());
		registration.setEmail(getRandomString()+"@gmail.com");
		registration.setPassword(getRandomAlphaNumeric().toLowerCase());
		registration.selectPrivacyPolicy();
		logger.info("Clicking on continue button to create account");
		registration.clickOnContinue();
		
		logger.info("Validating expected result with actual result");
		String expectedMessage = "Your Account Has Been Created!";
		//Assert.assertEquals(registration.getConfirmMessage().toLowerCase(), expectedMessage.toLowerCase());
		if(expectedMessage.toLowerCase().equals(registration.getConfirmMessage().toLowerCase())) {
			logger.info("Account creation successful");
			Assert.assertTrue(true);
		}
		else {
			logger.error("Account creation unsuccessful");
			logger.debug("Debug logs");
			Assert.assertTrue(false);
		}
	}
}
