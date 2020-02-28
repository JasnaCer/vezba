package tests.zgrade;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pages.global.HomePage;
import pages.global.LoginPage;
import pages.zgrade.ZgradaDodavanjePage;
import pages.zgrade.ZgradaPregledPage;

public class ZgradaDodavanjeTest {
	public WebDriver driver;
	ZgradaDodavanjePage zgradaDP;
	LoginPage loginP;
	HomePage homeP;
	ZgradaPregledPage zgradaPP;

	@BeforeSuite
	public void setupSelenium() {
		// instanciranje browsera
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver = new ChromeDriver();
		// navigacija na zeljenu stranicu
		driver.get("http://localhost:8080");
		// uveceavam window
		driver.manage().window().maximize();

		// instanciram potrebne stranice
		zgradaDP = new ZgradaDodavanjePage(driver);
		loginP = new LoginPage(driver);
		homeP = new HomePage(driver);
		zgradaPP = new ZgradaPregledPage(driver);
	}

	@Test(priority = 0)
	public void LoginIredirekt() {
		loginP.logIn("admin@gmail.com", "Bar5slova");
		homeP.getZgrade().click();
		// proveravam da li sam na stranici zgrade
		String urlExpected = "http://localhost:8080/zgrade";
		String urlActual = driver.getCurrentUrl();
		assertEquals(urlActual, urlExpected);
	}
	@Test(priority = 1)
	public void dodavanjeZgradeUspesno() {
		//uslov za uspesnost testa je da se test pokrece prvi put i da ne postoji dodata zgrada sa istim podacima
		zgradaDP.dodajZgradu("Kraljevo", "Niska", "3", "2");
		String expected = "Uspesno ste dodali zgradu!";
		String actual = zgradaDP.getMsgDodata().getText();
		assertEquals(actual, expected);
		//provera da li se zgrada vidi u tabeli na stranici pregledi
		zgradaPP.isZgradaPresent("vnm ccc");
	}
	
	@Test(priority = 2)
	public void dodavanjeZgradePraznaPolja() {
		zgradaDP.dodajZgradu("", "", "", "");
		String expected = "Ovo polje ne sme biti prazno!";
		//poruku smestam u string
		String actual = zgradaDP.getMsgMesto().getText();
		//poredim ocekivanu i dobijenu poruku
		assertEquals(actual, expected);
		//isto radim i za ostala polja
		String actual1 = zgradaDP.getMsgUlica().getText();
		assertEquals(actual1, expected);
		String actual2 = zgradaDP.getMsgBroj().getText();
		assertEquals(actual2, expected);
		//izlazim iz polja broj stanova da bi se pojavila poruka 
		zgradaDP.setBroj("");
		String actual3 = zgradaDP.getMsgBrojStanova().getText();
		assertEquals(actual3, expected);
		//dugme dodajte nije omoguceno jer nisu popunjena polja
		assertFalse(zgradaDP.getBtnDodajte().isEnabled());
	}
	@Test(priority = 3)
	public void dodavanjeZgradeKojaPostoji() {
		zgradaDP.dodajZgradu("Novi Sad", "Boska Buhe", "42", "5");
		String expected = "Vec postoji zgrada na toj adresi!";
		String actual = zgradaDP.getMsgZgradaVecPostoji().getText();
		assertEquals(actual, expected);
	}
	@Test(priority = 4)
	public void resetBttPraznaPolja() {
		zgradaDP.setMesto("Novi Sad");
		zgradaDP.setUlica("Borska");
		zgradaDP.setBroj("5");
		zgradaDP.setBrojStanova("6");
		zgradaDP.getBtnResetujte();
		assertEquals(zgradaDP.getMesto().getText(),"");
		assertEquals(zgradaDP.getUlica().getText(),"");
		assertEquals(zgradaDP.getBroj().getText(),"");
		assertEquals(zgradaDP.getBrojStanova().getText(),"");
	}
	@Test(priority = 5)
	public void bttDodavanjePrikazanoOmoguceno() {
		zgradaDP.getBtnDodavanje().isDisplayed();
		zgradaDP.getBtnDodavanje().isEnabled();
	}
	@Test(priority = 6)
	public void bttDodavanje() {
		zgradaDP.getBtnDodavanje().click();
		//proveravam da li klik na dugme redirektuje na stranicu dodavanje
		String urlExpected = "http://localhost:8080/zgrade/dodavanje";
		String urlActual = driver.getCurrentUrl();
		assertEquals(urlActual, urlExpected);
	}
	
	@Test(priority = 7)
	public void bttPregledPrikazanoOmoguceno() {
		zgradaDP.getBtnPregled().isDisplayed();
		zgradaDP.getBtnPregled().isEnabled();
	}

	@Test(priority = 8)
	public void bttPregled() {
		zgradaDP.getBtnPregled().click();
		//proveravam da li klik na dugme redirektuje na stranicu pregled
		String urlExpected = "http://localhost:8080/zgrade/pregled";
		String urlActual = driver.getCurrentUrl();
		assertEquals(urlActual, urlExpected);
	}
	
	// zatvaratnje browser-a kad se izvrse testovi
	@AfterSuite
	public void closeSelenium() {
		// Shutdown the browser
		driver.close();
	}
}
