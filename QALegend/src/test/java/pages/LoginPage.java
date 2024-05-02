package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.selenium.utilities.WebElementUtility;

public class LoginPage {
WebDriver driver;
	
	public LoginPage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver,this); 
						  
		}
	@FindBy(xpath = " //input[@id='username']")
    WebElement username;
	
	@FindBy(xpath = "//input[@id='password']")
    WebElement password;
	
	@FindBy(xpath = "//button[@class='btn btn-primary']")
    WebElement login_button;
	
	@FindBy(xpath = "//a[@class='btn btn-link']")
	WebElement forgetPassword;
	
	@FindBy(xpath = "//input[@name='remember']")
	WebElement rememberMeCheckBox;
	
	@FindBy(xpath =" //span[@class='help-block']//strong")
	WebElement errormessage;
	@FindBy (xpath ="//button[@class='btn btn-default btn-sm']")
	WebElement endtour;
			
   public ResetPage clickOnForgetPassword1()
    {
		WebElementUtility.clickOnElement(forgetPassword);
		return new ResetPage(driver);
	}

	public void selectRememberMeCheckBox()
	{
		WebElementUtility.clickOnElement(rememberMeCheckBox);
	}
		
	public String userGetText()
	{
		String text=WebElementUtility.getText(errormessage);
		return text;
	}
		
	public HomePage clickOnLoginButton() {
		WebElementUtility.clickOnElement(login_button);
		return new HomePage(driver);
	}
	public void enterUserName(String user_name)
	{
		WebElementUtility.enterValue(username, user_name);
		
	}
	public void enterPassword(String pass_word) {
		WebElementUtility.enterValue(password, pass_word);
	}
	public ResetPage clickOnForgetPassword() {
		WebElementUtility.clickOnElement(forgetPassword);
		return new ResetPage(driver);
	}
	public HomePage clickOnEndTour()
	{
		WebElementUtility.clickOnElement(endtour);
		return new HomePage(driver);
	}
	
}
