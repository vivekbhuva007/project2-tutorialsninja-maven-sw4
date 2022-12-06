package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;

public class LoginPage extends Utility {

    By clickOnMyAccount = By.xpath("//span[contains(text(),'My Account')]");
    By MyAccountOptions = By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li");

    By verifyReturnAccountText = By.xpath("//h2[contains(text(),'Returning Customer')]");


    public void setClickOnMyAccount(){
        clickOnElement(clickOnMyAccount);


    }
    public void verifySelectMyAccountOptions(String options){
        selectMyAccountOptions(MyAccountOptions,options);
    }

    public String verifyReturningCustomerAccountMessage(){
        return getTextFromElement(verifyReturnAccountText);
    }

}
