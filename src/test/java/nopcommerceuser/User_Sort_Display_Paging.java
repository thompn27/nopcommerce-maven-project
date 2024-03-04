package nopcommerceuser;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjectsNopCommerceUser.*;

public class User_Sort_Display_Paging extends BaseTest {
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName){
        driver = getBrowserDriver(browserName);
        userHomePageObject = PageGeneratorManager.getHomePageObject(driver);

    }
    @Test
    public void User_01_Sort_Product_By_Name_A_To_Z(){
        log.info("Home page: open Notebook page");
        userHomePageObject.openSubCategoryPageByName(driver,"Computers", "Notebooks");
        userNoteBookPageObject = PageGeneratorManager.getUserNoteBookPageObject(driver);

        log.info("Notebook page: select Sort by A to Z");
        userNoteBookPageObject.selectSortBy("Name: A to Z");

        log.info("Notebook page: verify the ordering is correct");
        Assert.assertTrue(userNoteBookPageObject.isOrderingCorrectByAscByName());
    }
    @Test
    public void User_02_Sort_Product_By_Name_Z_To_A(){
        log.info("Home page: open Notebook page");
        userHomePageObject.openSubCategoryPageByName(driver,"Computers", "Notebooks");
        userNoteBookPageObject = PageGeneratorManager.getUserNoteBookPageObject(driver);

        log.info("Notebook page: select Sort by A to Z");
        userNoteBookPageObject.selectSortBy("Name: Z to A");

        log.info("Notebook page: verify the ordering is correct");
        Assert.assertTrue(userNoteBookPageObject.isOrderingCorrectByDescByName());
    }
    @Test
    public void User_03_Sort_Product_By_Price_Low_to_High(){
        log.info("Home page: open Notebook page");
        userHomePageObject.openSubCategoryPageByName(driver,"Computers", "Notebooks");
        userNoteBookPageObject = PageGeneratorManager.getUserNoteBookPageObject(driver);

        log.info("Notebook page: select Sort by price Low to high");
        userNoteBookPageObject.selectSortBy("Price: Low to High");

        log.info("Notebook page: verify the ordering is correct");
        Assert.assertTrue(userNoteBookPageObject.isOrderingCorrectByAscByPrice());

    }
    @Test
    public void User_04_Sort_Product_By_Price_High_to_Low(){
        log.info("Home page: open Notebook page");
        userHomePageObject.openSubCategoryPageByName(driver,"Computers", "Notebooks");
        userNoteBookPageObject = PageGeneratorManager.getUserNoteBookPageObject(driver);

        log.info("Notebook page: select Sort by price Low to high");
        userNoteBookPageObject.selectSortBy("Price: High to Low");

        log.info("Notebook page: verify the ordering is correct");
        Assert.assertTrue(userNoteBookPageObject.isOrderingCorrectByDescByPrice());
    }

    @AfterClass(alwaysRun = true)
    public void afterClass(){
        closeBrowserDriver();
    }

    private WebDriver driver;
    private UserHomePageObject userHomePageObject;
    private UserNoteBookPageObject userNoteBookPageObject;

}

