package test;

import org.Base;
import org.selenium.constants.Constants;
import org.selenium.constants.Messages;
import org.selenium.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import listeners.RetryAnalyser;
import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends Base{
	@Test(priority=4,groups="Regression",retryAnalyzer=RetryAnalyser.class)
	public void verifyHomePageTitle() 
	{
	String userName =ExcelUtility.readStringData(2,0 ,Constants.LOGIN_PAGE_DATA);
	String password = ExcelUtility. readIntegerData(3,0, Constants.LOGIN_PAGE_DATA);
	LoginPage loginobj = new LoginPage(driver);
	loginobj.enterUserName(userName);
	loginobj.enterPassword(password);
	HomePage home = loginobj.clickOnLoginButton();
	String actual_Title = driver.getTitle();
	HomePage homeobj= loginobj.clickOnEndTour();
	System.out.println(actual_Title);
	String expected_Title = ExcelUtility.readStringData(0,0, Constants.HOME_PAGE_DATA)+"123";
	Assert.assertEquals(actual_Title, expected_Title, Messages.TITLE_MISMATCH);
}
	@Test(priority=5,groups="Regression")
	
public void verifyUserLoginDate()
{
	String username=ExcelUtility.readStringData(2, 0, Constants.LOGIN_PAGE_DATA);
	String password=ExcelUtility.readIntegerData(3, 0, Constants.LOGIN_PAGE_DATA);
	LoginPage login= new LoginPage(driver);
	login.enterUserName(username);
	login.enterPassword(password);
	HomePage homeobj= new HomePage(driver);
	HomePage home=login.clickOnLoginButton();
	String actual_logindate=homeobj.getLoginDate();
	String expected_logindate=homeobj.getCurrentDate();
	Assert.assertEquals(actual_logindate, expected_logindate,Messages.LOGIN_DATE_FAILED);
}
}
