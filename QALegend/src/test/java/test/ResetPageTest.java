package test;

import org.automation_core.Base;
import org.selenium.constants.Constants;
import org.selenium.constants.Messages;
import org.selenium.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ResetPage;

public class ResetPageTest extends Base{
	@Test (priority=6,groups= {"Regression","Smoke"})
	public void verifyResetPageTitle() 
{
	LoginPage login= new LoginPage(driver);
	ResetPage rest_page=login.clickOnForgetPassword();
	String actual_tittle=driver.getTitle();
	String expected_tittle=ExcelUtility.readStringData(0, 0, Constants.RESET_PAGE_DATA);
	Assert.assertEquals(actual_tittle, expected_tittle,Messages.TITLE_MISMATCH);
}
@Test(priority=7,groups="Sanity" )
public void verifyErrorMessageWithInvalidEmailid() 
{
	
	  LoginPage login= new LoginPage(driver);
	  ResetPage rest_page=login.clickOnForgetPassword();
	  ResetPage reset= new ResetPage(driver);
	  String email=ExcelUtility.readStringData(2, 0, Constants.RESET_PAGE_DATA);
	  reset.enterEmail(email);
	  reset.clickOnResetLink();
	  String actual_error_message=reset.getEmailErrorMessage();
	  String expected_error_message=ExcelUtility.readStringData(0,1, Constants.RESET_PAGE_DATA);
	  Assert.assertEquals(actual_error_message, expected_error_message,Messages.EMAIL_ERROR_MISMATCH);
}
}
