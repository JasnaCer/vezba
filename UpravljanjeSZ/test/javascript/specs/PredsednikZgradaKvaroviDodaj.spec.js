var PocetnaPredsednikPocetnaPage = require('../pages/predsednikPage/PredsednikPocetnaPage.js');
var LoginPage = require('../pages/global/login.page.js');
var PredsednikZgradaObavestenjaPage = require('../pages/predsednikPage/PredsednikZgradaObavestenjaPage.js');
var PredsednikZgradaKvaroviPage = require('../pages/predsednikPage/PredsednikZgradaKvaroviPage.js');
var PredsednikZgradaKvaroviDodajPage = require('../pages/predsednikPage/PredsednikZgradaKvaroviDodajPage.js');
describe('Predsednik Zgrada Kvarovi Dodaj page tests:', function () {
    var loginPage;
    var pocetnaP;
    var pzoPage;
    var kvaroviP;
    var kvaroviDodajP;
    browser.ignoreSynchronization = true;

    beforeAll(function () {
        // idemo na stranicu koju testiramo
        browser.navigate().to("http://localhost:8080");
        //instanciram potrebne stranice
        
        loginPage = new LoginPage();
        pocetnaP = new PocetnaPredsednikPocetnaPage();
        pzoPage =  new PredsednikZgradaObavestenjaPage();
        kvaroviP = new PredsednikZgradaKvaroviPage();
        kvaroviDodajP =  new PredsednikZgradaKvaroviDodajPage();
    });
    it('should successfully log in as "predsednik skupstine" and rediredirect on  zgrade kvarovi dodaj', function () {
        //u ovom testu treba uspesno da se ulogujem kao predsednik i rediretujem na  zgrade kvarovi dodaj stranicu
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
        kvaroviP.btnDodaj.click();
        expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/zgrada/1/kvar/dodaj');
       
    });
    it('should successfully add new kvar', function () {
        //u ovom testu treba uspesno da dodam novi kvar 
        kvaroviDodajP.lokacijaKvara = 'Novi Sad';
        kvaroviDodajP.opisKvara = 'neki kvar'
        kvaroviDodajP.btnOdgovornoLice.click();
        expect(kvaroviDodajP.formaOdgovornoLice.isDisplayed()).toBe(true);
        expect(kvaroviDodajP.btnPrihvati.isDisplayed()).toBe(true);
        kvaroviDodajP.btnPrihvati.click();
        kvaroviDodajP.btnDodajKvar.click();
        //proveravam da li je uspesno dodat kvar
        expect(pzoPage.msgAlert.getText()).toEqual('Kvar uspesno dodat');
        //vratim se na kvarove
        pzoPage.tabKvarovi.click();
    });
    it('should try add new kvar without lokacija', function () {
        //u ovom testu treba da probam da dodam novi kvar bez lokacije
        kvaroviP.btnDodaj.click();
        kvaroviDodajP.lokacijaKvara = '';
        kvaroviDodajP.opisKvara = 'neki kvar'
        expect(kvaroviDodajP.msgLokacijaPrazna.getText()).toEqual('Ovo polje ne sme biti prazno!');
        //vratim se na kvarove
        pzoPage.tabKvarovi.click();
    });
    it('should try add new kvar without opis', function () {
         //u ovom testu treba da probam da dodam novi kvar bez opisa();
        kvaroviP.btnDodaj.click();
        kvaroviDodajP.lokacijaKvara = 'Novi Sad';
        kvaroviDodajP.opisKvara = ''
        kvaroviDodajP.lokacijaKvara = 'Novi Sad';
        expect(kvaroviDodajP.msgOpisPrazan.getText()).toEqual('Ovo polje ne sme biti prazno!');
        //vratim se na kvarove
        pzoPage.tabKvarovi.click();
    });
    it('should try add new kvar without lokacija and opis', function () {
         //u ovom testu treba da probam da dodam novi kvar bez lokacije i opisa
         kvaroviP.btnDodaj.click();
        kvaroviDodajP.lokacijaKvara = '';
        kvaroviDodajP.opisKvara = ''
        expect(kvaroviDodajP.btnDodajKvar.isEnabled()).toBe(false);
        //vratim se na kvarove
        pzoPage.tabKvarovi.click();
    });
    it('forma odgovorno lice should be successfully displayed', function () {
        //forma za izbor odgovornog lica treba biti prikazana
        //vracam se na posle predhodnog testa na formu za dodavanje odgovornog lica
        pzoPage.tabKvarovi.click();
        kvaroviP.btnDodaj.click();
        kvaroviDodajP.btnOdgovornoLice.click()
        expect(kvaroviDodajP.formaOdgovornoLice.isDisplayed()).toBe(true);
        //proveravam preko titla na formi
        expect(kvaroviDodajP.msgTitleForme.getText()).toEqual('Izbor odgovornog lica');
        expect(kvaroviDodajP.pretraga.isDisplayed()).toBe(true);
        expect(kvaroviDodajP.odgovornoLiceTable.isDisplayed()).toBe(true);
        
    });
    it('should successfully select value in Prikazi', function () {
        // proveraavam selekt prikazi
        // selektujem zeljeni prikaz
        var option = kvaroviDodajP.selektPrikazi = '50';
        //proveravam da li je selektovana opcija jednaka ocekivanoj
        expect(option).toEqual('50');
    });
    it('should successfully find person in table - name', function () {
        kvaroviDodajP.pretraga = "Gospodin Predsednik";
        //proverim da li sam dobila  ocekivan rezultat
        expect(kvaroviDodajP.getOdgovornoLiceIzTabele('Gospodin Predsednik').getText()).toContain("Gospodin Predsednik");
    });
    it('should successfully close forma odgovorno lice', function () {
        //klik na dugme odustani uslesno zatvara formu
        kvaroviDodajP.btnOdustani.click();
        expect(kvaroviDodajP.formaOdgovornoLice.isDisplayed()).toBe(false);
       
    });
});