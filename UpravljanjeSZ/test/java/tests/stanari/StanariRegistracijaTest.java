package tests.stanari;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pages.global.HomePage;
import pages.global.LoginPage;
import pages.stanari.StanariRegistracijaPage;


public class StanariRegistracijaTest {
	public WebDriver driver;
	LoginPage loginP;
	HomePage homeP;
	
	StanariRegistracijaPage stanariRP;

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
		loginP = new LoginPage(driver);
		homeP = new HomePage(driver);
		stanariRP = new StanariRegistracijaPage(driver);
	}

	@Test(priority = 0)
	public void LoginIredirekt() {
		loginP.logIn("admin@gmail.com", "Bar5slova");
		homeP.getStanari().click();
		// proveravam da li sam na stranici zgrade
		String urlExpected = "http://localhost:8080/stanari";
		String urlActual = driver.getCurrentUrl();
		assertEquals(urlActual, urlExpected);
	}
	@Test(priority = 0)
	public void uspesnaRegistracija() {
		 //registracija stanara sa ispravnim podacima
		stanariRP.registracija("mirko21@gmail.com", "Bar5slova", "Mirko", "Mirkovic");
		// proveravam da li je uspesno registrovan
		assertEquals(stanariRP.getMsgAlert().getText(),"Uspesno ste registrovali stanara!");
	}
	@Test(priority = 1)
	public void registracijaPraznaPolja() {
		 //registracija stanara sa ispravnim podacima
		stanariRP.registracija("", "", "", "");
		String expected = "Ovo polje ne sme biti prazno!";
		//poruku smestam u string
		String actual = stanariRP.getMsgEmail().getText();
		//poredim ocekivanu i dobijenu poruku
		assertEquals(actual, expected);
		//isto radim i za ostala polja
		String actual1 = stanariRP.getMsgLozinka().getText();
		assertEquals(actual1, expected);
		String actual2 = stanariRP.getMsgIme().getText();
		assertEquals(actual2, expected);
		//izlazim iz polja broj stanova da bi se pojavila poruka 
        stanariRP.setIme("");
        String actual3 = stanariRP.getMsgPrezime().getText();
		assertEquals(actual3, expected);
		//dugme dodajte nije omoguceno jer nisu popunjena polja
		assertFalse(stanariRP.btnRegistrujte().isEnabled());
	}
	@Test(priority = 2)
	public void registracijaNeispravanEmail() {
		 //registracija stanara sa neispravnim email-om
		stanariRP.registracija("milfegmail", "Bar5slova", "Mile", "Milic");
		String expected = "Neispravna email adresa!";
		//poruku smestam u string
		String actual = stanariRP.getMsgEmail().getText();
		//poredim ocekivanu i dobijenu poruku
		assertEquals(actual, expected);
	}
	@Test(priority = 3)
	public void registracijaLozinkaKracaOd6() {
		//registracija stanara sa neispravnom lozinkom
		stanariRP.registracija("milfegmail", "Bar5s", "Mile", "Milic");
		String expected = "Neispravna lozinka!";
		//poruku smestam u string
		String actual = stanariRP.getMsgLozinka().getText();
		//poredim ocekivanu i dobijenu poruku
		assertEquals(actual, expected);
	}
	@Test(priority = 4)
	public void registracijaLozinkaBezVelikihSlova() {
		 //registracija stanara sa neispravnom lozinkom
		stanariRP.registracija("milfegmail", "bar5slova", "Mile", "Milic");
		String expected = "Neispravna lozinka!";
		//poruku smestam u string
		String actual = stanariRP.getMsgLozinka().getText();
		//poredim ocekivanu i dobijenu poruku
		assertEquals(actual, expected);
	}
	@Test(priority = 5)
	public void registracijaLozinkaBezMalihSlova() {
		 //registracija stanara sa neispravnom lozinkom
		stanariRP.registracija("milfegmail", "BAR5SLOVA", "Mile", "Milic");
		String expected = "Neispravna lozinka!";
		//poruku smestam u string
		String actual = stanariRP.getMsgLozinka().getText();
		//poredim ocekivanu i dobijenu poruku
		assertEquals(actual, expected);
	}
	@Test(priority = 6)
	public void registracijaLozinkaBezBrojeva() {
		 //registracija stanara sa neispravnom lozinkom
		stanariRP.registracija("milfegmail", "BARrSLOVA", "Mile", "Milic");
		String expected = "Neispravna lozinka!";
		//poruku smestam u string
		String actual = stanariRP.getMsgLozinka().getText();
		//poredim ocekivanu i dobijenu poruku
		assertEquals(actual, expected);
	}
	@Test(priority = 7)
	public void registracijaPostojecegKorisnika() {
		 //registracija stanara koji je vec registrovan
		stanariRP.registracija("mirko21@gmail.com", "Bar5slova", "Mirko", "Mirkovic");
		//poredim ocekivanu i dobijenu poruku
		assertTrue(stanariRP.getMsgAlert().getText().contains("je zauzeta"));
	}
	@Test(priority = 8)
	public void resetBttPraznaPolja() {
		//klik na reset treba da ocisti polja
		stanariRP.setEmail("dadadda");
		stanariRP.setLozinka("gfgfgf");
		stanariRP.setIme("dada");
		stanariRP.setPrezime("fdfdffd");
		stanariRP.btnResetujte();
		assertEquals(stanariRP.getEmail().getText(),"");
		assertEquals(stanariRP.getLozinka().getText(),"");
		assertEquals(stanariRP.getIme().getText(),"");
		assertEquals(stanariRP.getPrezime().getText(),"");
	}
	@Test(priority = 9)
	public void bttRegistracija() {
		stanariRP.getBtnRegistracija().click();
		//proveravam da li klik na dugme redirektuje na stranicu registracija
		assertEquals(driver.getCurrentUrl(), "http://localhost:8080/stanari/registracija");
	}
	@Test(priority = 10)
	public void bttPregled() {
		stanariRP.getBtnPregled().click();
		//proveravam da li klik na dugme redirektuje na stranicu pregled
		String urlExpected = "http://localhost:8080/stanari/pregled";
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
