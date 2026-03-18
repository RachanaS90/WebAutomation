package PracticeWebAutomation.EventHub;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;

public class Eventtest extends Logintest{
	
	Eventpage eventpage;
	
	Bookingpage bookingpage;
	
	@Test(dataProvider="logindata")
	public void selectEvent(String email, String password)
	{	
		eventpage = loginTest(email, password);
		eventpage.searchEvent();
		String selectedCategory = eventpage.selectCategory("Festival");
        Assert.assertEquals("Festival", selectedCategory);
        bookingpage = eventpage.navigateToBookingPage();
	}
	
	@Test(dependsOnMethods = "selectEvent")
	public void bookEvents()
	{
		String actulmessage = bookingpage.addDetails();
		String expectedmessage = "Booking Confirmed!";
		Assert.assertTrue(actulmessage.contains(expectedmessage));
	}
}
