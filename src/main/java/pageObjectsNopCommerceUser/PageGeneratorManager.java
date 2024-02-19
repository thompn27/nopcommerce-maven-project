package pageObjectsNopCommerceUser;

import org.openqa.selenium.WebDriver;
import pageObjectsNopCommerceAdmin.AdminDashboardPageObject;
import pageObjectsNopCommerceAdmin.AdminLoginPageObject;
import pageObjectsNopCommerceAdmin.AdminProductDetailPageObject;
import pageObjectsNopCommerceAdmin.AdminProductPageObject;

public class PageGeneratorManager {
    public static UserHomePageObject getHomePageObject(WebDriver driver){

        return new UserHomePageObject(driver);
    }
    public static UserRegisterPageObject getRegisterPageObject(WebDriver driver){
        return new UserRegisterPageObject(driver);
    }
    public static UserLoginPageObject getLoginPageObject(WebDriver driver){
        return new UserLoginPageObject(driver);
    }
    public static UserCustomerInforPageObject getCustomerInforPageObject(WebDriver driver) {
        return new UserCustomerInforPageObject(driver);
    }
    public static UserAddressesPageObject getAddressesPageObject(WebDriver driver){
        return new UserAddressesPageObject(driver);
    }
    public static UserOrdersPageObject getOrdersPageObject(WebDriver driver) {
        return new UserOrdersPageObject(driver);
    }
    public static UserDownloadableProductsPageObject getDownloadableProductsPageObject(WebDriver driver){
        return new UserDownloadableProductsPageObject(driver);
    }
    public static UserBackInStockSubscriptionsPageObject getBackInStockSubscriptionsPageObject(WebDriver driver){
        return new UserBackInStockSubscriptionsPageObject(driver);
    }
    public static UserRewardPointsPageObject getRewardPointsPageObject(WebDriver driver){
        return new UserRewardPointsPageObject(driver);
    }
    public static UserChangePasswordPageObject getChangePasswordPageObject(WebDriver driver){
        return new UserChangePasswordPageObject(driver);
    }
    public static UserMyProductReviewsPageObject getMyProductReviewsPageObject(WebDriver driver){
        return new UserMyProductReviewsPageObject(driver);
    }

    public static AdminLoginPageObject getAdminLoginPageObject(WebDriver driver) {
        return new AdminLoginPageObject(driver);
    }

    public static AdminDashboardPageObject getAdminDashboardPageObject(WebDriver driver) {
        return new AdminDashboardPageObject(driver);
    }

    public static UserPrivacyNoticePageObject getPrivacyNoticePageObject(WebDriver driver) {
        return new UserPrivacyNoticePageObject(driver);
    }

    public static UserSearchPageObject getUserSearchPageObject(WebDriver driver) {
        return new UserSearchPageObject(driver);
    }
    public static UserDesktopPageObject getUserDesktopPageObject(WebDriver driver){
        return new UserDesktopPageObject(driver);
    }
    public static UserProductDetailPageObject getUserProductDetailPageObject(WebDriver driver){
        return new UserProductDetailPageObject(driver);
    }
    public static UserProductReviewPageObject getUserProductReviewPageObject(WebDriver driver){
        return new UserProductReviewPageObject(driver);

    }
    public static UserWishListPageObject getUserWishListPageObject(WebDriver driver){
        return new UserWishListPageObject(driver);
    }
    public static UserComparePageObject getUserComparePageObject(WebDriver driver){
        return new UserComparePageObject(driver);
    }
    public static UserNoteBookPageObject getUserNoteBookPageObject(WebDriver driver){
        return new UserNoteBookPageObject(driver);
    }
    public static UserRecentProductViewPageObject getUserRecentProductViewPageObject(WebDriver driver){
        return new UserRecentProductViewPageObject(driver);
    }
    public static UserShoppingCartPageObject getUserShoppingCartPageObject(WebDriver driver){
        return new UserShoppingCartPageObject(driver);
    }
    public static UserCheckOutPageObject getUserCheckOutPageObject(WebDriver driver){
        return new UserCheckOutPageObject(driver);
    }
    public static AdminProductDetailPageObject getAdminProductDetailPageObject(WebDriver driver){
        return new AdminProductDetailPageObject(driver);
    }
    public static AdminProductPageObject getAdminProductPageObject(WebDriver driver){
        return new AdminProductPageObject(driver);
    }
    public static UserThankYouPageObject getUserThankYouPageObject(WebDriver driver){
        return new UserThankYouPageObject(driver);
    }
}
