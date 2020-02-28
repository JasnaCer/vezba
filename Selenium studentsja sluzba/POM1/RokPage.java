package zadatakPOM1;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RokPage {
	private WebDriver driver;

	public RokPage(WebDriver driver) {
		this.driver = driver;
	}
	// KREIRANJe NOVOG ROKA
	public WebElement getFormaRok() {
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
	
	public WebElement getPocetak() {
		return Utility.waitForElementPresence(driver, By.id("field_pocetak"), 10);
	}
	public void setPocetak(String poc) {
		WebElement pocetak = getPocetak();
		pocetak.clear();
		pocetak.sendKeys(poc);
	}
	public WebElement getKraj() {
		return Utility.waitForElementPresence(driver, By.id("field_kraj"), 10);
	}
	public void setKraj(String kra) {
		WebElement kraj = getKraj();
		kraj.clear();
		kraj.sendKeys(kra);
	}
	
	public WebElement getBtnSave(){
		 return Utility.waitForElementPresence
		 (driver,
		 By.xpath("//div[@class='modal-footer']/button[@type='submit']"),10);
		 }

		 public void createRok(String naziv, String pocetak, String kraj){
		 setNaziv(naziv);
		 setPocetak(pocetak);
		 setKraj(kraj);
		 getBtnSave().click();
		 }
}
