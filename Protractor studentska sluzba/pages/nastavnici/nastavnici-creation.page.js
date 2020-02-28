// Prazan konstruktor
// Posto je "element" globalna funkcija, ne moramo da prosledimo nista.
var NastavniciCreationPage = function() {};
var utils = require('../utils.js');

// Opis polja i metoda
NastavniciCreationPage.prototype = Object.create({}, {
    
    modalDialog: {
        get: function() {
            return utils.waitForElementPresence(by.className('modal-dialog'), 10000);
        }
    },

    modalTitle: {
        get: function() {
            return utils.waitForElementPresence(by.id('myNastavniciLabel'), 10000);
        }
    },

    ime: {
        get: function() {
            return utils.waitForElementPresence(by.name('ime'), 10000);
        },
        set: function(value) {
            this.ime.clear();
            this.ime.sendKeys(value);
        }
    },

    prezime: {
        get: function() {
            return utils.waitForElementPresence(by.name('prezime'), 10000);
        },
        set: function(value) {
            this.prezime.clear();
            this.prezime.sendKeys(value);
        }
    },

    zvanje: {
        get: function() {
            return utils.waitForElementPresence(by.name('zvanje'), 10000);
        },
        set: function(value) {
            this.zvanje.clear();
            this.zvanje.sendKeys(value);
        }
    },
    
    cancelButton: {
        get: function() {
            return this.modalDialog.element(by.className('btn-default'));
        }
    },
    
    saveBtn: {
        get: function() {
            return this.modalDialog.element(by.className('btn-primary'));
        }
    },

    createNastavnik: {
        value: function(ime, prezime, zvanje) {
            this.ime = ime;
            this.prezime = prezime;
            this.zvanje = zvanje;
            
            this.saveBtn.click();
        }
    }
});

// Export klase
module.exports = NastavniciCreationPage;