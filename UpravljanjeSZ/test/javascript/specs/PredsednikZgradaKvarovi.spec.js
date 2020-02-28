var PocetnaPredsednikPocetnaPage = require('../pages/predsednikPage/PredsednikPocetnaPage.js');
var LoginPage = require('../pages/global/login.page.js');
var PredsednikZgradaObavestenjaPage = require('../pages/predsednikPage/PredsednikZgradaObavestenjaPage.js');
var PredsednikZgradaKvaroviPage = require('../pages/predsednikPage/PredsednikZgradaKvaroviPage.js');
describe('Predsednik Zgrada Kvarovi page tests:', function () {
    var loginPage;
    var pocetnaP;
    var pzoPage;
    var kvaroviP;
    browser.ignoreSynchronization = true;

    beforeAll(function () {
        // idemo na stranicu koju testiramo
        browser.navigate().to("http://localhost:8080");
        //instanciram potrebne stranice
        
        loginPage = new LoginPage();
        pocetnaP = new PocetnaPredsednikPocetnaPage();
        pzoPage =  new PredsednikZgradaObavestenjaPage();
        kvaroviP = new PredsednikZgradaKvaroviPage();
    });
    it('should successfully log in as "predsednik skupstine" and rediredirect on  zgrade kvarovi', function () {
        //u ovom testu treba uspesno da se ulogujem kao predsednik i rediretujem na  zgrade kvarovi stranicu
        loginPage.login('predSkup@gmail.com', 'Bar5slova');
        //proveri da li sam na pravoj stranici preko email-a ulogovanog korisnika i preko url-a
        expect(pocetnaP.emailUlogovaniKorisnik.getText()).toContain('predSkup@gmail.com');
        expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/pocetna');
        pocetnaP.linkStranicaZgrada.click();
        //proveravam da li sam ispravno redirektovana
        expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/zgrada/1/obavestenja');
        expect(pzoPage.textMsg).toEqual('Zgrada');
        pzoPage.tabKvarovi.click();
        //proveravam da li sam ispravno redirektovana
        expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/zgrada/1/kvarovi');
       
    });
    it('should successfully select value in Prikazi', function () {
        // proveraavam selekt prikazi
        // selektujem zeljeni prikaz
        var option = kvaroviP.prikaz = '50';
        //proveravam da li je selektovana opcija jednaka ocekivanoj
        expect(option).toEqual('50');
    });
    it('btnDodaj should be displayed and enabled', function () {
        //dugme dodaj treba biti omoguceno i prisutno
        expect(kvaroviP.checkKvarovi.isEnabled()).toBe(true);
        expect(kvaroviP.checkKvarovi.isPresent()).toBe(true);
    });
    it('check box should be not checked', function () {
        //proveravam cekboks treba biti neselektovan
        expect(kvaroviP.checkKvarovi.isSelected()).toBe(false);
    });
    it('kvar should be deleted', function () {
        //kvar treba biti uspesno izbrisan
        expect(kvaroviP.checkKvarovi.isSelected()).toBe(false);
        kvaroviP.btnbrisi.click();
        expect(pzoPage.msgAlert.getText()).toEqual('Uspesno izbrisan kvar');
    });



});

