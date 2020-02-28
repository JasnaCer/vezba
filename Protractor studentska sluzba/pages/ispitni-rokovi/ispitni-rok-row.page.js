// Konstruktor kupi vrednost elementa na koji se odnosi.
// rowElement se tada moze koristiti kao pocetak pretrage za druge elemente.
var IspitniRokRow = function(rowElement) {
  this.rowElement = rowElement;
}

IspitniRokRow.prototype = Object.create({}, {
  
  naziv: {
    get: function() {
      return this.rowElement.element(by.xpath('.//td[1]')).getText();
    }
  },
  
  pocetak: {
    get: function() {
      return this.rowElement.element(by.xpath('.//td[2]')).getText();
    }
  },

  kraj: {
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

module.exports = IspitniRokRow;
