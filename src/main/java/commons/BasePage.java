package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjectsNopCommerceUser.*;
import pageUIsNopCommerceAdmin.AdminDashboardPageUI;
import pageObjectsNopCommerceAdmin.AdminLoginPageObject;
import pageUIsNopCommerceUser.BasePageUI;
import pageUIsNopCommerceUser.UserHomePageUI;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePage {
    public static BasePage getBasePageObject() {
        return new BasePage();
    }
    public void openPageUrl(WebDriver driver, String urlName){
        driver.get(urlName);
    }
    public String getTitlePage(WebDriver driver){
        return driver.getTitle();
    }

    public String getCurrentUrlPage(WebDriver driver){
        return driver.getCurrentUrl();
    }

    public String getPageSource(WebDriver driver){
        return driver.getPageSource();
    }

    public void backToPage(WebDriver driver){
        driver.navigate().back();
    }

    public void forwardToPage(WebDriver driver){
        driver.navigate().forward();
    }

    public void refreshThePage(WebDriver driver){
        driver.navigate().refresh();
    }

    private Alert waitAlertPresence(WebDriver driver){
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return explicitWait.until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert(WebDriver driver){
        waitAlertPresence(driver).accept();
    }

    public void cancelAlert(WebDriver driver){
        waitAlertPresence(driver).dismiss();
    }

    public  String getTextAlert(WebDriver driver){
        return waitAlertPresence(driver).getText();
    }

    public void sendKeyToAlert(WebDriver driver, String textValue){
        waitAlertPresence(driver).sendKeys(textValue);
    }

    public void switchToWindowByID(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindow : allWindows) {
            if (!runWindow.equals(parentID)) {
                driver.switchTo().window(runWindow);
                break;
            }
        }
    }

    public void switchToWindowByTitle(WebDriver driver, String title) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            driver.switchTo().window(runWindows);
            String currentWin = driver.getTitle();
            if (currentWin.equals(title)) {
                break;
            }
        }
    }

    public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            if (!runWindows.equals(parentID)) {
                driver.switchTo().window(runWindows);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
    }

    public By getByXpathLocator(String locator){
        return By.xpath(locator);
    }
    // id=, class=, name=, css=, xpath=,
    public By getByLocator(String locatorType){
        By by = null;
        if(locatorType.startsWith("id=") || locatorType.startsWith("Id=") || locatorType.startsWith("ID=")){
            by = By.id(locatorType.substring(3));
        }else if(locatorType.startsWith("class=") || locatorType.startsWith("Class=") || locatorType.startsWith("CLASS=")){
            by = By.className(locatorType.substring(6));
        }else if(locatorType.startsWith("name=") || locatorType.startsWith("Name=") || locatorType.startsWith("NAME=")){
            by = By.name(locatorType.substring(5));
        }else if(locatorType.startsWith("css=") || locatorType.startsWith("Css=") || locatorType.startsWith("CSS=")){
            by = By.cssSelector(locatorType.substring(4));
        }else if(locatorType.startsWith("xpath=") || locatorType.startsWith("Xpath=") || locatorType.startsWith("XPATH=")){
            by = By.xpath(locatorType.substring(6));
        }else{
            throw new RuntimeException("Not locator");
        }
        return by;
    }
    public String getDynamicXpath(String locatorType, String... dynamicValues){
        if(locatorType.startsWith("xpath=") || locatorType.startsWith("Xpath=") || locatorType.startsWith("XPATH=")){
            locatorType = String.format(locatorType, (Object[]) dynamicValues);
        }
        return locatorType;
    }
    public WebElement getWebElement(WebDriver driver, String locatorType){
        return driver.findElement(getByLocator(locatorType));
    }
    public WebElement getWebElement(WebDriver driver, String locatorType, String... dynamicValues){
        return driver.findElement(getByLocator(getDynamicXpath(locatorType,dynamicValues)));
    }

    public List<WebElement> getListWebElements(WebDriver driver, String locator){
        return driver.findElements(getByLocator(locator));
    }
    public List<WebElement> getListWebElements(WebDriver driver, String locator, String... dynamicValues){
        return driver.findElements(getByLocator(getDynamicXpath(locator,dynamicValues)));
    }

    public void clickToElement(WebDriver driver, String locator){
        getWebElement(driver, locator).click();
    }
    public void clickToElement(WebDriver driver, String locator, String... dynamicValues){
        getWebElement(driver, getDynamicXpath(locator,dynamicValues)).click();
    }

    public void sendKeyToElement(WebDriver driver, String locator, String textValue){
        WebElement element = getWebElement(driver, locator);
        element.clear();
        element.sendKeys(textValue);
    }
    public void sendKeyToElement(WebDriver driver, String locator, String textValue, String... dynamicValues){
        WebElement element = getWebElement(driver, getDynamicXpath(locator,dynamicValues));
        element.clear();
        element.sendKeys(textValue);
    }

    public String getTextElement(WebDriver driver, String locator){
        return getWebElement(driver, locator).getText();
    }
    public String getTextElement(WebDriver driver, String locator, String... dynamicValues){
        return getWebElement(driver, getDynamicXpath(locator,dynamicValues)).getText();
    }
    public void selectItemInDropdownByDefault(WebDriver driver, String locator, String textvalue){
        Select select = new Select(getWebElement(driver, locator));
        select.selectByVisibleText(textvalue);
        //select.selectByValue(textvalue);
    }
    public void selectItemInDropdownByDefault(WebDriver driver, String locator, String textvalue, String... dynamicValues){
        Select select = new Select(getWebElement(driver, getDynamicXpath(locator,dynamicValues)));
        select.selectByVisibleText(textvalue);
        //select.selectByValue(textvalue);
    }
    public String getSelectedItemInDropdownByDefault(WebDriver driver, String locator){
        Select select = new Select(getWebElement(driver, locator));
        return select.getFirstSelectedOption().getText();
    }
    public String getSelectedItemInDropdownByDefault(WebDriver driver, String locator, String... dynamicValues){
        Select select = new Select(getWebElement(driver, getDynamicXpath(locator,dynamicValues)));
        return select.getFirstSelectedOption().getText();
    }

    public Boolean isDropdownMultiple(WebDriver driver, String locator){
        Select select = new Select(getWebElement(driver, locator));
        return select.isMultiple();
    }
    public Boolean isDropdownMultiple(WebDriver driver, String locator, String... dynamicValues){
        Select select = new Select(getWebElement(driver, getDynamicXpath(locator,dynamicValues)));
        return select.isMultiple();
    }

    public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem) {
        getWebElement(driver, parentLocator).click();
        sleepInSecond(1);

        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childItemLocator)));

        for (WebElement item : allItems) {
            if (item.getText().trim().equals(expectedItem)) {
                JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
                sleepInSecond(1);

                item.click();
                sleepInSecond(1);
                break;
            }
        }
    }

    public String getAttributeValue(WebDriver driver, String locator, String attributeName){
        return getWebElement(driver, locator).getAttribute(attributeName);
    }
    public String getAttributeValue(WebDriver driver, String locator, String attributeName, String... dynamicValues){
        return getWebElement(driver, getDynamicXpath(locator,dynamicValues)).getAttribute(attributeName);
    }

    public String  getCssValue(WebDriver driver, String locator, String cssName){
        return getWebElement(driver, locator).getCssValue(cssName);
    }
    public String  getCssValue(WebDriver driver, String locator, String cssName, String... dynamicValues){
        return getWebElement(driver, getDynamicXpath(locator,dynamicValues)).getCssValue(cssName);
    }

    public String getHexaColorFromRGBA(String rgbaValue){
         return Color.fromString(rgbaValue).asHex().toUpperCase();
    }

    public int getElementSize(WebDriver driver, String locator){
        return getListWebElements(driver, locator).size();
    }
    public int getElementSize(WebDriver driver, String locator, String... dynamicValues){
        return getListWebElements(driver, getDynamicXpath(locator,dynamicValues)).size();
    }

    public void checkToCheckboxOrRadio(WebDriver driver, String locator){
        WebElement element = getWebElement(driver, locator);
        if(!element.isSelected()){
            element.click();
        }
    }
    public void checkToCheckboxOrRadio(WebDriver driver, String locator, String... dynamicValues){
        WebElement element = getWebElement(driver, getDynamicXpath(locator,dynamicValues));
        if(!element.isSelected()){
            element.click();
        }
    }

    public void unCheckToCheckbox(WebDriver driver, String locator){
        WebElement element = getWebElement(driver, locator);
        if(element.isSelected()){
            element.click();
        }
    }
    public void unCheckToCheckbox(WebDriver driver, String locator, String... dynamicValues){
        WebElement element = getWebElement(driver, getDynamicXpath(locator,dynamicValues));
        if(element.isSelected()){
            element.click();
        }
    }

    public boolean isDisplayElement(WebDriver driver, String locator){
        return getWebElement(driver, locator).isDisplayed();
    }
    public boolean isDisplayElement(WebDriver driver, String locator, String... dynamicValues){
        return getWebElement(driver, getDynamicXpath(locator,dynamicValues)).isDisplayed();
    }
    public boolean isElementUnDisplayed(WebDriver driver, String locator) {
        overrideImplicitTimeout(driver, shortTime);
        List<WebElement> elements = getListWebElements(driver, locator);
        overrideImplicitTimeout(driver, longTime);
        if(elements.size() == 0){
            return true;
        }else if(elements.size() > 0 && elements.get(0).isDisplayed()){
            return true;
        }else{
            return false;
        }
    }
    public boolean isElementUnDisplayed(WebDriver driver, String locator, String... dynamicValues) {
        overrideImplicitTimeout(driver, shortTime);
        List<WebElement> elements = getListWebElements(driver, getDynamicXpath(locator,dynamicValues));
        overrideImplicitTimeout(driver, longTime);
        if(elements.size() == 0){
            return true;
        }else if(elements.size() > 0 && elements.get(0).isDisplayed()){
            return true;
        }else{
            return false;
        }
    }
    public void overrideImplicitTimeout(WebDriver driver, long timeOut){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOut));
    }
    public boolean isEnableElement(WebDriver driver, String locator){
        return getWebElement(driver, locator).isEnabled();
    }

    public boolean isSelectedElement(WebDriver driver, String locator){
        return getWebElement(driver, locator).isSelected();
    }
    public boolean isSelectedElement(WebDriver driver, String locator, String... dynamicValues){
        return getWebElement(driver, getDynamicXpath(locator,dynamicValues)).isSelected();
    }

    public void switchToFrameandIframe(WebDriver driver, String locator){
        driver.switchTo().frame(getTextElement(driver, locator));
    }

    public void switchToDefualtContent(WebDriver driver){
        driver.switchTo().defaultContent();
    }

    public void doubleClick(WebDriver driver, String locator){
        Actions action = new Actions(driver);
        action.doubleClick(getWebElement(driver, locator)).perform();
    }

    public void hoverToElement(WebDriver driver, String locator){
        Actions action = new Actions(driver);
        action.moveToElement(getWebElement(driver, locator)).perform();
    }
    public void hoverToElement(WebDriver driver, String locator, String... dynamicValues){
        Actions action = new Actions(driver);
        action.moveToElement(getWebElement(driver, getDynamicXpath(locator,dynamicValues))).perform();
    }
    public void enterKeyboard(WebDriver driver, String locator, Keys keys){
        Actions action = new Actions(driver);
        action.sendKeys(getWebElement(driver, locator), keys).perform();
    }
    public void enterKeyboard(WebDriver driver, String locator, Keys keys, String... dynamicValues){
        Actions action = new Actions(driver);
        action.sendKeys(getWebElement(driver, getDynamicXpath(locator,dynamicValues)), keys).perform();
    }

