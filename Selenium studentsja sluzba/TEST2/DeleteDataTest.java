package zadatakTEST2;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import zadatakPOM1.MenuPage;
import zadatakPOM1.NastavnikPage;
import zadatakPOM1.NastavnikTablePage;
import zadatakPOM1.PredmetPage;
import zadatakPOM1.PredmetTablePage;
import zadatakPOM1.StudentPage;
import zadatakPOM1.StudentTablePage;
import zadatakTEST1.BaseTest;

public class DeleteDataTest extends BaseTest {

	MenuPage menuP;
	StudentPage studentP;
	StudentTablePage studentTP;
	NastavnikPage nastavnikP;
	NastavnikTablePage nastavnikTP;
	PredmetPage predmetP;
	PredmetTablePage predmetTP;

	@BeforeClass
	public void setUp() {

		menuP = new MenuPage(driver);
		studentP = new StudentPage(driver);
		studentTP = new StudentTablePage(driver);
		nastavnikP = new NastavnikPage(driver);
		nastavnikTP = new NastavnikTablePage(driver);
		predmetP = new PredmetPage(driver);
		predmetTP = new PredmetTablePage(driver);
	}
	@Test(priority = 0)
	public void deletePredmet() {
		
//		// odlazim na stranucu predmeti
//		menuP.getEntitiesMenu().click();
//		// proveravam da li se pojavio getpredmeti
//		assertTrue(menuP.getPredmet().isDisplayed());
//		WebElement predmet = menuP.getPredmet();
//		predmet.click();
//
//		// proveravam da li sam na stranici
//		String expec = "Predmetis";
//		String act = predmetTP.getTextMsg();
//		assertTrue(act.equals(expec));
		
	//brisem predmet
		predmetTP.deletePredmetByNaziv("Matematika");
		assertTrue(predmetTP.getDeleteForma().isDisplayed());
		predmetTP.getBttDelete().click();
		assertFalse(predmetTP.isPredmetPresent("Matematika"));
		
	}
	@Test(priority=1)
	public void deleteNastavnika() {
		// odlazim na stranucu nastavnik
		menuP.getEntitiesMenu().click();
		assertTrue(menuP.getNastavnik().isDisplayed());
		menuP.getNastavnik().click();

		// proveravam da li sam na stranici nastavnici
		String expec = "Nastavnicis";
		String act = nastavnikTP.getTextMsg();
		assertTrue(act.equals(expec));
		
	//brisem nastavnika
		nastavnikTP.deleteNastavnikByIme("Milan");
		assertTrue(nastavnikTP.getDeleteForma().isDisplayed());
		nastavnikTP.getBttDelete().click();
		assertTrue(nastavnikTP.getNastavniciTable().isDisplayed());//ovde moram da usporim test sa pozivom tabele
		//ako to ne uradim pukne test na asertaciji, ne uhvati da je izbrisan
		//samo u slucaju nastavnika, u ostalim testovima radi dobro
		assertFalse(nastavnikTP.isNastavnikPresent("Milan"));
	}
	@Test(priority = 2)
	public void deleteStudents() {
		// odlazim na stranucu studenti
		menuP.getEntitiesMenu().click();
		WebElement student = menuP.getStudent();
		student.click();
		// proveravam da li sam na stranici
		String expec = "Studentis";
		String act = studentTP.getTextMsg();
		assertTrue(act.equals(expec));

		studentTP.deleteStudentByIndex("E 5652");
		// pojavi se delete forma
		assertTrue(studentTP.getDeleteForma().isDisplayed());
		// kliknem na delete dugme
		studentTP.getBttDelete().click();
		// proveravm da li su izbrisani
		assertFalse(studentTP.isStudentPresent("E 5652"));
		// isto i za drugog radim
		studentTP.deleteStudentByIndex("E1234");
		assertTrue(studentTP.getDeleteForma().isDisplayed());
		studentTP.getBttDelete().click();
		assertFalse(studentTP.isStudentPresent("E1234"));
	}

	
}
