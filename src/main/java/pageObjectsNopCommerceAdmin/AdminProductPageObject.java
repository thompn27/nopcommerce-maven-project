package pageObjectsNopCommerceAdmin;

import pageObjectsNopCommerceUser.PageGeneratorManager;
import pageUIsNopCommerceAdmin.AdminProductPageUI;
import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class AdminProductPageObject extends BasePage {
    WebDriver driver;
    public AdminProductPageObject(WebDriver driver){
        this.driver = driver;
    }

    public boolean isProductResultDisplayedByProductName(String productName) {
        waitForElementVisible(driver, AdminProductPageUI.PRODUCT_IN_TABLE_BY_PRODUCT_NAME, productName);
        return isDisplayElement(driver, AdminProductPageUI.PRODUCT_IN_TABLE_BY_PRODUCT_NAME, productName);
    }

    public String getSearchResultItems() {
        waitForElementVisible(driver, AdminProductPageUI.SEARCH_RESULT_ITEMS);
        return getTextElement(driver, AdminProductPageUI.SEARCH_RESULT_ITEMS);
    }

    public void checkToCheckboxByLabelName(String labelName) {
        waitForElementVisible(driver, AdminProductPageUI.CHECK_BOX_BY_LABEL_NAME, labelName);
        checkToCheckboxOrRadio(driver, AdminProductPageUI.CHECK_BOX_BY_LABEL_NAME, labelName);
    }

    public AdminProductDetailPageObject clickOnGoButton() {
        waitForElementClickable(driver, AdminProductPageUI.GO_BUTTON);
        clickToElement(driver, AdminProductPageUI.GO_BUTTON);
        return PageGeneratorManager.getAdminProductDetailPageObject(driver);
    }
}
