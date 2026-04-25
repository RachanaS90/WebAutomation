import Files.payloads;
import io.restassured.path.json.JsonPath;

public class SumValidation {

	
	public static void main(String[] args) 
	{
		JsonPath js = new JsonPath(payloads.CoursePrice());
		int count = js.getInt("courses.size()");
		System.out.println(count);
	int sum =0;
		for(int i=0;i<count;i++)
		{
			int price = js.getInt("courses["+i+"].price");
		//	System.out.println(price);
			int copies = js.getInt("courses["+i+"].copies");
			int amount = price * copies;
			System.out.println(amount);
			sum =sum+amount;
		}
		System.out.println(sum);
	}

}
