package tests.predsednik;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pages.global.HomePage;
import pages.global.LoginPage;
import pages.predsednik.PredsednikPocetnaPage;

public class PredsednikPocetnaTest {
	public WebDriver driver;
	LoginPage loginP;
	HomePage homeP;
	PredsednikPocetnaPage predsednikPocetnaP;

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
		predsednikPocetnaP = new PredsednikPocetnaPage(driver);
	}

	@Test(priority = 0)
	public void LoginIredirekt() {
		loginP.logIn("predSkup@gmail.com", "Bar5slova");
		// proveravam da li sam na stranici pocetna
		String urlExpected = "http://localhost:8080/pocetna";
		String urlActual = driver.getCurrentUrl();
		assertEquals(urlActual, urlExpected);
	}
	@Test(priority = 1)
	public void checkZgradaUKojojZiviteTable() {
		//da li se tabela prikazala i da li sadrzi odgovarajuce podatke
		assertTrue(predsednikPocetnaP.getZgradaUKojojZiviTable().isDisplayed());
		assertTrue(predsednikPocetnaP.getRedZgradaZivi("Boska Buhe").getText().contains("Novi Sad"));
		assertTrue(predsednikPocetnaP.getRedZgradaZivi("Boska Buhe").getText().contains("Boska Buhe"));
		assertTrue(predsednikPocetnaP.getRedZgradaZivi("Boska Buhe").getText().contains("42"));
	}
	@Test(priority = 2)
	public void redirektNaZgradaStranicu() {
		//da li klik na link stranica u tabeli redirektuje na zgrada stranicu
		predsednikPocetnaP.getLinkStranicaZgrade().click();
		assertEquals(driver.getCurrentUrl(),"http://localhost:8080/zgrada/1/obavestenja");
		//vracam se na pocetnu
		predsednikPocetnaP.getLinkPocetna().click();
		assertEquals(driver.getCurrentUrl(),"http://localhost:8080/pocetna");
	}
	@Test(priority = 3)
	public void checkZgradaVlasnikTable() {
	    // proveravam da li je prikazana tabela i u tabeli prikazana ocekivana lokacija, ulica i broj 
		assertTrue(predsednikPocetnaP.getZgradaVlaskikTable().isDisplayed());
		//AKO POSTOJI RED U TABELI Zgrade u kojima ste vlasnik stana
//		assertTrue(predsednikPocetnaP.getRedZgradaVlaskikTable("Boska Buhe").getText().contains("Novi Sad"));
//		assertTrue(predsednikPocetnaP.getRedZgradaVlaskikTable("Boska Buhe").getText().contains("Boska Buhe"));
//		assertTrue(predsednikPocetnaP.getRedZgradaVlaskikTable("Boska Buhe").getText().contains("42"));
	}
//	@Test(priority = 4)
//	public void redirektNaZgradaStranicuDruga() {
//		//da li klik na link stranica u tabeli redirektuje na zgrada stranicu
//		predsednikPocetnaP.getLinkStranicaZ().click();
//		assertEquals(driver.getCurrentUrl(),"http://localhost:8080/zgrada/1/obavestenja");
//	}

	@AfterSuite
	public void closeSelenium() {
		// Shutdown the browser
		driver.close();
	}
}
