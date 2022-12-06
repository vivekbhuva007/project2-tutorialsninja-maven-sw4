package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopPage extends Utility {

    By mouseHoverOnDesktop = By.linkText("Desktops");

     By verifyDesktopText = By.xpath("//h2[contains(text(),'Desktops')]");

     By productNameSorted = By.xpath("//h4/a");




     By allProductList = By.xpath("//p[@class ='price']");



     public void userMouseHoverOnDesktopPage(){
         mouseHoverToElementAndClick(mouseHoverOnDesktop);
     }
     public String userVerifyDesktopText(){
         return getTextFromElement(verifyDesktopText);
     }





     public void allProductList(){
         List<WebElement> products = driver.findElements(productNameSorted);
         ArrayList<String> originalProductsName = new ArrayList<>();
         for (WebElement e : products) {
             originalProductsName.add(e.getText());
         }
         System.out.println(originalProductsName);
         // Sort By Reverse order
         Collections.reverse(originalProductsName);
         System.out.println(originalProductsName);


     }
     public void userShouldGetAllZtoAProductList(){

        List<WebElement> products = driver.findElements(productNameSorted);
         ArrayList<String> afterSortByZToAProductsName = new ArrayList<>();
         for (WebElement e : products) {
             afterSortByZToAProductsName.add(e.getText());
         }
         System.out.println(afterSortByZToAProductsName);
     }











    public void selectMenu(String menu) {
        List<WebElement> topMenuList = driver.findElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = driver.findElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
        }
    }




}



