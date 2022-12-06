package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.*;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAccountTest extends BaseTest {

    ComponentsPage componentsPage = new ComponentsPage();
    DesktopPage desktopPage = new DesktopPage();
    LaptopAndNoteBookPageTest laptopAndNoteBookPageTest = new LaptopAndNoteBookPageTest();
    HpProductPage hpProductPage = new HpProductPage();
    CartPage cartPage = new CartPage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage=new LoginPage();


    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully(){
        registerPage.ClickOnMyAccount();
        registerPage.verifySelectMyAccountOptions("Register");
        String expectedMessage = "Register Account";
        Assert.assertEquals(registerPage.verifyRegisterAccountMessage(),expectedMessage,"Register page is not displayed");

    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        loginPage.setClickOnMyAccount();
        loginPage.verifySelectMyAccountOptions("Login");
        String expectedMessage = "Returning Customer";
        Assert.assertEquals(loginPage.verifyReturningCustomerAccountMessage(), expectedMessage, "Register page is not displayed");


    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        loginPage.setClickOnMyAccount();
        loginPage.verifySelectMyAccountOptions("Login");
        registerPage.setEmail("vivek7@gmail.com");
        registerPage.setPassword("test145");

        registerPage.ClickOnMyAccount();
        registerPage.clickLoginButton();

        registerPage.verifySelectMyLogOutOptions("Logout");
        String expectedMessages = "Account Logout";
        Assert.assertEquals(registerPage.verifyAccountCreated(),expectedMessages,"");



    }

    }
