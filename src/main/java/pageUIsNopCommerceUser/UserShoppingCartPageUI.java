package pageUIsNopCommerceUser;

public class UserShoppingCartPageUI {
    public static final String PRODUCT_NAME_IN_TABLE_IN_CART_PAGE = "xpath=//td[@class='product']//a[text()='%s']";
    public static final String SHOPPING_CART_PAGE_TITLE = "xpath=//div[@class='page shopping-cart-page']//h1[text()='Shopping cart']";
    public static final String EDIT_LINK_FROM_PRODUCT_NAME = "xpath=//a[text()='%s']/following-sibling::div[@class='edit-item']//a";
    public static final String REMOVE_PRODUCT_BUTTON = "xpath=//a[text()='%s']/parent::td/following-sibling::td[@class='remove-from-cart']//button";
    public static final String REMOVE_PRODUCT_SUCCESS_MESSAGE = "xpath=//div[@class='page shopping-cart-page']//div[@class='order-summary-content']//div[contains(text(),'Your Shopping Cart is empty!')]";
    public static final String PRODUCT_IN_CART_BY_NAME = "xpath=//tr//td[@class='product']//a[text()='%s']";
    public static final String SEARCH_TEXTBOX = "css=input#small-searchterms";
    public static final String SEARCH_BUTTON = "xpath=//div[@class='header']//button[@class='button-1 search-box-button']";
    public static final String QTY_TEXTBOX = "xpath=//a[text()='%s']/parent::td/following-sibling::td[@class='quantity']//input";
    public static final String UPDATE_SHOPPING_CART_BUTTON = "css=button#updatecart";
    public static final String PRICE_AFTER_UPDATING_QTY = "xpath=//a[text()='%s']/parent::td[@class='product']/following-sibling::td[@class='subtotal']//span";
    public static final String PRICE_BEFORE_UPDATING_QTY = "xpath=//a[text()='%s']/parent::td[@class='product']/following-sibling::td[@class='unit-price']//span";

    public static final String TERM_CONDITION_CHECKBOX = "xpath=//input[@id='termsofservice']";
    public static final String CHECKOUT_BUTTON = "xpath=//button[@id='checkout']";
}
