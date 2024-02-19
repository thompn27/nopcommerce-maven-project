package pageUIsNopCommerceUser;

public class UserWishListPageUI {
    public static final String PRODUCT_NAME_IN_TABLE = "xpath=//td[@class='product']//a[text()='%s']";
    public static final String PRODUCT_CHECKBOX_IN_TABLE = "xpath=//a[text()='%s']/parent::td/preceding-sibling::td[@class='add-to-cart']//input";
    public static final String ADD_TO_CARD_BUTTON = "xpath=//button[@name='addtocartbutton']";
    public static final String REMOVE_PRODUCT_ON_WISHLIST_BY_NAME = "xpath=//a[text()='%s']/parent::td/following-sibling::td[@class='remove-from-cart']//button";
}
