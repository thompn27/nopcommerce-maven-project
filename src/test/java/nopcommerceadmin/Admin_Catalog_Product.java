package nopcommerceadmin;

import commons.BaseTest;
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

    private WebDriver driver;

    private String emailAddress, password;
    private AdminLoginPageObject adminLoginPageObject;
    private AdminDashboardPageObject adminDashboardPageObject;
    private AdminProductDetailPageObject adminProductDetailPageObject;
    private AdminProductPageObject adminProductPageObject;
    private String productName = "Lenovo IdeaCentre 600 All-in-one PC";
    private String productSku = "LE_IC_600";
    @Parameters({"browser", "urlName"})
    @BeforeClass
    public void beforeClass(String browserName, String urlName){
        driver = getBrowserDriver(browserName, urlName);
        adminLoginPageObject = PageGeneratorManager.getAdminLoginPageObject(driver);

        emailAddress = "admin@yourstore.com";
        password = "admin";

        log.info("Login page: Login to Admin page with email and passwor");
        adminDashboardPageObject = adminLoginPageObject.loginAsAdmin(emailAddress, password);

        log.info("Dashboard Admin: wait for Dashboard ready");
        Assert.assertTrue(adminDashboardPageObject.isLoadingIconUndisplayedNop(driver));

    }
    //@Test
//    public void Admin_01_Search_With_Product_Name(){
//        log.info("Dashboard: open Catalog - Product");
//        adminDashboardPageObject.openPageBySubAndParentPageNameNop(driver,"Catalog", "Products");
//        adminProductPageObject = PageGeneratorManager.getAdminProductPageObject(driver);
//
//        log.info("Product: wait for Loading icon disappear");
//        Assert.assertTrue(adminProductPageObject.isLoadingIconUndisplayedNop(driver));
//
//        log.info("Product: enter a product name");
//        adminProductPageObject.inputToTextBoxByLabelAndPageNameNop(driver, "Products", "SearchProductName", productName);
//
//        log.info("Product: click on search button");
//        adminProductPageObject.clickOnSearchButtonByPageNameNop(driver, "Products");
//
//        log.info("Product: wait for Loading icon disappear");
//        Assert.assertTrue(adminProductPageObject.isLoadingIconUndisplayedNop(driver));
//
//        log.info("Product: verify product displayed");
//        Assert.assertTrue(adminProductPageObject.isProductResultDisplayedByProductName(productName));
//        Assert.assertEquals(adminProductPageObject.getSearchResultItems(), "1-2 of 2 items");
//    }
    @Test
    public void Admin_02_Search_With_Product_Name_Parent_Category_Unchecked(){

    }
    @Test
    public void Admin_03_Search_With_Product_Name_Parent_Category_Checked(){

    }
    @Test
    public void Admin_04_Search_With_Product_Name_Child_Category(){

    }
    @Test
    public void Admin_05_Search_With_Product_Name_Manufacturer(){

    }
    @Test
    public void Admin_06_Go_Directlt_To_Product_SKU(){

    }
    @AfterClass(alwaysRun = true)
    public void afterClass(){
        closeBrowserDriver();
    }
}

