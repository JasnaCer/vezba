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
import pages.predsednik.PredsednikZgradaObavestenjaPage;
import pages.predsednik.PredsednikZgradaPredloziTacekePage;

public class PredsednikZgradaPredloziTacekeTest {
	public WebDriver driver;
	LoginPage loginP;
	HomePage homeP;
	PredsednikPocetnaPage predsednikPocetnaP;
	PredsednikZgradaObavestenjaPage pzoPage;
	PredsednikZgradaPredloziTacekePage predloziTackeP;
	

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
	}

	@Test(priority = 0)
	public void LoginIredirekt() {
		loginP.logIn("predSkup@gmail.com", "Bar5slova");
		// proveravam da li sam na stranici pocetna
		String urlExpected = "http://localhost:8080/pocetna";
		String urlActual = driver.getCurrentUrl();
		assertEquals(urlActual, urlExpected);
		//odlazim na stranicu zgrade obavestenja
		predsednikPocetnaP.getLinkStranicaZgrade().click();
		assertEquals(driver.getCurrentUrl(),"http://localhost:8080/zgrada/1/obavestenja");
		//proveravam preko naslova
		assertEquals(pzoPage.getTextMsg(),"Zgrada");
		//rediretujem na  zgrade predlozi stranicu
		pzoPage.getTabPredloziTacke().click();
		//proveravam da li sam ispravno redirektovana
		assertEquals(driver.getCurrentUrl(),"http://localhost:8080/zgrada/1/tacke");

	}
	@Test(priority = 1)
	public void selektPtikazi() {
		// proveraavam selekt prikazi
		// selektujem zeljeni prikaz
		Select select = predloziTackeP.getPrikaz();
		select.selectByValue("50");
		// pravim string od selektovane vrednosti
		WebElement option = select.getFirstSelectedOption();
		String text = option.getText();
		// proveravam da li je tacno da su jednake dobijena i ocekivana vrednost
		assertEquals(text, "50");

	}
	@Test(priority = 2)
	public void dodajTacku() {
		// uspesno dodajem novo obavestenje
		predloziTackeP.btnDodaj().click();
		//proveravam da li se forma otvorila
		assertTrue(predloziTackeP.getFormaDodajPredlogTacku().isDisplayed());
		predloziTackeP.setTextpolje("Dodajem novu tacku dnevnog reda");
		predloziTackeP.btnPotvrdi().click();
		//proveravam da li je uspesno dodato
		assertEquals(pzoPage.msgAlert().getText(), "Predlog tacke dnevnog reda uspesno dodat");
		//vracam se na stranicu obavestenja
		pzoPage.getTabPredloziTacke().click();
	}
	@Test(priority = 3)
	public void dodajTackuBezUnetogTeksta() {
		// uspesno dodajem novo obavestenje
		predloziTackeP.btnDodaj().click();
		//proveravam da li se forma otvorila
		assertTrue(predloziTackeP.getFormaDodajPredlogTacku().isDisplayed());
		predloziTackeP.setTextpolje("");
		assertFalse(predloziTackeP.btnPotvrdi().isEnabled());
		//vracam se na stranicu obavestenja
		pzoPage.getTabPredloziTacke().click();
}
	@Test(priority = 4)
	public void izmeniTacku() {
		pzoPage.getTabPredloziTacke().click();
		predloziTackeP.btnIzmeni().click();
		//menjam tekst
		predloziTackeP.setTextKojiMenjam("menjam tekst");
		predloziTackeP.btnPotvrdi2().click();
		pzoPage.msgAlert().isDisplayed();
		//Uspesno izmenjeno obavestenje
		assertEquals(pzoPage.msgAlert().getText(), "Tacka uspesno izmenjena");
		// refres stranice za sledeci test
		driver.get(driver.getCurrentUrl());
	}

	@Test(priority = 5)
	public void dodajTackuUSkupstinu() {
		//iz selekta biram skupstinu
		predloziTackeP.setSkupstinu(1);
		//dodajem u skupstinu svoju tacku
		predloziTackeP.btnDodajPredlogTackeUSkupstinu().click();
		//proveravam da li je dodata
		pzoPage.msgAlert().isDisplayed();
		assertEquals(pzoPage.msgAlert().getText(), "Tacka uspesno dodata u skupstinu");
		//vracam se na stranicu tacke
		pzoPage.getTabPredloziTacke().click();
	}
	@Test(priority = 6)
	public void dodajTackuBezSkupstineSkupstinu() {
		//ne izaberem skupstinu a pokusam da dodam tacke
		assertFalse(predloziTackeP.btnDodajPredlogTackeUSkupstinu().isEnabled());
		//vracam se na stranicu tacke
		pzoPage.getTabPredloziTacke().click();
	}
	@Test(priority = 7)
	public void izbrisiTacku() {
		predloziTackeP.btnDodaj().click();
		predloziTackeP.setTextpolje("Dodajem novu tacku dnevnog reda");
		predloziTackeP.btnPotvrdi().click();
		pzoPage.getTabPredloziTacke().click();
		predloziTackeP.btnObrisi().click();
		//proveravam da li je uspesno izbrisano
		pzoPage.msgAlert().isDisplayed();
		assertEquals(pzoPage.msgAlert().getText(), "Tacka uspesno izbrisana");
	}
	
	
	@AfterSuite
	public void closeSelenium() {
		// Shutdown the browser
		driver.close();
	}

}
