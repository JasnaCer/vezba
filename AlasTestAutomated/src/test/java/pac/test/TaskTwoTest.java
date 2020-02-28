package pac.test;


import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import junit.framework.Assert;
import taskOne.pages.GooglePage;

public class TaskTwoTest extends BaseTest {
	
	private GooglePage googlePage;
	
	@BeforeClass
	public void setupSelenium() {
		//Driver instantiation
		/*System.setProperty("webdriver.gecko.driver", "geckodriver");
		driver = new FirefoxDriver();*/
		//Driver instantiation
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver = new ChromeDriver();
		//Page classes instantiation
		googlePage = new GooglePage(driver);
		
		// navigate to the desired page
		driver.get("https://www.google.com");
		// maximize  window
		driver.manage().window().maximize();
				
		//Checking that the Google page is loaded, not necessary, but desirable
		String expected = "https://www.google.com/";
		String actual = driver.getCurrentUrl();
		Assert.assertEquals(actual, expected);
	}
	@Test
	public void searchCheese(){
		//I call method from googlePage class
		googlePage.searching("cheese");
		//print assertion message
		System.out.println("There is too much cheese on the internet");
		//I compare the actual result with the expected result
		String actual = googlePage.getResult();
		String expected = "777";
		Assert.assertEquals(actual, expected);
	}
	
	@AfterClass
	void closeSelenium() {
		// Shutdown the browser
		driver.close();
	}

}
