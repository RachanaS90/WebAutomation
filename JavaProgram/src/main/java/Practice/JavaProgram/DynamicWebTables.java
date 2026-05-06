package Practice.JavaProgram;

import org.openqa.selenium.chrome.ChromeDriver;

import com.sun.rowset.internal.Row;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicWebTables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		String actualcoursename = "Learn SQL in Practical + Database Testing from Scratch";
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@name='courses']//tr"));
		
		for (int i=1;i<rows.size();i++)
		{
			String coursename = rows.get(i).findElement(By.xpath(".//td[2]")).getText().trim();
			String courseprice = rows.get(i).findElement(By.xpath(".//td[3]")).getText().trim();
			
			if(coursename.equalsIgnoreCase(actualcoursename))
			{
				System.out.println("Course name is : " + coursename + " and Price is : " + courseprice);
			}
		}
		
		
		String coursename1 = "WebServices / REST API Testing with SoapUI";
		
		String xpath = "//td[text()='" + coursename1 +"']/following-sibling::td";
		
		WebElement price = driver.findElement(By.xpath(xpath));
		System.out.println("Course name is : " + coursename1);
		System.out.println("And Price is : " + price.getText().trim());
		
		
		driver.quit();
	}

}
