Feature: validating Place API's

@AddPlace
Scenario Outline: Verify if place is successfully added using AddPlace API
Given Add Place Payload with "<name>" "<address>" "<language>"
When User calls "AddPlaceAPI" with "POST" http request
Then The api call got success with status code 200
And "status" in response body is "OK"
And verify place_id created maps to "<name>" using "getPlaceAPI"

Examples:
   |name | address | language |
   |Time Sqaure| Marol | English|
#   |The Leela | Mumbai | French |


@DeletePlace
Scenario: Verify if Delete Place API functionality is working
Given DeletePlace Payload
When User calls "deletePlaceAPI" with "POST" http request
Then The api call got success with status code 200
And "status" in response body is "OK"