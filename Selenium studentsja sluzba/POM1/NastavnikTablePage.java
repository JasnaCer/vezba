package zadatakPOM1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NastavnikTablePage {
private WebDriver driver;
	
	public NastavnikTablePage (WebDriver driver){
		this.driver = driver;
	}
	
	//h2 poruka nastavniks za asertaciju da sam na stranici nastavniki
		public String getTextMsg(){
			return Utility.waitForElementPresence(driver, By.xpath("//h2[@translate='ssluzbaApp.nastavnici.home.title']"),10).getText();
		}
		//dugme create new nastavnik
		public WebElement getBtnCreateEdit(){
			return Utility.waitForElementPresence(driver, By.xpath("//button[@ui-sref='nastavnici.new']"),10);
		}
		//cela tabela nastavnika
		public WebElement getNastavniciTable(){	
			return Utility.waitForElementPresence(driver, By.xpath("//table[@class='jh-table table table-striped']"),10);
		}
//		//lista sa redom u kome je moj nastavnik(po imenu i prezimenu)
//		public List<WebElement> getNastavnikFromTable(String ime){
//			return(new WebDriverWait(driver,10))
//		.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
//				By.xpath("//*[contains(text(), '"+ime+"')]/../..")));
//		}
//		//vadim iz liste red u kome je moj student, 
//		//jer samo njega i sadrzi, ako postoji student sa tim brojem indeksa
//		public WebElement redMogNastavnika(String ime){
//			return getNastavnikFromTable(ime).get(0);
//		}
		// red moje prijave izvucen iz tabele po nazivu
		public WebElement redMogNastavnika(String ime) {
			return Utility.waitForElementPresence(driver, By.xpath("//*[contains(text(),\"" + ime + "\")]/../.."), 10);
		}
		public boolean isNastavnikPresent(String ime) {
			return Utility.isPresent(driver, By.xpath("//*[contains(text(),\"" + ime + "\")]/../.."));
		}
		
		
		//BRISANJE Nastavnika


		//metoda za brisanje nastavnika po imenu, nadje red po imenu i klikne na delete
		public void deleteNastavnikByIme(String ime){
			redMogNastavnika(ime).findElement(By.className("btn-danger")).click();
		}
		
		//forma koja se otvara posle klika na delete u redu u kome je nastavnik
		public WebElement getDeleteForma(){
			return Utility.waitForElementPresence
					(driver, By.xpath("//div[@class='modal-content']/form[@name='deleteForm']"),10);
		}
		
		//delete dugme u novom prozoru
		public WebElement getBttDelete(){
			return Utility.waitForElementPresence
					(driver, By.xpath("//div[@class='modal-footer']/button[@type='submit']"),10);
			
		}
		public boolean isNastavnikDeleted(String ime) {
			return Utility.waitForElementInvisibility(driver, By.xpath("//*[contains(text(), '"+ime+"')]/../.."),10);
		}
		
}
