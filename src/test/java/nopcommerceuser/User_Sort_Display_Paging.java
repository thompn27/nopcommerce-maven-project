package nopcommerceuser;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjectsNopCommerceUser.*;

public class User_Sort_Display_Paging extends BaseTest {

    private WebDriver driver;
    private UserHomePageObject userHomePageObject;
    private UserRegisterPageObject userRegisterPageObject;
    private UserLoginPageObject userLoginPageObject;

    private String firstName, lastName, emailAddress, password;
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName){
        driver = getBrowserDriver(browserName);
        userHomePageObject = PageGeneratorManager.getHomePageObject(driver);


        emailAddress = firstName + lastName + getRandNumber() + "@gmail.com";

    }
    @Test
    public void User_01_CustomerInfo(){

    }
    @Test
    public void User_02_Addresses(){

    }
    @Test
    public void User_03_Change_Password(){

    }
    @Test
    public void User_04_My_Product_Review(){



    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}

