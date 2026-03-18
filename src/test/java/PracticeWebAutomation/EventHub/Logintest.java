package PracticeWebAutomation.EventHub;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class Logintest extends Basetest{
	
	@DataProvider(name="logindata")
	public Object[][] getUserDetails() {
		return new Object[][] {
			{"rachanapitale28@gmail.com","Mumbai@2026"}
		};
	}
	
	@Test(dataProvider="logindata")
	public Eventpage loginTest(String email, String password)
	{
		Loginpage loginpage = goToURL();
		return loginpage.userLogin(email, password);
	}
}
