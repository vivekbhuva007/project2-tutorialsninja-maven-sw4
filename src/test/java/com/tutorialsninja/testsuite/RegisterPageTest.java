package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.*;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.tutorialsninja.pages.RegisterPage.getAlphaNumericString;

public class RegisterPageTest extends BaseTest {

    ComponentsPage componentsPage = new ComponentsPage();
    DesktopPage desktopPage = new DesktopPage();
    LaptopAndNoteBookPageTest laptopAndNoteBookPageTest = new LaptopAndNoteBookPageTest();
    HpProductPage hpProductPage = new HpProductPage();
    CartPage cartPage = new CartPage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();


    @Test
    public void verifyThatUserRegisterAccountSuccessfully() {
        loginPage.setClickOnMyAccount();
        registerPage.verifySelectMyAccountOptions("Register");
        registerPage.firstnameField("prime");
        registerPage.lastNameField("testing");
        registerPage.setEmail("vivek" +getAlphaNumericString(4)+ "@jayswaminarayan.com");
        registerPage.setTelephone("07845613485");
        registerPage.setPassword("test145");
        registerPage.confirmPassword("test145");
        registerPage.setRadioButton();
        registerPage.agreeButtonClick();
        registerPage.setContinueButton();
        String expectedMessage = "Your Account Has Been Created!";
        Assert.assertEquals(registerPage.verifyAccountCreated(),expectedMessage,"");
        registerPage.continueText();
       registerPage.ClickOnMyAccount();
      registerPage.verifySelectMyLogOutOptions("Logout");
      registerPage.continueText();
        String expectedMessages = "Account Logout";
        Assert.assertEquals(registerPage.verifyAccountCreated(),expectedMessages,"");




    }



    }
