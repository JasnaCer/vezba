package zadatakPOM1;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;

public class PredmetPage {

	private WebDriver driver;

	public PredmetPage(WebDriver driver) {
		this.driver = driver;
	}

	// kada na stranici predmeti kliknem na dugme create ovo je forma koja se
	// otvara
	// KREIRANJ NOV PREDMET
	public WebElement getFormaPredmet() {
		return Utility.waitForElementPresence(driver, By.xpath("//form[@name='editForm']"), 10);
	}

	public WebElement getNaziv() {
		return Utility.waitForElementPresence(driver, By.id("field_naziv"), 10);
	}

	public void setNaziv(String naz) {
		WebElement naziv = getNaziv();
		naziv.clear();
		naziv.sendKeys(naz);
	}

	// selektovanje studenta
	public Select getStudentiSelect() {
		return new Select(Utility.waitForElementPresence(driver, By.id("field_studenti"), 10));
	}

	public void setStudenta(ArrayList<String>studenti) {
		Select student = this.getStudentiSelect();
		student.deselectAll();
		for (String studa: studenti) {
			student.selectByVisibleText(studa);
		}
	}
	// selektovanje nastavnika
	public Select getSelectNastavnika() {
		return new Select(Utility.waitForElementPresence(driver, By.id("field_nastavnici"), 10));
	}

	public void setNastavnika(ArrayList<String> nastavnici) {
		Select nastavnik = this.getSelectNastavnika();// "taj"selektovani je moj objekat selekt
		nastavnik.deselectAll();  //deselektujem ako ima selektovanih opcija
		for (String nasta : nastavnici) {//mog nastavnika u listi nastavnika
			nastavnik.selectByVisibleText(nasta);// selektuj po..
		}
		
	}

	 public WebElement getBtnSave(){
	 return Utility.waitForElementPresence
	 (driver,
	 By.xpath("//div[@class='modal-footer']/button[@type='submit']"),10);
	 }

	 public void createPredmet(String naz, ArrayList<String> studenti, ArrayList<String> nastavnici){
	 setNaziv(naz);
	 setStudenta(studenti);
	 setNastavnika(nastavnici);
	 getBtnSave().click();
	 }

}
