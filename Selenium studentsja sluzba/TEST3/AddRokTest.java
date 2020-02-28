package zadatakTEST3;


import static org.testng.Assert.assertTrue;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import zadatakPOM1.MenuPage;
import zadatakPOM1.RokPage;
import zadatakPOM1.RokTablePage;
import zadatakTEST1.BaseTest;

public class AddRokTest extends BaseTest {

	MenuPage menuP;
	RokPage rokP;
	RokTablePage rokTP;

	@BeforeClass
	public void setUp() {
		menuP = new MenuPage(driver);
		rokP = new RokPage(driver);
		rokTP = new RokTablePage(driver);
	}

	@Test
	public void addRok() {
		// odlazim na stranucu rokovi
		menuP.getEntitiesMenu().click();
		assertTrue(menuP.getRok().isDisplayed());
		menuP.getRok().click();

		// proveravam da li sam na stranici rokovi
		String expec = "IspitniRokovis";
		String act = rokTP.getTextMsg();
		assertTrue(act.contains(expec));

		// kreiranje roka
		rokTP.getBtnCreateEdit().click();
		// proveraam jel se forma pojavila
		assertTrue(rokP.getFormaRok().isDisplayed());
		// klik na create nastavnik
		rokP.createRok("Aprilski", "2016-04-15", "2016-04-22");

		// proveravam da li je kreiran
		String rok = rokTP.redMogRoka("Aprilski").getText();
		assertTrue(rok.contains("Aprilski Apr 15, 2016 Apr 22, 2016"));

	}

}
