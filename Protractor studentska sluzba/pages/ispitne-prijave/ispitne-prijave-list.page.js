// Prazan konstruktor
// Posto je "element" globalna funkcija, ne moramo da prosledimo nista.
var StudentsListPage = function() {};
var utils = require('../utils.js');

// Opis polja i metoda
StudentsListPage.prototype = Object.create({}, {
    
    createBtn: {
        get: function() {
            return utils.waitToBeClickable(by.xpath("//button [@ui-sref=\"ispitnePrijave.new\"]"), 10000);
        }
    },
    
    ispitnaPrijavaTable: {
        get: function() {
            return utils.waitForElementPresence(by.className('jh-table'), 10000);
        }
    },
    
    tableRows: {
        get: function() {
            return this.ispitnaPrijavaTable.all(by.repeater('ispitnePrijave in ispitnePrijaves'));
        }
    }
});

// Export klase
module.exports = StudentsListPage;