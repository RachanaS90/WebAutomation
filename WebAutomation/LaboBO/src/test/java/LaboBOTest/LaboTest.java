package LaboBOTest;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import PageActions.Characteristicspage;
import PageActions.Formulapage;
import PageActions.Loginpage;
import PageActions.Volumepage;

public class LaboTest extends Basetest {

	@Test
	public void login()
	
	{		
		Loginpage loginpage= goToURL();
	    loginpage.login();
	}
	
	@Test
	public void saveCharacteristics() throws InterruptedException
	{
		Loginpage loginpage= goToURL();
		Characteristicspage Characteristicspage=loginpage.login();
		Characteristicspage.checkHomePage();
		Characteristicspage.selectCharacteristics();
		AssertJUnit.assertEquals(Characteristicspage.saveCentrale(), successMessage);
		AssertJUnit.assertEquals(Characteristicspage.saveMultipleCentrale(), popupheader);
	}
	
	@Test
	public void saveFormula() throws InterruptedException
	{
		Loginpage loginpage = goToFormulaLink();
		Formulapage formulapage = loginpage.formulalogin();
		AssertJUnit.assertEquals(formulapage.formulaSelection(), formulasuccessMessage);
	}
	
	@Test
	public void saveVolume() throws InterruptedException
	{
		saveCharacteristics();
		Volumepage volumepage = new Volumepage(driver);
		volumepage.saveVolume();
	}
}
