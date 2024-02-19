package pageObjectsNopCommerceUser;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIsNopCommerceUser.UserWishListPageUI;

public class UserWishListPageObject extends BasePage {
    WebDriver driver;
    public UserWishListPageObject(WebDriver driver){
        this.driver = driver;
    }

    public boolean isProductDisplayByProductName(String productName) {
        waitForElementVisible(driver, UserWishListPageUI.PRODUCT_NAME_IN_TABLE, productName);
        return isDisplayElement(driver, UserWishListPageUI.PRODUCT_NAME_IN_TABLE, productName);
    }

    public void clickToCheckBoxByProductName(String productName) {
        waitForElementClickable(driver, UserWishListPageUI.PRODUCT_CHECKBOX_IN_TABLE, productName);
        clickToElement(driver, UserWishListPageUI.PRODUCT_CHECKBOX_IN_TABLE, productName);
    }

    public UserShoppingCartPageObject clickToAddToCartButton() {
        waitForElementClickable(driver, UserWishListPageUI.ADD_TO_CARD_BUTTON);
        clickToElement(driver, UserWishListPageUI.ADD_TO_CARD_BUTTON);
        return PageGeneratorManager.getUserShoppingCartPageObject(driver);
    }

    public boolean isProductFromWishlistRemovedByName(String productName) {
        sleepInSecond(1);
        return isElementUnDisplayed(driver, UserWishListPageUI.PRODUCT_NAME_IN_TABLE, productName);
    }

    public void removeProductFromWishlistByName(String productName) {
        waitForElementClickable(driver, UserWishListPageUI.REMOVE_PRODUCT_ON_WISHLIST_BY_NAME, productName);
        clickToElement(driver, UserWishListPageUI.REMOVE_PRODUCT_ON_WISHLIST_BY_NAME, productName);
    }


}
