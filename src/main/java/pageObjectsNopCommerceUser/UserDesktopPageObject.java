package pageObjectsNopCommerceUser;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIsNopCommerceUser.UserDesktopPageUI;

public class UserDesktopPageObject extends BasePage {
    private WebDriver driver;

    public UserDesktopPageObject(WebDriver driver) {
        this.driver = driver;
    }


    public void clickToAddToCompareButtonByProductName(String productName) {
        waitForElementClickable(driver, UserDesktopPageUI.ADD_TO_COMPARE_BUTTON, productName);
        clickToElement(driver, UserDesktopPageUI.ADD_TO_COMPARE_BUTTON, productName);
    }

    public boolean isProductAddToCompareSuccessMessageDisplayedByName() {
        waitForElementVisible(driver, UserDesktopPageUI.ADD_TO_COMPARE_SUCCESS_MESSAGE);
        return isDisplayElement(driver, UserDesktopPageUI.ADD_TO_COMPARE_SUCCESS_MESSAGE);
    }
}
