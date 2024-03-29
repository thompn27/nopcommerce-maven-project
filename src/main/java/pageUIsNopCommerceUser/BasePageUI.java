package pageUIsNopCommerceUser;

public class BasePageUI {
    public static final String CUSTOMER_INFOR_LINK = "Xpath=//a[text()='Customer info']";
    public static final String ADDRESSES_LINK = "XPATH=//div[contains(@class,'block-account-navigation')]//a[text()='Addresses']";
    public static final String ORDERS_LINK = "xpath=//div[contains(@class,'block-account-navigation')]//a[text()='Orders']";
    public static final String DOWNLOADABLE_PRODUCTS_LINK = "xpath=//div[contains(@class,'block-account-navigation')]//a[text()='Downloadable products']";
    public static final String BACK_IN_STOCK_SUBSCRIPTION_LINK = "xpath=//div[contains(@class,'block-account-navigation')]//a[text()='Back in stock subscriptions']";
    public static final String REWARD_POINTS_LINK = "xpath=//div[contains(@class,'block-account-navigation')]//a[text()='Reward points']";
    public static final String CHANGE_PASSWORD_LINK = "xpath=//div[contains(@class,'block-account-navigation')]//a[text()='Change password']";
    public static final String MY_PRODUCT_REVIEWS_LINK = "xpath=//div[contains(@class,'block-account-navigation')]//a[text()='My product reviews']";
    public static final String DYNAMIC_PAGE_AT_MY_ACCOUNT = "xpath=//div[contains(@class,'block-account-navigation')]//a[text()='%s']";
    public static final String DYNAMIC_PAGE_BY_AREA = "xpath=//div[contains(@class,'%s')]//a[text()='%s']";
    public static final String WISH_LIST_LINK = "xpath=//a[@class='ico-wishlist']";
    public static final String LOGO_PAGE = "xpath=//div[@class='header-logo']//img";
    public static final String PRODUCT_NAME_LINK = "xpath=//h2[@class='product-title']//a[text()='%s']";
    public static final String SHOPPING_CART_LINK = "css=div.header-upper a.ico-cart";
    public static final String PAGE_BY_SUB_PAGE_NAME = "xpath=//p[contains(text(),'%s')]/parent::a/following-sibling::ul//p[text()=' %s']";
    public static final String TEXTBOX_BY_LABEL_AND_PAGENAME_NOP = "xpath=//h1[contains(text(),'%s')]/parent::div/following-sibling::section//input[@id='%s']";
    public static final String SEARCH_BUTTON_BY_PAGE_NAME_NOP = "xpath=//h1[contains(text(),'%s')]/parent::div/following-sibling::section//button[contains(@id,'search')]";
    public static final String LOADING_ICON = "xpath=//div[@id='ajaxBusy']//span";
    public static final String MENU_TITLE_BY_PARENT_PAGE_NAME = "xpath=//div[@class='os-content']//ul[@role='menu']//p[contains(text(),'%s')]//i";

    public static final String ITEM_DROPDOWN_BY_LABEL_AND_VALUE = "xpath=//label[text()='%s']/parent::div/parent::div/following-sibling::div//select";
    public static final String VALUE_TEXTBOX_BY_LABEL_NAME = "xpath=//label[text()='%s']/parent::div/parent::div/following-sibling::div//input";
    public static final String CUSTOMER_ROLE = "xpath=//input[@aria-describedby='SelectedCustomerRoleIds_taglist']";
    public static final String ROLE_LIST = "xpath=//ul[@id='SelectedCustomerRoleIds_listbox']//li";
    public static final String SEARCH_RESULT_ITEMS = "css=div[class='dataTables_info']";
    public static final String SAVE_AND_CONTINUE_EDIT_BUTTON = "xpath=//button[@name='save-continue']";
    public static final String BACK_TO_CUSTOMER_LIST = "xpath=//a[text()='back to customer list']";
    public static final String ADD_NEW_CUS_SUCCESS_MESSAGE = "xpath=//div[contains(@class,'alert-success')]";

}
