package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import testbase.BaseClass;

public class LoginWithValidCredentialsTC002 extends BaseClass{

	@Test(groups = {"sanity", "master"})
	public void login() {
		logger.info("*****Starting LoginWithValidCredentialsTC002*****");
		HomePage hp = new HomePage(driver);
		hp.clickOnMyAccount();
		logger.info("Clicking on login");
		hp.clickOnLogin();
		
		logger.info("Providing email and password");
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(prop.getProperty("email"));
		lp.setPassword(prop.getProperty("password"));
		logger.info("Clicking on login button");
		lp.clickOnLoginButton();
		
		//validation
		MyAccountPage mp= new MyAccountPage(driver);
		Assert.assertEquals(mp.isMyAccountPageExists(), true);
		logger.info("*****Finished LoginWithValidCredentialsTC002*****");
	}
}
