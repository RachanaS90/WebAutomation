package Practice.JavaProgram;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class HandleAlert {
  public static void main(String[] args) {
 
	  WebDriverManager.chromedriver().setup();
	  
	  WebDriver driver = new ChromeDriver();
	  driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	  
	  driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
	  
	  Alert alert = driver.switchTo().alert();
	  
	  System.out.println(alert.getText());
	  
	  alert.accept();
	  
	  driver.quit();
	  
	  
	  
  }
}
