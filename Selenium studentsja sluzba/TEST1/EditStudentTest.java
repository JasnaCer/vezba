package zadatakTEST1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import zadatakPOM1.MenuPage;
import zadatakPOM1.StudentPage;
import zadatakPOM1.StudentTablePage;

public class EditStudentTest extends BaseTest{
	

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
	public void editStudent() {
		//OVO MI NE TREBA JER SU TESTOVI U ISTOJ KLASI, JEDAN ZA DRUGIM
//		// odlazim na stranucu studenti
//		menuP.getEntitiesMenu().click();
//		WebElement student = menuP.getStudent();
//		student.click();
//		// proveravam da li sam na stranici
//		String expec = "Studentis";
//		String act = studentP.getTextMsg();
//		assertTrue(act.equals(expec));
		
		//PROVERAVAM DA LI POSTOJI STUDENT SA INDEKSOM
		assertTrue(studentTP.isStudentPresent("E 5652"));
		
		//pozivam metodu za edit
		studentTP.editStudenta("E 5652");
		//proveravam forma da li se pojavila
		assertTrue(studentP.getFormaStudent().isDisplayed());
		//menjam podatak
		studentP.setGrad("Kraljevo");
		//proveravam da li je podatak izmenjen
		studentP.getBtnSave().click();
		
		
		String studa = studentTP.redMogSudenta("E 5652").getText();
		// tvrdim da postoji red koji sadrzi broj indeksa
		assertTrue(studa.contains("E 5652 Nikola Nikolic Kraljevo"));
		
	}

}
