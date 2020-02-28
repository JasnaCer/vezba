package zadatakTEST1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import zadatakPOM1.MenuPage;
import zadatakPOM1.StudentPage;
import zadatakPOM1.StudentTablePage;

public class AddStudent2Test extends BaseTest {

	

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
	public void addStudent2() {
//		//OVO MI NE TREBA JER SU TESTOVI U ISTOJ KLASI, JEDAN ZA DRUGIM
		//TREBA MI KADA IZVRSAVAM TESOVE NEZAVISNO JEDAN OD DRUGOG
//		// odlazim na stranucu studenti
//		menuP.getEntitiesMenu().click();
		//proveravam da li se pojavio getStudent
		//assertTrue(menuP.getStudent().isDisplayed());
//		WebElement student = menuP.getStudent();
//		student.click();
//		// proveravam da li sam na stranici
//		String expec = "Studentis";
//		String act = studentP.getTextMsg();
//		assertTrue(act.equals(expec));
		
		
		// kreiranje drugog studenta
		studentTP.getBtnCreateEdit().click();
		// proveraam jel se forma pojavila
		assertTrue(studentP.getFormaStudent().isDisplayed());
		studentP.createStudent("E 5652", "Nikola", "Nikolic", "Beograd");
		
		//proveravam da li je kreiran
		String studa = studentTP.redMogSudenta("E 5652").getText();
		assertTrue(studa.contains("E 5652 Nikola Nikolic Beograd"));

	}
}
