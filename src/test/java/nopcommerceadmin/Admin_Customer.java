package nopcommerceadmin;

import com.datanop.*;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjectsNopCommerceAdmin.*;
import pageObjectsNopCommerceUser.PageGeneratorManager;

public class Admin_Customer extends BaseTest {
    @Parameters({"browser", "urlName"})
    @BeforeClass
    public void beforeClass(String browserName, String urlName){
        driver = getBrowserDriver(browserName, urlName);
        adminLoginPageObject = PageGeneratorManager.getAdminLoginPageObject(driver);
        adminNewCustomerData = AdminNewCustomerData.getAdminNewCustomerData();
        addressData = AddressData.getAddressData();


        emailAddress = "admin@yourstore.com";
        password = "admin";

        log.info("Login page: Login to Admin page with email and passwor");
        adminDashboardPageObject = adminLoginPageObject.loginAsAdmin(emailAddress, password);

        log.info("Dashboard Admin: wait for Dashboard ready");
        Assert.assertTrue(adminDashboardPageObject.isLoadingIconUndisplayedNop(driver));

    }
    @Test
    public void Admin_01_Add_New_Customer(){
        adminDashboardPageObject = PageGeneratorManager.getAdminDashboardPageObject(driver);
        log.info("Dashboard page: open the Customer page");
        adminDashboardPageObject.openPageBySubAndParentPageNameNop(driver,"Customers", "Customers");
        adminCustomerPageObject = PageGeneratorManager.getAdminCustomerPageObject(driver);

        log.info("wait for Dashboard ready");
        Assert.assertTrue(adminCustomerPageObject.isLoadingIconUndisplayedNop(driver));

        log.info("Customer page: Click on Add new button");
        adminAddNewCustomerPageObject = adminCustomerPageObject.clickOnAddNewButton();

        log.info(" wait for Dashboard ready");
        Assert.assertTrue(adminAddNewCustomerPageObject.isLoadingIconUndisplayedNop(driver));

        log.info("Add new Customer page: Enter customer info");
        adminAddNewCustomerPageObject.inputToTextBoxByLabelAndPageNameNop(driver, "Add a new customer", "Email", emailAddressCustomer);
        adminAddNewCustomerPageObject.inputToTextBoxByLabelAndPageNameNop(driver, "Add a new customer", "Password", passwordCustomer);
        adminAddNewCustomerPageObject.inputToTextBoxByLabelAndPageNameNop(driver, "Add a new customer", "FirstName", firstName);
        adminAddNewCustomerPageObject.inputToTextBoxByLabelAndPageNameNop(driver, "Add a new customer", "LastName", lastName);
        adminAddNewCustomerPageObject.checkToRadioByGenderName("Female");
        adminAddNewCustomerPageObject.inputToTextBoxByLabelAndPageNameNop(driver, "Add a new customer", "DateOfBirth", dateOfBirth);
        adminAddNewCustomerPageObject.inputToTextBoxByLabelAndPageNameNop(driver, "Add a new customer", "Company", companyName);
        adminAddNewCustomerPageObject.selectTheCustomerRole(driver, "Guests");
        adminAddNewCustomerPageObject.inputToTextAreaAdminComment(adminComment);

        log.info("Add new Customer page: click on Save button");
        adminAddNewCustomerPageObject.clickOnSaveAndContinueEditButton(driver);

        log.info(" wait for Dashboard ready");
        Assert.assertTrue(adminAddNewCustomerPageObject.isLoadingIconUndisplayedNop(driver));

        log.info("Add new Customer page: verify add new customer success message display");
        Assert.assertTrue(adminAddNewCustomerPageObject.isSuccessMessageDisplayed(driver));

        log.info("Add new Customer page: click to Back to Customer list button");
        adminCustomerPageObject = adminAddNewCustomerPageObject.clickOnbackToCustomerListPage(driver);

        log.info(" wait for Dashboard ready");
        Assert.assertTrue(adminCustomerPageObject.isLoadingIconUndisplayedNop(driver));

        log.info("Customer page: Search the new customer by Customer role");
        adminCustomerPageObject.selectTheCustomerRole(driver, "Guests");

        log.info("Customer page: click Search button");
        adminCustomerPageObject.clickOnSearchButtonByPageNameNop(driver, "Customers");

        log.info(" wait for Dashboard ready");
        Assert.assertTrue(adminCustomerPageObject.isLoadingIconUndisplayedNop(driver));

        log.info("Customer page: verify search result displayed");
        Assert.assertTrue(adminCustomerPageObject.isSearchResultByCustomerInfoDisplayed(firstName + " " + lastName));
    }
    @Test
    public void Admin_02_Search_Customer_with_Email(){
        log.info("Refresh Customer page");
        adminCustomerPageObject.refreshThePage(driver);

        log.info(" wait for Dashboard ready");
        Assert.assertTrue(adminCustomerPageObject.isLoadingIconUndisplayedNop(driver));

        log.info("Customer: Enter an email ");
        adminCustomerPageObject.inputToTextBoxByLabelAndPageNameNop(driver, "Customers", "SearchEmail", emailAddressCustomer);

        log.info("Customer page: select the customer role");
        adminCustomerPageObject.selectTheCustomerRole(driver, "Guests");

        log.info("Customer page: click on Search button");
        adminCustomerPageObject.clickOnSearchButtonByPageNameNop(driver, "Customers");

        log.info(" wait for Dashboard ready");
        Assert.assertTrue(adminCustomerPageObject.isLoadingIconUndisplayedNop(driver));

        log.info("Customer page: verify search result");
        Assert.assertTrue(adminCustomerPageObject.isSearchResultByCustomerInfoDisplayed(emailAddressCustomer));
        Assert.assertEquals(adminCustomerPageObject.getSearchResultItems(driver), "1");

    }
    @Test
    public void Admin_03_Search_Customer_With_First_Last_Name(){
        log.info("Refresh Customer page");
        adminCustomerPageObject.refreshThePage(driver);

        log.info(" wait for Dashboard ready");
        Assert.assertTrue(adminCustomerPageObject.isLoadingIconUndisplayedNop(driver));

        log.info("Customer: Enter the firstname and lastname ");
        adminCustomerPageObject.inputToTextBoxByLabelAndPageNameNop(driver, "Customers", "SearchFirstName", firstName);
        adminCustomerPageObject.inputToTextBoxByLabelAndPageNameNop(driver, "Customers", "SearchLastName", lastName);

        log.info("Customer page: select the customer role");
        adminCustomerPageObject.selectTheCustomerRole(driver, "Guests");

        log.info("Customer page: click on Search button");
        adminCustomerPageObject.clickOnSearchButtonByPageNameNop(driver, "Customers");

        log.info(" wait for Dashboard ready");
        Assert.assertTrue(adminCustomerPageObject.isLoadingIconUndisplayedNop(driver));

        log.info("Customer page: verify search result");
        Assert.assertTrue(adminCustomerPageObject.isSearchResultByCustomerInfoDisplayed(firstName + " " + lastName));
        Assert.assertEquals(adminCustomerPageObject.getSearchResultItems(driver), "1");
    }
    @Test
    public void Admin_04_Search_Customer_With_Company(){
        log.info("Refresh Customer page");
        adminCustomerPageObject.refreshThePage(driver);

        log.info(" wait for Dashboard ready");
        Assert.assertTrue(adminCustomerPageObject.isLoadingIconUndisplayedNop(driver));

        log.info("Customer: Enter the company name ");
        adminCustomerPageObject.inputToTextBoxByLabelAndPageNameNop(driver, "Customers", "SearchCompany", companyName);

        log.info("Customer page: select the customer role");
        adminCustomerPageObject.selectTheCustomerRole(driver, "Guest");

        log.info("Customer page: click on Search button");
        adminCustomerPageObject.clickOnSearchButtonByPageNameNop(driver, "Customers");

        log.info(" wait for Dashboard ready");
        Assert.assertTrue(adminCustomerPageObject.isLoadingIconUndisplayedNop(driver));

        log.info("Customer page: verify search result");
        Assert.assertTrue(adminCustomerPageObject.isSearchResultByCustomerInfoDisplayed(companyName));
        Assert.assertEquals(adminCustomerPageObject.getSearchResultItems(driver), "1");
    }
    @Test
    public void Admin_05_Search_With_Full_Customer_Data(){
        log.info("Refresh Customer page");
        adminCustomerPageObject.refreshThePage(driver);

        log.info(" wait for Dashboard ready");
        Assert.assertTrue(adminCustomerPageObject.isLoadingIconUndisplayedNop(driver));

        log.info("Customer: Enter the full customer infor: emai, firstname, lastname, dob, company name, customer role ");
        adminCustomerPageObject.inputToTextBoxByLabelAndPageNameNop(driver, "Customers", "SearchEmail", emailAddressCustomer);
        adminCustomerPageObject.inputToTextBoxByLabelAndPageNameNop(driver, "Customers", "SearchFirstName", firstName);
        adminCustomerPageObject.inputToTextBoxByLabelAndPageNameNop(driver, "Customers", "SearchLastName", lastName);
        adminCustomerPageObject.inputToTextBoxByLabelAndPageNameNop(driver, "Customers", "SearchCompany", companyName);
        adminCustomerPageObject.selectTheCustomerRole(driver, "Guests");

        log.info("Customer page: click on Search button");
        adminCustomerPageObject.clickOnSearchButtonByPageNameNop(driver, "Customers");

        log.info(" wait for Dashboard ready");
        Assert.assertTrue(adminCustomerPageObject.isLoadingIconUndisplayedNop(driver));

        log.info("Customer page: verify search result");
        Assert.assertTrue(adminCustomerPageObject.isSearchResultByCustomerInfoDisplayed(firstName + " " + lastName));
        Assert.assertEquals(adminCustomerPageObject.getSearchResultItems(driver), "1");
    }
    @Test
    public void Admin_06_Edit_Customer_Info(){
        log.info("Refresh Customer page");
        adminCustomerPageObject.refreshThePage(driver);

        log.info(" wait for Dashboard ready");
        Assert.assertTrue(adminCustomerPageObject.isLoadingIconUndisplayedNop(driver));

        log.info("Customer: Enter the full customer info: email, firstname, lastname, dob, company name, customer role ");
        adminCustomerPageObject.inputToTextBoxByLabelAndPageNameNop(driver, "Customers", "SearchFirstName", firstName);

        log.info("Customer page: select the customer role");
        adminCustomerPageObject.selectTheCustomerRole(driver, "Guest");

        log.info("Customer page: click on Search button");
        adminCustomerPageObject.clickOnSearchButtonByPageNameNop(driver, "Customers");

        log.info("Customer page: click on Edit button");
        adminEditCustomerPageObject = adminCustomerPageObject.clickOnEditButton();

        log.info(" wait for Dashboard ready");
        Assert.assertTrue(adminCustomerPageObject.isLoadingIconUndisplayedNop(driver));

        log.info("Edit customer page: edit firstname, lastname, company name");
        adminEditCustomerPageObject.inputToTextBoxByLabelAndPageNameNop(driver, "Edit customer details", "FirstName", "Edit " + firstName);
        adminEditCustomerPageObject.inputToTextBoxByLabelAndPageNameNop(driver, "Edit customer details", "LastName", "Edit " + lastName);
        adminEditCustomerPageObject.inputToTextBoxByLabelAndPageNameNop(driver, "Edit customer details", "Company", "Edit " + companyName);

        log.info("Edit customer page: click on Save and continue button");
        adminEditCustomerPageObject.clickOnSaveAndContinueEditButton(driver);

        log.info("Edit customer page: verify update success message display");
        adminEditCustomerPageObject.isSuccessMessageDisplayed(driver);

        log.info("Edit customer page: click on Back to Customer list");
        adminCustomerPageObject = adminEditCustomerPageObject.clickOnbackToCustomerListPage(driver);

        log.info(" wait for Dashboard ready");
        Assert.assertTrue(adminCustomerPageObject.isLoadingIconUndisplayedNop(driver));

        log.info("Customer page: enter the first name has edited");
        adminCustomerPageObject.inputToTextBoxByLabelAndPageNameNop(driver, "Customers", "SearchFirstName", "Edit " + firstName);
        adminCustomerPageObject.inputToTextBoxByLabelAndPageNameNop(driver, "Customers", "SearchLastName", "Edit " + lastName);

        log.info("Customer page: select the customer role");
        adminCustomerPageObject.selectTheCustomerRole(driver, "Guests");

        log.info("Customer page: click on Search button");
        adminCustomerPageObject.clickOnSearchButtonByPageNameNop(driver, "Customers");

        log.info(" wait for Dashboard ready");
        Assert.assertTrue(adminCustomerPageObject.isLoadingIconUndisplayedNop(driver));

        log.info("Customer page: verify search result");
        Assert.assertTrue(adminCustomerPageObject.isSearchResultByCustomerInfoDisplayed("Edit " + firstName + " " + "Edit " + lastName));
        Assert.assertEquals(adminCustomerPageObject.getSearchResultItems(driver), "1");
    }
    @Test
    public void Admin_07_Add_New_Address_In_Customer_Detail(){
        adminCustomerPageObject.refreshThePage(driver);

        log.info(" wait for Dashboard ready");
        Assert.assertTrue(adminCustomerPageObject.isLoadingIconUndisplayedNop(driver));

        log.info("Customer page: enter the first name has edited");
        adminCustomerPageObject.inputToTextBoxByLabelAndPageNameNop(driver, "Customers", "SearchFirstName", "Edit " + firstName);
        adminCustomerPageObject.inputToTextBoxByLabelAndPageNameNop(driver, "Customers", "SearchLastName", "Edit " + lastName);

        log.info("Customer page: select the customer role");
        adminCustomerPageObject.selectTheCustomerRole(driver, "Guests");

        log.info("Customer page: click on Search button");
        adminCustomerPageObject.clickOnSearchButtonByPageNameNop(driver, "Customers");

        log.info(" wait for Dashboard ready");
        Assert.assertTrue(adminCustomerPageObject.isLoadingIconUndisplayedNop(driver));

        log.info("Customer page: click on Edit button");
        adminEditCustomerPageObject = adminCustomerPageObject.clickOnEditButton();

        log.info("Edit page: click on Address");
        adminEditCustomerPageObject.clickOnAddressSection();

        log.info("Edit page: click on Add new Address button");
        adminAddAddressPageObject = adminEditCustomerPageObject.clickOnAddNewAddressButton();

        log.info(" wait for Dashboard ready");
        Assert.assertTrue(adminAddAddressPageObject.isLoadingIconUndisplayedNop(driver));

        log.info("Add new Address page: enter Address info");
        adminAddAddressPageObject.inputToTextBoxByLabelAndPageNameNop(driver, "Add a new address", "Address_FirstName", firstName);
        adminAddAddressPageObject.inputToTextBoxByLabelAndPageNameNop(driver, "Add a new address", "Address_LastName", lastName);
        adminAddAddressPageObject.inputToTextBoxByLabelAndPageNameNop(driver, "Add a new address", "Address_Email", emailAddressCustomer);
        adminAddAddressPageObject.inputToTextBoxByLabelAndPageNameNop(driver, "Add a new address", "Address_Company", companyName);

        adminAddAddressPageObject.selectItemByLabelAndValue(driver, "Address_CountryId", country);
        adminAddAddressPageObject.inputToTextBoxByLabelAndPageNameNop(driver, "Add a new address", "Address_City", cityName);
        adminAddAddressPageObject.inputToTextBoxByLabelAndPageNameNop(driver, "Add a new address", "Address_Address1", address1);
        adminAddAddressPageObject.inputToTextBoxByLabelAndPageNameNop(driver, "Add a new address", "Address_ZipPostalCode", zipCode);
        adminAddAddressPageObject.inputToTextBoxByLabelAndPageNameNop(driver, "Add a new address", "Address_PhoneNumber", phoneNumber);

        log.info("Add new Address page: click Save button");
        adminAddAddressPageObject.clickOnSaveButton();

        log.info(" wait for Dashboard ready");
        Assert.assertTrue(adminAddAddressPageObject.isLoadingIconUndisplayedNop(driver));

        log.info("Add new Address page: verify add new success message displayed");
        adminAddAddressPageObject.isSuccessMessageDisplayed(driver);

        log.info("Add new Address page: Click back to customer detail button");
        adminEditCustomerPageObject = adminAddAddressPageObject.clickOnBackToCustomerDetail();

        log.info(" wait for Dashboard ready");
        Assert.assertTrue(adminEditCustomerPageObject.isLoadingIconUndisplayedNop(driver));

        log.info("Customer detail: verify the new address displayed");
        Assert.assertTrue(adminEditCustomerPageObject.isCustomerAtSectionDisplayedByInfo("customer-address", "Edit " + firstName));
        Assert.assertTrue(adminEditCustomerPageObject.isCustomerAtSectionDisplayedByInfo("customer-address", "Edit " + lastName));
        Assert.assertTrue(adminEditCustomerPageObject.isCustomerAtSectionDisplayedByInfo("customer-address", phoneNumber));
        Assert.assertTrue(adminEditCustomerPageObject.isAddressDisplayAtSectionName("customer-address", address1));

    }
    @Test
    public void Admin_08_Delete_Address_In_Customer_Detail(){
        log.info("Customer page: open Customer page");
        adminEditCustomerPageObject.openPageBySubAndParentPageNameNop(driver, "Customers", "Customers");
        adminCustomerPageObject = PageGeneratorManager.getAdminCustomerPageObject(driver);

        log.info(" wait for Dashboard ready");
        Assert.assertTrue(adminCustomerPageObject.isLoadingIconUndisplayedNop(driver));

        log.info("Customer page: enter firstname and lastname");
        adminCustomerPageObject.inputToTextBoxByLabelAndPageNameNop(driver, "Customers", "SearchFirstName", "Edit " + firstName);
        adminCustomerPageObject.inputToTextBoxByLabelAndPageNameNop(driver, "Customers", "SearchLastName", "Edit " + lastName);

        log.info("Customer page: select the customer role");
        adminCustomerPageObject.selectTheCustomerRole(driver, "Guests");

        log.info("Customer page: click on Search button");
        adminCustomerPageObject.clickOnSearchButtonByPageNameNop(driver, "Customers");

        log.info(" wait for Dashboard ready");
        Assert.assertTrue(adminCustomerPageObject.isLoadingIconUndisplayedNop(driver));

        log.info("Customer page: click on Edit button");
        adminEditCustomerPageObject = adminCustomerPageObject.clickOnEditButton();

        log.info("Edit page: click on Address");
        adminEditCustomerPageObject.clickOnAddressSection();

        log.info("Edit customer page: click on Delete address button");
        adminEditCustomerPageObject.clickOnDeleteAddressButton();
        adminEditCustomerPageObject.confirmDeleteAddressAlert();

        log.info("Edit customer page: verify address undisplayed");
        Assert.assertTrue(adminEditCustomerPageObject.isAddressUnDisplayed());
    }
    @AfterClass(alwaysRun = true)
    public void afterClass(){
        closeBrowserDriver();
    }


