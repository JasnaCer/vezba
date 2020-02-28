//konstruktor stranice
var HomePage = function () { }
var utils = require('../utils.js');
// Opis polja i metoda
HomePage.prototype = Object.create({}, {

    //MENI
	//link Pocetna u meniju
    pocetna: {
        get: function () {
            return utils.waitForElementPresence(by.linkText('Pocetna'),10000);
        }
    },
    //link Zgrade u meniju
    zgrada: {
        get: function () {
            return utils.waitForElementPresence(by.linkText('Zgrade'),10000);
        }
    },
	
    //link Stanari u meniju
    stanari: {
        get: function () {
            return utils.waitForElementPresence(by.linkText('Stanari'),10000);
        }
    },
	
    //link Institucije u meniju
    institucije: {
        get: function () {
            return utils.waitForElementPresence(by.linkText('Institucije'),10000);
        }
    },
	
    //link Firme u meniju
    firme: {
        get: function () {
            return utils.waitForElementPresence(by.linkText('Firme'),10000);
        }
    },
	
    // email korisnika koji se ispise na pocetnoj stranici nakon uspesnog logovanja
    emailTxt: {
        get: function () {
            return utils.waitForElementPresence(by.xpath("//*[@id=\"navbarColor02\"]/ul[2]/li[1]/label"),10000);
        }
    },
	
	//link dugme izloguj se u meniju
    btnIzlogujSe: {
        get: function () {
            return utils.waitForElementPresence(by.xpath("//*[@class='btn btn-secondary']"),10000);
        }
    },
	
    //STRANICA lista 
    listaMeni: {
        get: function () {
            return utils.waitForElementPresence(by.id('opcije'),10000);
        }
    },
	
});

// Export klase
module.exports = HomePage;