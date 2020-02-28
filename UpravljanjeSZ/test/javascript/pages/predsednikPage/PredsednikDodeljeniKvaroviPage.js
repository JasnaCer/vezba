//konstruktor stranice
var PredsednikDodeljeniKvaroviPage = function () { }
var utils = require('../utils.js');
// Opis polja i metoda
PredsednikDodeljeniKvaroviPage.prototype = Object.create({}, {

        // dobavljanje registracija dugmeta
        btnRegistracija: {
            get: function() {
                return utils.waitForElementPresence(by.xpath('/html/body/app-root/app-stanari/div/div/div/div/ul/li[1]/button/b'), 10000);
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
        
        //metoda za pretragu 
        pretraga: {
            value: function(imePrezEmail) {
                this.imePrezEmail = imePrezEmail;
                this.btnPretraga.click();
            }
        },
        //ako nema stanara u tabeli ispisuje se poruka Nijedan stanar sa trazenim kriterijumom nije prondajen!
        msgNemaStanara: {
            value: function(ime) {
                return utils.waitForElementPresence(by.xpath('html/body/app-root/app-stanari/div/app-izlistaj-stanare/div/div[1]/h2'),10000);
            }
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
    
});

// Export klase
module.exports = PredsednikDodeljeniKvaroviPage;
