//konstruktor stranice
var LoginPage = function () { }
var utils = require('../utils.js');
// Opis polja i metoda
LoginPage.prototype = Object.create({}, {

    //dobavljanje i setovanje email polja
    email: {
        get: function() {
            return utils.waitForElementPresence(by.id('email'), 10000);
        },
        set: function(value) {
            return this.email.clear().sendKeys(value);
        }
    },
    //dobavljanje i setovanje lozinka polja
    lozinka: {
        get: function() {
            return utils.waitForElementPresence(by.id('lozinka'),10000);
        },
        set: function(value) {
            return this.lozinka.clear().sendKeys(value);
        }
    },
    //dobavljanje uloguj se dugmeta
	btnUlogujSe: {
        get: function() {
            return utils.waitForElementPresence(by.xpath("//button[@class='btn btn-primary']"),10000);
        }
    },
    // poruka koja se ispise kada se ne unese validan email 
    msgEmail: {
       
        get: function() {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-logovanje/div/form/fieldset/div[1]/strong'), 10000);
        }
    },
    // poruka koja se ispise kada se ne unese validna lozinka  
    msgLozinka: {
        get: function() {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-logovanje/div/form/fieldset/div[1]/strong'), 10000).getText();
        }
    },
    //metoda za login(prosledjuje parametre i klikce)
    login: {
        value: function(ema, loz) {
            this.email = ema;
            this.lozinka = loz;
            this.btnUlogujSe.click();
        }
    }

});

// Export klase
module.exports = LoginPage;