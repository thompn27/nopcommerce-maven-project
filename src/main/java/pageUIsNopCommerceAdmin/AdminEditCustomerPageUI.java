package pageUIsNopCommerceAdmin;

public class AdminEditCustomerPageUI {
    public static final String EDIT_BUTTON = "xpath=//tbody//tr//td[@class=' button-column']//a";
    public static final String CUSTOMER_INFO_IN_ADDRESS_TABLE = "xpath=//div[@id='%s']//tbody//td[text()='%s']";
    public static final String ADDRESS_IN_ADDRESS_TABLE = "xpath=//div[@id='%s']//tbody//tr//td//div[contains(text(),'%s')]";
    public static final String ADDRESS_SECTION_TITLE = "xpath=//div[@id='customer-address']//div[@class='card-title']";
    public static final String ADD_NEW_ADDRESS_BUTTON = "xpath=//div[@id='customer-address']//button[contains(text(),'Add new address')]";
    public static final String DELETE_ADDRESS_BUTTON = "xpath=//div[@id='customer-address']//tbody//tr//td//i[@class='far fa-trash-alt']";
}
