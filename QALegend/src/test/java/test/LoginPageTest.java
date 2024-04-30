package test;

import org.Base;
import org.selenium.constants.Constants;
import org.selenium.constants.Messages;
import org.selenium.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;
import dataProvider.Dataproviders;
import pages.HomePage;
import pages.LoginPage;

public class LoginPageTest extends Base {
	@Test(priority =1,groups= "Smoke")
	public void verifyLoginPageTitle() 
{
		LoginPage loginobj=new LoginPage(driver);
		HomePage home=loginobj.clickOnLoginButton();
		String actual_tittle=driver.getTitle();
		String data=ExcelUtility.readStringData(0, 0, Constants.LOGIN_PAGE_DATA);
		Assert.assertEquals(actual_tittle, data,Messages.TITLE_MISMATCH);
}
	@Test(priority =2,groups= "Regression")
public void verifyUserLoginwithValidCredentials() 
{
		String username=ExcelUtility.readStringData(2,0, Constants.LOGIN_PAGE_DATA);
		String password=ExcelUtility.readIntegerData(3,0, Constants.LOGIN_PAGE_DATA);
		LoginPage loginobj=new LoginPage(driver);
		loginobj.enterUserName(username);
		loginobj.enterPassword(password);
		HomePage home= new HomePage(driver);
		HomePage home_page=loginobj.clickOnLoginButton();
		String user_name=home.getLoggedUser();
		//String expected_username="Welcome XYZ,";
		String expected_username=ExcelUtility.readStringData(0, 3, Constants.LOGIN_PAGE_DATA);
		Assert.assertEquals(user_name, expected_username,Messages.LOGIN_MISMATCH);
		}
	
	@Test(priority=3,dataProvider="InvalidUserCredentials",dataProviderClass=Dataproviders.class)

	public void verifyErrorMessageWhileLoginwithInvalidCredentials(String username,String password) 
{
		String expected=ExcelUtility.readStringData(1, 0, Constants.LOGIN_PAGE_DATA);
		LoginPage loginobj=new LoginPage(driver);
		loginobj.enterUserName(username);
		loginobj.enterPassword(password);
		HomePage home= new HomePage(driver);
		HomePage home_user=loginobj.clickOnLoginButton();
		String user_name=home.getLoggedUser();
	    String error_actual=loginobj.userGetText();
        Assert.assertEquals(error_actual, expected,Messages.LOGIN_FAILED_WARNING_MESSAGE_NOT_FOUND);
	}
}
