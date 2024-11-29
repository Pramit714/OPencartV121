package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001AccountRegistrationTest extends BaseClass {
	
	
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration()
	{
		
		logger.info("***********Starting TC_001AccountRegistrationTest ******");
		
		try
		{
		HomePage hp=new HomePage(driver);
		
		hp.clickMyAccount();
		logger.info("***********Clicked on My Account ******");
		
		hp.clickRegister();
		logger.info("***********Clicked on Register ******");
		
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");	
		regpage.setTelephone(randomeNumber());
		
		
		String password=randomeAlphaNumberic();
		
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		//regpage.setPassword("xdy436");
		//regpage.setConfirmPassword("xdy436");
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		String confmsg=regpage.getConfirmationMsg();
		Assert.assertEquals(confmsg,"Your Account Has Been Created!");
		
		
	 }
		catch(Exception e)
		{
			logger.error("Test Failed");
			Assert.fail();
		}
		
		logger.info("******Finished TC001_AccountRegistrationTest *****");
	}
	
	
	
}
