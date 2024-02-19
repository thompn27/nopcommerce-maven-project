package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePageFactory {

    public static BasePageFactory getBasePageObject() {
        return new BasePageFactory();
    }
    public void openPageUrl(WebDriver driver, String urlName){
        driver.get(urlName);
    }
    public void clickToElement(WebDriver driver, WebElement element){
        element.click();
    }
    public void sendKeyToElement(WebDriver driver, WebElement element, String textValue){
        element.clear();
        element.sendKeys(textValue);
    }
    public String getTextElement(WebDriver driver, WebElement element){

        return element.getText();
    }
    public void selectItemInDropdownByDefault(WebDriver driver, WebElement element, String textvalue){
        Select select = new Select(element);
        select.selectByValue(textvalue);
    }
    public String getSelectedItemInDropdownByDefault(WebDriver driver, WebElement element){
        Select select = new Select(element);
        return select.getFirstSelectedOption().getText();
    }

    public Boolean isDropdownMultiple(WebDriver driver, WebElement element){
        Select select = new Select(element);
        return select.isMultiple();
    }
    public Boolean isDisplayElement(WebDriver driver, WebElement element) {
        return element.isDisplayed();
    }
    public void waitForElementVisible(WebDriver driver, WebElement element){
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTime));
        explicitWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForAllElementVisible(WebDriver driver, List<WebElement> elements){
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTime));
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }
    public void waitForElementInVisible(WebDriver driver, WebElement element){
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTime));
        explicitWait.until(ExpectedConditions.invisibilityOf(element));
    }
    public void waitForAllElementInVisible(WebDriver driver, List<WebElement> elements){
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTime));
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(elements));
    }
    public void waitForElementClickable(WebDriver driver, WebElement element){
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTime));
        explicitWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private long longTime = 50;

}
