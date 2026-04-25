package PageActions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Basepage {

	WebDriver driver;
	WebDriverWait wait;

	public Basepage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, Duration.ofMillis(1000));
	}
	
	public WebElement elementToBeVisible(WebElement element)
	{
		return wait.until(ExpectedConditions.visibilityOf(element));   
	}
	
	public WebElement elementToBeClickable(WebElement element)
	{
        return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public WebElement visibilityOfElementLocated(By element)
	{
		return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
	
	public List<WebElement> allElementVisibility(List<WebElement> ele) {
		return wait.until(ExpectedConditions.visibilityOfAllElements(ele));
	}
	
}
