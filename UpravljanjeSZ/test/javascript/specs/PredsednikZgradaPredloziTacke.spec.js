var PocetnaPredsednikPocetnaPage = require('../pages/predsednikPage/PredsednikPocetnaPage.js');
var LoginPage = require('../pages/global/login.page.js');
var PredsednikZgradaObavestenjaPage = require('../pages/predsednikPage/PredsednikZgradaObavestenjaPage.js');
var PredsednikZgradaPredloziTackePage = require('../pages/predsednikPage/PredsednikZgradaPredloziTackePage.js');
describe('Predsednik Zgrada Predlozi Tacke page tests:', function () {
    var loginPage;
    var pocetnaP;
    var pzoPage;
    var predloziTackeP;
    browser.ignoreSynchronization = true;

    beforeAll(function () {
        // idemo na stranicu koju testiramo
        browser.navigate().to("http://localhost:8080");
        //instanciram potrebne stranice
        
        loginPage = new LoginPage();
        pocetnaP = new PocetnaPredsednikPocetnaPage();
        pzoPage =  new PredsednikZgradaObavestenjaPage();
        predloziTackeP = new PredsednikZgradaPredloziTackePage();
    });
    it('should successfully log in as "predsednik skupstine" and rediredirect on  zgrade predlozi tacke', function () {
        //u ovom testu treba uspesno da se ulogujem kao predsednik i rediretujem na  zgrade predlozi stranicu
        loginPage.login('predSkup@gmail.com', 'Bar5slova');
        //proveri da li sam na pravoj stranici preko email-a ulogovanog korisnika i preko url-a
        expect(pocetnaP.emailUlogovaniKorisnik.getText()).toContain('predSkup@gmail.com');
        expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/pocetna');
        pocetnaP.linkStranicaZgrada.click();
        //proveravam da li sam ispravno redirektovana
        expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/zgrada/1/obavestenja');
        expect(pzoPage.textMsg).toEqual('Zgrada');
        pzoPage.tabPredloziTacke.click();
        //proveravam da li sam ispravno redirektovana
        expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/zgrada/1/tacke');
       
    });
    it('should successfully select value in Prikazi', function () {
        // proveraavam selekt prikazi
        // selektujem zeljeni prikaz
        var option = predloziTackeP.prikaz = '50';
        //proveravam da li je selektovana opcija jednaka ocekivanoj
        expect(option).toEqual('50');
    });
    it('should successfully add new tacku dnevnog reda', function () {
        //u ovom testu treba uspesno da dodam novu tacku 
        predloziTackeP.btnDodajPredlogTacku.click();
        expect(predloziTackeP.formaDodajPredlogTacku.isPresent()).toBe(true);
        predloziTackeP.textpolje = 'Dodajem novu tacku dnevnog reda';
        predloziTackeP.btnPotvrdiPredlogTacku.click();
        expect(pzoPage.msgAlert.getText()).toEqual('Predlog tacke dnevnog reda uspesno dodat');
        //vracam se na tacke
        pzoPage.tabPredloziTacke.click();
    });
    it('should try add new tacku without text input ', function () {
        //u ovom testu treba da probam da dodam novu tacku bez unetog teksta
        predloziTackeP.btnDodajPredlogTacku.click();
        expect(predloziTackeP.formaDodajPredlogTacku.isPresent()).toBe(true);
        predloziTackeP.textpolje = '';
        expect(predloziTackeP.btnPotvrdiPredlogTacku.isEnabled()).toBe(false);
        //vracam se na tacke
        pzoPage.tabPredloziTacke.click();
    });
    it('should successfully changed tacku', function () {
        //u ovom testu treba uspesno da izmenim tacku 
        pzoPage.tabPredloziTacke.click();
        predloziTackeP.btnIzmeniTacku.click();
        predloziTackeP.textKojiMenjam = 'menjam tacku';
        predloziTackeP.btnPotvrdi2.click();
        expect(pzoPage.msgAlert.isPresent()).toBe(true);
        expect(pzoPage.msgAlert.getText()).toEqual('Tacka uspesno izmenjena');
    });
    it('should successfully add tacku in skupstina', function () {
        //u ovom testu treba uspesno da dodam tacku  u skupstinu
        predloziTackeP.selektSkupstinu = "22:55 05.12.2020 - 00:00 19.12.2020"
        predloziTackeP.btnDodajPredlogTackeUSkupstinu.click();
        expect(pzoPage.msgAlert.isPresent()).toBe(true);
        expect(pzoPage.msgAlert.getText()).toEqual('Tacka uspesno dodata u skupstinu');
        //vracam se na tacke
        pzoPage.tabPredloziTacke.click();
    });
    it('should try add new tacku without skupstina', function () {
        //u ovom testu treba da probam da dodam novu tacku bez izabrane skupstine
        expect(predloziTackeP.btnDodajPredlogTackeUSkupstinu.isEnabled()).toBe(false);
        //vracam se na tacke
        pzoPage.tabPredloziTacke.click();
    });
    it('should successfully delete tacku', function () {
        //u ovom testu treba uspesno da izbrisem tacku 
        predloziTackeP.btnDodajPredlogTacku.click();
		predloziTackeP.textpolje = ' Dodajem novu tacku dnevnog reda';
        predloziTackeP.btnPotvrdiPredlogTacku.click();
		pzoPage.tabPredloziTacke.click();
        predloziTackeP.btnBrisi.click();
        expect(pzoPage.msgAlert.isPresent()).toBe(true);
        expect(pzoPage.msgAlert.getText()).toEqual('Tacka uspesno izbrisana');
    });
});