package pageObjectsNopCommerceAdmin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjectsNopCommerceUser.PageGeneratorManager;
import pageUIsNopCommerceAdmin.AdminCustomerPageUI;
import pageUIsNopCommerceAdmin.AdminEditCustomerPageUI;

public class AdminCustomerPageObject extends BasePage {
    private WebDriver driver;

    public AdminCustomerPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public AdminAddNewCustomerPageObject clickOnAddNewButton() {
        waitForElementClickable(driver, AdminCustomerPageUI.ADD_NEW_BUTTON);
        clickToElement(driver, AdminCustomerPageUI.ADD_NEW_BUTTON);
        return PageGeneratorManager.getAdminAddNewCustomerPageObject(driver);
    }
    public boolean isSearchResultByCustomerInfoDisplayed(String customerInfor) {
        waitForElementVisible(driver, AdminCustomerPageUI.SEARCH_RESULT_BY_CUSTOMER_INFOR, customerInfor);
        return isDisplayElement(driver, AdminCustomerPageUI.SEARCH_RESULT_BY_CUSTOMER_INFOR, customerInfor);

    }

    public AdminEditCustomerPageObject clickOnEditButton() {
        waitForElementClickable(driver, AdminEditCustomerPageUI.EDIT_BUTTON);
        clickToElement(driver, AdminEditCustomerPageUI.EDIT_BUTTON);
        return PageGeneratorManager.getAdminEditCustomerPageObject(driver);
    }
}
