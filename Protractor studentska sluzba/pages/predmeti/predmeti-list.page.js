var PredmetRow = require('./predmet-row.page.js');
// Prazan konstruktor
// Posto je "element" globalna funkcija, ne moramo da prosledimo nista.
var PredmetiListPage = function() {};
var utils = require('../utils.js');

// Opis polja i metoda
PredmetiListPage.prototype = Object.create({}, {
    
    createBtn: {
        get: function() {
            return element(by.xpath("//button [@ui-sref=\"predmeti.new\"]"));
        }
    },
    
    predmetiTable: {
        get: function() {
            return element(by.className('jh-table'));
        }
    },
    
    tableRows: {
        get: function() {
            return element.all(by.repeater('predmeti in predmetis'));
        }
    },
    
    getPredmetByName: {
        value: function(name) {
            var el = utils.waitForElementPresence(by.xpath('//*[contains(text(),"' + name + '")]/../..'), 10000);
            return new PredmetRow(el);
        }
    }
});

// Export klase
module.exports = PredmetiListPage;