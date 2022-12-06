package com.tutorialsninja.utility;

import com.tutorialsninja.browserfactory.ManagerBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class Utility extends ManagerBrowser {



    /**
     * this method will click on element
     */

    public void clickOnElement(By by) {
        //  WebElement loginLink = driver.findElement(by);
        // WebElement loginlink = driver.findElement(By.name(""));
        // loginlink.click();
        driver.findElement(by).click();
    }


    // this method will insert text
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);




    }
    //This method verify the expected text
    public void assertVerifyText(By by, String expectedtext) {
        String actualText = getTextFromElement(by);
        String expectedText = expectedtext;
        // Assert.assertEquals("Error has occurred --->  Test failed : ", expectedText, actualText);
    }
    //
    public String getTextFromElement(By by){
        WebElement actualTextMessageElement = driver.findElement(by);
        return actualTextMessageElement.getText();
    }
    // ===================================================Alert method===================

    // This method will switch to alert
    public void switchToAlert(){
        driver.switchTo().alert();


    }
    // This method will accept alert
    public void acceptAlert(){
        driver.switchTo().alert().accept();

    }
    // this method will get text from alert
    public  String getTextFromAlert() {
        return driver.switchTo().alert().getText();

    }

    // this method will dismiss alert
    public void dismissAlert(){
        driver.switchTo().alert().dismiss();

    }
    //  this method will send text to alert
    public void sendTextToAlert(String text){
        driver.switchTo().alert().sendKeys(text);

    }




    //Homework 4 methods acceptAlert,dismissAlert,  String getTextFromAlert, sendTextToAlert(String text)

//************************ Select class methods*******************

    // this method will select options by visible text
    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }
    // homework 3 method
    /**
     * This method will select the option by value
     */
    public void selectByValueFromDropdown(By by, String value) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByValue(value);
    }



    /**
     * This method will select the option by index
     */
    public void selectByIndexFromDropDown(By by, int index) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByIndex(index);
    }




    /**
     * This method will select the option by contains text
     */
    public void selectByContainsTextFromDropDown(By by, String text) {
        List<WebElement> allOptions = new Select(driver.findElement(by)).getOptions();
        for (WebElement options : allOptions) {
            if (options.getText().contains(text)) {
                options.click();
            }
        }
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>.Window handle>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>(Not now)



    /**
     * This method will close all windows
     */
    public void closeAllWindows(List<String> hList, String parentWindow) {
        for (String str : hList) {
            if (!str.equals(parentWindow)) {
                driver.switchTo().window(str).close();
            }
        }
    }

    /**
     * This method will switch to parent window
     */
    public void switchToParentWindow(String parentWindowId) {
        driver.switchTo().window(parentWindowId);
    }

    /**
     * This method will find that we switch to right window
     */
    public boolean switchToRightWindow(String windowTitle, List<String> hList) {
        for (String str : hList) {
            String title = driver.switchTo().window(str).getTitle();
            if (title.contains(windowTitle)) {
                System.out.println("Found the right window....");
                return true;
            }
        }
        return false;
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>action class>>>>>>>>>>>>>>>>>>>>>
    //mouseHoverToElement(By by), mouseHoverToElementAndClick(By by)


    public void perform(){
        Actions act = new Actions(driver);
        act.build().perform();
    }
    public void mouseHoverOnElement(By by) {
        Actions actions = new Actions(driver);
        WebElement xyz = driver.findElement(by);
        actions.moveToElement(xyz).perform();
    }
    public void mouseHoverToElementAndClick(By by){
        Actions actions = new Actions(driver);
        WebElement mouseHoveAndClick = driver.findElement(by);
        actions.moveToElement(mouseHoveAndClick).click().perform();

    }

    public void mouseHoverOnElementAndClickk(By by , By by2) {
        Actions actions = new Actions(driver);
        WebElement hover = driver.findElement(by);
        WebElement hoverAgain = driver.findElement(by2);
        actions.moveToElement(hover).moveToElement(hoverAgain).click().perform();


    }
    public void clearAndEnterQuantity(By by,String text) {
        Actions action = new Actions(driver);
        WebElement qty =driver.findElement(by);
        qty.click();
        qty.clear();
        qty.sendKeys(text);

    }
    //==============Right click and double click action, drag and drop==================================
    public void contextRightClickAction(By by){
        WebElement button =driver.findElement(by);
        Actions act = new Actions(driver);
        // act.contextClick(button).build().perform();
        act.contextClick(button).perform();

    }
    public void doubleCLick(By by){
        WebElement button =driver.findElement(by);
        Actions act = new Actions(driver);
        act.doubleClick(button).perform();

    }
    public void dragAndDrop(By by, By by2){
        WebElement drag = driver.findElement(by);
        WebElement drop = driver.findElement(by2);
        Actions actions = new Actions(driver);
        actions.dragAndDrop(drag,drop).perform();



    }


    /**
     * This method will use to wait until  VisibilityOfElementLocated
     */
    public WebElement waitUntilVisibilityOfElementLocated(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement waitForElementWithFluentWait(By by, int time, int pollingTime) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(time))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(by);
            }
        });
        return element;
    }

    public void selectMyAccountOptions(By myAccountOptions, String option) {
        List<WebElement> myAccountList = driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountList = driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        }


    }
}
