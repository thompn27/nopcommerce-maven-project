package pageObjectsNopCommerceUser;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIsNopCommerceUser.UserMyProductReviewPageUI;

public class UserMyProductReviewsPageObject extends BasePage {
    private final WebDriver driver;

    public UserMyProductReviewsPageObject(WebDriver driver){
        this.driver = driver;
    }

    public String getNewProductReviewTitle() {
        waitForElementVisible(driver, UserMyProductReviewPageUI.REVIEW_TITLE);
        return getTextElement(driver, UserMyProductReviewPageUI.REVIEW_TITLE);
    }

    public String getNewProductReviewText() {
        waitForElementVisible(driver, UserMyProductReviewPageUI.REVIEW_TEXT);
        return getTextElement(driver, UserMyProductReviewPageUI.REVIEW_TEXT);
    }
}
