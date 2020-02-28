package pages.stanari;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pages.helpers.Utility;

public class StanariRegistracijaPage {
	private WebDriver driver;

	// konstruktor stranice
	public StanariRegistracijaPage(WebDriver driver) {
		this.driver = driver;
	}

	// dobavljanje registracija dugmeta
	public WebElement getBtnRegistracija() {
		return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-stanari/div/div/div/div/ul/li[1]/button/b"), 10);
	}

	// dobavljanje pregled dugmeta
	public WebElement getBtnPregled() {
		return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-stanari/div/div/div/div/ul/li[2]/button/b"), 10);
	}

	// dobavljanje i setovanje email polja
	public WebElement getEmail() {
		return Utility.waitForElementPresence(driver, By.id("email"), 10);
	}

	public void setEmail(String em) {
		WebElement email = getEmail();
		email.clear();
		email.sendKeys(em);
	}

	// dobavljanje i setovanje password polja
	public WebElement getLozinka() {
		return Utility.waitForElementPresence(driver, By.id("lozinka"), 10);
	}

	public void setLozinka(String loz) {
		WebElement lozinka = getLozinka();
		lozinka.clear();
		lozinka.sendKeys(loz);
	}

	// dobavljanje i setovanje ime polja
	public WebElement getIme() {
		return Utility.waitForElementPresence(driver, By.id("ime"), 10);
	}

	public void setIme(String im) {
		WebElement ime = getIme();
		ime.clear();
		ime.sendKeys(im);
	}

	// dobavljanje i setovanje prezime polja
	public WebElement getPrezime() {
		return Utility.waitForElementPresence(driver, By.id("prezime"), 10);
	}

	public void setPrezime(String pre) {
		WebElement prezime = getPrezime();
		prezime.clear();
		prezime.sendKeys(pre);
	}

	// dobavljanje registracija dugmeta
	public WebElement btnRegistrujte() {
		return Utility.waitForElementPresence(driver,
			By.xpath("/html/body/app-root/app-stanari/div/app-registruj-stanara/div/form/fieldset/div[5]/div[2]/button[1]"),10);
	}

	// metoda za registraciju stanara
	public void registracija(String email, String lozinka, String ime, String prezime) {
		setEmail(email);
		setLozinka(lozinka);
		setIme(ime);
		setPrezime(prezime);
		btnRegistrujte().click();
	}

	// dobavljanje resetujte dugmeta
	public WebElement btnResetujte() {
		return Utility.waitForElementPresence(driver,
			By.xpath("/html/body/app-root/app-stanari/div/app-registruj-stanara/div/form/fieldset/div[5]/div[2]/button[2]"),10);
	}

	// dobavljanje poruke uspesno ste registrovali stanara
	public WebElement getMsgAlert() {
		return Utility.waitForElementPresence(driver, By.xpath("//*[@id='toast-container']/div/div"), 10);
	}

	// dobavljanje poruke da je email pogresan ili obavezan
	public WebElement getMsgEmail() {
		return Utility.waitForElementPresence(driver,By.xpath("/html/body/app-root/app-stanari/div/app-registruj-stanara/div/form/fieldset/div[1]/div/div"),
			10);
	}

	// dobavljanje poruke da je lozinka pogresna ili obavezna
	public WebElement getMsgLozinka() {
		return Utility.waitForElementPresence(driver,By.xpath("/html/body/app-root/app-stanari/div/app-registruj-stanara/div/form/fieldset/div[2]/div/div"),
				10);
	}
	//dobavljanje poruke da je polje ime obavezno
	public WebElement getMsgIme() {
		return Utility.waitForElementPresence(driver,By.xpath("/html/body/app-root/app-stanari/div/app-registruj-stanara/div/form/fieldset/div[3]/div/div"),
				10);
	}
	//dobavljanje poruke da je polje prezime obavezno
	public WebElement getMsgPrezime() {
		return Utility.waitForElementPresence(driver,By.xpath("/html/body/app-root/app-stanari/div/app-registruj-stanara/div/form/fieldset/div[4]/div/div"),
				10);
		}
}
