package pageObjectsNopCommerceUser;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIsNopCommerceUser.UserAddressesPageUI;

public class UserAddressesPageObject extends BasePage {
    private final WebDriver driver;

    public UserAddressesPageObject(WebDriver driver){
        this.driver = driver;
    }

    public void clickOnAddNewButton() {
        waitForElementClickable(driver, UserAddressesPageUI.ADD_NEW_BUTTON);
        clickToElement(driver, UserAddressesPageUI.ADD_NEW_BUTTON);
    }

    public void inputToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, UserAddressesPageUI.FIRST_NAME_TEXTBOX);
        sendKeyToElement(driver, UserAddressesPageUI.FIRST_NAME_TEXTBOX, firstName);
    }

    public void inputToLastNameTextbox(String lastName) {
        waitForElementVisible(driver, UserAddressesPageUI.LAST_NAME_TEXTBOX);
        sendKeyToElement(driver, UserAddressesPageUI.LAST_NAME_TEXTBOX, lastName);
    }

    public void inputToEmailAddressTextbox(String emailAddress) {
        waitForElementVisible(driver, UserAddressesPageUI.EMAIL_ADDRESS_TEXTBOX);
        sendKeyToElement(driver, UserAddressesPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);
    }

    public void selectACountryFromDropdown(String countryName) {
        waitForElementClickable(driver, UserAddressesPageUI.COUNTRY_DROPDOWN);
        selectItemInDropdownByDefault(driver, UserAddressesPageUI.COUNTRY_DROPDOWN, countryName);
    }

    public void inputToCityTextbox(String cityName) {
        waitForElementVisible(driver, UserAddressesPageUI.CITY_TEXTBOX);
        sendKeyToElement(driver, UserAddressesPageUI.CITY_TEXTBOX, cityName);
    }

    public void inputToAddress1Textbox(String address) {
        waitForElementVisible(driver, UserAddressesPageUI.ADDRESS_1_TEXTBOX);
        sendKeyToElement(driver, UserAddressesPageUI.ADDRESS_1_TEXTBOX, address);
    }

    public void inputToZipCodeTextbox(String zipCode) {
        waitForElementVisible(driver, UserAddressesPageUI.ZIP_CODE_TEXTBOX);
        sendKeyToElement(driver, UserAddressesPageUI.ZIP_CODE_TEXTBOX, zipCode);
    }

    public void inputToPhoneNumberTextbox(String phoneNumber) {
        waitForElementVisible(driver, UserAddressesPageUI.PHONE_NUMBER_TEXTBOX);
        sendKeyToElement(driver, UserAddressesPageUI.PHONE_NUMBER_TEXTBOX, phoneNumber);
    }

    public void clickOnSaveButtonOnAddressesPage() {
        waitForElementClickable(driver, UserAddressesPageUI.SAVE_ON_ADDRESSES_BUTTON);
        clickToElement(driver, UserAddressesPageUI.SAVE_ON_ADDRESSES_BUTTON);
    }

    public boolean isAddNewAddressSuccessMessageDisplayed() {
        waitForElementVisible(driver, UserAddressesPageUI.ADD_NEW_ADDRESS_SUCCESS_MESSAGE);
        return isDisplayElement(driver, UserAddressesPageUI.ADD_NEW_ADDRESS_SUCCESS_MESSAGE);
    }
}
