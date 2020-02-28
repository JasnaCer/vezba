//konstruktor stranice
var PredsednikZgradaKvaroviDodajPage = function () { }
var utils = require('../utils.js');
// Opis polja i metoda
PredsednikZgradaKvaroviDodajPage.prototype = Object.create({}, {

    lokacijaKvara: {
        get: function() {
            return utils.waitForElementPresence(by.id('mesto'), 10000);
        },
        set: function(value) {
            return this.lokacijaKvara.clear().sendKeys(value);
        }
    },
    msgLokacijaPrazna: { 
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-dodaj-kvar/div/form/fieldset/div[1]/div/div'), 10000);
        }
    },
    opisKvara: {
        get: function() {
            return utils.waitForElementPresence(by.id('opis'), 10000);
        },
        set: function(value) {
            return this.opisKvara.clear().sendKeys(value);
        }
    },
    msgOpisPrazan: { 
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-dodaj-kvar/div/form/fieldset/div[2]/div/div'), 10000);
        }
    },
    btnOdgovornoLice: { 
        get: function () {
            return utils.waitForElementPresence(by.id('odgovorno_lice'), 10000);
        }
    },
    btnDodajKvar: { 
        get: function () {
            return utils.waitForElementPresence(by.id('submit'), 10000);
        }
    },
    formaOdgovornoLice: { 
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-dodaj-kvar/div/form/fieldset/moguci-odgovorni-modal/div[2]/div'), 10000);
        }
    },
    msgTitleForme: { 
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-dodaj-kvar/div/form/fieldset/moguci-odgovorni-modal/div[2]/div/div/div[1]/h2'), 10000);
        }
    },
    pretraga: {
        get: function() {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-dodaj-kvar/div/form/fieldset/moguci-odgovorni-modal/div[2]/div/div/div[2]/label/input'), 10000);
        },
        set: function(value) {
            return this.pretraga.clear().sendKeys(value);
        }
    },
    
    selektPrikazi: {
        get: function () {
            return utils.waitForElementPresence(by.id('prikaz'), 10000).getText();
        },
        set: function (value) {
            this.selektPrikazi.element(by.cssContainingText('option', value)).click();
        }
    },
    //TABELA IZBOR ODGOVORNOG LICA 
     // cela tabela sa stanarima
     odgovornoLiceTable: {
        get: function() {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-dodaj-kvar/div/form/fieldset/moguci-odgovorni-modal/div[2]/div/div/div[2]/table'), 10000);
        }
    },
    // red mog stanara izvucen iz tabele po imenu
    getOdgovornoLiceIzTabele: {
        value: function(ime) {
            return utils.waitForElementPresence(by.xpath('//*[contains(text(),"' + ime + '")]/../..'),10000);
        }
    },
    // red za koji ocekujem da nije prisutan u tabeli
    getRedNijeUTabeli: {
        value: function(ime) {
            return utils.waitForElementInvisibility(by.xpath('//*[contains(text(),"' + ime + '")]/../..'),10000);
        }
    },
   

    btnPrihvati: { 
        get: function () {
            return utils.waitForElementPresence(by.id('button_2'), 10000);
        }
    },
    btnOdustani: { 
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-dodaj-kvar/div/form/fieldset/moguci-odgovorni-modal/div[2]/div/div/div[3]/button'), 10000);
        }
    },
  
    
    
});

// Export klase
module.exports = PredsednikZgradaKvaroviDodajPage;