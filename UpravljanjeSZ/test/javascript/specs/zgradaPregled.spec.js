var LoginPage = require('../pages/global/login.page.js');
var HomePage = require('../pages/global/home.page.js');
var ZgradaDodavanjePage = require('../pages/zgrade/ZgradaDodavanjePage.js');
var ZgradaPregledPage = require('../pages/zgrade/ZgradaPregledPage.js');
describe('Pregled zgrada page tests:', function () {
    var loginPage;
    var homePage;
    var zgradaDP;
    var zgradaPP;
    browser.ignoreSynchronization = true;

    beforeAll(function () {
        // idemo na stranicu koju testiramo
        browser.navigate().to("http://localhost:8080");
        //instanciram potrebne stranice
        loginPage = new LoginPage();
        homePage = new HomePage();
        zgradaDP = new ZgradaDodavanjePage();
        zgradaPP = new ZgradaPregledPage();
    });

    it('should successfully log in as "admin" and rediredirect on page zgrade and redirect on page zgrade/pregled', function () {
        //u ovom testu proveravam da li dugme dodavanje redirektuje na stranicu zgrada/dodavanje 
        loginPage.login('admin@gmail.com', 'Bar5slova');
        homePage.zgrada.click();
        //proveri da li sam na pravoj stranici
        expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/zgrade');
        //kliknem na dugme pregled
        zgradaDP.btnPregled.click();
        // proveravam da li sam na stranici zgrade/pregled
        expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/zgrade/pregled');
    });
    it('should successfully select value in Prikazi', function () {
        // proveraavam selekt prikazi
        // selektujem zeljeni prikaz
        var option = zgradaPP.prikaz = '50';
        //proveravam da li je selektovana opcija jednaka ocekivanoj
        expect(option).toEqual('50');
    });
    it('should successfully do a search', function () {
        //obavim pretragu sa tacnim podacima, oba polja popunjena
        zgradaPP.pretraga('Boska Buhe', 'Novi Sad');
        //u tabeli treba da se pokazo rezultat pretrage, uzimam taj string i proveramam da li sadrzi ocekivan rezultat
        expect(zgradaPP.getZgraduIzTabele('Boska Buhe').getText()).toContain('Boska Buhe');
    });
    it('should not successfully do a search with numbers', function () {
        zgradaPP.pretraga('11111', '111111');
        //treba se prikazati poruka o neuspesnoj pretrazi
        expect(zgradaPP.getMsgPretraga.getText()).toEqual('Nijedna zgrada sa trazenim kriterijumima nije prondajena!');
        //refres stranice zbog sledeceg testa
        browser.driver.navigate().refresh() ;
    });
    it('should not successfully do a search with special characters', function () {
        zgradaPP.pretraga('@@@@@', '$$$$$$');
        //treba se prikazati poruka o neuspesnoj pretrazi
        expect(zgradaPP.getMsgPretraga.getText()).toEqual('Nijedna zgrada sa trazenim kriterijumima nije prondajena!');
        //refres stranice zbog sledeceg testa
        browser.driver.navigate().refresh() ;
    });
    it('should not successfully do a search with nonexistent data', function () {
        zgradaPP.pretraga('Kralj', 'Petar');
        //treba se prikazati poruka o neuspesnoj pretrazi
        expect(zgradaPP.getMsgPretraga.getText()).toEqual('Nijedna zgrada sa trazenim kriterijumima nije prondajena!');
        //refres stranice zbog sledeceg testa
        browser.driver.navigate().refresh() ;
    });
    it('should successfully do a search with fill ulicaBroj fild', function () {
        //testiram pretragu - unosim u polje samo ulica/broj podatke
        zgradaPP.ulicaBroj = '42';
        //u tabeli treba da se pokazo rezultat pretrage, uzimam taj string i proveramam da li sadrzi ocekivan rezultat
        expect(zgradaPP.getZgraduIzTabele('42').getText()).toContain('42');
    });

    it('should successfully do a search with fill grad fild', function () {
        //testiram pretragu - unosim u polje samo ulica/broj podatke
        zgradaPP.ulicaBroj = 'Novi Sad';
        //u tabeli treba da se pokazo rezultat pretrage, uzimam taj string i proveramam da li sadrzi ocekivan rezultat
        expect(zgradaPP.getZgraduIzTabele('Novi Sad').getText()).toContain('Novi Sad');
    });
    it('should successfully redirect click on link in table row', function () {
        //testiram da li link adresa i predsednik zgrade u tabeli da li redirektuju na odgovarajuce stranice
        //nadjem red
        zgradaPP.getZgraduIzTabele('Boska Buhe');
        //kliknem na link, poredim stvarnu i ocekivanu adresu
        zgradaPP.linkAdresa.click();
        expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/zgrada/1/stanovi');
        //vracam se na pregled stranicu
        homePage.zgrada.click();
        zgradaDP.btnPregled.click();
        //kliknem na link predsednik u tabeli i poredim da li sam redirektovana na tacnu stranicu
        zgradaPP.linkPredsednik.click();
        expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/stanar/2');
    });

});