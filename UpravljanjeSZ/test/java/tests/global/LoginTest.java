package tests.global;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pages.global.HomePage;
import pages.global.LoginPage;

public class LoginTest {
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

	// test login sa tacnim podacima
	// test ligin ADMIN rola
	@Test(priority = 0)
	public void loginTrueCredential() {
		loginP.logIn("admin@gmail.com", "Bar5slova");
		assertEquals(driver.getCurrentUrl(), "http://localhost:8080/pocetna");
		// izlogujem se jer u narednom testu se ponovo logujem
		homeP.getBtnIzlogujSe().click();
	}

	// test ligin Predsednik Skupstine rola
	@Test(priority = 2)
	public void loginTrueCredentialPS() {
		loginP.logIn("predSkup@gmail.com", "Bar5slova");
		assertEquals(driver.getCurrentUrl(), "http://localhost:8080/pocetna");
		// izlogujem se jer u narednom testu se ponovo logujem
		homeP.getBtnIzlogujSe().click();
	}

	// test ligin STANAR rola
	@Test(priority = 3)
	public void loginTrueCredentialS() {
		loginP.logIn("marko@gmail.com", "Bar5slova");
		assertEquals(driver.getCurrentUrl(), "http://localhost:8080/pocetna");
		// izlogujem se jer u narednom testu se ponovo logujem
		homeP.getBtnIzlogujSe().click();
	}

	// test login kada je email prazan
	@Test(priority = 4)
	public void emptyEmail() {
		loginP.logIn("", "Bar5slova");
		String expected = "Email nije validnog formata!";
		String actual = loginP.getMsgEmail();
		assertEquals(actual, expected);
		// refres stranice za sledeci login
		driver.get(driver.getCurrentUrl());
	}
	// test login kada je email nevalidan 
		@Test(priority = 5)
		public void wrongEmail() {
			loginP.logIn("afafsfsf", "Bar5slova");
			String expected = "Email nije validnog formata!";
			String actual = loginP.getMsgEmail();
			assertEquals(actual, expected);
			// refres stranice za sledeci login
			driver.get(driver.getCurrentUrl());
		}

	// test login kada je lozinka prazna
	@Test(priority = 6)
	public void emptyLozinka() {
		loginP.logIn("admin@gmail.com", "");
		String expected = "Lozinka nije validnog formata (Mora biti bar jedno veliko slovo, veliko malo slovo i broj i minimalne duzine 6)!";
		String actual = loginP.getMsgLozinka();
		assertEquals(actual, expected);
		// refres stranice za sledeci login
		driver.get(driver.getCurrentUrl());
	}
	// test login kada je lozinka netacna
	@Test(priority = 7)
	public void wrongLozinka() {
		loginP.logIn("admin@gmail.com", "admin");
		String expected = "Lozinka nije validnog formata (Mora biti bar jedno veliko slovo, veliko malo slovo i broj i minimalne duzine 6)!";
		String actual = loginP.getMsgLozinka();
		assertEquals(actual, expected);
		// refres stranice za sledeci login
		driver.get(driver.getCurrentUrl());
	}

	// test login kada je lozinka manja od 6 slova
	@Test(priority = 8)
	public void lessThan6Characters() {
		loginP.logIn("admin@gmail.com", "admina");
		String expected = "Lozinka nije validnog formata (Mora biti bar jedno veliko slovo, veliko malo slovo i broj i minimalne duzine 6)!";
		String actual = loginP.getMsgLozinka();
		assertEquals(actual, expected);
		// refres stranice za sledeci login
		driver.get(driver.getCurrentUrl());
	}

	// test login kada je lozinka bez velikih slova
	@Test(priority = 9)
	public void withoutCapitalLetters() {
		loginP.logIn("admin@gmail.com", "bar5slova");
		String expected = "Lozinka nije validnog formata (Mora biti bar jedno veliko slovo, veliko malo slovo i broj i minimalne duzine 6)!";
		String actual = loginP.getMsgLozinka();
		assertEquals(actual, expected);
		// refres stranice za sledeci login
		driver.get(driver.getCurrentUrl());
	}

	// test login kada je lozinka bez malih
	@Test(priority = 10)
	public void withoutSmalllLetters() {
		loginP.logIn("admin@gmail.com", "BAR5SLOVA");
		String expected = "Lozinka nije validnog formata (Mora biti bar jedno veliko slovo, veliko malo slovo i broj i minimalne duzine 6)!";
		String actual = loginP.getMsgLozinka();
		assertEquals(actual, expected);
		// refres stranice za sledeci login
		driver.get(driver.getCurrentUrl());
	}

	// test login kada je lozinka bez brojeva
	@Test(priority = 11)
	public void withoutNumber() {
		loginP.logIn("admin@gmail.com", "BARrSLOVA");
		String expected = "Lozinka nije validnog formata (Mora biti bar jedno veliko slovo, veliko malo slovo i broj i minimalne duzine 6)!";
		String actual = loginP.getMsgLozinka();
		assertEquals(actual, expected);
		// refres stranice za sledeci login
		driver.get(driver.getCurrentUrl());
	}
	// zatvaratnje browser-a kad se izvrse testovi
	@AfterSuite
	public void closeSelenium() {
		// Shutdown the browser
		driver.close();
	}

}
