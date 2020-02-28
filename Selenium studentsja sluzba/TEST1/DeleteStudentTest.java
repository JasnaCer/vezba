package zadatakTEST1;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import zadatakPOM1.MenuPage;
import zadatakPOM1.StudentPage;
import zadatakPOM1.StudentTablePage;

public class DeleteStudentTest extends BaseTest {
	
	
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
	public void deleteStudents() {
		
//		//OVO MI NE TREBA JER SU TESTOVI U ISTOJ KLASI, JEDAN ZA DRUGIM
//		// odlazim na stranucu studenti
//		menuP.getEntitiesMenu().click();
//		WebElement student = menuP.getStudent();
//		student.click();
//		// proveravam da li sam na stranici
//		String expec = "Studentis";
//		String act = studentP.getTextMsg();
//		assertTrue(act.equals(expec));
		
		//kliknem na delete u redu u kome je student
		studentTP.deleteStudentByIndex("E 5652");
		//pojavi se delete forma
		assertTrue(studentTP.getDeleteForma().isDisplayed());
		//kliknem na delete dugme
		studentTP.getBttDelete().click();
		//proveravm da li su izbrisani
		assertFalse(studentTP.isStudentPresent("E 5652"));
		//isto i za drugog radim
		studentTP.deleteStudentByIndex("E1234");
		assertTrue(studentTP.getDeleteForma().isDisplayed());
		studentTP.getBttDelete().click();
		assertFalse(studentTP.isStudentPresent("E1234"));
	
	}
}
