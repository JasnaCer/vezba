var PocetnaPredsednikPocetnaPage = require('../pages/predsednikPage/PredsednikPocetnaPage.js');
var LoginPage = require('../pages/global/login.page.js');
var PredsednikZgradaObavestenjaPage = require('../pages/predsednikPage/PredsednikZgradaObavestenjaPage.js');
var PredsednikPromenaLozinkePage = require('../pages/predsednikPage/PredsednikPromenaLozinkePage.js');
describe('Predsednik Zgrada Promena lozinke page tests:', function () {
    var loginPage;
    var pocetnaP;
    var pzoPage;
    var promenaLozinke;
    browser.ignoreSynchronization = true;

    beforeAll(function () {
        // idemo na stranicu koju testiramo
        browser.navigate().to("http://localhost:8080");
        //instanciram potrebne stranice
        loginPage = new LoginPage();
        pocetnaP = new PocetnaPredsednikPocetnaPage();
        pzoPage = new PredsednikZgradaObavestenjaPage();
        promenaLozinke = new PredsednikPromenaLozinkePage();
    });
    it('should successfully log in as "predsednik skupstine" and rediredirect on promena lozinke', function () {
        //u ovom testu treba uspesno da se ulogujem kao predsednik i rediretujem na  zgrade predlozi stranicu
        loginPage.login('predSkup@gmail.com', 'Bar5slova');
        pocetnaP.promenaLozinke.click();
        expect(promenaLozinke.formaLozinka.isPresent()).toBe(true);
    });

    it('should should not be successfully changed password - less than 6 characters', function () {
        //neuspesna promena lozinka kraca od 6 karaktera
        promenaLozinke.promeniPass("Bar5slova", "Bar5s", "Bar5s");
        expect(promenaLozinke.msgNovaObaveznoNeispravno.getText()).toEqual("Neispravna lozinka! Pogledajte napomenu.");
        expect(promenaLozinke.btnPromeniLozinku.isEnabled()).toBe(false);
        //refres stranice zbog sledeceg testa
        browser.driver.navigate().refresh();
    });
    it('should should not be successfully changed password - without capital letters', function () {
        //neuspesna promena lozinka bez velikih slova
        promenaLozinke.promeniPass("Bar5slova", "bar5slova", "bar5slova");
        expect(promenaLozinke.msgNovaObaveznoNeispravno.getText()).toEqual("Neispravna lozinka! Pogledajte napomenu.");
        expect(promenaLozinke.btnPromeniLozinku.isEnabled()).toBe(false);
        //refres stranice zbog sledeceg testa
        browser.driver.navigate().refresh();
    });
    it('should should not be successfully changed password - without small letters', function () {
        //neuspesna promena lozinka bez malih slova
        promenaLozinke.promeniPass("Bar5slova", "BAR6SLOCA", "BAR6SLOCA");
        expect(promenaLozinke.msgNovaObaveznoNeispravno.getText()).toEqual("Neispravna lozinka! Pogledajte napomenu.");
        expect(promenaLozinke.btnPromeniLozinku.isEnabled()).toBe(false);
        //refres stranice zbog sledeceg testa
        browser.driver.navigate().refresh();
    });
    it('should should not be successfully changed password - without numbers', function () {
        //neuspesna promena lozinka bez cifri
        promenaLozinke.promeniPass("Bar5slova", "BARSLOCA", "BARSLOCA");
        expect(promenaLozinke.msgNovaObaveznoNeispravno.getText()).toEqual("Neispravna lozinka! Pogledajte napomenu.");
        expect(promenaLozinke.btnPromeniLozinku.isEnabled()).toBe(false);
        //refres stranice zbog sledeceg testa
        browser.driver.navigate().refresh();
    });
    it('should should not be successfully changed password - empty fields', function () {
        //neuspesna promena lozinka kad su polja prazna
        promenaLozinke.promeniPass("", "", "");
        expect(promenaLozinke.msgStaraObavezno.getText()).toEqual("Ovo polje je obavezno!");
        expect(promenaLozinke.msgNovaObaveznoNeispravno.getText()).toEqual("Ovo polje je obavezno!");
        expect(promenaLozinke.btnPromeniLozinku.isEnabled()).toBe(false);
        //refres stranice zbog sledeceg testa
        browser.driver.navigate().refresh();
    });
    it('should should not be successfully changed password - are not the same old and new', function () {
        //neuspesna promena lozinka - nisu iste stara i nova
        promenaLozinke.promeniPass("Bar5slova", "Bar6slova", "Bar7slova");
        expect(promenaLozinke.msgPotvrdaNePoklapaju.getText()).toEqual("Lozinke se ne poklapaju!");
    });
    it('should should be successfully changed password ', function () {
        //u ovom testu treba uspesno da promenim lozinku i ulogujem se sa novim podacima
        promenaLozinke.promeniPass("Bar5slova", "Bar6slova", "Bar6slova");
        expect(pzoPage.msgAlert.getText()).toEqual("Lozinka uspesno izmenjena!");
    });
});


