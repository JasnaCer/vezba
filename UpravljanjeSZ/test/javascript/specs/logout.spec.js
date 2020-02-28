var LoginPage = require('../pages/global/login.page.js');
var HomePage = require('../pages/global/home.page.js');

describe('Logout test:', function () {
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
    
    it('logout test, should redirect on logovanje, admin rola', function () {
        //logovanje
        loginPage.login('admin@gmail.com', 'Bar5slova');
        //provera da sam na dobroj stranici
        expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/pocetna');
        //provera da se dugme pojavilo i da je omoguceno
        expect(homePage.btnIzlogujSe.isDisplayed()).toBe(true);
        expect(homePage.btnIzlogujSe.isEnabled()).toBe(true);
        //klik na dugme izloguj se
        homePage.btnIzlogujSe.click();
        expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/logovanje');
    });
    it('logout test, should redirect on logovanje, stanar rola', function () {
        //logovanje
        loginPage.login('marko@gmail.com', 'Bar5slova');
        //provera da sam na dobroj stranici
        expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/pocetna');
        //provera da se dugme pojavilo i da je omoguceno
        expect(homePage.btnIzlogujSe.isDisplayed()).toBe(true);
        expect(homePage.btnIzlogujSe.isEnabled()).toBe(true);
        //klik na dugme izloguj se
        homePage.btnIzlogujSe.click();
        expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/logovanje');
    });
    it('logout test, should redirect on logovanje, predsednik rola', function () {
        //logovanje
        loginPage.login('predSkup@gmail.com', 'Bar5slova');
        //provera da sam na dobroj stranici
        expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/pocetna');
        //provera da se dugme pojavilo i da je omoguceno
        expect(homePage.btnIzlogujSe.isDisplayed()).toBe(true);
        expect(homePage.btnIzlogujSe.isEnabled()).toBe(true);
        //klik na dugme izloguj se
        homePage.btnIzlogujSe.click();
        expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/logovanje');
    });


});