package zadatakTEST1;



import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import zadatakPOM1.HomePage;
import zadatakPOM1.LoginPage;
import zadatakPOM1.MenuPage;
import zadatakPOM1.StudentPage;
import zadatakPOM1.StudentTablePage;




public class LoginTestAll extends BaseTest {
	
	HomePage homeP;
	LoginPage loginP;
	MenuPage menuP;

	
	@BeforeSuite
	public void setupSelenium() {

		// instanciranje browsera
		System.setProperty("webdriver.gecko.driver", "geckodriver");
		driver = new FirefoxDriver();
//		System.setProperty("webdriver.chrome.driver", "chromedriver");
//		WebDriver driver = new ChromeDriver();
		// navigacija na zeljenu stranicu
		driver.get("http://localhost:8080/#/");
		driver.manage().window().maximize();
		
		menuP = new MenuPage(driver);
		loginP = new LoginPage(driver);
		homeP = new HomePage(driver);
		
	}
	

	@Test(priority = 0)
	public void login() {

		// klik na Account
		menuP.getAccountMenu().click();
		// proveravam da li se pojavio signin
		assertEquals(true, menuP.getSignUp().isDisplayed());
		// pronalazim sign in element u acouunt i klik
		menuP.getSignUp().click();

		// logujem se
		loginP.logIn("admin", "admin");

		// proveravam da li sam se ulogovala,
		// roveravam da su 2 stringa jednaka
		String expected = "You are logged in as user \"admin\".";
		String actual = homeP.getTextMsg();
		assertEquals(actual, expected);

		// moze i ovako proveravam da li je tacno da su 2 stringa jednaka
		// assertTrue(actual.equals(expected));
	}
	@AfterSuite
	public void closeSelenium() {
		// Shutdown the browser
		driver.close();
	}

}