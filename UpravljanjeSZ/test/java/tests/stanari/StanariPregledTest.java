package tests.stanari;

import static org.testng.Assert.assertEquals;
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
import pages.stanari.StanariPregledPage;
import pages.stanari.StanariRegistracijaPage;

public class StanariPregledTest {
	public WebDriver driver;
	LoginPage loginP;
	HomePage homeP;
	StanariRegistracijaPage stanariRP;
	StanariPregledPage stanariPP;

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
	}

	// proveravam da li dugme registracija redirektuje na stranicu
	// stanari/registracija
	@Test(priority = 1)
	public void registracijaRedirekt() {
		stanariPP.getBtnRegistracija().click();
		String urlExpected = "http://localhost:8080/stanari/registracija";
		String urlActual = driver.getCurrentUrl();
		assertEquals(urlActual, urlExpected);
		// vracam se na pregled stranicu
		stanariRP.getBtnPregled().click();
	}

	@Test(priority = 2)
	public void selektPtikazi() {
		// proveraavam selekt prikazi
		// selektujem zeljeni prikaz
		Select select = stanariPP.getPrikaz();
		select.selectByValue("50");
		// pravim string od selektovane vrednosti
		WebElement option = select.getFirstSelectedOption();
		String text = option.getText();
		// proveravam da li je tacno da su jednake dobijena i ocekivana vrednost
		assertEquals(text, "50");
	}

	@Test(priority = 3)
	public void pretragaUspesna() {
		// obavim pretragu sa tacnim podacima
		stanariPP.pretraga("Gospodin");
		// u tabeli treba da se prikazao rezultat pretrage, uzimam taj string
		// iproveramam da li je ocekivan
		String stanar = stanariPP.getStanaraIzTabele("Gospodin").getText();
		assertTrue(stanar.contains("Gospodin"));

	}
	@Test(priority = 4)
	public void pretragaNeuspesna() {
		//obavim pretragu sa podacima koji ne postoje u tabeli, trazim neregistrovanog korisnika
		stanariPP.pretraga("Milojkomile");
		assertEquals(stanariPP.msgNemaStanara().getText(), "Nijedan stanar sa trazenim kriterijumom nije prondajen!");
		//rifresujem stranicu zbog sledeceg teste
		driver.get(driver.getCurrentUrl());
	}
	// testiram pretragu sa oba polja popunjena brojevima
		@Test(priority = 5)
		public void pretragaBrojevi() {
			stanariPP.pretraga("1111111");
			assertEquals(stanariPP.msgNemaStanara().getText(), "Nijedan stanar sa trazenim kriterijumom nije prondajen!");
			// refres stranice za sledeci login
			driver.get(driver.getCurrentUrl());
		}

		// testiram pretragu sa oba polja popunjena specijalnim znacima
		@Test(priority = 6)
		public void pretragaSpecijalniZnaci() {
			stanariPP.pretraga("@@@@");
			assertEquals(stanariPP.msgNemaStanara().getText(), "Nijedan stanar sa trazenim kriterijumom nije prondajen!");
			// refres stranice za sledeci login
			driver.get(driver.getCurrentUrl());
		}
	@Test(priority = 7)
	public void linkStanarRedirekt() {
        //testiram da li klik na link stanar u tabeli redirektuju na odgovarajucu stranicu
		stanariPP.getStanaraIzTabele("Gospodin Predsednik");
		stanariPP.getLinkStanar().click();
		//proveravam da li klik na link redirektuje na stranicu stanar
		assertEquals(driver.getCurrentUrl(), "http://localhost:8080/stanar/2");
		//vracam se nazad zbog sledeceg testa
		homeP.getStanari().click();
		stanariRP.getBtnPregled().click();
		}
	@Test(priority = 8)
	public void pregledRedirekt() {
		stanariPP.getBtnPregled().click();
		String urlExpected = "http://localhost:8080/stanari/pregled";
		String urlActual = driver.getCurrentUrl();
		assertEquals(urlActual, urlExpected);
		// vracam se na pregled stranicu
		stanariRP.getBtnPregled().click();
	}
	// zatvaratnje browser-a kad se izvrse testovi
	@AfterSuite
	public void closeSelenium() {
		// Shutdown the browser
		driver.close();
	}

	
	 // it('should successfully redirect click on btt Pregled', function () {
    //     //testiram da li klik na dugme pregled redirektuju na odgovarajucu stranicu
    //     stanariRP.btnPregled.click();
    //     expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/stanari/pregled');
    // });
}
