package PracticeWebAutomation.EventHub;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Bookingpage extends Basepage {

	public Bookingpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[contains(text(),'+')]")
	WebElement addticket;
	
	@FindBy(id="customerName")
	WebElement customername;
	
	@FindBy(id="customer-email")
	WebElement customeremail;
	
	@FindBy(id="phone")
	WebElement customerphone;
	
	@FindBy(xpath="//span[@class='text-indigo-700']")
	WebElement totalprice;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement confirmbooking;
	
	@FindBy(xpath="//h3[contains(text(),'Booking Confirmed')]")
	WebElement successmessage;
	
	
	
	public String addDetails()
	{
		visibilityOf(addticket).click();
		customername.sendKeys("Rachana Sinha");
		customeremail.sendKeys("example@gmail.com");
		customerphone.sendKeys("9089898990");
		WebElement bookingbtn = elementToBeClickable(confirmbooking);
		jsexecutor(bookingbtn);
		String actulmessage = successmessage.getText().trim();
		return actulmessage;
	}

	
}
