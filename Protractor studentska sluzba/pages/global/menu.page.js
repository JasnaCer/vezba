// Prazan konstruktor
// Posto je "element" globalna funkcija, ne moramo da prosledimo nista.
var MenuPage = function() {};
var utils = require('../utils.js');

// Opis polja i metoda
MenuPage.prototype = Object.create({}, {
    
    // AccountMenu dropdown
    accountMenu: {
        get: function() {
            return utils.waitForElementPresence(by.id('account-menu'), 10000);
        }
    },
    
    // Sign up button
    signUp: {
        get: function() {
            return utils.waitForElementPresence(by.xpath('//a [@ui-sref="login"]'), 10000);
        }
    },

    // Register button
    register: {
        get: function() {
            return utils.waitToBeClickable(by.xpath('//a [@ui-sref="register"]'), 10000);
        }
    },
    
    // Entities dropdown button
    entities: {
        get: function() {
            return utils.waitToBeClickable(by.linkText('Entities'), 10000);
        }
    },
    
    // Studenti link
    studentsLink: {
        get: function() {
            return utils.waitToBeClickable(by.xpath('//a[@ui-sref=\"studenti\"]'), 10000);
        }
    },

    // Ispitni rokovi link
    ispitniRokoviLink: {
        get: function() {
            return utils.waitToBeClickable(by.xpath('//a [@ui-sref=\"ispitniRokovi\"]'), 10000);
        }
    },

    // Nastavnici link
    nastavniciLink: {
        get: function() {
            return utils.waitToBeClickable(by.xpath('//a [@ui-sref=\"nastavnici\"]'), 10000);
        }
    },

    // predmeti link
    predmetiLink: {
        get: function() {
            return utils.waitToBeClickable(by.xpath('//a [@ui-sref=\"predmeti\"]'), 10000);
        }
    },

    // ispitnePrijave link
    ispitnePrijaveLink: {
        get: function() {
            return utils.waitToBeClickable(by.xpath('//a [@ui-sref=\"ispitnePrijave\"]'), 10000);
        }
    },
    
    // Log out button
    logOut: {
        get: function() {
            return utils.waitToBeClickable(by.id('logout'), 10000);
        }
    }
});

// Export klase
module.exports = MenuPage;