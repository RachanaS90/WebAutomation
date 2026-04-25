import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class BugTest {

	@Test
	public void createBug()
	{
		RestAssured.baseURI = "https://rahulshettyacademy-team.atlassian.net/";
		
		given().header("Content-Type","application/json").header("Authorization","Basic bWVudG9yQHJhaHVsc2hldHR5YWNhZGVteS5jb206QVRBVFQzeEZmR0YwdFNlOHYzNUtILWQtU3U4NUFMckIyTjdDNXIwY0pJU0djdFIwRFBybUhfZjVlUmg4dE5UUVV6UVp1dTFkMXJHdkRjUzNHRnV4TVE4WklSNU9tdFlPbUszLUxBbVU4OEFTM3JrOGkwODFSYV9kQTlPQ3J5QjRERXlFWldJYXpwWGw3VDFTWnBLY0ZOSDBucjVBMUtLQ3FuWVBldzFLR2JSMWowa2JFdGVNVFZFPUZCMzhFM0JB")
		.body("{\\n\"+\"\\\"fields\\\": {\\n\"+ \"       \\\"project\\\":\\n\"				+ \"       {\\n\"				+ \"          \\\"key\\\": \\\"SCRUM\\\"\\n\"				+ \"       },\\n\"				+ \"       \\\"summary\\\": \\\"Website items are not working- automation Rest Assured\\\",\\n\"				+ \"       \\\"issuetype\\\": {\\n\"				+ \"          \\\"name\\\": \\\"Bug\\\"\\n\"				+ \"       }\\n\"				+ \"   }\\n\"				+ \"}")
		.log().all()
		.post("rest/api/3/issue")
		.then().log().all().assertThat().statusCode(200).extract().response().toString();
	}
}
