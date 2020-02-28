var LoginPage = require('../page_objects/login.page.js');
var MenuPage = require('../page_objects/menu.page.js');
var StudentsListPage = require('../page_objects/students-list.page.js');
var StudentCreationPage = require('../page_objects/student-creation.page.js');
var ModalDeletePage = require('../page_objects/modal-delete.page.js');

describe('Adding a student', function() {
  var loginPage;
  var menuPage;
  var studentsListPage;
  var studentCreationPage;
  var modalDeletePage;
  
  beforeAll(function() {
    loginPage = new LoginPage();
    menuPage = new MenuPage();
    studentsListPage = new StudentsListPage();
    studentCreationPage = new StudentCreationPage();
    modalDeletePage = new ModalDeletePage();
    
    browser.get('/');
    expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/#/');
    
    // Izvrsava login pre pocetka testova vezanih za dodavanje studenta
    menuPage.accountMenu.click();
    menuPage.signIn.click();
    loginPage.login('admin', 'admin');
  });
  
  it('should add two students.', function() {
    
    menuPage.entities.click();
    expect(menuPage.studentsLink.isDisplayed()).toBe(true);
    menuPage.studentsLink.click();
    
    // Sacekati da se predje na stranicu
    browser.wait(function() {
      return browser.getCurrentUrl().then(function(url) {
        return url === 'http://localhost:8080/#/studentis';
      });
    }, 5000, 'Could not navigate to /studentis');
    
    expect(studentsListPage.studentsTable.isDisplayed()).toBe(true);
    // Proveravamo koliko redova ima u tabeli (bez header-a)
    expect(studentsListPage.tableRows.count()).toEqual(0);
    
    var createBtn = studentsListPage.createBtn;
    expect(createBtn.isDisplayed()).toBe(true);
    createBtn.click();
    
    // Potvrda da je modalni dijalog prikazan
    expect(studentCreationPage.modalDialog.isDisplayed()).toBe(true);
    expect(studentCreationPage.modalDialogTitle).toEqual('Create or edit a Studenti');
    
    expect(studentCreationPage.index.isDisplayed()).toBe(true);
		expect(studentCreationPage.ime.isDisplayed()).toBe(true);
		expect(studentCreationPage.prezime.isDisplayed()).toBe(true);
		expect(studentCreationPage.grad.isDisplayed()).toBe(true);
		expect(studentCreationPage.cancelBtn.isDisplayed()).toBe(true);
		expect(studentCreationPage.saveBtn.isDisplayed()).toBe(true);
    
    studentCreationPage.index = 'RA 43-2011';
		studentCreationPage.ime = 'Miroslav';
		studentCreationPage.prezime = 'Kondic';
		studentCreationPage.grad = 'Novi Sad';
		studentCreationPage.saveBtn.click();
    
    // Sacekati da se modal skloni sa stranice
    browser.wait(function() {
      return studentCreationPage.modalDialog.isPresent().then(function(isPresent) {
        return !isPresent;
      });
    }, 5000, 'Modal dialog never disappeared');
    
    // Proveriti da li je student prisutan
    var studentRow = studentsListPage.getStudentRowByIndex('RA 43-2011');
    expect(studentRow.index).toEqual('RA 43-2011');
    expect(studentRow.ime).toEqual('Miroslav');
    expect(studentRow.prezime).toEqual('Kondic');
    
    // Dodati drugog studenta
    createBtn = studentsListPage.createBtn;
    expect(createBtn.isDisplayed()).toBe(true);
    createBtn.click();
    
    studentCreationPage.createStudent('RA 45-2011', 'Novi', 'Korisnik', 'Novi Sad');
    studentRow = studentsListPage.getStudentRowByIndex('RA 45-2011');
    expect(studentRow.index).toEqual('RA 45-2011');
    expect(studentRow.ime).toEqual('Novi');
    expect(studentRow.prezime).toEqual('Korisnik');
    
    expect(studentsListPage.tableRows.count()).toEqual(2);
  });
  
  it('should delete all students.', function() {
    var studentRow = studentsListPage.getStudentRowByIndex('RA 43-2011');
    studentRow.deleteBtn.click();
    var modalDelete = modalDeletePage.modal;
    expect(modalDelete.isDisplayed()).toBe(true);
    modalDeletePage.confirmDelete();
    
    // Sacekati da se modal skloni sa stranice
    browser.wait(function() {
      return modalDelete.isPresent().then(function(isPresent) {
        return !isPresent;
      });
    }, 5000, 'Modal dialog never disappeared');
    
    expect(studentsListPage.tableRows.count()).toEqual(1);
    
    studentRow = studentsListPage.getStudentRowByIndex('RA 45-2011');
    studentRow.deleteBtn.click();
    modalDelete = modalDeletePage.modal;
    expect(modalDelete.isDisplayed()).toBe(true);
    modalDeletePage.confirmDelete();
    
    // Sacekati da se modal skloni sa stranice
    browser.wait(function() {
      return modalDelete.isPresent().then(function(isPresent) {
        return !isPresent;
      });
    }, 5000, 'Modal dialog never disappeared');
    
    expect(studentsListPage.tableRows.count()).toEqual(0);
  });
});
