package pageUIsNopCommerceUser;

public class UserSearchPageUI {
    public static final String SEARCH_ON_PAGE_BUTTON = "xpath=//button[@class='button-1 search-button']";
    public static final String SEARCH_RESULT_MESAAGE = "xpath=//div[@class='search-results']//div[@class='products-wrapper']//div";
    public static final String SEARCH_TEXTBOX = "xpath=//input[@class='search-text']";
    public static final String PRODUCT_NUMNER_RESULT = "xpath=//div[@class='search-results']//div[@class='item-grid']//div[@class='item-box']";
    public static final String PRODUCT_RESULT_BY_NAME = "xpath=//h2[@class='product-title']//a[text()='%s']";
    public static final String ADVANCE_CHECKBOX = "xpath=//label[text()='Advanced search']/preceding-sibling::input[@id='advs']";
    public static final String DROPDOWN_BY_LABEL_NAME = "xpath=//label[text()='%s']/following-sibling::select";
    public static final String SUB_CATEGORIES_CHECKBOX = "xpath=//label[text()='Automatically search sub categories']/preceding-sibling::input";
    public static final String ADD_TO_CART_BUTTON = "xpath=//a[text()='%s']/parent::h2/following-sibling::div[@class='add-info']//button[contains(@class,'add-to-cart-button')]";
    public static final String CLOSE_SUCCESS_MESSAGE_BUTTON = "xpath=//div[@class='bar-notification success']//span[@class='close']";
    public static final String ADD_TO_CART_SUCCESS_MESSAGE = "xpath=//div[@class='bar-notification success']//a[text()='shopping cart']";
    public static final String PRODUCT_NAME_WITH_KEYSEARCH = "xpath=//h2[@class='product-title']//a[contains(text(),'%s')]";
}
