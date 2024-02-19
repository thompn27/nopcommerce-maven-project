package pageObjectsNopCommerceUser;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIsNopCommerceUser.UserRegisterPageUI;

public class UserRegisterPageObject extends BasePage {
    private final WebDriver driver;

    public UserRegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public UserHomePageObject clickToRegisterButton() {
        waitForElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
        return PageGeneratorManager.getHomePageObject(driver);
    }

    public String getFirstNameErrorMessage() {
        waitForElementVisible(driver, UserRegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
        return getTextElement(driver, UserRegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
    }

    public String getLastNameErrorMessage() {
        waitForElementVisible(driver, UserRegisterPageUI.LAST_NAME_ERROR_MESSAGE);
        return getTextElement(driver, UserRegisterPageUI.LAST_NAME_ERROR_MESSAGE);
    }

    public String getEmailErrorMessage() {
        waitForElementVisible(driver, UserRegisterPageUI.EMAIL_ERROR_MESSAGE);
        return getTextElement(driver, UserRegisterPageUI.EMAIL_ERROR_MESSAGE);
    }

    public String getPasswordErrorMessage() {
        waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_ERROR_MESSAGE);
        return getTextElement(driver, UserRegisterPageUI.PASSWORD_ERROR_MESSAGE);
    }

    public String getConfirmPasswordErrorMessage() {
        waitForElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
        return getTextElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
    }

    public String getRegisterSuccessfulMessage() {
        waitForElementVisible(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
        return getTextElement(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
    }

    public String getExistingEmailErrorMessage() {
        waitForElementVisible(driver, UserRegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
        return getTextElement(driver, UserRegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
    }

    public void inputToFirstNameTextBox(String firstName) {
        waitForElementVisible(driver, UserRegisterPageUI.FIRST_NAME_TEXT_BOX);
        sendKeyToElement(driver, UserRegisterPageUI.FIRST_NAME_TEXT_BOX, firstName);
    }

    public void inputToLastNameTextBox(String lastName) {
        waitForElementVisible(driver, UserRegisterPageUI.LAST_NAME_TEXT_BOX);
        sendKeyToElement(driver, UserRegisterPageUI.LAST_NAME_TEXT_BOX, lastName);
    }

    public void inputToEmailTextBox(String emailAddress) {
        waitForElementVisible(driver, UserRegisterPageUI.EMAIL_TEXT_BOX);
        sendKeyToElement(driver, UserRegisterPageUI.EMAIL_TEXT_BOX, emailAddress);
    }

    public void inputToPasswordTextBox(String password) {
        waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_TEXT_BOX);
        sendKeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXT_BOX, password);
    }

    public void inputToConfrirmPasswordTextBox(String password) {
        waitForElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXT_BOX);
        sendKeyToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXT_BOX, password);
    }
    public void registerAnUser(String firstName, String lastName, String emailAddress, String password, String confirmPassword){
        inputToFirstNameTextBox(firstName);
        inputToLastNameTextBox(lastName);
        inputToEmailTextBox(emailAddress);
        inputToPasswordTextBox(password);
        inputToConfrirmPasswordTextBox(confirmPassword);
        clickToRegisterButton();
    }

    public UserHomePageObject clickToLogOutLink(WebDriver driver) {
        waitForElementVisible(driver, UserRegisterPageUI.LOGOUT_LINK);
        clickToElement(driver, UserRegisterPageUI.LOGOUT_LINK);
        return PageGeneratorManager.getHomePageObject(driver);
    }

    public void clickToLoginLink() {
    }
}
