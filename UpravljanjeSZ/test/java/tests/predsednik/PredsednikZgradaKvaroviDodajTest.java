package tests.predsednik;

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
import pages.predsednik.PredsednikPocetnaPage;
import pages.predsednik.PredsednikZgradaKvaroviDodajPage;
import pages.predsednik.PredsednikZgradaKvaroviPage;
import pages.predsednik.PredsednikZgradaObavestenjaPage;
import pages.predsednik.PredsednikZgradaPredloziTacekePage;

public class PredsednikZgradaKvaroviDodajTest {
	public WebDriver driver;
	LoginPage loginP;
	HomePage homeP;
	PredsednikPocetnaPage predsednikPocetnaP;
	PredsednikZgradaObavestenjaPage pzoPage;
	PredsednikZgradaPredloziTacekePage predloziTackeP;
	PredsednikZgradaKvaroviPage kvaroviP;
	PredsednikZgradaKvaroviDodajPage kvaroviDodajP;

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
		predloziTackeP =  new PredsednikZgradaPredloziTacekePage(driver);
		kvaroviP = new PredsednikZgradaKvaroviPage(driver);
		kvaroviDodajP = new PredsednikZgradaKvaroviDodajPage(driver);
	}

	@Test(priority = 0)
	public void LoginIredirekt() {
		loginP.logIn("predSkup@gmail.com", "Bar5slova");
		//odlazim na stranicu zgrade obavestenja
		predsednikPocetnaP.getLinkStranicaZgrade().click();
		assertEquals(driver.getCurrentUrl(),"http://localhost:8080/zgrada/1/obavestenja");
		//proveravam preko naslova
		assertEquals(pzoPage.getTextMsg(),"Zgrada");
		pzoPage.getTabkvarovi().click();
		assertEquals(driver.getCurrentUrl(),"http://localhost:8080/zgrada/1/kvarovi");
		kvaroviP.btnDodaj().click();
		//proveravam da li sam ispravno redirektovana
		assertEquals(driver.getCurrentUrl(),"http://localhost:8080/zgrada/1/kvar/dodaj");
		
	}
	@Test(priority = 1)
	public void dodajKvar() {
		kvaroviDodajP.setLokacija("Novi sad");
		kvaroviDodajP.setOpis("mali kvar");
		kvaroviDodajP.btnOdgovornoLice().click();
		kvaroviDodajP.btnPrihvati().click();
		kvaroviDodajP.btnDodajKvar().click();
		//proveravam da li je uspesno dodato
		assertEquals(pzoPage.msgAlert().getText(), "Kvar uspesno dodat");
		//vratim se na kvarove
		pzoPage.getTabkvarovi().click();
		
	}
	@Test(priority = 2)
	public void dodajKvarBezLokacije() {
		kvaroviP.btnDodaj().click();
		kvaroviDodajP.setLokacija("");
		kvaroviDodajP.setOpis("mali kvar");
		assertEquals(kvaroviDodajP.msgLokacijaPrzna().getText(), "Ovo polje ne sme biti prazno!");
		//vratim se na kvarove
		pzoPage.getTabkvarovi().click();
		
	}
	@Test(priority = 3)
	public void dodajKvarBezOpisa() {
		kvaroviP.btnDodaj().click();
		kvaroviDodajP.setOpis("");
		kvaroviDodajP.setLokacija("Novi Sad ");
		assertEquals(kvaroviDodajP.msgOpisPrzan().getText(), "Ovo polje ne sme biti prazno!");
		//vratim se na kvarove
		pzoPage.getTabkvarovi().click();
	}
	@Test(priority = 4)
	public void dodajKvarBezOpisaLokacije() {
		kvaroviP.btnDodaj().click();
		kvaroviDodajP.setLokacija("");
		kvaroviDodajP.setOpis("");
		assertFalse(kvaroviDodajP.btnDodajKvar().isEnabled());
		//vratim se na kvarove
				pzoPage.getTabkvarovi().click();
	}

	@Test(priority = 5)
	public void formaOdgovornoLice() {
		kvaroviP.btnDodaj().click();
		kvaroviDodajP.btnOdgovornoLice().click();
		assertTrue(kvaroviDodajP.getFormaOdgovornoLice().isDisplayed());
		//proveravam preko titla na formi
		assertEquals(kvaroviDodajP.msgTitleForme().getText(), "Izbor odgovornog lica");
		assertTrue(kvaroviDodajP.getPretraga().isDisplayed());
		assertTrue(kvaroviDodajP.getOdgovornoLiceTable().isDisplayed());
	}
	
	@Test(priority = 6)
	public void selektPrikazi() {
		// proveraavam selekt prikazi
		// selektujem zeljeni prikaz
		Select select = kvaroviDodajP.getSelektPrikaz();
		select.selectByValue("50");
		// pravim string od selektovane vrednosti
		WebElement option = select.getFirstSelectedOption();
		String text = option.getText();
		// proveravam da li je tacno da su jednake dobijena i ocekivana vrednost
		assertEquals(text, "50");
	}
	@Test(priority = 7)
	public void odgovornoLicePretraga() {
		//pretraga treba da da rezultat u tabeli koji sadrzi tekst unet u polje pretraga
		assertTrue(kvaroviDodajP.getFormaOdgovornoLice().isDisplayed());
		assertTrue(kvaroviDodajP.getOdgovornoLiceIzTabele("Gospodin Predsednik").getText().contains("Gospodin Predsednik"));
	}
	@Test(priority = 7)
	public void odustani() {
		//da li klik na dugme odustani zatvara formu
		kvaroviDodajP.btnOdustani().click();
		assertFalse(kvaroviDodajP.getFormaOdgovornoLice().isDisplayed());
	}

	@AfterSuite
	public void closeSelenium() {
		// Shutdown the browser
		driver.close();
	}
	
	
}
