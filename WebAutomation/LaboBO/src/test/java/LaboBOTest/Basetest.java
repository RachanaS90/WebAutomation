package LaboBOTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageActions.Loginpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Basetest {

	WebDriver driver;
	String successMessage = "Bétons spéciaux enregistrés avec succès.";
	String popupheader = "Centrale";
	String formulasuccessMessage = "Formules mises à jour avec succès";

	public WebDriver initializeDriver() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		driver.manage().window().maximize();
		return driver;
	}
	
	public Loginpage goToURL() {
		initializeDriver();
		driver.get("https://solutionsbpe.rec.sgdbf.saint-gobain.net/");
		return new Loginpage(driver);
	}
	
	public Loginpage goToFormulaLink()
	{
		initializeDriver();
		driver.get("https://solutionsbpe.rec.sgdbf.saint-gobain.net/ilabo/bo/ilaboFormula/lists");
		return new Loginpage(driver);
	}

}
