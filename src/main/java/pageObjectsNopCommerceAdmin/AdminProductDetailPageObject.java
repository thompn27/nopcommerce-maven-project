package pageObjectsNopCommerceAdmin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIsNopCommerceAdmin.AdminProductDetailPageUI;

public class AdminProductDetailPageObject extends BasePage {
    WebDriver driver;
    public AdminProductDetailPageObject(WebDriver driver){
        this.driver = driver;
    }

    public boolean isProductDetailPageDisplayed() {
        waitForElementVisible(driver, AdminProductDetailPageUI.PRODUCT_DETAIL_NAME_TEXT);
        return isDisplayElement(driver, AdminProductDetailPageUI.PRODUCT_DETAIL_NAME_TEXT);
    }


}
