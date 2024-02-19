package pageUIsNopCommerceUser;

public class UserChangePasswordPageUI {
    public static final String OLD_PASSWORD_TEXTBOX = "xpath=//input[@id='OldPassword']";
    public static final String NEW_PASSWORD_TEXTBOX = "xpath=//input[@id='NewPassword']";
    public static final String CONFIRM_NEW_PASSWORD_TEXTBOX = "xpath=//input[@id='ConfirmNewPassword']";
    public static final String CHANGE_PASSWORD_BUTTON = "xpath=//button[contains(@class,'change-password-button')]";
    public static final String CHANGE_PASSWORD_SUCCESS_MESSAGE = "xpath=//div[@class='bar-notification success']//p[text()='Password was changed']";
    public static final String CLOSE_CHANGE_SUCCESS_MESSAGE = "xpath=//span[@class='close']";
    public static final String LOG_OUT_LINK = "xpath=//a[@class='ico-logout']";
}
