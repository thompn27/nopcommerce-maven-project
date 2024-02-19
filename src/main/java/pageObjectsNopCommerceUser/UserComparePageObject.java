package pageObjectsNopCommerceUser;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIsNopCommerceUser.UserComparePageUI;

public class UserComparePageObject extends BasePage {
    WebDriver driver;
    public UserComparePageObject(WebDriver driver){
        this.driver = driver;
    }

    public boolean isProductCompareDisplayedByName(String productName) {
        waitForElementVisible(driver, UserComparePageUI.PRODUCT_NAME_IN_COMPARE_TABLE, productName);
        return isDisplayElement(driver, UserComparePageUI.PRODUCT_NAME_IN_COMPARE_TABLE, productName);
    }

    public void clickOnClearListProductsCompareButton() {
        waitForElementClickable(driver, UserComparePageUI.CLEAR_LIST_COMPARE_BUTTON);
        clickToElement(driver, UserComparePageUI.CLEAR_LIST_COMPARE_BUTTON);
    }

    public boolean isClearProductsCompareSuccessMessageDisplayed() {
        waitForElementVisible(driver, UserComparePageUI.CLEAR_COMPARE_SUCCESS_MESSAGE);
        return isDisplayElement(driver, UserComparePageUI.CLEAR_COMPARE_SUCCESS_MESSAGE);
    }

    public boolean isProductCompareUndisplayedByName(String productName) {
        sleepInSecond(2);
        return isElementUnDisplayed(driver, UserComparePageUI.PRODUCT_NAME_IN_COMPARE_TABLE, productName);
    }
}
