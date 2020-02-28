var LoginPage = require('../pages/global/login.page.js');
var HomePage = require('../pages/global/home.page.js');
var ZgradaDodavanjePage = require('../pages/zgrade/ZgradaDodavanjePage.js');
var ZgradaPregledPage = require('../pages/zgrade/ZgradaPregledPage.js');

describe('Add zgradu page tests:', function () {
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

    it('should successfully log in as "admin" and rediredirect on page zgrade', function () {

        loginPage.login('admin@gmail.com', 'Bar5slova');
        homePage.zgrada.click();
        //proveri da li sam na pravoj stranici
        expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/zgrade');
    });

    it('should successfully add zgrada', function () {
        //uslov za uspesnost testa je da se test pokrece prvi put i da ne postoji dodata zgrada sa istim podacima
        //dodaj zgradu
        zgradaDP.dodajZgradu('Apatin', 'Niska', '3', '3');
        //proveri da le je dodata 
        expect(zgradaDP.msgDodata.getText()).toEqual('Uspesno ste dodali zgradu!');
    });
    it('should successfully add zgrada in table', function () {
        //provera da li se zgrada vidi u tabeli na stranici pregledi
        zgradaDP.btnPregled.click();
        zgradaPP.prikaz = '50';
        expect(zgradaPP.zgradaTable.isDisplayed()).toBe(true);
        //proveri da li je dodata 
        expect(zgradaPP.getZgraduIzTabele('Apatin').getText()).toContain('Sombor');
        //vrati se na stranicu dodavanje
        zgradaPP.btnDodavanje.click();
    });

    it('should display a messages when fields is empty', function () {
        //polja su prazna
        zgradaDP.dodajZgradu("", "", "", "");
        //proveravam poruku koja se pojavi kada je polje prazno
        expect(zgradaDP.msgMesto.getText()).toEqual('Ovo polje ne sme biti prazno!');
        expect(zgradaDP.msgUlica.getText()).toEqual('Ovo polje ne sme biti prazno!');
        expect(zgradaDP.msgBroj.getText()).toEqual('Ovo polje ne sme biti prazno!');
        //izlazim iz polja broj stanova da bi se pojavila poruka 
        zgradaDP.broj = '';
        expect(zgradaDP.msgBrojStanova.getText()).toEqual('Ovo polje ne sme biti prazno!');
        //dugme dodajte nije omoguceno jer nisu popunjena polja
        expect(zgradaDP.btnDodajte.isEnabled()).toBe(false);
    });
    it('should display a messages when zgrada already exists', function () {
        //polja su prazna
        zgradaDP.dodajZgradu('Novi Sad', 'Boska Buhe', '42', '5');
        //proveravam poruku koja se pojavi kada zgrada postoji
        expect(zgradaDP.msgZgradaVecPostoji.getText()).toEqual('Vec postoji zgrada na toj adresi!');
    });
    it('should clear text filds', function () {
        //punim polja
        zgradaDP.mesto = 'nis';
        zgradaDP.ulica = 'borska';
        zgradaDP.broj = '11';
        zgradaDP.brojStanova = '22';
        zgradaDP.btnResetujte.click();
        //proveravam da li su polja prazna posle klika na reset
        expect(zgradaDP.mesto.getText()).toEqual('');
        expect(zgradaDP.ulica.getText()).toEqual('');
        expect(zgradaDP.broj.getText()).toEqual('');
        expect(zgradaDP.brojStanova.getText()).toEqual('');
    });
    it('should be button btnDodajte enebled and displayed', function () {
        expect(zgradaDP.btnDodavanje.isEnabled()).toBe(true);
        expect(zgradaDP.btnDodavanje.isDisplayed()).toBe(true);
    });
     it('should successfully redirect on page zgrade/dodajte', function () {
        //kliknem na dugme pregled
        zgradaDP.btnDodavanje.click();
        //proverim da li sam redirektovana na stranicu dodavanje
        expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/zgrade/dodavanje');
    });
    it('should be button btnPregled enebled and displayed', function () {
        expect(zgradaDP.btnPregled.isEnabled()).toBe(true);
        expect(zgradaDP.btnPregled.isDisplayed()).toBe(true);
    });
     it('should successfully redirect on page zgrade/pregled', function () {
        //kliknem na dugme pregled
        zgradaDP.btnPregled.click();
        //proverim da li samredirektovana na stranicu pregled
        expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/zgrade/pregled');
    });
});