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
import pages.predsednik.PredsednikZgradaKvaroviPage;
import pages.predsednik.PredsednikZgradaObavestenjaPage;
import pages.predsednik.PredsednikZgradaPredloziTacekePage;

public class PredsednikZgradaKvaroviTest {
	public WebDriver driver;
	LoginPage loginP;
	HomePage homeP;
	PredsednikPocetnaPage predsednikPocetnaP;
	PredsednikZgradaObavestenjaPage pzoPage;
	PredsednikZgradaPredloziTacekePage predloziTackeP;
	PredsednikZgradaKvaroviPage kvaroviP;

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
		pzoPage = new PredsednikZgradaObavestenjaPage(driver);
		predloziTackeP = new PredsednikZgradaPredloziTacekePage(driver);
		kvaroviP = new PredsednikZgradaKvaroviPage(driver);
	}

	@Test(priority = 0)
	public void LoginIredirekt() {
		loginP.logIn("predSkup@gmail.com", "Bar5slova");
		// odlazim na stranicu zgrade obavestenja
		predsednikPocetnaP.getLinkStranicaZgrade().click();
		assertEquals(driver.getCurrentUrl(), "http://localhost:8080/zgrada/1/obavestenja");
		// proveravam preko naslova
		assertEquals(pzoPage.getTextMsg(), "Zgrada");
		pzoPage.getTabkvarovi().click();
		// proveravam da li sam ispravno redirektovana
		assertEquals(driver.getCurrentUrl(), "http://localhost:8080/zgrada/1/kvarovi");

	}

	@Test(priority = 1)
	public void selektPtikazi() {
		// proveraavam selekt prikazi
		// selektujem zeljeni prikaz
		Select select = kvaroviP.getPrikaz();
		select.selectByValue("50");
		// pravim string od selektovane vrednosti
		WebElement option = select.getFirstSelectedOption();
		String text = option.getText();
		// proveravam da li je tacno da su jednake dobijena i ocekivana vrednost
		assertEquals(text, "50");

	}

	@Test(priority = 2)
	public void prikaziZavrseneKvarove() {
		// check box inicijalno je odcekiran
		assertFalse(kvaroviP.getCbZavrseniKvarovi().isSelected());
	}
	@Test(priority = 3)
	public void btnDodaj() {
		// dugme je vidljivo i omoguceno
		assertTrue(kvaroviP.btnDodaj().isDisplayed());
		assertTrue(kvaroviP.btnDodaj().isEnabled());
	}
	@Test(priority = 4)
	public void izbrisiKvar() {
		//brisanje kvara
		kvaroviP.btnbrisi().click();
		assertEquals(pzoPage.msgAlert().getText(), "Uspesno izbrisan kvar");

	}

	@AfterSuite
	public void closeSelenium() {
		// Shutdown the browser
		driver.close();
	}

}
