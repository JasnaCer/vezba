package zadatakTEST2;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import zadatakPOM1.MenuPage;
import zadatakPOM1.NastavnikPage;
import zadatakPOM1.NastavnikTablePage;

import zadatakTEST1.BaseTest;

public class AddNastavnikTest extends BaseTest{

	MenuPage menuP;
	NastavnikTablePage nastavnikTP;
	NastavnikPage nastavnikP;

	@BeforeClass
	public void setUp() {
		
		menuP = new MenuPage(driver);
		nastavnikTP = new NastavnikTablePage(driver);
		nastavnikP = new NastavnikPage(driver);
	}
	@Test
	public void addNastavnik() {
		// odlazim na stranucu nastavnici
		menuP.getEntitiesMenu().click();
		assertTrue(menuP.getNastavnik().isDisplayed());
		menuP.getNastavnik().click();
		
		// proveravam da li sam na stranici nastavnici
		String expec = "Nastavnicis";
		String act = nastavnikTP.getTextMsg();
		assertTrue(act.equals(expec));
		
		// kreiranjenastavnika
		nastavnikTP.getBtnCreateEdit().click();
		// proveraam jel se forma pojavila
		assertTrue(nastavnikP.getFormaNastavnik().isDisplayed());
		// klik na create nastavnik
		nastavnikP.createNastavnik("Milan", "Markovic", "Profesor");
		
	
		//proveravam da li je kreiran
		
		String nast = nastavnikTP.redMogNastavnika("Milan").getText();
		assertTrue(nast.contains("Milan Markovic Profesor"));
	
	}	
}
