// Prazan konstruktor
// Posto je "element" globalna funkcija, ne moramo da prosledimo nista.
var IspitniRokoviCreationPage = function() {};
var utils = require('../utils.js');

// Opis polja i metoda
IspitniRokoviCreationPage.prototype = Object.create({}, {
    
    modalDialog: {
        get: function() {
            return utils.waitForElementPresence(by.className('modal-dialog'), 10000);
        }
    },

    modalTitle: {
        get: function() {
            return utils.waitForElementPresence(by.id('myIspitniRokoviLabel'), 10000);
        }
    },

    naziv: {
        get: function() {
            return utils.waitForElementPresence(by.name('naziv'), 10000);
        },
        set: function(value) {
            this.naziv.clear();
            this.naziv.sendKeys(value);
        }
    },

    pocetak: {
        get: function() {
            return utils.waitForElementPresence(by.id('field_pocetak'), 10000);
        },
        set: function(value) {
            this.pocetak.clear();
            this.pocetak.sendKeys(value);
        }
    },

    kraj: {
        get: function() {
            return utils.waitForElementPresence(by.id('field_kraj'), 10000);
        },
        set: function(value) {
            this.kraj.clear();
            this.kraj.sendKeys(value);
        }
    },
    
    cancelButton: {
        get: function() {
            return utils.waitToBeClickable(by.className('btn-default'), 10000);
        }
    },
    
    saveBtn: {
        get: function() {
            return this.modalDialog.element(by.className('btn-primary'));
        }
    },

    createIspitniRok: {
        value: function(naziv, pocetak, kraj) {
            this.naziv = naziv;
            this.pocetak = pocetak;
            this.kraj = kraj;
            
            this.saveBtn.click();
        }
    }
});

// Export klase
module.exports = IspitniRokoviCreationPage;