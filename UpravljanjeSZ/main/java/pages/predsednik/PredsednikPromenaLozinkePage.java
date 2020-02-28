package pages.predsednik;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pages.helpers.Utility;

public class PredsednikPromenaLozinkePage {
	private WebDriver driver;

	// konstruktor stranice
	public PredsednikPromenaLozinkePage(WebDriver driver) {
		this.driver = driver;
	}
	 //dobavljanje forme promena lozinke 
	public WebElement getFormaPromenaLozinke() {
		return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-promena-lozinke/div/form"), 10);
	}
	// dobavljanje i setovanje polja stara lozinka
	public WebElement getStaraLozinka() {
		return Utility.waitForElementPresence(driver, By.id("staraLozinka"), 10);
	}

	public void setStaratLozinka(String loz) {
		WebElement lozinka = getStaraLozinka();
		lozinka.clear();
		lozinka.sendKeys(loz);
	}
	
	// dobavljanje i setovanje polja nova lozinka
	public WebElement getNovaLozinka() {
		return Utility.waitForElementPresence(driver, By.id("novaLozinka"), 10);
	}

	public void setNovaLozinka(String loz) {
		WebElement lozinka = getNovaLozinka();
		lozinka.clear();
		lozinka.sendKeys(loz);
	}
	// dobavljanje i setovanje polja potvrda lozinke
	public WebElement getPotvrdaLozinka() {
		return Utility.waitForElementPresence(driver, By.id("potvrdaNoveLozinke"), 10);
	}

	public void setPotvrdaLozinka(String loz) {
		WebElement lozinka = getPotvrdaLozinka();
		lozinka.clear();
		lozinka.sendKeys(loz);
	}
	// dobavljanje promeni lozinku dugmeta
	public WebElement btnPromeniLozinku() {
		return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-promena-lozinke/div/form/fieldset/div[4]/button"), 10);
	}
	//metoda za promenu lozinke
		public void promenaPass(String staraLozinka, String novaLozinka, String potvrdiLozinku){
			setStaratLozinka(staraLozinka);
			setNovaLozinka(novaLozinka);
			setPotvrdaLozinka(potvrdiLozinku);
			btnPromeniLozinku().click();
		}
		
		public WebElement msgStaraObavezno() {
			return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-promena-lozinke/div/form/fieldset/div[1]/div"), 10);
		}
		public WebElement msgNovaObaveznoNeispravno() {
			return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-promena-lozinke/div/form/fieldset/div[2]/div[1]/div"), 10);
		}
		public WebElement msgPotvrdaNePoklapaju() {
			return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-promena-lozinke/div/form/fieldset/div[2]/div[2]/div"), 10);
		}
		
}
