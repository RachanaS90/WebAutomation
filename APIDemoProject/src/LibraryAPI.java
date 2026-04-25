import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Files.ReUsableMethods;
import Files.payloads;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class LibraryAPI {

	@Test(dataProvider="BookData")
	public void getAddBook(String isbn, String asile)
	{
		RestAssured.baseURI="http://216.10.245.166";
		
		 String resp  = given().header("Content-Type","application/json")
		.body(payloads.AddBook(isbn,asile))
		.when().post("Library/Addbook.php")
		.then().log().all().extract().response().asString();
		
		 JsonPath js = ReUsableMethods.rawToJson(resp);
		 
		 System.out.println(js.get("ID").toString());
	}
	
	@DataProvider(name="BoodData")
	
	public static Object[][] getdata()
	{
		return new Object[][] {{"hasda","2323"},{"asdas","3422"},{"asdas","23432"}};
	}
	
}
