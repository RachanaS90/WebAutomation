package PageActions;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class Characteristicspage extends Basepage {
	
	WebDriver driver;

	public Characteristicspage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//span[contains(text(),'Bétons Spéciaux')]")
	WebElement FirstMenuTitle;
	
	@FindBy(id="ilabo_filter_sites")
	WebElement sites;
	
	@FindBy(id="ilabo_centrale_list")
	WebElement centrale;
	
	@FindBy(xpath="//strong[contains(text(),'Sélection des caractéristiques')]")
	WebElement subTitle;
	
	@FindBy(id="concrete_charac_expand_collapse")
	WebElement expandAll;
	
	@FindBy(xpath="//span[contains(text(),'Attention')]")
	WebElement warningMessage;
	
	@FindBy(css="input[type*='checkbox']")
	static List<WebElement> checkbox;
	
	@FindBy(css=".success_msg")
	WebElement successMsg;
	
	By multipleCentraleHeader=By.id("ilabo_save_multiple_centrale_header");
	
	@FindBy(css="[id='centrale-checkbox-list'] li label")
	List<WebElement> centraleList;
	
	@FindBy(id="save_for_selected_centrale")
	WebElement saveforselectedcentrale;
	
	@FindBy(id="save_multiple_centrale_concrete")
	WebElement savemultiplecentralebutton;
	
	@FindBy(id="save_centrale_concrete")
	WebElement savecentralebutton;
	
	public WebElement getCharactcheckbox(int j) {
		return driver.findElement(By.xpath("//input[@id='characteristics_" + j + "']/parent::label"));
	}
	
	public void checkHomePage()
	{
		String homepage = FirstMenuTitle.getText();
		String expectedhomepage = "Bétons Spéciaux";
		if(homepage.equals(expectedhomepage))
		{
			System.out.println("HomaPage lodaded successfully.");
		}
	}
	
	public void selectCharacteristics()
	{
		Select sitedropdown1= new Select(sites);
		sites.click();
		sitedropdown1.selectByIndex(21);
		
		Select centraledropdown = new Select(centrale);
		centrale.click();
		centraledropdown.selectByIndex(1);
		
		String header = subTitle.getText();
		String HomePageHeader = "Sélection des caractéristiques";
		if(header.equalsIgnoreCase(HomePageHeader))
		{
			System.out.println("Landed on main menu successfully.");
		}
		
		expandAll.click();
		
		String expectedWarningMessage = "Attention : Toutes les caractéristiques seront sauvergardées dans les centrales ajoutées";

		String actualWarningMessage = warningMessage.getText();
		if(expectedWarningMessage.equalsIgnoreCase(actualWarningMessage))
		{
			System.out.println("Warning message is displayed properly");
		}
	}
	
	
	public String saveCentrale() {
		System.out.println(checkbox.size());
		for (int i = 0; i < checkbox.size(); i++) {
			boolean checkcondition = checkbox.get(i).isSelected();
			System.out.println(checkcondition);

			if (!checkcondition) {
				int j = i + 1;
				elementToBeClickable(getCharactcheckbox(j)).click();
				break;
			}
		}
		savecentralebutton.click();
		return elementToBeVisible(successMsg).getText();
	}
	
	public String saveMultipleCentrale() throws InterruptedException {
		for (int i = 0; i < checkbox.size(); i++) {
			boolean checkcondition = checkbox.get(i).isSelected();
			System.out.println(checkcondition);

			if (!checkcondition) {
				int j = i + 1;
				elementToBeClickable(getCharactcheckbox(j)).click();
				break;
			}
		}
		savemultiplecentralebutton.click();
		allElementVisibility(centraleList).stream().filter(li -> li.getText().contains("testt")).forEach(li -> li.click());
		saveforselectedcentrale.click();
		return visibilityOfElementLocated(multipleCentraleHeader).getText();
	}	
	
}
