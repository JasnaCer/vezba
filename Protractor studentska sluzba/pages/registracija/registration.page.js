// Prazan konstruktor
// Posto je "element" globalna funkcija, ne moramo da prosledimo nista.
var RegistrationPage = function() {};
var utils = require('../utils.js');

// Opis polja i metoda
RegistrationPage.prototype = Object.create({}, {
    
    username: {
        get: function() {
            return utils.waitForElementPresence(by.name('login'), 10000);
        },
        set: function(value) {
            this.username.clear();
            this.username.sendKeys(value);
        }
    },

    usernameErrors: {
        get: function() {
            // Uzimamo sve <p> tagove u prvom div elementu nakon elementa sa id "login".
            // Ovo su tagovi sa tekstom greske. Zatim filterujemo i uzimamo samo one koji su prikazani.
            // Nakon toga preuzimamo tekst. Povratna vrednost je stoga Promise koji ce za rezultat imati
            // niz stringova trenutnih gresaka. NPR:
            //
            // ['Your username cannot be longer than 50 characters.', 'Your username can only contain lower-case letters and digits.']
            var errors =  element.all(by.css('#login + div p')).filter(function(err) {
                return err.isDisplayed();
            });

            return errors.getText();
        }
    },
    
    email: {
        get: function() {
            return utils.waitForElementPresence(by.name('email'), 10000);
        },
        set: function(value) {
            this.email.clear();
            this.email.sendKeys(value);
        }
    },

    emailErrors: {
        get: function() {
            var errors =  element.all(by.css('#email + div p')).filter(function(err) {
                return err.isDisplayed();
            });

            return errors.getText();
        }
    },

    password: {
        get: function() {
            return utils.waitForElementPresence(by.name('password'), 10000);
        },
        set: function(value) {
            this.password.clear();
            this.password.sendKeys(value);
        }
    },

    passwordErrors: {
        get: function() {
            var errors =  element.all(by.css('#password + div p')).filter(function(err) {
                return err.isDisplayed();
            });

            return errors.getText();
        }
    },

    confirmPassword: {
        get: function() {
            return utils.waitForElementPresence(by.name('confirmPassword'), 10000);
        },
        set: function(value) {
            this.confirmPassword.clear();
            this.confirmPassword.sendKeys(value);
        }
    },

    confirmPasswordErrors: {
        get: function() {
            var errors =  element.all(by.css('#confirmPassword + div p')).filter(function(err) {
                return err.isDisplayed();
            });

            return errors.getText();
        }
    },

    registerBtn: {
        get: function() {
            return element(by.css('form button[type=submit]'));
        }
    },

    actionMessage: {
        get function() {
            // Uzimamo alert element koji nije sakriven.
            return element(by.css('alert:not(.ng-hide)')).getText();
        }
    }
});

// Export klase
module.exports = RegistrationPage;