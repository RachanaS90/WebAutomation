package LaboBOTest;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MainTest {

	static List<WebElement> checkbox;
	static WebDriverWait wait;
	static WebDriver driver;
	static WebElement sites;
	static WebElement centrale;
	

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));

		driver.get("https://solutionsbpe.rec.sgdbf.saint-gobain.net/");
		driver.manage().window().maximize();

		WebElement existingCredentials = driver.findElement(By.xpath("//b[contains(text(),'automatically')]"));
		WebElement connection = driver.findElement(By.id("login.submit.id"));

		if (existingCredentials.isDisplayed()) {
			connection.click();
		} else {
			driver.findElement(By.id("username")).sendKeys("R9224560");
			driver.findElement(By.id("password")).sendKeys("Shivansh@2026");
			connection.click();
		}

		WebElement LaboBOApp = driver.findElement(By.xpath("//strong[contains(text(),'LABO')]"));
		if (LaboBOApp.isDisplayed()) {
			LaboBOApp.click();
		} else {
			System.out.println("No permission to access Labo BO App");
		}

		String HomePage = driver.findElement(By.xpath("//span[contains(text(),'Bétons Spéciaux')]")).getText();
		String expectedHomePage = "Bétons Spéciaux";
		Assert.assertEquals(expectedHomePage, HomePage);

		sites = driver.findElement(By.id("ilabo_filter_sites"));

		Select sitedropdown = new Select(sites);
		sites.click();
		sitedropdown.selectByIndex(21);

		WebElement centrale = driver.findElement(By.id("ilabo_centrale_list"));
		Select centraledropdown = new Select(centrale);
		centrale.click();
		centraledropdown.selectByIndex(1);

		String header = driver.findElement(By.xpath("//strong[contains(text(),'Sélection des caractéristiques')]"))
				.getText();
		String HomePageHeader = "Sélection des caractéristiques";
		Assert.assertEquals(HomePageHeader.toUpperCase(), header);

		driver.findElement(By.id("concrete_charac_expand_collapse")).click();
		String expectedWarningMessage = "Attention : Toutes les caractéristiques seront sauvergardées dans les centrales ajoutées";

		String actualWarningMessage = driver.findElement(By.xpath("//span[contains(text(),'Attention')]")).getText();

		Assert.assertEquals(actualWarningMessage, expectedWarningMessage);

		wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		checkbox = driver.findElements(By.cssSelector("input[type*='checkbox']"));
		System.out.println(checkbox.size());

		saveCentrale();
		String successMessage = "Bétons spéciaux enregistrés avec succès.";
		Thread.sleep(1000);
		String actualSuccessMessage = driver.findElement(By.cssSelector(".success_msg")).getText();
		Assert.assertEquals(successMessage, actualSuccessMessage);

		saveMultipleCentrale();
		String multipleSaveHeader = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("ilabo_save_multiple_centrale_header")))
				.getText();
		String centralheader = "Centrale";
		Assert.assertEquals(multipleSaveHeader, centralheader);

		List<WebElement> centraleList = driver.findElements(By.cssSelector("[id='centrale-checkbox-list'] li label"));
		centraleList.stream().filter(li -> li.getText().contains("testt")).forEach(li -> li.click());

		driver.findElement(By.id("save_for_selected_centrale")).click();

		formulaSelection();
	}

	public static void saveCentrale() {
		for (int i = 0; i < checkbox.size(); i++) {
			boolean checkcondition = checkbox.get(i).isSelected();
			System.out.println(checkcondition);

			if (!checkcondition) {
				int j = i + 1;
				WebElement characteristics = driver
						.findElement(By.xpath("//input[@id='characteristics_" + j + "']/parent::label"));
				wait.until(ExpectedConditions.elementToBeClickable(characteristics)).click();
				break;
			}
		}
		driver.findElement(By.id("save_centrale_concrete")).click();
	}

	public static void saveMultipleCentrale() {
		for (int i = 0; i < checkbox.size(); i++) {
			boolean checkcondition = checkbox.get(i).isSelected();
			System.out.println(checkcondition);

			if (!checkcondition) {
				int j = i + 1;
				WebElement characteristics = driver
						.findElement(By.xpath("//input[@id='characteristics_" + j + "']/parent::label"));
				wait.until(ExpectedConditions.elementToBeClickable(characteristics)).click();
				break;
			}
		}
		driver.findElement(By.id("save_multiple_centrale_concrete")).click();
	}

	public static void formulaSelection() throws InterruptedException {
		driver.findElement(By.xpath("//span[contains(text(),'Formules Spéciales')]")).click();
		WebElement formulaDropdown= driver.findElement(By.id("formula_type_list"));
		Select select = new Select(formulaDropdown);
		List<WebElement> options = select.getOptions();
		System.out.println(options.size());
		for (int i = 0; i < options.size(); i++) {
			options.get(i).click();
			String nonFormulaSection = driver
					.findElements(By.xpath("//h4[contains(text(),'Formules Non Sélectionnées')]")).toString();
			String nonformulaTitle = "Formules Non Sélectionnées";
			List<WebElement> formulus = driver.findElements(By.xpath("//tr"));			
			if (nonFormulaSection.contains(nonformulaTitle)) {
				for (int j=0;j<1;j++) {
					WebElement rightArrow = null;
					try {
						formulus.get(i).click();
						rightArrow = driver.findElement(By.xpath("//button[@name='right_move']"));
					} catch (Exception e) {
						driver.findElements(By.xpath("//tr")).get(i).click();
						rightArrow = driver.findElement(By.xpath("//button[@name='right_move']"));
					}
					if (rightArrow.isEnabled()) {
						driver.findElement(By.xpath("//button[@name='right_move']")).click();
					}
				}
			}
		}
		String successMessage = "Formules mises à jour avec succès";
		Thread.sleep(1000);
		
		String actualSuccessMessage = driver.findElement(By.cssSelector(".success_msg")).getText();
		System.out.println(actualSuccessMessage);
		Assert.assertEquals(successMessage, actualSuccessMessage);
		driver.findElement(By.xpath("//div[@class='alert alert-success common_success_msg_div']//em[@class='fa fa-close']")).click();
	}
	

}
