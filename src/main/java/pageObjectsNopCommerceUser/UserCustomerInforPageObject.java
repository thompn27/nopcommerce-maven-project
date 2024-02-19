package pageObjectsNopCommerceUser;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIsNopCommerceUser.UserCustomerInfoPageUI;

public class UserCustomerInforPageObject extends BasePage {
    private final WebDriver driver;

    public UserCustomerInforPageObject(WebDriver driver){
        this.driver = driver;
    }

    public boolean isDisplayTitlePage() {
        waitForElementVisible(driver, UserCustomerInfoPageUI.CUSTOMER_INFO_TITLE);
        return isDisplayElement(driver, UserCustomerInfoPageUI.CUSTOMER_INFO_TITLE);
    }

    public void checkToGenderByLabel(String gender) {
        waitForElementClickable(driver, UserCustomerInfoPageUI.GENDER_RADIO_BUTTON, gender);
        checkToCheckboxOrRadio(driver, UserCustomerInfoPageUI.GENDER_RADIO_BUTTON, gender);
    }

    public void inputNewFirstNameToFirstNameTextbox(String newFirstName) {
        waitForElementVisible(driver, UserCustomerInfoPageUI.FIRST_NAME_CUSTOMER_INFO_TEXTBOX);
        sendKeyToElement(driver, UserCustomerInfoPageUI.FIRST_NAME_CUSTOMER_INFO_TEXTBOX, newFirstName);
    }

    public void inputNewLastNameToLasstNameTextbox(String newLastName) {
        waitForElementVisible(driver, UserCustomerInfoPageUI.LAST_NAME_CUSTOMER_INFO_TEXTBOX);
        sendKeyToElement(driver, UserCustomerInfoPageUI.LAST_NAME_CUSTOMER_INFO_TEXTBOX, newLastName);
    }
    public void selectByDropdown(String selectingValue, String... dropdownLabel){
        waitForElementClickable(driver, UserCustomerInfoPageUI.DROPDOWN_LABEL, dropdownLabel);
        selectItemInDropdownByDefault(driver, UserCustomerInfoPageUI.DROPDOWN_LABEL, selectingValue, dropdownLabel);
    }
    public void selectDateOfBirthByDropDown(String dateValue, String monthValue, String yearValue, String... dropdownLabel) {
        selectByDropdown(dateValue, dropdownLabel);
        selectByDropdown(monthValue, dropdownLabel);
        selectByDropdown(yearValue, dropdownLabel);
    }

    public void inputToComapanyNameTextbox(String companyName) {
        waitForElementVisible(driver, UserCustomerInfoPageUI.COMPANY_NAME_TEXTBOX);
        sendKeyToElement(driver, UserCustomerInfoPageUI.COMPANY_NAME_TEXTBOX, companyName);
    }

    public void clickToSaveButton() {
        waitForElementClickable(driver, UserCustomerInfoPageUI.SAVE_CUSTOMER_INFO_BUTTON);
        clickToElement(driver, UserCustomerInfoPageUI.SAVE_CUSTOMER_INFO_BUTTON);
    }

    public boolean isSelectGenderByLabel(String gender) {
        waitForElementVisible(driver, UserCustomerInfoPageUI.GENDER_RADIO_BUTTON, gender);
        return isSelectedElement(driver, UserCustomerInfoPageUI.GENDER_RADIO_BUTTON, gender);
    }

    public String getUpdatedFirstNameByAttributeValue(String attributevalue) {
        waitForElementVisible(driver, UserCustomerInfoPageUI.FIRST_NAME_CUSTOMER_INFO_TEXTBOX);
        return getAttributeValue(driver, UserCustomerInfoPageUI.FIRST_NAME_CUSTOMER_INFO_TEXTBOX, attributevalue);
    }

    public String getUpdatedLastNameByAttributeValue(String attributevalue) {
        waitForElementVisible(driver, UserCustomerInfoPageUI.LAST_NAME_CUSTOMER_INFO_TEXTBOX);
        return getAttributeValue(driver, UserCustomerInfoPageUI.LAST_NAME_CUSTOMER_INFO_TEXTBOX, attributevalue);
    }

//    public boolean isDisplaySelectedDate(){
//        waitForElementVisible(driver, UserCustomerInfoPageUI.DATE_DROPDOWN);
//        return isSelectedElement(driver, UserCustomerInfoPageUI.DATE_DROPDOWN);
//    }
//    public boolean isDisplaySelectedMonth(){
//        waitForElementVisible(driver, UserCustomerInfoPageUI.MONTH_DROPDOWN);
//        return isSelectedElement(driver, UserCustomerInfoPageUI.MONTH_DROPDOWN);
//    }
//    public boolean isDisplaySelectedYear(){
//        waitForElementVisible(driver, UserCustomerInfoPageUI.YEAR_DROPDOWN);
//        return isSelectedElement(driver, UserCustomerInfoPageUI.YEAR_DROPDOWN);
//    }
//    public boolean isSelectedByDateOfBirth(String selectedValue, String... dropdownLabel) {
//        waitForElementVisible(driver, UserCustomerInfoPageUI.DROPDOWN_LABEL, dropdownLabel);
//        return isSelectedElement(driver, UserCustomerInfoPageUI.DROPDOWN_LABEL, dropdownLabel);
//
//
//    }

    public String getCompanyNameByAttributeValue(String attributeValue) {
        waitForElementVisible(driver, UserCustomerInfoPageUI.COMPANY_NAME_TEXTBOX);
        return getAttributeValue(driver, UserCustomerInfoPageUI.COMPANY_NAME_TEXTBOX, attributeValue);
    }

    public boolean isDisplayCustomerInfoUpdatedMessage() {
        waitForElementVisible(driver, UserCustomerInfoPageUI.CUSTOMER_INFO_UPDATED_SUCCESS_MESSAGE);
        return isDisplayElement(driver, UserCustomerInfoPageUI.CUSTOMER_INFO_UPDATED_SUCCESS_MESSAGE);
    }

    public void selectDateByDropdown(String dateVale) {
        waitForElementClickable(driver, UserCustomerInfoPageUI.DATE_DROPDOWN);
        selectItemInDropdownByDefault(driver, UserCustomerInfoPageUI.DATE_DROPDOWN, dateVale);
    }

    public void selectMonthByDropdown(String monthValue) {
        waitForElementClickable(driver, UserCustomerInfoPageUI.MONTH_DROPDOWN);
        selectItemInDropdownByDefault(driver, UserCustomerInfoPageUI.MONTH_DROPDOWN, monthValue);
    }

    public void selectYearByDropdown(String yearValue) {
        waitForElementClickable(driver, UserCustomerInfoPageUI.YEAR_DROPDOWN);
        selectItemInDropdownByDefault(driver, UserCustomerInfoPageUI.YEAR_DROPDOWN, yearValue);
    }

    public String getSelectedDate() {
        waitForElementVisible(driver, UserCustomerInfoPageUI.DATE_DROPDOWN);
        return getSelectedItemInDropdownByDefault(driver, UserCustomerInfoPageUI.DATE_DROPDOWN);
    }

    public String getSelectedMonth() {
        waitForElementVisible(driver, UserCustomerInfoPageUI.MONTH_DROPDOWN);
        return getSelectedItemInDropdownByDefault(driver, UserCustomerInfoPageUI.MONTH_DROPDOWN);
    }

    public String getSelectedyear() {
        waitForElementVisible(driver, UserCustomerInfoPageUI.YEAR_DROPDOWN);
        return getSelectedItemInDropdownByDefault(driver, UserCustomerInfoPageUI.YEAR_DROPDOWN);
    }
}
