//konstruktor stranice
var ZgradaPregledPage = function () { }
var utils = require('../utils.js');
// Opis polja i metoda
ZgradaPregledPage.prototype = Object.create({}, {

     // dobavljanje dodavanje dugmeta
     btnDodavanje: {
        get: function() {
            return utils.waitForElementPresence(by.xpath('//button[@class="btn btn-outline-primary"]'), 10000);
        },
    },
    // dobavljanje pregled dugmeta
    btnPregled: {
        get: function() {
            return utils.waitForElementPresence(by.xpath('//button[@class="btn btn-primary"]'),10000);
        },
    },
    //SELEKT
    prikaz: {
        get: function() {
            return utils.waitForElementPresence(by.id('prikaz'), 10000).getText();
        },
        set: function(value) {
            this.prikaz.element(by.cssContainingText('option', value)).click();
        }
    },
    // PRETRAGA
	// dobavljanje i setovanje polja ulica ili broj
    ulicaBroj: {
        get: function() {
            return utils.waitForElementPresence(by.id('ulicaBroj'), 10000);
        },
        set: function(value) {
            return this.ulicaBroj.clear().sendKeys(value);
        }
    },
    // dobavljanje i setovanje grad polja
    grad: {
        get: function() {
            return utils.waitForElementPresence(by.id('mesto'), 10000);
        },
        set: function(value) {
            return this.grad.clear().sendKeys(value);
        }
    },
    // dobavljanje pretraga dugmeta
    btnPretraga: {
        get: function() {
            return utils.waitForElementPresence(by.xpath("//div[@class='row']//button"),10000);
        },
    },
    // dobavljanje poruke pretrage
    getMsgPretraga: {
        get: function() {
            return utils.waitForElementPresence(by.xpath("/html/body/app-root/app-zgrade/div/app-izlistaj-zgrade/div/div[1]/h2"),10000);
        },
    },
    //metoda za pretragu za oba polja unesena
    pretraga: {
        value: function(ulicabroj, grad) {
            this.ulicaBroj = ulicabroj;
            this.grad = grad;
            this.btnPretraga.click();
        }
    },

    // TABELA
    // cela tabela zgrade
    zgradaTable: {
        get: function() {
            return utils.waitForElementPresence(by.xpath("/html/body/app-root/app-zgrade/div/app-izlistaj-zgrade/div/div[1]/table"), 10000);
        }
    },
    // red moje zgrade izvucen iz tabele po adresi
    getZgraduIzTabele: {
        value: function(adresa) {
            return utils.waitForElementPresence(by.xpath('//*[contains(text(),"' + adresa + '")]/../..'),10000);
        }
    },

    //adresa link u tabeli
    linkAdresa: {
        get: function() {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrade/div/app-izlistaj-zgrade/div/div[1]/table/tbody/tr[1]/td[1]/a'),10000);
        },
    },
    //predsednik link u tabeli
    linkPredsednik: {
        get: function() {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrade/div/app-izlistaj-zgrade/div/div[1]/table/tbody/tr[1]/td[2]/a'),10000);
        },
    },
});

// Export klase
module.exports = ZgradaPregledPage;