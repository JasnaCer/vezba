//konstruktor stranice
var FirmaPage = function () { }
var utils = require('../utils.js');
// Opis polja i metoda
FirmaPage.prototype = Object.create({}, {

    //   // h2 poruka firma za asertaciju da sam na stranici stanar
    //   textMsg: {
    //     get: function () {
    //         return utils.waitForElementPresence(by.xpath("/html/body/app-root/app-stanar/div/div/h2"),10000).getText();
    //     }
    //   },
    //   imePrezime: {
    //     get: function () {
    //         return utils.waitForElementPresence(by.xpath("/html/body/app-root/app-stanar/div/div/h5[1]"),10000).getText();
    //     }                                              
    // },
     
    // //TABELA Stanar zgrada gde stanuje
    // stanGdeStanujeTable: {
    //     get: function() {
    //         return utils.waitForElementPresence(by.id('stan'), 10000);
    //     }
    // },
    // // red mog stanara izvucen iz tabele po imenu
    // getStanGdeStanujeRed: {
    //     value: function(adresa) {
    //         return utils.waitForElementPresence(by.xpath('//*[contains(text(),"' + adresa + '")]/../..'),10000);
    //     }
    // },
    // // red za koji ocekujem da nije prisutan u tabeli
    // getRedNijeUTabeli: {
    //     value: function(adresa) {
    //         return utils.waitForElementInvisibility(by.xpath('//*[contains(text(),"' + adresa + '")]/../..'),10000);
    //     }
    // },
    // //link adresa tabela stanuje
    // linkAdresS: {
    //     get: function() {
    //         return utils.waitForElementPresence(by.xpath('//*[@id="stan"]/tbody/tr/td[1]/a'),10000);
    //     },
    // },
    // //link stan
    // linkStanS: {
    //     get: function() {
    //         return utils.waitForElementPresence(by.xpath('//*[@id="stan"]/tbody/tr/td[2]/a'),10000);
    //     },
    // },
    // //TABELA Stanovi u kojima je vlasnik:
    // stanGdeJeVlasnikTable: {
    //     get: function() {
    //         return utils.waitForElementPresence(by.id('vlasnikStanova'), 10000);
    //     }
    // },
    // getStanGdeJeVlasnikRed: {
    //     value: function(adresa) {
    //         return utils.waitForElementPresence(by.xpath('//*[contains(text(),"' + adresa + '")]/../..'),10000);
    //     }
    // },
    // // red za koji ocekujem da nije prisutan u tabeli
    // getRedNijeUTabeli: {
    //     value: function(adresa) {
    //         return utils.waitForElementInvisibility(by.xpath('//*[contains(text(),"' + adresa + '")]/../..'),10000);
    //     }
    // },
    //  //link adresa tabela vlasnik
    //  linkAdresaV: {
    //     get: function() {
    //         return utils.waitForElementPresence(by.xpath('//*[@id="vlasnikStanova"]/tbody/tr/td[1]/a'),10000);
    //     },
    // },
    // //link stan
    // linkStanV: {
    //     get: function() {
    //         return utils.waitForElementPresence(by.xpath('//*[@id="vlasnikStanova"]/tbody/tr/td[2]/a'),10000);
    //     },
    // },
  
});
// Export klase
module.exports = FirmaPage;
