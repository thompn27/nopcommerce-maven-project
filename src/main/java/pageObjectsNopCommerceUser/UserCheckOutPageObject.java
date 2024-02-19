package pageObjectsNopCommerceUser;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIsNopCommerceUser.UserCheckOutPageUI;

public class UserCheckOutPageObject extends BasePage {
    WebDriver driver;
    public UserCheckOutPageObject(WebDriver driver){
        this.driver = driver;
    }
    public void inputToCountryTextBox(String country){
        waitForElementVisible(driver, UserCheckOutPageUI.COUNTRY_TEXT_BOX);
        selectItemInDropdownByDefault(driver, UserCheckOutPageUI.COUNTRY_TEXT_BOX, country);
    }
    public void inputToCityTextBox(String cityName){
        waitForElementVisible(driver, UserCheckOutPageUI.CITY_TEXT_BOX);
        sendKeyToElement(driver, UserCheckOutPageUI.CITY_TEXT_BOX, cityName);
    }
    public void inputToAddress1TextBox(String address1){
        waitForElementVisible(driver, UserCheckOutPageUI.ADDRESS1_TEXT_BOX);
        sendKeyToElement(driver, UserCheckOutPageUI.ADDRESS1_TEXT_BOX, address1);
    }
    public void inputToZipCodeTextBox(String zipCode){
        waitForElementVisible(driver, UserCheckOutPageUI.ZIP_CODE_TEXT_BOX);
        sendKeyToElement(driver, UserCheckOutPageUI.ZIP_CODE_TEXT_BOX, zipCode);
    }
    public void inputToPhoneNumberTextBox(String phoneNumber){
        waitForElementVisible(driver, UserCheckOutPageUI.PHONE_NUMBER_TEXT_BOX);
        sendKeyToElement(driver, UserCheckOutPageUI.PHONE_NUMBER_TEXT_BOX, phoneNumber);
    }

    public void fillBillingAddress(String country, String cityName, String address1, String zipCode, String phoneNumber) {
        inputToCountryTextBox(country);
        inputToCityTextBox(cityName);
        inputToAddress1TextBox(address1);
        inputToZipCodeTextBox(zipCode);
        inputToPhoneNumberTextBox(phoneNumber);
    }

    public void clickOnContinueButtonBySection(String sectionName) {
        waitForElementClickable(driver, UserCheckOutPageUI.CONTINUE_BUTTON_BY_SECTION_NAME, sectionName);
        clickToElement(driver, UserCheckOutPageUI.CONTINUE_BUTTON_BY_SECTION_NAME, sectionName);
    }

    public void clickOnShippingMethodByName(String shippingMethodName) {
        waitForElementClickable(driver, UserCheckOutPageUI.SHIPPING_METHOD_RADIO_BY_METHOD_NAME, shippingMethodName);
        clickToElement(driver, UserCheckOutPageUI.SHIPPING_METHOD_RADIO_BY_METHOD_NAME, shippingMethodName);
    }

    public void clickOnPaymentMethodByName(String paymentMethodName) {
        waitForElementClickable(driver, UserCheckOutPageUI.PAYMENT_METHOD_RADIO_BY_METHOD_NAME, paymentMethodName);
        clickToElement(driver, UserCheckOutPageUI.PAYMENT_METHOD_RADIO_BY_METHOD_NAME, paymentMethodName);
    }

    public String isAddressDisplayed() {
        waitForElementVisible(driver, UserCheckOutPageUI.PAYMENT_INFORMATION_MESSAGE);
        return getTextElement(driver, UserCheckOutPageUI.PAYMENT_INFORMATION_MESSAGE);
    }

    public String getFullname() {
        waitForElementVisible(driver, UserCheckOutPageUI.FULL_NAME_TEXT);
        return getTextElement(driver, UserCheckOutPageUI.FULL_NAME_TEXT);
    }

    public String getEmail() {
        waitForElementVisible(driver, UserCheckOutPageUI.EMAIL_ADDRESS_TEXT);
        return getTextElement(driver, UserCheckOutPageUI.EMAIL_ADDRESS_TEXT);
    }

    public String getPhone() {
        waitForElementVisible(driver, UserCheckOutPageUI.PHONE_NUMBER_TEXT);
        return getTextElement(driver, UserCheckOutPageUI.PHONE_NUMBER_TEXT);
    }

    public String getAddress1() {
        waitForElementVisible(driver, UserCheckOutPageUI.ADDRESS1_TEXT);
        return getTextElement(driver, UserCheckOutPageUI.ADDRESS1_TEXT);
    }

    public String getCity() {
        waitForElementVisible(driver, UserCheckOutPageUI.CITY_NAME_TEXT);
        return getTextElement(driver, UserCheckOutPageUI.CITY_NAME_TEXT);
    }

    public String getCountry() {
        waitForElementVisible(driver, UserCheckOutPageUI.COUNTRY_NAME_TEXT);
        return getTextElement(driver, UserCheckOutPageUI.COUNTRY_NAME_TEXT);
    }

    public String getPaymentMethod() {
        waitForElementVisible(driver, UserCheckOutPageUI.PAYMENT_METHOD_NAME_TEXT);
        return getTextElement(driver, UserCheckOutPageUI.PAYMENT_METHOD_NAME_TEXT);
    }

    public String getShippingMethod() {
        waitForElementVisible(driver, UserCheckOutPageUI.SHIPPING_METHOD_NAME_TEXT);
        return getTextElement(driver, UserCheckOutPageUI.SHIPPING_METHOD_NAME_TEXT);
    }

    public boolean isProductNameDisplayedByName(String productName) {
        waitForElementVisible(driver, UserCheckOutPageUI.PRODUCT_NAME_IN_TABLE, productName);
        return isDisplayElement(driver, UserCheckOutPageUI.PRODUCT_NAME_IN_TABLE, productName);
    }

    public String getTotalprice() {
        waitForElementVisible(driver, UserCheckOutPageUI.TOTAL_PRICE_TEXT);
        return getTextElement(driver, UserCheckOutPageUI.TOTAL_PRICE_TEXT);
    }

    public String getTotalPriceInTableByProductName(String productName) {
        waitForElementVisible(driver, UserCheckOutPageUI.TOTAL_PRICE_IN_TABLE_TEXT, productName);
        return getTextElement(driver, UserCheckOutPageUI.TOTAL_PRICE_IN_TABLE_TEXT, productName);
    }

    public String getProductQuantitiesByProductName(String productName) {
        waitForElementVisible(driver, UserCheckOutPageUI.QTY_TEXT, productName);
        return getTextElement(driver, UserCheckOutPageUI.QTY_TEXT, productName);
    }

    public UserThankYouPageObject clickOnConfirmOrderButton() {
        waitForElementVisible(driver, UserCheckOutPageUI.CONFIRM_BUTTON);
        clickToElement(driver, UserCheckOutPageUI.CONFIRM_BUTTON);
        return PageGeneratorManager.getUserThankYouPageObject(driver);
    }
}
