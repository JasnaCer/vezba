package pages.stanari;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pages.helpers.Utility;

public class StanariPregledPage {
	private WebDriver driver;

	// konstruktor stranice
	public StanariPregledPage(WebDriver driver) {
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
		//SELEKT
		public Select getPrikaz() {
			return new Select(Utility.waitForElementPresence(driver, By.id("prikaz"), 10));
		}
		public void setPrikaz(String value) {
			this.getPrikaz().selectByVisibleText(value);
		}
		// PRETRAGA
		// dobavljanje i setovanje polja ime Prezime Email
		public WebElement getImePrezEmail() {
			return Utility.waitForElementPresence(driver, By.id("filter"), 10);
		}

		public void setImePrezEmail(String imePrezEmail) {
			WebElement imePreEma = getImePrezEmail();
			imePreEma.clear();
			imePreEma.sendKeys(imePrezEmail);
		}
		// dobavljanje pretraga dugmeta
		public WebElement getBtnPretraga() {
			return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-stanari/div/app-izlistaj-stanare/div/div[1]/div/button"), 10);
		}
		//metoda za pretragu 
		public void pretraga(String imeprezimeemail){
			setImePrezEmail(imeprezimeemail);
			getBtnPretraga().click();
		}
		 //ako nema stanara u tabeli ispisuje se poruka Nijedan stanar sa trazenim kriterijumom nije prondajen!
		public WebElement msgNemaStanara() {
			return Utility.waitForElementPresence(driver, By.xpath("html/body/app-root/app-stanari/div/app-izlistaj-stanare/div/div[1]/h2"), 10);
		}
		// TABELA cela tabela stanara
		public WebElement getStanariTable() {
			return Utility.waitForElementPresence(driver, By.xpath("//table[@class='table table-hover ng-star-inserted']"), 10);
		}

		// red  stanara izvucen iz tabele po imenu
		public WebElement getStanaraIzTabele(String ime) {
			return Utility.waitForElementPresence(driver, By.xpath("//*[contains(text(),\"" + ime + "\")]/../.."), 10);
		}
		//metoda za proveru da li stanar  postoji u tabeli
		public boolean isStanarPresent(String ime){
			return Utility.isPresent(driver, By.xpath("//*[contains(text(),\"" + ime + "\")]/../.."));
		}
		//stanarlink u tabeli
		public WebElement getLinkStanar() {
			return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-stanari/div/app-izlistaj-stanare/div/div[1]/table/tbody/tr[1]/td/a"), 10);
		}
		//link stanar janko jankovic za stanarPage test 
		public WebElement getLinkStanarJJ() {
			return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-stanari/div/app-izlistaj-stanare/div/div[1]/table/tbody/tr[3]/td/a"), 10);
		}
       

}
