package zadatakPOM1;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PrijavaPage {

	private WebDriver driver;

	public PrijavaPage(WebDriver driver) {
		this.driver = driver;
	}

	// KREIRANJe NOVE PRIJAVE
	public WebElement getFormaPrijava() {
		return Utility.waitForElementPresence(driver, By.xpath("//form[@name='editForm']"), 10);
	}

	public WebElement getTeorija() {
		return Utility.waitForElementPresence(driver, By.id("field_teorija"), 10);
	}

	public void setTeorija(String teor) {
		WebElement teorija = getTeorija();
		teorija.clear();
		teorija.sendKeys(teor);
	}

	public WebElement getZadaci() {
		return Utility.waitForElementPresence(driver, By.id("field_zadaci"), 10);
	}

	public void setZadaci(String zad) {
		WebElement zadaci = getZadaci();
		zadaci.clear();
		zadaci.sendKeys(zad);
	}

	// selektovanje roka
	public Select getRokoviSelect() {
		return new Select(Utility.waitForElementPresence(driver, By.id("field_ispitniRok"), 10));
	}
	public void setRok(String value) {
		this.getRokoviSelect().selectByVisibleText(value);
	}

	public Select getStudentiSelect() {
		return new Select(Utility.waitForElementPresence(driver, By.id("field_student"), 10));
	}
	public void setStudenti(String value) {
		this.getStudentiSelect().selectByVisibleText(value);
	}

	// selektovanje predmeta
	public Select getPredmetiSelect() {
		return new Select(Utility.waitForElementPresence(driver, By.id("field_predmet"), 10));
	}
	public void setPredmeti(String value) {
		this.getPredmetiSelect().selectByVisibleText(value);
	}

	 public WebElement getBtnSave(){
		 return Utility.waitForElementPresence
		 (driver,
		 By.xpath("//div[@class='modal-footer']/button[@type='submit']"),10);
		 }
	 public void createPrijavu(String teorija, String zadaci, String rok, String student, String predmet){
		 setTeorija(teorija);
		 setZadaci(zadaci);
		 setRok(rok);
		 setStudenti(student);
		 setPredmeti(predmet);
		 getBtnSave().click();
		 }

}
