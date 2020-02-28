package zadatakTEST1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import zadatakPOM1.MenuPage;
import zadatakPOM1.StudentPage;
import zadatakPOM1.StudentTablePage;

public class AddStudent1Test extends BaseTest {

	


	MenuPage menuP;
	StudentPage studentP;
	StudentTablePage studentTP;

	@BeforeClass
	public void setUp() {
		
		menuP = new MenuPage(driver);
		studentP = new StudentPage(driver);
		studentTP = new StudentTablePage(driver);
	}
	@Test
	public void addStudent1() {
		// odlazim na stranucu studenti
		menuP.getEntitiesMenu().click();
		//proveravam da li se pojavio getStudent
		assertTrue(menuP.getStudent().isDisplayed());
		WebElement student = menuP.getStudent();
		student.click();
		// proveravam da li sam na stranici
		String expec = "Studentis";
		String act = studentTP.getTextMsg();
		assertTrue(act.equals(expec));


		// kreiranje studenta
		studentTP.getBtnCreateEdit().click();
		// proveraam jel se forma pojavila
		assertTrue(studentP.getFormaStudent().isDisplayed());
		// klik na create student
		studentP.createStudent("E1234", "Marko", "Markovic", "Novi Sad");
		
		/**Da li je dovoljna samo jedna od ove 2 asertacije za proveru da li je kreiran student
		 * i koja?
		 * prvu izbegavati ili koristiti samo kada je sigurno samo 1 element sa tim podacima, 
		 * ako nije jedinstveno moze baciti exception zbog 2 ili vise koje pronalazi i smesta u listu*/
		//proveravam da li je kreiran
		
		String studa = studentTP.redMogSudenta("E1234").getText();
		assertTrue(studa.contains("E1234 Marko Markovic Novi Sad"));
	
	}

}
