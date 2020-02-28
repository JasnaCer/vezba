//konstruktor stranice
var StanariRegistracijaPage = function () { }
var utils = require('../utils.js');
// Opis polja i metoda
StanariRegistracijaPage.prototype = Object.create({}, {

    // dobavljanje registracija dugmeta
btnRegistracija: {
    get: function() {
        return utils.waitForElementPresence(by.xpath('//button[@class="btn btn-primary"]'), 10000);
    },
},
// dobavljanje pregled dugmeta
btnPregled: {
    get: function() {
        return utils.waitForElementPresence(by.xpath('//button[@class="btn btn-outline-primary"]'),10000);
    },
},
// dobavljanje i setovanje email polja
email: {
    get: function() {
        return utils.waitForElementPresence(by.id('email'), 10000);
    },
    set: function(value) {
        return this.email.clear().sendKeys(value);
    }
},
// dobavljanje i setovanje lozinka polja
lozinka: {
    get: function() {
        return utils.waitForElementPresence(by.id('lozinka'), 10000);
    },
    set: function(value) {
        return this.lozinka.clear().sendKeys(value);
    }
},
// dobavljanje i setovanje ime polja
ime: {
    get: function() {
        return utils.waitForElementPresence(by.id('ime'), 10000);
    },
    set: function(value) {
        return this.ime.clear().sendKeys(value);
    }
},
 // dobavljanje i setovanje prezime polja
 prezime: {
    get: function() {
        return utils.waitForElementPresence(by.id('prezime'), 10000);
    },
    set: function(value) {
        return this.prezime.clear().sendKeys(value);
    }
},
//dobavljanje registrujte dugmeta
btnRegistrujte: {
    get: function() {
        return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-stanari/div/app-registruj-stanara/div/form/fieldset/div[5]/div[2]/button[1]'),10000);
    }
},
//metoda za registraciju stanara
registrujStanara: {
    value: function(email, lozinka, ime, prezime) {
        this.email = email;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.btnRegistrujte.click();
    }
},
//dobavljanje resetujte dugmeta
btnResetujte: {
    get: function() {
        return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-stanari/div/app-registruj-stanara/div/form/fieldset/div[5]/div[2]/button[2]'),10000);
    }
},
 //dobavljanje poruke uspesno ste registrovali stanara
 msgAlert: {
       
    get: function() {
        return utils.waitForElementPresence(by.xpath('//*[@id="toast-container"]/div/div'), 10000);
    }                                               
},
//dobavljanje poruke da je email pogresan ili obavezan
msgEmail: {
    get: function() {
        return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-stanari/div/app-registruj-stanara/div/form/fieldset/div[1]/div/div'), 10000).getText();
    }
},
//dobavljanje poruke da je polje lozinka obavezno ili pogresno
msgLozinka: {
    get: function() {
        return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-stanari/div/app-registruj-stanara/div/form/fieldset/div[2]/div/div'), 10000).getText();
    }
},
//dobavljanje poruke da je polje ime obavezno
msgIme: {
    get: function() {
        return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-stanari/div/app-registruj-stanara/div/form/fieldset/div[3]/div/div'), 10000).getText();
    }
},
//dobavljanje poruke da je polje prezime obavezno
msgPrezime: {
    get: function() {
        return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-stanari/div/app-registruj-stanara/div/form/fieldset/div[4]/div/div'), 10000).getText();
    }
},
});
    // Export klase
module.exports = StanariRegistracijaPage;
