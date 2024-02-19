package pageUIsNopCommerceUser;

public class UserProductDetailPageUI {
    public static final String ADD_YOUR_REVIEW_LINK = "xpath=//div[@class='product-review-links']//a[text()='Add your review']";
    public static final String ADD_WISHLIST_SUCCESS_MESSAGE = "xpath=//div[@class='bar-notification success']//p[contains(text(),'The product has been added to your')]";
    public static final String ADD_TO_WISHLIST_BUTTON = "xpath=//div[@class='add-to-wishlist']//button";
    public static final String CLOSE_WISH_LIST_SUCCESS_MESSAGE = "xpath=//div[@class='bar-notification success']//span[@class='close']";
    public static final String PROCESSOR_DROPDOWN = "xpath=//label[text()=' Processor ']/parent::dt/following-sibling::dd[@id='product_attribute_input_1']//select";
    public static final String RAM_DROPDOWN = "xpath=//label[text()=' RAM ']/parent::dt/following-sibling::dd[@id='product_attribute_input_2']//select";
    public static final String HDD_RADIO = "xpath=//label[text()=' HDD ']/parent::dt/following-sibling::dd[@id='product_attribute_input_3']//label[text()='%s']/preceding-sibling::input";
    public static final String OS_RADIO = "xpath=//label[text()=' OS ']/parent::dt/following-sibling::dd[@id='product_attribute_input_4']//label[text()='%s']/preceding-sibling::input";
    public static final String SOFTWARE_CHECKBOX = "xpath=//label[text()=' Software ']/parent::dt/following-sibling::dd[@id='product_attribute_input_5']//label[text()='%s']/preceding-sibling::input";
    public static final String ADD_TO_CART_BUTTON = "xpath=//button[contains(@id,'add-to-cart-button')]";
    public static final String ADD_TO_CART_SUCCESS_MESSAGE = "xpath=//div[@class='bar-notification success']//a[text()='shopping cart']";
    public static final String SHOPPING_CART_LINK = "xpath=//li[@id='topcartlink']//a[@class='ico-cart']";
    public static final String SHOPPING_CART_POPUP = "xpath=//div[@class='mini-shopping-cart']";
    public static final String PRODUCT_NAME = "xpath=//div[@class='name']//a[text()='%s']";
    public static final String SELECTED_ONFO_OF_PRODUCT = "xpath=//a[text()='%s']/parent::div[@class='name']/following-sibling::div[@class='attributes']";
    public static final String SELECTED_QUANTITY_PRODUCTS = "xpath=//div[@class='mini-shopping-cart']//div[@class='quantity']//span";
    public static final String ITEMS_ADDED_TO_CART = "xpath=//div[@class='mini-shopping-cart']//div[@class='count']//a";
    public static final String PRODUCT_QUANTITIES_TEXTBOX = "xpath=//input[@id='product_enteredQuantity_1']";
    public static final String UPDATE_PRODUCT_BUTTON = "xpath=//button[@id='add-to-cart-button-1']";
    public static final String SUB_TOTAL_PRICE = "xpath=//div[@class='mini-shopping-cart']//div[@class='totals']//strong";
    public static final String PRICE_AFTER_SELECTING_INFO = "css=div.product-price span";
    public static final String CLOSE_SUCCESS_BUTTON = "xpath=//div[@class='bar-notification success']//span[@class='close']";
}
