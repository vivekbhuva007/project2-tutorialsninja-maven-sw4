package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RegisterPage extends Utility {
    By clickOnMyAccount = By.xpath("//span[contains(text(),'My Account')]");
    By MyAccountOptions = By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li");

    By verifyRegisterAccountText = By.xpath("//h1[contains(text(),'Register Account')]");


    By firstname = By.id("input-firstname");
    By lastname = By.id("input-lastname");
    By email = By.id("email");
    By telephone = By.id("input-telephone");
    By password = By.id("input-password");
    By confirm = By.id("input-confirm");


    By agreeButton = By.xpath("//div[@class = 'buttons']//input[@name='agree']");

    By continueButton = By.xpath("//div[@class = 'buttons']//input[@value='Continue']");

    By verifyTextAccountCreated = By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]");

    By myAccountText = By.xpath("//span[contains(text(),'My Account')]");


    By logoutOption = By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li");

    By verifyLogoutAccount = By.xpath("//h1[contains(text(),'Account Logout')]");

    By getContinueButton = By.xpath("//a[contains(text(),'Continue')]");

    By radioButton = By.xpath("//fieldset[3]//input");

    By actionLoginButton = By.xpath("//form[contains(@action,'login')]//input[@type='submit']");


    public void clickLoginButton(){
        clickOnElement(actionLoginButton);
    }


    public void firstnameField(String first) {
        sendTextToElement(firstname, first);
    }

    public void lastNameField(String last) {
        sendTextToElement(lastname, last);

    }

    public void setEmail(String emailField) {
        sendTextToElement(email,emailField);

    }

    public void setTelephone(String number) {
        sendTextToElement(telephone, number);

    }

    public void setPassword(String passwordField) {
        sendTextToElement(password, passwordField);

    }

    public void confirmPassword(String password) {
        sendTextToElement(confirm, password);

    }

    public void agreeButtonClick() {
        clickOnElement(agreeButton);

    }

    public void setContinueButton() {
        clickOnElement(continueButton);

    }


    public void ClickOnMyAccount() {
        clickOnElement(myAccountText);


    }




    public void verifySelectMyAccountOptions(String options) {
        selectMyAccountOptions(MyAccountOptions, options);
    }

    public String verifyRegisterAccountMessage() {
        return getTextFromElement(verifyRegisterAccountText);
    }

    public String verifyAccountCreated() {
        return getTextFromElement(verifyTextAccountCreated);
    }

    public void verifySelectMyLogOutOptions(String options) {
        selectMyAccountOptions(logoutOption, options);
    }

    public String verifyAccountLogOut() {
        return getTextFromElement(verifyLogoutAccount);
    }

    public void continueText() {
        clickOnElement(getContinueButton);

    }

    public void setRadioButton() {
        List<WebElement> radioButtons = driver.findElements(radioButton);
        for (WebElement e : radioButtons) {
            if (e.getText().equals("Yes")) {
                e.click();
                break;
            }

        }
    }

    public static String getAlphaNumericString(int n) {
        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";
        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index = (int) (AlphaNumericString.length() * Math.random());
            // add Character one by one in end of sb
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }
}




