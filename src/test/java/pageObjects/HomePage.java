package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	
	//constructor
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
//Locators
	
@FindBy(xpath="//span[normalize-space()='My Account']")	
WebElement lnkMyaccount;

@FindBy(xpath="//a[normalize-space()='Register']")
WebElement lnkRegister;

@FindBy(xpath="//a[normalize-space()='Login']") //for step5 Login link added
WebElement lnkLogin;

//Action Methods

public void clickMyAccount()

{
	lnkMyaccount.click();
}


public void clickRegister()

{
	lnkRegister.click();
}

public void clickLogin()

{
	lnkLogin.click();
}


}
