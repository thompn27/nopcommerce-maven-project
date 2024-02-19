package pageObjectsNopCommerceAdmin;

import PageUIsNopCommerceAdmin.AdminProductPageUI;
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
}
