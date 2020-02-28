var LoginPage = require('../pages/global/login.page.js');
var HomePage = require('../pages/global/home.page.js');
var ZgradaDodavanjePage = require('../pages/zgrade/ZgradaDodavanjePage.js');
var ZgradaPregledPage = require('../pages/zgrade/ZgradaPregledPage.js');
var ZgradaPage = require('../pages/zgrade/ZgradaPage.js');
var StanPage = require('../pages/zgrade/StanPage.js');

describe('Stan page tests:', function () {
    var loginPage;
    var homePage;
    var zgradaDP;
    var zgradaPP;
    var zgradaP;
    var stanP;
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
        stanP = new StanPage();
    });

    it('should successfully log in as "admin" and rediredirect on page stanovi', function () {
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
        expect(zgradaP.textMsg).toEqual("Zgrada");
        zgradaP.btnVlasnikStanar.click();
        expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/stan/1');
    });
    it('should be same expected and actual stan title and address', function () {
        // proveravam da li je prikazani naslov stranice i adresa  isti kao i ocekivani
        expect(stanP.textMsg).toContain('Stan');
        expect(stanP.adresa).toContain('Boska Buhe 42, Novi Sad');
    });
    //proveravam selekt prikazi
    it('should successfully select value in Prikazi', function () {
        // proveraavam selekt prikazi
        // selektujem zeljeni prikaz
        var option = stanP.prikaz = '50';
        //proveravam da li je selektovana opcija jednaka ocekivanoj
        expect(option).toEqual('50');
    });

    //filter
    //ime koje postoji
    it('should successfully find person in korisnici - name', function () {
        stanP.filter = "Gospodin Predsednik";
        stanP.btnFiltriraj.click();
        //proverim da li sam dobila  ocekivan rezultat
        expect(stanP.getKorisnikaIzTabele('Gospodin Predsednik').getText()).toContain("Gospodin Predsednik");
    });
    //email koji postoji
    it('should successfully find person in korisnici - email', function () {
        stanP.filter = "predSkup@gmail.com";
        stanP.btnFiltriraj.click();
        //proverim da li sam dobila  ocekivan rezultat
        expect(stanP.getKorisnikaIzTabele('predSkup@gmail.com').getText()).toContain("predSkup@gmail.com");
    });
    //ime koje ne postoji
    it('should not find person in korisnici if name dont exist', function () {
        stanP.filter = "milan";
        stanP.btnFiltriraj.click();
        //kada red ne postoji u tabeli
        expect(stanP.getRedNijeUTabeli('milan'));
        //kada nema razultata pretrage tabela ne sadrzi redove
        // ovde ocekujem da u tabeli nema redova jer pretraga ne daje rezulatat
        expect(element.all(by.css("#korisnici > tbody > tr")).count()).toBeLessThan(1);
        browser.driver.navigate().refresh();
    });
    it('should be delete vlasnik and stanar for next tests', function () {
        //brisem vlasnika i stanare zbog sledecih testova
        stanP.btnUkloniVlasnikaStranica.click();
        stanP.btnUkloniStanaraIzTabele.click();
        stanP.btnUkloniStanaraIzTabele.click();
        browser.driver.navigate().refresh();
    });



    //USLOV ZA IZVODJENJE TESTA JE DA SU TABELA STANARI I POLJE VLASNIK PRAZNI
    //Brisem postojece pre izvrsavanja testa

    //NEMA STANARA NI VLASNIKA 
    it('tests text in fild when there are not Stanari and Vlasnik ', function () {
        // proveravam da li je ocekivani ispis kada nisu postavljeni stanari i vlasnik
        expect(stanP.vlasnik).toContain('Nema vlasnika');
        expect(stanP.stanari).toContain('Nema useljenih stanara!');
    });

    //DODAJEM STANARA I VLASNIKA IZ KORISNIKA
    it('should be successfully add vlasnika in vlasnik', function () {
        //dodajem vlasnika  i proveravam da li je dodat
        expect(stanP.btnPostaviZaVlasnikaK.isEnabled()).toBe(true);
        stanP.btnPostaviZaVlasnikaK.click();
        expect(stanP.msgAlert.getText()).toEqual('Uspesno ste postavili vlasnika!');
    });
    it('should be successfully add stanar in table stanari', function () {
        //dodajem stanara u tabelu stanari i proveravam da li je dodat
        expect(stanP.btnDodajUStanareK.isEnabled()).toBe(true);
        stanP.btnDodajUStanareK.click();
        expect(stanP.msgAlert.getText()).toEqual('Uspesno ste dodali stanara!');
    });
    //POKUSAVAM DA DODAM STANARA KOJI JE VEC U TABELI STANARI
    it('should be disable button btnDodajUStanareK', function () {
        //dodajem stanara u tabelu stanari i proveravam da li je dodat
        expect(stanP.btnDodajUStanareK.isEnabled()).toBe(false);
    });
    
    // //BRISEM STANARA I VLASNIKA 
    it('should be delete vlasnik', function () {
        //brisem vlasnika i proveravam da li je izbrisan
        expect(stanP.btnUkloniVlasnikaStranica.isEnabled()).toBe(true);
        stanP.btnUkloniVlasnikaStranica.click();
        expect(stanP.msgAlert.getText()).toEqual('Uspesno ste uklonili vlasnika!');
        expect(stanP.vlasnik.getText()).toContain('Nema vlasnika');
    });
    it('should be delete stanar', function () {
        //brisem stanara i proveravam da li je izbrisan
        expect(stanP.btnUkloniStanaraIzTabele.isEnabled()).toBe(true);
        stanP.btnUkloniStanaraIzTabele.click();
        expect(stanP.msgAlert.getText()).toEqual('Uspesno ste uklonili stanara!');
        expect(stanP.stanari.getText()).toContain('Nema useljenih stanara!');
        //zbog narednog testa refres jer prikaze alert od ovog
        browser.driver.navigate().refresh() ;
    });

   
    // //IZ TABELE STANARI DODAJEM PREDSEDNIKA I VLASNIKA - uslov da postoji stanar u tabeli stanari, zato ih prvo dodajem
    it('should be successfully add vlasnik', function () {
        expect(stanP.btnDodajUStanareK.isEnabled()).toBe(true);
        stanP.btnDodajUStanareK.click();
        //dodajem vlasnika i proveravam da li je dodat
        expect(stanP.btnPostaviZaVlasnika.isPresent()).toBe(true);
        stanP.btnPostaviZaVlasnika.click();
        expect(stanP.msgAlert.isPresent()).toBe(true);
        expect(stanP.msgAlert.getText()).toEqual('Uspesno ste postavili vlasnika!');
    });
    //dodajem predsednika
      it('should be successfully add predsednik', function () {
        expect(stanP.btnPostaviZaPredsednika.isEnabled()).toBe(true);
        //dodajem predsednika i proveravam da li je dodat
        stanP.btnPostaviZaPredsednika.click();
        expect(stanP.msgAlert.isPresent()).toBe(true);
        expect(stanP.msgAlert.getText()).toEqual('Uspesno ste postavili predsednika zgrade!');
    });
});
