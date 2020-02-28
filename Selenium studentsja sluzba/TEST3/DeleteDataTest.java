package zadatakTEST3;


import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import zadatakPOM1.MenuPage;
import zadatakPOM1.NastavnikPage;
import zadatakPOM1.NastavnikTablePage;
import zadatakPOM1.PredmetPage;
import zadatakPOM1.PredmetTablePage;
import zadatakPOM1.PrijavaPage;
import zadatakPOM1.PrijavaTablePage;
import zadatakPOM1.RokPage;
import zadatakPOM1.RokTablePage;
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
	PrijavaPage prijavaP;
	PrijavaTablePage prijavaTP;
	RokPage rokP;
	RokTablePage rokTP;

	@BeforeClass
	public void setUp() {

		menuP = new MenuPage(driver);
		studentP = new StudentPage(driver);
		studentTP = new StudentTablePage(driver);
		nastavnikP = new NastavnikPage(driver);
		nastavnikTP = new NastavnikTablePage(driver);
		predmetP = new PredmetPage(driver);
		predmetTP = new PredmetTablePage(driver);
		prijavaP = new PrijavaPage(driver);
		prijavaTP = new PrijavaTablePage(driver);
		rokP = new RokPage(driver);
		rokTP = new RokTablePage(driver);
	}

	// brisanje prijave
	@Test(priority = 0)
	public void deletePrijavu() {

		// brisem prijavu
		prijavaTP.deletePrijavaByNazivRoka("Aprilski");
		assertTrue(prijavaTP.getDeleteForma().isDisplayed());
		prijavaTP.getBttDelete().click();
		// proveravam da li je prijava izvrisana -
		assertTrue(prijavaTP.isPrijavaDeleted("Aprilski"));
	}
	@Test(priority = 1)
	public void deletePredmet() {
		
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
		
	//brisem predmet
		predmetTP.deletePredmetByNaziv("Matematika");
		assertTrue(predmetTP.getDeleteForma().isDisplayed());
		predmetTP.getBttDelete().click();
		assertTrue(predmetTP.isPredmetDeleted("Matematika"));
		
	}
	@Test(priority=2)
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
		assertTrue(nastavnikTP.isNastavnikDeleted("Milan"));
	
	}
	@Test(priority = 3)
	public void deleteStudents() {
		// odlazim na stranucu studenti
		menuP.getEntitiesMenu().click();
		WebElement student = menuP.getStudent();
		student.click();
		// proveravam da li sam na stranici
		String expec = "Studentis";
		String act = studentTP.getTextMsg();
		assertTrue(act.equals(expec));

		studentTP.deleteStudentByIndex("E1234");
		assertTrue(studentTP.getDeleteForma().isDisplayed());
		studentTP.getBttDelete().click();
		assertTrue(studentTP.isStudentDeleted("E1234"));
	}

	// brisanje roka
	@Test(priority = 4)
	public void deleteRok() {
		// odlazim na stranucu rokovi
		menuP.getEntitiesMenu().click();
		assertTrue(menuP.getRok().isDisplayed());
		menuP.getRok().click();

		// proveravam da li sam na stranici rokovi
		String expec = "IspitniRokovis";
		String act = rokTP.getTextMsg();
		assertTrue(act.contains(expec));
		// brisem rok
		rokTP.deleteRokByNaziv("Aprilski");
		assertTrue(rokTP.getDeleteForma().isDisplayed());
		rokTP.getBttDelete().click();
		//proveravam da li je rok izbrisan - ovo sam uradila po vasoj sugestiji za invisibilityOfElementLocated
		//u metodi isRokDelete prosledjujem naziv
		//u utility sam napravila metodu waitForElementInvisibility
		//koj ceka vraca true ako element nije prisutan na stranici
		//saceka interval vremena i tek onda vraca vrednost, sto omogucava da se asertacija ne odradi pre 
		// registrovanja da je lement uklonjen sa stranice
		//ovo je metoda da vam ne saljem celu stranicu
		
		/*public static boolean waitForElementInvisibility(WebDriver driver, By selector, int waitInterval) {
		boolean invisible = (new WebDriverWait(driver,waitInterval))
				.until(ExpectedConditions.invisibilityOfElementLocated(selector));
		return invisible;
		}*/
		assertTrue(rokTP.isRokDeleted("Aprilski"));
	}

}
