package pageObjectsNopCommerceUser;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIsNopCommerceUser.UserSearchPageUI;

public class UserSearchPageObject extends BasePage {
    private final WebDriver driver;

    public UserSearchPageObject(WebDriver driver){
        this.driver = driver;
    }

    public void clickOnSearchButtonNop() {
        waitForElementClickable(driver, UserSearchPageUI.SEARCH_ON_PAGE_BUTTON);
        clickToElement(driver, UserSearchPageUI.SEARCH_ON_PAGE_BUTTON);
    }

    public String getSearchNoResultMessageDisplayed() {
        waitForElementVisible(driver, UserSearchPageUI.SEARCH_RESULT_MESAAGE);
        return getTextElement(driver, UserSearchPageUI.SEARCH_RESULT_MESAAGE);
    }

    public void inputToSearchTextbox(String textSearch) {
        waitForElementVisible(driver, UserSearchPageUI.SEARCH_TEXTBOX);
        sendKeyToElement(driver, UserSearchPageUI.SEARCH_TEXTBOX, textSearch);
    }

    public int getProductNumberResult() {
        waitForElementVisible(driver, UserSearchPageUI.PRODUCT_NUMNER_RESULT);
        return getElementSize(driver, UserSearchPageUI.PRODUCT_NUMNER_RESULT);
    }

    public boolean isProductResultDisplayedByName(String productName) {
        waitForElementVisible(driver, UserSearchPageUI.PRODUCT_RESULT_BY_NAME, productName);
        return isDisplayElement(driver, UserSearchPageUI.PRODUCT_RESULT_BY_NAME, productName);
    }

    public void checkToAdvancedCheckbox() {
        waitForElementClickable(driver, UserSearchPageUI.ADVANCE_CHECKBOX);
        checkToCheckboxOrRadio(driver, UserSearchPageUI.ADVANCE_CHECKBOX);
    }

    public void selectDropdownByLabelName(String labelName, String itemName) {
        waitForElementClickable(driver, UserSearchPageUI.DROPDOWN_BY_LABEL_NAME, labelName);
        selectItemInDropdownByDefault(driver, UserSearchPageUI.DROPDOWN_BY_LABEL_NAME,itemName, labelName);
    }

    public void checkToSubCategoriesCheckbox() {
        waitForElementClickable(driver, UserSearchPageUI.SUB_CATEGORIES_CHECKBOX);
        checkToCheckboxOrRadio(driver, UserSearchPageUI.SUB_CATEGORIES_CHECKBOX);
    }

    public boolean isSearchResultDisplayed(String keySearch) {
        waitForElementVisible(driver, UserSearchPageUI.PRODUCT_NAME_WITH_KEYSEARCH, keySearch);
        return isDisplayElement(driver, UserSearchPageUI.PRODUCT_NAME_WITH_KEYSEARCH, keySearch);
    }

    public void clickOnAddToCartButtonByName(String productName) {
        waitForElementClickable(driver, UserSearchPageUI.ADD_TO_CART_BUTTON, productName);
        clickToElement(driver, UserSearchPageUI.ADD_TO_CART_BUTTON, productName);
    }

    public boolean isAddToCartSuccessMessageDisplayed() {
        waitForElementVisible(driver, UserSearchPageUI.ADD_TO_CART_SUCCESS_MESSAGE);
        return isDisplayElement(driver, UserSearchPageUI.ADD_TO_CART_SUCCESS_MESSAGE);
    }

    public void closeAddToCartSuccessMessage() {
        waitForElementClickable(driver, UserSearchPageUI.CLOSE_SUCCESS_MESSAGE_BUTTON);
        clickToElement(driver, UserSearchPageUI.CLOSE_SUCCESS_MESSAGE_BUTTON);
    }


}
