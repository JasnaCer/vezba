var EC = protractor.ExpectedConditions;

var utils = {};

utils.waitToBeClickable = function(selector, interval, message) {
    var el = element(selector);
    browser.wait(EC.elementToBeClickable(el), interval, message);
    return element(selector);
};

utils.waitForElementPresence = function(selector, interval, message) {
    var el = element(selector);
    browser.wait(EC.presenceOf(el), interval, message);
    return element(selector);
};

utils.waitForTitle = function(title, interval, message) {
    browser.wait(EC.titleIs(title), interval, message);
}

module.exports = utils;