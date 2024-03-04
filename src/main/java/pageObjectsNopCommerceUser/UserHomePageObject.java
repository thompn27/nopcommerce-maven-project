package pageObjectsNopCommerceUser;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIsNopCommerceUser.UserHomePageUI;

public class UserHomePageObject extends BasePage {
    private final WebDriver driver;

    public UserHomePageObject(WebDriver driver){
        this.driver = driver;
    }

    public UserRegisterPageObject clickToRegisterLink() {
        waitForElementClickable(driver, UserHomePageUI.USER_REGISTER_LINK);
        clickToElement(driver, UserHomePageUI.USER_REGISTER_LINK);
        return PageGeneratorManager.getRegisterPageObject(driver);
    }

    public boolean isDisplayMyAccountLink() {
        waitForElementClickable(driver, UserHomePageUI.USER_MY_ACCOUNT_LINK_HEADER);
        return isDisplayElement(driver, UserHomePageUI.USER_MY_ACCOUNT_LINK_HEADER);
    }

    public UserLoginPageObject clickToLoginLink() {
        waitForElementClickable(driver, UserHomePageUI.USER_LOGIN_LINK);
        clickToElement(driver, UserHomePageUI.USER_LOGIN_LINK);
        return PageGeneratorManager.getLoginPageObject(driver);
    }

    public UserCustomerInforPageObject clickToMyAccountLink() {
        waitForElementClickable(driver, UserHomePageUI.USER_MY_ACCOUNT_LINK_HEADER);
        clickToElement(driver, UserHomePageUI.USER_MY_ACCOUNT_LINK_HEADER);
        return PageGeneratorManager.getCustomerInforPageObject(driver);
    }

    public void closeLogInSuccessMessage() {
        waitForElementClickable(driver, UserHomePageUI.CLOSE_LOGIN_SUCCESS_MESSAGE);
        clickToElement(driver, UserHomePageUI.CLOSE_LOGIN_SUCCESS_MESSAGE);
    }
}
