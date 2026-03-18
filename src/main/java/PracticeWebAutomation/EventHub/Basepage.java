package PracticeWebAutomation.EventHub;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Basepage {
  
	WebDriver driver;
	WebDriverWait wait;

	public Basepage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofMillis(5000));
	}
	
	public WebElement visibilityOf(WebElement element)
	{
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public List<WebElement> visibilityOfAllElements(List<WebElement> options)
	{
		return wait.until(ExpectedConditions.visibilityOfAllElements(options));
	}
	
	public WebElement elementToBeClickable(WebElement element)
	{
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void jsexecutor(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);
	}
  
}
