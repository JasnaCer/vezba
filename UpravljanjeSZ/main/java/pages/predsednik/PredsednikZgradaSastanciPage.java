package pages.predsednik;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pages.helpers.Utility;

public class PredsednikZgradaSastanciPage {
	private WebDriver driver;

	// konstruktor stranice
	public PredsednikZgradaSastanciPage(WebDriver driver) {
		this.driver = driver;
	}
	 //SASTANCI SKUPSTINE
	public Select getPrikaz() {
		return new Select(Utility.waitForElementPresence(driver, By.id("prikaz"), 10));
	}
	public void setPrikaz(String value) {
		this.getPrikaz().selectByVisibleText(value);
	}
	public WebElement btnDodaj() {
		return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-sastanci/a/button"), 10);
	}
	public Select getSelektTipSastanka() {
		return new Select(Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-sastanci/select"), 10));
	}
	public void setSelektTipSastanka(String value) {
		this.getSelektTipSastanka().selectByVisibleText(value);
	}
    //DODAJ DUGME
	public WebElement getFormaDodajZakazivanjeSkupstine() {
		return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-dodaj-sastanak/div/form"),
				10);											
	}
	public WebElement getFormaDodajZakazivanjeSkupstineNaslov() {
		return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-dodaj-sastanak/div/form/fieldset/legend"),
				10);
	}
	public WebElement getInputPocetak() {
		return Utility.waitForElementPresence(driver, By.xpath("//input[@name ='pocetakSkupstine']"), 10);
	}
	public void setInputPocetak(String poc) {
		WebElement pocetak = getInputPocetak();
		pocetak.clear();
		pocetak.sendKeys(poc);
	}
	public WebElement getInputZavrsetak() {
		return Utility.waitForElementPresence(driver, By.xpath("//input[@name ='zavrsetakSkupstine']"), 10);
	}
	public void setInputZavrsetak(String kra) {
		WebElement kraj = getInputZavrsetak();
		kraj.clear();
		kraj.sendKeys(kra);
	}
	public WebElement btnPotvrdiIzmenu() {
		return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-dodaj-sastanak/div/form/fieldset/div[2]/button"),
				10);
	}
	 //SASTANAK JE U TOKU
	public WebElement getPregledajTackeUToku() {
		return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-sastanci/div[1]/div/table/tbody/tr[5]/td/span[1]/a/span"),
				10);
	}
	//ZAKAZAN SASTANAK
	
	public WebElement getIzmeniTackeZakazan() {
		return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-sastanci/div[2]/div/table/tbody/tr[5]/td/span[1]/a/span"),
				10);
	}
	public WebElement getFormaIzmenaTerminaSkupstine() {
		return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-izmena-sastanka/div/form"),
				10);
	}
	public WebElement getFormaIzmenaTerminaSkupstineNaslov() {
		return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-izmena-sastanka/div/form/fieldset/legend"),
				10);
	}
	public WebElement getIzmenaInputPocetak() {
		return Utility.waitForElementPresence(driver, By.xpath("//input[@name ='pocetakSkupstine']"), 10);
	}
	public void setIzmenaInputPocetak(String poc) {
		WebElement pocetak = getIzmenaInputPocetak();
		pocetak.clear();
		pocetak.sendKeys(poc);
	}
	public WebElement getIzmenaInputZavrsetak() {
		return Utility.waitForElementPresence(driver, By.xpath("//input[@name ='zavrsetakSkupstine']"), 10);
	}
	public void setIzmenaInputZavrsetak(String kra) {
		WebElement kraj = getIzmenaInputZavrsetak();
		kraj.clear();
		kraj.sendKeys(kra);
	}
	public WebElement btnPotvrdiIzmenu2() {
		return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-izmena-sastanka/div/form/fieldset/div[2]/button"),
				10);
	}
	public WebElement btnOtkaziZakazan() {
		return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-sastanci/div[2]/div/table/tbody/tr[5]/td/span[2]/a/span"),
				10);
	}
	public WebElement btnPregledajTackeZakazan() {
		return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-tacke-sastanci/div[2]/div/table/tbody/tr[4]/td/span[2]/a/span"),
				10);
	}
	public WebElement btnIzmeniPregledajTacke() {
		return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-tacke-sastanci/div[1]/div/table/tbody/tr[4]/td/span[1]/a[1]/span"),
				10);
	}
	
	public WebElement btnIzmeniPregledajTackePotvrdi() {
		return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-tacke-sastanci/div[1]/div/table/tbody/tr[4]/td/span[1]/a[2]/span"),
				10);
	}
	public WebElement btnIzmeniPregledajTackeOdustani() {
		return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-tacke-sastanci/div[1]/div/table/tbody/tr[4]/td/span[1]/a[3]/span/font"),
				10);
	}
	public WebElement btnUkloniPregledajTacke() {
		return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-tacke-sastanci/div[1]/div/table/tbody/tr[4]/td/span[1]/a[4]/span"),
				10);
	}
	public WebElement btnPregledajAnketuPregledajTacke() {
		return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-tacke-sastanci/div[1]/div/table/tbody/tr[4]/td/span[2]/a/span"),
				10);
	}
	
	//ANKETA
    //NOVO PITANJE
	public WebElement getNovoPitanjeAnketa() {
		return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-izlistaj-ankete/div[2]/app-pitanje"),
				10);
	}
	public WebElement btnNovoPitanjeAnketa() {
		return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-izlistaj-ankete/div[1]/div/div[2]/button"),
				10);
	}
	public WebElement getNovoPitanjeAnketaForma() {
		return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-izlistaj-ankete/div[1]/div/div[2]/button"),
				10);
	}
	public WebElement getTextPitanja() {
		return Utility.waitForElementPresence(driver, By.xpath("//input[@name ='zavrsetakSkupstine']"), 10);
	}
	public void setTextPitanja(String te) {
		WebElement text = getTextPitanja();
		text.clear();
		text.sendKeys(te);
	}
	//poruka da polje ne sme biti prazno
	public WebElement getmsgPraznoPolje() {
		return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-izlistaj-ankete/app-dodaj-pitanje/div/div[1]/div/label/div"),
				10);
	}
	public WebElement getRadioObicnoPitanje() {
		return Utility.waitForElementPresence(driver, By.id("radio1"),
				10);
	}
	public WebElement getTekstOpcije() {
		return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-izlistaj-ankete/app-dodaj-pitanje/div/div[3]/div[1]/label/input"), 10);
	}
	public void setTekstOpcije(String te) {
		WebElement text = getTekstOpcije();
		text.clear();
		text.sendKeys(te);
	}
	public WebElement getMsgTekstOpcijePraznoPolje() {
		return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-izlistaj-ankete/app-dodaj-pitanje/div/div[3]/div[1]/label/div"),
				10);
	}
	public WebElement getRadioStanarPitanje() {
		return Utility.waitForElementPresence(driver, By.id("radio2"),
				10);
	}
	public Select getSelektStanar() {
		return new Select(Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-sastanci/select"), 10));
	}
	public void setSelektStanar(String value) {
		this.getSelektStanar().selectByVisibleText(value);
	}
	
	public WebElement btnDodajStanarOpciju() {
		return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-izlistaj-ankete/app-dodaj-pitanje/div/div[4]/div[2]/button"),
				10);
	}
	// TABELA  opcije
	public WebElement getOpcijeTable() {
		return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-izlistaj-ankete/app-dodaj-pitanje/div/div[6]/div/label/table"), 10);
	}
	// red opcijeizvucen iz tabele po imenu
	public WebElement getOpcijuIzTabele(String opcija) {
		return Utility.waitForElementPresence(driver, By.xpath("//*[contains(text(),\"" + opcija + "\")]/../.."), 10);
	}

	// metoda za proveru da li opcija postoji u tabeli, po imenu
	public boolean isOpcijaPresent(String opcija) {
		return Utility.isPresent(driver, By.xpath("//*[contains(text(),\"" + opcija + "\")]/../.."));
	}
	public WebElement btnUkloniOpciju() {
		return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-izlistaj-ankete/app-dodaj-pitanje/div/div[6]/div/label/table/tbody/tr[1]/td[3]/button"),
				10);
	}
	//radio Firma Pitanje
	public WebElement getRadioFirmaPitanje() {
		return Utility.waitForElementPresence(driver, By.id("radio3"),
				10);
	}
	public Select getSelektFirma() {
		return new Select(Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-izlistaj-ankete/app-dodaj-pitanje/div/div[5]/div[1]/label/select"), 10));
	}
	public void setSelektFirma(String value) {
		this.getSelektFirma().selectByVisibleText(value);
	}
	public WebElement msgSelectFirmaPrazno() {
		return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-izlistaj-ankete/app-dodaj-pitanje/div/div[5]/div[1]/label/div"),
				10);
	}
	public WebElement btnDodajFirmu() {
		return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-izlistaj-ankete/app-dodaj-pitanje/div/div[5]/div[2]/button"),
				10);
	}
	public WebElement btnDodajPitanjeUAnketu() {
		return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-izlistaj-ankete/app-dodaj-pitanje/div/div[7]/div[2]/button"),
				10);
	}
	//TEKUCE PITANJE
	
	public WebElement getFormaTekucePitanje() {
		return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-izlistaj-ankete/div[2]/app-pitanje/div"),
				10);
	}  
	public WebElement getTekucePitanjeUAnketi() {
		return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-izlistaj-ankete/div[2]/app-pitanje/div/div[1]/div[1]/p"),
				10);
	}
	public WebElement btnVidiGlasove() {
		return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-izlistaj-ankete/div[2]/app-pitanje/div/div[1]/div[2]/button[1]"),
				10);
	}
	public WebElement btnIzmeni() {
		return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-izlistaj-ankete/div[2]/app-pitanje/div/div[1]/div[2]/button[2]"),
				10);
	} 
	public WebElement btnSacuvatiPitanje() {
		return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-izlistaj-ankete/div[2]/app-pitanje/div/div[1]/div[2]/button[3]"),
				10);
	} 
	public WebElement btnIzbrisati() {
		return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-izlistaj-ankete/div[2]/app-pitanje/div/div[1]/div[2]/button[4]"),
				10);
	} 
	public WebElement getRadioPrviOdgovor() {
		return Utility.waitForElementPresence(driver, By.id("13"),
				10);
	}
	public WebElement getTekstOdgovor() {
		return Utility.waitForElementPresence(driver, By.id("span_13_1"), 10);
	}
	
	public WebElement btnIzmenitiPrviOdgovor() {
		return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-izlistaj-ankete/div[2]/app-pitanje/div/fieldset/div/div[1]/div[1]/div[2]/button[1]"),
				10);
	} 
	public WebElement btnSacuvatiPrviOdgovor() {
		return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-izlistaj-ankete/div[2]/app-pitanje/div/fieldset/div/div[1]/div[1]/div[2]/button[2]"),
				10);
	} 
    public WebElement btnIzbrisatiPrviOdgovor() {
	return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-izlistaj-ankete/div[2]/app-pitanje/div/fieldset/div/div[1]/div[1]/div[2]/button[3]"),
			10);
    } 
    public WebElement btnDodajStanarKaoOpcr() {
    	return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-izlistaj-ankete/div[2]/app-pitanje/div/div[2]/div[1]/button"),
    			10);
    } 
    public Select getSelektStanar2() {
		return new Select(Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-izlistaj-ankete/div[2]/app-pitanje/div/div[2]/div[2]/label/select"), 10));
	}
	public void setSelektStanar2(String value) {
		this.getSelektStanar2().selectByVisibleText(value);
	}
	public WebElement getPregledajZapisnikZavrsen() {
		return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-sastanci/div[3]/div/table/tbody/tr[5]/td/span[2]/a/span"),
				10);
	    } 
//   Pregledaj anketu  redirekt samo na stranicu anketa

	public WebElement getPregledajZapisnikZavrsenAnketa() {
		return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-tacke-sastanci/div/div/table/tbody/tr[4]/td/span[1]/a/span"),
				10);
	    } 
//    donesi odluku 

	public WebElement getPregledajZapisnikZavrsenOdluka() {
		return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-tacke-sastanci/div/div/table/tbody/tr[4]/td/span[2]/a[1]/span"),
				10);
	    } 
//    //donesi odluku potvrdi
	public WebElement getPregledajZapisnikZavrsenOdlukaPotvrdi() {
		return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-tacke-sastanci/div/div/table/tbody/tr[4]/td/span[2]/a[2]/span"),
				10);
	    } 
//    donesi odluku odustani
	public WebElement getPpregledajZapisnikZavrsenOdlukaOdustani() {
		return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-tacke-sastanci/div/div/table/tbody/tr[4]/td/span[2]/a[3]/span/font"),
				10);
	    } 
  
    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
