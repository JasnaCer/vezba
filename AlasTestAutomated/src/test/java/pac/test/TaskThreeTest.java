package pac.test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import taskThree.pages.AddCandidatePage;
import taskThree.pages.CandidatesPage;
import taskThree.pages.DashboardPage;
import taskThree.pages.LoginPage;
import taskThree.pages.VacanciesPage;

public class TaskThreeTest extends BaseTest{
	
	private AddCandidatePage addCandidatePage;
	private CandidatesPage candidatesPage;
	private DashboardPage dashboardPage;
	private LoginPage loginPage;
	private VacanciesPage vacanciesPage;
	
	@BeforeClass
	public void setupSelenium() {
		
		//Driver instantiation
		/*System.setProperty("webdriver.gecko.driver", "geckodriver");
		driver = new FirefoxDriver();*/
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver = new ChromeDriver();
		
		//Page classes instantiation
		loginPage = new LoginPage(driver);
		addCandidatePage = new AddCandidatePage(driver);
		candidatesPage = new CandidatesPage(driver);
		dashboardPage = new DashboardPage(driver);
		vacanciesPage = new VacanciesPage(driver);
		
		// navigate to the desired page
		driver.get("https://orangehrm-demo-6x.orangehrmlive.com");
		// maximize  window
		driver.manage().window().maximize();
				
		//Checking that the Login page is loaded, not necessary, but desirable
		String expected = "Login";
		String actual = loginPage.getTitle();
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 1)
	public void loginTest(){
		//click on button login and login
		loginPage.getLoginBtn().click();

		//Checking that the Dashboard page is loaded
		String actual = dashboardPage.getTitle();
		String expected = "Dashboard";
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 2)
	public void GoToVacanciesPageTest(){
		//waiting for the element to appear
		dashboardPage.getRecruitment().isDisplayed();
		//click on link Recruitment and go to Vacancies page
		dashboardPage.getRecruitment().click();
		
		//Checking that the Vacancies page is loaded
		String expected = "https://orangehrm-demo-6x.orangehrmlive.com/client/#/noncore/recruitment/viewRecruitmentModule";
		String actual = driver.getCurrentUrl();
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 3)
	public void goToCandidatesPageTest(){
		//the element is located in another frame
		driver.switchTo().frame(0);
		vacanciesPage.getMenu().click();
		vacanciesPage.getCandidates().click();
		//Checking that the Candidates page is open
		Assert.assertTrue(candidatesPage.getCandidatesTable().isDisplayed());
		
		//print out the number of candidates
		Integer rows = candidatesPage.noRow();
		System.out.println("Number of all rows are : " + rows );
	}
	
	@Test(priority = 4)
	public void addCandidateTest(){
		//Open modal Add candidate
		candidatesPage.getAddBtn().click();
		//RESUME document is required for this text!!!
		// count number of rows before add candidate
		Integer rows = candidatesPage.noRow();
		
		//waiting to open modal
		addCandidatePage.getCandidateModal().isDisplayed();
		//add candidate - forwarding:path to resume and values other fields
		addCandidatePage.addCandidate("/home/tester/Resume.txt", "QA", "Automation", "qaautomation@gmail.com");
		
		// count number of rows after add candidate
		Integer rowsNew = candidatesPage.noRow();
		Integer one = rowsNew - rows; 
		Integer exp = 1;
		Assert.assertEquals(one, exp);
		
		//waiting for an alert
		addCandidatePage.getElementAlert().isDisplayed();
		//checking that the candidate has been added to the table
		Assert.assertEquals(addCandidatePage.getElementAlert().getText(),"Successfully Saved");
	}
	
	@Test(priority = 5)
	public void deleteCandidateTest(){
		// count number of rows before delete candidate
		Integer rows1 = candidatesPage.noRow();
		//deleting a candidate from the table by name
		candidatesPage.deleteCandidateByName("QA");
		
		//waiting for an alert
		candidatesPage.getElementAlert().isDisplayed();
		//checking that the candidate has been deleted to the table
		Assert.assertEquals(candidatesPage.getElementAlert().getText(),"Successfully Deleted");
		
		//Checking that the Candidates page is open, provides time to load the number of rows after deletion
		Assert.assertTrue(candidatesPage.getCandidatesTable().isDisplayed());
		
		//count number of rows after delete candidate 
		Integer rowsNew1 = candidatesPage.noRow();
		Integer one1 = rows1 - rowsNew1; 
		Integer exp = 1;
		Assert.assertEquals(one1, exp);
	}

	@Test(priority = 6)
	public void logoutTest(){
		//Open the side menu
		vacanciesPage.getMenu().click();
		candidatesPage.logout();
	
		//Checking that the Login page is loaded
		String actual = loginPage.getTitleLogout();
		String expected = "Login";
		Assert.assertEquals(actual, expected);
	}
	
	@AfterClass
	void closeSelenium() {
		// Shutdown the browser
		driver.close();
	}
}