    private WebDriver driver;
    private String emailAddress, password;
    private AdminLoginPageObject adminLoginPageObject;
    private AdminDashboardPageObject adminDashboardPageObject;
    private AdminCustomerPageObject adminCustomerPageObject;
    private AdminAddNewCustomerPageObject adminAddNewCustomerPageObject;
    private AdminEditCustomerPageObject adminEditCustomerPageObject;
    private AdminAddAddressPageObject adminAddAddressPageObject;
    private AdminNewCustomerData adminNewCustomerData;
    private AddressData addressData;
    private String emailAddressCustomer = adminNewCustomerData.getEmail();
    private String passwordCustomer = adminNewCustomerData.getPassword();
    private String firstName = adminNewCustomerData.getFirstName();
    private String lastName = adminNewCustomerData.getLastname();
    private String gender = adminNewCustomerData.getGender();
    private String dateOfBirth = adminNewCustomerData.getDateOfBirth();
    private String companyName = adminNewCustomerData.getCompanyName();
    private String adminComment = adminNewCustomerData.getAdminComment();
    private String country = addressData.getCountry();
    private String cityName = addressData.getCityName();
    private String address1 = addressData.getAddress1();
    private String zipCode = addressData.getZipCode();
    private String phoneNumber = addressData.getPhoneNumber();
}

