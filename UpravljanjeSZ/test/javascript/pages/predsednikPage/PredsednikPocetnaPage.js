//konstruktor stranice
var PredsednikPocetnaPage = function () { }
var utils = require('../utils.js');
// Opis polja i metoda
PredsednikPocetnaPage.prototype = Object.create({}, {

    // dobavljanje linka pocetna iz menija
    linkPocetna: {
        get: function () {
            return utils.waitForElementPresence(by.xpath('//*[@id="navbarColor02"]/ul[1]/li[1]/a'), 10000);
        },
    },
    // dobavljanje linka Dodeljeni kvarovi iz menija
    dodeljeniKvarovi: {
        get: function () {
            return utils.waitForElementPresence(by.xpath('//*[@id="navbarColor02"]/ul[1]/li[2]'), 10000);
        },
    },
    // dobavljanje linka promen lozinke iz menija
    promenaLozinke: {
        get: function () {
            return utils.waitForElementPresence(by.xpath('//*[@id="navbarColor02"]/ul[1]/li[3]/a'), 10000);
        },
    },
    // dobavljanje linka email ulogovanog korisnika iz menija
    emailUlogovaniKorisnik: {
        get: function () {
            return utils.waitForElementPresence(by.xpath('//*[@id="navbarColor02"]/ul[2]/li[1]/label'), 10000);
        },
    },
    // dobavljanje Izlogujte se dugmeta
    btnIzlogujetSe: {
        get: function () {
            return utils.waitForElementPresence(by.xpath('//*[@id="navbarColor02"]/ul[2]/li[2]/button'), 10000);
        },
    },

    //TABELA Zgrada u kojoj zivite
    zgradaUKojojZiviteTable: {
        get: function () {
            return utils.waitForElementPresence(by.id('zgradaStanuje'), 10000);
        }
    },
    // red iz tabele po ulici
    getStanGdeStanujeRed: {
        value: function (ulica) {
            return utils.waitForElementPresence(by.xpath('//*[contains(text(),"' + ulica + '")]/../..'), 10000);
        }
    },
    // red za koji ocekujem da nije prisutan u tabeli
    getRedNijeUTabeli: {
        value: function (ulica) {
            return utils.waitForElementInvisibility(by.xpath('//*[contains(text(),"' + ulica + '")]/../..'), 10000);
        }
    },
    //link adresa tabela stanuje
    linkStranicaZgrada: {
        get: function () {
            return utils.waitForElementPresence(by.xpath('//*[@id="zgradaStanuje"]/tbody/tr/td[4]/a'), 10000);
        },
    },

    //TABELA Zgrade u kojima ste vlasnik stana
    zgradeGdeJeVlasnikTable: {
        get: function () {
            return utils.waitForElementPresence(by.id('zgradaVlasnik'), 10000);
        }
    },
    gdeJeVlasnikRed: {
        value: function (adresa) {
            return utils.waitForElementPresence(by.xpath('//*[contains(text(),"' + adresa + '")]/../..'), 10000);
        }
    },
    // red za koji ocekujem da nije prisutan u tabeli
    getRedNijeUTabeli: {
        value: function (adresa) {
            return utils.waitForElementInvisibility(by.xpath('//*[contains(text(),"' + adresa + '")]/../..'), 10000);
        }
    },
    //link adresa tabela vlasnik
    linkStranica: {
        get: function () {
            return utils.waitForElementPresence(by.xpath('//*[@id="zgradaVlasnik"]/tbody/tr/td[4]/a'), 10000);
        },
    }





});

// Export klase
module.exports = PredsednikPocetnaPage;
