package zadatakTEST2;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import zadatakPOM1.MenuPage;
import zadatakPOM1.StudentPage;
import zadatakPOM1.StudentTablePage;
import zadatakTEST1.BaseTest;

public class AddStudent1Test extends BaseTest{
	
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
		
		
		//proveravam da li je kreiran
		String studa = studentTP.redMogSudenta("E1234").getText();
		assertTrue(studa.contains("E1234 Marko Markovic Novi Sad"));
	
	}

}
