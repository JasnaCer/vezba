// Konstruktor kupi vrednost elementa na koji se odnosi.
// rowElement se tada moze koristiti kao pocetak pretrage za druge elemente.
var PredmetRow = function(rowElement) {
  this.rowElement = rowElement;
}

PredmetRow.prototype = Object.create({}, {
  
  ime: {
    get: function() {
      return this.rowElement.element(by.xpath('.//td[1]')).getText();
    }
  },
  
  studenti: {
    get: function() {
      return this.rowElement.element(by.xpath('.//td[2]')).getText();
    }
  },

  nastavnici: {
    get: function() {
      return this.rowElement.element(by.xpath('.//td[3]')).getText();
    }
  },
  
  viewBtn: {
    get: function() {
      return this.rowElement.element(by.className('btn-info'));
    }
  },
  
  editBtn: {
    get: function() {
      return this.rowElement.element(by.className('btn-primary'));
    }
  },
  
  deleteBtn: {
    get: function() {
      return this.rowElement.element(by.className('btn-danger'));
    }
  }
});

module.exports = PredmetRow;
