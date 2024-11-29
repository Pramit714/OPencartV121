package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003LoginDDT extends BaseClass{
	
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class) //getting  data providers from different class
	public void verify_LoginDDT(String email, String pwd,String exp) throws InterruptedException 
	{
		        
		logger.info("******Strated TC_003LoginDDT*****************");
		
		try 
		{
		        //HomePage
				HomePage hp=new HomePage(driver);
				hp.clickMyAccount();
				hp.clickLogin();
				
				//LoginPage
				LoginPage lp=new LoginPage(driver);
				lp.setEmail(email);
				lp.setPassword(pwd);
				lp.clickLogin();
				
				//MyAccount
				MyAccountPage macc=new MyAccountPage(driver);
				boolean targetPage=macc.isAccountPageExists();
				
				
				
				if(exp.equalsIgnoreCase("Valid"))
				{
					if(targetPage==true)
					{
						macc.clickLogout();
						Assert.assertTrue(true);
						
					}
					else
					{
						Assert.assertTrue(false);
					}
					
				}
				
				if(exp.equalsIgnoreCase("Invalid"))
				{
					if(targetPage==true)
					{
						macc.clickLogout();
						Assert.assertTrue(false);
					}
					
					else
					{
						Assert.assertTrue(true);
					}
				}
				
		}
		catch(Exception e)	
		{
			Assert.fail();
		}
		
		Thread.sleep(3000);
		logger.info("*******Finished TC_003LoginDDT**************");
	
	}

}
