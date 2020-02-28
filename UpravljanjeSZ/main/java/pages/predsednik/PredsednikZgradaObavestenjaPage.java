package pages.predsednik;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pages.helpers.Utility;

public class PredsednikZgradaObavestenjaPage {
	private WebDriver driver;

	// konstruktor stranice
	public PredsednikZgradaObavestenjaPage(WebDriver driver) {
		this.driver = driver;
	}

	// h2 poruka Zgrada za asertaciju da sam na stranici zgrada
	public String getTextMsg() {
		return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrada/div/h2"), 10).getText();
	}

	// adresa
	public String getTextAdresa() {
		return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrada/div/div[1]/h5[1]"), 10)
				.getText();
	}

	// predsednik
	public String getTextPredsednik() {
		return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrada/div/div[1]/h5[2]"), 10)
				.getText();
	}

	// predsedniklink
	public WebElement getLinkPredsednik() {
		return Utility.waitForElementPresence(driver, By.partialLinkText("Gospodin Predsednik"), 10);
	}

	// MENI sa tabobvima
	public WebElement getTabObavestenja() {
		return Utility.waitForElementPresence(driver,
				By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-navbar-zgrada/ul/li[1]"), 10);
	}

	public WebElement getTabPredloziTacke() {
		return Utility.waitForElementPresence(driver,
				By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-navbar-zgrada/ul/li[2]"), 10);
	}

	public WebElement getTabSastanciSkupstine() {
		return Utility.waitForElementPresence(driver,
				By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-navbar-zgrada/ul/li[3]"), 10);
	}

	public WebElement getTabkvarovi() {
		return Utility.waitForElementPresence(driver,
				By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-navbar-zgrada/ul/li[4]"), 10);
	}

	// SELEKT

	public Select getPrikaz() {
		return new Select(Utility.waitForElementPresence(driver, By.id("prikaz"), 10));
	}

	public void setPrikaz(String value) {
		this.getPrikaz().selectByVisibleText(value);
	}

	public WebElement btnDodajObavestenje() {
		return Utility.waitForElementPresence(driver, By.id("dodajObavestenje"), 10);
	}

	public WebElement formaDodajObavestenje() {
		return Utility.waitForElementPresence(driver,
				By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-dodaj-obavestenje/div/form"), 10);
	}

	public WebElement formaDodajObavestenjeNaslov() {
		return Utility.waitForElementPresence(driver,
				By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-dodaj-obavestenje/div/form/fieldset/legend"),
				10);
	}

	public WebElement getTextPolje() {
		return Utility.waitForElementPresence(driver, By.id("tekstObavestenja"), 10);
	}

	public void setTextPolje(String te) {
		WebElement text = getTextPolje();
		text.clear();
		text.sendKeys(te);
	}

	public WebElement btnPotvrdi() {
		return Utility.waitForElementPresence(driver, By.id("dodajObavestenje"), 10);
	}

	public WebElement msgAlert() {
		return Utility.waitForElementPresence(driver, By.xpath("//*[@id='toast-container']/div/div"), 15);
	}

	public WebElement btnIzmeniObavestenje() {
		return Utility.waitForElementPresence(driver, By.id("izmeniObavestenje"), 10);
	}

	// TABELICA OBAVESTENJE
	public WebElement poljeObavestenjeTabela() {
		return Utility.waitForElementPresence(driver,
				By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-obavestenja/div[1]/div/table"), 10);
	}

	// red iz tabele po sadrzaju
	public WebElement getRedPoljeObavestenjeTabela(String sadrzaj) {
		return Utility.waitForElementPresence(driver, By.xpath("//*[contains(text(),\"" + sadrzaj + "\")]/../.."), 10);
	}

	// metoda za proveru da li korisnik postoji u tabeli, po imenu
	public boolean isredpoljeObavestenjeTabela(String sadrzaj) {
		return Utility.isPresent(driver, By.xpath("//*[contains(text(),\"" + sadrzaj + "\")]/../.."));
	}
	public WebElement getTextKojiMenjam() {
		return Utility.waitForElementPresence(driver, By.id("noviTekst"), 10);
	}

	public void setTextKojiMenjam(String te) {
		WebElement text = getTextKojiMenjam();
		text.clear();
		text.sendKeys(te);
	}
	

	public WebElement btnPotvrdi2() {
		return Utility.waitForElementPresence(driver,
				By.xpath(
						"/html/body/app-root/app-zgrada/div/div[2]/app-obavestenja/div[1]/div/table/tbody/tr[3]/td/span/a[2]/span"),
				10);
	}

	public WebElement btnOdustani() {
		return Utility.waitForElementPresence(driver,
				By.xpath(
						"/html/body/app-root/app-zgrada/div/div[2]/app-obavestenja/div[1]/div/table/tbody/tr[3]/td/span/a[3]/span"),
				10);
	}

	public WebElement btnObrisi() {
		return Utility.waitForElementPresence(driver,
				By.xpath(
						"/html/body/app-root/app-zgrada/div/div[2]/app-obavestenja/div[1]/div/table/tbody/tr[3]/td/span/a[4]/span"),
				10);
	}
}
