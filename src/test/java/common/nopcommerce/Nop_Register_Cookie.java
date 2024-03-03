package common.nopcommerce;

import commons.BaseTest;
import com.datanop.UserData;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pageObjectsNopCommerceUser.PageGeneratorManager;
import pageObjectsNopCommerceUser.UserHomePageObject;
import pageObjectsNopCommerceUser.UserLoginPageObject;
import pageObjectsNopCommerceUser.UserRegisterPageObject;

import java.util.Set;

public class Nop_Register_Cookie extends BaseTest {
    private WebDriver driver;
    private UserHomePageObject userHomePageObject;
    private UserLoginPageObject userLoginPageObject;
    private UserRegisterPageObject userRegisterPageObject;
    private UserData userData;
    public static String firstName, lastName, emailAddress, password;
    public static Set<Cookie> loggedCookies;

    @Parameters("browser")
    @BeforeTest
    public void Register_An_Account(String browserName){
        driver = getBrowserDriver(browserName);
        userHomePageObject = PageGeneratorManager.getHomePageObject(driver);
        userData = UserData.getUserData();

        firstName = userData.getFirstName();
        lastName = userData.getLastName();
        emailAddress = firstName + lastName + getRandNumber() + "@gmail.com";
        password = userData.getPassword();
        System.out.println("first name: " + firstName);
        System.out.println("last name: " + lastName);
        System.out.println("email address: " + emailAddress);
        System.out.println("password: " + password);

        log.info("Register: Register an account");
        userRegisterPageObject = userHomePageObject.clickToRegisterLink();

        userRegisterPageObject.inputToFirstNameTextBox(firstName);
        userRegisterPageObject.inputToLastNameTextBox(lastName);
        userRegisterPageObject.inputToEmailTextBox(emailAddress);
        userRegisterPageObject.inputToPasswordTextBox(password);
        userRegisterPageObject.inputToConfrirmPasswordTextBox(password);
        userRegisterPageObject.clickToRegisterButton();

        Assert.assertEquals(userRegisterPageObject.getRegisterSuccessfulMessage(),"Your registration completed");
        log.info("Login: Login to App with an account");
        userLoginPageObject = userHomePageObject.clickToLoginLink();
        userLoginPageObject.inputToUserEmailTextBox(emailAddress);
        userLoginPageObject.inputToUserPasswordTextBox(password);
        userHomePageObject = userLoginPageObject.clickToUserLoginButton();

        log.info("Login_03: Verify login success");
        Assert.assertTrue(userHomePageObject.isDisplayMyAccountLink());

        log.info("Login: get cookies");
        loggedCookies = userHomePageObject.getAllCookies(driver);
        closeBrowserDriver();
    }
}
