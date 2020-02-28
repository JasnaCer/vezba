// Prazan konstruktor
// Posto je "element" globalna funkcija, ne moramo da prosledimo nista.
var HomePage = function() {}
var utils = require('../utils.js');

// Opis polja i metoda
HomePage.prototype = Object.create({}, {
    
    // Login Confirmation text
    loginConfirmationText: {
        get: function() {
            return utils.waitForElementPresence(by.binding('account.login'), 10000).getText();
        }
    }
});

// Export klase
module.exports = HomePage;