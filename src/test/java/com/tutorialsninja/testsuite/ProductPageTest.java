package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.*;
import com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductPageTest extends BaseTest {
    ComponentsPage componentsPage = new ComponentsPage();
    DesktopPage desktopPage = new DesktopPage();
    LaptopAndNoteBookPageTest laptopAndNoteBookPageTest = new LaptopAndNoteBookPageTest();
    HpProductPage hpProductPage = new HpProductPage();
    CartPage cartPage = new CartPage();


    @Test


    public void verifyProductArrangeInAlphabeticalOrder() {
        desktopPage.userMouseHoverOnDesktopPage();
        desktopPage.selectMenu("Show All Desktops");
        desktopPage.allProductList();
        hpProductPage.productNameByZtoA("Name (Z - A)");
        desktopPage.userShouldGetAllZtoAProductList();


    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() {
        hpProductPage.userClickOnCurrency();
        hpProductPage.userSelectCurrencyList();
        desktopPage.userMouseHoverOnDesktopPage();
        desktopPage.selectMenu("Show All Desktops");
        hpProductPage.productNameByAtoZ("Name (A - Z)");
        hpProductPage.clickOnLaptopHP();
        String expectedMessage = "HP LP3065";
        Assert.assertEquals(hpProductPage.verifyLaptopText(),expectedMessage,"not Displayed");
        hpProductPage.datePicker();
        hpProductPage.clickOnCart();
        Assert.assertTrue(getTextFromElement(By.cssSelector("body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible"))
                .contains("Success: You have added HP LP3065 to your shopping cart!"));
        hpProductPage.shoppingCartClick();

        Assert.assertTrue(getTextFromElement(By.xpath("//div[@id='content']//h1")).contains("Shopping Cart"));

        String expectedMessage1 = "HP LP3065";
        Assert.assertEquals(cartPage.productNotMatching(),expectedMessage,"not Displayed");

        Assert.assertTrue( getTextFromElement(By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]")).contains("2023-11-30"));

        String expectedMessage2 = "Product 21";
        Assert.assertEquals(cartPage.modelNotMatching(),expectedMessage2,"not Displayed");


        String expectedMessage3 = "£74.73";
        Assert.assertEquals(cartPage.totalNotMatching(),expectedMessage3,"not Displayed");

    }
    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        laptopAndNoteBookPageTest.userShouldMouseHoverOnLaptopAndBookPageTest();
        laptopAndNoteBookPageTest.selectMenu("Show All Laptops & Notebooks");
        hpProductPage.getAllProductAndPriceIntoArrayList();



    }
    @Test
    public void verifyThatUserPlaceOrderSuccessfully(){
        hpProductPage.userClickOnCurrency();
        hpProductPage.userSelectCurrencyList();
        laptopAndNoteBookPageTest.userShouldMouseHoverOnLaptopAndBookPageTest();
        laptopAndNoteBookPageTest.selectMenu("Show All Laptops & Notebooks");
        hpProductPage.priceHighToLow("Price (High > Low)");
        hpProductPage.userClickOnMacBook();

        String expectedMessage ="MacBook";
        Assert.assertEquals(hpProductPage.verifyMacbookMessage(),expectedMessage,"no message Displayed");

        hpProductPage.clickOnCart();

        Assert.assertTrue(getTextFromElement(By.cssSelector("body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible"))
                        .contains("Success: You have added MacBook to your shopping cart!"));

        hpProductPage.shoppingCartClick();
        Assert.assertTrue(getTextFromElement(By.xpath("//div[@id='content']//h1")).contains("Shopping Cart"));

        String expectedMessage1 = "MacBook";
        Assert.assertEquals(cartPage.productNotMatching(),expectedMessage1,"not Displayed");

        hpProductPage.setInsertTwoQuantity("2");
        hpProductPage.setClickOnUpdateButton();

        Assert.assertTrue( getTextFromElement(By.xpath("//div[@id='checkout-cart']/div[1]")).contains("Success: You have modified your shopping cart!"));


        String expectedMessage4 = "£737.45";
        Assert.assertEquals(cartPage.totalNotMatching(),expectedMessage4,"not Displayed");







    }

}
