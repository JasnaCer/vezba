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
import pages.zgrade.ZgradaDodavanjePage;
import pages.zgrade.ZgradaPage;
import pages.zgrade.ZgradaPregledPage;

public class ZgradaTest {

	public WebDriver driver;
	ZgradaDodavanjePage zgradaDP;
	LoginPage loginP;
	HomePage homeP;
	ZgradaPregledPage zgradaPP;
	ZgradaPage zgradaP;

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
	}

	@Test(priority = 0)
	public void LoginIredirekt() {
		loginP.logIn("admin@gmail.com", "Bar5slova");
		homeP.getZgrade().click();
		zgradaDP.getBtnPregled().click();
		// proveravam da li sam na stranici zgrade/pregled
		String urlExpected = "http://localhost:8080/zgrade/pregled";
		String urlActual = driver.getCurrentUrl();
		assertEquals(urlActual, urlExpected);
		// kliknem na link adresa, poredim stvarnu i ocekivanu adresu
		zgradaPP.getLinkAdresa().click();
		String urlExp = "http://localhost:8080/zgrada/1/stanovi";
		String urlAct = driver.getCurrentUrl();
		assertEquals(urlAct, urlExp);
		// proveravam da li sam na stranici preko naslova Zgrada
		String expec = "Zgrada";
		String act = zgradaP.getTextMsg();
		assertTrue(act.equals(expec));
	}
	// proveravam da li je prikazani naslov  isti kao i ocekivani
		@Test(priority = 1)
		public void naslovCheck() {
			assertTrue(zgradaP.getTextMsg().equals("Zgrada"));
		}

	// proveravam da li je prikazana adresa ista kao i ocekivana
	@Test(priority = 2)
	public void adresaCheck() {
		assertTrue(zgradaP.getTextAdresa().contains("Boska Buhe 42, Novi Sad"));
	}

	// proveravam da li je prikazani predsednik isti kao i ocekivani
	@Test(priority = 3)
	public void predsednikCheck() {
		assertTrue(zgradaP.getTextPredsednik().contains("Gospodin Predsednik "));
	}
	@Test(priority = 4)
	public void tabelaVlasniciStanari() {
	 // proveravam da li je tabela prikazana
	assertTrue(zgradaP.getStanoviTable().isDisplayed());
}
	@Test(priority = 5)
	public void selektPtikazi() {
		// proveraavam selekt prikazi
		// selektujem zeljeni prikaz
		Select select = zgradaPP.getPrikaz();
		select.selectByValue("50");
		// pravim string od selektovane vrednosti
		WebElement option = select.getFirstSelectedOption();
		String text = option.getText();
		// proveravam da li je tacno da su jednake dobijena i ocekivana vrednost
		assertEquals(text, "50");

	}

	// proveravam da li klik na obavestenja tab redirektuje na stranicu
	// obavestenja
	@Test(priority = 6)
	public void redirektObaveztenja() {
		zgradaP.getObavestenjaTab().click();
		String urlExp = "http://localhost:8080/zgrada/1/obavestenja";
		String urlAct = driver.getCurrentUrl();
		assertEquals(urlAct, urlExp);
	}

	// proveravam da li klik na predlozi i tacke tab redirektuje na stranicu
	// predlozi i tacke
	@Test(priority = 7)
	public void redirektPredloziTacke() {
		zgradaP.getPredloziTab().click();
		String urlExp = "http://localhost:8080/zgrada/1/tacke";
		String urlAct = driver.getCurrentUrl();
		assertEquals(urlAct, urlExp);
	}

	// proveravam da li klik na sastanci tab redirektuje na stranicu
	// sastanci
	@Test(priority = 8)
	public void redirektSastanci() {
		zgradaP.getSastanciTab().click();
		String urlExp = "http://localhost:8080/zgrada/1/sastanci";
		String urlAct = driver.getCurrentUrl();
		assertEquals(urlAct, urlExp);
	}
	// proveravam da li klik na kvarovi tab redirektuje na stranicu kvarovi i da li je cek box inicijalo ne cekiran
	@Test(priority = 9)
	public void redirektKvarovi() {
		zgradaP.getKvaroviTab().click();
		String urlExp = "http://localhost:8080/zgrada/1/kvarovi";
		String urlAct = driver.getCurrentUrl();
		assertEquals(urlAct, urlExp);
		//proveravam cekboks
		assertFalse(zgradaP.getCbZavrseniKvarovi().isSelected());
		//vracam se na stranicu stanovi
		zgradaP.getStanoviTab().click();
	}
	@Test(priority = 10)
	public void redirektStanar() {
		 // proveravam da li klik na link Predsednik redirektuje na stranicu Stanar
		zgradaP.getLinkPredsednik().click();
		String urlExp = "http://localhost:8080/stanar/2";
		String urlAct = driver.getCurrentUrl();
		assertEquals(urlAct, urlExp);
		//vracam se na stranicu zgrada zbog sledeceg testa
		homeP.getZgrade().click();
		zgradaDP.getBtnPregled().click();
		zgradaPP.getLinkAdresa().click();
		
	}

	@Test(priority = 11)
	public void dugmeVlasnikIStanari() {
		 // proveravam da li je dugme prikazano i omoguceno i da li redirektuje na stranicu stan
		assertTrue(zgradaP.getBtnVlasnikStanar().isDisplayed());
		assertTrue(zgradaP.getBtnVlasnikStanar().isEnabled());
		zgradaP.getBtnVlasnikStanar().click();
		assertEquals(driver.getCurrentUrl(), "http://localhost:8080/stan/1");
		
	}

	@AfterSuite
	public void closeSelenium() {
		// Shutdown the browser
		driver.close();
	}

}
