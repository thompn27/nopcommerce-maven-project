package common.nopcommerce;

import commons.BaseTest;
import datanop.UserData;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pageObjectsNopCommerceUser.PageGeneratorManager;
import pageObjectsNopCommerceUser.UserHomePageObject;
import pageObjectsNopCommerceUser.UserRegisterPageObject;

public class Nop_Register_End_User extends BaseTest {
    @Parameters("browser")
    @BeforeTest
    public void Register_An_Account(String browserName){
        driver = getBrowserDriver(browserName);
        userHomePageObject = PageGeneratorManager.getHomePageObject(driver);


        firstName = userData.getFirstName();
        lastName = userData.getLastName();
        emailAddress = firstName + lastName + getRandNumber() + "@gmail.com";
        password = "123456";

        log.info("Register: Register an account");
        userRegisterPageObject = userHomePageObject.clickToRegisterLink();

        userRegisterPageObject.inputToFirstNameTextBox(firstName);
        userRegisterPageObject.inputToLastNameTextBox(lastName);
        userRegisterPageObject.inputToEmailTextBox(emailAddress);
        userRegisterPageObject.inputToPasswordTextBox(password);
        userRegisterPageObject.inputToConfrirmPasswordTextBox(password);
        userRegisterPageObject.clickToRegisterButton();

        Assert.assertEquals(userRegisterPageObject.getRegisterSuccessfulMessage(),"Your registration completed");
        closeBrowserDriver();
    }
    private WebDriver driver;
    private UserHomePageObject userHomePageObject;
    private UserRegisterPageObject userRegisterPageObject;
    private UserData userData;
    private String firstName, lastName;

    public static String emailAddress, password;
}
