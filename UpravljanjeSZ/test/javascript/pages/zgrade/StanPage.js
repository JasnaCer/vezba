//konstruktor stranice
var StanPage = function () { }
var utils = require('../utils.js');
// Opis polja i metoda
StanPage.prototype = Object.create({}, {

    // h2 poruka stan za asertaciju da sam na stranici zgrada
    textMsg: {
        get: function () {
            return utils.waitForElementPresence(by.xpath("//div[@class='col-md-8']/h2"),10000).getText();
        }
    },
    // adresa
    adresa: {
        get: function () {
            return utils.waitForElementPresence(by.xpath("//div[@class='col-md-8']/h5"),10000).getText();
        }
    },
    // vlasnik
    vlasnik: {
        get: function () {
            return utils.waitForElementPresence(by.xpath("/html/body/app-root/app-stan/div[1]/div[1]/div/h5"),10000).getText();
        }                                              
    },
    // vlasnikLink 
   vlasnikLink: {
        get: function () {
            return utils.waitForElementPresence(by.partialLinkText("Marko Markovic"),10000);
        }
    },
    btnUkloniVlasnikaStranica: {
        get: function () {
            return utils.waitForElementPresence(by.id('ukloniVlasnika'),10000);
        }
    },

    //naslov stanar
    stanari: {
        get: function () {
            return utils.waitForElementPresence(by.xpath("/html/body/app-root/app-stan/div[1]/div[1]/h4"),10000).getText();
        }
    },
      //TABELA STANARI
    // cela tabela sa stanarima
    stanariTable: {
        get: function() {
            return utils.waitForElementPresence(by.id('stanari'), 10000);
        }
    },
    // red mog stanara izvucen iz tabele po imenu
    getStanaraIzTabele: {
        value: function(stanar) {
            return utils.waitForElementPresence(by.xpath('//*[contains(text(),"' + stanar + '")]/../..'),10000);
        }
    },
    btnPostaviZaPredsednika: {
        get: function () {
            return utils.waitForElementPresence(by.xpath('//*[@id="stanari"]/tbody/tr/td[2]/div[1]/button'),10000);
        }
    },
    btnPostaviZaVlasnika: {
        get: function () {
            return utils.waitForElementPresence(by.xpath('//*[@id="stanari"]/tbody/tr/td[2]/div[2]/button'),10000);
        }
    },
    btnUkloniStanaraIzTabele: {
        get: function () {
            return utils.waitForElementPresence(by.xpath('//*[@id="stanari"]/tbody/tr[1]/td[2]/div[3]/button'),10000);
        }                                                                                                    
    },
    // vlasnik link u tabeli
    linkStanar: {
        get: function() {
            return utils.waitForElementPresence(by.xpath("//*[@id='stanari']/tbody/tr[1]/td[1]/a"),10000);
        },
    },

    //naslov korisnici
    korisnici: {
        get: function () {
            return utils.waitForElementPresence(by.xpath("/html/body/app-root/app-stan/div[1]/div[2]/h4"),10000).getText();
        }
    },
    //SELEKT Prikazi
    prikaz: {
        get: function() {
            return utils.waitForElementPresence(by.id('prikaz'), 10000).getText();
        },
        set: function(value) {
            this.prikaz.element(by.cssContainingText('option', value)).click();
        }
    },
    //FILTER
    //dobavljanje i setovanje filter polja
    filter: {
        get: function() {
            return utils.waitForElementPresence(by.id('filter'), 10000);
        },
        set: function(value) {
            return this.filter.clear().sendKeys(value);
        }
    },
    btnFiltriraj: {
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-stan/div[1]/div[2]/div/button'),10000);
        }
    },
    //
     //TABELA KORISNICI
    // cela tabela sa stanarima
    korisnikTable: {
        get: function() {
            return utils.waitForElementPresence(by.id('korisnici'), 10000);
        }
    },
    // red mog stanara izvucen iz tabele po imenu
    getKorisnikaIzTabele: {
        value: function(korisnik) {
            return utils.waitForElementPresence(by.xpath('//*[contains(text(),"' + korisnik + '")]/../..'),10000);
        }
    },
    // red za koji ocekujem da nije prisutan u tabeli
    getRedNijeUTabeli: {
        value: function(korisnik) {
            return utils.waitForElementInvisibility(by.xpath('//*[contains(text(),"' + korisnik + '")]/../..'),10000);
        }
    },
     btnPostaviZaVlasnikaK: {
        get: function () {
            return utils.waitForElementPresence(by.xpath('//*[@id="korisnici"]/tbody/tr[1]/td[2]/div[1]/button'),10000);
        }
    },
    btnDodajUStanareK: {
        get: function () {
            return utils.waitForElementPresence(by.xpath('//*[@id="korisnici"]/tbody/tr[1]/td[2]/div[2]/button'),10000);
        }
    },
    // korisnik link u tabeli
    linkKorisnik: {
        get: function() {
            return utils.waitForElementPresence(by.xpath("//*[@id='korisnici']/tbody/tr[1]/td[1]/p/a"),10000);
        },
    },
    //alert poruka
    msgAlert: {
        get: function() {
            return utils.waitForElementPresence(by.xpath('//*[@id="toast-container"]/div/div'), 10000);
        }                                                 
    },
    
    
});

// Export klase
module.exports = StanPage;
