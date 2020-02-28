package tests.predsednik;

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
import pages.predsednik.PredsednikPocetnaPage;
import pages.predsednik.PredsednikPromenaLozinkePage;
import pages.predsednik.PredsednikZgradaObavestenjaPage;

public class PredsednikPromenaLozinkeTest {
	public WebDriver driver;
	LoginPage loginP;
	HomePage homeP;
	PredsednikPocetnaPage predsednikPocetnaP;
	PredsednikZgradaObavestenjaPage pzoPage;
	PredsednikPromenaLozinkePage promenaLozinke;

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
		pzoPage =  new PredsednikZgradaObavestenjaPage(driver);
		promenaLozinke = new PredsednikPromenaLozinkePage(driver);
	}

	@Test(priority = 0)
	public void LoginIredirekt() {
		loginP.logIn("predSkup@gmail.com", "Bar5slova");
		predsednikPocetnaP.getLinkPromenaLozinke().click();
		//odlazim na stranicu promena lozinke
		assertTrue(promenaLozinke.getFormaPromenaLozinke().isDisplayed());
	}

	@Test(priority = 1)
	public void promenaLozinkeKracaOd6() {
		promenaLozinke.promenaPass("Bar5slova", "Bar5s", "Bar5s");
		assertEquals(promenaLozinke.msgNovaObaveznoNeispravno().getText(),"Neispravna lozinka! Pogledajte napomenu.");
		assertFalse(promenaLozinke.btnPromeniLozinku().isEnabled());
		// refres stranice za sledeci test
		driver.get(driver.getCurrentUrl());
	}
	@Test(priority = 2)
	public void promenaLozinkeBezVelikihSlova() {
		promenaLozinke.promenaPass("Bar5slova", "bar55slova", "bar55slova");
		assertEquals(promenaLozinke.msgNovaObaveznoNeispravno().getText(),"Neispravna lozinka! Pogledajte napomenu.");
		assertFalse(promenaLozinke.btnPromeniLozinku().isEnabled());
		// refres stranice za sledeci test
		driver.get(driver.getCurrentUrl());
	}
	@Test(priority = 3)
	public void promenaLozinkeBezMalihSlova() {
		promenaLozinke.promenaPass("Bar5slova", "bar55slova", "bar55slova");
		assertEquals(promenaLozinke.msgNovaObaveznoNeispravno().getText(),"Neispravna lozinka! Pogledajte napomenu.");
		assertFalse(promenaLozinke.btnPromeniLozinku().isEnabled());
		// refres stranice za sledeci test
		driver.get(driver.getCurrentUrl());
	}
	@Test(priority = 4)
	public void promenaLozinkeBezBrojeva() {
		promenaLozinke.promenaPass("Bar5slova", "Barslovaa", "Barslovaa");
		assertEquals(promenaLozinke.msgNovaObaveznoNeispravno().getText(),"Neispravna lozinka! Pogledajte napomenu.");
		assertFalse(promenaLozinke.btnPromeniLozinku().isEnabled());
		// refres stranice za sledeci test
				driver.get(driver.getCurrentUrl());
	}
	@Test(priority = 5)
	public void promenaLozinkePraznaPolja() {
		promenaLozinke.promenaPass("", "", "");
		
		assertEquals(promenaLozinke.msgStaraObavezno().getText(),"Ovo polje je obavezno!");
		assertEquals(promenaLozinke.msgNovaObaveznoNeispravno().getText(),"Ovo polje je obavezno!");
		assertFalse(promenaLozinke.btnPromeniLozinku().isEnabled());
		// refres stranice za sledeci test
				driver.get(driver.getCurrentUrl());
	}
	@Test(priority = 6)
	public void promenaLozinkeRzliciteStaraINova() {
		assertFalse(promenaLozinke.btnPromeniLozinku().isEnabled());
		promenaLozinke.promenaPass("Bar5slova", "Bar6slova", "Bar7slova");
		assertEquals(promenaLozinke.msgPotvrdaNePoklapaju().getText(),"Lozinke se ne poklapaju!");
		
	}
	@Test(priority = 7)
	public void promenaLozinkeUspesna() {
		promenaLozinke.promenaPass("Bar5slova", "Bar6slova", "Bar6slova");
		assertEquals(pzoPage.msgAlert().getText(), "Lozinka uspesno izmenjena!");
		
	}
	
	@AfterSuite
	public void closeSelenium() {
		// Shutdown the browser
		driver.close();
	}
}
