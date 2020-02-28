//konstruktor stranice
var PredsednikZgradaKvaroviPage = function () { }
var utils = require('../utils.js');
// Opis polja i metoda
PredsednikZgradaKvaroviPage.prototype = Object.create({}, {

    prikaz: {
        get: function () {
            return utils.waitForElementPresence(by.id('prikaz'), 10000).getText();
        },
        set: function (value) {
            this.prikaz.element(by.cssContainingText('option', value)).click();
        }
    },
    btnDodaj: {
        get: function () {
            return utils.waitForElementPresence(by.xpath('//*[@id="dodaj"]/button'), 10000);
        }
    },
    checkKvarovi: {
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrada/div/div[2]/app-kvarovi/div/div/label/input'), 10000);
        }
    },

    btnPregledaj: {
        get: function () {
            return utils.waitForElementPresence(by.xpath('//*[@id="kvar_2"]/table/tbody/tr[4]/td/a'), 10000);
        }
    },
    btnIzmeni: {
        get: function () {
            return utils.waitForElementPresence(by.xpath('//*[@id="kvar_1"]/table/tbody/tr[4]/td/span[1]'), 10000);
        }
    },

    btnbrisi: {
        get: function () {
            return utils.waitForElementPresence(by.xpath('//*[@id="kvar_1"]/table/tbody/tr[4]/td/span[2]/a'), 10000);
        }
    },



});

// Export klase
module.exports = PredsednikZgradaKvaroviPage;