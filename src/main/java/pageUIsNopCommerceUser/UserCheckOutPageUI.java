package pageUIsNopCommerceUser;

public class UserCheckOutPageUI {
    public static final String COUNTRY_TEXT_BOX = "xpath=//select[@id='BillingNewAddress_CountryId']";
    public static final String CITY_TEXT_BOX = "xpath=//input[@id='BillingNewAddress_City']";
    public static final String ADDRESS1_TEXT_BOX = "xpath=//input[@id='BillingNewAddress_Address1']";
    public static final String ZIP_CODE_TEXT_BOX = "xpath=//input[@id='BillingNewAddress_ZipPostalCode']";
    public static final String PHONE_NUMBER_TEXT_BOX = "xpath=//input[@id='BillingNewAddress_PhoneNumber']";
    public static final String CONTINUE_BUTTON_BY_SECTION_NAME = "xpath=//h2[text()='%s']/parent::div/following-sibling::div//button[text()='Continue']";
    public static final String SHIPPING_METHOD_RADIO_BY_METHOD_NAME = "xpath=//div[@class='method-name']//label[contains(text(),'%s')]/preceding-sibling::input";
    public static final String PAYMENT_METHOD_RADIO_BY_METHOD_NAME = "xpath=//div[@class='section payment-method']//label[text()='%s']/preceding-sibling::input";
    public static final String PAYMENT_INFORMATION_MESSAGE = "xpath=//div[@class='section payment-info']//td//p";
    public static final String FULL_NAME_TEXT = "xpath=//div[@class='billing-info']//li[@class='name']";
    public static final String EMAIL_ADDRESS_TEXT = "xpath=//div[@class='billing-info']//li[@class='email']";
    public static final String PHONE_NUMBER_TEXT = "xpath=//div[@class='billing-info']//li[@class='phone']";
    public static final String ADDRESS1_TEXT = "xpath=//div[@class='billing-info']//li[@class='address1']";
    public static final String CITY_NAME_TEXT = "xpath=//div[@class='billing-info']//li[@class='city-state-zip']";
    public static final String COUNTRY_NAME_TEXT = "xpath=//div[@class='billing-info']//li[@class='country']";
    public static final String PAYMENT_METHOD_NAME_TEXT = "xpath=//li[@class='payment-method']//span[@class='value']";
    public static final String SHIPPING_METHOD_NAME_TEXT = "xpath=//li[@class='shipping-method']//span[@class='value']";
    public static final String PRODUCT_NAME_IN_TABLE = "xpath=//form[@id='shopping-cart-form']//a[text()='%s']";
    public static final String TOTAL_PRICE_TEXT = "xpath=//div[@class='total-info']//tr[@class='order-total']//strong";
    public static final String TOTAL_PRICE_IN_TABLE_TEXT = "xpath=//form[@id='shopping-cart-form']//a[text()='%s']/parent::td/following-sibling::td[@class='subtotal']//span";
    public static final String QTY_TEXT = "xpath=//form[@id='shopping-cart-form']//a[text()='%s']/parent::td/following-sibling::td[@class='quantity']//span";
    public static final String CONFIRM_BUTTON = "css=div#confirm-order-buttons-container button";
}
