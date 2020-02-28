var LoginPage = require('../pages/global/login.page.js');
var HomePage = require('../pages/global/home.page.js');
var ZgradaDodavanjePage = require('../pages/zgrade/ZgradaDodavanjePage.js');
var ZgradaPregledPage = require('../pages/zgrade/ZgradaPregledPage.js');
var ZgradaPage = require('../pages/zgrade/ZgradaPage.js');

describe('Zgrada page tests:', function () {
    var loginPage;
    var homePage;
    var zgradaDP;
    var zgradaPP;
    var zgradaP;
    browser.ignoreSynchronization = true;

    beforeAll(function () {
        // idemo na stranicu koju testiramo
        browser.navigate().to("http://localhost:8080");
        //instanciram potrebne stranice
        loginPage = new LoginPage();
        homePage = new HomePage();
        zgradaDP = new ZgradaDodavanjePage();
        zgradaPP = new ZgradaPregledPage();
        zgradaP = new ZgradaPage();
    });

    it('should successfully log in as "admin" and rediredirect on page zgrada/1/stanovi', function () {
        //u ovom testu proveravam da li dugme dodavanje redirektuje na stranicu zgrada/dodavanje 
        loginPage.login('admin@gmail.com', 'Bar5slova');
        homePage.zgrada.click();
        //kliknem na dugme pregled
        zgradaDP.btnPregled.click();
        // proveravam da li sam na stranici zgrade/pregled
        expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/zgrade/pregled');
        //kliknem na link, poredim stvarnu i ocekivanu adresu
        zgradaPP.linkAdresa.click();
        expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/zgrada/1/stanovi');
        // proveravam da li sam na stranici preko naslova Zgrada
        expect(zgradaP.textMsg).toEqual("Zgrada")
    });

    it('should be same expected and actual address', function () {
        // proveravam da li je prikazana adresa ista kao i ocekivana
        expect(zgradaP.adresa.getText()).toContain('Boska Buhe 42, Novi Sad');
    });
    it('should be same expected and actual title', function () {
        // proveravam da li je prikazana adresa ista kao i ocekivana
        expect(zgradaP.textMsg.getText()).toEqual('Zgrada');
    });
    it('should be same expected and actual predsednik', function () {
        // proveravam da li je prikazana adresa ista kao i ocekivana
        expect(zgradaP.predsednik).toContain('Gospodin Predsednik');
    });
    it('should be displayed table Vlasnici i stanari', function () {
        // proveravam da li je prikazana tabela vlasnici i stanari
        expect(zgradaP.stanoviTable.isDisplayed()).toBe(true);
    
    });
    it('should successfully select value in Prikazi', function () {
        // proveraavam selekt prikazi
        // selektujem zeljeni prikaz
        var option = zgradaPP.prikaz = '50';
        //proveravam da li je selektovana opcija jednaka ocekivanoj
        expect(option).toEqual('50');
    });
    it('should be redirect on obavestenja page', function () {
        // proveravam da li klik na obavestenja tab redirektuje na stranicu obavestenja
        zgradaP.obavestenjaTab.click();
        expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/zgrada/1/obavestenja');
    });
    it('should be redirect on  Predlozi i tacke page', function () {
        // proveravam da li klik na predlozi i tacke tab redirektuje na stranicu predlozi i tacke
        zgradaP.predloziTab.click();
        expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/zgrada/1/tacke');
    });
    it('should be redirect on sastanci page', function () {
        // proveravam da li klik na sastanci tab redirektuje na stranicu sastanci
        zgradaP.sastanciTab.click();
        expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/zgrada/1/sastanci');
    });
    it('should be redirect on kvarovi page and check box should be not checked', function () {
        // proveravam da li klik na kvarovi tab  redirektuje na stranicu kvarovi
        zgradaP.kvaroviTab.click();
        expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/zgrada/1/kvarovi');
        //proveravam cekboks treba biti neselektovan
        expect(zgradaP.cbZavrseniKvarovi.isSelected()).toBe(false);
        //vracam se na stranicu stanovi
		zgradaP.stanoviTab.click();
    });
    it('should be redirect on Stanar page', function () {
        // proveravam da li klik na link Predsednik redirektuje na stranicu Stanar
        zgradaP.predsednikLink.click();
        expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/stanar/2');
        //vracam se na stranicu zgrada zbog sledeceg testa
        homePage.zgrada.click();
        zgradaDP.btnPregled.click();
        zgradaPP.linkAdresa.click();
    });
    it('should be click on button btnVlasnikStanar redirect on stan page', function () {
        // proveravam da li je dugme prikazano i omoguceno i da li redirektuje na stranicu stan
        expect(zgradaP.btnVlasnikStanar.isDisplayed()).toBe(true);
        expect(zgradaP.btnVlasnikStanar.isEnabled()).toBe(true);
        zgradaP.btnVlasnikStanar.click();
        expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/stan/1');
    });
    

});