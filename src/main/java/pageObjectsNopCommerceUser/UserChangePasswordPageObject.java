package pageObjectsNopCommerceUser;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIsNopCommerceUser.UserChangePasswordPageUI;

public class UserChangePasswordPageObject extends BasePage {
    private final WebDriver driver;

    public UserChangePasswordPageObject(WebDriver driver){
        this.driver = driver;
    }

    public void inputToOldPasswordTextbox(String password) {
        waitForElementVisible(driver, UserChangePasswordPageUI.OLD_PASSWORD_TEXTBOX);
        sendKeyToElement(driver, UserChangePasswordPageUI.OLD_PASSWORD_TEXTBOX, password);
    }

    public void inputToNewPasswordtextbox(String newPassword) {
        waitForElementVisible(driver, UserChangePasswordPageUI.NEW_PASSWORD_TEXTBOX);
        sendKeyToElement(driver, UserChangePasswordPageUI.NEW_PASSWORD_TEXTBOX, newPassword);
    }

    public void inputToConfirmPasswordTextbox(String newPassword) {
        waitForElementVisible(driver, UserChangePasswordPageUI.CONFIRM_NEW_PASSWORD_TEXTBOX);
        sendKeyToElement(driver, UserChangePasswordPageUI.CONFIRM_NEW_PASSWORD_TEXTBOX, newPassword);
    }

    public void clickOnChangePasswordButton() {
        waitForElementClickable(driver, UserChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
        clickToElement(driver, UserChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
    }

    public boolean isChangePasswordSuccessMessageDisplay() {
        waitForElementVisible(driver, UserChangePasswordPageUI.CHANGE_PASSWORD_SUCCESS_MESSAGE);
        return isDisplayElement(driver, UserChangePasswordPageUI.CHANGE_PASSWORD_SUCCESS_MESSAGE);
    }

    public void closeSuccesMessage() {
        waitForElementVisible(driver, UserChangePasswordPageUI.CLOSE_CHANGE_SUCCESS_MESSAGE);
        clickToElement(driver, UserChangePasswordPageUI.CLOSE_CHANGE_SUCCESS_MESSAGE);
    }

    public UserHomePageObject clickOnLogoutLink() {
        waitForElementClickable(driver, UserChangePasswordPageUI.LOG_OUT_LINK);
        clickToElement(driver, UserChangePasswordPageUI.LOG_OUT_LINK);
        return PageGeneratorManager.getHomePageObject(driver);
    }
}
