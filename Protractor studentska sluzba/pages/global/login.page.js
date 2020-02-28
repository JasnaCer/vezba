// Prazan konstruktor
// Posto je "element" globalna funkcija, ne moramo da prosledimo nista.
var LoginPage = function() {};
var utils = require('../utils.js');

// Opis polja i metoda
LoginPage.prototype = Object.create({}, {
    
    // Username polje
    username: {
        get: function() {
            return utils.waitForElementPresence(by.model('username'), 10000);
        },
        set: function(value) {
            this.username.clear();
            this.username.sendKeys(value);
        }
    },
    
    // Password polje
    password: {
        get: function() {
            return utils.waitForElementPresence(by.model('password'), 10000);
        },
        set: function(value) {
            this.password.clear();
            this.password.sendKeys(value);
        }
    },
    
    // Sign in button
    signInBtn: {
        get: function() {
            return utils.waitForElementPresence(by.buttonText('Sign in'), 10000);
        }
    },
    
    // Metoda za prelazak na ovu stranicu
    navigateToPage: {
        value: function() {
            browser.get('http://localhost:8080/#/login');
            browser.wait(function() {
                return browser.getCurrentUrl().then(function(url) {
                    return url === 'http://localhost:8080/#/login';
                });
            }, 5000)
        }
    },
    
    // Metoda za login
    login: {
        value: function(usernameString, passwordString) {
            this.username = usernameString;
            this.password = passwordString;
            this.signInBtn.click();
        }
    }
});

// Export klase
module.exports = LoginPage;
