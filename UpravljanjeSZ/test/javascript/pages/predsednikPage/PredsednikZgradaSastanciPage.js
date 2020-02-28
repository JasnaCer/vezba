//konstruktor stranice
var PredsednikZgradaSastanciPage = function () { }
var utils = require('../utils.js');
// Opis polja i metoda
PredsednikZgradaSastanciPage.prototype = Object.create({}, {


    //SASTANCI SKUPSTINE
    prikazSastanci: {
        get: function () {
            return utils.waitForElementPresence(by.id('prikaz'), 10000).getText();
        },
        set: function (value) {
            this.prikaz.element(by.cssContainingText('option', value)).click();
        }
    },
    btnDodajSastanak: {
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-sastanci/a/button'), 10000);
        }
    },
    selektTipSastanka: {
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-sastanci/select'), 10000).getText();
        },
        set: function (value) {
            this.selektTipSastanka.element(by.cssContainingText('option', value)).click();
        }
    },
    //DODAJ DUGME
    formaDodajZakazivanjeSkupstine: {
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-dodaj-sastanak/div/form'), 10000);
        }
    },
    formaDodajZakazivanjeSkupstineNaslov: {
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-dodaj-sastanak/div/form/fieldset/legend'), 10000);
        }
    },
    
    textInputPocetak: {
        get: function () {
            return utils.waitForElementPresence(by.xpatg("//input[@name ='pocetakSkupstine']"), 10000).getText();
        },
        set: function (value) {
            this.textInputPocetak.element(by.cssContainingText('option', value)).click();
        }
    },
   
    textInputKraj: {
        get: function () {
            return utils.waitForElementPresence(by.xpatg("//input[@name ='zavrsetakSkupstine']"), 10000).getText();
        },
        set: function (value) {
            this.textInputKraj.element(by.cssContainingText('option', value)).click();
        }
    },
    btnPotvrdi: {
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-dodaj-sastanak/div/form/fieldset/div[2]/button'), 10000);
        }
    },

    //SASTANAK JE U TOKU
    pregledajTackeUToku: {//redirekt samo na stranicu poredjenje sa url
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-sastanci/div[1]/div/table/tbody/tr[5]/td/span[1]/a/span'), 10000);
        }
    },


    //ZAKAZAN SASTANAK
    izmeniTackeZakazan: {//redirekt na stranicu Izmena termina skupstine gde se popunjava forme, 
        //izmeni otvara se forma izmena termina skupstine ista kao dodaj skupstinu
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-sastanci/div[2]/div/table/tbody/tr[5]/td/span[1]/a/span'), 10000);
        }
    },
    formaIzmenaTerminaSkupstine: {
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-izmena-sastanka/div/form'), 10000);
        }                                                
    },
    formaIzmenaTerminaSkupstineNaslov: {
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-izmena-sastanka/div/form/fieldset/legend'), 10000);
        }                                                
    },
    textInputPocetakI: {
        get: function () {
            return utils.waitForElementPresence(by.xpatg("//input[@name ='pocetakSkupstine']"), 10000).getText();
        },
        set: function (value) {
            this.textInputPocetak.element(by.cssContainingText('option', value)).click();
        }
    },
   
    textInputKrajI: {
        get: function () {
            return utils.waitForElementPresence(by.xpatg("//input[@name ='zavrsetakSkupstine']"), 10000).getText();
        },
        set: function (value) {
            this.textInputKraj.element(by.cssContainingText('option', value)).click();
        }
    },
    btnPotvrdiIzmenu: {
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-izmena-sastanka/div/form/fieldset/div[2]/button'), 10000);
        }
    },
    //otkazi
    otkaziZakazan: { //alert potvrda
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-sastanci/div[2]/div/table/tbody/tr[5]/td/span[2]/a/span'), 10000);
        }
    },

    //pregledaj tacke
    pregledajTackeZakazan: { //ide na pregled gde kliknem na pregledaj anketu samo redirekt
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-tacke-sastanci/div[2]/div/table/tbody/tr[4]/td/span[2]/a/span'), 10000);
        }
    },
    
    //izmeni  
    izmeniPregledajTacke: { //ide na pregled gde kliknem na pregledaj anketu samo redirekt
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-tacke-sastanci/div[1]/div/table/tbody/tr[4]/td/span[1]/a[1]/span'), 10000);
        }
    },
    //potvrdi
    izmeniPregledajTackePotvrdi: { //ide na pregled gde kliknem na pregledaj anketu samo redirekt
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-tacke-sastanci/div[1]/div/table/tbody/tr[4]/td/span[1]/a[2]/span'), 10000);
        }
    },
     //odustani
    izmeniPregledajTackeOdustani: { //ide na pregled gde kliknem na pregledaj anketu samo redirekt
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-tacke-sastanci/div[1]/div/table/tbody/tr[4]/td/span[1]/a[3]/span/font'), 10000);
        }
    },

    //  ukloni 
    ukloniPregledajTacke: { //alert poruka
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-tacke-sastanci/div[1]/div/table/tbody/tr[4]/td/span[1]/a[4]/span'), 10000);
        }
    },
    // anketa
    pregledajAnketuPregledajTacke: { //redirekt 
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-tacke-sastanci/div[1]/div/table/tbody/tr[4]/td/span[2]/a/span'), 10000);
        }
    },

    //ANKETA
    //NOVO PITANJE
    novoPitanjeAnketa: { 
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-izlistaj-ankete/div[2]/app-pitanje'), 10000);
        }
    },
    btnNovoPitanjeAnketa: { 
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-izlistaj-ankete/div[1]/div/div[2]/button'), 10000);
        }
    },
   
    novoPitanjeAnketaForma: { 
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-izlistaj-ankete/app-dodaj-pitanje'), 10000);
        }
    },
    textPitanja: {
        get: function() {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-izlistaj-ankete/app-dodaj-pitanje/div/div[1]/div/label/input'), 10000);
        },
        set: function(value) {
            return this.textPitanja.clear().sendKeys(value);
        }
    },
    //poruka da polje ne sme biti prazno
    msgPraznoPolje: { 
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-izlistaj-ankete/app-dodaj-pitanje/div/div[1]/div/label/div'), 10000).getText();
        }
    },
    radioObicnoPitanje: { 
        get: function () {
            return utils.waitForElementPresence(by.id('radio1'), 10000);
        }
    },
    tekstOpcije: {
        get: function() {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-izlistaj-ankete/app-dodaj-pitanje/div/div[3]/div[1]/label/input'), 10000);
        },
        set: function(value) {
            return this.tekstOpcije.clear().sendKeys(value);
        }
    },
    msgTekstOpcijePraznoPolje: { 
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-izlistaj-ankete/app-dodaj-pitanje/div/div[3]/div[1]/label/div'), 10000).getText();
        }
    },
    radioStanarPitanje: { 
        get: function () {
            return utils.waitForElementPresence(by.id('radio2'), 10000).getText();
        }
    },
    selektStanar: {
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-sastanci/select'), 10000).getText();
        },
        set: function (value) {
            this.selektStanar.element(by.cssContainingText('option', value)).click();
        }
    },
    btnDodajStanarOpciju: { 
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-izlistaj-ankete/app-dodaj-pitanje/div/div[4]/div[2]/button'), 10000);
        }
    },
    // TABELA  opcije
    opcijeTable: { 
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-izlistaj-ankete/app-dodaj-pitanje/div/div[6]/div/label/table'), 10000);
        }
    },
    // red opcije izvucen iz tabele po imenu
    getOpcijuIzTabele: {
        value: function(text) {
            return utils.waitForElementPresence(by.xpath('//*[contains(text(),"' + text + '")]/../..'),10000);
        }
    },
    // red za koji ocekujem da nije prisutan u tabeli
    getRedNijeUTabeli: {
        value: function(text) {
            return utils.waitForElementInvisibility(by.xpath('//*[contains(text(),"' + text + '")]/../..'),10000);
        }
    },
    btnUkloniOpciju: { 
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-izlistaj-ankete/app-dodaj-pitanje/div/div[6]/div/label/table/tbody/tr[1]/td[3]/button'), 10000);
        }
    },
    radioFirmaPitanje: { 
        get: function () {
            return utils.waitForElementPresence(by.id('radio3'), 10000).getText();
        }
    },
    selektFirma: {
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-izlistaj-ankete/app-dodaj-pitanje/div/div[5]/div[1]/label/select'), 10000).getText();
        },
        set: function (value) {
            this.selektFirma.element(by.cssContainingText('option', value)).click();
        }
    },
    msgSelectFirmaPrazno: { 
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-izlistaj-ankete/app-dodaj-pitanje/div/div[5]/div[1]/label/div'), 10000).getText();
        }
    }, 
    btnDodajFirmu: { 
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-izlistaj-ankete/app-dodaj-pitanje/div/div[5]/div[2]/button'), 10000);
        }
    },  
    btnDodajPitanjeUAnketu: { 
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-izlistaj-ankete/app-dodaj-pitanje/div/div[7]/div[2]/button'), 10000);
        }
    },  
    
    //TEKUCE PITANJE
    formaTekucePitanje: { 
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-izlistaj-ankete/div[2]/app-pitanje/div'), 10000);
        }
    },  
   tekucePitanjeUAnketi: { 
    get: function () {
        return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-izlistaj-ankete/div[2]/app-pitanje/div/div[1]/div[1]/p'), 10000);
    }
},
    btnVidiGlasove: { 
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-izlistaj-ankete/div[2]/app-pitanje/div/div[1]/div[2]/button[1]'), 10000);
        }
    }, 
    btnIzmeni: { 
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-izlistaj-ankete/div[2]/app-pitanje/div/div[1]/div[2]/button[2]'), 10000);
        }
    }, 
    btnSacuvatiPitanje: { 
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-izlistaj-ankete/div[2]/app-pitanje/div/div[1]/div[2]/button[3]'), 10000);
        }
    }, 
    btnIzbrisati: { 
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-izlistaj-ankete/div[2]/app-pitanje/div/div[1]/div[2]/button[4]'), 10000);
        }
    }, 
    radioPrviOdgovor: { 
        get: function () {
            return utils.waitForElementPresence(by.id('13'), 10000);
        }
    },   
    textOdgovor: {
        get: function() {
            return utils.waitForElementPresence(by.id('span_13_1'), 10000);
        }
    },
    btnIzmenitiPrviOdgovor: { 
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-izlistaj-ankete/div[2]/app-pitanje/div/fieldset/div/div[1]/div[1]/div[2]/button[1]'), 10000);
        }
    }, 
    btnSacuvatiPrviOdgovor: { 
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-izlistaj-ankete/div[2]/app-pitanje/div/fieldset/div/div[1]/div[1]/div[2]/button[2]'), 10000);
        }
    }, 
    btnIzbrisatiPrviOdgovor: { 
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-izlistaj-ankete/div[2]/app-pitanje/div/fieldset/div/div[1]/div[1]/div[2]/button[3]'), 10000);
        }
    }, 
    
   btnDodajStanarKaoOpcr: { 
    get: function () {
        return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-izlistaj-ankete/div[2]/app-pitanje/div/div[2]/div[1]/button'), 10000);
    }
    }, 
    selektStanar: {
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-izlistaj-ankete/div[2]/app-pitanje/div/div[2]/div[2]/label/select'), 10000).getText();
        },
        set: function (value) {
            this.selektStanar.element(by.cssContainingText('option', value)).click();
        }
    },
     
    pregledajZapisnikZavrsen: {
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-sastanci/div[3]/div/table/tbody/tr[5]/td/span[2]/a/span'), 10000);
        }
    },
    //   Pregledaj anketu  redirekt samo na stranicu anketa
    pregledajZapisnikZavrsenAnketa: {
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-tacke-sastanci/div/div/table/tbody/tr[4]/td/span[1]/a/span'), 10000);
        }
    },
    //donesi odluku 
    pregledajZapisnikZavrsenOdluka: {
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-tacke-sastanci/div/div/table/tbody/tr[4]/td/span[2]/a[1]/span'), 10000);
        }
    },
    //donesi odluku potvrdi
    pregledajZapisnikZavrsenOdlukaPotvrdi: { //alert crveni nije poruka odgovarajuceg formata
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-tacke-sastanci/div/div/table/tbody/tr[4]/td/span[2]/a[2]/span'), 10000);
        }
    },
    //donesi odluku odustani
    pregledajZapisnikZavrsenOdlukaOdustani: { //samo se zatvori
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-tacke-sastanci/div/div/table/tbody/tr[4]/td/span[2]/a[3]/span/font'), 10000);
        }
    },
    
});

// Export klase
module.exports = PredsednikZgradaSastanciPage;