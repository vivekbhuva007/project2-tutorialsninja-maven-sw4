package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;

public class CartPage extends Utility {

    By verifyShoppingCartText = By.xpath("//div[@id='content']//h1");

     By productNameNotMatched = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a");

     By modelNotMatched = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[3]");


     By totalNotMatched = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[6]");


    public String verifyShoppingCartText(){
        return getTextFromElement(verifyShoppingCartText);
    }
    public String productNotMatching(){
        return getTextFromElement(productNameNotMatched);
    }
    public String modelNotMatching(){
        return getTextFromElement(modelNotMatched);
    }
    public String totalNotMatching(){
        return getTextFromElement(totalNotMatched);
    }




}

