package PageActions;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Loginpage extends Basepage {
	WebDriver driver;
	public Loginpage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//b[contains(text(),'automatically')]")
	WebElement existingCredentials;

	@FindBy(id="login.submit.id")
	WebElement connection;
	 
	@FindBy(id="username")
	WebElement Username;
	
	@FindBy(id="password")
	WebElement Password;
	
	@FindBy(xpath="//strong[contains(text(),'LABO')]")
	WebElement LaboApplication;
	
	
	
	public Characteristicspage login()
	{
		//WebDriverWait wait=new WebDriverWait(driver);
		if (existingCredentials.isDisplayed()) {
			connection.click();
		} else {
			Username.sendKeys("R9224560");
			Password.sendKeys("Shivansh@2026");
			connection.click();
		}
		
		if (LaboApplication.isDisplayed()) {
			LaboApplication.click();
		} else {
			System.out.println("No permission to access Labo BO App");
		}
		return new Characteristicspage(driver);
	}
	
	public Formulapage formulalogin()
	{
		if (existingCredentials.isDisplayed()) {
			connection.click();
		} else {
			Username.sendKeys("R9224560");
			Password.sendKeys("Shivansh@2026");
			connection.click();
		}
		
		if (LaboApplication.isDisplayed()) {
			LaboApplication.click();
		} else {
			System.out.println("No permission to access Labo BO App");
		}
		return new Formulapage(driver);
	}

	
}
