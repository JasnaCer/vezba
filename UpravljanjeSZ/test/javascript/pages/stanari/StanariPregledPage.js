//konstruktor stranice
var StanariPregledPage = function () { }
var utils = require('../utils.js');
// Opis polja i metoda
StanariPregledPage.prototype = Object.create({}, {

        // dobavljanje registracija dugmeta
        btnRegistracija: {
            get: function() {
                return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-stanari/div/div/div/div/ul/li[1]/button/b'), 10000);
            },
        },
        // dobavljanje pregled dugmeta
        btnPregled: {
            get: function() {
                return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-stanari/div/div/div/div/ul/li[2]/button/b'),10000);
            },
        },
        //SELEKT
        prikaz: {
            get: function() {
                return utils.waitForElementPresence(by.id('prikaz'), 10000).getText();
            },
            set: function(value) {
                this.prikaz.element(by.cssContainingText('option', value)).click();
            }
        },
        // PRETRAGA
        // dobavljanje i setovanje polja ime, prezime, email
        imePrezEmail: {
            get: function() {
                return utils.waitForElementPresence(by.id('filter'), 10000);
            },
            set: function(value) {
                return this.imePrezEmail.clear().sendKeys(value);
            }
        },
        
        // dobavljanje pretraga dugmeta
        btnPretraga: {
            get: function() {
                return utils.waitForElementPresence(by.xpath("/html/body/app-root/app-stanari/div/app-izlistaj-stanare/div/div[1]/div/button"),10000);
            },
        },
        //metoda za pretragu 
        pretraga: {
            value: function(imePrezEmail) {
                this.imePrezEmail = imePrezEmail;
                this.btnPretraga.click();
            }
        },
        //ako nema stanara u tabeli ispisuje se poruka Nijedan stanar sa trazenim kriterijumom nije prondajen!
        msgNemaStanara: {
            get: function() {
                return utils.waitForElementPresence(by.xpath("html/body/app-root/app-stanari/div/app-izlistaj-stanare/div/div[1]/h2"),10000).getText();
            },
        },
      
        
        // TABELA
    // cela tabela stanara
    stanariTable: {
        get: function() {
            return utils.waitForElementPresence(by.xpath("//table[@class='table table-hover ng-star-inserted']"), 10000);
        }
    },
    // red  stanara izvucen iz tabele po imenu
    getStanaraIzTabele: {
        value: function(ime) {
            return utils.waitForElementPresence(by.xpath('//*[contains(text(),"' + ime + '")]/../..'),10000);
        }
    },
    // red za koji ocekujem da nije prisutan u tabeli
    getRedNijeUTabeli: {
        value: function(stanar) {
            return utils.waitForElementInvisibility(by.xpath('//*[contains(text(),"' + stanar + '")]/../..'),10000);
        }
    },
    //stanar link u tabeli
    linkStanar: {
        get: function() {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-stanari/div/app-izlistaj-stanare/div/div[1]/table/tbody/tr[1]/td/a'),10000);
        },
    },
    //stanar janko jankovic za stanarPage test 
    linkStanarJJ: {
        get: function() {
            return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-stanari/div/app-izlistaj-stanare/div/div[1]/table/tbody/tr[3]/td/a'),10000);
        },
    },
});

// Export klase
module.exports = StanariPregledPage;