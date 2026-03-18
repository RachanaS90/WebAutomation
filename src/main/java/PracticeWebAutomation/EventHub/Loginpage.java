package PracticeWebAutomation.EventHub;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage extends Basepage{

	WebDriver driver;

	public Loginpage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id= "email")
	WebElement emailid;
	
	@FindBy(id= "password")
	WebElement password;
	
	@FindBy(id= "login-btn")
	WebElement loginbtn;
	
	public Eventpage userLogin(String email, String passwrd)
	{
		emailid.sendKeys(email);
		password.sendKeys(passwrd);
		loginbtn.click();
		return new Eventpage(driver);
	}

}
