package zadatakTEST2;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import zadatakPOM1.MenuPage;
import zadatakPOM1.StudentPage;
import zadatakPOM1.StudentTablePage;
import zadatakTEST1.BaseTest;

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
