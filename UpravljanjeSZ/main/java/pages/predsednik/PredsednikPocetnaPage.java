package pages.predsednik;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pages.helpers.Utility;

public class PredsednikPocetnaPage {
	private WebDriver driver;

	// konstruktor stranice
	public PredsednikPocetnaPage(WebDriver driver) {
		this.driver = driver;
	}

	// dobavljanje linka pocetna iz menija
	public WebElement getLinkPocetna() {
		return Utility.waitForElementPresence(driver, By.xpath("//*[@id='navbarColor02']/ul[1]/li[1]/a"), 10);
	}

	// dobavljanje linka Dodeljeni kvarovi iz menija
	public WebElement getLinkDodeljeniKvarovi() {
		return Utility.waitForElementPresence(driver, By.xpath("//*[@id='navbarColor02']/ul[1]/li[2]"), 10);
	}
	// dobavljanje linka promen lozinke iz menija
	public WebElement getLinkPromenaLozinke() {
		return Utility.waitForElementPresence(driver, By.xpath("//*[@id='navbarColor02']/ul[1]/li[3]/a"), 10);
	}
	// dobavljanje linka email ulogovanog korisnika iz menija
	public WebElement getLinkEmailKorisnika() {
		return Utility.waitForElementPresence(driver, By.xpath("//*[@id='navbarColor02']/ul[2]/li[1]/label"), 10);
	}
	// dobavljanje Izlogujte se dugmeta
	public WebElement btnIzlogujteSe() {
		return Utility.waitForElementPresence(driver, By.xpath("//*[@id='navbarColor02']/ul[2]/li[2]/button"), 10);
	}
	 //TABELA Zgrada u kojoj zivite
	public WebElement getZgradaUKojojZiviTable() {
		return Utility.waitForElementPresence(driver, By.id("zgradaStanuje"), 10);
	}

	// red zgrade izvucen iz tabele po ulici
	public WebElement getRedZgradaZivi(String ulica) {
		return Utility.waitForElementPresence(driver, By.xpath("//*[contains(text(),\"" + ulica + "\")]/../.."), 10);
	}

	// metoda za proveru da li zgrada postoji u tabeli, po ulici
	public boolean isZgradaPresent(String ulica) {
		return Utility.isPresent(driver, By.xpath("//*[contains(text(),\"" + ulica + "\")]/../.."));
	}
	//link adresa tabela stanuje
	public WebElement getLinkStranicaZgrade() {
		return Utility.waitForElementPresence(driver, By.xpath("//*[@id='zgradaStanuje']/tbody/tr/td[4]/a"), 10);
	}														    
	
	//TABELA Zgrade u kojima ste vlasnik stana
		public WebElement getZgradaVlaskikTable() {
			return Utility.waitForElementPresence(driver, By.id("zgradaVlasnik"), 10);
		}

		// red zgrade izvucen iz tabele po ulici
		public WebElement getRedZgradaVlaskikTable(String ulica) {
			return Utility.waitForElementPresence(driver, By.xpath("//*[contains(text(),\"" + ulica + "\")]/../.."), 10);
		}

		// metoda za proveru da li zgrada postoji u tabeli, po ulici
		public boolean isVlasnikePresent(String ulica) {
			return Utility.isPresent(driver, By.xpath("//*[contains(text(),\"" + ulica + "\")]/../.."));
		}
		//link adresa tabela stanuje
		public WebElement getLinkStranicaZ() {
			return Utility.waitForElementPresence(driver, By.xpath("//*[@id='zgradaStanuje']/tbody/tr/td[4]/a"), 10);
		}
}
