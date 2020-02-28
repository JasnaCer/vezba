package tests.firme;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pages.firme.FirmaPage;
import pages.firme.FirmeDodajPage;
import pages.firme.FirmePregledPage;
import pages.global.HomePage;
import pages.global.LoginPage;

public class FirmePregledTest {
	public WebDriver driver;
	LoginPage loginP;
	HomePage homeP;
	FirmeDodajPage firmeDP;
	FirmePregledPage firmePP;
	FirmaPage firmaP;

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
		firmeDP = new FirmeDodajPage(driver);
		firmePP = new FirmePregledPage(driver);
		firmaP = new FirmaPage(driver);
	}

	@Test(priority = 0)
	public void LoginIredirekt() {
		loginP.logIn("admin@gmail.com", "Bar5slova");
		homeP.getFirme().click();
		// proveravam da li sam na stranici firme
		assertEquals(driver.getCurrentUrl(), "http://localhost:8080/firme");
		proveriti url
//		firmeDP.getBtnPregled().click();
//		// proveravam da li klik na dugme redirektuje na stranicu pregled
//		assertEquals(driver.getCurrentUrl(), "http://localhost:8080/firme/pregled");
	}
	

	@AfterSuite
	public void closeSelenium() {
		// Shutdown the browser
		driver.close();
	}

}
