//konstruktor stranice
var ZgradaPage = function () { }
var utils = require('../utils.js');
// Opis polja i metoda
ZgradaPage.prototype = Object.create({}, {

    // h2 poruka Zgrada za asertaciju da sam na stranici zgrada
    textMsg: {
        get: function () {
            return utils.waitForElementPresence(by.xpath("//div[@class='container']/h2"),10000).getText();
        }
    },
    // adresa
    adresa: {
        get: function () {
            return utils.waitForElementPresence(by.xpath("/html/body/app-root/app-zgrada/div/div[1]/h5[1]"),10000).getText();
        }
    },
    // predsednik
    predsednik: {
        get: function () {
            return utils.waitForElementPresence(by.xpath("//html/body/app-root/app-zgrada/div/div[1]/h5[2]"),10000).getText();
        }
    },
    // predsedniklink 
    predsednikLink: {
        get: function () {
            return utils.waitForElementPresence(by.partialLinkText("Gospodin Predsednik"),10000);
        }
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
    // meni sa tabovima
    menuTab: {
        get: function () {
            return utils.waitForElementPresence(by.xpath("//ul[@class='nav nav-tabs']"),10000);
        }
    },
    // tab stanovi
    stanoviTab: {
        get: function () {
            return utils.waitForElementPresence(by.linkText("Stanovi"),10000);
        }
    },
    // tab obavestenja
    obavestenjaTab: {
        get: function () {
            return utils.waitForElementPresence(by.linkText("Obavestenja"),10000);
        }
    },
    // tab predlozi tacke dnevnog reda
    predloziTab: {
        get: function () {
            return utils.waitForElementPresence(by.linkText("Predlozi tacke dnevnog reda"),10000);
        }
    },
    // tab sastanci skupstine
    sastanciTab: {
        get: function () {
            return utils.waitForElementPresence(by.linkText("Sastanci skupstine"),10000);
        }
    },
    // tab kvarovi
    kvaroviTab: {
        get: function () {
            return utils.waitForElementPresence(by.linkText("Kvarovi"),10000);
        }
    },
    // TABELA
    // cela tabela sa stanovima
    stanoviTable: {
        get: function() {
            return utils.waitForElementPresence(by.xpath("//table[@class='table table-hover']"), 10000);
        }
    },
    // red mog stana izvucen iz tabele po vlasniku
    getStanIzTabele: {
        value: function(vlasnik) {
            return utils.waitForElementPresence(by.xpath('//*[contains(text(),"' + vlasnik + '")]/../..'),10000);
        }
    },
    // vlasnik link u tabeli
    linkVlasnik: {
        get: function() {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-stanovi/div/div[1]/table/tbody/tr[1]/td[1]/a'),10000);
        },
    },
    // dobavljanje vlasnik i stanari dugmeta
    btnVlasnikStanar: {
        get: function() {
            return utils.waitForElementPresence(by.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-stanovi/div/div[1]/table/tbody/tr[1]/td[2]/a"),10000);
        },
    },
    // dobavljanje cekboksa na stranici kvarovi
    cbZavrseniKvarovi: {
        get: function() {
            return utils.waitForElementPresence(by.xpath("//input[@type='checkbox']"),10000);
        },
    }

});

// Export klase
module.exports = ZgradaPage;