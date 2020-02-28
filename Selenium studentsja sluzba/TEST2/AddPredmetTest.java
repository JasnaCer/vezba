package zadatakTEST2;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import zadatakPOM1.MenuPage;
import zadatakPOM1.PredmetPage;
import zadatakPOM1.PredmetTablePage;

import zadatakTEST1.BaseTest;

public class AddPredmetTest extends BaseTest {

	MenuPage menuP;
	PredmetPage predmetP;
	PredmetTablePage predmetTP;

	@BeforeClass
	public void setUp() {

		menuP = new MenuPage(driver);
		predmetP = new PredmetPage(driver);
		predmetTP = new PredmetTablePage(driver);
	}

	@Test
	public void addPredmet() {

		// odlazim na stranucu predmeti
		menuP.getEntitiesMenu().click();
		// proveravam da li se pojavio getpredmeti
		assertTrue(menuP.getPredmet().isDisplayed());
		WebElement predmet = menuP.getPredmet();
		predmet.click();

		// proveravam da li sam na stranici
		String expec = "Predmetis";
		String act = predmetTP.getTextMsg();
		assertTrue(act.equals(expec));

		predmetTP.getBtnCreateEdit().click();
		ArrayList<String> student = new ArrayList<String>();
		student.add(new String("Marko Markovic"));
		ArrayList<String> nastavnik = new ArrayList<String>();
		nastavnik.add(new String("Milan Markovic"));
		predmetP.createPredmet("Matematika", student, nastavnik);
		
		//proveravam da li je kreiran
		String predm = predmetTP.redMogPredmeta("Matematika").getText();
		assertTrue(predm.contains("Matematika Marko Markovic Milan Markovic"));
	}

}
