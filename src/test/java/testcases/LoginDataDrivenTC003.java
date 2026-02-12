package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import testbase.BaseClass;
import utilities.DataProviders;

public class LoginDataDrivenTC003 extends BaseClass{

	@Test(dataProvider = "login-data",dataProviderClass = DataProviders.class, groups = {"datadriven"})
	public void loginDataDrivenTest(String email, String password, String result) {
		logger.info("*****Starting LoginDataDrivenTC003*****");
		HomePage hp = new HomePage(driver);
		hp.clickOnMyAccount();
		logger.info("Clicking on login");
		hp.clickOnLogin();
		
		logger.info("Providing email and password");
		LoginPage lp = new LoginPage(driver);		
		lp.setEmail(email);
		lp.setPassword(password);
		logger.info("Clicking on login button");
		lp.clickOnLoginButton();
		
		//validation
		logger.info("validating results");
		MyAccountPage mp= new MyAccountPage(driver);
		boolean status = mp.isMyAccountPageExists();
		//System.out.println(status);
		if (result.equalsIgnoreCase("valid")) {
		    Assert.assertTrue(status, "Login should succeed for valid credentials");
		} else if (result.equalsIgnoreCase("invalid")) {
		    Assert.assertFalse(status, "Login should fail for invalid credentials");
		}

		if (status) {
		    mp.clickOnLogout();
		    //System.out.println(email);
		}

		logger.info("*****Starting LoginDataDrivenTC003*****");
	}
}
