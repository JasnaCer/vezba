package pages.zgrade;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pages.helpers.Utility;

public class StanPage {
	private WebDriver driver;

	// konstruktor stranice
	public StanPage(WebDriver driver) {
		this.driver = driver;
	}

	// h2 poruka stan za asertaciju da sam na stranici stan
	public String getMsg() {
		return Utility.waitForElementPresence(driver, By.xpath("//div[@class='col-md-8']/h2"), 10).getText();
	}

	// adresa
	public String getTextAdresa() {
		return Utility.waitForElementPresence(driver, By.xpath("//div[@class='col-md-8']/h5"), 10).getText();
	}

	// vlasnik
	public String getTextVlasnik() {
		return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-stan/div[1]/div[1]/div/h5"), 10)
				.getText();
	}

	// vlasnikLink
	public String getLinkVlasnik() {
		return Utility.waitForElementPresence(driver, By.partialLinkText("Marko Markovic"), 10).getText();
	}

	// dugme ukloni vlasnika
	public WebElement btnUkloniVlasnikaStranica() {
		return Utility.waitForElementPresence(driver, By.id("ukloniVlasnika"), 10);
	}

	// naslov stanar
	public String getTxtStanari() {
		return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-stan/div[1]/div[1]/h4"), 10)
				.getText();
	}
	// TABELA STANARI
	// cela tabela sa stanarima

	public WebElement getStanariTable() {
		return Utility.waitForElementPresence(driver, By.id("stanari"), 10);
	}

	// red mog stanara izvucen iz tabele po imenu
	public WebElement getStanaraIzTabele(String ime) {
		return Utility.waitForElementPresence(driver, By.xpath("//*[contains(text(),\"" + ime + "\")]/../.."), 10);
	}

	// metoda za proveru da li stanar postoji u tabeli, po imenu
	public boolean isStanarPresent(String ime) {
		return Utility.isPresent(driver, By.xpath("//*[contains(text(),\"" + ime + "\")]/../.."));
	}

	// dugme postavi za predsednika
	public WebElement btnPostaviZaPredsednika() {
		return Utility.waitForElementPresence(driver, By.xpath("//*[@id='stanari']/tbody/tr/td[2]/div[1]/button"), 10);
	}

	// dugme postavi vlasnika
	public WebElement btnPostaviZaVlasnika() {
		return Utility.waitForElementPresence(driver, By.xpath("//*[@id='stanari']/tbody/tr/td[2]/div[2]/button"), 10);
	}

	// btnUkloniStanaraIzTabele
	public WebElement btnUkloniStanaraIzTabele() {
		return Utility.waitForElementPresence(driver, By.xpath("//*[@id='stanari']/tbody/tr[1]/td[2]/div[3]/button"),
				10);
	}

	// vlasnik link u tabeli
	// vlasnikLink
	public String getLinkStanar() {
		return Utility.waitForElementPresence(driver, By.xpath("//*[@id='stanari']/tbody/tr[1]/td[1]/a"), 10).getText();
	}

	// naslov korisnici
	public String getKorisnici() {
		return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-stan/div[1]/div[2]/h4"), 10)
				.getText();
	}

	// SELEKT
	public Select getPrikaz() {
		return new Select(Utility.waitForElementPresence(driver, By.id("prikaz"), 10));
	}

	public void setPrikaz(String value) {
		this.getPrikaz().selectByVisibleText(value);
	}

	// FILTER
	// dobavljanje i setovanje filter polja
	public WebElement getFilter() {
		return Utility.waitForElementPresence(driver, By.id("filter"), 10);
	}

	public void setFilter(String fil) {
		WebElement filter = getFilter();
		filter.clear();
		filter.sendKeys(fil);
	}

	// btnFiltriraj
	public WebElement btnFiltriraj() {
		return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-stan/div[1]/div[2]/div/button"),
				10);
	}
	// TABELA KORISNICI
	// cela tabela sa korisnicima

	public WebElement getKorisniciTable() {
		return Utility.waitForElementPresence(driver, By.id("korisnici"), 10);
	}

	// red mog korisnika izvucen iz tabele po imenu
	public WebElement getKorisnikaIzTabele(String ime) {
		return Utility.waitForElementPresence(driver, By.xpath("//*[contains(text(),\"" + ime + "\")]/../.."), 10);
	}

	// metoda za proveru da li korisnik postoji u tabeli, po imenu
	public boolean isKorisnikPresent(String ime) {
		return Utility.isPresent(driver, By.xpath("//*[contains(text(),\"" + ime + "\")]/../.."));
	}

	// dugme postavi za vlasnika
	public WebElement btnPostaviZaVlasnikaK() {
		return Utility.waitForElementPresence(driver, By.xpath("//*[@id='korisnici']/tbody/tr[1]/td[2]/div[1]/button"),
				10);
	}

	// dugme btnDodajUStanareK
	public WebElement btnDodajUStanareK() {
		return Utility.waitForElementPresence(driver, By.xpath("//*[@id='korisnici']/tbody/tr[1]/td[2]/div[2]/button"),
				10);
	}

	// korisnik link u tabeli
	public String getlinkKorisnik() {
		return Utility.waitForElementPresence(driver, By.xpath("//*[@id='korisnici']/tbody/tr[1]/td[1]/p/a"), 10)
				.getText();
	}

	// alert poruka
	public WebElement msgAlert() {
		return Utility.waitForElementPresence(driver, By.xpath("//*[@id='toast-container']/div/div"), 10);
	}

	
}
