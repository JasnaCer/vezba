var NastavnikRow = require('./nastavnik-row.page.js');
// Prazan konstruktor
// Posto je "element" globalna funkcija, ne moramo da prosledimo nista.
var NastavniciListPage = function() {};
var utils = require('../utils.js');

// Opis polja i metoda
NastavniciListPage.prototype = Object.create({}, {
    
    createBtn: {
        get: function() {
            return element(by.xpath("//button [@ui-sref=\"nastavnici.new\"]"));
        }
    },
    
    nastavniciTable: {
        get: function() {
            return element(by.className('jh-table'));
        }
    },
    
    tableRows: {
        get: function() {
            return element.all(by.repeater('nastavnici in nastavnicis'));
        }
    },
    
    getNastavnikByName: {
        value: function(name) {
            var el = utils.waitForElementPresence(by.xpath('//*[contains(text(),"' + name + '")]/../..'), 10000);
            return new NastavnikRow(el);
        }
    }
});

// Export klase
module.exports = NastavniciListPage;