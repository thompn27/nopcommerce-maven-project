package pageObjectsNopCommerceUser;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIsNopCommerceUser.UserShoppingCartPageUI;

import java.text.ParseException;

public class UserShoppingCartPageObject extends BasePage {
    WebDriver driver;
    public UserShoppingCartPageObject(WebDriver driver){
        this.driver = driver;
    }

    public boolean isProductDisplayedByName(String productName) {
        waitForElementVisible(driver, UserShoppingCartPageUI.PRODUCT_NAME_IN_TABLE_IN_CART_PAGE, productName);
        return isDisplayElement(driver, UserShoppingCartPageUI.PRODUCT_NAME_IN_TABLE_IN_CART_PAGE, productName);
    }

    public boolean isShoppingCartTitlePageDisplayed() {
        waitForElementVisible(driver, UserShoppingCartPageUI.SHOPPING_CART_PAGE_TITLE);
        return isDisplayElement(driver, UserShoppingCartPageUI.SHOPPING_CART_PAGE_TITLE);
    }

    public UserProductDetailPageObject clickOnEditLinkByProductName(String productName) {
        waitForElementClickable(driver, UserShoppingCartPageUI.EDIT_LINK_FROM_PRODUCT_NAME, productName);
        clickToElement(driver, UserShoppingCartPageUI.EDIT_LINK_FROM_PRODUCT_NAME, productName);
        return PageGeneratorManager.getUserProductDetailPageObject(driver);
    }

    public void clickOnRemoveFromCartByProductName(String productName) {
        waitForElementClickable(driver, UserShoppingCartPageUI.REMOVE_PRODUCT_BUTTON, productName);
        clickToElement(driver, UserShoppingCartPageUI.REMOVE_PRODUCT_BUTTON, productName);
    }

    public boolean isRemoveProductSuccessMessageDisplayed() {
        waitForElementVisible(driver, UserShoppingCartPageUI.REMOVE_PRODUCT_SUCCESS_MESSAGE);
        return isDisplayElement(driver, UserShoppingCartPageUI.REMOVE_PRODUCT_SUCCESS_MESSAGE);
    }

    public boolean isProductUndisplayOnCartPage(String productName) {
        return isElementUnDisplayed(driver, UserShoppingCartPageUI.PRODUCT_IN_CART_BY_NAME, productName);
    }

    public void inputToSearchBox(String searchKeyword) {
        waitForElementVisible(driver, UserShoppingCartPageUI.SEARCH_TEXTBOX);
        sendKeyToElement(driver, UserShoppingCartPageUI.SEARCH_TEXTBOX, searchKeyword);
    }

    public UserSearchPageObject clickOnSearchButtonNop() {
        waitForElementClickable(driver, UserShoppingCartPageUI.SEARCH_BUTTON);
        clickToElement(driver, UserShoppingCartPageUI.SEARCH_BUTTON);
        return PageGeneratorManager.getUserSearchPageObject(driver);
    }

    public void inputToQtyBoxByProductName(String productName, String quantitiesNumbers) {
        waitForElementVisible(driver, UserShoppingCartPageUI.QTY_TEXTBOX, productName);
        sendKeyToElement(driver, UserShoppingCartPageUI.QTY_TEXTBOX, quantitiesNumbers, productName);
    }

    public void clickOnUpdateShoppingCartButton() {
        waitForElementClickable(driver, UserShoppingCartPageUI.UPDATE_SHOPPING_CART_BUTTON);
        clickToElement(driver, UserShoppingCartPageUI.UPDATE_SHOPPING_CART_BUTTON);
    }

    public float getTotalPriceByProductName(String productName) throws ParseException {
        float totalPriceByFloat;
        waitForElementVisible(driver, UserShoppingCartPageUI.PRICE_AFTER_UPDATING_QTY, productName);
        String totalPriceByString = getTextElement(driver, UserShoppingCartPageUI.PRICE_AFTER_UPDATING_QTY, productName).substring(1);
        return totalPriceByFloat = Float.parseFloat(totalPriceByString.replace(",", "")); //2,500.00
    }
    public float getPriceUnitByProductName(String productName) throws ParseException {
        float productPriceUnitByFloat;
        waitForElementVisible(driver, UserShoppingCartPageUI.PRICE_BEFORE_UPDATING_QTY, productName);
        String productPriceUnitByString = getTextElement(driver, UserShoppingCartPageUI.PRICE_BEFORE_UPDATING_QTY, productName).substring(1);
        return productPriceUnitByFloat = Float.parseFloat(productPriceUnitByString); //500.00
    }

    public void clickOnTermAndConditionCheckbox() {
        waitForElementClickable(driver, UserShoppingCartPageUI.TERM_CONDITION_CHECKBOX);
        checkToCheckboxOrRadio(driver, UserShoppingCartPageUI.TERM_CONDITION_CHECKBOX);
    }

    public UserCheckOutPageObject clickOnCheckOutButton() {
        waitForElementClickable(driver, UserShoppingCartPageUI.CHECKOUT_BUTTON);
        clickToElement(driver, UserShoppingCartPageUI.CHECKOUT_BUTTON);
        return PageGeneratorManager.getUserCheckOutPageObject(driver);
    }
}
