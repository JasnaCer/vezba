// Prazan konstruktor
// Posto je "element" globalna funkcija, ne moramo da prosledimo nista.
var StudentCreationPage = function() {};
var utils = require('../utils.js');

// Opis polja i metoda
StudentCreationPage.prototype = Object.create({}, {
    
    modalDialog: {
        get: function() {
            return utils.waitForElementPresence(by.className('modal-dialog'), 10000);
        }
    },
    
    modalDialogTitle: {
        get: function() {
            return utils.waitForElementPresence(by.id('myStudentiLabel'), 10000).getText();
        }
    },
    
    index: {
        get: function() {
            return utils.waitForElementPresence(by.name('indeks'), 10000);
        },
        set: function(value) {
            return this.index.clear().sendKeys(value);
        }
    },
    
    ime: {
        get: function() {
            return utils.waitForElementPresence(by.name('ime'), 10000);
        },
        set: function(value) {
            return this.ime.clear().sendKeys(value);
        }
    },
    
    prezime: {
        get: function() {
            return utils.waitForElementPresence(by.name('prezime'), 10000);
        },
        set: function(value) {
            return this.prezime.clear().sendKeys(value);
        }
    },
    
    grad: {
        get: function() {
            return utils.waitForElementPresence(by.name('grad'), 10000);
        },
        set: function(value) {
            return this.grad.clear().sendKeys(value);
        }
    },
    
    cancelBtn: {
        get: function() {
            return this.modalDialog.element(by.className('btn-default'));
        }
    },
    
    saveBtn: {
        get: function() {
            return this.modalDialog.element(by.className('btn-primary'));
        }
    },
    
    createStudent: {
        value: function(index, ime, prezime, grad) {
            this.index = index;
            this.ime = ime;
            this.prezime = prezime;
            this.grad = grad;
            this.saveBtn.click();
        }
    }
});

// Export klase
module.exports = StudentCreationPage;