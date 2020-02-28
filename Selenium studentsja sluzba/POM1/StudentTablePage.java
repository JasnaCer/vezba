package zadatakPOM1;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class StudentTablePage {
	
	private WebDriver driver;
	
	
	public StudentTablePage (WebDriver driver){
		this.driver = driver;
	}
	

	
	
	//kad kliknem na studenti ovo je stranica koja se otvara
	
	//h2 poruka studentis za asertaciju da sam na stranici studenti
	public String getTextMsg(){
		return Utility.waitForElementPresence(driver, By.xpath("//h2[@translate='ssluzbaApp.studenti.home.title']"),10).getText();
	}
	//dugme create new student
	public WebElement getBtnCreateEdit(){
		return Utility.waitForElementPresence(driver, By.xpath("//button[@ui-sref='studenti.new']"),10);
	}
	//cela tabela studenata 
	public WebElement getStudentsTable(){	
		return Utility.waitForElementPresence(driver, By.xpath("//table[@class='jh-table table table-striped']"),10);
	}

//	//lista sa redom u kome je moj student(po indeksu)
//	public List<WebElement> getStudentFromTable(String brojIndeksa){
//		return(new WebDriverWait(driver,10))
//	.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
//			By.xpath("//*[contains(text(), '"+brojIndeksa+"')]/../..")));
//	}
//	//vadim iz liste red u kome je moj student, 
//	//jer samo njega i sadrzi, ako postoji student sa tim brojem indeksa
//	public WebElement redMogSudenta(String index){
//		return getStudentFromTable(index).get(0);
//	}
	public WebElement redMogSudenta(String index) {
		return Utility.waitForElementPresence(driver, By.xpath("//*[contains(text(),\"" + index + "\")]/../.."), 10);
	}
	
	public boolean isStudentPresent(String index){
		return Utility.isPresent(driver, By.xpath("//*[contains(text(),\"" + index + "\")]/../.."));
	}

//EDIT STUDENTA
	
	//Edit u redu gde je student.clik
	public void editStudenta(String index) {
		redMogSudenta(index).findElement(By.className("btn-primary")).click();
	}

	//BRISANJE STUDENTA

	//metoda za brisanje studenta po indeksu, nadje red po indeksu i klikne na delete
	public void deleteStudentByIndex(String index){
		redMogSudenta(index).findElement(By.className("btn-danger")).click();
	}
	
	//forma koja se otvara posle klika na delete u redu u kome je student
	public WebElement getDeleteForma(){
		return Utility.waitForElementPresence
				(driver, By.xpath("//div[@class='modal-content']/form[@name='deleteForm']"),10);
	}
	
	//delete dugme u novom prozoru
	public WebElement getBttDelete(){
		return Utility.waitForElementPresence
				(driver, By.xpath("//div[@class='modal-footer']/button[@type='submit']"),10);
		
	}
	
	public boolean isStudentDeleted(String index) {
		return Utility.waitForElementInvisibility(driver, By.xpath("//*[contains(text(), '"+index+"')]/../.."),10);
	}
	
		
}
