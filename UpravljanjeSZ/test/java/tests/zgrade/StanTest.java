package tests.zgrade;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pages.global.HomePage;
import pages.global.LoginPage;
import pages.zgrade.StanPage;
import pages.zgrade.ZgradaDodavanjePage;
import pages.zgrade.ZgradaPage;
import pages.zgrade.ZgradaPregledPage;

public class StanTest {
	public WebDriver driver;
	ZgradaDodavanjePage zgradaDP;
	LoginPage loginP;
	HomePage homeP;
	ZgradaPregledPage zgradaPP;
	ZgradaPage zgradaP;
	StanPage stanP;

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
		zgradaP = new ZgradaPage(driver);
		stanP = new StanPage(driver);
	}

	@Test(priority = 0)
	public void LoginIredirekt() {
		loginP.logIn("admin@gmail.com", "Bar5slova");
		homeP.getZgrade().click();
		zgradaDP.getBtnPregled().click();
		zgradaPP.getLinkAdresa().click();
		zgradaP.getBtnVlasnikStanar().click();
		// proveravam da li sam na stranici stan
		assertEquals(driver.getCurrentUrl(), "http://localhost:8080/stan/1");
		// proveravam da li sam na stranici preko naslova
		assertTrue(stanP.getMsg().equals("Stan"));
	}
	// proveravam da li je prikazani naslov isti kao i ocekivani
	@Test(priority = 1)
	public void naslovCheck() {
		assertTrue(stanP.getMsg().equals("Stan"));
	}
	// proveravam da li je prikazana adresa ista kao i ocekivana
	@Test(priority = 2)
	public void adresaCheck() {
		assertTrue(stanP.getTextAdresa().contains("Boska Buhe 42, Novi Sad"));
	}

	// SELEKT PRIKAZ
	@Test(priority = 3)
	public void selektPrikaz() {
		// proveraavam selekt prikazi
		// selektujem zeljeni prikaz
		Select select = stanP.getPrikaz();
		select.selectByValue("50");
		// pravim string od selektovane vrednosti
		WebElement option = select.getFirstSelectedOption();
		String text = option.getText();
		// proveravam da li je tacno da su jednake dobijena i ocekivana vrednost
		assertEquals(text, "50");
	}

	// FILTER
	@Test(priority = 4)
	public void imeKojePostoji() {
		stanP.setFilter("Gospodin Predsednik");
		assertTrue(stanP.isKorisnikPresent("Gospodin Predsednik"));
	}
	@Test(priority = 5)
	public void emailKojiPostoji() {
		stanP.setFilter("predSkup@gmail.com");
		assertTrue(stanP.isKorisnikPresent("predSkup@gmail.com"));
	}
	@Test(priority = 6)
	public void imeKojeNePostoji() {
		stanP.setFilter("milan");
		assertFalse(stanP.isKorisnikPresent("milan"));
	}
	// USLOV DA VLASNIK POLJE I TABELA STANARI BUDU PRAZNI zato ih brisem pre nastavka testa
	@Test(priority = 7)
	public void brisemVlasnikaStanare() {
		stanP.btnUkloniVlasnikaStranica().click();
		stanP.btnUkloniStanaraIzTabele().click();
		stanP.btnUkloniStanaraIzTabele().click();
		driver.get(driver.getCurrentUrl());
		
	}
	
	// proveravam da li je ocekivani ispis kada nisu postavljeni stanari
	// ivlasnik
	@Test(priority = 8)
	public void nemaVlasnikaStanara() {
		assertTrue(stanP.getTextVlasnik().contains("Nema vlasnika"));
		assertTrue(stanP.getTxtStanari().contains("Nema useljenih stanara!"));
		driver.get(driver.getCurrentUrl());
	}
	// DODAJEM STANARA I VLASNIKA IZ KORISNIKA
	@Test(priority = 9)
	public void vlasnikIzKorisnika() {
		assertTrue(stanP.btnPostaviZaVlasnikaK().isEnabled());
		stanP.btnPostaviZaVlasnikaK().click();
		assertTrue(stanP.msgAlert().getText().contains("Uspesno ste postavili vlasnika!"));
	}
	@Test(priority = 10)
	public void stanarIzKorisnika() {
		assertTrue(stanP.btnDodajUStanareK().isEnabled());
		stanP.btnDodajUStanareK().click();
		assertTrue(stanP.msgAlert().isDisplayed());
		assertTrue(stanP.msgAlert().getText().contains("Uspesno ste dodali stanara!"));
		driver.get(driver.getCurrentUrl());
	}
	// POKUSAVAM DA DODAM STANARA KOJI JE VEC U TABELI STANARI
	@Test(priority = 11)
	public void dodajPostojecegStanara() {
		// dugme treba da bude disejblovano
		assertFalse(stanP.btnDodajUStanareK().isEnabled());
	}
	// BRISEM STANARA I VLASNIKA
	@Test(priority = 12)
	public void brisanjeVlasnika() {
		assertTrue(stanP.btnUkloniVlasnikaStranica().isEnabled());
		stanP.btnUkloniVlasnikaStranica().click();
		assertTrue(stanP.msgAlert().isDisplayed());
		assertEquals(stanP.msgAlert().getText(), "Uspesno ste uklonili vlasnika!");
		assertTrue(stanP.getTextVlasnik().contains("Nema vlasnika"));
		
	}
	@Test(priority = 13)
	public void brisanjeStanara() {
		assertTrue(stanP.btnUkloniStanaraIzTabele().isEnabled());
		stanP.btnUkloniStanaraIzTabele().click();
		assertTrue(stanP.msgAlert().isDisplayed());
		assertEquals(stanP.msgAlert().getText(), "Uspesno ste uklonili stanara!");
		assertTrue(stanP.getTxtStanari().contains("Nema useljenih stanara!"));
		//refres jer prikaze u narednom testu sadrzaj ovog alerta i test padne
		driver.get(driver.getCurrentUrl());
		
		
	}
	 // IZ TABELE STANARI DODAJEM PREDSEDNIKA I VLASNIKA - uslov da tabela stanari nije prazna
	 @Test(priority = 14)
	 public void dodavanjeVlasnikaIzStanari() {
		 assertTrue(stanP.btnDodajUStanareK().isEnabled());
		 stanP.btnDodajUStanareK().click();
		 assertTrue(stanP.btnPostaviZaVlasnika().isEnabled());
		 stanP.btnPostaviZaVlasnika().click();
		 assertTrue(stanP.msgAlert().isDisplayed());
		 assertEquals(stanP.msgAlert().getText(), "Uspesno ste postavili vlasnika!");
		 
	 }
	
	 @Test(priority = 15)
	 public void dodavanjePredsednikaIzStanari() {
		 assertTrue(stanP.btnPostaviZaPredsednika().isEnabled());
		 stanP.btnPostaviZaPredsednika().click();
		 assertTrue(stanP.msgAlert().isDisplayed());
		 assertEquals(stanP.msgAlert().getText(), "Uspesno ste postavili predsednika zgrade!");
	 }

		@AfterSuite
		public void closeSelenium() {
			// Shutdown the browser
			driver.close();
		}
}
