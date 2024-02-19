package pageObjectsNopCommerceAdmin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import PageUIsNopCommerceAdmin.AdminLoginPageUI;
import pageObjectsNopCommerceUser.PageGeneratorManager;

public class AdminLoginPageObject extends BasePage {
    private final WebDriver driver;

    public AdminLoginPageObject(WebDriver driver){
        this.driver = driver;
    }
    public void inputToAdminEmail(String adminEmailAddress){
        waitForElementVisible(driver, AdminLoginPageUI.ADMIN_EMAIL_TEXT_BOX);
        sendKeyToElement(driver, AdminLoginPageUI.ADMIN_EMAIL_TEXT_BOX, adminEmailAddress);
    }
    public void inputToAdminPassword(String adminPassword){
        waitForElementVisible(driver, AdminLoginPageUI.ADMIN_PASSWORD_TEXT_BOX);
        sendKeyToElement(driver, AdminLoginPageUI.ADMIN_PASSWORD_TEXT_BOX, adminPassword);
    }
    public AdminDashboardPageObject clickToLoginButtonAdmin(WebDriver driver){
        waitForElementClickable(driver, AdminLoginPageUI.ADMIN_LOGIN_BUTTON);
        clickToElement(driver, AdminLoginPageUI.ADMIN_LOGIN_BUTTON);
        return PageGeneratorManager.getAdminDashboardPageObject(driver);
    }
    public AdminDashboardPageObject loginAsAdmin(String adminEmailAddress, String adminPassword){
        inputToAdminEmail(adminEmailAddress);
        inputToAdminPassword(adminPassword);
        return clickToLoginButtonAdmin(driver);
    }

}
