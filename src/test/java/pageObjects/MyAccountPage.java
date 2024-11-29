package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	
	        //constructor
			public MyAccountPage(WebDriver driver)
			{
				super(driver);
			}

			
			//Locators
			
			@FindBy(xpath="//h2[normalize-space()='My Account'")	//MyAccount Page heading
			WebElement msgHeading;
			
			@FindBy(xpath="//div[@class='list-group']//a[text()='Logout']") //added for step 6.3 for logout
			WebElement lnkLogout;
			
			//Action Method
			
			public boolean isAccountPageExists()
			{
				try
				{
					return(msgHeading.isDisplayed());
					
				}
				
				catch(Exception e)
				{
					return false;
				}
			}
			
			public void clickLogout()
			{
				lnkLogout.click();
			}
}
