package test;

import java.time.Duration;

import org.Base;
import org.selenium.constants.Constants;
import org.selenium.constants.Messages;
import org.selenium.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ManageUserPage;

public class ManageUserPageTest extends Base{
	@Test(priority=8,groups= "Sanity")
	public void verifyManageUserTittle()
	{
	String username=ExcelUtility.readStringData(2,0, Constants.LOGIN_PAGE_DATA);
	String password=ExcelUtility.readIntegerData(3,0, Constants.LOGIN_PAGE_DATA);
	LoginPage login= new LoginPage(driver);
	login.enterUserName(username);
	login.enterPassword(password);
	HomePage home= new HomePage(driver);
	HomePage home_=login.clickOnLoginButton();
	home.clickOnEndTour();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	home.clickOnUserManagement();
	ManageUserPage manage=home.clickOnUsers();
	ManageUserPage manageuser= new ManageUserPage(driver);
	String title_actual=manageuser.getTittle();
	String title_expected=ExcelUtility.readStringData(0, 0, Constants.MANAGE_USER_DATA);
	Assert.assertEquals(title_actual, title_expected,Messages.TITLE_MISMATCH);
	}
}
