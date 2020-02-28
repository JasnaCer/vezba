package zadatakTEST2;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import zadatakPOM1.HomePage;
import zadatakPOM1.LoginPage;
import zadatakPOM1.MenuPage;
import zadatakPOM1.NastavnikPage;
import zadatakPOM1.NastavnikTablePage;
import zadatakPOM1.PredmetPage;
import zadatakPOM1.PredmetTablePage;
import zadatakPOM1.StudentPage;
import zadatakPOM1.StudentTablePage;

public class Zadatak2TestAll {
	public WebDriver driver;
	HomePage homeP;
	LoginPage loginP;
	MenuPage menuP;
	PredmetTablePage predmetTP;
	PredmetPage predmetP;
	NastavnikTablePage nastavnikTP;
	NastavnikPage nastavnikP;
	StudentPage studentP;
	StudentTablePage studentTP;
	

	@BeforeSuite
	public void setupSelenium() {

		// instanciranje browsera
		System.setProperty("webdriver.gecko.driver", "geckodriver");
		driver = new FirefoxDriver();

		// navigacija na zeljenu stranicu
		driver.get("http://localhost:8080/#/");
		driver.manage().window().maximize();

		menuP = new MenuPage(driver);
		loginP = new LoginPage(driver);
		homeP = new HomePage(driver);
		predmetTP = new PredmetTablePage(driver);
		predmetP = new PredmetPage(driver);
		nastavnikTP = new NastavnikTablePage(driver);
		nastavnikP = new NastavnikPage(driver);
		studentP = new StudentPage(driver);
		studentTP = new StudentTablePage(driver);
	}

	@Test(priority = 0)
	public void login() {

		// klik na Account
		menuP.getAccountMenu().click();
		// proveravam da li se pojavio signin
		assertEquals(true, menuP.getSignUp().isDisplayed());
		// pronalazim sign in element u acouunt i klik
		menuP.getSignUp().click();

		// logujem se
		loginP.logIn("admin", "admin");

		// proveravam da li sam se ulogovala,
		// roveravam da su 2 stringa jednaka
		String expected = "You are logged in as user \"admin\".";
		String actual = homeP.getTextMsg();
		assertEquals(actual, expected);

		// moze i ovako proveravam da li je tacno da su 2 stringa jednaka
		// assertTrue(actual.equals(expected));
	}
	@Test(priority =1)
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
	@Test (priority=2)
	public void addStudent1() {
		// odlazim na stranucu studenti
		menuP.getEntitiesMenu().click();
		//proveravam da li se pojavio getStudent
		assertTrue(menuP.getStudent().isDisplayed());
		WebElement student = menuP.getStudent();
		student.click();
		
		// proveravam da li sam na stranici
		String expec = "Studentis";
		String act = studentTP.getTextMsg();
		assertTrue(act.equals(expec));

		// kreiranje studenta
		studentTP.getBtnCreateEdit().click();
		// proveraam jel se forma pojavila
		assertTrue(studentP.getFormaStudent().isDisplayed());
		// klik na create student
		studentP.createStudent("E1234", "Marko", "Markovic", "Novi Sad");
		
		//proveravam da li je kreiran
		String studa = studentTP.redMogSudenta("E1234").getText();
		assertTrue(studa.contains("E1234 Marko Markovic Novi Sad"));
	
	}
	@Test(priority=3)
	public void addStudent2() {
		
		// kreiranje drugog studenta
		studentTP.getBtnCreateEdit().click();
		// proveraam jel se forma pojavila
		assertTrue(studentP.getFormaStudent().isDisplayed());
		studentP.createStudent("E 5652", "Nikola", "Nikolic", "Beograd");
		
		//proveravam da li je kreiran
		
		String studa = studentTP.redMogSudenta("E 5652").getText();
		assertTrue(studa.contains("E 5652 Nikola Nikolic Beograd"));

	}
	@Test(priority=4)
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
	@Test(priority = 5)
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
	
	@Test(priority = 6)
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
	@Test(priority=7)
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
	

	@AfterSuite
	public void closeSelenium() {
		// Shutdown the browser
		driver.close();
	}

}
