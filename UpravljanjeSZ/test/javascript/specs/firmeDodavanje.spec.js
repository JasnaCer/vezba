var LoginPage = require('../pages/global/login.page.js');
var HomePage = require('../pages/global/home.page.js');
var FirmeDodavanjePage = require('../pages/firme/FirmeDodavanjePage.js');
var FirmePregledPage = require('../pages/firme/FirmePregledPage.js');
var FirmaPage = require('../pages/firme/FirmaPage.js');
describe('Dodavanje firme page tests:', function () {
    var loginPage;
    var homePage;
    var firmeDP;
    var firmePP;
    var firmaP;
    browser.ignoreSynchronization = true;

    beforeAll(function () {
        // idemo na stranicu koju testiramo
        browser.navigate().to("http://localhost:8080");
        //instanciram potrebne stranice
        loginPage = new LoginPage();
        homePage = new HomePage();
        firmePP = new FirmePregledPage();
        firmeDP = new FirmeDodavanjePage();
        firmaP = new FirmaPage();
    });

    it('should successfully log infirma/pregled', function () {
        //u ovom testu proveravam da li dugme dodavanje redirektuje na stranicu zgrada/dodavanje 
        loginPage.login('', 'Bar5slova');
        // homePage.firme.click();
        // //proveri da li sam na pravoj stranici
        // expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/stanari');
        // //kliknem na dugme pregled
        // firmeDP.btnPregled.click();
        // // proveravam da li sam na stranici zgrade/pregled
        // expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/firme/pregled');
        
    });

    // describe('Positive tests', function () {
    //     it('should successfully log in as "admin" and rediredirect on page stanari', function () {
    //         loginPage.login('admin@gmail.com', 'Bar5slova');
    //         homePage.stanari.click();
    //         //proveri da li sam na pravoj stranici
    //         expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/stanari');
    //     });
    //     it('should successfully do registracija stanara ', function () {
    //         //registracija stanara sa ispravnim podacima
    //         stanariRP.registrujStanara('milfe@gmail.com', 'Bar5slova', 'Mile', 'Milic');
    //         expect(stanariRP.msgAlert.getText()).toEqual('Uspesno ste registrovali stanara!');
    //     });
    // });

    // describe('Negative tests', function () {
    //     it('empty filds', function () {
    //         stanariRP.registrujStanara('', '', '', '');
    //         //proveravam poruku koja se pojavi kada je polje prazno
    //         expect(stanariRP.msgEmail.getText()).toEqual('Ovo polje ne sme biti prazno!');
    //         expect(stanariRP.msgLozinka.getText()).toEqual('Ovo polje ne sme biti prazno!');
    //         expect(stanariRP.msgIme.getText()).toEqual('Ovo polje ne sme biti prazno!');
    //         //izlazim iz polja broj stanova da bi se pojavila poruka 
    //         stanariRP.ime = '';
    //         expect(stanariRP.msgPrezime.getText()).toEqual('Ovo polje ne sme biti prazno!');
    //         //dugme dodajte nije omoguceno jer nisu popunjena polja
    //         expect(stanariRP.btnRegistrujte.isEnabled()).toBe(false);
    //     });

    //     it('wrong email', function () {
    //         stanariRP.registrujStanara('milfegmail', 'Bar5slova', 'Mile', 'Milic');
    //         expect(stanariRP.msgEmail.isDisplayed()).toBe(true);
    //         expect(stanariRP.msgEmail.getText()).toEqual("Neispravna email adresa!");
    //         //refres stranice zbog sledeceg testa
    //         browser.driver.navigate().refresh();
    //     });
    //     it('lozinka less than 6 characters', function () {
    //         stanariRP.registrujStanara('milfe@gmail.com', 'bar5s', 'Mile', 'Milic');
    //         expect(stanariRP.msgLozinka.isDisplayed()).toBe(true);
    //         expect(stanariRP.msgLozinka.getText()).toEqual("Neispravna lozinka!");
    //         //refres stranice zbog sledeceg testa
    //         browser.driver.navigate().refresh();
    //     });
    //     it('lozinka without capital letters', function () {
    //         stanariRP.registrujStanara('milfe@gmail.com', 'bar5slova', 'Mile', 'Milic');
    //         expect(stanariRP.msgLozinka.isDisplayed()).toBe(true);
    //         expect(stanariRP.msgLozinka.getText()).toEqual("Neispravna lozinka!");
    //         //refres stranice zbog sledeceg testa
    //         browser.driver.navigate().refresh();
    //     });
    //     it('lozinka without small letters', function () {
    //         stanariRP.registrujStanara('milfe@gmail.com', 'BAR5SLOVA', 'Mile', 'Milic');
    //         expect(stanariRP.msgLozinka.isDisplayed()).toBe(true);
    //         expect(stanariRP.msgLozinka.getText()).toEqual("Neispravna lozinka!");
    //         //refres stranice zbog sledeceg testa
    //         browser.driver.navigate().refresh();
    //     });
    //     it('lozinka without number', function () {
    //         stanariRP.registrujStanara('milfe@gmail.com', 'BARrSLOVA', 'Mile', 'Milic');
    //         expect(stanariRP.msgLozinka.isDisplayed()).toBe(true);
    //         expect(stanariRP.msgLozinka.getText()).toEqual("Neispravna lozinka!");
    //         //refres stranice zbog sledeceg testa
    //         browser.driver.navigate().refresh();
    //     });
    //     it('should display a messages when email already exists', function () {
    //         stanariRP.registrujStanara('milfe@gmail.com', 'Bar5slova', 'Mile', 'Milic');
    //         expect(stanariRP.msgAlert.isDisplayed()).toBe(true);
    //         expect(stanariRP.msgAlert.getText()).toContain("je zauzeta");
    //         //refres stranice zbog sledeceg testa
    //         browser.driver.navigate().refresh();
    //     });
    //     it('resetujte button should clear text filds', function () {
    //         //punim polja
    //         stanariRP.email = 'email';
    //         stanariRP.lozinka = 'lozinka';
    //         stanariRP.ime = 'ime';
    //         stanariRP.prezime = 'prezime';
    //         stanariRP.btnRegistrujte.click();
    //         //proveravam da li su polja prazna posle klika na reset
    //         expect(stanariRP.email.getText()).toEqual('');
    //         expect(stanariRP.lozinka.getText()).toEqual('');
    //         expect(stanariRP.ime.getText()).toEqual('');
    //         expect(stanariRP.prezime.getText()).toEqual('');
    //     });
    //     it('should successfully redirect on page stanari/registracija', function () {
    //         //kliknem na dugme pregled
    //         stanariRP.btnRegistracija.click();
    //         //proverim da li samredirektovana na stranicu pregled
    //         expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/stanari/registracija');
    //     });
    //     it('should successfully redirect on page stanari/pregled', function () {
    //         //kliknem na dugme pregled
    //         stanariRP.btnPregled.click();
    //         //proverim da li samredirektovana na stranicu pregled
    //         expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/stanari/pregled');
    //     });

    // });


});