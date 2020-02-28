package pac.test;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import junit.framework.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import pac.helpers.Utils;
import taskOne.pages.DemoqaPage;
import taskOne.pages.DroppablePage;
import taskOne.pages.GooglePage;
import taskOne.pages.TooltipPage;

public class TaskOneTest extends BaseTest{

	private GooglePage googlePage;
	private DemoqaPage demoqaPage;
	private DroppablePage droppablePage ;
	private TooltipPage tooltipPage;

	@BeforeClass
	public void setupSelenium() {
		//Driver instantiation
		/*System.setProperty("webdriver.gecko.driver", "geckodriver");
		driver = new FirefoxDriver();*/
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver = new ChromeDriver();
		//Page classes instantiation
		googlePage = new GooglePage(driver);
		demoqaPage = new DemoqaPage(driver);
		droppablePage = new DroppablePage(driver);
		tooltipPage =  new TooltipPage(driver);
		
		// navigate to the desired page
		driver.get("https://www.google.com");
		// maximize  window
		driver.manage().window().maximize();
				
		//Checking that the Google page is loaded, not necessary, but desirable
		String expected = "https://www.google.com/";
		String actual = driver.getCurrentUrl();
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 1)
	public void searchGoToDemoqaPage(){
		//I call method from googlePage class
		googlePage.searching("demoqa.com");
		//Hit the first result which will navigate to demoqa.com
		googlePage.getLink().click();
		//Checking that the DemoQa page is loaded
		String actual1 = demoqaPage.getTitle();
		//System.out.println(actual);
		String expected1 = "Home";
		Assert.assertEquals(actual1, expected1);
	}
	
	@Test(priority = 2)
	public void droppableTest(){
		//Click on the Droppable link on the left hand side in the Interactions section
		demoqaPage.getDroppable().click();
		//Checking that the Droppable window is open
		String actual2 = demoqaPage.getTitle();
		String expected2 = "Droppable";
		Assert.assertEquals(actual2, expected2);
	}
	
	@Test(priority = 3)
	public void dragAndDrop() throws Exception{
		//Pick and drop the “Drag me to my target” box into the “Drop here” box
		//Use Action class for drag and drop
		Actions action = new Actions(driver);
		//create elements (arguments) for method dragAndDrop() action class
		WebElement from = droppablePage.getFrom();
		WebElement to =droppablePage.getTo();
		//Dragged and dropped
		action.dragAndDrop(from, to).build().perform();
		
		// if the element is dragged it is printed Dropped!
		String actual3 = droppablePage.getText();
		String expected3 = "Dropped!";
		Assert.assertEquals(actual3, expected3);
		//print out the text from the “Drop here” box after dragging element
		System.out.println(droppablePage.getText());
		
		//call method takeSnapShot() from Utils class, this function will take screenshot
		Utils.takeSnapShot(driver, "/home/tester/screenshot1");
	}
	
	@Test(priority = 4)
	public void goTooltipTest(){
		//Click on the Tooltip link on the left hand side in the Widgets section.
		tooltipPage.getTooltip().click();
		//Checking that the Tooltip window is open
		String actual4 = tooltipPage.getTitle();
		String expected4 = "Tooltip";
		Assert.assertEquals(actual4, expected4);	
	}
	
	@Test(priority = 5)
	public void popUpTest(){
		//Move your cursor to the “Your age” input element
		Actions actions = new Actions(driver);
		//move cursor to middle “Your age” element
		actions.moveToElement(tooltipPage.getYourAge()).perform();
		//print out the text from the pop-up 
		System.out.println(tooltipPage.getMsgAlert());
		////I compare the actual text with the expected text from the pop-up
		String actual5 = tooltipPage.getMsgAlert();
		String expected5 = "We ask for your age only for statistical purposes.";
		Assert.assertEquals(actual5, expected5);
	}
	
	@AfterClass
	public void closeSelenium() {
		// Shutdown the browser
		driver.quit();
	}
}
