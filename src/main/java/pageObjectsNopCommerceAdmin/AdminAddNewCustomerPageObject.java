package pageObjectsNopCommerceAdmin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjectsNopCommerceUser.PageGeneratorManager;
import pageUIsNopCommerceAdmin.AdminAddNewCustomerPageUI;

public class AdminAddNewCustomerPageObject extends BasePage {
    private WebDriver driver;

    public AdminAddNewCustomerPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void checkToRadioByGenderName(String genderName) {
        waitForElementClickable(driver, AdminAddNewCustomerPageUI.GENDER_RADIO_BY_NAME, genderName);
        checkToCheckboxOrRadio(driver, AdminAddNewCustomerPageUI.GENDER_RADIO_BY_NAME, genderName);
    }

    public void inputToTextAreaAdminComment(String adminComment) {
        waitForElementVisible(driver, AdminAddNewCustomerPageUI.ADMIN_COMMENT_TEXT_AREA);
        sendKeyToElement(driver, AdminAddNewCustomerPageUI.ADMIN_COMMENT_TEXT_AREA, adminComment);
    }



}
