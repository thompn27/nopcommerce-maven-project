package pageObjectsNopCommerceUser;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIsNopCommerceUser.UserProductReviewPageUI;

public class UserProductReviewPageObject extends BasePage {
    WebDriver driver;

    public UserProductReviewPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToReviewTitleTextbox(String reviewTitle) {
        waitForElementVisible(driver, UserProductReviewPageUI.REVIEW_TITLE_TEXTBOX);
        sendKeyToElement(driver, UserProductReviewPageUI.REVIEW_TITLE_TEXTBOX, reviewTitle);
    }

    public void inputToReviewTextbox(String reviewText) {
        waitForElementVisible(driver, UserProductReviewPageUI.REVIEW_TEXT_TEXTBOX);
        sendKeyToElement(driver, UserProductReviewPageUI.REVIEW_TEXT_TEXTBOX, reviewText);
    }

    public void selectRating(String radioLabel) {
        waitForElementClickable(driver, UserProductReviewPageUI.RARING_RADIO, radioLabel);
        checkToCheckboxOrRadio(driver, UserProductReviewPageUI.RARING_RADIO, radioLabel);
    }

    public void clickOnSubmitReviewButton() {
        waitForElementClickable(driver, UserProductReviewPageUI.SUBMIT_REVIEW_BUTTON);
        clickToElement(driver, UserProductReviewPageUI.SUBMIT_REVIEW_BUTTON);
    }

    public UserCustomerInforPageObject clickOnMyAccountLink() {
        waitForElementClickable(driver, UserProductReviewPageUI.MY_ACCOUNT_HEADER_LINK);
        clickToElement(driver, UserProductReviewPageUI.MY_ACCOUNT_HEADER_LINK);
        return PageGeneratorManager.getCustomerInforPageObject(driver);
    }
}
