package pageObjectsNopCommerceUser;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIsNopCommerceUser.UserNotebookPageUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserNoteBookPageObject extends BasePage {
    WebDriver driver;

    public UserNoteBookPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void selectSortBy(String sortOrdering) {
        waitForElementClickable(driver, UserNotebookPageUI.SORT_BY_DROPDOWN);
        selectItemInDropdownByDefault(driver, UserNotebookPageUI.SORT_BY_DROPDOWN, sortOrdering);
        sleepInSecond(3);
    }

    public boolean isOrderingCorrectByAscByName() {
        List<String> productNames = new ArrayList<>();
        waitForAllElementVisible(driver, UserNotebookPageUI.PRODUCTS_NAME);
        List<WebElement> products = getListWebElements(driver, UserNotebookPageUI.PRODUCTS_NAME);
        for(WebElement product : products){
            productNames.add(product.getText());
        }
        List<String> sortedProductName = new ArrayList<>();
        for (String productName : productNames){
            sortedProductName.add(productName);
        }
        Collections.sort(sortedProductName);
        return productNames.equals(sortedProductName);
    }

    public boolean isOrderingCorrectByDescByName() {
        List<String> productNames = new ArrayList<>();
        waitForAllElementVisible(driver, UserNotebookPageUI.PRODUCTS_NAME);
        List<WebElement> products = getListWebElements(driver, UserNotebookPageUI.PRODUCTS_NAME);
        for(WebElement product : products){
            productNames.add(product.getText());
        }
        System.out.println("From UI: ");
        for (String name : productNames){
            System.out.println(name);
        }
        List<String> sortedProductName = new ArrayList<>();
        for (String productName : productNames){
            sortedProductName.add(productName);
        }
        Collections.sort(sortedProductName);
        Collections.reverse(sortedProductName);
        System.out.println("After sort: ");
        for (String sortName: sortedProductName){
            System.out.println(sortName);
        }
        return productNames.equals(sortedProductName);
    }

    public boolean isOrderingCorrectByAscByPrice() {
        List<Float> productPrices = new ArrayList<>();
        waitForAllElementVisible(driver, UserNotebookPageUI.PRODUCTS_PRICE);
        List<WebElement> products = getListWebElements(driver, UserNotebookPageUI.PRODUCTS_PRICE);
        for(WebElement product : products){
            productPrices.add(Float.parseFloat(product.getText().substring(2).replace(",", "")));
        }
        System.out.println("From UI: ");
        for (Float price : productPrices){
            System.out.println(price);
        }
        List<Float> sortedProductPrices = new ArrayList<>();
        for (Float productPrice : productPrices){
            sortedProductPrices.add(productPrice);
        }
        Collections.sort(sortedProductPrices);
        System.out.println("After sort: ");
        for (Float sortPrice: sortedProductPrices){
            System.out.println(sortPrice);
        }
        return productPrices.equals(sortedProductPrices);
    }

    public boolean isOrderingCorrectByDescByPrice() {
        List<Float> productPrices = new ArrayList<>();
        waitForAllElementVisible(driver, UserNotebookPageUI.PRODUCTS_PRICE);
        List<WebElement> products = getListWebElements(driver, UserNotebookPageUI.PRODUCTS_PRICE);
        for(WebElement product : products){
            //$1,800.00
            productPrices.add(Float.parseFloat(product.getText().substring(2).replace(",", "")));
        }
        System.out.println("From UI: ");
        for (Float price : productPrices){
            System.out.println(price);
        }
        List<Float> sortedProductPrices = new ArrayList<>();
        for (Float productPrice : productPrices){
            sortedProductPrices.add(productPrice);
        }
        Collections.sort(sortedProductPrices);
        Collections.reverse(sortedProductPrices);
        System.out.println("After sort: ");
        for (Float sortPrice: sortedProductPrices){
            System.out.println(sortPrice);
        }
        return productPrices.equals(sortedProductPrices);
    }
}

