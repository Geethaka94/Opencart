package testCases;

import org.testng.annotations.Test;

import pageObjects.HomePage;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	@Test
	public void verify_account_registration()
	{
		logger.info("TC001 Starting...");
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
	}

}
