package stepDefinations;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@DeletePlace")
	public void beforeScenario() throws Exception
	{
		StepDefination step = new StepDefination();
		if(StepDefination.placeId==null)
		{
		step.add_place_payload_with("Test", "India", "English");
		step.user_calls_with_http_request("AddPlaceAPI", "POST");
		step.verify_place_id_created_maps_to_using("Test", "");
		}
	}
		
	
}
