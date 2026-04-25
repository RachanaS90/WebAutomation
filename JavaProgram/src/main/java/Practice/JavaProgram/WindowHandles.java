package Practice.JavaProgram;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		WebElement openwindow = driver.findElement(By.id("openwindow"));
		openwindow.click();
		
		Set<String> newwindow = driver.getWindowHandles();
		Iterator<String> it = newwindow.iterator();


		String parentwindow = it.next();
		String childwindow = it.next();
		
		driver.switchTo().window(childwindow);
		System.out.println("Child winodow has been opened");
		
		driver.switchTo().window(parentwindow);
		System.out.println("shifted to parent window");
		
		driver.quit();
	}

}
