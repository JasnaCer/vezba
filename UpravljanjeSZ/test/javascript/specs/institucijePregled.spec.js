var LoginPage = require('../pages/global/login.page.js');
var HomePage = require('../pages/global/home.page.js');
var InstitucijeDodavanjePage = require('../pages/institucije/InstitucijeDodavanjePage.js');
var InstitucijePregledPage = require('../pages/institucije/InstitucijePregledPage.js');
var InstitucijaPage = require('../pages/institucije/InstitucijaPage.js');
describe('Pregled institucije page tests:', function () {
    var loginPage;
    var homePage;
    var institucijeDP;
    var institucijePP;
    var institucijaP;
    browser.ignoreSynchronization = true;

    beforeAll(function () {
        // idemo na stranicu koju testiramo
        browser.navigate().to("http://localhost:8080");
        //instanciram potrebne stranice
        loginPage = new LoginPage();
        homePage = new HomePage();
        institucijePP = new InstitucijePregledPage();
        institucijeDP = new InstitucijeDodavanjePage();
        institucijaP = new InstitucijaPage();
    });

    it('should successfully log in as "admin" and rediredirect on page stanari and redirect on page stanari/pregled', function () {
        //u ovom testu proveravam da li dugme dodavanje redirektuje na stranicu zgrada/dodavanje 
        loginPage.login('', 'Bar5slova');
        // homePage.stanari.click();
        // //proveri da li sam na pravoj stranici
        // expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/stanari');
        // //kliknem na dugme pregled
        // institucijeDP.btnPregled.click();
        // // proveravam da li sam na stranici zgrade/pregled
        // expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/institucije/pregled');
       
    });

    
    // it('should successfully select value in Prikazi', function () {
    //     // proveraavam selekt prikazi
    //     // selektujem zeljeni prikaz
    //     var option = stanariPP.prikaz = '50';
    //     //proveravam da li je selektovana opcija jednaka ocekivanoj
    //     expect(option).toEqual('50');
    // });
    // it('should successfully do a search', function () {
    //     //obavim pretragu sa svim dozvoljenim podacima
    //     stanariPP.pretraga('Gospodin');
    //     //u tabeli treba da se pokazo rezultat pretrage, uzimam taj string i proveramam da li sadrzi ocekivan rezultat
    //     expect(stanariPP.getStanaraIzTabele('Gospodin').getText()).toContain('Gospodin');
    //     stanariPP.pretraga('Predsednik');
    //     expect(stanariPP.getStanaraIzTabele('Predsednik').getText()).toContain('Predsednik');
    //     stanariPP.pretraga('predSkup@gmail.com');
    //     expect(stanariPP.getStanaraIzTabele('predSkup@gmail.com').getText()).toContain('predSkup@gmail.com');
    // });
    // it('should not successfully do a search', function () {
    //     //obavim pretragu sa podacima koji ne postoje u tabeli, trazim neregistrovanog korisnika
    //     stanariPP.pretraga('milojkomile');
    //     //u tabeli treba da se pokazo rezultat pretrage, uzimam taj string i proveramam da li sadrzi ocekivan rezultat
    //     expect(stanariPP.msgNemaStanara).toContain('Nijedan stanar sa trazenim kriterijumom nije prondajen!');
    //      //refres stranice zbog sledeceg testa
    //      browser.driver.navigate().refresh() ;
    // });
    // it('should not successfully do a search with numbers', function () {
    //     stanariPP.pretraga('11111');
    //     //treba se prikazati poruka o neuspesnoj pretrazi
    //     expect(stanariPP.msgNemaStanara).toContain('Nijedan stanar sa trazenim kriterijumom nije prondajen!');
    //     //refres stranice zbog sledeceg testa
    //     browser.driver.navigate().refresh() ;
    // });
    // it('should not successfully do a search with special characters', function () {
    //     stanariPP.pretraga('@@@@@');
    //     //treba se prikazati poruka o neuspesnoj pretrazi
    //     expect(stanariPP.msgNemaStanara).toContain('Nijedan stanar sa trazenim kriterijumom nije prondajen!');
    //     //refres stranice zbog sledeceg testa
    //     browser.driver.navigate().refresh() ;
    // });
   
    // it('should successfully redirect click on link in table row', function () {
    //     //testiram da li klik na link stanar u tabeli redirektuju na odgovarajucu stranicu
    //     //nadjem red
    //     stanariPP.getStanaraIzTabele('Gospodin Predsednik');
    //     //kliknem na link, poredim stvarnu i ocekivanu adresu
    //     stanariPP.linkStanar.click();
    //     expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/stanar/2');
        
    // });
    // it('should successfully redirect click on btt Registracija', function () {
    //     //testiram da li klik na dugme registracija redirektuju na odgovarajucu stranicu
    //     //vracam se na stranicu stanari/pregled
    //     homePage.stanari.click();
    //     stanariRP.btnPregled.click();
    //     //klik na dugme registracija
    //     stanariPP.btnRegistracija.click();
    //     expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/stanari/registracija');
    // });
    // it('should successfully redirect click on btt Pregled', function () {
    //     //testiram da li klik na dugme pregled redirektuju na odgovarajucu stranicu
    //     //vracam se na stranicu stanari/pregled
    //     homePage.stanari.click();
    //     stanariRP.btnPregled.click();
    //     expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/stanari/pregled');
        
    // });

});