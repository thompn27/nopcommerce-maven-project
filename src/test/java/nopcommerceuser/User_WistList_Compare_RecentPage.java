package nopcommerceuser;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjectsNopCommerceUser.*;

public class User_WistList_Compare_RecentPage extends BaseTest {
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
        product1 = "Apple MacBook Pro 13-inch";
        product2 = "Asus N551JK-XO076H Laptop";
        product3 = "HP Envy 6-1180ca 15.6-Inch Sleekbook";
        product4 = "HP Spectre XT Pro UltraBook";
        product5 = "Lenovo Thinkpad X1 Carbon Laptop";
        productDesktop1 = "Digital Storm VANQUISH 3 Custom Performance PC";
        productDesktop2 = "Lenovo IdeaCentre 600 All-in-One PC";

        log.info("Precondition: Register an account");
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
    public void User_01_Add_Product_To_WishList(){
        log.info("Home: open the desktop page by click on Computers");
        userHomePageObject.openSubCategoryPageByName(driver, "Computers", "Desktops");
        userDesktopPageObject = PageGeneratorManager.getUserDesktopPageObject(driver);

        log.info("Desktop: click on product name ");
        userProductDetailPageObject = userDesktopPageObject.clickOnProductByName(driver, productDesktop1);
        userProductDetailPageObject.clickOnAddToWishListButton();
        Assert.assertTrue(userProductDetailPageObject.isAddToWishListSuccessMessageDisplay());

        userProductDetailPageObject.closeWishListSuccessMessage();
        userProductDetailPageObject.sleepInSecond(1);
        userWishListPageObject = userProductDetailPageObject.openWishListPage(driver);
        Assert.assertTrue(userWishListPageObject.isProductDisplayByProductName(productDesktop1));
    }
    @Test
    public void User_02_Add_Product_To_Cart_From_WishList(){
        userWishListPageObject = PageGeneratorManager.getUserWishListPageObject(driver);
        userWishListPageObject.clickToCheckBoxByProductName(productDesktop1);
        userShoppingCartPageObject = userWishListPageObject.clickToAddToCartButton();
        Assert.assertTrue(userShoppingCartPageObject.isProductDisplayedByName(productDesktop1));

        userWishListPageObject = userShoppingCartPageObject.openWishListPage(driver);
        Assert.assertTrue(userWishListPageObject.isProductFromWishlistRemovedByName(productDesktop1));
    }
    @Test
    public void User_03_Remove_Product_From_Wishlist(){
        log.info("Wishlist: open the desktop page by click on Computers");
        userWishListPageObject = PageGeneratorManager.getUserWishListPageObject(driver);
        userWishListPageObject.openSubCategoryPageByName(driver, "Computers", "Desktops");
        userDesktopPageObject = PageGeneratorManager.getUserDesktopPageObject(driver);

        log.info("Desktop: click on product name ");
        userProductDetailPageObject = userDesktopPageObject.clickOnProductByName(driver, productDesktop1);
        userProductDetailPageObject.clickOnAddToWishListButton();
        userProductDetailPageObject.isAddToWishListSuccessMessageDisplay();

        userProductDetailPageObject.closeWishListSuccessMessage();
        userProductDetailPageObject.sleepInSecond(2);
        userWishListPageObject = userProductDetailPageObject.openWishListPage(driver);
        Assert.assertTrue(userWishListPageObject.isProductDisplayByProductName(productDesktop1));

        userWishListPageObject.removeProductFromWishlistByName(productDesktop1);
        Assert.assertTrue(userWishListPageObject.isProductFromWishlistRemovedByName(productDesktop1));
    }
    @Test
    public void User_04_Compare_Products(){
        log.info("Wishlist: Open Home page by click on logo");
        userHomePageObject = userWishListPageObject.openHomePageByClickonLogo(driver);

        log.info("Home: open the desktop page by click on Computers");
        userHomePageObject.openSubCategoryPageByName(driver, "Computers", "Desktops");
        userDesktopPageObject = PageGeneratorManager.getUserDesktopPageObject(driver);

        log.info("Desktop: Add 1st products to compare");
        userDesktopPageObject.clickToAddToCompareButtonByProductName(productDesktop1);
        Assert.assertTrue(userDesktopPageObject.isProductAddToCompareSuccessMessageDisplayedByName());

        log.info("Desktop: Add 2nd product to compare ");
        userDesktopPageObject.clickToAddToCompareButtonByProductName(productDesktop2);
        userDesktopPageObject.sleepInSecond(1);
        Assert.assertTrue(userDesktopPageObject.isProductAddToCompareSuccessMessageDisplayedByName());

        log.info("Desktop: open the Compare page at Footer");
        userDesktopPageObject.openPagesByAreaAndPageName(driver, "footer-upper", "Compare products list");
        userComparePageObject = PageGeneratorManager.getUserComparePageObject(driver);

        log.info("Compare: verify products display on Compare page");
        Assert.assertTrue(userComparePageObject.isProductCompareDisplayedByName(productDesktop1));
        Assert.assertTrue(userComparePageObject.isProductCompareDisplayedByName(productDesktop2));

        log.info("Compare: clear products compare list");
        userComparePageObject.clickOnClearListProductsCompareButton();
        Assert.assertTrue(userComparePageObject.isClearProductsCompareSuccessMessageDisplayed());

//        log.info("Compare: verify 2products removed from the Compare page");
//        Assert.assertTrue(userComparePageObject.isProductCompareUndisplayedByName(productDesktop1));
//        Assert.assertTrue(userComparePageObject.isProductCompareUndisplayedByName(productDesktop2));
    }
    @Test
    public void User_05_Recent_View_Products() {
        log.info("Wishlist: Open Home page by click on logo");
        userHomePageObject = userWishListPageObject.openHomePageByClickonLogo(driver);

        log.info("Home: open the Notebook page by click on Computers");
        userHomePageObject.openSubCategoryPageByName(driver,"Computers", "Notebooks");
        userNoteBookPageObject = PageGeneratorManager.getUserNoteBookPageObject(driver);

        log.info("Notebook: Click view 5 products");
        userProductDetailPageObject = userNoteBookPageObject.clickOnProductByName(driver,product1);

        userProductDetailPageObject.backToPage(driver);
        userNoteBookPageObject = PageGeneratorManager.getUserNoteBookPageObject(driver);

        userProductDetailPageObject = userNoteBookPageObject.clickOnProductByName(driver,product2);
        userProductDetailPageObject.backToPage(driver);
        userNoteBookPageObject = PageGeneratorManager.getUserNoteBookPageObject(driver);

        userProductDetailPageObject = userNoteBookPageObject.clickOnProductByName(driver,product3);
        userProductDetailPageObject.backToPage(driver);
        userNoteBookPageObject = PageGeneratorManager.getUserNoteBookPageObject(driver);

        userProductDetailPageObject = userNoteBookPageObject.clickOnProductByName(driver,product4);
        userProductDetailPageObject.backToPage(driver);
        userNoteBookPageObject = PageGeneratorManager.getUserNoteBookPageObject(driver);

        userProductDetailPageObject = userNoteBookPageObject.clickOnProductByName(driver,product5);
        userProductDetailPageObject.backToPage(driver);
        userNoteBookPageObject = PageGeneratorManager.getUserNoteBookPageObject(driver);

        log.info("Notebook: open the Recent product view page");
        userNoteBookPageObject.openPagesByAreaAndPageName(driver, "footer-upper", "Recently viewed products");
        userRecentProductViewPageObject = PageGeneratorManager.getUserRecentProductViewPageObject(driver);
        userRecentProductViewPageObject.sleepInSecond(2);

        log.info("Recent product view: verify display 3last products only");
        Assert.assertEquals(userRecentProductViewPageObject.getProductNumberonRecentViewPage(), 3);
        Assert.assertTrue(userRecentProductViewPageObject.isProductOnRecentDisplayedByName(product3));
        Assert.assertTrue(userRecentProductViewPageObject.isProductOnRecentDisplayedByName(product4));
        Assert.assertTrue(userRecentProductViewPageObject.isProductOnRecentDisplayedByName(product5));

    }
        @AfterClass
    public void afterClass(){
        driver.quit();
    }
    private WebDriver driver;
    private UserHomePageObject userHomePageObject;
    private UserRegisterPageObject userRegisterPageObject;
    private UserLoginPageObject userLoginPageObject;
    private UserDesktopPageObject userDesktopPageObject;
    private UserProductDetailPageObject userProductDetailPageObject;
    private UserWishListPageObject userWishListPageObject;
    private UserShoppingCartPageObject userShoppingCartPageObject;
    private UserComparePageObject userComparePageObject;
    private UserNoteBookPageObject userNoteBookPageObject;
    private UserRecentProductViewPageObject userRecentProductViewPageObject;

    private String firstName, lastName, emailAddress, password, productDesktop1, productDesktop2, product1, product2, product3, product4, product5;
}

