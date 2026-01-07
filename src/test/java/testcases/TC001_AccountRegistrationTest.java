package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.AccountRegistrationPage;
import pageobjects.HomePage;
import testbase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups ={"Regression","Master"} )
	public void verfifyAccountRegisistration() {

		logger.info("****** starting TC001_AccountRegistrationTest******");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickmyaccount();
			logger.info("clicked on my account ");
			hp.clickregister();
			logger.info("clicked on register link");
			AccountRegistrationPage arp = new AccountRegistrationPage(driver);
			logger.info("providing customer details");
			arp.enterFirstName(randomString().toUpperCase());// random name
			arp.enterLastName(randomString().toUpperCase());
			arp.enterEmail(randomString() + "@gmail.com");// randomly generated email
			arp.enterTelephone(randomNumber());
			arp.enterPassword("Abc@123");
			arp.enterconfPassword("Abc@123");
			arp.clickChecbox();
			logger.info("Accepted privacy policy");

			arp.clickSubmit();
			logger.info("Clicked on Submit button");

			// ADD VERIFICATION HERE
			String confMsg = arp.getConfirmationMsg();
			if(confMsg.equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);
			}
			else {
				logger.error("test failed");
				Assert.assertTrue(false);
			}

			//Assert.assertEquals(confMsg, "Your Account Has Been Created!!!", "Account registration failed");

			
		} catch (Exception e) {
			
			// logger.debug("debug logs");
			Assert.fail();
		}
		logger.info("Account registration test PASSED");
	}

}
