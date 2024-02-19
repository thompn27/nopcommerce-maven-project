package nopcommerceuser;

import commons.BaseTest;
import datanop.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjectsNopCommerceUser.*;
public class User_My_Account_Page extends BaseTest {

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName){
        driver = getBrowserDriver(browserName);
        userHomePageObject = PageGeneratorManager.getHomePageObject(driver);
        userData = UserData.getUserData();

        emailAddress = userData.getFirstName() + userData.getLastName() + getRandNumber() + "@gmail.com";
        System.out.println(emailAddress);

        reviewTitle = userData.getNewFirstName() + " " + userData.getNewLastName() + "review";
        reviewText = "great";

        log.info("Precondition: Register an account");
        log.info("Register: Click on 'Register' link");
        userHomePageObject.clickToRegisterLink();
        userRegisterPageObject = PageGeneratorManager.getRegisterPageObject(driver);
        log.info("Register: Enter all required fields and click on 'Register' button");
        userRegisterPageObject.registerAnUser(userData.getFirstName(), userData.getLastName(), emailAddress, userData.getPassword(), userData.getPassword());

        log.info("register: verify register success message displayed");
        verifyEquals(userRegisterPageObject.getRegisterSuccessfulMessage(),"Your registration completed");
        log.info("Login: Click on 'Login' link");
        userLoginPageObject = userHomePageObject.clickToLoginLink();
        log.info("Login: login with '" + emailAddress + " and " + userData.getPassword());
        userHomePageObject = userLoginPageObject.loginAsUser(emailAddress, userData.getPassword());
    }
    @Test
    public void User_01_CustomerInfo(){
        userCustomerInforPageObject = userHomePageObject.clickToMyAccountLink();
        verifyTrue(userCustomerInforPageObject.isDisplayTitlePage());

        userCustomerInforPageObject.checkToGenderByLabel("gender-female");
        userCustomerInforPageObject.inputNewFirstNameToFirstNameTextbox(userData.getNewFirstName());
        userCustomerInforPageObject.inputNewLastNameToLasstNameTextbox(userData.getNewLastName());
        userCustomerInforPageObject.selectDateByDropdown(userData.getDateVale());
        userCustomerInforPageObject.selectMonthByDropdown(userData.getMonthValue());
        userCustomerInforPageObject.selectYearByDropdown(userData.getYearValue());
        //userCustomerInforPageObject.selectDateOfBirthByDropDown(dateVale, monthValue, yearValue, "DateOfBirthDay", "DateOfBirthMonth", "DateOfBirthYear");
        userCustomerInforPageObject.inputToComapanyNameTextbox(userData.getCompanyName());
        userCustomerInforPageObject.clickToSaveButton();

        verifyTrue(userCustomerInforPageObject.isDisplayCustomerInfoUpdatedMessage());
        verifyTrue(userCustomerInforPageObject.isSelectGenderByLabel("gender-female"));
        log.info("Customer info: verify new first name displayed");
        verifyEquals(userCustomerInforPageObject.getUpdatedFirstNameByAttributeValue("value"), userData.getNewFirstName());
        verifyEquals(userCustomerInforPageObject.getUpdatedLastNameByAttributeValue("value"), userData.getNewLastName());
        verifyEquals(userCustomerInforPageObject.getSelectedDate(), userData.getDateVale());
        verifyEquals(userCustomerInforPageObject.getSelectedMonth(), userData.getMonthValue());
        verifyEquals(userCustomerInforPageObject.getSelectedyear(), userData.getYearValue());
        //Assert.assertTrue(userCustomerInforPageObject.isSelectedByDateOfBirth());
        log.info("Customer info: verify company name displayed");
        verifyEquals(userCustomerInforPageObject.getCompanyNameByAttributeValue("value"), userData.getCompanyName());
    }
    @Test
    public void User_02_Addresses(){
        userAddressesPageObject = userCustomerInforPageObject.openAddressesPageObject(driver);
        log.info("Addresses: click on 'ADD NEW' button");
        userAddressesPageObject.clickOnAddNewButton();
        log.info("Addresses: Inout fields and click on Save button");
        userAddressesPageObject.inputToFirstNameTextbox(userData.getNewFirstName());
        userAddressesPageObject.inputToLastNameTextbox(userData.getNewLastName());
        userAddressesPageObject.inputToEmailAddressTextbox(emailAddress);
        userAddressesPageObject.selectACountryFromDropdown(userData.getCountryValue());
        userAddressesPageObject.inputToCityTextbox(userData.getCityName());
        userAddressesPageObject.inputToAddress1Textbox(userData.getAddress1());
        userAddressesPageObject.inputToZipCodeTextbox(userData.getZipCode());
        userAddressesPageObject.inputToPhoneNumberTextbox(userData.getPhoneNumber());
        userAddressesPageObject.clickOnSaveButtonOnAddressesPage();

        log.info("Addresses: verify add a new address successful");
        verifyTrue(userAddressesPageObject.isAddNewAddressSuccessMessageDisplayed());
    }
    @Test
    public void User_03_Change_Password(){
        log.info("Change Password: Open the Change password page");
        userChangePasswordPageObject = userAddressesPageObject.openChangePasswordPageObject(driver);
        log.info("Cahnge password: Enter the Old and New password");
        userChangePasswordPageObject.inputToOldPasswordTextbox(userData.getPassword());
        userChangePasswordPageObject.inputToNewPasswordtextbox(userData.getNewPassword());
        userChangePasswordPageObject.inputToConfirmPasswordTextbox(userData.getNewPassword());

        log.info("Change password: Click on Change password button");
        userChangePasswordPageObject.clickOnChangePasswordButton();

        log.info("Change password: verify change password success message displayed");
        verifyTrue(userChangePasswordPageObject.isChangePasswordSuccessMessageDisplay());

        log.info("Change password: Close success message");
        userChangePasswordPageObject.closeSuccesMessage();

        log.info("Logout: Click logout link");
        userChangePasswordPageObject.sleepInSecond(2);
        userHomePageObject = userChangePasswordPageObject.clickOnLogoutLink();

        log.info("Home page: click on Login link");
        userLoginPageObject = userHomePageObject.clickToLoginLink();

        log.info("Login: login with old password");
        userLoginPageObject.loginAsUser(emailAddress, userData.getPassword());

        log.info("Login: verify an error message displays");
        verifyEquals(userLoginPageObject.getSummaryErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

        log.info("Login: login with new password");
        userHomePageObject = userLoginPageObject.loginAsUser(emailAddress, userData.getNewPassword());

        log.info("Home: verify login success");
        verifyTrue(userHomePageObject.isDisplayMyAccountLink());
    }
    @Test
    public void User_04_My_Product_Review(){
        log.info("Home: open the desktop page by click on Computers");
        userHomePageObject.openSubCategoryPageByName(driver,"Computers", "Desktops");
        userDesktopPageObject = PageGeneratorManager.getUserDesktopPageObject(driver);
                log.info("Desktop: click on product name ");
        userProductDetailPageObject = userDesktopPageObject.clickOnProductByName(driver,"Build your own computer");

        log.info("Product detail: click on Add your review");
        userProductReviewPageObject = userProductDetailPageObject.clickOnAddYourReviewLink();

        log.info("Prodcut review: Enter your review");
        userProductReviewPageObject.inputToReviewTitleTextbox(reviewTitle);
        userProductReviewPageObject.inputToReviewTextbox(reviewText);
        userProductReviewPageObject.selectRating("Not bad but also not excellent");

        log.info("Product review: Click on SUBMIT REVIEW button");
        userProductReviewPageObject.clickOnSubmitReviewButton();

        log.info("My account: open My product review page");
        userCustomerInforPageObject = userProductReviewPageObject.clickOnMyAccountLink();
        userMyProductReviewsPageObject = userCustomerInforPageObject.openMyProductReviewsPageObject(driver);

        log.info("My product review: verify a new review displayed");
        Assert.assertEquals(userMyProductReviewsPageObject.getNewProductReviewTitle(), reviewTitle);
        Assert.assertEquals(userMyProductReviewsPageObject.getNewProductReviewText(), reviewText);
    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    private WebDriver driver;
    private UserHomePageObject userHomePageObject;
    private UserRegisterPageObject userRegisterPageObject;
    private UserLoginPageObject userLoginPageObject;
    private UserCustomerInforPageObject userCustomerInforPageObject;
    private UserAddressesPageObject userAddressesPageObject;
    private UserChangePasswordPageObject userChangePasswordPageObject;
    private UserMyProductReviewsPageObject userMyProductReviewsPageObject;
    private UserDesktopPageObject userDesktopPageObject;
    private UserProductDetailPageObject userProductDetailPageObject;
    private UserProductReviewPageObject userProductReviewPageObject;
    private UserData userData;
    private String emailAddress, reviewTitle, reviewText;
}

