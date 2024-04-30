package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.selenium.utilities.DateUtility;
import org.selenium.utilities.WebElementUtility;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this); 
	}
		
	@FindBy(xpath = "//section[@class='content-header' ]")
	WebElement Register_User_Title;
	@FindBy(xpath ="//span[@class='title']")
	WebElement user_management;
	@FindBy(xpath = "//div[@class='m-8 pull-left mt-15 hidden-xs']")
	WebElement login_Date;
	@FindBy (xpath ="/html/body/div[2]/aside/section/ul/li[2]/ul/li[1]/a/span")
	WebElement users;
	@FindBy (xpath ="//button[@class='btn btn-default btn-sm']")
	WebElement endtour;

	public String getLoggedUser()
	{
		String user=WebElementUtility.getText(Register_User_Title);
		return user;
	}
	public String getTittle()
	{
		String tittle=driver.getTitle();
		return tittle;
	}
		public String getLoginDate()
	{
		String login_date = WebElementUtility.getText(login_Date);
		return login_date;
	}
	public String getCurrentDate()
	{
		String current_date = DateUtility.getUserLoginDate("dd-MM-YYYY");
		return current_date;
	}
	public void clickOnUserManagement()
	{
		WebElementUtility.clickOnElement(user_management);
		
	}
	public ManageUserPage clickOnUsers()
	{
		WebElementUtility.clickOnElement(users);
		return new ManageUserPage(driver);
		
	}
	public void clickOnEndTour()
	{
		WebElementUtility.clickOnElement(endtour);
		
	}
}
