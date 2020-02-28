package zadatakTEST1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import zadatakPOM1.HomePage;
import zadatakPOM1.LoginPage;
import zadatakPOM1.MenuPage;
import zadatakPOM1.StudentPage;
import zadatakPOM1.StudentTablePage;

public class LoginTest {

	public WebDriver driver;
	HomePage homeP;
	LoginPage loginP;
	MenuPage menuP;
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
		// proveravam da su 2 stringa jednaka
		String expected = "You are logged in as user \"admin\".";
		String actual = homeP.getTextMsg();
		assertEquals(actual, expected);

		// moze i ovako proveravam da li je tacno da su 2 stringa jednaka
		// assertTrue(actual.equals(expected));
	}

	@Test(priority = 1)
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

		// proveravam da li je kreiran
		
		String studa = studentTP.redMogSudenta("E1234").getText();
		assertTrue(studa.contains("E1234 Marko Markovic Novi Sad"));
	}

	@Test(priority = 2)
	public void addStudent2() {

		// kreiranje drugog studenta
		studentTP.getBtnCreateEdit().click();
		// proveraam jel se forma pojavila
		assertTrue(studentP.getFormaStudent().isDisplayed());
		studentP.createStudent("E 5652", "Nikola", "Nikolic", "Beograd");

		// proveravam da li je kreiran
	
		String studa = studentTP.redMogSudenta("E 5652").getText();
		assertTrue(studa.contains("E 5652 Nikola Nikolic Beograd"));

	}

	@Test(priority = 3)
	public void editStudent() {

		// PROVERAVAM DA LI POSTOJI STUDENT SA INDEKSOM
		assertTrue(studentTP.isStudentPresent("E 5652"));

		// pozivam metodu za edit
		studentTP.editStudenta("E 5652");
		// proveravam forma da li se pojavila
		assertTrue(studentP.getFormaStudent().isDisplayed());
		// menjam podatak
		studentP.setGrad("Kraljevo");
		// proveravam da li je podatak izmenjen
		studentP.getBtnSave().click();

		String studa = studentTP.redMogSudenta("E 5652").getText();
		// tvrdim da postoji red koji sadrzi broj indeksa
		assertTrue(studa.contains("E 5652 Nikola Nikolic Kraljevo"));

	}

	@Test(priority = 4)
	public void deleteStudents() {

		//kliknem na delete u redu u kome je student
		studentTP.deleteStudentByIndex("E 5652");
		//pojavi se delete forma
		assertTrue(studentTP.getDeleteForma().isDisplayed());
		//kliknem na delete dugme
		studentTP.getBttDelete().click();
		//proveravm da li su izbrisani
		assertFalse(studentTP.isStudentPresent("E 5652"));
		//isto i za drugog radim
		studentTP.deleteStudentByIndex("E1234");
		assertTrue(studentTP.getDeleteForma().isDisplayed());
		studentTP.getBttDelete().click();
		assertFalse(studentTP.isStudentPresent("E1234"));
	}

	@Test(priority = 5)
	public void logOut() {
		menuP.getAccountMenu().click();
		// proveravam da li se pojavio signin
		assertEquals(true, menuP.getLogOut().isDisplayed());
		// pronalazim sign in element u acouunt i klik
		menuP.getLogOut().click();

		// proveravam da li sam se izlogovala,
		// proveravam da su 2 stringa jednaka
		String expected = "This is your homepage";
		String actual = homeP.getHomePageMsg();
		assertEquals(actual, expected);
	}

	@AfterSuite
	public void closeSelenium() {
		// Shutdown the browser
		driver.close();
	}

}