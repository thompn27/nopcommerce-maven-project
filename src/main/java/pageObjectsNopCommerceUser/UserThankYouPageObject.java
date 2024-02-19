package pageObjectsNopCommerceUser;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIsNopCommerceUser.UserThankYouPageUI;

public class UserThankYouPageObject extends BasePage {
    WebDriver driver;
    public UserThankYouPageObject (WebDriver driver){
        this.driver = driver;
    }

    public boolean isOrderSuccessMessageDisplayed() {
        waitForElementVisible(driver, UserThankYouPageUI.ORDER_SUCCESS_MESSAGE);
        return isDisplayElement(driver, UserThankYouPageUI.ORDER_SUCCESS_MESSAGE);
    }
}
