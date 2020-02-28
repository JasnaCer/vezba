var Jasmine2HtmlReporter = require('protractor-jasmine2-html-reporter');
var SpecReporter = require('jasmine-spec-reporter');

exports.config = {
    seleniumServerJar: '../../../node_modules/protractor/selenium/selenium-server-standalone-2.47.1.jar',
    chromeDriver: '../../../chromedriver',
    allScriptsTimeout: 60000,

    specs: [
        'specs/login.spec.js'
        // 'specs/home.spec.js',
        // 'specs/logout.spec.js',
        // 'specs/zgradaDodavanje.spec.js',
        //'specs/zgradaPregled.spec.js',
        // 'specs/zgrada.spec.js',
        // 'specs/stan.spec.js'
        // 'specs/stanariRegistracija.spec.js',
        // 'specs/stanariPregled.spec.js',
        // 'specs/stanar.spec.js',
        // 'specs/predsednikPocetna.spec.js',
        // 'specs/PredsednikZgradaObavestenja.spec.js',
        // 'specs/PredsednikZgradaPredloziTacke.spec.js',
        // 'specs/PredsednikZgradaKvarovi.spec.js',
        // 'specs/PredsednikZgradaKvaroviDodaj.spec.js',
        // 'specs/predsednikPromenaLozinke.spec.js',
        //'specs/institucija.spec.js'
         //'specs/institucijeDodavanje.spec.js',
      //'specs/institucijePregled.spec.js',
        //'specs/firma.spec.js'
        // 'specs/firmeDodavanje.spec.js',
        // 'specs/firmePregled.spec.js',


    ],

    capabilities: {
        'browserName': 'chrome',
    },

    directConnect: true,

    //baseUrl: 'http://localhost:8080/',

    framework: 'jasmine2',

    jasmineNodeOpts: {
        showColors: true,
        isVerbose: true,
        defaultTimeoutInterval: 60000,
        print: function () { }
    },

    onPrepare: function () {
        // Postavljamo prozor na fullscreen
        browser.driver.manage().window().maximize();

        // Registrujemo reportere
        jasmine.getEnv().addReporter(new Jasmine2HtmlReporter({
            savePath: "./target/reports/e2e/",
            takeScreenshots: true,
            takeScreenshotsOnlyOnFailures: true,
            fixedScreenshotName: true
        }));
        jasmine.getEnv().addReporter(new SpecReporter({
            displayStacktrace: 'all',
            displaySpecDuration: true,
            displayFailuresSummary: false,
            displayPendingSummary: false,
        }));
    }
};
