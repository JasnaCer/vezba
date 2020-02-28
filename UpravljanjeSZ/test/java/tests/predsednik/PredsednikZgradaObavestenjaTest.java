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

public class PredsednikZgradaObavestenjaTest {
	public WebDriver driver;
	LoginPage loginP;
	HomePage homeP;
	PredsednikPocetnaPage predsednikPocetnaP;
	PredsednikZgradaObavestenjaPage pzoPage;

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
	}
	@Test(priority = 1)
	public void selektPtikazi() {
		// proveraavam selekt prikazi
		// selektujem zeljeni prikaz
		Select select = pzoPage.getPrikaz();
		select.selectByValue("50");
		// pravim string od selektovane vrednosti
		WebElement option = select.getFirstSelectedOption();
		String text = option.getText();
		// proveravam da li je tacno da su jednake dobijena i ocekivana vrednost
		assertEquals(text, "50");

	}
	@Test(priority = 2)
	public void dodajObavestenje() {
		// uspesno dodajem novo obavestenje
		pzoPage.btnDodajObavestenje().click();
		//proveravam da li se forma otvorila
		assertTrue(pzoPage.formaDodajObavestenje().isDisplayed());
		pzoPage.setTextPolje("Dodajem novo obavestenje");
		pzoPage.btnPotvrdi().click();
		//proveravam da li je uspesno dodato
		assertEquals(pzoPage.msgAlert().getText(), "Obavestenje uspesno dodato!");
		//vracam se na stranicu obavestenja
		pzoPage.getTabObavestenja().click();
	}
	@Test(priority = 3)
	public void dodajObavestenjeBezUnetogTeksta() {
		// uspesno dodajem novo obavestenje
		pzoPage.btnDodajObavestenje().click();
		//proveravam da li se forma otvorila
		assertTrue(pzoPage.formaDodajObavestenje().isDisplayed());
		pzoPage.setTextPolje("");
		assertFalse(pzoPage.btnPotvrdi().isEnabled());
		//vracam se na stranicu obavestenja
		pzoPage.getTabObavestenja().click();
	}
	@Test(priority = 4)
	public void izmeniObavestenje() {
		pzoPage.getTabObavestenja().click();
		pzoPage.btnIzmeniObavestenje().click();
		//menjam tekst
		pzoPage.setTextKojiMenjam("menjam tekst");
		pzoPage.btnPotvrdi2().click();
		pzoPage.msgAlert().isDisplayed();
		//Uspesno izmenjeno obavestenje
		assertEquals(pzoPage.msgAlert().getText(), "Uspesno izmenjeno obavestenje");
		
	}
	@Test(priority = 5)
	public void izbrisiObavestenje() {
		pzoPage.btnObrisi().click();
		//proveravam da li je uspesno izbrisano
		pzoPage.msgAlert().isDisplayed();
		assertEquals(pzoPage.msgAlert().getText(), "Uspesno izbrisano obavestenje");
	}
	
	@AfterSuite
	public void closeSelenium() {
		// Shutdown the browser
		driver.close();
	}
}
