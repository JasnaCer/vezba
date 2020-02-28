package zadatakTEST1;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import zadatakPOM1.HomePage;
import zadatakPOM1.MenuPage;
import zadatakPOM1.StudentPage;
import zadatakPOM1.StudentTablePage;

public class LogOutTest extends BaseTest {

	
	MenuPage menuP;
	HomePage homeP;

	@BeforeClass
	public void setUp() {
		menuP = new MenuPage(driver);
		homeP = new HomePage(driver);
	}
	
	@Test
	public void logOut() {
		menuP.getAccountMenu().click();
		// proveravam da li se pojavio signin
		assertEquals(true, menuP.getLogOut().isDisplayed());
		// pronalazim sign in element u acouunt i klik
		menuP.getLogOut().click();
		
		// proveravam da li sam se izlogovala,
		// proveravam da su 2 stringa jednaka
		String expected = "This is your homepage";
		String actual = homeP.getHomePageMsg();
		assertEquals(actual, expected);
	}

}
