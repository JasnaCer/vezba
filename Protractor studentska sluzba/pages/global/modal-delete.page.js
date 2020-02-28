// Prazan konstruktor
// Posto je "element" globalna funkcija, ne moramo da prosledimo nista.
var ModalDeletePage = function() {};
var utils = require('../utils.js');

// Opis polja i metoda
ModalDeletePage.prototype = Object.create({}, {
    
    // Modal element
    modal: {
        get: function() {
            return utils.waitForElementPresence(by.className('modal-dialog'), 15000);
        }
    },
    
    // Confirm deletion
    confirmDelete: {
        value: function() {
            return this.modal.element(by.className('btn-danger')).click();
        }
    },
    
    // Cancel deletion
    cancelDelete: {
        value: function() {
            return this.modal.element(by.className('btn-primary')).click();
        }
    },
});

// Export klase
module.exports = ModalDeletePage;