package tests.zgrade;

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
import pages.zgrade.ZgradaDodavanjePage;
import pages.zgrade.ZgradaPregledPage;

public class ZgradaPregledTest {
	public WebDriver driver;
	ZgradaDodavanjePage zgradaDP;
	LoginPage loginP;
	HomePage homeP;
	ZgradaPregledPage zgradaPP;

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
	}

	// proveravam da li dugme dodavanje redirektuje na stranic zgrada/dodavanje @Test(priority=1)
	@Test(priority = 1)
	public void dodavanjeRedirect() {
		zgradaPP.getBtnDodavanje().click();
		String urlExpected = "http://localhost:8080/zgrade/dodavanje";
		String urlActual = driver.getCurrentUrl();
		assertEquals(urlActual, urlExpected);
		// vracam se na pregled stranicu
		zgradaDP.getBtnPregled().click();
	}

	@Test(priority = 2)
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

	//testiram pretragu sa oba polja popunjena ispravnim podacima
	@Test(priority=3)
	public void pretraga() {
		// obavim pretragu sa tacnim podacima, oba polja popunjena
		zgradaPP.pretraga("Boska Buhe", "Novi Sad");
		// u tabeli treba da se pokazao rezultat pretrage, uzimam taj string i
		// proveramam da li je ocekivan
		String zgrada = zgradaPP.getZgraduIzTabele("Boska Buhe").getText();
		assertTrue(zgrada.contains("Boska Buhe"));
	}
	// testiram pretragu sa oba polja popunjena brojevima
	@Test(priority = 4)
	public void pretragaBrojevi() {
		zgradaPP.pretraga("1111111", "111111");
		assertEquals(zgradaPP.getMsgPretraga().getText(), "Nijedna zgrada sa trazenim kriterijumima nije prondajena!");
		// refres stranice za sledeci login
		driver.get(driver.getCurrentUrl());
	}

	// testiram pretragu sa oba polja popunjena specijalnim znacima
	@Test(priority = 5)
	public void pretragaSpecijalniZnaci() {
		zgradaPP.pretraga("@@@@", "#####");
		assertEquals(zgradaPP.getMsgPretraga().getText(), "Nijedna zgrada sa trazenim kriterijumima nije prondajena!");
		// refres stranice za sledeci login
		driver.get(driver.getCurrentUrl());
	}

	// testiram pretragu sa oba polja popunjena nepostojecim podacima
	@Test(priority = 6)
	public void pretragaNepostojeciPodacii() {
		zgradaPP.pretraga("Kralj", "Petar");
		assertEquals(zgradaPP.getMsgPretraga().getText(), "Nijedna zgrada sa trazenim kriterijumima nije prondajena!");
		// refres stranice za sledeci login
		driver.get(driver.getCurrentUrl());
	}

	// testiram pretragu - unosim u polje samo ulica/broj podatke
	@Test(priority = 7)
	public void pretragaSamoUlicaBroj() {
		// obavim pretragu sa tacnim podacima
		zgradaPP.setUlicaBroj("42");
		// u tabeli treba da se pokazo rezultat pretrage, uzimam taj string i
		// proveramam da li je ocekivan
		String zgrada = zgradaPP.getZgraduIzTabele("42").getText();
		assertTrue(zgrada.contains("42"));
	}

	@Test(priority = 8)
	public void pretragaSamoGrad() {
		// obavim pretragu sa tacnim podacima
		zgradaPP.setGrad("Novi Sad");
		// u tabeli treba da se pokazo rezultat pretrage, uzimam taj string i
		// proveramam da li je ocekivan
		String zgrada = zgradaPP.getZgraduIzTabele("Novi Sad").getText();
		assertTrue(zgrada.contains("Novi Sad"));
	}

	// testiram da li link adresa i predsednik zgrade u tabeli da li redirektuju
	// na odgovarajuce stranice
	@Test(priority = 9)
	public void redirektAdresaPredsednik() {
		// nadjem red
		zgradaPP.getZgraduIzTabele("Boska Buhe");
		// kliknem na link, poredim stvarnu i ocekivanu adresu
		zgradaPP.getLinkAdresa().click(); 
		assertEquals(driver.getCurrentUrl(), "http://localhost:8080/zgrada/1/stanovi");
		// vracam se na pregled stranicu
		homeP.getZgrade().click();
		zgradaDP.getBtnPregled().click();
		// kliknem na link predsednik u tabeli
		zgradaPP.getLinkPredsednik().click();
		assertEquals(driver.getCurrentUrl(), "http://localhost:8080/stanar/2");
	}

	@AfterSuite
	public void closeSelenium() {
		// Shutdown the browser
		driver.close();
	}

}
