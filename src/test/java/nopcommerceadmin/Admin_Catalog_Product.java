package nopcommerceadmin;

import commons.BaseTest;
import com.datanop.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjectsNopCommerceUser.*;
import pageObjectsNopCommerceAdmin.AdminDashboardPageObject;
import pageObjectsNopCommerceAdmin.AdminLoginPageObject;
import pageObjectsNopCommerceAdmin.AdminProductDetailPageObject;
import pageObjectsNopCommerceAdmin.AdminProductPageObject;

public class Admin_Catalog_Product extends BaseTest {
    @Parameters({"browser", "urlName"})
    @BeforeClass
    public void beforeClass(String browserName, String urlName){
        driver = getBrowserDriver(browserName, urlName);
        adminLoginPageObject = PageGeneratorManager.getAdminLoginPageObject(driver);
        adminProductSearchData = AdminProductSearchData.getAdminProductSearchData();

        emailAddress = "admin@yourstore.com";
        password = "admin";
        productName = adminProductSearchData.getProductName();
        productSku = adminProductSearchData.getProductSku();
        attributeValue = adminProductSearchData.getAttributeValue();

        log.info("Login page: Login to Admin page with email and passwor");
        adminDashboardPageObject = adminLoginPageObject.loginAsAdmin(emailAddress, password);

        log.info("Dashboard Admin: wait for Dashboard ready");
        Assert.assertTrue(adminDashboardPageObject.isLoadingIconUndisplayedNop(driver));
        //adminDashboardPageObject.sleepInSecond(10);

    }
    @Test
    public void Admin_01_Search_With_Product_Name(){
        log.info("Dashboard: open Catalog - Product");
        adminDashboardPageObject.openPageBySubAndParentPageNameNop(driver, "Catalog", "Products");
        adminProductPageObject = PageGeneratorManager.getAdminProductPageObject(driver);

        log.info("Product: wait for Loading icon disappear");
        Assert.assertTrue(adminProductPageObject.isLoadingIconUndisplayedNop(driver));

        log.info("Product: enter a product name");
        adminProductPageObject.inputToTextBoxByLabelAndPageNameNop(driver, "Products", "SearchProductName", productName);

        log.info("Product: click on search button");
        adminProductPageObject.clickOnSearchButtonByPageNameNop(driver, "Products");

        log.info("Product: wait for Loading icon disappear");
        Assert.assertTrue(adminProductPageObject.isLoadingIconUndisplayedNop(driver));

        log.info("Product: verify product displayed");
        Assert.assertTrue(adminProductPageObject.isProductResultDisplayedByProductName(productName));
        Assert.assertEquals(adminProductPageObject.getSearchResultItems(driver), "1");
    }
    @Test
    public void Admin_02_Search_With_Product_Name_Parent_Category_Unchecked(){
        log.info("Products page: Reload page");
        adminProductPageObject.refreshThePage(driver);

        log.info("Product: wait for Loading icon disappear");
        Assert.assertTrue(adminProductPageObject.isLoadingIconUndisplayedNop(driver));

        log.info("Products page: enter a product name");
        adminProductPageObject.inputToTextBoxByLabelAndPageNameNop(driver, "Products", "SearchProductName", productName);

        log.info("Products page: Select a Category");
        adminProductPageObject.selectItemByLabelAndValue(driver, "Category", "Computers");

        log.info("Product: click on search button");
        adminProductPageObject.clickOnSearchButtonByPageNameNop(driver, "Products");

        log.info("Product: wait for Loading icon disappear");
        Assert.assertTrue(adminProductPageObject.isLoadingIconUndisplayedNop(driver));

        log.info("Products page: verify No product displayed");
        Assert.assertEquals(adminProductPageObject.getSearchResultItems(driver), "No records");
    }
    @Test
    public void Admin_03_Search_With_Product_Name_Parent_Category_Checked(){
        log.info("Products page: Reload page");
        adminProductPageObject.refreshThePage(driver);

        log.info("Product: wait for Loading icon disappear");
        Assert.assertTrue(adminProductPageObject.isLoadingIconUndisplayedNop(driver));

        log.info("Products page: enter a product name");
        adminProductPageObject.inputToTextBoxByLabelAndPageNameNop(driver, "Products", "SearchProductName", productName);

        log.info("Products page: Select a Category");
        adminProductPageObject.selectItemByLabelAndValue(driver, "Category", "Computers");

        log.info("Products page: check to subcategory checkbox");
        adminProductPageObject.checkToCheckboxByLabelName("Search subcategories");

        log.info("Product: click on search button");
        adminProductPageObject.clickOnSearchButtonByPageNameNop(driver, "Products");

        log.info("Product: wait for Loading icon disappear");
        Assert.assertTrue(adminProductPageObject.isLoadingIconUndisplayedNop(driver));

        log.info("Product: verify product displayed");
        Assert.assertTrue(adminProductPageObject.isProductResultDisplayedByProductName(productName));
        Assert.assertEquals(adminProductPageObject.getSearchResultItems(driver), "1");

    }
    @Test
    public void Admin_04_Search_With_Product_Name_Child_Category(){
        log.info("Products page: Reload page");
        adminProductPageObject.refreshThePage(driver);

        log.info("Product: wait for Loading icon disappear");
        Assert.assertTrue(adminProductPageObject.isLoadingIconUndisplayedNop(driver));

        log.info("Products page: enter a product name");
        adminProductPageObject.inputToTextBoxByLabelAndPageNameNop(driver, "Products", "SearchProductName", productName);

        log.info("Products page: Select a Category");
        adminProductPageObject.selectItemByLabelAndValue(driver, "Category", "Computers >> Desktops");

        log.info("Product: click on search button");
        adminProductPageObject.clickOnSearchButtonByPageNameNop(driver, "Products");

        log.info("Product: wait for Loading icon disappear");
        Assert.assertTrue(adminProductPageObject.isLoadingIconUndisplayedNop(driver));

        log.info("Product: verify product displayed");
        Assert.assertTrue(adminProductPageObject.isProductResultDisplayedByProductName(productName));
        Assert.assertEquals(adminProductPageObject.getSearchResultItems(driver), "1");
    }
    @Test
    public void Admin_05_Search_With_Product_Name_Manufacturer(){
        log.info("Products page: Reload page");
        adminProductPageObject.refreshThePage(driver);

        log.info("Product: wait for Loading icon disappear");
        Assert.assertTrue(adminProductPageObject.isLoadingIconUndisplayedNop(driver));

        log.info("Products page: enter a product name");
        adminProductPageObject.inputToTextBoxByLabelAndPageNameNop(driver, "Products", "SearchProductName", productName);

        log.info("Products page: Select a Category");
        adminProductPageObject.selectItemByLabelAndValue(driver, "Category", "All");

        log.info("Products page: select a Manufacturer");
        adminProductPageObject.selectItemByLabelAndValue(driver, "Manufacturer", "Apple");

        log.info("Product: click on search button");
        adminProductPageObject.clickOnSearchButtonByPageNameNop(driver, "Products");

        log.info("Product: wait for Loading icon disappear");
        Assert.assertTrue(adminProductPageObject.isLoadingIconUndisplayedNop(driver));

        log.info("Products page: verify No product displayed");
        Assert.assertEquals(adminProductPageObject.getSearchResultItems(driver), "No records");
    }
    @Test
    public void Admin_06_Go_Directlt_To_Product_SKU(){
        log.info("Products page: Reload page");
        adminProductPageObject.refreshThePage(driver);

        log.info("Product: wait for Loading icon disappear");
        Assert.assertTrue(adminProductPageObject.isLoadingIconUndisplayedNop(driver));

        log.info("Product page: enter a product on SKU box");
        adminProductPageObject.inputToTextBoxByLabelAndPageNameNop(driver, "Products", "GoDirectlyToSku", productSku);

        log.info("Products page: click on Go button");
        adminProductDetailPageObject = adminProductPageObject.clickOnGoButton();
        adminProductDetailPageObject.sleepInSecond(10);

//        log.info("Product: wait for Loading icon disappear");
//        Assert.assertTrue(adminProductPageObject.isLoadingIconUndisplayedNop(driver));

        log.info("Product detail page: verify it goes to the Product detail page");
        Assert.assertTrue(adminProductDetailPageObject.isProductDetailPageDisplayed());

        log.info("Product detail page: verify product info display");
        Assert.assertEquals(adminProductDetailPageObject.getProductInforByLabelDisplayed(driver, attributeValue, "Product name"), productName);
        Assert.assertEquals(adminProductDetailPageObject.getProductInforByLabelDisplayed(driver, attributeValue, "SKU"), productSku);

    }
    @AfterClass(alwaysRun = true)
    public void afterClass(){
        closeBrowserDriver();
    }


    private WebDriver driver;

    private String emailAddress, password;
    private AdminLoginPageObject adminLoginPageObject;
    private AdminDashboardPageObject adminDashboardPageObject;
    private AdminProductDetailPageObject adminProductDetailPageObject;
    private AdminProductPageObject adminProductPageObject;
    private AdminProductSearchData adminProductSearchData;
    private String productName;
    private String productSku;
    private String attributeValue;
}

