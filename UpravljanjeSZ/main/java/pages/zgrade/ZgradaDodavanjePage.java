package pages.zgrade;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pages.helpers.Utility;

public class ZgradaDodavanjePage {

	private WebDriver driver;

	// konstruktor stranice
	public ZgradaDodavanjePage(WebDriver driver) {
		this.driver = driver;
	}

	// dobavljanje dodavanje dugmeta
	public WebElement getBtnDodavanje() {
		return Utility.waitForElementPresence(driver, By.xpath("//button[@class='btn btn-primary']"), 10);
	}

	// dobavljanje pregled dugmeta
	public WebElement getBtnPregled() {
		return Utility.waitForElementPresence(driver, By.xpath("//button[@class='btn btn-outline-primary']"), 10);
	}

	// dobavljanje i setovanje mesto polja
	public WebElement getMesto() {
		return Utility.waitForElementPresence(driver, By.id("mesto"), 10);
	}

	public void setMesto(String mest) {
		WebElement mesto = getMesto();
		mesto.clear();
		mesto.sendKeys(mest);
	}

	// dobavljanje i setovanje ulica polja
	public WebElement getUlica() {
		return Utility.waitForElementPresence(driver, By.id("ulica"), 10);
	}

	public void setUlica(String ulic) {
		WebElement ulica = getUlica();
		ulica.clear();
		ulica.sendKeys(ulic);
	}

	// dobavljanje i setovanje broj polja
	public WebElement getBroj() {
		return Utility.waitForElementPresence(driver, By.id("broj"), 10);
	}

	public void setBroj(String bro) {
		WebElement broj = getBroj();
		broj.clear();
		broj.sendKeys(bro);
	}

	// dobavljanje i setovanje broj stanova polja
	public WebElement getBrojStanova() {
		return Utility.waitForElementPresence(driver, By.id("brojStanova"), 10);
	}

	public void setBrojStanova(String bros) {
		WebElement brojS = getBrojStanova();
		brojS.clear();
		brojS.sendKeys(bros);
	}

	// dobavljanje dodajte dugmeta
	public WebElement getBtnDodajte() {
		return Utility.waitForElementPresence(driver,
				By.xpath(
						"/html/body/app-root/app-zgrade/div/app-dodaj-zgradu/div/form/fieldset/div[5]/div[2]/button[1]"),
				10);
	}

	// dobavljanje resetujte dugmeta
	public WebElement getBtnResetujte() {
		return Utility.waitForElementPresence(driver,
				By.xpath(
						"/html/body/app-root/app-zgrade/div/app-dodaj-zgradu/div/form/fieldset/div[5]/div[2]/button[2]"),
				10);
	}

	// dobavljanje poruke da je zgrada uspesno dodata 
	public WebElement getMsgDodata() {
		return Utility.waitForElementPresence(driver, By.xpath("//*[@id='toast-container']/div/div"), 10);
	}

	// dobavljanje poruke da je polje mesto obavezno
	public WebElement getMsgMesto() {
		return Utility.waitForElementPresence(driver,
				By.xpath("/html/body/app-root/app-zgrade/div/app-dodaj-zgradu/div/form/fieldset/div[1]/div/div"), 10);
	}

	// dobavljanje poruke da je polje ulica obavezno
	public WebElement getMsgUlica() {
		return Utility.waitForElementPresence(driver,
				By.xpath("/html/body/app-root/app-zgrade/div/app-dodaj-zgradu/div/form/fieldset/div[2]/div/div"), 10);
	}

	// dobavljanje poruke da je polje broj obavezno
	public WebElement getMsgBroj() {
		return Utility.waitForElementPresence(driver,
				By.xpath("/html/body/app-root/app-zgrade/div/app-dodaj-zgradu/div/form/fieldset/div[3]/div/div"), 10);
	}

	// dobavljanje poruke da je polje broj stanova obavezno
	public WebElement getMsgBrojStanova() {
		return Utility.waitForElementPresence(driver,
				By.xpath("/html/body/app-root/app-zgrade/div/app-dodaj-zgradu/div/form/fieldset/div[4]/div/div"), 10);
	}
	// dobavljanje poruke da vec postoji zgrada na toj adresi
		public WebElement getMsgZgradaVecPostoji() {
			return Utility.waitForElementPresence(driver,
					By.xpath("//*[@id=\"toast-container\"]/div/div"), 10);
		}
		//Vec postoji zgrada na toj adresi!
	// metoda za dodavanje zgrade
	public void dodajZgradu(String mesto, String ulica, String broj, String brojs) {
		setMesto(mesto);
		setUlica(ulica);
		setBroj(broj);
		setBrojStanova(brojs);
		getBtnDodajte().click();
	}

}
