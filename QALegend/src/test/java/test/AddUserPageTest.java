package test;

import java.time.Duration;

import org.automation_core.Base;
import org.selenium.constants.Constants;
import org.selenium.constants.Messages;
import org.selenium.utilities.ExcelUtility;
import org.selenium.utilities.RandomDataUtility;
import org.selenium.utilities.WaitUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import listeners.RetryAnalyser;
import pages.AddUserPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageUserPage;

public class AddUserPageTest extends Base {
	@Test(priority=9,groups="Smoke")
	public void verifyAddUserTitle()
	{
	String username=ExcelUtility.readStringData(2,0, Constants.LOGIN_PAGE_DATA);
	String password=ExcelUtility.readIntegerData(3,0, Constants.LOGIN_PAGE_DATA);
	LoginPage login= new LoginPage(driver);
	login.enterUserName(username);
	login.enterPassword(password);
	HomePage home= new HomePage(driver);
	HomePage home_=login.clickOnLoginButton();
	home.clickOnEndTour();
	WaitUtility.waitUsingImplicitWait(driver);
	home.clickOnUserManagement();
	ManageUserPage manage=home.clickOnUsers();
	ManageUserPage manageuser= new ManageUserPage(driver);
	AddUserPage adduser=manageuser.clickOnAddButton();
	WaitUtility.waitUsingImplicitWait(driver);
	AddUserPage add_user= new AddUserPage(driver);
	String acutal_tittle=add_user.getTittle();
	String expected_tittle=ExcelUtility.readStringData(0,1, Constants.ADD_USER_DATA);
	Assert.assertEquals(acutal_tittle, expected_tittle,Messages.TITLE_MISMATCH);
	}

@Test(priority=10,groups="Sanity",retryAnalyzer=RetryAnalyser.class)
	
	public void verfiAddUser() 
   {
		String username=ExcelUtility.readStringData(2, 0, Constants.LOGIN_PAGE_DATA);
		String password=ExcelUtility.readIntegerData(3, 0, Constants.LOGIN_PAGE_DATA);
		LoginPage login= new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		HomePage home= new HomePage(driver);
		HomePage home_=login.clickOnLoginButton();
		home.clickOnEndTour();
		WaitUtility.waitUsingImplicitWait(driver);
		home.clickOnUserManagement();
		ManageUserPage manage=home.clickOnUsers();
		ManageUserPage manageuser= new ManageUserPage(driver);
		AddUserPage adduser=manageuser.clickOnAddButton();
		WaitUtility.waitUsingImplicitWait(driver);
		AddUserPage add_user= new AddUserPage(driver);
		String prefix=ExcelUtility.readStringData(0, 0, Constants.ADD_USER_DATA);
		String firstname=RandomDataUtility.getFirstName();
		String lastname=RandomDataUtility.getLasttName();
		String email=firstname+"."+lastname+"@gmail.com";
		String user_name=firstname;
		String pass_word=firstname+"."+lastname;
		String con_pass=pass_word;
		add_user.enterPrefix(prefix);
		add_user.enterFirstName(firstname);
		add_user.enterLastName(lastname);
		add_user.enterEmail(email);
		add_user.enterUserName(user_name);
		add_user.enterPassword(pass_word);
		add_user.enterConPassword(con_pass);
		ManageUserPage manage_s=add_user.clickOnSubmitButton();
		WaitUtility.waitUsingImplicitWait(driver);
		manageuser.clickOnSearch();
		String search_user=email;
		manageuser.enterSearchValue(search_user);
		WaitUtility.waitUsingImplicitWait(driver);
		String actual_user=manageuser.getSerachUser();
		Assert.assertEquals(actual_user, user_name,Messages.USER_CREATION_FAILED);
}
	@Test(priority=11,groups="Sanity",retryAnalyzer=RetryAnalyser.class)
	public void verifyUserLoginWithNewlyAddedUsers()
	{
		String username=ExcelUtility.readStringData(2, 0, Constants.LOGIN_PAGE_DATA);
		String password=ExcelUtility.readIntegerData(3, 0, Constants.LOGIN_PAGE_DATA);
		LoginPage login= new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		HomePage home= new HomePage(driver);
		HomePage home_=login.clickOnLoginButton();
	 	home.clickOnEndTour();
	 	WaitUtility.waitUsingImplicitWait(driver);
		home.clickOnUserManagement();
		ManageUserPage manage=home.clickOnUsers();
		ManageUserPage manageuser= new ManageUserPage(driver);
		AddUserPage adduser=manageuser.clickOnAddButton();
		WaitUtility.waitUsingImplicitWait(driver);
		AddUserPage add_user= new AddUserPage(driver);
		String firstName= RandomDataUtility.getFirstName();
		String lastname= RandomDataUtility.getLasttName();
		String email= firstName+"."+lastname+"123@gmail.com";
		String pass_word=firstName+"."+lastname;
		String user_name=firstName;
		add_user.enterFirstName(firstName);
		add_user.enterLastName(lastname);
		add_user.enterEmail(email);
		add_user.enterUserName(user_name);
		add_user.enterPassword(pass_word);
		add_user.enterConPassword(pass_word);
		ManageUserPage manage_s=add_user.clickOnSubmitButton();
		manage.clickOnUserName();
		LoginPage relog=manageuser.clickOnLogOut();
		WaitUtility.waitUsingImplicitWait(driver);
		String username_re=user_name;
		String password_re=pass_word;
		LoginPage login_re= new LoginPage(driver);
		login.enterUserName(username_re);
		login.enterPassword(password_re);
		HomePage home1= new HomePage(driver);
		HomePage home_2=login.clickOnLoginButton();
		WaitUtility.waitUsingImplicitWait(driver);
		String actual_user=home_2.getLoggedUser();
		String expected_user="Welcome "+firstName+",";
		Assert.assertEquals(actual_user, expected_user,Messages.RELOGIN_FAILED);
		
	}
		
}
