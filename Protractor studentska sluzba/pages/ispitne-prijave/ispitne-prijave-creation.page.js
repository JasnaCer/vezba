// Prazan konstruktor
// Posto je "element" globalna funkcija, ne moramo da prosledimo nista.
var IspitnePrijaveCreationPage = function() {};
var utils = require('../utils.js');

// Opis polja i metoda
IspitnePrijaveCreationPage.prototype = Object.create({}, {
    
    modalDialog: {
        get: function() {
            return utils.waitForElementPresence(by.className('modal-dialog'), 10000);
        }
    },

    modalTitle: {
        get: function() {
            return utils.waitForElementPresence(by.id('myIspitnePrijaveLabel'), 10000);
        }
    },

    teorija: {
        get: function() {
            return utils.waitForElementPresence(by.id('field_teorija'), 10000);
        },
        set: function(value) {
            this.teorija.clear();
            this.teorija.sendKeys(value);
        }
    },

    zadaci: {
        get: function() {
            return utils.waitForElementPresence(by.id('field_zadaci'), 10000);
        },
        set: function(value) {
            this.zadaci.clear();
            this.zadaci.sendKeys(value);
        }
    },

    ispitniRok: {
        get: function() {
            return utils.waitForElementPresence(by.id('field_ispitniRok'), 10000);
        },
        set: function(value) {
            this.ispitniRok.element(by.cssContainingText('option', value)).click();
        }
    },

    student: {
        get: function() {
            return utils.waitForElementPresence(by.id('field_student'), 10000);
        },
        set: function(value) {
            this.student.element(by.cssContainingText('option', value)).click();
        }
    },

    predmet: {
        get: function() {
            return utils.waitForElementPresence(by.id('field_predmet'), 10000);
        },
        set: function(value) {
            this.predmet.element(by.cssContainingText('option', value)).click();
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

    createIspitnaPrijava: {
        value: function(teorija, zadaci, ispitniRok, student, predmet) {
            this.teorija = teorija;
            this.zadaci = zadaci;
            this.ispitniRok = ispitniRok;
            this.student = student;
            this.predmet = predmet;

            this.saveBtn.click();
        }
    }
});

// Export klase
module.exports = IspitnePrijaveCreationPage;