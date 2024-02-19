package pageObjectsNopCommerceUser;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIsNopCommerceUser.UserRecentProductViewPageUI;

public class UserRecentProductViewPageObject extends BasePage {
    WebDriver driver;

    public UserRecentProductViewPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public int getProductNumberonRecentViewPage() {
        waitForElementVisible(driver, UserRecentProductViewPageUI.PRODUCT_NUMBERS_IN_RECENT_PAGE);
        return getElementSize(driver, UserRecentProductViewPageUI.PRODUCT_NUMBERS_IN_RECENT_PAGE);

    }

    public boolean isProductOnRecentDisplayedByName(String productName) {
        waitForElementVisible(driver, UserRecentProductViewPageUI.PRODUCT_NAME_IN_RECENT_PAGE, productName);
        return isDisplayElement(driver, UserRecentProductViewPageUI.PRODUCT_NAME_IN_RECENT_PAGE, productName);
    }
}
