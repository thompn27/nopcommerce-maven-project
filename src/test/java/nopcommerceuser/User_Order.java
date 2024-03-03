package nopcommerceuser;

import common.nopcommerce.Nop_Register_Cookie;
import commons.BaseTest;
import com.datanop.AddressData;
import com.datanop.ProductData;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjectsNopCommerceUser.*;

import java.text.ParseException;

public class User_Order extends BaseTest {
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName){
        driver = getBrowserDriver(browserName);
        userHomePageObject = PageGeneratorManager.getHomePageObject(driver);
        productData = ProductData.getProductData();
        addressDate = AddressData.getAddressData();

        productName1 = productData.getProductName1();
        productName2 = productData.getProductName2();
        paymentMethod = addressDate.getPaymentMethod();
        shippingMethod = addressDate.getShippingMethod();
        country = addressDate.getCountry();
        cityName = addressDate.getCityName();
        address1 = addressDate.getAddress1();
        zipCode = addressDate.getZipCode();
        phoneNumber = addressDate.getPhoneNumber();

        log.info("Login: Login to App with cookie and then reload page");
        userLoginPageObject = userHomePageObject.clickToLoginLink();
        userLoginPageObject.addCookie(driver, Nop_Register_Cookie.loggedCookies);
        userLoginPageObject.refreshThePage(driver);

        log.info("Login_03: Verify login success");
        Assert.assertTrue(userHomePageObject.isDisplayMyAccountLink());
    }
    @Test
    public void User_01_Add_Product_To_Cart(){
        String processorName = productData.getAddProcessorName();
        String ramType = productData.getAddRamType();
        String hddName = productData.getAddHddName();
        String oSName= productData.getAddoSName();
        String softwareName = productData.getAddSoftwareName();
        log.info("Home: open Desktop page");
        userHomePageObject.openSubCategoryPageByName(driver, "Computers", "Desktops");
        userDesktopPageObject = PageGeneratorManager.getUserDesktopPageObject(driver);

        log.info("Desktop: click a product by Name to open the product detail page");
        userProductDetailPageObject = userDesktopPageObject.clickOnProductByName(driver, productName1);

        log.info("Product detail: select the product info");
        userProductDetailPageObject.selectProcessorForProduct(processorName);
        userProductDetailPageObject.selectRamForProduct(ramType);
        userProductDetailPageObject.checkToRadioHddByProductName(hddName);
        userProductDetailPageObject.checkToRadioOsByProductName(oSName);
        userProductDetailPageObject.checkToCheckboxSoftwareByProductName(softwareName);
        userProductDetailPageObject.clickOnAddTocartButton();

        log.info("Product detail: verify add product to cart success message displayed");
        Assert.assertTrue(userProductDetailPageObject.isAddToCartSuccessMessageDisplayed());
        userProductDetailPageObject.closeWishListSuccessMessage();
        userProductDetailPageObject.sleepInSecond(2);

        log.info("Product detail: verify product is added to cart");
        userProductDetailPageObject.openShoppingCartPopup();
        Assert.assertTrue(userProductDetailPageObject.isproductNameDisplayed(productName1));
        Assert.assertTrue(userProductDetailPageObject.isProcessorSelectDisplayed(processorName, productName1));
        Assert.assertTrue(userProductDetailPageObject.isRamSelectedDisplayed(ramType, productName1));
        Assert.assertTrue(userProductDetailPageObject.isHddSelectedDisplayed(hddName, productName1));
        Assert.assertTrue(userProductDetailPageObject.isOsSelectedDisplayed(oSName, productName1));
        Assert.assertTrue(userProductDetailPageObject.isSoftwareSelectedDisplayed(softwareName, productName1));
        Assert.assertEquals(userProductDetailPageObject.getProductQuantitiesSelected(), "1");
    }
    @Test
    public void User_02_Edit_Product_In_Shopping_Cart() throws ParseException {
        String processorName = productData.getUpdateProcessorName();
        String ramType = productData.getUpdateRamType();
        String hddName = productData.getUpdateHddName();
        String oSName= productData.getUpdateoSName();
        String softwareName = productData.getUpdateSoftwareName();
        String productQuantities = productData.getUpdateProductQuantities();
        int quantitiesNumber = Integer.parseInt(productQuantities);

        log.info("Shopping cart: open shopping cart");
        userShoppingCartPageObject = userProductDetailPageObject.openShoppingCartPage(driver);

        log.info("Shopping cart: verify displays the shopping cart page");
        Assert.assertTrue(userShoppingCartPageObject.isShoppingCartTitlePageDisplayed());

        log.info("Shopping cart: click on edit link");
        userProductDetailPageObject = userShoppingCartPageObject.clickOnEditLinkByProductName(productName1);

        log.info("Product detail: select the product info");
        userProductDetailPageObject.selectProcessorForProduct(processorName);
        userProductDetailPageObject.selectRamForProduct(ramType);
        userProductDetailPageObject.checkToRadioHddByProductName(hddName);
        userProductDetailPageObject.checkToRadioOsByProductName(oSName);
        userProductDetailPageObject.checkToCheckboxSoftwareByProductName(softwareName);
        userProductDetailPageObject.inputProductQuantities(productQuantities);
        float finalPrice = userProductDetailPageObject.FinalPrice(quantitiesNumber);

        log.info("Product detail: click on Update button");
        userProductDetailPageObject.clickOnUpdateButton();

        log.info("Product detail: update product success message displayed");
        Assert.assertTrue(userProductDetailPageObject.isAddToCartSuccessMessageDisplayed());
        userProductDetailPageObject.closeWishListSuccessMessage();
        userProductDetailPageObject.sleepInSecond(2);

        log.info("Product detail: open shopping cart popup");
        userProductDetailPageObject.openShoppingCartPopup();

        log.info("Shopping cart popup: get total price");
        float totalPriceOnMiniCart = userProductDetailPageObject.totalPriceOnMiniCart();

        log.info("Product detail: verify product info is updated");
        Assert.assertTrue(userProductDetailPageObject.isproductNameDisplayed(productName1));
        Assert.assertTrue(userProductDetailPageObject.isProcessorSelectDisplayed(processorName, productName1));
        Assert.assertTrue(userProductDetailPageObject.isRamSelectedDisplayed(ramType, productName1));
        Assert.assertTrue(userProductDetailPageObject.isHddSelectedDisplayed(hddName, productName1));
        Assert.assertTrue(userProductDetailPageObject.isOsSelectedDisplayed(oSName, productName1));
        Assert.assertTrue(userProductDetailPageObject.isSoftwareSelectedDisplayed(softwareName, productName1));
        Assert.assertEquals(userProductDetailPageObject.getProductQuantitiesSelected(), "3");
        Assert.assertEquals(totalPriceOnMiniCart, finalPrice);
    }
    @Test
    public void User_03_Remove_From_Cart(){
        log.info("Shopping cart: Open the shopping cart page");
        userShoppingCartPageObject = userProductDetailPageObject.openShoppingCartPage(driver);

        log.info("Shopping cart: click on Remove button");
        userShoppingCartPageObject.clickOnRemoveFromCartByProductName(productName1);

        log.info("Shopping cart: Verify remove product success message displayed");
        Assert.assertTrue(userShoppingCartPageObject.isRemoveProductSuccessMessageDisplayed());

        log.info("Shopping cart: verify product disappear on the cart page");
        Assert.assertTrue(userShoppingCartPageObject.isProductUndisplayOnCartPage(productName1));
    }
    @Test
    public void User_04_Update_Shopping_Cart() throws ParseException {
        String searchKeyword = productData.getSearchKeyword();
        String productName= productData.getProductName();
        String quantitiesString = productData.getQuantitiesString();
        int quantitiesNumbers = Integer.parseInt(quantitiesString);


        log.info("Shopping cart: search 'lenovo' ");
        userShoppingCartPageObject.inputToSearchBox(searchKeyword);

        log.info("Shopping cart: click on Search button");
        userSearchPageObject = userShoppingCartPageObject.clickOnSearchButtonNop();

        log.info("Shopping cart: displays the result: 2 lenovo products");
        Assert.assertTrue(userSearchPageObject.isSearchResultDisplayed(searchKeyword));

        log.info("Search: click Add Lenovo product to Cart");
        userSearchPageObject.clickOnAddToCartButtonByName(productName);

        log.info("Search: verify add to cart success message displayed");
        Assert.assertTrue(userSearchPageObject.isAddToCartSuccessMessageDisplayed());
        userSearchPageObject.closeAddToCartSuccessMessage();
        userSearchPageObject.sleepInSecond(2);

        log.info("Search: open shopping cart page");
        userShoppingCartPageObject = userSearchPageObject.openShoppingCartPage(driver);
        float productPriceUnit = userShoppingCartPageObject.getPriceUnitByProductName(productName);

        log.info("Shopping cart: increase QTY to 5");
        userShoppingCartPageObject.inputToQtyBoxByProductName(productName,quantitiesString);

        log.info("Shopping cart: click on update shopping cart");
        userShoppingCartPageObject.clickOnUpdateShoppingCartButton();
        userShoppingCartPageObject.sleepInSecond(3);

        log.info("Shopping cart: verify the price is updated");
        float totalPrice = userShoppingCartPageObject.getTotalPriceByProductName(productName);
        System.out.println("total: " + totalPrice);
        float priceAfterUpdatingQty = productPriceUnit * quantitiesNumbers;
        System.out.println("total after: " + priceAfterUpdatingQty);
        Assert.assertEquals(totalPrice, priceAfterUpdatingQty);

        log.info("Shopping cart: remove all product in cart");
        userShoppingCartPageObject.clickOnRemoveFromCartByProductName(productName);

        log.info("Shopping cart: verify product disappear on the cart page");
        Assert.assertTrue(userShoppingCartPageObject.isProductUndisplayOnCartPage(productName));
    }
    @Test
    public void User_05_Checkout_Order_By_Cheque(){
        log.info("Home page: Open Home page by click on Logo");
        userHomePageObject = userShoppingCartPageObject.openHomePageByClickonLogo(driver);

        log.info("Notebooks page: Open the notebooks page");
        userHomePageObject.openSubCategoryPageByName(driver, "Computers", "Notebooks");
        userNoteBookPageObject = PageGeneratorManager.getUserNoteBookPageObject(driver);

        userProductDetailPageObject = userNoteBookPageObject.clickOnProductByName(driver, productName2);
        userProductDetailPageObject.clickOnAddTocartButton();
        userProductDetailPageObject.closeSuccessMessage();

        userShoppingCartPageObject = userProductDetailPageObject.openShoppingCartPage(driver);
        userShoppingCartPageObject.clickOnTermAndConditionCheckbox();
        userCheckOutPageObject = userShoppingCartPageObject.clickOnCheckOutButton();

        log.info("Checkout page: Fill the Billing address");
        userCheckOutPageObject.fillBillingAddress(country, cityName, address1, zipCode, phoneNumber);
        userCheckOutPageObject.clickOnContinueButtonBySection("Billing address");

        log.info("Checkout page: Select a shipping method");
        userCheckOutPageObject.clickOnShippingMethodByName(shippingMethod);
        userCheckOutPageObject.clickOnContinueButtonBySection("Shipping method");

        log.info("Checkout page: Select a payment method");
        userCheckOutPageObject.clickOnPaymentMethodByName(paymentMethod);
        userCheckOutPageObject.clickOnContinueButtonBySection("Payment method");

        log.info("Checkout: Verify Payment information");
        Assert.assertTrue(userCheckOutPageObject.isAddressDisplayed().contains("Mail Personal or Business Check, Cashier's Check or money order to:"));

        userCheckOutPageObject.clickOnContinueButtonBySection("Payment information");

        log.info("Checkout: Verify Order information on Confirm section");
        Assert.assertTrue(userCheckOutPageObject.getFullname().contains(Nop_Register_Cookie.firstName + " " + Nop_Register_Cookie.lastName));
        Assert.assertTrue(userCheckOutPageObject.getEmail().contains(Nop_Register_Cookie.emailAddress));
        Assert.assertTrue(userCheckOutPageObject.getPhone().contains(phoneNumber));
        Assert.assertTrue(userCheckOutPageObject.getAddress1().contains(address1));
        Assert.assertTrue(userCheckOutPageObject.getCity().contains(cityName));
        Assert.assertTrue(userCheckOutPageObject.getCountry().contains(country));
        Assert.assertTrue(userCheckOutPageObject.getPaymentMethod().contains(paymentMethod));
        Assert.assertTrue(userCheckOutPageObject.getShippingMethod().contains(shippingMethod));
        Assert.assertTrue(userCheckOutPageObject.isProductNameDisplayedByName(productName2));
        Assert.assertEquals(userCheckOutPageObject.getProductQuantitiesByProductName(productName2),"2");
        Assert.assertEquals(userCheckOutPageObject.getTotalprice(), userCheckOutPageObject.getTotalPriceInTableByProductName(productName2));

        log.info("Thank you page: click on Confirm button");
        userThankYouPageObject = userCheckOutPageObject.clickOnConfirmOrderButton();

        log.info("Thank you page: Verify order success message displayed");
        Assert.assertTrue(userThankYouPageObject.isOrderSuccessMessageDisplayed());

    }
    @Test
    public void User_06_Re_Order(){
        //String orderNumber = userCheckOutPageObject.getOrderNumber();
        userThankYouPageObject = PageGeneratorManager.getUserThankYouPageObject(driver);
        userThankYouPageObject.openPagesByAreaAndPageName(driver, "footer-upper", "Orders");
        userOrdersPageObject = PageGeneratorManager.getOrdersPageObject(driver);

        log.info("Order page: click on Detail link to open order detail");


    }
    @AfterClass(alwaysRun = true)
    public void afterClass(){
        closeBrowserDriver();
    }
    private WebDriver driver;
    private UserHomePageObject userHomePageObject;
    private UserLoginPageObject userLoginPageObject;
    private UserDesktopPageObject userDesktopPageObject;
    private UserProductDetailPageObject userProductDetailPageObject;
    private UserShoppingCartPageObject userShoppingCartPageObject;
    private UserSearchPageObject userSearchPageObject;
    private UserNoteBookPageObject userNoteBookPageObject;
    private UserCheckOutPageObject userCheckOutPageObject;
    private UserOrdersPageObject userOrdersPageObject;
    private UserThankYouPageObject userThankYouPageObject;
    private ProductData productData;
    private AddressData addressDate;

    private String productName1, productName2, paymentMethod, shippingMethod, country, cityName, address1, phoneNumber, zipCode;
}

