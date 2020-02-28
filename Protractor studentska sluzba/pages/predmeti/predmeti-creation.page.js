// Prazan konstruktor
// Posto je "element" globalna funkcija, ne moramo da prosledimo nista.
var PredmetiCreationPage = function() {};
var utils = require('../utils.js');
var _ = require('lodash');

// Opis polja i metoda
PredmetiCreationPage.prototype = Object.create({}, {
    
    modalDialog: {
        get: function() {
            return utils.waitForElementPresence(by.className('modal-dialog'), 10000);
        }
    },

    modalTitle: {
        get: function() {
            return utils.waitForElementPresence(by.id('myPredmetiLabel'), 10000);
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

    studenti: {
        get: function() {
            return utils.waitForElementPresence(by.name('studenti'), 10000);
        },
        set: function(studentLabels) {
            var studenti = this.studenti;
            _.each(studentLabels, function(studentLabel) {
                studenti.element(by.cssContainingText('option', studentLabel)).click();
            });
        }
    },

    nastavnici: {
        get: function() {
            return utils.waitForElementPresence(by.name('nastavnici'), 10000);
        },
        set: function(nastavniciLabels) {
            var nastavnici = this.nastavnici;
            _.each(nastavniciLabels, function(nastavnikLabel) {
                nastavnici.element(by.cssContainingText('option', nastavnikLabel)).click();
            });
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

    createPredmet: {
        value: function(naziv, studenti, nastavnici) {
            this.naziv = naziv;
            this.studenti = studenti;
            this.nastavnici = nastavnici;
            
            this.saveBtn.click();
        }
    }
});

// Export klase
module.exports = PredmetiCreationPage;