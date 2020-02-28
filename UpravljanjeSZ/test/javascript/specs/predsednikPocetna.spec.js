var PocetnaPredsednikPocetnaPage = require('../pages/predsednikPage/PredsednikPocetnaPage.js');
var LoginPage = require('../pages/global/login.page.js');
describe('Predsednik pocetna page tests:', function () {
    var loginPage;
    var pocetnaP;
    browser.ignoreSynchronization = true;

    beforeAll(function () {
        // idemo na stranicu koju testiramo
        browser.navigate().to("http://localhost:8080");
        //instanciram potrebne stranice

        loginPage = new LoginPage();
        pocetnaP = new PocetnaPredsednikPocetnaPage();
    });
    it('should successfully log in as "predsednik skupstine" and rediredirect on pocetna page', function () {
        //u ovom testu treba uspesno da se ulogujem kao predsednik i rediretujem na pocetnu stranicu
        loginPage.login('predSkup@gmail.com', 'Bar5slova');
        //proveri da li sam na pravoj stranici preko email-a ulogovanog korisnika i preko url-a
        expect(pocetnaP.emailUlogovaniKorisnik.getText()).toContain('predSkup@gmail.com');
        expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/pocetna');
    });
    it('should be present address in tabele Zgrada u kojoj zivite', function () {
        // proveravam da li je prikazana tabela i u tabeli prikazana ocekivana lokacija, ulica i broj 
        expect(pocetnaP.zgradaUKojojZiviteTable.isPresent()).toBe(true);
        expect(pocetnaP.getStanGdeStanujeRed('Boska Buhe').getText()).toContain('Novi Sad');
        expect(pocetnaP.getStanGdeStanujeRed('Boska Buhe').getText()).toContain('Boska Buhe');
        expect(pocetnaP.getStanGdeStanujeRed('Boska Buhe').getText()).toContain('42');
    });
    it('should be redirect to the appropriate pages after click on the link in the table', function () {
        // proveravam da li klikom na link u tabeli odlazim na dobru stranicu
        pocetnaP.linkStranicaZgrada.click();
        expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/zgrada/1/obavestenja');
        //vracam se na pocetnu
        pocetnaP.linkPocetna.click();
        expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/pocetna');
    });

    it('should be present address in tabele Zgrade u kojima ste vlasnik stana', function () {
        // proveravam da li je prikazana tabela i u tabeli prikazana ocekivana lokacija, ulica i broj 
        expect(pocetnaP.zgradeGdeJeVlasnikTable.isPresent()).toBe(true);
        //AKO POSTOJI RED U TABELI Zgrade u kojima ste vlasnik stana
        //     expect(pocetnaP.gdeJeVlasnikRed('Boska Buhe').getText()).toContain('Novi Sad');
        //     expect(pocetnaP.gdeJeVlasnikRed('Boska Buhe').getText()).toContain('Boska Buhe');
        //     expect(pocetnaP.gdeJeVlasnikRed('Boska Buhe').getText()).toContain('42');
    });
    // it('should be redirect to the appropriate pages after click on the link in the table', function () {
    //     // proveravam da li klikom na link u tabeli odlazim na dobru stranicu
    //     pocetnaP.linkStranica.click();
    //     expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/zgrada/1/obavestenja');
    // });

});