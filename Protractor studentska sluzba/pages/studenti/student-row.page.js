// Konstruktor kupi vrednost elementa na koji se odnosi.
// rowElement se tada moze koristiti kao pocetak pretrage za druge elemente.
var StudentRow = function(rowElement) {
  this.rowElement = rowElement;
}

StudentRow.prototype = Object.create({}, {
  
  index: {
    get: function() {
      return this.rowElement.element(by.binding('studenti.indeks')).getText();
    }
  },
  
  ime: {
    get: function() {
      return this.rowElement.element(by.binding('studenti.ime')).getText();
    }
  },
  
  prezime: {
    get: function() {
      return this.rowElement.element(by.binding('studenti.prezime')).getText();
    }
  },
  
  grad: {
    get: function() {
      return this.rowElement.element(by.binding('studenti.grad')).getText();
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

module.exports = StudentRow;
