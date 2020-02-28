package pages.stanari;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pages.helpers.Utility;

public class StanarPage {
	private WebDriver driver;

	// konstruktor stranice
	public StanarPage(WebDriver driver) {
		this.driver = driver;
	}

	// h2 poruka stanar za asertaciju da sam na stranici stan
	public String getMsg() {
		return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-stanar/div/div/h2"), 10)
				.getText();
	}

	// imePrezime
	public String getImePrezime() {
		return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-stanar/div/div/h5[1]"), 10)
				.getText();
	}
	// TABELA Stanar zgrada gde stanuje
	// cela tabela sa stanarima

	public WebElement getStanGdeStanujeTable() {
		return Utility.waitForElementPresence(driver, By.id("stan"), 10);
	}

	// red mog stanara izvucen iz tabele po imenu
	public WebElement getStanGdeStanujeRed(String adresa) {
		return Utility.waitForElementPresence(driver, By.xpath("//*[contains(text(),\"" + adresa + "\")]/../.."), 10);
	}

	// metoda za proveru da li adresa postoji u tabeli
	public boolean isAdresaPresent(String adresa) {
		return Utility.isPresent(driver, By.xpath("//*[contains(text(),\"" + adresa + "\")]/../.."));
	}
	//link adresa tabela stanuje
	public WebElement getLinkAdresS() {
		return Utility.waitForElementPresence(driver, By.xpath("//*[@id='stan']/tbody/tr/td[1]/a"), 10);
	}
	//link stan
	public WebElement getLinkStanS() {
		return Utility.waitForElementPresence(driver, By.xpath("//*[@id='stan']/tbody/tr/td[2]/a"), 10);
	}
	//TABELA Stanovi u kojima je vlasnik:
	public WebElement getStanGdeJeVlasnikTable() {
		return Utility.waitForElementPresence(driver, By.id("vlasnikStanova"), 10);
	}

	// red mog stanara izvucen iz tabele po imenu
	public WebElement getStanGdeJeVlasnikRed(String adresa) {
		return Utility.waitForElementPresence(driver, By.xpath("//*[contains(text(),\"" + adresa + "\")]/../.."), 10);
	}

	//link adresa tabela vlasnik
	public WebElement getLinkAdresV() {
		return Utility.waitForElementPresence(driver, By.xpath("//*[@id='vlasnikStanova']/tbody/tr/td[1]/a"), 10);
	}
	//link stan
	public WebElement getLinkStanV() {
		return Utility.waitForElementPresence(driver, By.xpath("//*[@id='vlasnikStanova']/tbody/tr/td[2]/a"), 10);
	}
}
