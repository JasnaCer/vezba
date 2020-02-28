package pages.predsednik;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pages.helpers.Utility;

public class PredsednikZgradaKvaroviDodajPage {
	private WebDriver driver;

	// konstruktor stranice
	public PredsednikZgradaKvaroviDodajPage(WebDriver driver) {
		this.driver = driver;
	}

	// dobavljanje i setovanje lokacija polja
	public WebElement getLokacija() {
		return Utility.waitForElementPresence(driver, By.id("mesto"), 10);
	}

	public void setLokacija(String mest) {
		WebElement mesto = getLokacija();
		mesto.clear();
		mesto.sendKeys(mest);
	}
	//dobavljanje poruke ovo polje ne sme biti prazno lokacija
	public WebElement msgLokacijaPrzna() {
		return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-dodaj-kvar/div/form/fieldset/div[1]/div/div"), 10);
	}
	// dobavljanje i setovanje opis polja
	public WebElement getOpis() {
		return Utility.waitForElementPresence(driver, By.id("opis"), 10);
	}

	public void setOpis(String op) {
		WebElement opis = getOpis();
		opis.clear();
		opis.sendKeys(op);
	}
	//dobavljanje poruke ovo polje ne sme biti prazno opis
	public WebElement msgOpisPrzan() {
		return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-dodaj-kvar/div/form/fieldset/div[2]/div/div"), 10);
	}
	// btnOdgovornoLice
	public WebElement btnOdgovornoLice() {
		return Utility.waitForElementPresence(driver, By.id("odgovorno_lice"), 10);
	}

	// btnDodajKvar
	public WebElement btnDodajKvar() {
		return Utility.waitForElementPresence(driver, By.id("submit"), 10);
	}

	// formaOdgovornoLice
	public WebElement getFormaOdgovornoLice() {
		return Utility.waitForElementPresence(driver,
				By.xpath(
						"/html/body/app-root/app-zgrada/div/div[2]/app-dodaj-kvar/div/form/fieldset/moguci-odgovorni-modal/div[2]/div"),
				10);
	}

	public WebElement msgTitleForme() {
		return Utility.waitForElementPresence(driver,
				By.xpath(
						"/html/body/app-root/app-zgrada/div/div[2]/app-dodaj-kvar/div/form/fieldset/moguci-odgovorni-modal/div[2]/div/div/div[1]/h2"),
				10);
	}

	public WebElement getPretraga() {
		return Utility.waitForElementPresence(driver,
				By.xpath(
						"/html/body/app-root/app-zgrada/div/div[2]/app-dodaj-kvar/div/form/fieldset/moguci-odgovorni-modal/div[2]/div/div/div[2]/label/input"),
				10);
	}

	public void setPretraga(String ol) {
		WebElement odgovornol = getPretraga();
		odgovornol.clear();
		odgovornol.sendKeys(ol);
	}

	// SELEKT
	public Select getSelektPrikaz() {
		return new Select(Utility.waitForElementPresence(driver, By.id("prikaz"), 10));
	}

	public void setSelektPrikaz(String value) {
		this.getSelektPrikaz().selectByVisibleText(value);
	}

	// TABELA IZBOR ODGOVORNOG LICA
	public WebElement getOdgovornoLiceTable() {
		return Utility.waitForElementPresence(driver,
				By.xpath(
						"/html/body/app-root/app-zgrada/div/div[2]/app-dodaj-kvar/div/form/fieldset/moguci-odgovorni-modal/div[2]/div/div/div[2]/table"),
				10);
	}

	// red odgovornog lica izvucen iz tabele po imenu
	public WebElement getOdgovornoLiceIzTabele(String ime) {
		return Utility.waitForElementPresence(driver, By.xpath("//*[contains(text(),\"" + ime + "\")]/../.."), 10);
	}

	// metoda za proveru da li korisnik postoji u tabeli, po imenu
	public boolean isOdgovornoLicePresent(String ime) {
		return Utility.isPresent(driver, By.xpath("//*[contains(text(),\"" + ime + "\")]/../.."));
	}

	public WebElement btnPrihvati() {
		return Utility.waitForElementPresence(driver, By.id("button_2"), 10);
	}

	public WebElement btnOdustani() {
		return Utility.waitForElementPresence(driver,
				By.xpath(
						"/html/body/app-root/app-zgrada/div/div[2]/app-dodaj-kvar/div/form/fieldset/moguci-odgovorni-modal/div[2]/div/div/div[3]/button"),
				10);
	}

}
