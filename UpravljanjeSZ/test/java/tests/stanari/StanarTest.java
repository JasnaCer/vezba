package tests.stanari;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pages.global.HomePage;
import pages.global.LoginPage;
import pages.stanari.StanarPage;
import pages.stanari.StanariPregledPage;
import pages.stanari.StanariRegistracijaPage;

public class StanarTest {
	public WebDriver driver;
	LoginPage loginP;
	HomePage homeP;
	StanariRegistracijaPage stanariRP;
	StanariPregledPage stanariPP;
	StanarPage stanarP;

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
		stanariPP = new StanariPregledPage(driver);
		stanarP = new StanarPage(driver);
	}

	@Test(priority = 0)
	public void LoginIredirekt() {
		loginP.logIn("admin@gmail.com", "Bar5slova");
		homeP.getStanari().click();
		// proveravam da li sam na stranici stanari
		String urlExpected = "http://localhost:8080/stanari";
		String urlActual = driver.getCurrentUrl();
		assertEquals(urlActual, urlExpected);
		stanariRP.getBtnPregled().click();
		// proveravam da li klik na dugme redirektuje na stranicu pregled
		String urlExp = "http://localhost:8080/stanari/pregled";
		String urlAct = driver.getCurrentUrl();
		assertEquals(urlAct, urlExp);
		stanariPP.getLinkStanarJJ().click();
		assertEquals(driver.getCurrentUrl(), "http://localhost:8080/stanar/4");
	}

	// proveravam da li su prikazani naslov stranice i ime i prezime isti kao i
	// ocekivani
	@Test(priority = 1)
	public void naslovImeCheck() {
		assertTrue(stanarP.getMsg().contains("Stanar"));
		assertTrue(stanarP.getImePrezime().contains("Janko Jankovic"));
	}

	// proveravam da li su prikazani adresa i broj u tabeli gde stanuje isti kao i ocekivani
	@Test(priority = 2)
	public void checkAddressNumberTabelaStanuje() {
		assertTrue(stanarP.getStanGdeStanujeTable().isDisplayed());
		assertTrue(stanarP.getStanGdeStanujeRed("Boska Buhe").getText().contains("Boska Buhe"));
		assertTrue(stanarP.getStanGdeStanujeRed("Boska Buhe").getText().contains("3"));
	}

	// proveravam da li je prikazana tabela i u tabeli gde je vlasnik prikazana ocekivana
	// adresa i broj stana
	@Test(priority = 3)
	public void checkAddressNumberTabelaVlasnik() {
		assertTrue(stanarP.getStanGdeJeVlasnikTable().isDisplayed());
		assertTrue(stanarP.getStanGdeJeVlasnikRed("Boska Buhe").getText().contains("Boska Buhe"));
		assertTrue(stanarP.getStanGdeJeVlasnikRed("Boska Buhe").getText().contains("3"));
	}

	// proveravam da li klikom na linkove u tabelama odlazim na dobre stranice
	@Test(priority = 4)
	public void linkRedirect() {
		 stanarP.getLinkAdresS().click();
		 assertEquals(driver.getCurrentUrl(), "http://localhost:8080/zgrada/1/stanovi");
		 // vratim se na stanar stranicu
	     homeP.getStanari().click(); 
	     stanariRP.getBtnPregled().click();   
	     stanariPP.getLinkStanarJJ().click();
	     assertTrue(stanarP.getImePrezime().contains("Janko Jankovic"));
		
	     stanarP.getLinkStanS().click();
		 assertEquals(driver.getCurrentUrl(), "http://localhost:8080/stan/4");
		 // vratim se na stanar stranicu
	     homeP.getStanari().click(); 
	     stanariRP.getBtnPregled().click();   
	     stanariPP.getLinkStanarJJ().click();
	     assertTrue(stanarP.getImePrezime().contains("Janko Jankovic"));
		
	     stanarP.getLinkAdresV().click();
		 assertEquals(driver.getCurrentUrl(), "http://localhost:8080/zgrada/1/stanovi");
		 // vratim se na stanar stranicu
	     homeP.getStanari().click(); 
	     stanariRP.getBtnPregled().click();   
	     stanariPP.getLinkStanarJJ().click();
	     assertTrue(stanarP.getImePrezime().contains("Janko Jankovic"));

	     stanarP.getLinkStanV().click();
	     assertEquals(driver.getCurrentUrl(), "http://localhost:8080/stan/4");
		
	}

	@AfterSuite
	public void closeSelenium() {
		// Shutdown the browser
		driver.close();
	}

}
