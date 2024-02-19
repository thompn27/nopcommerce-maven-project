package nopcommerceuser;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjectsNopCommerceUser.*;

public class User_Search_Advaned_Search extends BaseTest {

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName){
        driver = getBrowserDriver(browserName);
        userHomePageObject = PageGeneratorManager.getHomePageObject(driver);

        firstName = "Ro";
        lastName = "P";
        emailAddress = firstName + lastName + getRandNumber() + "@gmail.com";
        System.out.println(emailAddress);
        password = "123456";

        log.info("Register: Click on 'Register' link");
        userHomePageObject.clickToRegisterLink();
        userRegisterPageObject = PageGeneratorManager.getRegisterPageObject(driver);

        log.info("Register: Enter all required fields and click on 'Register' button");
        userRegisterPageObject.registerAnUser(firstName, lastName, emailAddress, password, password);

        log.info("register: verify register success message displayed");
        verifyEquals(userRegisterPageObject.getRegisterSuccessfulMessage(),"Your registration completed");

        log.info("Login: Click on 'Login' link");
        userLoginPageObject = userHomePageObject.clickToLoginLink();

        log.info("Login: login with '" + emailAddress + " and " + password);
        userHomePageObject = userLoginPageObject.loginAsUser(emailAddress, password);
    }
    @Test
    public void User_01_Search_Empty_Data() {
        userLoginPageObject.openPagesByAreaAndPageName(driver, "footer-upper", "Search");
        userSearchPageObject = PageGeneratorManager.getUserSearchPageObject(driver);

        userSearchPageObject.clickOnSearchButtonNop();

        Assert.assertEquals(userSearchPageObject.getSearchNoResultMessageDisplayed(), "Search term minimum length is 3 characters");
    }

    @Test
    public void User_02_Search_Not_Exit_Data(){
        userSearchPageObject.inputToSearchTextbox("Macbook Pro 2050");
        userSearchPageObject.clickOnSearchButtonNop();

        Assert.assertEquals(userSearchPageObject.getSearchNoResultMessageDisplayed(), "No products were found that matched your criteria.");

    }
    @Test
    public void User_03_Search_Tuong_Doi() {
        userSearchPageObject.inputToSearchTextbox("Lenovo");
        userSearchPageObject.clickOnSearchButtonNop();

        Assert.assertEquals(userSearchPageObject.getProductNumberResult(), 2);
        Assert.assertTrue(userSearchPageObject.isProductResultDisplayedByName("Lenovo IdeaCentre 600 All-in-One PC"));
        Assert.assertTrue(userSearchPageObject.isProductResultDisplayedByName("Lenovo Thinkpad X1 Carbon Laptop"));

    }
    @Test
    public void User_04_Search_Tuyet_Doi(){
        userSearchPageObject.inputToSearchTextbox("ThinkPad X1 Carbon");
        userSearchPageObject.clickOnSearchButtonNop();

        Assert.assertEquals(userSearchPageObject.getProductNumberResult(), 1);
        Assert.assertTrue(userSearchPageObject.isProductResultDisplayedByName("Lenovo Thinkpad X1 Carbon Laptop"));
    }
    @Test
    public void User_05_Search_Parent_Categories(){
        userSearchPageObject.inputToSearchTextbox("Apple macbook pro");
        userSearchPageObject.checkToAdvancedCheckbox();

        userSearchPageObject.selectDropdownByLabelName("Category:", "Computers");
        userSearchPageObject.clickOnSearchButtonNop();

        Assert.assertEquals(userSearchPageObject.getSearchNoResultMessageDisplayed(), "No products were found that matched your criteria.");

    }
    @Test
    public void User_06_Search_Sub_Categories(){
        userSearchPageObject.inputToSearchTextbox("Apple macbook pro");
        userSearchPageObject.checkToAdvancedCheckbox();

        userSearchPageObject.selectDropdownByLabelName("Category:", "Computers");
        userSearchPageObject.checkToSubCategoriesCheckbox();
        userSearchPageObject.clickOnSearchButtonNop();

        Assert.assertEquals(userSearchPageObject.getProductNumberResult(), 1);
        Assert.assertTrue(userSearchPageObject.isProductResultDisplayedByName("Apple MacBook Pro 13-inch"));

    }
    @Test
    public void User_07_Search_Incorrect_Manufacturer(){
        userSearchPageObject.inputToSearchTextbox("Apple macbook pro");
        userSearchPageObject.checkToAdvancedCheckbox();
        userSearchPageObject.selectDropdownByLabelName("Category:", "Computers" );
        userSearchPageObject.checkToSubCategoriesCheckbox();
        userSearchPageObject.selectDropdownByLabelName("Manufacturer:", "HP");

        userSearchPageObject.clickOnSearchButtonNop();
        Assert.assertEquals(userSearchPageObject.getSearchNoResultMessageDisplayed(), "No products were found that matched your criteria.");
    }
    @Test
    public void User_08_Search_Correct_Manufacturer(){
        userSearchPageObject.inputToSearchTextbox("Apple macbook pro");
        userSearchPageObject.checkToAdvancedCheckbox();
        userSearchPageObject.selectDropdownByLabelName("Category:", "Computers" );
        userSearchPageObject.checkToSubCategoriesCheckbox();
        userSearchPageObject.selectDropdownByLabelName("Manufacturer:", "Apple");

        userSearchPageObject.clickOnSearchButtonNop();
        Assert.assertEquals(userSearchPageObject.getProductNumberResult(), 1);
        Assert.assertTrue(userSearchPageObject.isProductResultDisplayedByName("Apple MacBook Pro 13-inch"));
    }
    @AfterClass(alwaysRun = true)
    public void afterClass(){
        closeBrowserDriver();
        //driver.quit();
    }

    private WebDriver driver;
    private UserHomePageObject userHomePageObject;
    private UserRegisterPageObject userRegisterPageObject;
    private UserLoginPageObject userLoginPageObject;
    private UserSearchPageObject userSearchPageObject;
    private String firstName, lastName, emailAddress, password;
}

