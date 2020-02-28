//konstruktor stranice
var ZgradaDodavanjePage = function () { }
var utils = require('../utils.js');
// Opis polja i metoda
ZgradaDodavanjePage.prototype = Object.create({}, {

    // dobavljanje dodavanje dugmeta
    btnDodavanje: {
        get: function() {
            return utils.waitForElementPresence(by.xpath('//button[@class="btn btn-primary"]'), 10000);
        },
    },
    // dobavljanje pregled dugmeta
    btnPregled: {
        get: function() {
            return utils.waitForElementPresence(by.xpath('//button[@class="btn btn-outline-primary"]'),10000);
        },
    },
    // dobavljanje i setovanje mesto polja
    mesto: {
        get: function() {
            return utils.waitForElementPresence(by.id('mesto'), 10000);
        },
        set: function(value) {
            return this.mesto.clear().sendKeys(value);
        }
    },
    // dobavljanje i setovanje ulica polja
    ulica: {
        get: function() {
            return utils.waitForElementPresence(by.id('ulica'), 10000);
        },
        set: function(value) {
            return this.ulica.clear().sendKeys(value);
        }
    },
    // dobavljanje i setovanje broj polja
    broj: {
        get: function() {
            return utils.waitForElementPresence(by.id('broj'), 10000);
        },
        set: function(value) {
            return this.broj.clear().sendKeys(value);
        }
    },
     // dobavljanje i setovanje broj stanova polja
     brojStanova: {
        get: function() {
            return utils.waitForElementPresence(by.id('brojStanova'), 10000);
        },
        set: function(value) {
            return this.brojStanova.clear().sendKeys(value);
        }
    },

    //dobavljanje dodajte dugmeta
	btnDodajte: {
        get: function() {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrade/div/app-dodaj-zgradu/div/form/fieldset/div[5]/div[2]/button[1]'),10000);
        }
    },
    //metoda za dodavanje zgrade
    dodajZgradu: {
        value: function(mes, uli, bro, brojSt) {
            this.mesto = mes;
            this.ulica = uli;
            this.broj = bro;
            this.brojStanova = brojSt;
            this.btnDodajte.click();
        }
    },
    //dobavljanje resetujte dugmeta
	btnResetujte: {
        get: function() {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrade/div/app-dodaj-zgradu/div/form/fieldset/div[5]/div[2]/button[2]'),10000);
        }
    },
    //dobavljanje poruke da je zgrada uspesno dodata 
    msgDodata: {
       
        get: function() {
            return utils.waitForElementPresence(by.xpath("//*[@id='toast-container']/div/div"), 10000);
        }
    },
    //dobavljanje poruke da je polje mesto obavezno
    msgMesto: {
        get: function() {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrade/div/app-dodaj-zgradu/div/form/fieldset/div[1]/div/div'), 10000).getText();
        }
    },
    //dobavljanje poruke da je polje ulica obavezno
    msgUlica: {
        get: function() {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrade/div/app-dodaj-zgradu/div/form/fieldset/div[2]/div/div'), 10000).getText();
        }
    },
    //dobavljanje poruke da je polje broj obavezno
    msgBroj: {
        get: function() {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrade/div/app-dodaj-zgradu/div/form/fieldset/div[3]/div/div'), 10000).getText();
        }
    },
    msgBrojStanova: {
        get: function() {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-zgrade/div/app-dodaj-zgradu/div/form/fieldset/div[4]/div/div'), 10000).getText();
        }
    },
    // dobavljanje poruke da vec postoji zgrada na toj adresi
    msgZgradaVecPostoji: {
        get: function() {
            return utils.waitForElementPresence(by.xpath('//*[@id=\"toast-container\"]/div/div'), 10000).getText();
        }
    }
    

});

// Export klase
module.exports = ZgradaDodavanjePage;