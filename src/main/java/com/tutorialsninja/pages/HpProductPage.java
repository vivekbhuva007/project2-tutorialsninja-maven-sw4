package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HpProductPage extends Utility {
    By clickOnCurrency = By.xpath("//span[contains(text(),'Currency')]");

    By allCurrencyList = By.xpath("//ul[@class = 'dropdown-menu']/li");

    By verifyHpLaptopText = By.xpath("//h1[contains(text(),'HP LP3065')]");

    By clickOndateElement = By.xpath("//div[@class = 'input-group date']//button");

    By datePickerSwitch = By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']");


    By allDate = By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']");


    By clickOnCart = By.xpath("//button[@id='button-cart']");


    By clickOnShoppingCart = By.xpath("//a[contains(text(),'shopping cart')]");
    By productSortedByNameZToA = By.id("input-sort");

    By priceHighTOLow = By.id("input-sort");

    By productSortedByNameAToZ = By.id("input-sort");

    By clickOnHpLaptop = By.xpath("//a[contains(text(),'HP LP3065')]");

    By date1 = By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='next']");

    By getAllProductAndPrice= By.xpath("//p[@class ='price']");

    By MacBookCLick = By.linkText("MacBook");

    By verifyMacbookText = By.xpath("//h1[contains(text(),'MacBook')]");

    By insertTwoQuantity = By.xpath("//input[contains(@name, 'quantity')]");

    By clickOnUpdateButton = By.xpath("//button[contains(@data-original-title, 'Update')]");



    public void setClickOnUpdateButton(){
        clickOnElement(clickOnUpdateButton);

    }


    public void setInsertTwoQuantity(String quantity){
        sendTextToElement(insertTwoQuantity,quantity);


    }


    public String verifyMacbookMessage (){
        return getTextFromElement(verifyMacbookText);
    }




    public void userClickOnMacBook(){
        clickOnElement(MacBookCLick);
    }


    public void priceHighToLow(String text2){
        selectByVisibleTextFromDropDown(getAllProductAndPrice,text2);

    }





    public void getAllProductAndPriceIntoArrayList (){
        List<WebElement> products = driver.findElements(getAllProductAndPrice);
        List<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            System.out.println(e.getText());
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",","")));
        }
        System.out.println(originalProductsPrice);
        // Sort By Reverse order
        Collections.sort(originalProductsPrice, Collections.reverseOrder());
        System.out.println(originalProductsPrice);
        // Select sort by Price (High > Low)
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Price (Low > High)");
        // After filter Price (High > Low) Get all the products name and stored into array list
        products = driver.findElements(By.xpath("//p[@class ='price']"));
        ArrayList<Double> afterSortByPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            afterSortByPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",","")));
        }
        System.out.println(afterSortByPrice);
       // Assert.assertEquals("Product not sorted by price High to Low", originalProductsPrice, afterSortByPrice);
    }










    public void userClickOnCurrency(){
        clickOnElement(clickOnCurrency);

    }

    public void userSelectCurrencyList(){
        List<WebElement> currencyList = driver.findElements(allCurrencyList);
        for (WebElement e:currencyList ) {
            if (e.getText().equalsIgnoreCase("£ Pound Sterling")){
                e.click();
                break;
            }
        }

        }
    public  String verifyLaptopText(){
        return getTextFromElement(verifyHpLaptopText);

    }

    public void datePicker(){
        String year = "2023";
        String month = "November";
        String date = "30";
        clickOnElement(clickOndateElement);
        while (true) {
            String monthAndYear = driver.findElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")).getText();
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(date1);
            }
        }
        List<WebElement> allDates = driver.findElements(allDate);
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(date)) {
                e.click();
                break;
            }
        }

    }
    public void clickOnCart(){
        clickOnElement(clickOnCart);
    }

    public void shoppingCartClick(){
        clickOnElement(clickOnShoppingCart);
    }

    public void productNameByAtoZ(String text){
        selectByVisibleTextFromDropDown(productSortedByNameAToZ,text);
    }
    public void productNameByZtoA(String text){
        selectByVisibleTextFromDropDown(productSortedByNameZToA,text);
    }

    public void clickOnLaptopHP(){
        clickOnElement(clickOnHpLaptop);



    }





}