//    public void uploadOneFile(WebDriver driver, String locator, String projectPath){
//        String file1 = "file1";
//        String file1Path = projectPath + "/uploadFiles/" + file1;
//
//        WebElement element = getWebElement(driver, locator);
//        element.sendKeys(file1Path);
//
//    }
    public void uploadOneFile(WebDriver driver, String locator, String uploadFile, String fileName){
        //uploadFile:
        String filePath = uploadFile + fileName;
        System.out.println(filePath);

        WebElement element = getWebElement(driver, locator);
        element.sendKeys(filePath);
    }

    public void uploadMultipleFile(WebDriver driver, String locator, String uploadFile, String... fileNames){
        String fullFileName = "";
        for(String file : fileNames){
            fullFileName = uploadFile + file + "\n";
        }
        fullFileName = fullFileName.trim();

        WebElement element = getWebElement(driver, locator);
        element.sendKeys(fullFileName);
    }

    public String getInnerText(WebDriver driver) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
    }

    public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
        return textActual.equals(textExpected);
    }

    public void scrollToBottomPage(WebDriver driver) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void highlightElement(WebDriver driver, String locator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement element = getWebElement(driver, locator);
        String originalStyle = getAttributeValue(driver, locator, "style");
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
        sleepInSecond(1);
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
    }

    public void clickToElementByJS(WebDriver driver, String locator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, locator));
    }
    public void clickToElementByJS(WebDriver driver, String locator, String... dynamicValues) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, getDynamicXpath(locator,dynamicValues)));
    }

    public void scrollToElement(WebDriver driver, String locator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locator));
    }
    public void scrollToElement(WebDriver driver, String locator, String... dynamicValues) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, getDynamicXpath(locator,dynamicValues)));
    }

    public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, locator));
    }

    public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTime));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    return true;
                }
            }
        };
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
            }
        };

        return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
    }

    public String getElementValidationMessage(WebDriver driver, String locator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, locator));
    }

    public boolean isImageLoaded(WebDriver driver, String locator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver, locator));
        if (status) {
            return true;
        } else {
            return false;
        }
    }

    public void waitForElementVisible(WebDriver driver, String locatorType){
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTime));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locatorType)));
    }
    public void waitForElementVisible(WebDriver driver, String locatorType, String... dynamicValues){
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTime));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType,dynamicValues))));
    }

    public void waitForAllElementVisible(WebDriver driver, String locator){
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTime));
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(getListWebElements(driver, locator)));
    }
    public void waitForElementInVisible(WebDriver driver, String  locatorType){
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTime));
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
    }
    public void waitForElementInVisible(WebDriver driver, String  locatorType, String... dynamicValues){
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTime));
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType,dynamicValues))));
    }
    public void waitForAllElementInVisible(WebDriver driver, String locator){
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTime));
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElements(driver, locator)));
    }
    public void waitForElementClickable(WebDriver driver, String locatorType){
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTime));
        explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(locatorType)));
    }
    public void waitForElementClickable(WebDriver driver, String locatorType, String... dynamicValues){
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTime));
        explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicXpath(locatorType,dynamicValues))));
    }

    public void waitForElementPresence(WebDriver driver, String locatorType){
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTime));
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(getByLocator(locatorType)));
    }
    public void waitForElementPresence(WebDriver driver, String locatorType, String... dynamicValues){
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTime));
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(getByLocator(getDynamicXpath(locatorType,dynamicValues))));
    }

    public void waitForAllElementPresence(WebDriver driver, String locatorType){
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTime));
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(locatorType)));
    }
    public Set<Cookie> getAllCookies(WebDriver driver){
        return driver.manage().getCookies();
    }
    public void addCookie(WebDriver driver, Set<Cookie> cookies){
        for(Cookie cookie : cookies){
            driver.manage().addCookie(cookie);
        }
        sleepInSecond(1);
    }
    public UserAddressesPageObject openAddressesPageObject(WebDriver driver) {
        waitForElementClickable(driver, BasePageUI.ADDRESSES_LINK);
        clickToElement(driver, BasePageUI.ADDRESSES_LINK);
        return PageGeneratorManager.getAddressesPageObject(driver);
    }

    public UserOrdersPageObject openOrdersPageObject(WebDriver driver) {
        waitForElementClickable(driver, BasePageUI.ORDERS_LINK);
        clickToElement(driver, BasePageUI.ORDERS_LINK);
        return PageGeneratorManager.getOrdersPageObject(driver);
    }

    public UserDownloadableProductsPageObject openDownloadableProductsPageObject(WebDriver driver) {
        waitForElementClickable(driver, BasePageUI.DOWNLOADABLE_PRODUCTS_LINK);
        clickToElement(driver, BasePageUI.DOWNLOADABLE_PRODUCTS_LINK);
        return PageGeneratorManager.getDownloadableProductsPageObject(driver);
    }

    public UserBackInStockSubscriptionsPageObject openBackInStockSubscriptionPageObject(WebDriver driver) {
        waitForElementClickable(driver, BasePageUI.BACK_IN_STOCK_SUBSCRIPTION_LINK);
        clickToElement(driver, BasePageUI.BACK_IN_STOCK_SUBSCRIPTION_LINK);
        return PageGeneratorManager.getBackInStockSubscriptionsPageObject(driver);
    }

    public UserRewardPointsPageObject openRewardPointsPageObject(WebDriver driver) {
        waitForElementClickable(driver, BasePageUI.REWARD_POINTS_LINK);
        clickToElement(driver, BasePageUI.REWARD_POINTS_LINK);
        return PageGeneratorManager.getRewardPointsPageObject(driver);
    }

    public UserChangePasswordPageObject openChangePasswordPageObject(WebDriver driver) {
        waitForElementClickable(driver, BasePageUI.CHANGE_PASSWORD_LINK);
        clickToElement(driver, BasePageUI.CHANGE_PASSWORD_LINK);
        return PageGeneratorManager.getChangePasswordPageObject(driver);
    }

    public UserMyProductReviewsPageObject openMyProductReviewsPageObject(WebDriver driver) {
        waitForElementClickable(driver, BasePageUI.MY_PRODUCT_REVIEWS_LINK);
        clickToElement(driver, BasePageUI.MY_PRODUCT_REVIEWS_LINK);
        return PageGeneratorManager.getMyProductReviewsPageObject(driver);
    }
    public UserCustomerInforPageObject openCustomerInforPageObject(WebDriver driver) {
        waitForElementClickable(driver, BasePageUI.CUSTOMER_INFOR_LINK);
        clickToElement(driver, BasePageUI.CUSTOMER_INFOR_LINK);
        return PageGeneratorManager.getCustomerInforPageObject(driver);
    }
    public BasePage openPagesAtMyAccountByName(WebDriver driver, String pageName){
        waitForElementClickable(driver, BasePageUI.DYNAMIC_PAGE_AT_MY_ACCOUNT, pageName);
        clickToElement(driver, BasePageUI.DYNAMIC_PAGE_AT_MY_ACCOUNT, pageName);
        switch (pageName){
            case "Customer info":
                return PageGeneratorManager.getCustomerInforPageObject(driver);
            case "Addresses":
                return PageGeneratorManager.getAddressesPageObject(driver);

            case "Orders":
                return PageGeneratorManager.getOrdersPageObject(driver);

            case "Downloadable products":
                return PageGeneratorManager.getDownloadableProductsPageObject(driver);

            case "Back in stock subscriptions":
                return PageGeneratorManager.getBackInStockSubscriptionsPageObject(driver);

            case "Reward points":
                return PageGeneratorManager.getRewardPointsPageObject(driver);

            case "Change password":
                return PageGeneratorManager.getChangePasswordPageObject(driver);

            case "My product reviews":
                return PageGeneratorManager.getMyProductReviewsPageObject(driver);
            default:
                throw new RuntimeException("Invalid page name.");
        }
    }
    public void openPagesAtMyAccountByPageName(WebDriver driver, String pageName) {
        waitForElementClickable(driver, BasePageUI.DYNAMIC_PAGE_AT_MY_ACCOUNT, pageName);
        clickToElement(driver, BasePageUI.DYNAMIC_PAGE_AT_MY_ACCOUNT, pageName);
    }
    public void openPagesByAreaAndPageName(WebDriver driver, String areaName, String pageName) {
        waitForElementClickable(driver, BasePageUI.DYNAMIC_PAGE_BY_AREA, areaName, pageName);
        clickToElement(driver, BasePageUI.DYNAMIC_PAGE_BY_AREA, areaName, pageName);
    }
    public UserWishListPageObject openWishListPage(WebDriver driver) {
        scrollToElement(driver, BasePageUI.WISH_LIST_LINK);
        waitForElementClickable(driver, BasePageUI.WISH_LIST_LINK);
        clickToElement(driver, BasePageUI.WISH_LIST_LINK);
        return PageGeneratorManager.getUserWishListPageObject(driver);
    }
    public UserShoppingCartPageObject openShoppingCartPage(WebDriver driver) {
        scrollToElement(driver, BasePageUI.SHOPPING_CART_LINK);
        waitForElementClickable(driver, BasePageUI.SHOPPING_CART_LINK);
        clickToElement(driver, BasePageUI.SHOPPING_CART_LINK);
        return PageGeneratorManager.getUserShoppingCartPageObject(driver);
    }
    public UserHomePageObject openHomePageByClickonLogo(WebDriver driver) {
        waitForElementVisible(driver, BasePageUI.LOGO_PAGE);
        clickToElement(driver, BasePageUI.LOGO_PAGE);
        return PageGeneratorManager.getHomePageObject(driver);
    }
    public UserHomePageObject clickToUserLogoutLink(WebDriver driver) {
        waitForElementClickable(driver, UserHomePageUI.USER_LOGOUT_LINK);
        clickToElement(driver, UserHomePageUI.USER_LOGOUT_LINK);
        return PageGeneratorManager.getHomePageObject(driver);
    }
    public AdminLoginPageObject clickToAdminLogOut(WebDriver driver) {
        waitForElementClickable(driver, AdminDashboardPageUI.ADMIN_LOGOUT_LINK);
        sleepInSecond(1);
        clickToElement(driver, AdminDashboardPageUI.ADMIN_LOGOUT_LINK);
        return PageGeneratorManager.getAdminLoginPageObject(driver);
    }
    public void openSubCategoryPageByName(WebDriver driver, String categoryName, String productCategoryName) {
        waitForElementClickable(driver, UserHomePageUI.CATEGORY_NAME_TAB, categoryName);
        hoverToElement(driver, UserHomePageUI.CATEGORY_NAME_TAB, categoryName);

        waitForElementClickable(driver, UserHomePageUI.PRODUCT_CATEGORY_NAME, productCategoryName);
        clickToElement(driver, UserHomePageUI.PRODUCT_CATEGORY_NAME, productCategoryName);
    }
    public UserProductDetailPageObject clickOnProductByName(WebDriver driver, String productName) {
        waitForElementVisible(driver, BasePageUI.PRODUCT_NAME_LINK, productName);
        clickToElement(driver, BasePageUI.PRODUCT_NAME_LINK, productName);
        return PageGeneratorManager.getUserProductDetailPageObject(driver);
    }
    public void openPageBySubAndParentPageNameNop(WebDriver driver, String parentPageName, String subPageName) {
        waitForElementClickable(driver, BasePageUI.MENU_TITLE_BY_PARENT_PAGE_NAME, parentPageName);
        clickToElement(driver, BasePageUI.MENU_TITLE_BY_PARENT_PAGE_NAME, parentPageName);

        waitForElementClickable(driver, BasePageUI.PAGE_BY_SUB_PAGE_NAME, parentPageName, subPageName);
        clickToElement(driver, BasePageUI.PAGE_BY_SUB_PAGE_NAME, parentPageName, subPageName);
    }
    public void inputToTextBoxByLabelAndPageNameNop(WebDriver driver, String pageName, String labelName, String inputValue) {
        waitForElementVisible(driver, BasePageUI.TEXTBOX_BY_LABEL_AND_PAGENAME_NOP, pageName, labelName);
        sendKeyToElement(driver, BasePageUI.TEXTBOX_BY_LABEL_AND_PAGENAME_NOP, inputValue, pageName, labelName);
    }
    public void clickOnSearchButtonByPageNameNop(WebDriver driver, String pageName) {
        waitForElementClickable(driver, BasePageUI.SEARCH_BUTTON_BY_PAGE_NAME_NOP, pageName);
        clickToElement(driver, BasePageUI.SEARCH_BUTTON_BY_PAGE_NAME_NOP, pageName);
    }
    public boolean isLoadingIconUndisplayedNop(WebDriver driver) {
        waitForElementInVisible(driver, BasePageUI.LOADING_ICON);
        //return isElementUnDisplayed(driver, BasePageUI.LOADING_ICON);
        return !isDisplayElement(driver, BasePageUI.LOADING_ICON);
    }
    public void selectItemByLabelAndValue(WebDriver driver, String labelName, String valueName) {
        waitForElementClickable(driver, BasePageUI.ITEM_DROPDOWN_BY_LABEL_AND_VALUE, labelName);
        selectItemInDropdownByDefault(driver, BasePageUI.ITEM_DROPDOWN_BY_LABEL_AND_VALUE, valueName, labelName);
    }
    public String getProductInforByLabelDisplayed(WebDriver driver, String attributeName, String labelName) {
        waitForElementVisible(driver, BasePageUI.VALUE_TEXTBOX_BY_LABEL_NAME, labelName);
        return getAttributeValue(driver, BasePageUI.VALUE_TEXTBOX_BY_LABEL_NAME, attributeName, labelName);
    }
    public void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private long longTime = 40;
    private long shortTime = 6;


}
