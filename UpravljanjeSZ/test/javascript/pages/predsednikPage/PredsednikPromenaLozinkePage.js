//konstruktor stranice
var PredsednikPromenaLozinkePage = function () { }
var utils = require('../utils.js');
// Opis polja i metoda
PredsednikPromenaLozinkePage.prototype = Object.create({}, {

   
    //dobavljanje forme promena lozinke 
    formaLozinka: {
        get: function () {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-promena-lozinke/div/form'), 10000);
        },
    },

    // dobavljanje i setovanje polja stara lozinka
    staraLozinka: {
        get: function () {
            return utils.waitForElementPresence(by.id('staraLozinka'), 10000);
        },
        set: function (value) {
            return this.staraLozinka.clear().sendKeys(value);
        }
    },

    // dobavljanje i setovanje polja nova lozinka
    novaLozinka: {
        get: function () {
            return utils.waitForElementPresence(by.id('novaLozinka'), 10000);
        },
        set: function (value) {
            return this.novaLozinka.clear().sendKeys(value);
        }
    },
    // dobavljanje i setovanje polja potvrda lozinke
    potvrdaLozinke: {
        get: function () {
            return utils.waitForElementPresence(by.id('potvrdaNoveLozinke'), 10000);
        },
        set: function (value) {
            return this.potvrdaLozinke.clear().sendKeys(value);
        }
    },
    
    // dobavljanje promeni lozinku dugmetta
    btnPromeniLozinku: { 
        get: function () {
            return utils.waitForElementPresence(by.xpath("//html/body/app-root/app-promena-lozinke/div/form/fieldset/div[4]/button"), 10000);
        },
    },
    //  //metoda za setovanje polja
     promeniPass: {
        value: function(stara, nova, potvrdi) {
            this.staraLozinka = stara;
            this.novaLozinka = nova;
            this.potvrdaLozinke = potvrdi;
            this.btnPromeniLozinku.click();
        }
    },
    msgStaraObavezno: {
        get: function () {
            return utils.waitForElementPresence(by.xpath("/html/body/app-root/app-promena-lozinke/div/form/fieldset/div[1]/div"), 10000);
        },
    },
    msgNovaObaveznoNeispravno: {
        get: function () {
            return utils.waitForElementPresence(by.xpath("/html/body/app-root/app-promena-lozinke/div/form/fieldset/div[2]/div[1]/div"), 10000);
        },
    },
    msgPotvrdaNePoklapaju: {
        get: function () {
            return utils.waitForElementPresence(by.xpath("/html/body/app-root/app-promena-lozinke/div/form/fieldset/div[2]/div[2]/div"), 10000);
        },
    },
   
   

});

// Export klase
module.exports = PredsednikPromenaLozinkePage;
