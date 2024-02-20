package pageObjectsNopCommerceAdmin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIsNopCommerceAdmin.AdminDashboardPageUI;

public class AdminDashboardPageObject extends BasePage {
    private final WebDriver driver;

    public AdminDashboardPageObject(WebDriver driver){
        this.driver = driver;
    }
    public boolean isDisplayAdminDashboard() {
        waitForElementVisible(driver, AdminDashboardPageUI.DASHBOARD_TEXT);
        return isDisplayElement(driver, AdminDashboardPageUI.DASHBOARD_TEXT);
    }


}
