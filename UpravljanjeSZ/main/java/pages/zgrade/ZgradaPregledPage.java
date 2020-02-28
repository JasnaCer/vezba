package pages.zgrade;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pages.helpers.Utility;

public class ZgradaPregledPage {
	private WebDriver driver;

	// konstruktor stranice
	public ZgradaPregledPage(WebDriver driver) {
		this.driver = driver;
	}

	// dobavljanje dodavanje dugmeta
	public WebElement getBtnDodavanje() {
		return Utility.waitForElementPresence(driver, By.xpath("//button[@class='btn btn-outline-primary']"), 10);
	}

	// dobavljanje pregled dugmeta
	public WebElement getBtnPregled() {
		return Utility.waitForElementPresence(driver, By.xpath("//button[@class='btn btn-primary']"), 10);
	}
	//SELEKT
	public Select getPrikaz() {
		return new Select(Utility.waitForElementPresence(driver, By.id("prikaz"), 10));
	}
	public void setPrikaz(String value) {
		this.getPrikaz().selectByVisibleText(value);
	}
    
	// PRETRAGA
	// dobavljanje i setovanje polja ulica ili broj
	public WebElement getUlicaBroj() {
		return Utility.waitForElementPresence(driver, By.id("ulicaBroj"), 10);
	}

	public void setUlicaBroj(String ulicabroj) {
		WebElement ulicaBroj = getUlicaBroj();
		ulicaBroj.clear();
		ulicaBroj.sendKeys(ulicabroj);
	}

	// dobavljanje i setovanje grad polja
	public WebElement getGrad() {
		return Utility.waitForElementPresence(driver, By.id("mesto"), 10);
	}

	public void setGrad(String mesto) {
		WebElement grad = getGrad();
		grad.clear();
		grad.sendKeys(mesto);
	}

	// dobavljanje pretraga dugmeta
	public WebElement getBtnPretraga() {
		return Utility.waitForElementPresence(driver, By.xpath("//div[@class='row']//button"), 10);
	}
	//metoda za pretragu za oba polja unesena
	public void pretraga(String ulicaBroj, String grad){
		setUlicaBroj(ulicaBroj);
		setGrad(grad);
		getBtnPretraga().click();
	}
	// dobavljanje poruke pretrage
		public WebElement getMsgPretraga() {
			return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrade/div/app-izlistaj-zgrade/div/div[1]/h2"), 10);
		}
	
	// TABELA
	// cela tabela zgrade
	public WebElement getZgradeTable() {
		return Utility.waitForElementPresence(driver, By.xpath("//table[@class='table table-hover ng-star-inserted']"), 10);
	}

	// red moje zgrade izvucen iz tabele po nazivu
	public WebElement getZgraduIzTabele(String adresa) {
		return Utility.waitForElementPresence(driver, By.xpath("//*[contains(text(),\"" + adresa + "\")]/../.."), 10);
	}
	//metoda za proveru da li zgrada postoji u tabeli
	public boolean isZgradaPresent(String adresa){
		return Utility.isPresent(driver, By.xpath("//*[contains(text(),\"" + adresa + "\")]/../.."));
	}
	//adresa link u tabeli
	public WebElement getLinkAdresa() {
		return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrade/div/app-izlistaj-zgrade/div/div[1]/table/tbody/tr[1]/td[1]/a"), 10);
	}
	//predsednik link u tabeli
	public WebElement getLinkPredsednik() {
		return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrade/div/app-izlistaj-zgrade/div/div[1]/table/tbody/tr[1]/td[2]/a"), 10);
	}
}
