var PocetnaPredsednikPocetnaPage = require('../pages/predsednikPage/PredsednikPocetnaPage.js');
var LoginPage = require('../pages/global/login.page.js');
var PredsednikZgradaObavestenjaPage = require('../pages/predsednikPage/PredsednikZgradaObavestenjaPage.js');
describe('Predsednik Zgrada Obavestenja page tests:', function () {
    var loginPage;
    var pocetnaP;
    var pzoPage;
    browser.ignoreSynchronization = true;

    beforeAll(function () {
        // idemo na stranicu koju testiramo
        browser.navigate().to("http://localhost:8080");
        //instanciram potrebne stranice
        
        loginPage = new LoginPage();
        pocetnaP = new PocetnaPredsednikPocetnaPage();
        pzoPage =  new PredsednikZgradaObavestenjaPage();
    });
    it('should successfully log in as "predsednik skupstine" and rediredirect on  zgrade obavestenja', function () {
        //u ovom testu treba uspesno da se ulogujem kao predsednik i rediretujem na  zgrade obavestenja stranicu
        loginPage.login('predSkup@gmail.com', 'Bar5slova');
        //proveri da li sam na pravoj stranici preko email-a ulogovanog korisnika i preko url-a
        expect(pocetnaP.emailUlogovaniKorisnik.getText()).toContain('predSkup@gmail.com');
        expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/pocetna');
        pocetnaP.linkStranicaZgrada.click();
        //proveravam da li sam ispravno redirektovana
        expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/zgrada/1/obavestenja');
        expect(pzoPage.textMsg).toEqual('Zgrada');

    });
    it('should successfully select value in Prikazi', function () {
        // proveraavam selekt prikazi
        // selektujem zeljeni prikaz
        var option = pzoPage.prikaz = '50';
        //proveravam da li je selektovana opcija jednaka ocekivanoj
        expect(option).toEqual('50');
    });
    it('should successfully add new obavestenja', function () {
        //u ovom testu treba uspesno da dodam novo obavestenje 
        pzoPage.btnDodajObavestenje.click();
        expect(pzoPage.formaDodajObavestenje.isPresent()).toBe(true);
        pzoPage.textpolje = 'Dodajem novo obavestenje';
        pzoPage.btnPotvrdi.click();
        expect(pzoPage.msgAlert.getText()).toEqual('Obavestenje uspesno dodato!');
        //vracam se na obavestenja
        pzoPage.tabObavestenja.click();
    });
    it('should try add new obavestenja without text input ', function () {
        //u ovom testu treba da probam da dodam novo obavestenje bez unetog teksta
        pzoPage.btnDodajObavestenje.click();
        expect(pzoPage.formaDodajObavestenje.isPresent()).toBe(true);
        pzoPage.textpolje = '';
        expect(pzoPage.btnPotvrdi.isEnabled()).toBe(false);
        //vracam se na obavestenja
        pzoPage.tabObavestenja.click();
    });
    it('should successfully changed obavestenja', function () {
        //u ovom testu treba uspesno da izmenim obavestenje 
        pzoPage.tabObavestenja.click();
        pzoPage.btnIzmeniObavestenje.click();
        pzoPage.textKojiMenjam = 'menjam tekst';
        pzoPage.btnPotvrdi2.click();
        expect(pzoPage.msgAlert.isPresent()).toBe(true);
        expect(pzoPage.msgAlert.getText()).toEqual('Uspesno izmenjeno obavestenje');
    });
    it('should successfully delete obavestenja', function () {
        //u ovom testu treba uspesno da izbrisem obavestenje 
        pzoPage.btnBrisi.click();
        expect(pzoPage.msgAlert.isPresent()).toBe(true);
        expect(pzoPage.msgAlert.getText()).toEqual('Uspesno izbrisano obavestenje');
    });


});