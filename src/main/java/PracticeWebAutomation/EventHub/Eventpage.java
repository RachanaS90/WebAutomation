package PracticeWebAutomation.EventHub;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Eventpage extends Basepage {

	String eventname = "World Tech Summit";
	String categoryname = "Festival";

	public Eventpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Search events, venues…']")
	WebElement searchfield;

	@FindBy(xpath = "//h3[contains(text(),'World Tech Summit')]")
	WebElement eventcard;

	@FindBy(xpath = "//a[@id='nav-events']")
	WebElement eventtab;
	
	@FindBy(xpath="//a[@class='hover:text-indigo-600 transition-colors']")
	WebElement eventlistpage;
	
	@FindBy(xpath="//div[@class='flex flex-col gap-1 sm:w-48']")
	WebElement category;
	
	@FindBy(xpath="//div//a[@id='book-now-btn']")
	WebElement bookbtn;
	
	
	public List<WebElement> getOptions()
	{
	return driver.findElements(By.xpath("//div[@class='flex flex-col gap-1 sm:w-48']//select//option"));
	}
	

	public void searchEvent() {
		visibilityOf(eventtab).click();
		visibilityOf(searchfield).sendKeys(eventname);
		String searchedevent = visibilityOf(eventcard).getText();
		System.out.println(searchedevent);
		if(searchedevent.equalsIgnoreCase(eventname))
		{
		  visibilityOf(eventcard).click();
		}
		visibilityOf(eventlistpage).click();
	}
	
	public String selectCategory(String categoryname)
	{
		visibilityOf(category).click();
		String cleantext = null;
		for (WebElement option : visibilityOfAllElements(getOptions())) {
	        String rawtext = option.getText().trim();
	        cleantext = rawtext.replaceAll("[^a-zA-Z ]", "").trim();
	        System.out.println("Option found: " + cleantext);
	        if (cleantext.equalsIgnoreCase(categoryname)) {
	            option.click();
	            System.out.println("Selected category: " + categoryname);
	            break;
	        }
	    }
		return cleantext;
	}
	
	public Bookingpage navigateToBookingPage()
	{
		Actions actions = new Actions(driver);
	    actions.moveToElement(bookbtn).click().perform();
		return new Bookingpage(driver);
	}




	
}
