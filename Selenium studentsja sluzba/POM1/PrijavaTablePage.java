package zadatakPOM1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PrijavaTablePage {
	private WebDriver driver;

	public PrijavaTablePage(WebDriver driver) {
		this.driver = driver;
	}

	// h2 poruka ispitneprijaves za asertaciju da sam na stranici prijave
	public String getTextMsg() {
		return Utility
				.waitForElementPresence(driver, By.xpath("//h2[@translate='ssluzbaApp.ispitnePrijave.home.title']"), 10)
				.getText();
	}

	// dugme create new prijava
	public WebElement getBtnCreateEdit() {
		return Utility.waitForElementPresence(driver, By.xpath("//button [@ui-sref=\"ispitnePrijave.new\"]"), 10);
	}

	// cela tabela prijava
	public WebElement getPrijaveTable() {
		return Utility.waitForElementPresence(driver, By.xpath("//table[@class='jh-table table table-striped']"), 10);
	}

	// red moje prijave izvucen iz tabele po nazivu
	public WebElement redMojePrijave(String rok) {
		return Utility.waitForElementPresence(driver, By.xpath("//*[contains(text(),\"" + rok + "\")]/../.."), 10);
	}

	public boolean isPrijavaPresent(String naziv) {
		return Utility.isPresent(driver, By.xpath("//*[contains(text(),\"" + naziv + "\")]/../.."));
	}

	// BRISANJE prijave

	// metoda za brisanje prijave po nazivu, nadje red po nazivu i klikne na
	// delete
	public void deletePrijavaByNazivRoka(String naziv) {
		redMojePrijave(naziv).findElement(By.className("btn-danger")).click();
	}
	
	// forma koja se otvara posle klika na delete u redu u kome je prijava
	public WebElement getDeleteForma() {
		return Utility.waitForElementPresence(driver,
				By.xpath("//div[@class='modal-content']/form[@name='deleteForm']"), 10);
	}

	// delete dugme u novom prozoru
	public WebElement getBttDelete() {
		return Utility.waitForElementPresence(driver, By.xpath("//div[@class='modal-footer']/button[@type='submit']"),
				10);

	}
	public boolean isPrijavaDeleted(String naziv) {
		return Utility.waitForElementInvisibility(driver, By.xpath("//*[contains(text(), '"+naziv+"')]/../.."),10);
	}
	// EDITOVANJE prijave

	// Edit u redu gde je prijava.clik
	public void editPrijave(String index) {
		redMojePrijave(index).findElement(By.className("btn-primary")).click();
	}

}
