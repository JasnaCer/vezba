package tests.institucije;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pages.global.HomePage;
import pages.global.LoginPage;
import pages.institucije.InstitucijaPage;
import pages.institucije.InstitucijeDodajPage;
import pages.institucije.InstitucijePregledPage;

public class InstitucijeDodajTest {
	public WebDriver driver;
	LoginPage loginP;
	HomePage homeP;
	InstitucijeDodajPage institucijeDP;
	InstitucijePregledPage institucijePP;
	InstitucijaPage institucijaP;

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
		institucijeDP = new InstitucijeDodajPage(driver);
		institucijePP = new InstitucijePregledPage(driver);
		institucijaP = new InstitucijaPage(driver);
	}

	@Test(priority = 0)
	public void LoginIredirekt() {
		loginP.logIn("admin@gmail.com", "Bar5slova");
		homeP.getInstitucije().click();
		// proveravam da li sam na stranici firme
		assertEquals(driver.getCurrentUrl(), "http://localhost:8080/institucije");
		proveriti url 

	}
	

	@AfterSuite
	public void closeSelenium() {
		// Shutdown the browser
		driver.close();
	}
}
