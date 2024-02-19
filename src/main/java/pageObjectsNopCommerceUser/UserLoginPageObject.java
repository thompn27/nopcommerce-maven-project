package pageObjectsNopCommerceUser;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIsNopCommerceUser.UserLoginPageUI;

public class UserLoginPageObject extends BasePage {
    private WebDriver driver;
    public UserLoginPageObject(WebDriver driver){
        this.driver = driver;
    }

    public UserHomePageObject clickToUserLoginButton() {
        waitForElementVisible(driver, UserLoginPageUI.USER_LOGIN_BUTTON);
        clickToElement(driver, UserLoginPageUI.USER_LOGIN_BUTTON);
        return PageGeneratorManager.getHomePageObject(driver);
    }

    public String getEmailErrorMessage() {
        waitForElementVisible(driver, UserLoginPageUI.USER_EMAIL_ERROR_MESSAGE);
        return getTextElement(driver, UserLoginPageUI.USER_EMAIL_ERROR_MESSAGE);
    }
    public String getSummaryErrorMessage() {
        waitForElementVisible(driver, UserLoginPageUI.USER_SUMMARY_ERROR_MESSAGE);
        return getTextElement(driver, UserLoginPageUI.USER_SUMMARY_ERROR_MESSAGE);
    }

    public void inputToUserEmailTextBox(String userEmailAddress) {
        waitForElementVisible(driver, UserLoginPageUI.USER_EMAIL_TEXT_BOX);
        sendKeyToElement(driver, UserLoginPageUI.USER_EMAIL_TEXT_BOX, userEmailAddress);
    }

    public void inputToUserPasswordTextBox(String userPassword) {
        waitForElementVisible(driver, UserLoginPageUI.USER_PASSWORD_TEXT_BOX);
        sendKeyToElement(driver, UserLoginPageUI.USER_PASSWORD_TEXT_BOX, userPassword);
    }
    public UserHomePageObject loginAsUser(String userEmailAddress, String userPassword){
        inputToUserEmailTextBox(userEmailAddress);
        inputToUserPasswordTextBox(userPassword);
        return clickToUserLoginButton();
    }

}
