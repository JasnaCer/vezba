package zadatakPOM1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PredmetTablePage {

	private WebDriver driver;

	public PredmetTablePage(WebDriver driver) {
		this.driver = driver;
	}

	// kad kliknem na predmeti ovo je stranica koja se otvara

	// h2 poruka predmetis za asertaciju da sam na stranici predmeti
	public String getTextMsg() {
		return Utility.waitForElementPresence(driver, By.xpath("//h2[@translate='ssluzbaApp.predmeti.home.title']"), 10)
				.getText();
	}

	// dugme create new predmeti
	public WebElement getBtnCreateEdit() {
		return Utility.waitForElementPresence(driver, By.xpath("//button [@ui-sref=\"predmeti.new\"]"), 10);
	}

	// cela tabela predmeti
	public WebElement getPredmetiTable() {
		return Utility.waitForElementPresence(driver, By.xpath("//table[@class='jh-table table table-striped']"), 10);
	}

//	// lista sa redom u kome je moj predmet(po nazivu )
//	public List<WebElement> getPredmetFromTable(String naziv) {
//		return (new WebDriverWait(driver, 10)).until(ExpectedConditions
//				.presenceOfAllElementsLocatedBy(By.xpath("//*[contains(text(), '" + naziv + "')]/../..")));
//	}
//
//	// vadim iz liste red u kome je moj predmet,
//	// jer samo njega i sadrzi, ako postoji predmet sa tim nazivom
//	public WebElement redMogPredmeta(String naziv) {
//		return getPredmetFromTable(naziv).get(0);
//	}
	public WebElement redMogPredmeta(String naziv) {
		return Utility.waitForElementPresence(driver, By.xpath("//*[contains(text(),\"" + naziv + "\")]/../.."), 10);
	}

	public boolean isPredmetPresent(String naziv) {
		return Utility.isPresent(driver, By.xpath("//*[contains(text(),\"" + naziv + "\")]/../.."));
	}
	
	//BRISANJE Predmeta

			//metoda za brisanje predmeta po nazivu, nadje red po nazivu i klikne na delete
			public void deletePredmetByNaziv(String index){
				redMogPredmeta(index).findElement(By.className("btn-danger")).click();
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
			public boolean isPredmetDeleted(String naziv) {
				return Utility.waitForElementInvisibility(driver, By.xpath("//*[contains(text(), '"+naziv+"')]/../.."),10);
			}
}
