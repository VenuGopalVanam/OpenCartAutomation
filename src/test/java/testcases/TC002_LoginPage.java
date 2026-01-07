package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccountsPage;
import testbase.BaseClass;

public class TC002_LoginPage extends BaseClass {
	
	
    @Test(groups = {"Sanity", "Master"})
	public void verifylogin() {
		logger.info("*****Starting TC002_LoginPage****** ");
		try {
		//Homepage
			
		HomePage hp = new HomePage(driver);
		hp.clickmyaccount();
		hp.clicklogin();
		//Loginpage
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(properties.getProperty("email"));
		lp.setPassword(properties.getProperty("password"));
		lp.clicklogin();
	
		
		//MyAccountverify
		MyAccountsPage ma = new MyAccountsPage(driver);
		boolean targetpage = ma.ismyaccountpageExists();
		Assert.assertTrue(targetpage);
		ma.clickLogout();
		logger.info("**** Finished TC002_Login******");
		}
		catch(Exception e) {
			Assert.fail(); 
		}
	}
}
