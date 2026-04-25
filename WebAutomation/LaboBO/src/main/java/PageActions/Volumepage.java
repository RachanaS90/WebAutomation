package PageActions;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Volumepage extends Basepage{

	WebDriver driver;

	public Volumepage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="ilabo_filter_sites")
	WebElement sites;
	
	@FindBy(xpath="//table[@id='centrale_big_volume_list_table']/child::tbody/child::tr")
	List<WebElement> list;
	
	@FindBy(id="cen_big_volume_35")
	WebElement volume;
	
	@FindBy(xpath="//button[@name='save_big_volume']")
	WebElement savebutton;
	
	@FindBy(xpath="//span[contains(text(),'Gros Volumes')]")
	WebElement grosvolumelink;
	
	public void saveVolume()
	{
		grosvolumelink.click();
		Select sitedropdown1= new Select(sites);
		sites.click();
		sitedropdown1.selectByIndex(21);
		
		System.out.println(list);
		
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).getText().equalsIgnoreCase("testt"))
			{
				volume.click();
				volume.sendKeys("40");
				savebutton.click();
			}
		}
	}
}
