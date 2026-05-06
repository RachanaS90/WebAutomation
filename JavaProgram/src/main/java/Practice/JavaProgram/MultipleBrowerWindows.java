package Practice.JavaProgram;

import java.util.Set;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleBrowerWindows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		WebElement windowbtn = driver.findElement(By.id("openwindow"));
		windowbtn.click();
		
		String parentwindow = driver.getWindowHandle();
		Set<String> allwindow = driver.getWindowHandles();
		
		for(String window : allwindow)
		{
			if(!window.equals(parentwindow))
			{
				driver.switchTo().window(window);
				System.out.println("child window" + driver.getTitle());
				driver.close();
			}
		}
		
		driver.switchTo().window(parentwindow);
		System.out.println("Parent window" + driver.getTitle());
		
		driver.quit();
	}

}
