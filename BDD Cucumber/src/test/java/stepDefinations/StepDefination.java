package stepDefinations;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static io.restassured.RestAssured.*;

import java.io.IOException;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefination extends Utils {
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	static String placeId;
	TestDataBuild data = new TestDataBuild();

	@Given("Add Place Payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String address, String language) throws Exception {
		res = given().spec(requestSpecification()).body(data.addPlacePayload(name, address, language));
	}

	@When("User calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method) {
		
		APIResources resourceapi = APIResources.valueOf(resource);
		
		if(method.equalsIgnoreCase("POST"))
		response = res.when().post(resourceapi.getResource());
		else if(method.equalsIgnoreCase("GET"))
			response = res.when().post(resourceapi.getResource());
	}

	@Then("The api call got success with status code {int}")
	public void the_api_call_got_success_with_statuscode(Integer int1) {
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String value) {
		Assert.assertEquals(getJsonPath(response,key), value);
	}
	
	@Then("verify place_id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedName,String resource) throws IOException
	{
		placeId = getJsonPath(response, "place_id");
		res=given().spec(requestSpecification()).queryParam("place_id",placeId);
		user_calls_with_http_request(resource,"GET");
		String actualName = getJsonPath(response, "name");
		Assert.assertEquals(actualName, expectedName);
		
	}
	
	@Given("DeletePlace Payload")
	public void DeletePlace_Payload() throws IOException
	{
		res=given().spec(requestSpecification()).body(data.deletePlacePayload(placeId));
	}

}
