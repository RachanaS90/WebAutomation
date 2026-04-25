
import org.testng.Assert;

import Files.payloads;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {
		
		JsonPath js = new JsonPath(payloads.CoursePrice());
		
		int count = js.getInt("courses.size()");
		System.out.println(count);
	
	    // Print purchase amount	
		int purchasevalue = js.get("dashboard.purchaseAmount");
		System.out.println(purchasevalue);
		
		//Print all course title and prices

		String courselist = "";
		int price = 0;
		for (int i=0;i<count;i++)
		{
			courselist = js.get("courses["+i+"].title");
			price = js.get("courses["+i+"].price");
			System.out.println(courselist +"-"+ price );
		}
				
		//Print first course
		String title = js.get("courses[2].title");
		System.out.println(title);
		
        // Print number of copies for any 1 course
		int copies = 0;
		for (int j=0;j<count;j++)
		{
			courselist = js.get("courses["+j+"].title");
			if(courselist.equalsIgnoreCase("RPA"))
			{
				copies = js.get("courses["+j+"].copies");
				System.out.println(courselist+"-"+copies);
				break;
			}
		}
		
		//Print sum of all courses price matches with purchase amount
		int sum= 0;
		for(int i=0;i<count;i++)
		{
			int price1 = js.get("courses["+i+"].price");
			int copies1 = js.get("courses["+i+"].copies");
			sum = sum + (price1*copies1);
		}
		System.out.println(sum);
		
		Assert.assertEquals(sum,purchasevalue);
		
	}

}
