package zadatakPOM1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RokTablePage {
	private WebDriver driver;

	public RokTablePage(WebDriver driver) {
		this.driver = driver;
	}

	// h2 poruka ispitnirokovis za asertaciju da sam na stranici rokovi
	public String getTextMsg() {
		return Utility
				.waitForElementPresence(driver, By.xpath("//h2[@translate='ssluzbaApp.ispitniRokovi.home.title']"), 10)
				.getText();
	}

	// dugme create new rok
	public WebElement getBtnCreateEdit() {
		return Utility.waitForElementPresence(driver, By.xpath("//button[@ui-sref='ispitniRokovi.new']"), 10);
	}

	// cela tabela rokovi
	public WebElement getRokoviTable() {
		return Utility.waitForElementPresence(driver, By.xpath("//table[@class='jh-table table table-striped']"), 10);
	}

	// red mog roka izvucen iz tabele po nazivu
	public WebElement redMogRoka(String naziv) {
		return Utility.waitForElementPresence(driver, By.xpath("//*[contains(text(),\"" + naziv + "\")]/../.."), 10);
	}

	public boolean isRokPresent(String naziv) {
		return Utility.isPresent(driver, By.xpath("//*[contains(text(),\"" + naziv + "\")]/../.."));
	}

	// BRISANJE roka

	// metoda za brisanje roka po nazivu, nadje red po nazivu i klikne na delete
	public void deleteRokByNaziv(String naziv) {
		redMogRoka(naziv).findElement(By.className("btn-danger")).click();
	}
	
	//ovo sam uradila po vasoj sugestiji za invisibilityOfElementLocated
	//u utility sam napravila metodu waitForElementInvisibility
	//koj ceka vraca true ako element nije prisutan na stranici
	//saceka interval vremena i tek onda vraca vrednost, sto omogucava da se asertacija ne odradi pre 
	// registrovanja da je lement uklonjen sa stranice, metoda:
	/*public static boolean waitForElementInvisibility(WebDriver driver, By selector, int waitInterval) {
		boolean invisible = (new WebDriverWait(driver,waitInterval))
				.until(ExpectedConditions.invisibilityOfElementLocated(selector));
		return invisible;
	}*/
	public boolean isRokDeleted(String naziv) {
		return Utility.waitForElementInvisibility(driver, By.xpath("//*[contains(text(), '"+naziv+"')]/../.."),10);
	}

	// forma koja se otvara posle klika na delete u redu u kome je rok
	public WebElement getDeleteForma() {
		return Utility.waitForElementPresence(driver,
				By.xpath("//div[@class='modal-content']/form[@name='deleteForm']"), 10);
	}

	// delete dugme u novom prozoru
	public WebElement getBttDelete() {
		return Utility.waitForElementPresence(driver, By.xpath("//div[@class='modal-footer']/button[@type='submit']"),
				10);

	}

	// EDITOVANJE roka

	// Edit u redu gde je rok.clik
	public void editRok(String index) {
		redMogRoka(index).findElement(By.className("btn-primary")).click();
	}

}
