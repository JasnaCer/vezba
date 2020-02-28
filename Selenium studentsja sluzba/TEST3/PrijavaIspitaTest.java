package zadatakTEST3;

import static org.testng.Assert.assertTrue;



import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import zadatakPOM1.MenuPage;
import zadatakPOM1.PrijavaPage;
import zadatakPOM1.PrijavaTablePage;
import zadatakTEST1.BaseTest;

public class PrijavaIspitaTest extends BaseTest{
	MenuPage menuP;
	PrijavaPage prijavaP;
	PrijavaTablePage prijavaTP;
	
	
	@BeforeClass
	public void setUp() {
		menuP = new MenuPage(driver);
		prijavaP = new PrijavaPage(driver);
		prijavaTP = new PrijavaTablePage(driver);
	}
	
	@Test
	public void addPrijavu() {
		// odlazim na stranucu prijave
		menuP.getEntitiesMenu().click();
		assertTrue(menuP.getPrijava().isDisplayed());
		menuP.getPrijava().click();

		// proveravam da li sam na stranici prijave
		String expec = "IspitnePrijaves";
		String act = prijavaTP.getTextMsg();
		assertTrue(act.contains(expec));

		// kreiranje prijave
		prijavaTP.getBtnCreateEdit().click();
		// proveraam jel se forma pojavila
		assertTrue(prijavaP.getFormaPrijava().isDisplayed());
		// klik na create student
		prijavaP.createPrijavu("50", "50", "Aprilski", "E1234 Marko Markovic", "Matematika");
		// proveravam da li je kreirana	
		assertTrue(prijavaTP.isPrijavaPresent("Aprilski"));
		
	}

	
}
