package tests.global;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pages.global.HomePage;
import pages.global.LoginPage;

public class HomeTest {

	public WebDriver driver;
	HomePage homeP;
	LoginPage loginP;

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
		homeP = new HomePage(driver);
		loginP = new LoginPage(driver);
		//logujem se u app
		loginP.logIn("admin@gmail.com", "Bar5slova");
		
	}
	// proveravam da li su eementi prisutni na stranici
	@Test(priority = 0)
	public void isPresent() {
		assertTrue(homeP.getPocetna().isDisplayed());
		assertTrue(homeP.getZgrade().isDisplayed());
		assertTrue(homeP.getStanari().isDisplayed());
		assertTrue(homeP.getInstitucije().isDisplayed());
		assertTrue(homeP.getFirme().isDisplayed());
		assertTrue(homeP.getBtnIzlogujSe().isDisplayed());
	}
	
	//proveravam da li klik na link redirektuje na odgovarajucu stranicu
		@Test(priority = 1)
		public void redirekt() {
			homeP.getZgrade().click();
			assertEquals(driver.getCurrentUrl(), "http://localhost:8080/zgrade");
			homeP.getStanari().click();
			assertEquals(driver.getCurrentUrl(), "http://localhost:8080/stanari");
			homeP.getPocetna().click();
			assertEquals(driver.getCurrentUrl(), "http://localhost:8080/pocetna");
		}
	
	// zatvaratnje browser-a kad se izvrse testovi
	@AfterSuite
	public void closeSelenium() {
		// Shutdown the browser
		driver.close();
	}

}
