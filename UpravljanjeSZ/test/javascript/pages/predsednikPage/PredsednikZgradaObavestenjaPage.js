//konstruktor stranice
var PredsednikZgradaObavestenjaPage = function () { }
var utils = require('../utils.js');
// Opis polja i metoda
PredsednikZgradaObavestenjaPage.prototype = Object.create({}, {

    // h2 poruka Zgrada za asertaciju da sam na stranici zgrada
    textMsg: {
        get: function () {
            return utils.waitForElementPresence(by.xpath("/html/body/app-root/app-zgrada/div/h2"), 10000).getText();
        }
    },
    // adresa
    adresa: {
        get: function () {
            return utils.waitForElementPresence(by.xpath("/html/body/app-root/app-zgrada/div/div[1]/h5[1]"), 10000).getText();
        }
    },
    //predsednik
    predsednik: {
        get: function () {
            return utils.waitForElementPresence(by.xpath("/html/body/app-root/app-zgrada/div/div[1]/h5[2]"), 10000).getText();
        }
    },
    predsednikLink: {
        get: function () {
            return utils.waitForElementPresence(by.partialLinkText("Gospodin Predsednik"), 10000);
        }
    },

    //MENI sa tabobvima
    tabObavestenja: {
        get: function () {
            return utils.waitForElementPresence(by.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-navbar-zgrada/ul/li[1]"), 10000);
        }
    },
    tabPredloziTacke: {
        get: function () {
            return utils.waitForElementPresence(by.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-navbar-zgrada/ul/li[2]"), 10000);
        }
    },
    tabSastanciSkupstine: {
        get: function () {
            return utils.waitForElementPresence(by.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-navbar-zgrada/ul/li[3]"), 10000);
        }
    },
    tabKvarovi: {
        get: function () {
            return utils.waitForElementPresence(by.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-navbar-zgrada/ul/li[4]"), 10000);
        }
    },

    //SELEKT Prikazi
    prikaz: {
        get: function () {
            return utils.waitForElementPresence(by.id('prikaz'), 10000).getText();
        },
        set: function (value) {
            this.prikaz.element(by.cssContainingText('option', value)).click();
        }
    },
    btnDodajObavestenje: {
        get: function () {
            return utils.waitForElementPresence(by.id('dodajObavestenje'), 10000);
        }
    },
    formaDodajObavestenje: {
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-dodaj-obavestenje/div/form'), 10000);
        }
    },
    formaDodajObavestenjeNaslov: {
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-dodaj-obavestenje/div/form/fieldset/legend'), 10000);
        }
    },
    textpolje: {
        get: function () {
            return utils.waitForElementPresence(by.id('tekstObavestenja'), 10000);
        },
        set: function (value) {
            return this.textpolje.clear().sendKeys(value);
        }
    },
    btnPotvrdi: {
        get: function () {
            return utils.waitForElementPresence(by.id('dodajObavestenje'), 10000);
        }
    },
    msgAlert: {
        get: function () {
            return utils.waitForElementPresence(by.xpath('//*[@id="toast-container"]/div/div'), 15000);
        }
    },
    btnIzmeniObavestenje: {
        get: function () {
            return utils.waitForElementPresence(by.id('izmeniObavestenje'), 10000);
        }
    },
    //TABELICA OBAVESTENJE
    poljeObavestenjeTabela: {
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-obavestenja/div[1]/div/table'), 10000);
        }
    },
    // red  izvucen iz tabele po imenu
    getRedPoljeObavestenjeTabela: {
        value: function (sadrzaj) {
            return utils.waitForElementPresence(by.xpath('//*[contains(text(),"' + sadrzaj + '")]/../..'), 10000);
        }
    },
    // red za koji ocekujem da nije prisutan u tabeli
    getRedNijeUTabeli: {
        value: function (sadrzaj) {
            return utils.waitForElementInvisibility(by.xpath('//*[contains(text(),"' + sadrzaj + '")]/../..'), 10000);
        }
    },
    textKojiMenjam: {
        get: function () {
            return utils.waitForElementPresence(by.id('noviTekst'), 10000);
        },
        set: function (value) {
            return this.textKojiMenjam.clear().sendKeys(value);
        }
    },
    btnPotvrdi2: {
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-obavestenja/div[1]/div/table/tbody/tr[3]/td/span/a[2]/span'), 10000);
        }
    },
    btnOdustani: {
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-obavestenja/div[1]/div/table/tbody/tr[3]/td/span/a[3]/span'), 10000);
        }
    },
    btnBrisi: {
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-obavestenja/div[1]/div/table/tbody/tr[3]/td/span/a[4]/span'), 10000);
        }
    },

});

// Export klase
module.exports = PredsednikZgradaObavestenjaPage;
