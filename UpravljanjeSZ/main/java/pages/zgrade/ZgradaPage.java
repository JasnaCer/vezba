package pages.zgrade;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pages.helpers.Utility;

public class ZgradaPage {
	private WebDriver driver;

	// konstruktor stranice
	public ZgradaPage(WebDriver driver) {
		this.driver = driver;
	}

	// h2 poruka Zgrada za asertaciju da sam na stranici zgrada
	public String getTextMsg() {
		return Utility.waitForElementPresence(driver, By.xpath("//div[@class='container']/h2"), 10).getText();
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

	// SELEKT
	public Select getPrikaz() {
		return new Select(Utility.waitForElementPresence(driver, By.id("prikaz"), 10));
	}

	public void setPrikaz(String value) {
		this.getPrikaz().selectByVisibleText(value);
	}
	// meni sa tabovima
	public WebElement getTabMenu() {
		return Utility.waitForElementPresence(driver, By.xpath("//ul[@class='nav nav-tabs']"), 10);
	}

	// tab stanovi
	public WebElement getStanoviTab() {
		return Utility.waitForElementPresence(driver, By.linkText("Stanovi"), 10);
	}

	// tab obavestenja
	public WebElement getObavestenjaTab() {
		return Utility.waitForElementPresence(driver, By.linkText("Obavestenja"), 10);
	}

	// tab predlozi tacke dnevnog reda
	public WebElement getPredloziTab() {
		return Utility.waitForElementPresence(driver, By.linkText("Predlozi tacke dnevnog reda"), 10);
	}

	// tab sastanci skupstine
	public WebElement getSastanciTab() {
		return Utility.waitForElementPresence(driver, By.linkText("Sastanci skupstine"), 10);
	}

	// tab kvarovi
	public WebElement getKvaroviTab() {
		return Utility.waitForElementPresence(driver, By.linkText("Kvarovi"), 10);
	}

	// TABELA
	// cela tabela sa stanovima
	public WebElement getStanoviTable() {
		return Utility.waitForElementPresence(driver, By.xpath("//table[@class='table table-hover']"), 10);
	}

	// red mog stana izvucen iz tabele po vlasniku
	public WebElement getStanIzTabele(String ime) {
		return Utility.waitForElementPresence(driver, By.xpath("//*[contains(text(),\"" + ime + "\")]/../.."), 10);
	}

	// metoda za proveru da li stan postoji u tabeli, po imenu vlasnika
	public boolean isStanPresent(String ime) {
		return Utility.isPresent(driver, By.xpath("//*[contains(text(),\"" + ime + "\")]/../.."));
	}

	// vlasnik link u tabeli
	public WebElement getLinkVlasnik() {
		return Utility.waitForElementPresence(driver,
				By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-stanovi/div/div[1]/table/tbody/tr[1]/td[1]/a"),
				10);
	}

	// dobavljanje vlasnik i stanari dugmeta
	public WebElement getBtnVlasnikStanar() {
		return Utility.waitForElementPresence(driver,
				By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-stanovi/div/div[1]/table/tbody/tr[1]/td[2]/a"),
				10);
	}
	 // dobavljanje cekboksa na stranici kvarovi
	public WebElement getCbZavrseniKvarovi() {
		return Utility.waitForElementPresence(driver,
				By.xpath("//input[@type='checkbox']"),
				10);
	}
   
}
