var StudentRow = require('./student-row.page.js');
// Prazan konstruktor
// Posto je "element" globalna funkcija, ne moramo da prosledimo nista.
var StudentsListPage = function() {};
var utils = require('../utils.js');

// Opis polja i metoda
StudentsListPage.prototype = Object.create({}, {
    
    createBtn: {
        get: function() {
            return element(by.xpath("//button [@ui-sref=\"studenti.new\"]"));
        }
    },
    
    studentsTable: {
        get: function() {
            return element(by.className('jh-table'));
        }
    },
    
    tableRows: {
        get: function() {
            return element.all(by.repeater('studenti in studentis'));
        }
    },
    
    getStudentRowByIndex: {
        value: function(index) {
            var el = this.studentsTable.element(by.xpath('//*[contains(text(),"' + index + '")]/../..'));
            // Povratna vrednost je objekat tipa StudentRow
            // Ovaj objekat ima polja koja opisuju jedan red u tabeli sa studentima.
            // Ako zelimo da pristupimo bas samom redu kao elementu tada koristiti polje
            // rowElement u novokreiranom objektu.
            return new StudentRow(el);
        }
    }
});

// Export klase
module.exports = StudentsListPage;