var IspitniRokRow = require('./ispitni-rok-row.page.js');
// Prazan konstruktor
// Posto je "element" globalna funkcija, ne moramo da prosledimo nista.
var StudentsListPage = function() {};

// Opis polja i metoda
StudentsListPage.prototype = Object.create({}, {
    
    createBtn: {
        get: function() {
            return element(by.xpath("//button [@ui-sref=\"ispitniRokovi.new\"]"));
        }
    },
    
    ispitniRokoviTable: {
        get: function() {
            return element(by.className('jh-table'));
        }
    },
    
    tableRows: {
        get: function() {
            return element.all(by.repeater('ispitniRokovi in ispitniRokovis'));
        }
    },
    
    getIspitniRokByName: {
        value: function(name) {
            var el = utils.waitForElementPresence(by.xpath('//*[contains(text(),"' + name + '")]/../..'), 10000);
            return new IspitniRokRow(el);
        }
    }
});

// Export klase
module.exports = StudentsListPage;