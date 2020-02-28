//konstruktor stranice
var PredsednikZgradaPredloziTackePage = function () { }
var utils = require('../utils.js');
// Opis polja i metoda
PredsednikZgradaPredloziTackePage.prototype = Object.create({}, {
    
    //PREDLOZI TACKE 
    prikaz: {
        get: function () {
            return utils.waitForElementPresence(by.id('prikaz'), 10000).getText();
        },
        set: function (value) {
            this.prikaz.element(by.cssContainingText('option', value)).click();
        }
    },
    btnDodajPredlogTacku: {
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-tacke/a/button/b'), 10000);
        }
    },
    selektSkupstinu: {
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-tacke/select'), 10000).getText();
        },
        set: function (value) {
            this.selektSkupstinu.element(by.cssContainingText('option', value)).click();
        }
    },
    btnDodajPredlogTackeUSkupstinu: {
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-tacke/div[1]/div/table/tbody/tr[1]/td[2]/button'), 10000);
        }
    },
    formaDodajPredlogTacku: {
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-dodaj-ptdr/div/form'), 10000);
        }
    },
    formaDodajPredlogTackuNaslov: {
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-dodaj-ptdr/div/form/fieldset/legend'), 10000);
        }
    },
    textpolje: {
        get: function() {
            return utils.waitForElementPresence(by.id('tekstPtdr'), 10000);
        },
        set: function(value) {
            return this.textpolje.clear().sendKeys(value);
        }
    },
    btnPotvrdiPredlogTacku: {
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-dodaj-ptdr/div/form/fieldset/div[2]/button'), 10000);
        }
    },
    btnIzmeniTacku: {
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-tacke/div[1]/div/table/tbody/tr[3]/td/span/a[1]/span'), 10000);
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
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-tacke/div[1]/div/table/tbody/tr[3]/td/span/a[2]/span'), 10000);
        }
    },
    btnOdustani: {
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-tacke/div[1]/div/table/tbody/tr[3]/td/span/a[3]/span/font'), 10000);
        }
    },
    btnBrisi: {
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-tacke/div[1]/div/table/tbody/tr[3]/td/span/a[4]/span'), 10000);
        }                                                 
    },

});
    // Export klase
module.exports = PredsednikZgradaPredloziTackePage;