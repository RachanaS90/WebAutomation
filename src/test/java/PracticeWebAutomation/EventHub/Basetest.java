package PracticeWebAutomation.EventHub;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Basetest {

	WebDriver driver;

	public WebDriver initializeDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		return driver;
	}

	public Loginpage goToURL() {
		initializeDriver();
		driver.get("https://eventhub.rahulshettyacademy.com/");
		return new Loginpage(driver);
	}

}
