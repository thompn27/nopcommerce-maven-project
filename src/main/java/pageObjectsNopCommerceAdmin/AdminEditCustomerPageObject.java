package pageObjectsNopCommerceAdmin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjectsNopCommerceUser.PageGeneratorManager;
import pageUIsNopCommerceAdmin.AdminEditCustomerPageUI;

public class AdminEditCustomerPageObject extends BasePage {
    private WebDriver driver;

    public AdminEditCustomerPageObject(WebDriver driver) {
        this.driver = driver;
    }


    public boolean isCustomerAtSectionDisplayedByInfo(String addresses, String customerInfo) {
        waitForElementVisible(driver, AdminEditCustomerPageUI.CUSTOMER_INFO_IN_ADDRESS_TABLE, addresses, customerInfo);
        return isDisplayElement(driver, AdminEditCustomerPageUI.CUSTOMER_INFO_IN_ADDRESS_TABLE, addresses, customerInfo);
    }

    public void clickOnAddressSection() {
        waitForElementClickable(driver, AdminEditCustomerPageUI.ADDRESS_SECTION_TITLE);
        clickToElement(driver, AdminEditCustomerPageUI.ADDRESS_SECTION_TITLE);
    }
    public AdminAddAddressPageObject clickOnAddNewAddressButton() {
        waitForElementClickable(driver, AdminEditCustomerPageUI.ADD_NEW_ADDRESS_BUTTON);
        clickToElement(driver, AdminEditCustomerPageUI.ADD_NEW_ADDRESS_BUTTON);
        return PageGeneratorManager.getAdminAddAddressPageObject(driver);
    }
    public boolean isAddressDisplayAtSectionName(String addresses, String address1) {
        waitForElementVisible(driver, AdminEditCustomerPageUI.ADDRESS_IN_ADDRESS_TABLE, addresses, address1);
        return isDisplayElement(driver, AdminEditCustomerPageUI.ADDRESS_IN_ADDRESS_TABLE, addresses, address1);

    }

    public void clickOnDeleteAddressButton() {
        waitForElementClickable(driver, AdminEditCustomerPageUI.DELETE_ADDRESS_BUTTON);
        clickToElement(driver, AdminEditCustomerPageUI.DELETE_ADDRESS_BUTTON);
    }

    public boolean isAddressUnDisplayed() {
        return isElementUnDisplayed(driver, AdminEditCustomerPageUI.ADDRESS_IN_ADDRESS_TABLE);
    }

    public void confirmDeleteAddressAlert() {
        acceptAlert(driver);
    }
}
