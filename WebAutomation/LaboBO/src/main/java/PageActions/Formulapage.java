package PageActions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Formulapage extends Basepage {

	WebDriver driver;

	public Formulapage(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[contains(text(),'Formules Spéciales')]")
	WebElement formulamenu;

	@FindBy(id = "formula_type_list")
	WebElement formulaDropdown;

	@FindBy(xpath = "//h4[contains(text(),'Formules Non Sélectionnées')]")
	WebElement nonformulasectionheader;
	
	@FindBy(xpath = "//h4[contains(text(),'Formules Sélectionnées')]")
	WebElement formulasectionheader;

	@FindBy(xpath = "//table[@id='ilabo_special_liquid_formulas_table']/tbody/tr")
	List<WebElement> activeformulas;

	@FindBy(xpath = "//div[@class='alert alert-success common_success_msg_div']//em[@class='fa fa-close']")
	WebElement toastmessage;

	@FindBy(css = ".success_msg")
	WebElement successmessage;

	@FindBy(id = "ilabo_filter_sites")
	WebElement sites;

	@FindBy(id = "ilabo_centrale_list")
	WebElement centrale;

	@FindBy(xpath = "//button[@name='right_move']")
	WebElement rightarrow;
	
	@FindBy(name="left_move")
	WebElement leftarrow;
	
	public List<WebElement> getNonActiveFormulas()
	{
		return driver.findElements(By.cssSelector("div[id=ilabo_formulas_table_wrapper] table tbody tr"));
	}

	public String formulaSelection() throws InterruptedException {

		formulamenu.click();
		Select sitedropdown1 = new Select(sites);
		sites.click();
		sitedropdown1.selectByIndex(21);

		Select centraledropdown = new Select(centrale);
		centrale.click();
		centraledropdown.selectByIndex(1);

		Select select = new Select(formulaDropdown);
		List<WebElement> options = select.getOptions();
		System.out.println(options.size());
		for (int i = 0; i < options.size(); i++) {
			options.get(i).click();
			String nonformulaTitle = "Formules Non Sélectionnées";
			if ((elementToBeVisible(nonformulasectionheader).toString()).contains(nonformulaTitle)) {
				for (int j = 0; j < 1; j++) {
					        try {
								allElementVisibility(getNonActiveFormulas()).get(j).click();
								elementToBeClickable(rightarrow).click();
								Thread.sleep(5000);
							} catch (InterruptedException e) {
								allElementVisibility(getNonActiveFormulas()).get(j).click();
								elementToBeClickable(rightarrow).click();
								Thread.sleep(5000);
							}
						}
					/*String formulaTitle = "Formules Sélectionnées";
					if((elementToBeVisible(formulasectionheader).toString()).contains(formulaTitle))
					{
						Thread.sleep(1000);
						allElementVisibility(activeformulas).get(j).click();
						elementToBeClickable(leftarrow).click();
					}*/
				}
			}
		Thread.sleep(1000);
		String msg = elementToBeVisible(successmessage).getText();
		toastmessage.click();
		return msg;
	}
}
