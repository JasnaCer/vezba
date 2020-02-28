var HomePage = require('../pages/global/home.page.js');
var LoginPage = require('../pages/global/login.page.js');


describe('Home page tests:', function () {
    var loginPage;
    var homePage;
    browser.ignoreSynchronization = true;

    beforeAll(function () {
        // idemo na stranicu koju testiramo
        browser.navigate().to("http://localhost:8080");
        //instanciram potrebne stranice
        loginPage = new LoginPage();
        homePage = new HomePage();
    });
   
    it('elements should be  present', function () {
        //logovanje
        loginPage.login('admin@gmail.com', 'Bar5slova');
        //provera da sam na dobroj stranici
        expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/pocetna');
        //provera da li su elementi prikazani
        expect(homePage.listaMeni.isDisplayed()).toBe(true);
        expect(homePage.btnIzlogujSe.isDisplayed()).toBe(true);
        expect(homePage.pocetna.isDisplayed()).toBe(true);
        expect(homePage.zgrada.isDisplayed()).toBe(true);
        expect(homePage.stanari.isDisplayed()).toBe(true);
        //ove su zakljucane do ispita
        expect(homePage.institucije.isDisplayed()).toBe(true);
        expect(homePage.firme.isDisplayed()).toBe(true);
    });
    it('links should be redirect to the appropriate pages', function () {
        homePage.zgrada.click();
        expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/zgrade');
        homePage.stanari.click();
        expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/stanari');
        homePage.pocetna.click();
        expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/pocetna');
    });

});