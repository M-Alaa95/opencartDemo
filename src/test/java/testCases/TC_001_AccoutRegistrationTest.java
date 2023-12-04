package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccoutRegistrationTest extends BaseClass
{

	
	@Test(groups = {"Regression","Master"})
	void test_account_registration() throws InterruptedException
	{
		logger.debug("Application logs . . . .");
		logger.info("*** Starting TC_001_AccoutRegistrationTest ***");
		try
		{
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on My Account link");
			hp.clickRegister();
			logger.info("Clicked on register link");			
			AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
			logger.info("Providing customer's data");
			regpage.setFirstName("Koko");
			
			regpage.setLastName("Wawa");
			
			regpage.setPassword("kokowawa");
			
			regpage.setEmail(randomeNumber()+randomeString()+"@gmail.com"); //randomly generated email
			
			regpage.setPrivacyPolicy();
			Thread.sleep(2000);
			regpage.clickContinue();
			logger.info("Clicked on continue . . .");
			String confmsg = regpage.getConfirmationMsg();
			logger.info("Validating expected message");
			Assert.assertEquals(confmsg, "You Account Has Been Created!","Not getting expected message");
		}
		catch(Exception e)
		{
			logger.error("Test Failed");
			Assert.fail();
		}
		
		logger.info("*** Finished TC_001_AccoutRegistrationTest ***");
	}
	


}
