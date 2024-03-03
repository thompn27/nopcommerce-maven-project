package pageObjectsNopCommerceAdmin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjectsNopCommerceUser.PageGeneratorManager;
import pageUIsNopCommerceAdmin.AdminAddAddressPageUI;
import pageUIsNopCommerceAdmin.AdminAddNewCustomerPageUI;

public class AdminAddAddressPageObject extends BasePage {
    private WebDriver driver;

    public AdminAddAddressPageObject(WebDriver driver) {
        this.driver = driver;
    }


    public void clickOnSaveButton() {
        waitForElementClickable(driver, AdminAddAddressPageUI.SAVE_BUTTON);
        clickToElement(driver, AdminAddAddressPageUI.SAVE_BUTTON);
    }

    public AdminEditCustomerPageObject clickOnBackToCustomerDetail() {
        waitForElementClickable(driver, AdminAddAddressPageUI.BACK_TO_CUSTOMER_DETIAL_BUTTON);
        clickToElement(driver, AdminAddAddressPageUI.BACK_TO_CUSTOMER_DETIAL_BUTTON);
        return PageGeneratorManager.getAdminEditCustomerPageObject(driver);
    }
}
