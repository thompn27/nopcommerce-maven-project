package pageObjectsNopCommerceUser;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIsNopCommerceUser.UserProductDetailPageUI;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class UserProductDetailPageObject extends BasePage {
    WebDriver driver;

    public UserProductDetailPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public UserProductReviewPageObject clickOnAddYourReviewLink() {
        waitForElementClickable(driver, UserProductDetailPageUI.ADD_YOUR_REVIEW_LINK);
        clickToElement(driver, UserProductDetailPageUI.ADD_YOUR_REVIEW_LINK);
        return PageGeneratorManager.getUserProductReviewPageObject(driver);
    }

    public void clickOnAddToWishListButton() {
        scrollToElement(driver, UserProductDetailPageUI.ADD_TO_WISHLIST_BUTTON);
        waitForElementClickable(driver, UserProductDetailPageUI.ADD_TO_WISHLIST_BUTTON);
        clickToElement(driver, UserProductDetailPageUI.ADD_TO_WISHLIST_BUTTON);
    }

    public boolean isAddToWishListSuccessMessageDisplay() {
        waitForElementVisible(driver, UserProductDetailPageUI.ADD_WISHLIST_SUCCESS_MESSAGE);
        return isDisplayElement(driver, UserProductDetailPageUI.ADD_WISHLIST_SUCCESS_MESSAGE);
    }


    public void closeWishListSuccessMessage() {
        waitForElementClickable(driver, UserProductDetailPageUI.CLOSE_WISH_LIST_SUCCESS_MESSAGE);
        clickToElement(driver, UserProductDetailPageUI.CLOSE_WISH_LIST_SUCCESS_MESSAGE);
    }

    public void selectProcessorForProduct(String processorName) {
        waitForElementClickable(driver, UserProductDetailPageUI.PROCESSOR_DROPDOWN, processorName);
        selectItemInDropdownByDefault(driver, UserProductDetailPageUI.PROCESSOR_DROPDOWN, processorName);
    }

    public void selectRamForProduct(String ramType) {
        waitForElementClickable(driver, UserProductDetailPageUI.RAM_DROPDOWN, ramType);
        selectItemInDropdownByDefault(driver, UserProductDetailPageUI.RAM_DROPDOWN, ramType);
    }

    public void checkToRadioHddByProductName(String hddname) {
        waitForElementClickable(driver, UserProductDetailPageUI.HDD_RADIO, hddname);
        checkToCheckboxOrRadio(driver, UserProductDetailPageUI.HDD_RADIO, hddname);
    }

    public void checkToRadioOsByProductName(String oSName) {
        waitForElementClickable(driver, UserProductDetailPageUI.OS_RADIO, oSName);
        checkToCheckboxOrRadio(driver, UserProductDetailPageUI.OS_RADIO, oSName);
    }

    public void checkToCheckboxSoftwareByProductName(String softwareName) {
        waitForElementClickable(driver, UserProductDetailPageUI.SOFTWARE_CHECKBOX, softwareName);
        checkToCheckboxOrRadio(driver, UserProductDetailPageUI.SOFTWARE_CHECKBOX, softwareName);
    }

    public void clickOnAddTocartButton() {
        scrollToElement(driver, UserProductDetailPageUI.ADD_TO_CART_BUTTON);
        waitForElementClickable(driver, UserProductDetailPageUI.ADD_TO_CART_BUTTON);
        clickToElement(driver, UserProductDetailPageUI.ADD_TO_CART_BUTTON);
    }

    public boolean isAddToCartSuccessMessageDisplayed() {
        waitForElementVisible(driver, UserProductDetailPageUI.ADD_TO_CART_SUCCESS_MESSAGE);
        return isDisplayElement(driver, UserProductDetailPageUI.ADD_TO_CART_SUCCESS_MESSAGE);
    }

    public void openShoppingCartPopup() {
        scrollToElement(driver, UserProductDetailPageUI.SHOPPING_CART_LINK);
        waitForElementVisible(driver, UserProductDetailPageUI.SHOPPING_CART_LINK);
        hoverToElement(driver, UserProductDetailPageUI.SHOPPING_CART_LINK);
    }

//    public boolean isProductinfoDisplayedByName(String productName, String processorName, String ramName, String hddName, String oSName, String softwareName, int numberProductSelected) {
//        waitForElementVisible(driver, UserProductDetailPageUI.SHOPPING_CART_POPUP);
//        String totalProductNumberBytext = getTextElement(driver, UserProductDetailPageUI.ITEMS_ADDED_TO_CART);
//        int totalProductNumber = Integer.parseInt(totalProductNumberBytext.replace(" item(s)", ""));
//        System.out.println(" Product numbers added: " + totalProductNumber);
//        boolean allStatus = false;
//        if(totalProductNumber > 0){
//            isDisplayElement(driver, UserProductDetailPageUI.PRODUCT_NAME, productName);
//            getTextElement(driver, UserProductDetailPageUI.SELECTED_ONFO_OF_PRODUCT, productName).contains(processorName);
//            getTextElement(driver, UserProductDetailPageUI.SELECTED_ONFO_OF_PRODUCT, productName).contains(ramName);
//            getTextElement(driver, UserProductDetailPageUI.SELECTED_ONFO_OF_PRODUCT, productName).contains(hddName);
//            getTextElement(driver, UserProductDetailPageUI.SELECTED_ONFO_OF_PRODUCT, productName).contains(oSName);
//            getTextElement(driver, UserProductDetailPageUI.SELECTED_ONFO_OF_PRODUCT, productName).contains(softwareName);
//            Assert.assertTrue(getTextElement(driver, UserProductDetailPageUI.SELECTED_QUANTITY_PRODUCTS).equals(numberProductSelected));
//            System.out.println("QTY: " + getTextElement(driver, UserProductDetailPageUI.SELECTED_QUANTITY_PRODUCTS));
//            return allStatus;
//        }
//        return allStatus;
//        }

    public boolean isproductNameDisplayed(String productName) {
        waitForElementVisible(driver, UserProductDetailPageUI.PRODUCT_NAME, productName);
        return isDisplayElement(driver, UserProductDetailPageUI.PRODUCT_NAME, productName);
    }

    public boolean isProcessorSelectDisplayed(String processorName, String productName) {
        waitForElementVisible(driver, UserProductDetailPageUI.SELECTED_ONFO_OF_PRODUCT, productName);
        return getTextElement(driver, UserProductDetailPageUI.SELECTED_ONFO_OF_PRODUCT, productName).contains(processorName);
    }

    public boolean isRamSelectedDisplayed(String ramName, String productName) {
        waitForElementVisible(driver, UserProductDetailPageUI.SELECTED_ONFO_OF_PRODUCT, productName);
        return getTextElement(driver, UserProductDetailPageUI.SELECTED_ONFO_OF_PRODUCT, productName).contains(ramName);
    }

    public boolean isHddSelectedDisplayed(String hddName, String productName) {
        waitForElementVisible(driver, UserProductDetailPageUI.SELECTED_ONFO_OF_PRODUCT, productName);
        return getTextElement(driver, UserProductDetailPageUI.SELECTED_ONFO_OF_PRODUCT, productName).contains(hddName);
    }

    public boolean isOsSelectedDisplayed(String oSName, String productName) {
        waitForElementVisible(driver, UserProductDetailPageUI.SELECTED_ONFO_OF_PRODUCT, productName);
        return getTextElement(driver, UserProductDetailPageUI.SELECTED_ONFO_OF_PRODUCT, productName).contains(oSName);
    }

    public boolean isSoftwareSelectedDisplayed(String softwareName, String productName) {
        waitForElementVisible(driver, UserProductDetailPageUI.SELECTED_ONFO_OF_PRODUCT, productName);
        return getTextElement(driver, UserProductDetailPageUI.SELECTED_ONFO_OF_PRODUCT, productName).contains(softwareName);

    }

    public String getProductQuantitiesSelected() {
        waitForElementVisible(driver, UserProductDetailPageUI.SELECTED_QUANTITY_PRODUCTS);
        return getTextElement(driver, UserProductDetailPageUI.SELECTED_QUANTITY_PRODUCTS);
    }

    public void inputProductQuantities(String productQuantities) {
        waitForElementVisible(driver, UserProductDetailPageUI.PRODUCT_QUANTITIES_TEXTBOX);
        sendKeyToElement(driver, UserProductDetailPageUI.PRODUCT_QUANTITIES_TEXTBOX, productQuantities);
    }

    public void clickOnUpdateButton() {
        waitForElementClickable(driver, UserProductDetailPageUI.UPDATE_PRODUCT_BUTTON);
        clickToElement(driver, UserProductDetailPageUI.UPDATE_PRODUCT_BUTTON);
    }

    public String getTotalPriceOncartMini() {
        waitForElementVisible(driver, UserProductDetailPageUI.SUB_TOTAL_PRICE);
        return getTextElement(driver, UserProductDetailPageUI.SUB_TOTAL_PRICE);
    }

    public String getPriceAfterSelectingInfo() {
        waitForElementVisible(driver, UserProductDetailPageUI.PRICE_AFTER_SELECTING_INFO);
        return getTextElement(driver, UserProductDetailPageUI.PRICE_AFTER_SELECTING_INFO);
    }

    public float FinalPrice(int quantitiesNumber) throws ParseException {
        float finalPrice;
        String priceAfterSelectingInfo = getPriceAfterSelectingInfo(); //$1,440.00
        String priceInString = priceAfterSelectingInfo.replace("0.00", "").substring(1);
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.FRANCE);
        Number parsedNPriceumber = numberFormat.parse(priceInString);
        float priceAfterSelectingInfoNumber = parsedNPriceumber.floatValue();
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return finalPrice = Float.parseFloat(decimalFormat.format(priceAfterSelectingInfoNumber * quantitiesNumber));
    }

    public float totalPriceOnMiniCart() throws ParseException {
        float totalPriceOnMiniCart;
        String totalPriceOnCartMini = getTotalPriceOncartMini(); //$2,880.00
        String totalPriceCartByString = totalPriceOnCartMini.replace("0.00", "").substring(1);
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.FRANCE);
        Number parsedNPriceumber = numberFormat.parse(totalPriceCartByString);
        return totalPriceOnMiniCart = parsedNPriceumber.floatValue();
    }

    public void closeSuccessMessage() {
        waitForElementClickable(driver, UserProductDetailPageUI.CLOSE_SUCCESS_BUTTON);
        clickToElement(driver, UserProductDetailPageUI.CLOSE_SUCCESS_BUTTON);
        sleepInSecond(1);
    }
}


