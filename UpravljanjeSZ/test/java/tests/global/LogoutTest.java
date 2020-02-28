package tests.global;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pages.global.HomePage;
import pages.global.LoginPage;

public class LogoutTest {
	public WebDriver driver;
	LoginPage loginP;
	HomePage homeP;

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
	}

	// test logout za sve role
	@Test
	public void logoutAdmin() {
		// logujem se da bih mogla da istestiram logout
		loginP.logIn("admin@gmail.com", "Bar5slova");

		WebElement butLogOut = homeP.getBtnIzlogujSe();
		// tvrdim da se dugme pojavilo i da je omoguceno
		assertTrue(butLogOut.isDisplayed());
		assertTrue(butLogOut.isEnabled());
		butLogOut.click();
		// uporedjujem ocekivanu i stvarnu url
		String urlExpected = "http://localhost:8080/logovanje";
		String urlActual = driver.getCurrentUrl();
		assertEquals(urlActual, urlExpected);
	}

	@Test
	public void logoutPredsednik() {
		// logujem se da bih mogla da istestiram logout
		homeP = new HomePage(driver);
		loginP.logIn("predSkup@gmail.com", "Bar5slova");

		WebElement butLogOut = homeP.getBtnIzlogujSe();
		// tvrdim da se dugme pojavilo i da je omoguceno
		assertTrue(butLogOut.isDisplayed());
		assertTrue(butLogOut.isEnabled());
		butLogOut.click();
		// uporedjujem ocekivanu i stvarnu url
		String urlExpected = "http://localhost:8080/logovanje";
		String urlActual = driver.getCurrentUrl();
		assertEquals(urlActual, urlExpected);
	}

	@Test
	public void logoutStanar() {
		// logujem se da bih mogla da istestiram logout
		homeP = new HomePage(driver);
		loginP.logIn("marko@gmail.com", "Bar5slova");

		WebElement butLogOut = homeP.getBtnIzlogujSe();
		// tvrdim da se dugme pojavilo i da je omoguceno
		assertTrue(butLogOut.isDisplayed());
		assertTrue(butLogOut.isEnabled());
		butLogOut.click();
		// uporedjujem ocekivanu i stvarnu url
		String urlExpected = "http://localhost:8080/logovanje";
		String urlActual = driver.getCurrentUrl();
		assertEquals(urlActual, urlExpected);
	}
	
	// zatvaratnje browser-a kad se izvrse testovi
	@AfterSuite
	public void closeSelenium() {
		// Shutdown the browser
		driver.close();
	}
}
