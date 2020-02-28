var LoginPage = require('../pages/global/login.page.js');
var HomePage = require('../pages/global/home.page.js');
var StanariRegistracijaPage = require('../pages/stanari/StanariRegistracijaPage.js');
var StanariPregledPage = require('../pages/stanari/StanariPregledPage.js');
var StanarPage = require('../pages/stanari/StanarPage.js');
describe('Stanar page tests:', function () {
    var loginPage;
    var homePage;
    var stanariRP;
    var stanariPP;
    var stanarP;
    browser.ignoreSynchronization = true;

    beforeAll(function () {
        // idemo na stranicu koju testiramo
        browser.navigate().to("http://localhost:8080");
        //instanciram potrebne stranice
        loginPage = new LoginPage();
        homePage = new HomePage();
        stanariPP = new StanariPregledPage();
        stanariRP = new StanariRegistracijaPage();
        stanarP = new StanarPage();
    });

    it('should successfully log in as "admin" and rediredirect on page stanari and redirect on page stanari/pregled', function () {
        //u ovom testu proveravam da li dugme dodavanje redirektuje na stranicu zgrada/dodavanje 
        loginPage.login('admin@gmail.com', 'Bar5slova');
        homePage.stanari.click();
        //proveri da li sam na pravoj stranici
        expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/stanari');
        //kliknem na dugme pregled
        stanariRP.btnPregled.click();
        // proveravam da li sam na stranici zgrade/pregled
        expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/stanari/pregled');
        //nadjem Janka Jankovica i kliknem na link u tabeli, proverim da li sam na dobroj stranici
        stanariPP.linkStanarJJ.click();
        expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/stanar/4');
    });
    it('should be same expected and actual stanar title and ime i prezime', function () {
        // proveravam da li je prikazani naslov stranice i adresa  isti kao i ocekivani
        expect(stanarP.textMsg).toContain('Stanar');
        expect(stanarP.imePrezime).toContain('Janko Jankovic');
    });
    it('should be present address and number in tabele stan u kome stanuje', function () {
        // proveravam da li je prikazana tabela i u tabeli prikazana ocekivana adresa i broj stana
        expect(stanarP.stanGdeStanujeTable.isPresent()).toBe(true);
        expect(stanarP.getStanGdeStanujeRed('Boska Buhe').getText()).toContain('Boska Buhe');
        expect(stanarP.getStanGdeStanujeRed('Boska Buhe').getText()).toContain('3');
    });
    it('should be present address and number in tabele Stanovi u kojima je vlasnik:', function () {
        // proveravam da li je prikazana tabele i u njoj adresa i broj koji su  ocekivani 
        expect(stanarP.stanGdeJeVlasnikTable.isPresent()).toBe(true);
        expect(stanarP.getStanGdeJeVlasnikRed('Boska Buhe').getText()).toContain('Boska Buhe');
        expect(stanarP.getStanGdeJeVlasnikRed('Boska Buhe').getText()).toContain('3');
    });
    it('should be redirect to the appropriate pages after click on the link in the table', function () {
        // proveravam da li klikom na linkove u tabelama odlazim na dobre stranice
        
        stanarP.linkAdresS.click();
        expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/zgrada/1/stanovi');
        // vratim se na stanar stranicu
        homePage.stanari.click();
        stanariRP.btnPregled.click(); 
        stanariPP.linkStanarJJ.click();
        expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/stanar/4');

        stanarP.linkStanS.click();
        expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/stan/4');
         // vratim se na stanar stranicu       
        homePage.stanari.click();
        stanariRP.btnPregled.click(); 
        stanariPP.linkStanarJJ.click();
        expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/stanar/4');

        stanarP.linkAdresaV.click();
        expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/zgrada/1/stanovi');
         // vratim se na stanar stranicu
        homePage.stanari.click();
        stanariRP.btnPregled.click(); 
        stanariPP.linkStanarJJ.click();
        expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/stanar/4');

        stanarP.linkStanV.click();
        expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/stan/4');
        
    });
});