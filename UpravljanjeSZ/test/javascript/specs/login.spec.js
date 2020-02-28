var LoginPage = require('../pages/global/login.page.js');
var HomePage = require('../pages/global/home.page.js');

describe('Login page tests:', function () {
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

    describe('Positive tests', function () {
        it('should successfully log in as "admin"', function () {
            //proveri da li sam na pravoj stranici
            expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/logovanje');
            loginPage.login('admin@gmail.com', 'Bar5slova');
            expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/pocetna');
            //izlogujem se zbog sledeceg testa
            homePage.btnIzlogujSe.click();
        });
        it('should successfully log in as "predsednik skupstine"', function () {
            //proveri da li sam na pravoj stranici
            expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/logovanje');
            loginPage.login('predSkup@gmail.com', 'Bar5slova');
            expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/pocetna');
            //izlogujem se zbog sledeceg testa
            homePage.btnIzlogujSe.click();
        });
        it('should successfully log in as "stanar"', function () {
            //proveri da li sam na pravoj stranici
            expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/logovanje');
            loginPage.login('marko@gmail.com', 'Bar5slova');
            expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/pocetna');
            //izlogujem se zbog sledeceg testa
            homePage.btnIzlogujSe.click();
        });
    });
     describe('Negative tests', function()  {
        it('wrong email', function(){ 
            loginPage.login('ssasddsaa', 'Bar5slova');
            expect(loginPage.msgEmail.isDisplayed()).toBe(true);
            expect(loginPage.msgEmail.getText()).toEqual("Email nije validnog formata!");
            //refres stranice zbog sledeceg testa
            browser.driver.navigate().refresh() ;
        });
        it('empty email', function(){ 
            loginPage.login('', 'Bar5slova');
            expect(loginPage.msgEmail.isDisplayed()).toBe(true);
            expect(loginPage.msgEmail.getText()).toEqual("Email nije validnog formata!");
            //refres stranice zbog sledeceg testa
            browser.driver.navigate().refresh() ;
        });
        it('wrong  lozinka', function(){
            loginPage.login('admin@gmail.com', 'jghfgsfkj');
            expect(loginPage.msgEmail.isDisplayed()).toBe(true);
            expect(loginPage.msgEmail.getText()).toEqual("Lozinka nije validnog formata (Mora biti bar jedno veliko slovo, veliko malo slovo i broj i minimalne duzine 6)!");
            //refres stranice zbog sledeceg testa
            browser.driver.navigate().refresh() ;
        });
        it('empty lozinka', function(){
            loginPage.login('admin@gmail.com', '');
            expect(loginPage.msgEmail.isDisplayed()).toBe(true);
            expect(loginPage.msgEmail.getText()).toEqual("Lozinka nije validnog formata (Mora biti bar jedno veliko slovo, veliko malo slovo i broj i minimalne duzine 6)!");
            //refres stranice zbog sledeceg testa
            browser.driver.navigate().refresh();
        });
        it('lozinka less than 6 characters', function(){
            loginPage.login('admin@gmail.com', 'admina');
            expect(loginPage.msgEmail.isDisplayed()).toBe(true);
            expect(loginPage.msgEmail.getText()).toEqual("Lozinka nije validnog formata (Mora biti bar jedno veliko slovo, veliko malo slovo i broj i minimalne duzine 6)!");
            //refres stranice zbog sledeceg testa
            browser.driver.navigate().refresh();
        });
        it('lozinka without capital letters', function(){
            loginPage.login('admin@gmail.com', 'bar5slova');
            expect(loginPage.msgEmail.isDisplayed()).toBe(true);
            expect(loginPage.msgEmail.getText()).toEqual("Lozinka nije validnog formata (Mora biti bar jedno veliko slovo, veliko malo slovo i broj i minimalne duzine 6)!");
            //refres stranice zbog sledeceg testa
            browser.driver.navigate().refresh(); 
        });
        it('lozinka without small letters', function(){
            loginPage.login('admin@gmail.com', 'BAR5SLOVA');
            expect(loginPage.msgEmail.isDisplayed()).toBe(true);
            expect(loginPage.msgEmail.getText()).toEqual("Lozinka nije validnog formata (Mora biti bar jedno veliko slovo, veliko malo slovo i broj i minimalne duzine 6)!");
            //refres stranice zbog sledeceg testa
            browser.driver.navigate().refresh(); 
        });
        it('lozinka without number', function(){
            loginPage.login('admin@gmail.com', 'BARrSLOVA');
            expect(loginPage.msgEmail.isDisplayed()).toBe(true);
            expect(loginPage.msgEmail.getText()).toEqual("Lozinka nije validnog formata (Mora biti bar jedno veliko slovo, veliko malo slovo i broj i minimalne duzine 6)!");
            //refres stranice zbog sledeceg testa
            browser.driver.navigate().refresh(); 
        });

    });
    

});
