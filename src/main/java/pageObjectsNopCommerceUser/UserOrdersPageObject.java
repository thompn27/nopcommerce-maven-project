package pageObjectsNopCommerceUser;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class UserOrdersPageObject extends BasePage {
    private final WebDriver driver;

    public UserOrdersPageObject(WebDriver driver){
        this.driver = driver;
    }

}
